package com.study.rest.dto;

import com.study.rest.entity.Product;
import lombok.Builder;
import lombok.Data;

public class ProductDto {

    // 등록할 때 사용 (등록용)
    @Data
    public static class Register {
        private String productName;
        private int price;
        private int sizeId;
        private int colorId;

        public Product toEntity() {
            return Product.builder()
                    .productName(productName)
                    .price(price)
                    .sizeId(sizeId)
                    .colorId(colorId)
                    .build();

        }
    }
}
