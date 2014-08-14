package org.mu.opencomm.common.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class OCRealm extends AuthorizingRealm {

//	@Autowired
//	//private UserService userService;
//
//	@Autowired
//	private PermissionService permissionService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
//		User user = WebUtil.getCurrentUser();
//		if (user != null) {
//			List<Permission> permissions = permissionService
//					.selectByRoleId(user.getRole().getId());
//			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//			for (Permission p : permissions) {
//				info.addStringPermission(p.getContent());
//			}
//			return info;
//		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
//		UsernamePasswordToken usernamePasswordToke = (UsernamePasswordToken) token;
//		String username = usernamePasswordToke.getUsername();
//		/*String password = new Md5Hash(usernamePasswordToke.getPassword())
//				.toHex();*/
//		String passwordT = "";
//		char[] s = usernamePasswordToke.getPassword();
//		for (int i = 0; i < s.length; i++) {
//			passwordT += s[i]; 
//		}
//		String password = MD5.Md5(passwordT);
//		//System.out.println("passwordT = "+passwordT);
//		//System.out.println("password = "+password);
//		User loginUser = userService.Login(new User(username, password));
//		if (loginUser != null) {
//			WebUtil.setCurrentUser(loginUser);
//
//			return new SimpleAuthenticationInfo(
//					usernamePasswordToke.getPrincipal(),
//					usernamePasswordToke.getPassword(), username);
//		} else
			return null;
	}
}
