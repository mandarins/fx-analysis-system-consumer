package com.forex.consumer.service;

import com.forex.consumer.dto.ForexPriceDto;
import com.forex.consumer.entity.CurrencyPairEntity;
import com.forex.consumer.entity.ForexPriceEntity;
import com.forex.consumer.repository.CurrencyPairRepository;
import com.forex.consumer.repository.ForexPriceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ForexPriceService {

    private final ForexPriceRepository forexPriceRepository;
    private final CurrencyPairRepository currencyPairRepository;

    @Transactional
    public void saveForexPrice(ForexPriceDto dto) {
        try {
            // Find the currency pair by symbol
            Optional<CurrencyPairEntity> currencyPair = currencyPairRepository.findBySymbol(dto.getSymbol());

            if (currencyPair.isEmpty()) {
                log.warn("Currency pair not found for symbol: {}", dto.getSymbol());
                return;
            }

            // Convert DTO to Entity
            ForexPriceEntity entity = ForexPriceEntity.builder()
                    .time(dto.getTimestamp())
                    .pairId(currencyPair.get().getId().intValue())  // Convert Long to Integer
                    .open(dto.getBidPrice())
                    .high(dto.getAskPrice())
                    .low(dto.getBidPrice())
                    .close(dto.getMidPrice())
                    .volume(0.0)  // Mock volume for now
                    .source(dto.getSource())
                    .build();

            // Save to database
            forexPriceRepository.save(entity);
            log.info("Saved forex price for {} at {}", dto.getSymbol(), dto.getTimestamp());

        } catch (Exception e) {
            log.error("Error saving forex price for {}: {}", dto.getSymbol(), e.getMessage());
        }
    }
}