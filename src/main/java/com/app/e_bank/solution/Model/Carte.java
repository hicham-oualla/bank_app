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
public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarte;
    private String numeroCarte;
    private LocalDate dateExpiration;
    private String typeCarte;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compt compte;

}


























