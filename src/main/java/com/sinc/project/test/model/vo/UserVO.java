package com.sinc.project.test.model.vo;

public class UserVO {
	private String id, pwd, name;
	private int	   point;
	private String imgsrc;
	
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", point=" + point + ", imgsrc=" + imgsrc + "]";
	}

	public UserVO() {}

	public UserVO(String id, String pwd, String name, int point, String imgsrc) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.point = point;
		this.imgsrc = imgsrc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public String getImgsrc() {
		return imgsrc;
	}


	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	
}

/*
 * CREATE TABLE SPRING_MEM_TBL ( id VARCHAR2(50) PRIMARY KEY, pwd VARCHAR2(50)
 * NOT NULL, name VARCHAR2(50) NOT NULL, point NUMBER DEFAULT 1000, imgsrc
 * VARCHAR2(50) DEFAULT 'images.png' );
 * 
 * INSERT INTO SPRING_MEM_TBL VALUES( 'id1', 'pwd1', 'heejae1', 1000, DEFAULT );
 * 
 * INSERT INTO SPRING_MEM_TBL VALUES( 'id2', 'pwd2', 'heejae2', 1000, DEFAULT );
 */