package com.kh.etc.chat;

import java.sql.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ChatServer extends TextWebSocketHandler{

	//클라이언트가 연결을 맺을 때 호출이되는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
	}
	
	//클라이언트로부터 메세지를 받을 때 호출되는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String nick = (String)session.getAttributes().get("nick");
		JsonObject obj = new JsonParser().parse(message.getPayload()).getAsJsonObject();
		
		log.info("msg : {}", obj.get("message").getAsString());
		log.info("target : {}", obj.get("target").getAsString());
		
		MsgVo vo = new MsgVo();
		vo.setMsg(obj.get("message").getAsString());
		vo.setNick(nick);
		vo.setTime(new Date().toLocaleString());
		
		WebSocketSession mySession = userSession.get(nick);
		
		WebSocketSession targetSession = userSessions.get(obj.get("target").getAsString());
		
		
		if(target)
	}
	
	private void sendMessageUser(MsgVo vo) {
		
	}

	//클라이언트가 연결을 끊을 때 호출되는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
	}
	
}
