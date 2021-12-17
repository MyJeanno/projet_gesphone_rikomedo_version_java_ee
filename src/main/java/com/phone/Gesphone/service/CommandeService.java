package com.phone.Gesphone.service;

import com.phone.Gesphone.model.Commande;
import com.phone.Gesphone.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;

    public void enregistrerCommande(Commande commande){
        commandeRepository.save(commande);
    }

    public List<Commande> listerCommande(){
        return commandeRepository.findAll();
    }

    public Commande selectUn(Long id){
        Optional<Commande> optional = commandeRepository.findById(id);
        Commande commande = null;
        if(optional.isPresent()){
            commande = optional.get();
        }else {
            throw new RuntimeException("Id introuvable");
        }
        return commande;
    }
}
