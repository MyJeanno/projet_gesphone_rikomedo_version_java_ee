package com.phone.Gesphone.controller;

import com.phone.Gesphone.model.TypeClient;
import com.phone.Gesphone.service.TypeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TypeClientController {

    @Autowired
    private TypeClientService typeClientService;

    @PostMapping("/typeClient/nouveau")
    public String saveTypeClient(@RequestParam String libbelleType){
        TypeClient typeClient = new TypeClient();
        typeClient.setLibbelleType(libbelleType);
        typeClientService.enregistrerTypeClient(typeClient);
        return "redirect:/typeClients";
    }

    @GetMapping("/typeClients")
    public String ListeTypeClient(Model model){
        model.addAttribute("typeclients", typeClientService.listerTypeClient());
        return "client/typeclient";
    }

    @GetMapping("/typeClient/FormEdit/{id}")
    public String showFormEditTypeClient(@PathVariable("id") Long id, Model model){
        TypeClient unTypeClient = typeClientService.listerUnTypeClient(id);
        model.addAttribute("typeClient", unTypeClient);
        return "client/FormEditTypeClient";
    }

    @PostMapping("/typeClient/update")
    public String updateTypeClient(@ModelAttribute("typeClient") TypeClient typeClient){
       typeClientService.enregistrerTypeClient(typeClient);
       return "redirect:/typeClients";
    }


}
