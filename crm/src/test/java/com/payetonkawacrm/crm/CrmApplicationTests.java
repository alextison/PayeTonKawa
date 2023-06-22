package com.payetonkawacrm.crm;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class CrmApplicationTests {

	@Test
	public void testGetCustomers() {
		RestTemplate restTemplateMock = mock(RestTemplate.class);	// Mock with restTemplate
		String mockApiUrl = "https://648eff0475a96b66444490b8.mockapi.io/api/v1/customers";	// Define API URL
		String expectedResponse = "{\"createdAt\":\"2023-02-19T15:26:38.450Z\",\"name\":\"Jessica Grady\",\"username\":\"Merle.Hammes\",\"firstName\":\"Johnson\",\"lastName\":\"Gutmann\",\"address\":{\"postalCode\":\"43019\",\"city\":\"Port Reanna\"},\"profile\":{\"firstName\":\"Malcolm\",\"lastName\":\"Ward\"},\"company\":{\"companyName\":\"Leffler, Murphy and Wunsch\"},\"id\":\"7\"}";	// Mock response data
		when(restTemplateMock.getForObject(mockApiUrl, String.class)).thenReturn(expectedResponse);	// Define comportement of restTemplateMock when calling getForObject() method
		CustomerController customerController = new CustomerController();	// Create instance of controller to test
		customerController.setRestTemplate(restTemplateMock);	// Inject restTemplateMock into controller
		String actualResponse = customerController.getCustomers();	// Call method to test
		assertEquals(expectedResponse, actualResponse);	// Check that the method returned the expected response
    }

	@Test
    public void testGetCustomerById() {
        RestTemplate restTemplateMock = mock(RestTemplate.class);
        String mockApiUrl = "https://648eff0475a96b66444490b8.mockapi.io/api/v1/customers/1";
		String expectedResponse = "{\"createdAt\":\"2023-02-19T15:26:38.450Z\",\"name\":\"Jessica Grady\",\"username\":\"Merle.Hammes\",\"firstName\":\"Johnson\",\"lastName\":\"Gutmann\",\"address\":{\"postalCode\":\"43019\",\"city\":\"Port Reanna\"},\"profile\":{\"firstName\":\"Malcolm\",\"lastName\":\"Ward\"},\"company\":{\"companyName\":\"Leffler, Murphy and Wunsch\"},\"id\":\"7\"}";        when(restTemplateMock.getForObject(mockApiUrl, String.class)).thenReturn(expectedResponse);
        CustomerController customerController = new CustomerController();
        customerController.setRestTemplate(restTemplateMock);
        String actualResponse = customerController.getCustomerById("1");
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testGetOrdersWithCustomerById() {
        RestTemplate restTemplateMock = mock(RestTemplate.class);
        String mockApiUrl = "https://648eff0475a96b66444490b8.mockapi.io/api/v1/customers/1/orders";
		String expectedResponse = "{\"createdAt\":\"2023-02-19T15:26:38.450Z\",\"name\":\"Jessica Grady\",\"username\":\"Merle.Hammes\",\"firstName\":\"Johnson\",\"lastName\":\"Gutmann\",\"address\":{\"postalCode\":\"43019\",\"city\":\"Port Reanna\"},\"profile\":{\"firstName\":\"Malcolm\",\"lastName\":\"Ward\"},\"company\":{\"companyName\":\"Leffler, Murphy and Wunsch\"},\"id\":\"7\"}";        when(restTemplateMock.getForObject(mockApiUrl, String.class)).thenReturn(expectedResponse);
        CustomerController customerController = new CustomerController();
        customerController.setRestTemplate(restTemplateMock);
        String actualResponse = customerController.getOrdersWithCustomerById("1");
        assertEquals(expectedResponse, actualResponse);
    }

	@Test
    public void testGetOrderById() {
        RestTemplate restTemplateMock = mock(RestTemplate.class);
		String expectedResponse = "{\"createdAt\":\"2023-02-19T15:26:38.450Z\",\"name\":\"Jessica Grady\",\"username\":\"Merle.Hammes\",\"firstName\":\"Johnson\",\"lastName\":\"Gutmann\",\"address\":{\"postalCode\":\"43019\",\"city\":\"Port Reanna\"},\"profile\":{\"firstName\":\"Malcolm\",\"lastName\":\"Ward\"},\"company\":{\"companyName\":\"Leffler, Murphy and Wunsch\"},\"id\":\"7\"}";        String expectedResponse = "Mocked order data";
        when(restTemplateMock.getForObject(mockApiUrl, String.class)).thenReturn(expectedResponse);
        CustomerController customerController = new CustomerController();
        customerController.setRestTemplate(restTemplateMock);
        String actualResponse = customerController.getOrderById("1", "1");
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testGetProductByOrder() {
        RestTemplate restTemplateMock = mock(RestTemplate.class);
        String mockApiUrl = "https://648eff0475a96b66444490b8.mockapi.io/api/v1/customers/1/orders/1/products";
		String expectedResponse = "{\"createdAt\":\"2023-02-19T15:26:38.450Z\",\"name\":\"Jessica Grady\",\"username\":\"Merle.Hammes\",\"firstName\":\"Johnson\",\"lastName\":\"Gutmann\",\"address\":{\"postalCode\":\"43019\",\"city\":\"Port Reanna\"},\"profile\":{\"firstName\":\"Malcolm\",\"lastName\":\"Ward\"},\"company\":{\"companyName\":\"Leffler, Murphy and Wunsch\"},\"id\":\"7\"}";        when(restTemplateMock.getForObject(mockApiUrl, String.class)).thenReturn(expectedResponse);
        CustomerController customerController = new CustomerController();
        customerController.setRestTemplate(restTemplateMock);
        String actualResponse = customerController.getProductByOrder("1", "1");
        assertEquals(expectedResponse, actualResponse);
    }

}
