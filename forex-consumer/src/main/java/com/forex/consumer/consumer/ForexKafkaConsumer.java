package com.forex.consumer.consumer;

import com.forex.consumer.dto.ForexPriceDto;
import com.forex.consumer.service.ForexPriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ForexKafkaConsumer {

    private final ForexPriceService forexPriceService;

    @KafkaListener(
            topics = "forex.prices.raw",
            groupId = "forex-consumer-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumeForexPrice(ForexPriceDto priceDto) {
        try {
            log.info("Received forex price from Kafka: {} - {}",
                    priceDto.getSymbol(), priceDto.getMidPrice());

            // Save to database
            forexPriceService.saveForexPrice(priceDto);

        } catch (Exception e) {
            log.error("Error consuming forex price: {}", e.getMessage(), e);
        }
    }
}