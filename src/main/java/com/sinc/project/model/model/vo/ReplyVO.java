package com.sinc.project.model.model.vo;

public class ReplyVO {
	private int rseq;
	private int seq;
	private String rwriter;
	private String rtext;
	private String rdate;
	
	public ReplyVO() {}
	
	public ReplyVO(int rseq, int seq, String rwriter, String rtext, String rdate) {
		super();
		this.rseq = rseq;
		this.seq = seq;
		this.rwriter = rwriter;
		this.rtext = rtext;
		this.rdate = rdate;
	}

	public int getRseq() {
		return rseq;
	}

	public void setRseq(int rseq) {
		this.rseq = rseq;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getRwriter() {
		return rwriter;
	}

	public void setRwriter(String rwriter) {
		this.rwriter = rwriter;
	}

	public String getRtext() {
		return rtext;
	}

	public void setRtext(String rtext) {
		this.rtext = rtext;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	@Override
	public String toString() {
		return "ReplyVO [rseq=" + rseq + ", seq=" + seq + ", rwriter=" + rwriter + ", rtext=" + rtext + ", rdate="
				+ rdate + "]";
	}
	
}



/*
 * CREATE TABLE SPRING_BOARD_REPLY_TBL( RSEQ NUMBER PRIMARY KEY, SEQ NUMBER,
 * RWRITER VARCHAR2(50), RTEXT VARCHAR2(50), RDATE DATE DEFAULT SYSDATE, FOREIGN
 * KEY (SEQ) REFERENCES SPRING_BOARD_TBL(SEQ) );
 */