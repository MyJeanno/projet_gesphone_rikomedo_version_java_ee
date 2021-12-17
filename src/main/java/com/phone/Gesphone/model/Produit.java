package com.phone.Gesphone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "libelle_produit")
    private String libelleProduit;
    @Column(name = "prix_detail")
    private int prixDetail;
    @Column(name = "quantite_detail")
    private int quantiteDetail;
    @Column(name = "quantite_gros")
    private int quantiteGros;
    private String actif;


}
