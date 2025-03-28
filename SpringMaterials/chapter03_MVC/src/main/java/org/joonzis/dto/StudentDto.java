package org.joonzis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
// 필드 명이 바뀌어도, 겟터 셋터 생성자들을 수정하지 않아도 된다.
public class StudentDto {
	private String name, dept;
	private int gradeNo, classNo;
	
}
