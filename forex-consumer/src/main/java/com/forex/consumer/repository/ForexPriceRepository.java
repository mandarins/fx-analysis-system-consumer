package com.forex.consumer.repository;

import com.forex.consumer.entity.ForexPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ForexPriceRepository extends JpaRepository<ForexPriceEntity, Long> {

   // @Query(value = "SELECT cp.id FROM forex.currency_pairs cp WHERE cp.symbol = :symbol", nativeQuery = true)
   // Long findPairIdBySymbol(@Param("symbol") String symbol);
}