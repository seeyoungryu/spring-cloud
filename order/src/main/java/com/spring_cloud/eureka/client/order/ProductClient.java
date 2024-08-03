package com.spring_cloud.eureka.client.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
// Eureka에 등록된 product-service(이름)를 식별하여 호출
// Feign은 이 이름을 사용하여 <마이크로서비스를 호출>합니다.
public interface ProductClient  {

    @GetMapping("/product/{id}") // product-service의 /product/{id} 엔드포인트를 호출
    String getProduct(@PathVariable("id") String id); //제품 ID를 경로 변수로 받아 제품 정보를 가져오는 메서드입니다.
}


/*
ProductClient는 product-service 마이크로서비스와 통신하기 위한 Feign 클라이언트 인터페이스입니다.
Feign을 사용하면 HTTP API 호출을 Java 인터페이스 메서드로 표현할 수 있습니다.
 */