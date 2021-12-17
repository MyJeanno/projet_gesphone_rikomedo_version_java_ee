package com.phone.Gesphone.service;

import com.phone.Gesphone.model.Produit;
import com.phone.Gesphone.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> listerProduits(){
        return produitRepository.findAll();
    }

    public void enregistrerProduit(Produit produit){
        produitRepository.save(produit);
    }

    public String calculerTotalPrix(){
        return String.format("%,d", produitRepository.calculerTotalPrix());
    }

    public Produit findOneProduit(Long id){
        Optional<Produit> optional = produitRepository.findById(id);
        Produit produit = null;
        if(optional.isPresent()){
            produit = optional.get();
        }else{
            throw new RuntimeException("Id introuvable");
        }
        return produit;
    }


}
