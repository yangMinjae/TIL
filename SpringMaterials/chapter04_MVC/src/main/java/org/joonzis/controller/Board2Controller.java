package org.joonzis.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.joonzis.domain.Board2VO;
import org.joonzis.service.Board2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins="*")
public class Board2Controller {

    @Autowired
    private Board2Service service;

    // 게시글 전체 조회
    @GetMapping(value = "/boardList", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Board2VO> getBoardList() {
        List<Board2VO> list = service.getAllList();
        return list;
    }

    // 게시글 상세 조회
    @GetMapping(value = "/board/{idx}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Board2VO getBoard(@PathVariable int idx) {
        Board2VO vo = service.getBoard(idx);
        return vo;
    }

    // 게시글 삽입
    @PostMapping("/board")
    public String register(@RequestBody Board2VO vo) {
        String result = service.register(vo) ? "success" : "fail";
        return result;
    }
    
    // 게시글 삭제
    @DeleteMapping(value = "/board/{idx}")
    public String delete(@PathVariable int idx){
        service.remove(idx);
        return "success";
    }

    // 게시글 수정
    @PutMapping("/board")
    public String putMethodName(@RequestBody Board2VO vo) {
        service.update(vo);
        return "success";
    }
}