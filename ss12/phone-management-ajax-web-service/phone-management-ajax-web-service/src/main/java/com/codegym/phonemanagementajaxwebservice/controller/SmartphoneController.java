package com.codegym.phonemanagementajaxwebservice.controller;

import com.codegym.phonemanagementajaxwebservice.model.Smartphone;
import com.codegym.phonemanagementajaxwebservice.service.ISmartphoneService;
import com.codegym.phonemanagementajaxwebservice.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> listSmartphones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphone = smartphoneService.findById(id);
        if (!smartphone.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphone.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Smartphone> editSmartphone(@PathVariable Long id ,@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.OK);
    }
}
