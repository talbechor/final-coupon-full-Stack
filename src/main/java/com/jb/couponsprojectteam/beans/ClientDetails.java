package com.jb.couponsprojectteam.beans;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClientDetails {
    private String email;
    private String password;
    private ClientType clientType;
}
