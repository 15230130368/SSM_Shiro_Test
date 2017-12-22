package com.zkx.controller;

import com.zkx.pojo.Gn;
import com.zkx.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class GnController {
	@Resource
	private UserService userService;

	@RequestMapping("/selAllGn")
	public ModelAndView selAllGn()throws Exception{
		ModelAndView mav = new ModelAndView();
		List<Gn> gns = userService.selAllGn();
		mav.getModel().put("gns",gns);
		mav.setViewName("/WEB-INF/jsp/main.jsp");
		return mav;
	}
	@RequiresPermissions("user:query")
	@RequestMapping("/user_query")
	public ModelAndView user_query()throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.getModel().put("message","用户管理");
		mav.setViewName("/WEB-INF/jsp/success.jsp");
		return mav;
	}
	@RequiresPermissions("good:query")
	@RequestMapping("/good_query")
	public ModelAndView good_query()throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.getModel().put("message","商品管理");
		mav.setViewName("/WEB-INF/jsp/success.jsp");
		return mav;
	}
}
