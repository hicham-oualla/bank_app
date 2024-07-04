package com.app.e_bank.solution.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Compt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcompt;
    private String type_compt;
    private float sold;
    private LocalDate date_creation;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
}
