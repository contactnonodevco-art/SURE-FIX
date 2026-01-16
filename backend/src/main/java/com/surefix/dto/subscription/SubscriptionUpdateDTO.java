package com.surefix.dto.subscription;

import com.surefix.enums.SubscriptionPlan;
import com.surefix.enums.SubscriptionStatus;
import lombok.*;

/**
 * DTO pour mettre à jour un abonnement
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionUpdateDTO {

    /** Nouveau plan d'abonnement */
    private SubscriptionPlan plan;

    /** Nouveau statut */
    private SubscriptionStatus status;
}
