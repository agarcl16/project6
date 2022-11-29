package com.alexGarcia.app.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.alexGarcia.app.entity.Oportunity;
import com.alexGarcia.app.repository.OportunityRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
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
	public void testIsOportunityNoExists() {

		Oportunity op = new Oportunity("Alex", "alex09945@gmail.com", "+34638731011");

		assertFalse(oportunityService.isOportunity(op));

	}

	@Test
	public void testCreateOportunity() {

		Oportunity op = new Oportunity("Alex", "alex09945@gmail.com", "+34638731011");
		
		@SuppressWarnings("removal")
		Long uno = new Long("1");
		
		Mockito.when(oportunityRepository.save(op)).thenReturn(new Oportunity(uno,"Alex","alex09945@gmail.com","+34638731011"));

		Oportunity op2 = oportunityService.addOportunity(op);
		
		assertEquals("Alex",op2.getName());
	}

}
