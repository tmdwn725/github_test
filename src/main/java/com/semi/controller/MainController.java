package com.semi.controller;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.semi.service.MemberService;

import com.semi.dto.MemberDTO;

@Controller
public class MainController {
	
	private final MemberService memberService;
	private final Logger log = LogManager.getLogger(this.getClass());
	// ������ ����
	@Autowired
	public MainController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/")
	public String main(Model model) {
		log.info("�α׸޽���");
		List<MemberDTO> memberList = memberService.findMembers();
		model.addAttribute("memberList",memberList);
		System.out.println(memberList.size());
		return "main/main";
	}
	
	@GetMapping("/name")
	public String name(Model model) {
		List<MemberDTO> memberList = memberService.findNames();
		model.addAttribute("pa", "����");
		model.addAttribute("memberList",memberList);
		return "main/main";
	}

}