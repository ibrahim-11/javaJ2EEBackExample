package com.homdemo.homdemo.service;

import com.homdemo.homdemo.entity.Product;
import com.homdemo.homdemo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


// Création d'une nouvelle instance de la classe ProductRepo.
    @Autowired
    private ProductRepo productRepo;

/**
 * Il renvoie une liste de tous les produits de la base de données
 * 
 * @return Une liste de tous les produits dans la base de données.
 */
    public List<Product> findAll(){
        return this.productRepo.findAll();
    }

/**
 * Si le produit est présent, retournez-le, sinon lancez une erreur 404
 * 
 * @param id L'identifiant du produit à supprimer.
 * @return Le produit avec l'identifiant qui a été transmis.
 */
    public Product findById(Integer id){

        Optional<Product> optproduct = this.productRepo.findById(id);
        if(optproduct.isPresent()){
            return  optproduct.get();
        }else{
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

  /**
   * Il prend un objet Product, l'enregistre dans la base de données et renvoie l'objet Product
   * enregistré.
   * 
   * @param newProduct Il s'agit de l'objet transmis par le contrôleur.
   * @return L'objet newProduct est renvoyé.
   */
    public Product create(Product newProduct){
        return this.productRepo.save(newProduct);
    }


/**
 * Si le produit existe, mettez-le à jour, sinon lancez une exception
 * 
 * @param newProduct le nouveau produit à mettre à jour
 */
    public Product update(Product newProduct){
        if(!this.productRepo.existsById(newProduct.getId())){
            throw  new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver la Product a mettere a jour ");
        }else{
            return this.productRepo.save(newProduct);
        }
    }

/**
 * Cette fonction supprime un produit par son identifiant
 * 
 * @param id L'identifiant du produit à supprimer.
 */
    public Product delete(Integer id){
        if(!this.productRepo.existsById(id)){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"impossible de trouver la guitar a suprimer");
        }
        Product productdelet = this.findById(id);
        this.productRepo.deleteById(id);
        if(this.productRepo.existsById(id)){
            throw  new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,"erreur lors de la supression");
        }
        return productdelet;
    }

}
