package com.homdemo.homdemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "transfert")
public class Transfert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nomEnvoie;
    private String nomRecepteur;
    private double montant;
    private double frais;
    private boolean status;

    public Transfert() {
    }

    public Transfert(int id, String nomEnvoie, String nomRecepteur, double montant, double frais, boolean status) {
        this.id = id;
        this.nomEnvoie = nomEnvoie;
        this.nomRecepteur = nomRecepteur;
        this.montant = montant;
        this.frais = frais;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomEnvoie() {
        return nomEnvoie;
    }

    public void setNomEnvoie(String nomEnvoie) {
        this.nomEnvoie = nomEnvoie;
    }

    public String getNomRecepteur() {
        return nomRecepteur;
    }

    public void setNomRecepteur(String nomRecepteur) {
        this.nomRecepteur = nomRecepteur;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getFrais() {
        return frais;
    }

    public void setFrais(double frais) {
        this.frais = frais;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
