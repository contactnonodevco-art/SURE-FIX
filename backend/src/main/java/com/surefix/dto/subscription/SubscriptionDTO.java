package com.surefix.dto.subscription;

import com.surefix.enums.SubscriptionPlan;
import com.surefix.enums.SubscriptionStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO de réponse pour un abonnement
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionDTO {

    private Integer id;

    /** ID de l'atelier */
    private Integer shopId;

    /** Nom de l'atelier */
    private String shopName;

    /** Plan d'abonnement */
    private SubscriptionPlan plan;

    /** Statut de l'abonnement */
    private SubscriptionStatus status;

    /** Prix mensuel */
    private BigDecimal monthlyPrice;

    /** Nombre maximum de techniciens */
    private Integer maxTechnicians;

    /** Nombre maximum de diagnostics par mois */
    private Integer maxDiagnosticsPerMonth;

    /** Date de début */
    private LocalDateTime startDate;

    /** Date de fin */
    private LocalDateTime endDate;

    /** Date du prochain paiement */
    private LocalDateTime nextBillingDate;

    /** Date de fin de la période d'essai */
    private LocalDateTime trialEndDate;

    /** Date de création */
    private LocalDateTime createdAt;
}
