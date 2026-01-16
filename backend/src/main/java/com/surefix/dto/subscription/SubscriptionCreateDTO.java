package com.surefix.dto.subscription;

import com.surefix.enums.SubscriptionPlan;
import jakarta.validation.constraints.*;
import lombok.*;

/**
 * DTO pour créer un abonnement
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionCreateDTO {

    /** ID de l'atelier */
    @NotNull(message = "L'ID de l'atelier est obligatoire")
    private Integer shopId;

    /** Plan d'abonnement choisi */
    @NotNull(message = "Le plan est obligatoire")
    private SubscriptionPlan plan;
}
