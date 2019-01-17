package com.a3.user.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

import com.a3.user.entity.UserEntity;

/**
 * 
 * @author Administrator
 * @date 2019/01/17
 */
public class UserRelam extends AuthorizingRealm {

    /*执行授权
     * (non-Javadoc)
     * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        UserEntity user = (UserEntity)subject.getPrincipal();
        // TODO 授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> perms = new HashSet<>();
        // TODO 查库权限
        info.setStringPermissions(perms);

        // 方案二
        /*// 从PrincipalCollection 中获取用户信息
        Object principal = principals.getPrimaryPrincipal();
        //利用登陆的用户的信息，当前用户的角色和权限
        Set<String> roles =  new HashSet<>();
        roles.add("user");
        if("admin".equals(principal))
        {
            roles.add("admin");
        }
        //创建 SimpleAuthorizationInfo 并设置roles属性
        info.setRoles(roles);*/

        return info;
    }

    /*执行认证
     * (non-Javadoc)
     * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
     */
    @SuppressWarnings("unused")
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户的信息
        UsernamePasswordToken userToken = (UsernamePasswordToken)token;
        // 用户名
        String username = userToken.getUsername();
        char[] passwordChar = userToken.getPassword();
        String passWord = String.valueOf(passwordChar);
        // TODO 查询数据库 返回信息
        UserEntity userEntity = null;
        if (userEntity == null) {
            throw new AuthenticationException("用户信息错误");
        }
        // 传入:用户名,加密后的密码,盐值,该realm的名字，加密算法和加密次数在已经在配置文件中指定
        SimpleAuthenticationInfo info =
            new SimpleAuthenticationInfo(username, passWord, ByteSource.Util.bytes(username), getName());

        return info;
    }

}
