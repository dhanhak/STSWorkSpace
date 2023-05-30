package kh.spring.dto;

public class ChatDTO {
	private String sender;
	private String message;
	private long write_date;

	public ChatDTO() {
		super();
	}

	public ChatDTO(String sender, String message, long write_date) {
		super();
		this.sender = sender;
		this.message = message;
		this.write_date = write_date;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getWrite_date() {
		return write_date;
	}

	public void setWrite_date(long write_date) {
		this.write_date = write_date;
	}

}
