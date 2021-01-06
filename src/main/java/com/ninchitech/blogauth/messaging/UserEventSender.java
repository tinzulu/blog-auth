package com.ninchitech.blogauth.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import com.ninchitech.blogauth.model.User;

import lombok.extern.slf4j.Slf4j;

import com.ninchitech.blogauth.dto.UserEventPayload;

@Service
@Slf4j
@EnableBinding(UserEventScream.class)
public class UserEventSender {
	
	@Autowired
	private UserEventScream channel;
	
	
	public void sendUserCreated(User user) {
        log.info("sending user created event for user {}", user.getUsername());
        sendUserChangedEvent(convertTo(user, UserEventType.CREATED));
    } 
	
	
	private void sendUserChangedEvent(UserEventPayload payload) {
		
        channel.momentsUserChanged().send(MessageBuilder.withPayload(payload).build());
        log.info("user event {} sent to topic {} for user {}",
        		payload.getEventType()+" "+payload.getUsername());
	}
	
	
	private UserEventPayload convertTo(User user, UserEventType eventType) {
        return UserEventPayload
                .builder()
                .eventType(eventType)
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .displayName(user.getUserProfile().getDisplayName())
                .profilePictureUrl(user.getUserProfile().getProfilePictureUrl()).build();
    }
}
