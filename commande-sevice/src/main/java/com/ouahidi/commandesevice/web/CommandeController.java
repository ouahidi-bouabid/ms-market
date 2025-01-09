package com.ouahidi.commandesevice.web;

import com.ouahidi.commandesevice.entities.Commande;
import com.ouahidi.commandesevice.modele.Client;
import com.ouahidi.commandesevice.modele.Produit;
import com.ouahidi.commandesevice.repositories.CommandeRepositoriy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController

public class CommandeController {

    public CommandeController(CommandeRepositoriy commandeRepositoriy,
                              ClientOpenFeing clientOpenFeing, ProduitOpenFeing produitOpenFeing) {
        this.commandeRepositoriy = commandeRepositoriy;
        this.clientOpenFeing = clientOpenFeing;
        this.produitOpenFeing = produitOpenFeing;
    }
    CommandeRepositoriy commandeRepositoriy;
    ClientOpenFeing clientOpenFeing;
    ProduitOpenFeing produitOpenFeing;
    @GetMapping("/commandes")
    public List<Commande> allCommandes(){
        List<Commande> commandes = commandeRepositoriy.findAll();
        for (Commande c: commandes){
            Produit p = produitOpenFeing.findById(c.getIdProduit());
            c.setProduit(p);
            Client  cl = clientOpenFeing.findById(c.getIdClient());
            c.setClient(cl);

        }
         return commandes;


    }

    @GetMapping("/commandes/{id}")
    public Commande aCommandes(@PathVariable Long id){

        Commande cm = commandeRepositoriy.findById(id).get();

         Client cl= clientOpenFeing.findById(cm.getIdClient());
        cm.setClient(cl);

         Produit p = produitOpenFeing.findById(cm.getIdProduit());
         cm.setProduit(p);

        return cm;
    }
}
