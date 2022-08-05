package com.homdemo.homdemo.repository;

import com.homdemo.homdemo.entity.Transfert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransfertRepo extends JpaRepository<Transfert,Integer> {
}
