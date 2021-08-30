package com.initgrep.apps.nauth.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton") //default
public abstract class CommandProcessor {

    public void processCommand() {
        getCommand().run();
    }


    @Lookup
    public abstract Command getCommand();

}



