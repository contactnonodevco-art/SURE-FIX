package com.surefix.mapper;

import com.surefix.dto.subscription.SubscriptionCreateDTO;
import com.surefix.dto.subscription.SubscriptionDTO;
import com.surefix.entity.Subscription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper Subscription - Conversion automatique Entity ↔ DTO
 */
@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    @Mapping(source = "shop.id", target = "shopId")
    @Mapping(source = "shop.name", target = "shopName")
    SubscriptionDTO toDto(Subscription subscription);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "shop", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "monthlyPrice", ignore = true)
    @Mapping(target = "maxTechnicians", ignore = true)
    @Mapping(target = "maxDiagnosticsPerMonth", ignore = true)
    @Mapping(target = "stripeCustomerId", ignore = true)
    @Mapping(target = "stripeSubscriptionId", ignore = true)
    @Mapping(target = "startDate", ignore = true)
    @Mapping(target = "endDate", ignore = true)
    @Mapping(target = "nextBillingDate", ignore = true)
    @Mapping(target = "trialEndDate", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Subscription toEntity(SubscriptionCreateDTO dto);
}
