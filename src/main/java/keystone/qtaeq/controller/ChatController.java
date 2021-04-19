package keystone.qtaeq.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import keystone.qtaeq.domain.Dto.SocketDto;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public SocketDto sendMessage(@Payload SocketDto socketDto){
        return socketDto;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public SocketDto addUser(@Payload SocketDto socketDto, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username",socketDto.getSender());
        return socketDto;
    }

}
