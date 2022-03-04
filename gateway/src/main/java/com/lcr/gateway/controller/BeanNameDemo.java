package com.lcr.gateway.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanNameDemo implements BeanNameAware, BeanFactoryPostProcessor {

    @Override
    public void setBeanName(String name) {
        System.out.println("这是beanName：" + name);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
