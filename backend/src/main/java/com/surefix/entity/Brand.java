package com.surefix.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Marque d'appareils électroménagers
 * Exemples : Whirlpool, Samsung, LG, Bosch, Maytag
 */
@Entity
@Table(name = "brands")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Nom de la marque */
    @Column(nullable = false, unique = true)
    private String name;

    /** Logo de la marque (URL ou chemin MinIO) */
    private String logoUrl;

    /** Description de la marque */
    private String description;

    /** Marque active ou non */
    @Column(nullable = false)
    @Builder.Default
    private Boolean active = true;

    /** Liste des codes d'erreur associés à cette marque */
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    @Builder.Default
    private List<ErrorCode> errorCodes = new ArrayList<>();

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
