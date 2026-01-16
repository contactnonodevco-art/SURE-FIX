package com.surefix.mapper;

import com.surefix.dto.shop.ShopCreateDTO;
import com.surefix.dto.shop.ShopDTO;
import com.surefix.entity.Shop;
import org.mapstruct.Mapper;

/**
 * Mapper Shop - Conversion automatique Entity ↔ DTO
 */
@Mapper(componentModel = "spring")
public interface ShopMapper {

    ShopDTO toDto(Shop shop);

    Shop toEntity(ShopCreateDTO dto);
}
