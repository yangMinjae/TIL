package org.joonzis.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board2VO {
	private int idx;
	private String writher;
	private String content;
	private String title;
	private Date regdate;
}
