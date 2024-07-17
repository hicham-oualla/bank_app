package com.app.e_bank.solution.Auth;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    private String username_user;
    private String password_user;
}