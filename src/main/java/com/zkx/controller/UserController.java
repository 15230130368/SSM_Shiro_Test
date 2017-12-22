package com.zkx.controller;

import com.zkx.pojo.User;
import com.zkx.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@Controller
public class UserController {
	@Resource
	private UserService userService;
@RequestMapping("/reg")
	public ModelAndView reg(User user)throws Exception{
		ModelAndView mav = new ModelAndView();

		System.out.println("oldUser:::"+user);

		StringBuffer sb = new StringBuffer();
		for (int i = 0;i<6;i++){

			char c = (char)(int)( Math.random()*26+97);
			sb.append(c);
		}
		String salt = sb.toString();

		SimpleHash sh = new SimpleHash("MD5",user.getPassword(),salt,3);
		String password = sh.toString();

		user.setPassword(password);
		user.setSalt(salt);
		userService.addUser(user);
		System.out.println("newUser:::"+user);
		mav.getModel().put("message",user);
		mav.setViewName("/WEB-INF/jsp/success.jsp");
		return mav;
	}
	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.getRequestDispatcher("/login.jsp").forward(request,response);
	}
}
