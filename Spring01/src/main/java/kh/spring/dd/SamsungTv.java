package kh.spring.dd;

import kh.spring.inter.Tv;

public class SamsungTv implements Tv{

	private int price;
	private String brand;
	
	public void powerOn() {
		System.out.println("sumsung");
	}
	public void powerOff() {}
	
	@Override
	public void volumUp() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void volumDown() {
		// TODO Auto-generated method stub
		
	}
}
