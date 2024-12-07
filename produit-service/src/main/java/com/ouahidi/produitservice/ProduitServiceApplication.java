package com.ouahidi.produitservice;

import com.ouahidi.produitservice.entities.Produit;
import com.ouahidi.produitservice.repositories.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

//@EnableDiscoveryClient

public class ProduitServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduitServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner debut(ProduitRepository produitRepository){

        return args -> {

            Produit p1 =Produit.builder()
                    .intitule("PC Desktop")
                    .prix(4000.0)
                    .build();

            produitRepository.save(p1);

            Produit p2=Produit.builder()
                    .intitule("PC Portable")
                    .prix(3000.0)
                    .build();

            produitRepository.save(p2);

            Produit p3=Produit.builder()
                    .intitule("Imprimante ")
                    .prix(2000.0)
                    .build();

            produitRepository.save(p3);

            System.out.println("=============");
            Produit p= produitRepository.findById(1L).get();
            System.out.println("prix "+p.getPrix());

        };


    }
}
