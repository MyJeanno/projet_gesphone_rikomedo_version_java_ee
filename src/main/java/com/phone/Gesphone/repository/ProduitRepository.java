package com.phone.Gesphone.repository;

import com.phone.Gesphone.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    @Query(value = "SELECT SUM(prix_detail) FROM produit", nativeQuery = true)
    public int calculerTotalPrix();
}
