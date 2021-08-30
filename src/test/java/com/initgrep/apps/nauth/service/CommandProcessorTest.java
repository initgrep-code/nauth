package com.initgrep.apps.nauth.service;

import com.initgrep.apps.nauth.services.Command;
import com.initgrep.apps.nauth.services.CommandProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { CommandProcessor.class, Command.class})
public class CommandProcessorTest {

    @Autowired
    CommandProcessor commandProcessor;


    @Test
    public void testCommandInstances(){
            commandProcessor.processCommand();
            commandProcessor.processCommand();
            commandProcessor.processCommand();
    }
}
