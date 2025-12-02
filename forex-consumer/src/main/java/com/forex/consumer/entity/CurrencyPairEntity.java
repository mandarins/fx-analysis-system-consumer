package com.forex.consumer.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "currency_pairs", schema = "forex")
@Data
public class CurrencyPairEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "symbol", nullable = false, unique = true)
    private String symbol;

    @Column(name = "base_currency")
    private String baseCurrency;

    @Column(name = "quote_currency")
    private String quoteCurrency;

    @Column(name = "is_active")
    private Boolean isActive;
}