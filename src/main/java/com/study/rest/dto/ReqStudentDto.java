package com.study.rest.dto;

import lombok.Data;

@Data
public class ReqStudentDto { // 요청 & 학생정보
    private String schoolName;
    private String department;
    private int grade;
    private String name;
}
