package kh.spring.dto;

import java.sql.Timestamp;

public class MemberDTO {
	private int seq;
	private String id;
	private String name;
	private Timestamp regdate;

	public MemberDTO() {
		super();
	}

	public MemberDTO(int seq, String id, String name, Timestamp regdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.regdate = regdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

}
