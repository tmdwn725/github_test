package com.semi.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.semi.service.MemberService;
import com.semi.domain.Member;
import com.semi.dto.MemberDTO;

@Controller
public class MainController {
	
	private final MemberService memberService;
	
	// ������ ����
	@Autowired
	public MainController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/")
	public String main(Model model) {
		List<MemberDTO> memberList = memberService.findMembers();
		model.addAttribute("memberList",memberList);
		System.out.println(memberList.size());
		return "common/main";
	}
	
	@GetMapping("/name")
	public String name(Model model) {
		List<MemberDTO> memberList = memberService.findNames();
		model.addAttribute("pa", "����");
		model.addAttribute("memberList",memberList);
		return "common/main";
	}

}