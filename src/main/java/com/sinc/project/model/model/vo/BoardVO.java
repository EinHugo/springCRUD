package com.sinc.project.model.model.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BoardVO {
	private int 	seq;
	private String  title, content, writer, regdate;
	private int		viewcnt;
	private int 	rcount;
	private boolean newFlag;
	
	public int getRcount() {
		return rcount;
	}

	public BoardVO(int seq, String title, String content, String writer, String regdate, int viewcnt, int rcount,
			List<ReplyVO> rlist) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
		this.rcount = rcount;
		this.rlist = rlist;
		this.newFlag = false;
		
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}

	private List<ReplyVO> rlist;
	
	public BoardVO() {}

	public List<ReplyVO> getRlist() {
		return rlist;
	}

	public void setRlist(List<ReplyVO> rlist) {
		this.rlist = rlist;
	}

	public BoardVO(int seq) {
		this.seq = seq;
	}

	public int getSeq() {
		return seq;
	}

	

	public void setSeq(int seq) {
		this.seq = seq;
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


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getRegdate() {
		return regdate;
	}


	public void setRegdate(String regdate) {
		this.regdate = regdate;
		try {
			Date regdateFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(regdate);
			long diff = Math.abs((new Date().getTime() - regdateFormat.getTime()) / 60000);
			
			if(diff < 30) {
				this.newFlag = true;
			} else {
				this.newFlag = false;
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public int getViewcnt() {
		return viewcnt;
	}


	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}


	public BoardVO(int seq, String title, String content, String writer, String regdate, int viewcnt) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
		this.newFlag = false;
		
	}

	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", regdate=" + regdate + ", viewcnt=" + viewcnt + ", newFlag=" + newFlag + "]";
	}

	public boolean isNewFlag() {
		return newFlag;
	}

	public void setNewFlag(boolean newFlag) {
		this.newFlag = newFlag;
	}


	
}


/*
 * CREATE TABLE SPRING_BOARD_TBL ( SEQ NUMBER PRIMARY KEY, TITLE VARCHAR2(50)
 * NOT NULL, CONTENT VARCHAR2(4000), WRITER VARCHAR2(50) REFERENCES
 * SPRING_MEM_TBL(ID), REGDATE DATE DEFAULT SYSDATE, VIEWCNT INT DEFAULT 0 );
 * CREATE SEQUENCE BOARD_SEQ ; INSERT INTO SPRING_BOARD_TBL VALUES (
 * BOARD_SEQ.NEXTVAL, 'TITLE1', 'CONTENT1', 'id1', DEFAULT, DEFAULT ); INSERT
 * INTO SPRING_BOARD_TBL VALUES ( BOARD_SEQ.NEXTVAL, 'TITLE2', 'CONTENT2',
 * 'id1', DEFAULT, DEFAULT );
 */