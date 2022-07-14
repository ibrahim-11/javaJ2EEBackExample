package com.homdemo.homdemo.controller;

import com.homdemo.homdemo.entity.Product;
import com.homdemo.homdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
// Mappage de l'URL au contrôleur.
@RequestMapping("/products")
// Autoriser l'application Angular à accéder à l'API.
// Pour autoriser tous les app front-end à acceder a l'API,on met @CrossOrigin("*")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

// Injecter le ProductService dans le ProductController.
// Injecter la dependance automatiquement lors du besoin
    @Autowired
    private ProductService productService;

/**
 * Cette fonction est une requête GET qui renvoie une liste de tous les produits
 * 
 * @return Une liste de produits
 */
    @GetMapping("")
    @ResponseStatus(code= HttpStatus.OK)
    public List<Product> findAll(){
        return this.productService.findAll();
    }
   
/**
 * Il renvoie un produit avec l'identifiant donné
 * 
 * @param id L'identifiant du produit à récupérer.
 * @return Un objet Produit
 */
    @GetMapping("/{id}")
    @ResponseStatus(code= HttpStatus.OK)
    public Product findById(@PathVariable Integer id){
        return  this.productService.findById(id);
    }

/**
 * Cette fonction crée un nouveau produit et le renvoie
 * 
 * @param newProduct C'est l'objet qui sera créé.
 * @return Le produit qui a été créé.
 */
    @PostMapping("")
    @ResponseStatus(code= HttpStatus.CREATED)
    public Product create (@RequestBody Product newProduct){

        return this.productService.create(newProduct);
    }

 // Mise à jour d'un produit.
/**
 * Cette fonction met à jour un produit dans la base de données
 * verification si  l'id renseigné egale aà l'id de l'objet recuperer
 * si oui on met à jour le produit dans la base de données si non
 * on retourne une exception 
 * @param Product L'objet qui sera mis à jour.
 * @param id L'identifiant du produit à mettre à jour.
 * @return L'objet Product est renvoyé.
 */
    @PostMapping("/{id}")
    @ResponseStatus(code= HttpStatus.ACCEPTED)
    public Product update (@RequestBody Product Product,@PathVariable Integer id){
        if (!id.equals(Product.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"mauvaise Product a mettre a jour");
        }
        return this.productService.update(Product);
    }

/**
 * Cette fonction supprime un produit de la base de données
 * 
 * @param id L'identifiant du produit à supprimer.
 * @return Le produit qui a été supprimé.
 */
    @DeleteMapping("/{id}")
    @ResponseStatus(code= HttpStatus.ACCEPTED)
    public Product delete (@PathVariable Integer id){

        return this.productService.delete(id);
    }
}
