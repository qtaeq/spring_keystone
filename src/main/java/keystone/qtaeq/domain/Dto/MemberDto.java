package keystone.qtaeq.domain.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private String email;
    private String password;

    private String auth;
}