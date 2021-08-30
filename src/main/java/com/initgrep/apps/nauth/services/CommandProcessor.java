package com.initgrep.apps.nauth.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton") //default
public class CommandProcessor implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void processCommand() {
        applicationContext.getBean(Command.class).run();
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.applicationContext =  applicationContext;
    }

}



