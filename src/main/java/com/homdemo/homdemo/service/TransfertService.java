package com.homdemo.homdemo.service;

import com.homdemo.homdemo.entity.Transfert;
import com.homdemo.homdemo.repository.TransfertRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TransfertService {
    @Autowired
    private TransfertRepo transfertRepo;

    public List<Transfert> findAll(){return this.transfertRepo.findAll();}

    public Transfert findById(Integer id){
        Optional<Transfert> optionalTransfert = this.transfertRepo.findById(id);

        if(optionalTransfert.isPresent()){
            return optionalTransfert.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    public Transfert create (Transfert newTransfert){
        return this.transfertRepo.save(newTransfert);
    }
    public Transfert upDate(Transfert newTransfert){
        if (!this.transfertRepo.existsById(newTransfert.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Impossible de trouver le transfert à mettre à jour");

        }else {
            return this.transfertRepo.save(newTransfert);

        }
    }

    public Transfert delete(Integer id){
        if(!this.transfertRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"impossile de trouver le transfert à suprimer");
        }
        Transfert deletedTransfert = this.findById(id);
        this.transfertRepo.deleteById(id);
        if(this.transfertRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,"erreur lors de la supression");

        }
        return  deletedTransfert;

    }

}
