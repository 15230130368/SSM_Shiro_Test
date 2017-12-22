package com.zkx.serviceImpl;

import com.zkx.mapper.UserMapper;
import com.zkx.pojo.Gn;
import com.zkx.pojo.User;
import com.zkx.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;

	public void addUser(User user) {
		userMapper.addUser(user);
	}

	public User selUserByUsercode(String usercode) {
		return userMapper.selUserByUsercode(usercode);
	}

	public List<Gn> selAllGn() {
		return userMapper.selAllGn();
	}

	public List<String> selAllPersByUserId(int userid) {
		return userMapper.selAllPersByUserId(userid);
	}
}
