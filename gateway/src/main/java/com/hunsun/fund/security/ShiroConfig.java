package com.hunsun.fund.security;

import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author
 * @Date 2024/4/19 20:27
 * @Description
 */
@Configuration
public class ShiroConfig {
    @Resource
    private UserRealm userRealm;

    /**
     * shiro过滤器工厂
     *
     * @param securityManager 安全管理器
     * @return {@link ShiroFilterFactoryBean}
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager) {
        //创建拦截链实例
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //设置组登录请求，其他路径一律自动跳转到这里
        shiroFilterFactoryBean.setLoginUrl("/login");
        //未授权跳转路径
        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");
        //设置拦截链map
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //放行请求
        filterChainDefinitionMap.put("/register", "anon");
        filterChainDefinitionMap.put("/*/login", "anon");
        filterChainDefinitionMap.put("/exception/**", "anon");
        //拦截剩下的其他请求
        filterChainDefinitionMap.put("/**", "authc");
        //设置拦截规则给shiro的拦截链工厂
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        // 添加自己的自定义拦截器并且取名为jwt
        Map<String, Filter> filterMap = new HashMap<String, Filter>(1);
        filterMap.put("jwt", new JwtFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        //拦截链配置，从上向下顺序执行，一般将jwt过滤器放在最为下边
        filterChainDefinitionMap.put("/**", "jwt");
        //配置拦截链到过滤器工厂
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //返回实例
        return shiroFilterFactoryBean;
    }

    /**
     * 安全管理器
     *
     * @return {@link DefaultWebSecurityManager}
     */
    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager() {
        //创建默认的web安全管理器
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        //配置shiro的自定义认证逻辑
        defaultSecurityManager.setRealm(userRealm);
        /*
         * 关闭shiro自带的session，详情见文档
         * http://shiro.apache.org/session-management.html#SessionManagement-StatelessApplications%28Sessionless%29
         */
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        defaultSecurityManager.setSubjectDAO(subjectDAO);
        //返回安全管理器实例
        return defaultSecurityManager;
    }


    /**
     *  开启Shiro的注解(如@RequiresRoles,@RequiresPermissions)
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 开启aop注解支持
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
