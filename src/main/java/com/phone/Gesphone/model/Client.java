package com.phone.Gesphone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom_client")
    private String nomClient;
    @Column(name = "prenom_client")
    private String prenomClient;
    @Column(name = "contact_client")
    private String contactClient;
    @Column(name = "solde_client")
    private int soldeClient;
    @Column(name = "date_echeance")
    private LocalDate dateEcheance;
    @Column(name = "statut_client")
    private String statutClient;
    private String autorisation;

    @ManyToOne
    @JoinColumn(name = "typeClientid", insertable = false, updatable = false)
    private TypeClient typeClient;
    private Long typeClientid;

}
