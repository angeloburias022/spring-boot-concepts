package com.springboot.concepts;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.springboot.concepts.entity.TaxiRide;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class ConceptsApplicationTests {

	@Test
	void contextLoads() {
		test();
	}

	private void test()
	{
	// 	TestRestTemplate testRestTemplate = new TestRestTemplate();
    // TaxiRide taxiRide = new TaxiRide(true, 10l);
    // String fare = testRestTemplate.postForObject(
    //   "http:localhost:8080/" + "calculate/", 
    //   taxiRide, String.class);
 
	  
    // assertThat(fare, "200");
	}
}
