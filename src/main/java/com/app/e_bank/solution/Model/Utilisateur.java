package com.app.e_bank.solution.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;
    private  String fullname_user ;
    private String mail_user ;
    private String password_user ;

    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnore //eviter boucle qui get all users
    private List<Compt> compt_list ;
}
