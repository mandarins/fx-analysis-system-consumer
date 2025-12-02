package com.forex.consumer.repository;

import com.forex.consumer.entity.CurrencyPairEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyPairRepository extends JpaRepository<CurrencyPairEntity, Long> {

    Optional<CurrencyPairEntity> findBySymbol(String symbol);
}