package com.a3.user.shiro;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * shrio 配置类
 * 
 * @author Donald 2019-01-17 21:29
 *
 */
@Configuration
public class ShiroConfig {

    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        // 配置shiro n内置过滤器
        Map<String, String> filterMap = new HashMap<>(12);
        /*
         * anon:表示可以匿名使用。 
            authc:表示需要认证(登录)才能使用，没有参数 
            roles：参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，当有多个参数时，例如admins/user/**=roles["admin,guest"],每个参数通过才算通过，相当于hasAllRoles()方法。 
            perms：参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，例如/admins/user/**=perms["user:add:*,user:modify:*"]，当有多个参数时必须每个参数都通过才通过，想当于isPermitedAll()方法。 
            rest：根据请求的方法，相当于/admins/user/**=perms[user:method] ,其中method为post，get，delete等。 
            port：当请求的url的端口不是8081是跳转到schemal://serverName:8081?queryString,其中schmal是协议http或https等，serverName是你访问的host,8081是url配置里port的端口，queryString是你访问的url里的？后面的参数。 
            authcBasic：没有参数表示httpBasic认证 
            ssl:表示安全的url请求，协议为https 
            user:当登入操作时不做检查
         */
        // 设置login url
        factoryBean.setLoginUrl("/login");
        // 设置成功后的跳转的连接
        factoryBean.setSuccessUrl("/index");
        filterMap.put("/web/**", "anon");
        // 静态资源处理
        filterMap.put("/js/**", "anon");
        filterMap.put("/css/**", "anon");
        filterMap.put("/images/**", "anon");
        filterMap.put("/font/**", "anon");
        // 当请求/shiro/logout时登
        filterMap.put("/logout", "logout");
        filterMap.put("/login", "anon");

        /*
         *  注意:这里的user是过滤器的一种,而下面roles[user]中的user是自定义的一种角色。
         *  注意:user拦截器既允许通过Subject.login()认证进入的用户访问;又允许通过rememberMe缓存进入的用户访问
         *  注意:authc拦截器既只允许通过Subject.login()认证进入的用户访问;不允许rememberMe缓存通过进入的用户访问
         */
        filterMap.put("/introduce.html", "user");
        filterMap.put("/rememberMe.html", "user");
        // 注意roles[user]这里的话,角色不要再用引号引起来了,直接写即可
        filterMap.put("/user.html", "authc,roles[user]");
        filterMap.put("/admin.html", "authc,roles[admin]");
        filterMap.put("/superadmin.html", "authc,roles[host,admin]");

        // 由于权限由上而下“就近”选择,所以一般将"/**"配置在最下面
        filterMap.put("/**", "authc");// 必须授权才能访问
        factoryBean.setFilterChainDefinitionMap(filterMap);
        return factoryBean;
    }

    @Bean("securityManager")
    public DefaultWebSecurityManager getSecurityManager(UserRelam userRelam, SessionManager sessionManager,
        EhCacheManager cacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRelam);
        securityManager.setCacheManager(cacheManager);
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }

    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher getHashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }

    @Bean("userRelam")
    public UserRelam getUserRelam(HashedCredentialsMatcher hashedCredentialsMatcher) {
        UserRelam userRelam = new UserRelam();
        userRelam.setCredentialsMatcher(hashedCredentialsMatcher);
        return new UserRelam();
    }

    /** 配置shiro框架组件的生命周期管理对象 */
    @Bean("LifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 配置授权属性应用对象(在执行授权操作时需要用到此对象)
     * 
     * @param securityManager
     * @return
     */
    @Bean("authorizationAttributeSourceAdvisor")
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    /** 配置负责为Bean对象(需要授权访问的方法所在的对象) 创建代理对象的Bean组件 */
    @Bean("defaultAdvisorAutoProxyCreator")
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    /** 使用缓存ehcachae */
    @Bean("ehCacheManager")
    public EhCacheManager getEhCacheManager() {
        EhCacheManager ehCacheManager = new EhCacheManager();
        ehCacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
        return ehCacheManager;
    }

    @Bean("sessionManager")
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdCookieEnabled(true);
        return sessionManager;
    }

}
