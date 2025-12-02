package com.forex.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ForexPriceDto {
    private String symbol;
    private String baseCurrency;
    private String quoteCurrency;
    private Double bidPrice;
    private Double askPrice;
    private Double midPrice;
    private LocalDateTime timestamp;
    private String source;
}