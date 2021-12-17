package com.phone.Gesphone.service;

import com.phone.Gesphone.model.TypeClient;
import com.phone.Gesphone.repository.TypeClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeClientService {

    @Autowired
    private TypeClientRepository typeClientRepository;

    public List<TypeClient> listerTypeClient(){
        return typeClientRepository.findAll();
    }

    public TypeClient listerUnTypeClient(Long id){
        Optional<TypeClient> optional = typeClientRepository.findById(id);
        TypeClient typeClient = null;
        if(optional.isPresent()){
            typeClient = optional.get();
        }else{
            throw new RuntimeException("Id introuvable");
        }
        return typeClient;
    }

    public void enregistrerTypeClient(TypeClient typeClient){
        typeClientRepository.save(typeClient);
    }

    public void supprimerTypeClient(Long id){
        typeClientRepository.deleteById(id);
    }
}
