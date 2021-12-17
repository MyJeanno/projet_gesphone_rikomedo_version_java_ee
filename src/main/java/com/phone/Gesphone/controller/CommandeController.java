package com.phone.Gesphone.controller;

import com.phone.Gesphone.model.Commande;
import com.phone.Gesphone.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
public class CommandeController {

    @Autowired
    private CommandeService commandeService;
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @GetMapping("/commandes")
    public String afficherCommande(Model model){
        model.addAttribute("commandes", commandeService.listerCommande());
        return "produit/commande";
    }

    @PostMapping("/commande/nouveau")
    public String enregistrerCommande(@RequestParam String numeroCommande,
                                      @RequestParam String dateCommande,
                                      @RequestParam int montantCommande){
       Commande commande = new Commande();
        LocalDate date = LocalDate.parse(dateCommande);
       commande.setNumeroCommande(numeroCommande);
       commande.setDateCommande(date);
       commande.setMontantCommande(montantCommande);
       commandeService.enregistrerCommande(commande);
       return "redirect:/commandes";
    }

    @GetMapping("/commande/FormEdit/{id}")
    public String showFormEdit(@PathVariable("id") Long id, Model model){
        Commande uneCommande = commandeService.selectUn(id);
        model.addAttribute("commande",uneCommande);
        return "produit/formEditCommande";
    }

    @PostMapping("/commande/update")
    public String updateCommande(@RequestParam Long id,
                                 @RequestParam String numeroCommande,
                                 @RequestParam String dateCommande,
                                 @RequestParam int montantCommande){
        Commande commande = new Commande();
        LocalDate date = LocalDate.parse(dateCommande);
        commande.setId(id);
        commande.setNumeroCommande(numeroCommande);
        commande.setDateCommande(date);
        commande.setMontantCommande(montantCommande);
        commandeService.enregistrerCommande(commande);
        return "redirect:/commandes";
    }
}
