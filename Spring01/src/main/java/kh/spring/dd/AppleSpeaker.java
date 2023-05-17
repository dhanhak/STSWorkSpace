package kh.spring.dd;

public class AppleSpeaker implements Speaker{

	@Override
	public void volumUp() {
		System.out.println("app : UP");
		
	}

	@Override
	public void volumDown() {
		System.out.println("app : Down");
		
	}
	
}
