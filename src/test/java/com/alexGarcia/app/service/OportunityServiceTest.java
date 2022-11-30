package com.alexGarcia.app.service;

import com.alexGarcia.app.dto.OportunityDTO;
import com.alexGarcia.app.entity.Oportunity;
import com.alexGarcia.app.repository.ContactRepository;
import com.alexGarcia.app.repository.OportunityRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InvalidObjectException;

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
        Assert.assertEquals("Alex", op2.getName());
    }

    /**
     * We have to check if the information is ok, if it is a new client or if will be a future contact
     */

    @Test
    public void testCheckInfo() {
        OportunityDTO op = new OportunityDTO();
        /**
         * The info is incorrect
         * The info must include:
         *      -Name
         *      -email or phone
         *      -Description
         */

        Assert.assertThrows("The information must include name", InvalidObjectException.class,() -> {
            oportunityService.checkInfo(op);
        });

        op.setName("Nombre");
        Assert.assertThrows("The information must include email or phone",InvalidObjectException.class,() -> { oportunityService.checkInfo(op);});

        op.setPhone("+34638731011");
        Assert.assertThrows("The information must include description",InvalidObjectException.class,() -> { oportunityService.checkInfo(op);});

        op.setDescription("prueba");

        /**
         * Check if Client is true => BussinessName mustNotBe null
         */

        op.setFutureClient("T");
        Assert.assertThrows("There is no BussinessName",InvalidObjectException.class,() -> { oportunityService.checkInfo(op);});
        op.setBussinesName("Solera");

        op.setFutureAction("prueba");
        Assert.assertThrows("Not a valid Date",InvalidObjectException.class,() -> { oportunityService.checkInfo(op);});

        op.setFutureAction("10/11/2021");
        Assert.assertThrows("Future Date must be after today",InvalidObjectException.class,() -> { oportunityService.checkInfo(op);});

        op.setFutureAction("16/12/2022");
        OportunityDTO op2 = new OportunityDTO();
        try{
            op2 = oportunityService.checkInfo(op);
        }catch(InvalidObjectException e){
        }
        Assert.assertEquals(op, op2);
    }
}
