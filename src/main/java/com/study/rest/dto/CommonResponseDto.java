package com.study.rest.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommonResponseDto {

        private String message;
        private int count;
        private boolean success; // true & false 판단 해주기 위한 변수로 선언

        public static CommonResponseDto ofDefault(int count) {
            return CommonResponseDto.builder()
                    .message(count > 0 ? "Successfully" : "failed")
                    .count(count)
                    .success(count > 0)
                    .build();
        }

}
