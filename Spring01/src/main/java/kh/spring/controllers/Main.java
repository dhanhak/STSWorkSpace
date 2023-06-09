package kh.spring.controllers;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kh.spring.dd.Speaker;
import kh.spring.inter.Tv;

public class Main {
	public static void main(String[] args) {
		
		// Spring -> Spring Container , Bean -> IOC : Inversion Of Control ( 제어의 역전 )
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("context.xml");
		
//		Tv tv = ctx.getBean("tv", Tv.class);	//DL : Dependecy Lookup , DI : Dependecy Injection
		
		Tv tv = (Tv) ctx.getBean("lg");
		tv.volumDown();
	}
}
