package com.study.rest.controller;

import com.study.rest.dto.ProductDto;
import com.study.rest.dto.ReqProductDto;
import com.study.rest.dto.ReqStudentDto;
import com.study.rest.entity.Product;
import com.study.rest.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j // log 를 찍을 때 사용
// REST API 라고 함
// 응답, 요청을 할때 / view 리턴 x 무조건 데이터 리턴
@RestController
public class BasicController {

    @Autowired
    private ProductService productService;

    /**
     * REST API
     * 데이터 통신을 위한 HTTP 요청 방식
     * HTTP(프로토콜)을 조금 더 잘 쓰기 위해서 정의된 개념
     * 1. 요청에 대한 동작은 무조건 메소드에 따라 정의하자.
     *  - 데이터 추가(등록)은 POST 요청으로 하자, 그리고 POST요청은 JSON 데이터로 요청하자.
     *  - 데이터 조회는 GET 요청으로 하자,
     *          그리고 GET 요청은 QueryString(params를 의미) 으로 요청하자.
     *          예) 주소?key1=value1&key2=value2
     *  - 데이터 수정은 PUT, Patch 요청으로 하자, JSON으로 요청하자.
     *      PUT 요청과 PATCH 요청의 차이점
     *      PUT 요청: 공백 또는 NULL인 데이터도 수정을 함. // 공백이 작성이 되어도 수정이 되고
     *      PATCH 요청: 공백 또는 NULL인 데이터는 수정을 하지 않음. // 공백이 작성이 되있으면 수정이 불가함
     *  - 데이터 삭제는 DELETE 요청으로 하자, params로 요청하자
     * 2. 주소(URL) 요청 메시지(Resurce) 자원 작성법
     *  - URL은 가능한 동사를 사용하지 않는다
     *  - 계층 구조로 작성한다.
     *      예) /집/주방/가스레인지, /식당/주방/가스레인지
     *  - 요청 메소드 마다 작성하는 방법이 다르다.
     *      상품 등록(POST) /product
     *      상품 하나(단건) 조회(GET) /product/1(id, key)
     *      상품 여러개(다건) 조회(GET) /products(전체), /products?page=1&count=30(한페이지에 30개씩)
     *      상품 수정(PUT) /product/1(id, key)
     *      상품 삭제(DELETE) /product/1(id, key)
     * 3. 주소는 가능한 대문자를 사용하지 않는다.
     *
     *
     */

    @CrossOrigin
    @PostMapping("/basic/student") // student 추가 / post 가 추가의 의미를 가짐
    // 제네릭
    public ResponseEntity<?> basicPost(@RequestBody ReqStudentDto reqStudentDto) {
        log.info("reqStudent : {}", reqStudentDto); // sout(System.out.println) 대신 log.info 를 써야함
        return ResponseEntity.ok().body(null); // ok -> 상태코드가 200이라는 것을 의미
    }

    @CrossOrigin
    @PostMapping("/api/v1/product")
    public ResponseEntity<?> registerProduct(@RequestBody ProductDto.Register register) {
//        log.info("{}", reqProductDto);
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // http에 띄울때 어떤 오류를 설정하는

        return ResponseEntity.ok().body(productService.registerProduct(register));
    }

    @CrossOrigin
    @GetMapping("/api/v1/sizes")
    public ResponseEntity<?> sizeListApi() {
        return ResponseEntity.ok().body(productService.getSizeListAll());
    }

    @CrossOrigin
    @GetMapping("/api/v1/colors")
    public ResponseEntity<?> colorListApi() {
        return ResponseEntity.ok().body(productService.getColorListAll());
    }
}
