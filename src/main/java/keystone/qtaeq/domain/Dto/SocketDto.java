package keystone.qtaeq.domain.Dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SocketDto {
    private MessageType type;
    private String content;
    private String sender;

}

