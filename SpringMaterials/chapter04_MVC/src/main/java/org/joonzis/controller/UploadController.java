package org.joonzis.controller;

import java.io.File;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.joonzis.domain.BoardAttachVO;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class UploadController {
	@GetMapping("uploadForm")
	public String uploadForm() {
		log.info("upload form");
		return "uploadForm";
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		for (MultipartFile multipartFile : uploadFile) {
			log.info("--------------------------------");
			log.info("Upload File Name : "+multipartFile.getOriginalFilename());
			log.info("Upload File size : "+multipartFile.getSize());
		}
	}
	
	@GetMapping("/uploadAsync")
	public String uploadAsync() {
		log.info("uploadAsync");
		return "uploadAsync";
	}
	
	@PostMapping(value = "uploadAsyncAction",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE
			)
	public ResponseEntity<List<BoardAttachVO>> uploadAsyncPost(MultipartFile[] uploadFile) {
		log.info("upload async post...");
		
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
		return new ResponseEntity<List<BoardAttachVO>>(list,HttpStatus.OK);
	}
	
	@GetMapping(value = "/download",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	// 파일 다운로드 메소드
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(String fileName){
		log.info("download file..."+fileName);
		Resource resource = new FileSystemResource("C:\\upload\\"+fileName);
		log.info("resource..."+resource);
		String resourceName = resource.getFilename();
		HttpHeaders headers = new HttpHeaders();
		
		try {
			headers.add("Content-Disposition", "attach; fileName="+ 
		new String(resourceName.getBytes("utf-8"),"ISO-8859-1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	
	// 파일 삭제
	@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile(@RequestBody String fileName){
		log.info("deleteFile : "+fileName);
		File file;
		try {
			file = new File("C:\\upload\\"+URLDecoder.decode(fileName,"utf-8"));
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	// 오늘 날짜의 경로를 문자열로 생성
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}
}
