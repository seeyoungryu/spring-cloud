package com.spring_cloud.eureka.client.order;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductClient productClient;
    // 이 필드는 ProductClient 인터페이스를 통해 다른 마이크로서비스(product-service)와 통신합니다.

    // 특정 제품의 정보를 가져오는 메서드
    public String getProductInfo(String productId) {
        return productClient.getProduct(productId); //  ProductClient를 사용 -> product-service 마이크로서비스를 호출하여 제품 정보를 가져옴
    }

    // 특정 주문의 정보를 가져오는 메서드
    public String getOrder(String orderId) {
        if(orderId.equals("1")) {
            String productId = "2"; // 예제에서 제품 ID는 고정된 값
            String productInfo = getProductInfo(productId); // 제품 정보를 가져옴
            return "Your order is " + orderId + " and " + productInfo; // 주문 정보와 제품 정보를 반환
        }
        return "Not exist order..."; // 주문 ID가 "1"이 아닌 경우
    }
}
