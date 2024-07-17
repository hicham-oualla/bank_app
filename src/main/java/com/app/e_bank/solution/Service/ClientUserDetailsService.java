package com.app.e_bank.solution.Service;


import com.app.e_bank.solution.Model.Utilisateur;
import com.app.e_bank.solution.Model.Role;
import com.app.e_bank.solution.Repository.UserRepository;
import com.app.e_bank.solution.Auth.AuthRequest;
import com.app.e_bank.solution.Auth.AuthResponse;
import com.app.e_bank.solution.config.JwtService;
import com.app.e_bank.solution.config.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class ClientUserDetailsService  implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;

    @Autowired
    private JwtService jwtService;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return repository.findByUsername(username);
    }

    public AuthResponse register(RegisterRequest request) {
        var user = Utilisateur.builder()
                .username(request.getUsername_user())
                .password(passwordEncoder.encode(request.getPassword_user()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername_user(),
                        request.getPassword_user()
                )
        );
        var user = repository.findByUsername(request.getUsername_user());
        var jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder()
                .accessToken(jwtToken)
                .build();
    }
}