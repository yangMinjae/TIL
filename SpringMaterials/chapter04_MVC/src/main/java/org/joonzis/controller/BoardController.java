package org.joonzis.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.joonzis.domain.BoardAttachVO;
import org.joonzis.domain.BoardVO;
import org.joonzis.domain.Criteria;
import org.joonzis.domain.PageDTO;
import org.joonzis.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
	public String register(BoardVO vo, @RequestParam("uploadFile")MultipartFile[] uploadFile) {
		log.info("register..."+vo);
		if(vo.getAttachList()!=null) {
			vo.getAttachList().forEach(
					attach->log.info(attach)
					);
		}
		if(!uploadFile[0].isEmpty()) {
			List<BoardAttachVO> list = handleMultipart(uploadFile);
			vo.setAttachList(list);			
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
		model.addAttribute("attachList",service.getAttachList(bno));
	}
	
	// 게시글 수정
	@PostMapping("/modify")
	public String modify(BoardVO vo, Criteria cri, MultipartFile[] uploadFile , @RequestParam("changed")boolean changed, RedirectAttributes rttr) {
		log.info("modify..."+vo);	
		if(!uploadFile[0].isEmpty()) {
			List<BoardAttachVO> list=handleMultipart(uploadFile);
			vo.setAttachList(list);
		}
		boolean result = service.modify(vo,changed);
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
	
	@ResponseBody
	@GetMapping(value = "/getAttachList/{bno}",
		produces = MediaType.APPLICATION_JSON_UTF8_VALUE
			)
	public ResponseEntity<List<BoardAttachVO>> getAttachList(@PathVariable("bno") int bno){
		log.info("getAttachList..."+bno);
		return new ResponseEntity<List<BoardAttachVO>>(service.getAttachList(bno),HttpStatus.OK);
	}
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}
	
	private List<BoardAttachVO> handleMultipart(MultipartFile[] uploadFile){
		List<BoardAttachVO> list = new ArrayList<BoardAttachVO>();
		String uploadFolder ="C:\\upload";
		// 폴더 만들어주기
		File uploadPath = new File(uploadFolder,getFolder());
		log.info("uploadPath : "+uploadPath);
		
		if(!uploadPath.exists()) {
			uploadPath.mkdirs();
		}
		for(MultipartFile multipartFile:uploadFile) {
			// 파일 정보를 담을 AttachFileDTO 객체 생성
			if(multipartFile==null) {
				continue;
			}
			BoardAttachVO boardAttachVo = new BoardAttachVO();
			log.info("--------------------------------");
			log.info("Upload File Name : "+multipartFile.getOriginalFilename());
			log.info("Upload File size : "+multipartFile.getSize());
			
			String uploadFileName = multipartFile.getOriginalFilename();
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			
			log.info("only file name : "+uploadFileName);
			
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			try {
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);
				
				boardAttachVo.setUuid(uuid.toString());
				boardAttachVo.setFileName(multipartFile.getOriginalFilename());
				boardAttachVo.setUploadPath(getFolder());
				list.add(boardAttachVo);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		return list;
	}
}
