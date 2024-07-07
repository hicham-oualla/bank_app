package com.app.e_bank.solution.Service;

import com.app.e_bank.solution.Model.Carte;
import com.app.e_bank.solution.Model.Compt;
import com.app.e_bank.solution.Repository.CarteRepository;
import com.app.e_bank.solution.Repository.ComptRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarteServiceTest {

    @Mock
    private CarteRepository carteRepository;

    @Mock
    private ComptRepository compteRepository;

    @InjectMocks
    private CarteService carteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreerCarte() {
        Compt compte = new Compt();
        compte.setIdcompt(1);
        compte.setType_compt("Savings");
        compte.setSold(1000.0F);

        Carte carte = new Carte();
        carte.setNumeroCarte("1234567890123456");
        carte.setTypeCarte("Debit");
        carte.setDateExpiration(LocalDate.now().plusYears(3));
        carte.setCompte(compte);

        when(compteRepository.findById(1)).thenReturn(Optional.of(compte));
        when(carteRepository.save(any(Carte.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Carte createdCarte = carteService.creerCarte(carte);

        assertNotNull(createdCarte);
        assertEquals("1234567890123456", createdCarte.getNumeroCarte());
        assertEquals("Debit", createdCarte.getTypeCarte());
        assertEquals(LocalDate.now().plusYears(3), createdCarte.getDateExpiration());
        assertEquals(compte, createdCarte.getCompte());
        assertTrue(createdCarte.isActive());
    }
}
