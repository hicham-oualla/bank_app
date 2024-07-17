package com.app.e_bank.solution.config;

import com.app.e_bank.solution.Model.Role;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String username_user ;

    private String password_user ;

}
