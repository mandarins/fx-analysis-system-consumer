package com.forex.consumer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "price_data", schema = "forex")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ForexPriceEntity.ForexPriceId.class)
public class ForexPriceEntity {

    @Id
    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    @Id
    @Column(name = "pair_id", nullable = false)
    private Integer pairId;  // Changed back to Integer to match database

    @Column(name = "open", nullable = false)
    private Double open;

    @Column(name = "high", nullable = false)
    private Double high;

    @Column(name = "low", nullable = false)
    private Double low;

    @Column(name = "close", nullable = false)
    private Double close;

    @Column(name = "volume")
    private Double volume;

    @Column(name = "source", length = 50)
    private String source;

    // Composite Primary Key Class
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ForexPriceId implements Serializable {
        private LocalDateTime time;
        private Integer pairId;
    }
}