package org.sid.catservice;

import org.sid.catservice.dao.ProduitRepository;
import org.sid.catservice.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CatServiceApplication implements CommandLineRunner {

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(CatServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        restConfiguration.exposeIdsFor(Produit.class);
        produitRepository.save(new Produit(null,"ordinateur assus",6700,3));
        produitRepository.save(new Produit(null,"imprmante",2500,4));
        produitRepository.save(new Produit(null,"smart phone",3000,5));
        produitRepository.findAll().forEach(p ->
                System.out.println(p.toString()));

    }
}
