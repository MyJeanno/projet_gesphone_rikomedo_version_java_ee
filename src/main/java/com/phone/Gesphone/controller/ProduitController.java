package com.phone.Gesphone.controller;

import com.phone.Gesphone.constante.Constante;
import com.phone.Gesphone.model.Produit;
import com.phone.Gesphone.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    //Cette partie de code concerne les produits en stock

    @GetMapping("/produits")
    public String listerProduit(Model model) {
        model.addAttribute("produits", produitService.listerProduits());
        model.addAttribute("total", produitService.calculerTotalPrix());
        return "produit/produit";
    }

    @GetMapping("/produits/tout")
    public String listerToutStockProduit(Model model) {
        model.addAttribute("produits", produitService.listerProduits());
        return "produit/listeProduit";
    }

    @GetMapping("/produits/detail")
    public String listerStockDetailProduit(Model model) {
        model.addAttribute("produits", produitService.listerProduits());
        return "produit/listeProduitDetail";
    }

    @PostMapping("produit/nouveau")
    public String enregisterProduit(@RequestParam String libelleProduit,
                                    @RequestParam int prixDetail){
        Produit produit = new Produit();
        produit.setLibelleProduit(libelleProduit);
        produit.setPrixDetail(prixDetail);
        produit.setQuantiteDetail(0);
        produit.setQuantiteGros(0);
        produit.setActif(Constante.ACTIVE_NON);
        produitService.enregistrerProduit(produit);
        return "redirect:/produits";
    }

    @GetMapping("produit/FormEdit/{id}")
    public String showFormeditProduit(@PathVariable("id") Long id, Model model){
        Produit unProduit = produitService.findOneProduit(id);
        model.addAttribute("produit", unProduit);
        return "produit/formEditProduit";
    }

    @PostMapping("/produit/update")
    public String updateProduit(@ModelAttribute("produit") Produit produit){
      produitService.enregistrerProduit(produit);
      return "redirect:/produits";
    }

    //Cette partie de code concerne les approvisionnements de produits

    @GetMapping("/appro/produits")
    public String listerProduitAppro(Model model) {
        model.addAttribute("produits", produitService.listerProduits());
        return "approvisionnement/listeProduitAppro";
    }

    @GetMapping("appro/FormAppro/{id}")
    public String showFormAppro(@PathVariable("id") Long id, Model model){
       Produit unProduit = produitService.findOneProduit(id);
       model.addAttribute("produit", unProduit);
       return "approvisionnement/FormAppro";
    }
}
