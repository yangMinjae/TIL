package org.joonzis.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/sample/*")
public class SampleController {
	@GetMapping("/all")
	public void doAll() {
		log.info("doAll...");
	}
	@GetMapping("/member")
	public void doMember() {
		log.info("doMember...");
	}
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("admin only");
	}
	@GetMapping("/index")
	public String index(){
		log.info("index");
		return "security_test";
	}
	// 어노테이션을 이용한 시큐리티
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	@GetMapping("/annoMember")
	public void doMember2() {
		log.info("로그인 멤버 어노테이션");
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/annoAdmin")
	public void doAdmin2() {
		log.info("로그인 어드민 어노테이션");
	}
}
