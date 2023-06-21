package com.payetonkawacrm.crm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {
	
	@GetMapping("/")
    public String getNothing() {
        
        return "Welcome to Payetonkawa";
    }
   
    
    @GetMapping("/customers")
    public String getCustomers() {
        RestTemplate restTemplate = new RestTemplate();
        String mockApiUrl = "https://648eff0475a96b66444490b8.mockapi.io/api/v1/customers";

        String responseData = restTemplate.getForObject(mockApiUrl, String.class);
        
        return responseData;
    }
   

    @GetMapping("/customers/{id}")
    public String getCustomerById(@PathVariable("id") String id) {
        RestTemplate restTemplate = new RestTemplate();
        String mockApiUrl = "https://648eff0475a96b66444490b8.mockapi.io/api/v1/customers/" + id;
        
        String customer = restTemplate.getForObject(mockApiUrl, String.class);

        return customer;
    }
    
    @GetMapping("/customers/{id}/orders")
    public String getOrdersWithCustomerById(@PathVariable("id") String id) {
        RestTemplate restTemplate = new RestTemplate();
        String mockApiUrl = "https://648eff0475a96b66444490b8.mockapi.io/api/v1/customers/" + id + "/orders";
        
        String orders = restTemplate.getForObject(mockApiUrl, String.class);

        return orders;
    }
    
    @GetMapping("/customers/{customerId}/orders/{orderId}")
    public String getOrderById(@PathVariable("customerId") String customerId, @PathVariable("orderId") String orderId) {
        RestTemplate restTemplate = new RestTemplate();
        String mockApiUrl = "https://648eff0475a96b66444490b8.mockapi.io/api/v1/customers/" + customerId + "/orders/" + orderId;
        
        String order = restTemplate.getForObject(mockApiUrl, String.class);

        return order;
    }
    
    @GetMapping("/customers/{customerId}/orders/{orderId}/products")
    public String getProductByOrder(@PathVariable("customerId") String customerId, @PathVariable("orderId") String orderId) {
        RestTemplate restTemplate = new RestTemplate();
        String mockApiUrl = "https://648eff0475a96b66444490b8.mockapi.io/api/v1/customers/" + customerId + "/orders/" + orderId + "/products";
        
        String orderProducts = restTemplate.getForObject(mockApiUrl, String.class);

        return orderProducts;
    }
}