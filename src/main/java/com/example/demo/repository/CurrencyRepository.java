package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long>{

	Currency findByCountry(String country);

}
