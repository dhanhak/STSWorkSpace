package kh.spring.dd;

import kh.spring.inter.Tv;

public class LGTv implements Tv {

	private int price;
	private String brand;

	private Speaker speaker;

	@Override
	public void volumUp() {
		speaker.volumUp();
	}
	
	@Override
	public void volumDown() {
		speaker.volumDown();
	}
	
	public LGTv() {}

	public LGTv(int price, String brand, Speaker speaker) {
		super();
		this.price = price;
		this.brand = brand;
		this.speaker = speaker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public void powerOn() {
		System.out.println("LG");
	}

	public void powerOff() {
	}

}
