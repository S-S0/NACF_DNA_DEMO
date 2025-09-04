package com.example.demo.repository;

import com.example.demo.domain.FinancialRatios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialRatiosRepository extends JpaRepository<FinancialRatios, Long> {

    List<FinancialRatios> findByBrcAndBasyyInOrderByBasyyAsc(String brc, List<String> years);
}