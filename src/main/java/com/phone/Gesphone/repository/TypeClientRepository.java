package com.phone.Gesphone.repository;

import com.phone.Gesphone.model.TypeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeClientRepository extends JpaRepository<TypeClient, Long> {
}
