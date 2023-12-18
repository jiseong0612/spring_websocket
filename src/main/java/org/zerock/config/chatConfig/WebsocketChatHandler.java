package org.zerock.config.chatConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.zerock.domain.ChatMessage;
import org.zerock.domain.ChatRoom;
import org.zerock.service.ChatService;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class WebsocketChatHandler extends TextWebSocketHandler{
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private ChatService chatService;
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String payload = message.getPayload();
		System.out.println("playload >>> " + payload);
		
		ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
		ChatRoom room = chatService.findRoomById(chatMessage.getRoomId());
		
		room.handleActions(session, chatMessage, chatService);
	}

}
