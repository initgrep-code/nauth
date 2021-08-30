package com.initgrep.apps.nauth.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Command {
    public void run(){
        System.out.println("Command Run for hashCode - "+this.hashCode());
    }
}
