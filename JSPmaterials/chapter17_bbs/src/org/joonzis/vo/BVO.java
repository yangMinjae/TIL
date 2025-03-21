package org.joonzis.vo;

import java.sql.Date;

public class BVO {
	private String title, content, pw, ip, filename;
	private int hit;
	private Date reg_date;
	public BVO() {}
	public BVO(String title, String content, String pw, int hit, String ip, String filename,  Date reg_date) {
		super();
		this.title = title;
		this.content = content;
		this.pw = pw;
		this.ip = ip;
		this.filename = filename;
		this.hit = hit;
		this.reg_date = reg_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	
}
