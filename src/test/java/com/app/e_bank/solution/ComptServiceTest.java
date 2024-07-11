package com.app.e_bank.solution;

import com.app.e_bank.solution.Model.Compt;
import com.app.e_bank.solution.Model.Utilisateur;
import com.app.e_bank.solution.Repository.ComptRepository;
import com.app.e_bank.solution.Repository.UserRepository;
import com.app.e_bank.solution.Service.ComptService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ComptServiceTest {

    @Mock
    private ComptRepository comptRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ComptService comptService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatCompt() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId_user(1);
        utilisateur.setFullname_user("John Doe");

        Compt compte = new Compt();
        compte.setType_compt("Savings");
        compte.setSold(1000.0f);
        compte.setUtilisateur(utilisateur);

        when(comptRepository.save(any(Compt.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Compt createdCompt = comptService.creatcompt(compte);

        assertNotNull(createdCompt);
        assertEquals("Savings", createdCompt.getType_compt());
        assertEquals(1000.0f, createdCompt.getSold());
        assertEquals(LocalDate.now(), createdCompt.getDate_creation());
        assertEquals(utilisateur, createdCompt.getUtilisateur());
    }

    @Test
    void testGetComptById() {
        Compt compte = new Compt();
        compte.setIdcompt(1);
        compte.setType_compt("Savings");

        when(comptRepository.findById(1)).thenReturn(Optional.of(compte));

        Compt foundCompt = comptService.getcomptbyid(1);

        assertNotNull(foundCompt);
        assertEquals(1, foundCompt.getIdcompt());
        assertEquals("Savings", foundCompt.getType_compt());
    }

    @Test
    void testGetAllCompt() {
        Compt compte1 = new Compt();
        compte1.setIdcompt(1);
        compte1.setType_compt("Savings");

        Compt compte2 = new Compt();
        compte2.setIdcompt(2);
        compte2.setType_compt("Checking");

        when(comptRepository.findAll()).thenReturn(Arrays.asList(compte1, compte2));

        List<Compt> comptes = comptService.getAllcompt();

        assertNotNull(comptes);
        assertEquals(2, comptes.size());
    }

    @Test
    void testDeleteCompt() {
        doNothing().when(comptRepository).deleteById(1);

        comptService.deletecompt(1);

        verify(comptRepository, times(1)).deleteById(1);
    }

    @Test
    void testGetSoldById() {
        Compt compte = new Compt();
        compte.setIdcompt(1);
        compte.setSold(1000.0f);

        when(comptRepository.findById(1)).thenReturn(Optional.of(compte));

        Float sold = comptService.getSoldById(1);

        assertNotNull(sold);
        assertEquals(1000.0f, sold);
    }

    @Test
    void testGetSoldByIdWhenComptNotFound() {
        when(comptRepository.findById(1)).thenReturn(Optional.empty());

        Float sold = comptService.getSoldById(1);

        assertNull(sold);
    }
}
