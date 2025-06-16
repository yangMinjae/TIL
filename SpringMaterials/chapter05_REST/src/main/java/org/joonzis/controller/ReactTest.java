package org.joonzis.controller;

import java.util.ArrayList;
import java.util.List;

import org.joonzis.domain.ProductVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@CrossOrigin(origins="*")
public class ReactTest {
	private final ProductVO[] data = {
	        new ProductVO(1, "삼색나물 단호박솥밥", "담백하고 고소한 별미 도시락", 39200, "3namul.jpg", "3namul-info.jpg"),
	        new ProductVO(2, "다섯가지 야채 새우 볶음밥", "새우, 닭가슴살, 야채 듬뿍", 35400, "5vege.jpg", "5vege-info.jpg"),
	        new ProductVO(3, "코코넛 닭가슴살 커리", "코코넛 커리로 특별하게", 39200, "coconut.jpg", "coconut-info.jpg"),
	        new ProductVO(4, "통단호박 크랜베리 콕콕 샐러드", "단호박 고유의 맛을 그대로", 22200, "cranberry.jpg", "cranberry-info.jpg"),
	        new ProductVO(5, "갈비맛 빅볼 닭가슴살", "균형잡힌 구성으로 제대로 된 한끼!", 35400, "galbi.jpg", "galbi-info.jpg"),
	        new ProductVO(6, "갈릭 케이준 치킨 샐러드", "with 홀그레인 머스타드 드레싱", 32400, "garlic.jpg", "garlic-info.jpg"),
	        new ProductVO(7, "갈릭 케이준 치킨 샐러드", "with 홀그레인 머스타드 드레싱", 32400, "garlic.jpg", "garlic-info.jpg"),
	        new ProductVO(8, "갈릭 케이준 치킨 샐러드", "with 홀그레인 머스타드 드레싱", 32400, "garlic.jpg", "garlic-info.jpg"),
	        new ProductVO(9, "갈릭 케이준 치킨 샐러드", "with 홀그레인 머스타드 드레싱", 32400, "garlic.jpg", "garlic-info.jpg"),
	        new ProductVO(10, "갈릭 케이준 치킨 샐러드", "with 홀그레인 머스타드 드레싱", 32400, "garlic.jpg", "garlic-info.jpg"),
	        new ProductVO(11, "갈릭 케이준 치킨 샐러드", "with 홀그레인 머스타드 드레싱", 32400, "garlic.jpg", "garlic-info.jpg"),
	        new ProductVO(12, "갈릭 케이준 치킨 샐러드", "with 홀그레인 머스타드 드레싱", 32400, "garlic.jpg", "garlic-info.jpg"),
	        new ProductVO(13, "갈릭 케이준 치킨 샐러드", "with 홀그레인 머스타드 드레싱", 32400, "garlic.jpg", "garlic-info.jpg"),
	        new ProductVO(14, "갈릭 케이준 치킨 샐러드", "with 홀그레인 머스타드 드레싱", 32400, "garlic.jpg", "garlic-info.jpg"),
	        new ProductVO(15, "갈릭 케이준 치킨 샐러드", "with 홀그레인 머스타드 드레싱", 32400, "garlic.jpg", "garlic-info.jpg")
	    };

	@GetMapping(value="/api/products", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ProductVO[] getProducts() {
//		try {
//			Thread.sleep(5000);			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		return data;
	}
	    
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
