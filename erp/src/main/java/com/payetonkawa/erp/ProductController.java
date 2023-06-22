package com.payetonkawa.erp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {
	
	@GetMapping("/")
    public String getNothing() {
        
        return "Welcome to Payetonkawa";
    }
   
    
    @GetMapping("/products")
    public String getProducts() {
        RestTemplate restTemplate = new RestTemplate();
        String mockApiUrl = "https://648eff0475a96b66444490b8.mockapi.io/api/v1/products";

        String responseData = restTemplate.getForObject(mockApiUrl, String.class);
        
        return responseData;
    }
   

    @GetMapping("/product/{id}")
    public String getProductById(@PathVariable("id") String id) {
        RestTemplate restTemplate = new RestTemplate();
        String mockApiUrl = "https://648eff0475a96b66444490b8.mockapi.io/api/v1/products/" + id;
        
        String product = restTemplate.getForObject(mockApiUrl, String.class);

        return product;
    }

}