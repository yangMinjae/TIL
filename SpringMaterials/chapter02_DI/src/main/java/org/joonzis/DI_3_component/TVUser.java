package org.joonzis.DI_3_component;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationContext3.xml");
		TV tv = (TV)ctx.getBean("tv");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
	}
}
