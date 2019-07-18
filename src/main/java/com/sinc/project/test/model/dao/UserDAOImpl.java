package com.sinc.project.test.model.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.sinc.project.test.model.vo.UserVO;

@Service("userDAOImpl")
public class UserDAOImpl implements UserDAO {

	@Resource(name="sqlSession")
	SqlSession session;
	
	@Override
	public UserVO loginRow(UserVO user) {
		return session.selectOne("com.sinc.user.loginRow", user);
	}

	@Override
	public int join(UserVO user) {
		UserVO userExists = session.selectOne("com.sinc.user.selectOneUser", user);
		int result;
		if(userExists != null) {
			System.out.println("user already exists");
			result = -1;
		} else {
			result = session.insert("com.sinc.user.join", user);
		}
		return result;
	}
	
	
	
}
