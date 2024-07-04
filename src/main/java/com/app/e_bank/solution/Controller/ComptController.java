package com.app.e_bank.solution.Controller;

import com.app.e_bank.solution.Model.Compt;
import com.app.e_bank.solution.Service.ComptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compt")
public class ComptController {
    @Autowired
    private ComptService comptService;

    @GetMapping("/")
    public List<Compt> getCompts() {
        return comptService.getAllcompt();
    }
    @GetMapping("/{id}")
    public Compt getCompt(@PathVariable Integer id) {
        return comptService.getcomptbyid(id);

    }

    @PostMapping("/add")
    public String addCompt(@RequestParam Integer id_Utilisateur, @RequestParam String type_Compt, @RequestParam float sold) {

                comptService.creatcompt(id_Utilisateur, type_Compt, sold);
        return "saved";
    }
}
