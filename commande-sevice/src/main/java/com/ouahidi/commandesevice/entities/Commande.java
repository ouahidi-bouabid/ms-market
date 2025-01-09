package com.ouahidi.commandesevice.entities;

import com.ouahidi.commandesevice.modele.Client;
import com.ouahidi.commandesevice.modele.Produit;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class Commande {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;
    private Integer quantite;
    private Long idProduit;
    private Long idClient;
    @Transient
    private Produit produit;
    @Transient
    private Client client;
}
