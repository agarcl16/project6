package com.alexGarcia.app.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.alexGarcia.app.entity.Oportunity;
import com.alexGarcia.app.repository.OportunityRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OportunityServiceTest {

	@InjectMocks
	private OportunityServiceImpl oportunityService;

	@Mock
	private OportunityRepository oportunityRepository;

	/*
	 * We have to create an oportunity, but we cannot create it if there is no
	 * contact.
	 */
	@Test
	public void testCreateOportunity() {

		Oportunity op = new Oportunity("Alex", "alex09945@gmail.com", "+34638731011");
		
		assertTrue(oportunityService.addOportunity(op));
		
		assertFalse(oportunityService.addOportunity(op));
	}

}
