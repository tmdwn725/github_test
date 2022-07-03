package com.semi.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semi.repository.JpaMemberRepository;
import com.semi.common.EntityConvert;
import com.semi.domain.Member;
import com.semi.dto.MemberDTO;

@Service
public class MemberService {
	
	private final Logger log = LogManager.getLogger(this.getClass());
	/*
	 * ��üȸ����ȸ
	 */
	@Autowired
	private final JpaMemberRepository memberRepository;
	
	@Autowired
	private ModelMapper modellMapper;
	
	public MemberService(JpaMemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public List<MemberDTO> findMembers(){
		return EntityConvert.convertList(memberRepository.findAll());
	}
	
	public List<MemberDTO> findNames(){
		List<Member> findNameList = memberRepository.findNames();
		List<MemberDTO> nameList = new ArrayList<MemberDTO>();
		log.info("��");
		nameList = EntityConvert.convertList(findNameList);
		log.info("��");
		/*
		for(Member vo : findNameList) {
			System.out.println("id: " + vo.getId());
			//System.out.println("model: " + modellMapper.map(vo, MemberDTO.class).getId());
			nameList.add(EntityConvert.convert(vo);
			//nameList.add(modellMapper.map(vo, MemberDTO.class));		
		}*/
		
		return nameList;
	}

}
