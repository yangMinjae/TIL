package org.joonzis.service;

public class LanguageServiceImpl implements LanguageService{
	@Override
	public String executeHanguel() {
		return "안녕";
	}
	@Override
	public String executeEnglish() {
		return "hello";
	}
}
