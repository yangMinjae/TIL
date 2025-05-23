package org.joonzis.domain;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberVO {
	private String userId, userPw, userName;
	private Date regDate, updateDate;
	private boolean enabled;
	
	private List<AuthVO> authList;
}
