package com.surefix.entity;

import com.surefix.enums.ApplianceType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Modèle d'appareil électroménager
 * Représente un modèle spécifique d'une marque (ex: Samsung WF45R6100AW)
 */
@Entity
@Table(name = "appliances")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appliance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Marque de l'appareil */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    /** Type d'appareil (lave-linge, frigo, etc.) */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplianceType type;

    /** Numéro de modèle (ex: WF45R6100AW) */
    @Column(nullable = false)
    private String modelNumber;

    /** Nom commercial du modèle */
    private String modelName;

    /** Année de fabrication */
    private Integer year;

    /** URL de l'image de l'appareil */
    private String imageUrl;

    /** Date de création */
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /** Date de dernière mise à jour */
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
