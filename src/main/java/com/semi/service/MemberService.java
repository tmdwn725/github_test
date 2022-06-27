package com.semi.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semi.repository.JpaMemberRepository;
import com.semi.common.EntityConvert;
import com.semi.domain.Member;
import com.semi.dto.MemberDTO;

@Service
public class MemberService {
	/*
	 * 전체회원조회
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
		nameList = EntityConvert.convertList(findNameList);
		/*
		for(Member vo : findNameList) {
			System.out.println("id: " + vo.getId());
			//System.out.println("model: " + modellMapper.map(vo, MemberDTO.class).getId());
			nameList.add(EntityConvert.convert(vo);
			//nameList.add(modellMapper.map(vo, MemberDTO.class));		
		}
		*/
		return nameList;
	}

}
