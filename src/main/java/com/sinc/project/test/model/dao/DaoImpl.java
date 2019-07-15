package com.sinc.project.test.model.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.project.test.model.vo.TestVO;

@Repository("dao")
public class DaoImpl {
	
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public void sampleRow() {
		System.out.println("dao sampleRow");
		TestVO vo = new TestVO("sinc", "sinc", "신세계");
//		int flag = session.insert("com.sinc.test.insert", vo);
//		System.out.println(flag);
	}
}
