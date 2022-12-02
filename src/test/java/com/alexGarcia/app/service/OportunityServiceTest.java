package com.alexGarcia.app.service;

import com.alexGarcia.app.dto.OportunityDTO;
import com.alexGarcia.app.entity.Oportunity;
import com.alexGarcia.app.repository.ContactRepository;
import com.alexGarcia.app.repository.OportunityRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InvalidObjectException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    /**
     * To check a normal oportunity we have testCreateOportunity()
     * We have to check if there is a new client add the client and add the oportunity to it
     * If we have a futureDate, generate the new contact
     * We check the information is valid before access this method
     * I have to mock some results of the repository, because some information will be added to the database
     * and in the next execution the test won't work
     */
    @Test
    public void testAddOportity(){
        /**
         * Normal oportunity
         */
        OportunityDTO op = new OportunityDTO();
        op.setName("Pedro");
        op.setEmail("alex09945@gmail.com");
        op.setPhone("+34638731011");
        op.setDescription("prueba");
        Oportunity op1 = oportunityService.addOportunity(op);
        Assert.assertNotNull(op1);

        /**
         * Oportunity with futureDate
         * We need to check the new Contact
         */
        op.setFutureAction("25/12/2023");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse("25/12/2023", formato);
        Oportunity op3 = oportunityService.getOportunity(op.getName());
        Oportunity op2 = oportunityService.addOportunity(op);
        Assert.assertEquals(op2.getContacts().size(),op3.getContacts().size()+2);

        /**
         * Oportunity now is client
         * We have to check if client exists
         *      if: add the oportunity to that client
         *      else: create a client and add the oportunity
         */
        op.setFutureClient("T");
        op.setBussinesName("Solera");
        op2 = oportunityService.addOportunity(op);
        Assert.assertEquals(op2.getClient().getName(),"Solera");
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
