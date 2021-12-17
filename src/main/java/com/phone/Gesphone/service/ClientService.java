package com.phone.Gesphone.service;

import com.phone.Gesphone.model.Client;
import com.phone.Gesphone.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public void enregistrerClient(Client client){
        clientRepository.save(client);
    }

    public List<Client> afficherClient(){
        return clientRepository.findAll();
    }

    public Client unClient(Long id){
        Optional<Client> optional = clientRepository.findById(id);
        Client client = null;
        if(optional.isPresent()){
            client = optional.get();
        }else {
            throw new RuntimeException("Id introuvable");
        }
        return client;
    }

    public void supprimerClient(Long id){
        clientRepository.deleteById(id);
    }
}
