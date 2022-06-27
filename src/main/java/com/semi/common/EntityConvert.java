package com.semi.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.semi.dto.MemberDTO;

public class EntityConvert {
	
	static ObjectMapper objectMapper = new ObjectMapper();
	
	public static<F,T> Object convert(F from){
		//ModelMapperconvert
        if(from == null) return null;
        return objectMapper.convertValue(from, opponentClass(from.getClass()));
	}
	
	// List�� ��ȯ���ش�.
    public static<F,T> List<T> convertList(List<F> froms){
    	List<T> ts = new ArrayList<>();
        if(froms.size() == 0) return ts;
        for (F from : froms) {
           ts.add((T) objectMapper.convertValue(from, opponentClass(from.getClass())));
        }
        return ts;
    }
	
	public static<T> Class opponentClass(Class<T> from) {
		Class objectClass = null;
		String className = from.getName();
        // ��θ� ������ Ŭ���� �̸��� ���´�.
        className = className.substring(className.lastIndexOf(".")+1).toLowerCase();
        
        // Ŭ������ ��ü �̸�(��θ� ����)
        // com.semi.dto.MemberDTO
        // com.semi.entity.Member
        // ���丮 �̸��� Ŭ���� �̸��� �����ؼ� ClassLoader�� ���� ��ȯ�� Ŭ������ ã�Ƴ���.
        try {
            if(className.contains("dto")) {
                objectClass = from.getClassLoader().loadClass(from.getName().replace(".dto", ".domain").replace("DTO",""));
            }else {
            	objectClass = from.getClassLoader().loadClass(from.getName().replace(".domain", ".dto") + "DTO");
            	
            }
            	
        } catch (ClassNotFoundException e) {
            return null;
        }
        return objectClass;
	}
		
}
