package com.zkx.realm;

import com.zkx.pojo.User;
import com.zkx.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;

public class CustomRealm extends AuthorizingRealm {
	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}

	@Resource
	private UserService userService;

	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		User user = (User) principal.getPrimaryPrincipal();
		List<String> pers = userService.selAllPersByUserId(user.getId());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(pers);
		return info;
	}

	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String percode = token.getPrincipal().toString();
		System.out.println("percode:::"+percode);
		User  user = userService.selUserByUsercode(percode);
		if (user == null){
			return null;
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName());

		return info;
	}
}
