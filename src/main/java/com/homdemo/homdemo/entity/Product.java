package com.homdemo.homdemo.entity;

import javax.persistence.*;
import java.io.Serializable;

// Une annotation JPA pour préparer cet objet au stockage dans un magasin de données basé sur JPA.
@Entity
// Dire à JPA que cette entité est mappée à une table nommée `product`.
@Table(name="product")
public class Product implements Serializable {
    @Id
// Une annotation JPA qui indique au fournisseur JPA de générer automatiquement la valeur du champ id.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
// Dire à JPA que le champ "nom" est mappé sur une colonne nommée "nom" dans la base de données.
    @Column(name="nom")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name = "prix")
    private Integer prix;

    public Product() {
    }

// Un constructeur.
    public Product(Integer id, String nom, String description, Integer prix) {
        this.id = id;
        this.name = nom;
        this.description = description;
        this.prix = prix;
    }

/**
 * Il renvoie l'identifiant de l'objet.
 * 
 * @return L'identifiant de l'objet.
 */
    public Integer getId() {
        return id;
    }

/**
 * Il définit l'identifiant de l'objet.
 * 
 * @param id L'identifiant de l'utilisateur
 */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return name;
    }

    public void setNom(String nom) {
        this.name = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }
}
