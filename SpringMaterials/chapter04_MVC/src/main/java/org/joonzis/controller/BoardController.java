package org.joonzis.controller;

import org.joonzis.domain.BoardVO;
import org.joonzis.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService service;

	// 게시글 전체 조회
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list...");
		model.addAttribute("list", service.getList());
	}
	
	// 게시글 등록
	@PostMapping("/register")
	public String register(BoardVO vo) {
		log.info("register..."+vo);
		boolean result = service.register(vo);
		return "redirect:/board/list";
		// redirect를 안쓰면 기본적으로 post
	}
	// 화면 이동
	@GetMapping("/register")
	public void register() {
		log.info("register...");
	}
	// 게시글 조회
	@GetMapping("/get")
	public void get(Model model, @RequestParam("bno") int bno) {
		log.info("get..."+bno);
		model.addAttribute(service.get(bno));
	}
	
	// 게시글 수정
	@PostMapping("/modify")
	public String modify(BoardVO vo) {
		log.info("modify..."+vo);
		boolean result = service.modify(vo);
		return "redirect:/board/list";
	}
	
	// 게시글 삭제
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") int bno) {
		log.info("remove..."+bno);
		boolean result = service.remove(bno);
		return "redirect:/board/list";
	}
}
