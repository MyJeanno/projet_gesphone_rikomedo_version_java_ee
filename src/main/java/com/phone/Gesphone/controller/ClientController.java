package com.phone.Gesphone.controller;

import com.phone.Gesphone.constante.Constante;
import com.phone.Gesphone.model.Client;
import com.phone.Gesphone.model.TypeClient;
import com.phone.Gesphone.service.ClientService;
import com.phone.Gesphone.service.TypeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private TypeClientService typeClientService;

    @GetMapping("/clients")
    public String afficherClient(Model model){
        model.addAttribute("clients", clientService.afficherClient());
        model.addAttribute("typeClients", typeClientService.listerTypeClient());
        return "client/client";
    }

    @PostMapping("client/nouveau")
    public String enregistrerClient(@RequestParam String nom,
                                    @RequestParam String prenom,
                                    @RequestParam TypeClient type,
                                    @RequestParam String contact
                                    ){
        Client client = new Client();
        client.setNomClient(nom);
        client.setPrenomClient(prenom);
        client.setTypeClientid(type.getId());
        client.setContactClient(contact);
        client.setAutorisation(Constante.ACTIVE_NON);
        clientService.enregistrerClient(client);
        return "redirect:/clients";
    }

    @GetMapping("client/formEditClient/{id}")
    public String showFormEditClient(@PathVariable("id") Long id, Model model){
        Client unClient = clientService.unClient(id);
        model.addAttribute("client",unClient);
        model.addAttribute("typeClients", typeClientService.listerTypeClient());
        return "client/formEditClient";
    }
}
