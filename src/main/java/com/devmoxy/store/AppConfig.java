package com.devmoxy.store;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Value("${server.port}")
    private int serverPort;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    public int getServerPort() { return serverPort;}

    public String getContextPath() { return contextPath; }

    @Value("${payment-gateway:stripe}")
    private String paymentGateway;

    @Bean
    public PaymentService stripe(){
        return new StripePaymentService();
    }

    @Bean
    public PaymentService paypal(){
        return new PaypalPaymentService();
    }

    @Bean
    public OrderService orderService(){
        if(paymentGateway.equals("stripe")){
            return new OrderService(stripe());
        }
        return new OrderService(paypal());
    }
}
