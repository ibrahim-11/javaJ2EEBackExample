package com.homdemo.homdemo.controller;

import com.homdemo.homdemo.entity.Product;
import com.homdemo.homdemo.entity.Transfert;
import com.homdemo.homdemo.service.TransfertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/transfert")
@CrossOrigin(origins = "http://localhost:4200")
public class TransfertController {
    @Autowired
    private TransfertService transfertService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Transfert> findAll() {
        return this.transfertService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Transfert findById(@PathVariable Integer id) {
        return this.transfertService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Transfert create(@RequestBody Transfert newTransfert) {
        return this.transfertService.create(newTransfert);
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Transfert update(@RequestBody Transfert newTransfert, @PathVariable Integer id) {
        if (!id.equals(newTransfert.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvaise transfert à mettre à jour");
        }
        return this.transfertService.upDate(newTransfert);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(code= HttpStatus.ACCEPTED)
    public Transfert delete (@PathVariable Integer id){

        return this.transfertService.delete(id);
    }




}
