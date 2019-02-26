package com.kapil.microservices.socialmultiplications.testlayer.test.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.kapil.microservices.socialmultiplications.businesslayer.domain.Multiplication;
import com.kapil.microservices.socialmultiplications.businesslayer.service.MultiplicationService;
import com.kapil.microservices.socialmultiplications.businesslayer.service.RandomGeneratorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationTest {

	@MockBean
	private RandomGeneratorService randomGeneratorService;

	@Autowired
	private MultiplicationService multiplicationService;

	@Test
	public void createRandomMultiplicationTest() {
		// given (our mocked Random Generator service will return first 50, then 30)
		given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);
		// when
		Multiplication multiplication = multiplicationService.createRandomMultiplication();
		// then
		assertThat(multiplication.getFactorA()).isEqualTo(50);
		assertThat(multiplication.getFactorB()).isEqualTo(30);
//		assertThat(multiplication.getResult()).isEqualTo(1500);
	}
}
