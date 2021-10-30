package com.ironhack.adopterservice.controller;

import com.ironhack.adopterservice.dao.Adopter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adopter")
public class AdopterController {

    @Autowired
    private AdopterRepository adopterRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Adopter> getAll(){
        return adopterRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addAdopter(@RequestBody Adopter adopter){
        adopterRepository.save(adopter);
    }
}
