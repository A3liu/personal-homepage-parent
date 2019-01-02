package com.a3.user.Builder;

import com.a3.user.entity.UserEntity;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * @Author: liuyaosen
 * @Date: 2019/1/2 22:34
 */
@Component
public class BuilderFactory implements BeanFactoryAware {

    private BeanFactory factory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        factory=beanFactory;
    }

    public UserEntity createNewUser(UserEntity userEntity){
        return factory.getBean(UserBuilder.class).add(userEntity).checkForCreateNerUser().checkUsernameExist().newUserInfoInitialize().build();
    }
}
