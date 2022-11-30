package com.alexGarcia.app.service;

import com.alexGarcia.app.entity.Oportunity;
import com.alexGarcia.app.repository.ContactRepository;
import com.alexGarcia.app.repository.OportunityRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OportunityServiceTest {

    @Autowired
    OportunityService oportunityService;
    @Autowired
    OportunityRepository oportunityRepository;
    @Autowired
    ContactRepository contactRepository;

    @Test
    public void testIsOportunityNoExists() {

        Oportunity op = new Oportunity("Pedro", "alex09945@gmail.com", "+34638731011", "Cosa");

        Assert.assertEquals(null, oportunityService.isOportunity(op));
    }

    @Test
    public void testIsOportunityExists() {

        Oportunity op = new Oportunity("Carlos", "alex09945@gmail.com", "+34638731011", "cosa");

        oportunityService.addOportunity(op);

        Assert.assertEquals("Carlos", oportunityService.isOportunity(op).getName());
    }

    @Test
    public void testCreateOportunity() {
        Oportunity op = new Oportunity("Alex", "alex09945@gmail.com", "+34638731011", "algo");
        Oportunity op2 = oportunityService.addOportunity(op);
        Assert.assertEquals("Alex",op2.getName());
    }
}
