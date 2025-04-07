package org.joonzis.controller;

import org.joonzis.domain.BoardVO;
import org.joonzis.domain.Criteria;
import org.joonzis.domain.PageDTO;
import org.joonzis.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService service;

	// 게시글 전체 조회
	@GetMapping("/list")
	public void list(Model model, Criteria cri, @ModelAttribute("cri2") Criteria cri2) {
		log.info("list...");
		if(cri.getPageNum()==0) {
			if(cri2!=null&&cri2.getPageNum()!=0) {
				cri.setPageNum(cri2.getPageNum());
			}else {
				cri.setPageNum(1);
			}
		}
		if(cri.getAmount()==0) {
			if(cri2!=null&&cri2.getAmount()!=0) {
				cri.setAmount(cri2.getAmount());
			}else {
				cri.setAmount(10);
			}
		}
		int total = service.getTotal();
		PageDTO dto = new PageDTO(cri,total);
		model.addAttribute("pageMaker",dto);
		model.addAttribute("list", service.getListByPage(cri));
	}
	
	// 게시글 등록
	@PostMapping("/register")
	public String register(BoardVO vo) {
		log.info("register..."+vo);
		if(vo.getAttachList()!=null) {
			vo.getAttachList().forEach(
					attach->log.info(attach)
					);
		}
		boolean result = service.register(vo);
		return "redirect:/board/list";
		// redirect를 안쓰면 기본적으로 post
	}
	// 화면 이동
	@GetMapping("/register")
	public void register() {
		log.info("register...");
	}
	// 게시글 조회 및 수정화면 이동
	@GetMapping({"/get","/modify"})
	public void get(Model model, @RequestParam("bno") int bno, Criteria cri) {
		log.info("get/modify..."+bno);
		model.addAttribute("vo",service.get(bno));
		model.addAttribute("cri",cri);
	}
	
	// 게시글 수정
	@PostMapping("/modify")
	public String modify(BoardVO vo, Criteria cri, RedirectAttributes rttr) {
		log.info("modify..."+vo);
		boolean result = service.modify(vo);
		rttr.addFlashAttribute("cri2", cri);
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
