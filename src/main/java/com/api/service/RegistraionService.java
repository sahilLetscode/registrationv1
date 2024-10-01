package com.api.service;

import com.api.Entity.Registraion;


import com.api.repository.RegistraionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistraionService {


    private RegistraionRepository registraionRepository;

    public RegistraionService(RegistraionRepository registraionRepository) {
        this.registraionRepository = registraionRepository;
    }

    public List<Registraion> getRegistraions(){
        List<Registraion> registraions = registraionRepository.findAll();
        return registraions;




    }

    public Registraion createRegistraion(Registraion registraion) {
        Registraion savedEntity = registraionRepository.save(registraion);
        return savedEntity;

    }

    public void deleteRegistraion(long id) {
        registraionRepository.deleteById(id);
    }

    public Registraion updateRegistraion(long id, Registraion registraion) {
        Registraion r = registraionRepository.findById(id).get();
        r.setId(id);
        r.setName(registraion.getName());
        r.setEmail(registraion.getEmail());
        r.setMobile(registraion.getMobile());
        Registraion savedEntity= registraionRepository.save(r);
       return savedEntity;
    }
}
