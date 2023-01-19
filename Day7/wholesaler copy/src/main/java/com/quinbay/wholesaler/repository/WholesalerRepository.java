package com.quinbay.wholesaler.repository;

import com.quinbay.wholesaler.model.Wholesaler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WholesalerRepository extends JpaRepository<Wholesaler,Integer> {

}
