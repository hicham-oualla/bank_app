package com.app.e_bank.solution.Service;

import com.app.e_bank.solution.Model.Compt;
import com.app.e_bank.solution.Repository.ComptRepository;
import com.app.e_bank.solution.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ComptService {
    @Autowired
    private ComptRepository comptRepository;

    @Autowired
    private UserRepository userRepository;

    public Compt creatcompt(Integer id_Utilisateur, String type_Compt, float sold) {
        Compt compt = new Compt();
        compt.setType_compt(type_Compt);
        compt.setSold(sold);
        compt.setDate_creation(LocalDate.now());
        compt.setUtilisateur(userRepository.getReferenceById(id_Utilisateur));
        return comptRepository.save(compt);
    }

    public Compt getcomptbyid(Integer id) {
        return comptRepository.findById(id).orElse(null);
    }

    public List<Compt> getAllcompt() {
        return comptRepository.findAll();
    }

    public void deletecompt(Integer id) {
        comptRepository.deleteById(id);
    }
    public Float getSoldById(Integer id) {
        Compt compt = comptRepository.findById(id).orElse(null);
        return (compt != null) ? compt.getSold() : null;
    }
}
