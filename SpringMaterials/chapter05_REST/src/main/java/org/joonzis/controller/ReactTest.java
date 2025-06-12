package org.joonzis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
public class ReactTest {
	@GetMapping("/getTextReact")
	public String getText() {
		return "안녕하세요";
	}
	
	@GetMapping(value = "/getListReact", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<String> getList(){
		List<String> arr = new ArrayList<String>();
		arr.add("api 요청");
		arr.add("성공");
		return arr;
	}
}
