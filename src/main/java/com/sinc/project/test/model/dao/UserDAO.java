package com.sinc.project.test.model.dao;

import com.sinc.project.test.model.vo.UserVO;

public interface UserDAO {

	UserVO loginRow(UserVO user);
	int join(UserVO user);
}
