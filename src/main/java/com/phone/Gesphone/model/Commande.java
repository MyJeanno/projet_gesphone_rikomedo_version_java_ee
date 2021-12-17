package com.phone.Gesphone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero_commande")
    private String numeroCommande;
    @Column(name = "date_commande")
    private LocalDate dateCommande;
    @Column(name = "montant_commande")
    private int montantCommande;

}
