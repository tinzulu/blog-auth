package com.ninchitech.blogauth.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface UserEventScream {
	
	String OUTPUT = "blogUserChanged";

    @SuppressWarnings("deprecation")
    @Output(OUTPUT)
    MessageChannel momentsUserChanged();
}
