package com.sinc.project.test.service;

import com.sinc.project.test.model.vo.UserVO;

public interface UserService {
	public UserVO loginService(UserVO user);
	public int join(UserVO user);
}
