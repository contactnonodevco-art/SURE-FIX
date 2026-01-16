package com.surefix.entity;

import com.surefix.enums.SubscriptionPlan;
import com.surefix.enums.SubscriptionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Abonnement d'un atelier à la plateforme Sure Fix
 * Gère le plan, le statut et la facturation
 */
@Entity
@Table(name = "subscriptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Atelier abonné */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id", nullable = false, unique = true)
    private Shop shop;

    /** Plan d'abonnement choisi */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubscriptionPlan plan;

    /** Statut de l'abonnement */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private SubscriptionStatus status = SubscriptionStatus.TRIAL;

    /** Prix mensuel en dollars */
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal monthlyPrice;

    /** Nombre maximum de techniciens autorisés */
    private Integer maxTechnicians;

    /** Nombre maximum de diagnostics par mois */
    private Integer maxDiagnosticsPerMonth;

    /** ID client Stripe */
    private String stripeCustomerId;

    /** ID abonnement Stripe */
    private String stripeSubscriptionId;

    /** Date de début de l'abonnement */
    @Column(nullable = false)
    private LocalDateTime startDate;

    /** Date de fin de l'abonnement (null si actif) */
    private LocalDateTime endDate;

    /** Date du prochain renouvellement */
    private LocalDateTime nextBillingDate;

    /** Date de fin de la période d'essai */
    private LocalDateTime trialEndDate;

    /** Date de création */
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /** Date de dernière mise à jour */
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (startDate == null) {
            startDate = LocalDateTime.now();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
