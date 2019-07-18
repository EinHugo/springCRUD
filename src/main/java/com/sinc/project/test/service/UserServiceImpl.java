package com.sinc.project.test.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.project.test.model.dao.UserDAO;
import com.sinc.project.test.model.vo.UserVO;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Resource(name="userDAOImpl")
	private UserDAO dao;

	@Override
	public UserVO loginService(UserVO user) {
		return dao.loginRow(user);
	}

	@Override
	public int join(UserVO user) {
		return dao.join(user);
	}
	
	
	
}
