package com.surefix.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Atelier de réparation électroménager
 * Représente un client B2B de la plateforme Sure Fix
 */
@Entity
@Table(name = "shops")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Nom de l'atelier */
    @Column(nullable = false)
    private String name;

    /** Adresse complète */
    private String address;

    /** Ville */
    private String city;

    /** Code postal */
    private String postalCode;

    /** Pays */
    private String country;

    /** Numéro de téléphone de l'atelier */
    private String phone;

    /** Email de contact de l'atelier */
    private String email;

    /** Numéro SIRET ou équivalent */
    private String siret;

    /** Liste des utilisateurs de cet atelier (Un atelier a plusieurs utilisateurs) */
    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<User> users = new ArrayList<>();

    /** Abonnement actuel de l'atelier */
    @OneToOne(mappedBy = "shop", cascade = CascadeType.ALL)
    private Subscription subscription;

    /** Atelier actif ou désactivé */
    @Column(nullable = false)
    @Builder.Default
    private Boolean active = true;

    /** Date de création */
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /** Date de dernière mise à jour */
    private LocalDateTime updatedAt;

    /**
     * Callback JPA - Exécuté automatiquement AVANT le premier INSERT en base
     */
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    /**
     * Callback JPA - Exécuté automatiquement AVANT chaque UPDATE en base
     */
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
