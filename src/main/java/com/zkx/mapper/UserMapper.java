package com.zkx.mapper;

import com.zkx.pojo.Gn;
import com.zkx.pojo.User;

import java.util.List;

public interface UserMapper {
	public void addUser(User user);
	public User selUserByUsercode(String usercode);
	public List<Gn> selAllGn();
	public List<String> selAllPersByUserId(int userid);
}
