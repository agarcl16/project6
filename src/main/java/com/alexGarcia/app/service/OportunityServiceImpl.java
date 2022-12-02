package com.alexGarcia.app.service;

import java.io.InvalidObjectException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.alexGarcia.app.dto.OportunityDTO;
import com.alexGarcia.app.entity.Client;
import com.alexGarcia.app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexGarcia.app.entity.Contact;
import com.alexGarcia.app.entity.Oportunity;
import com.alexGarcia.app.repository.ContactRepository;
import com.alexGarcia.app.repository.OportunityRepository;

@Service
public class OportunityServiceImpl implements OportunityService {

    @Autowired
    private OportunityRepository oportunityRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Oportunity addOportunity(OportunityDTO op) {
        Oportunity oportunity = new Oportunity();
        oportunity.setName(op.getName());
        oportunity.setEmail(op.getEmail());
        oportunity.setPhone(op.getPhone());
        oportunity.setDescription(op.getDescription());

        Oportunity op2;

        if (op.getFutureClient() == null || !op.getFutureClient().equals("T")) {
            op2 = isOportunity(oportunity);
            if (op2 == null)
                op2 = oportunityRepository.save(oportunity);
            op2= createContact(op, op2);
        } else {
            Client client = isClient(op.getBussinesName());
            if (client == null)
                client = clientRepository.save(new Client(op.getBussinesName()));
            op2 = isOportunity(oportunity);
            if (op2 == null){
                oportunity.setClient(client);
                op2 = oportunityRepository.save(oportunity);
            }else{
                /**
                 * La oportunidad existe, pero no tiene asignado ningun cliente (update de la oportunidad)
                 */
                if(op2.getClient()==null){
                    oportunityRepository.delete(op2);
                    Oportunity update = op2;
                    update.setClient(client);
                    oportunityRepository.save(update);
                    update = isOportunity(update);
                    op2.setId(update.getId());
                }
                /**
                 * La oportunidad existe pero esta asignada a otro cliente
                 */
                else if(!op2.getClient().getName().equals(client.getName())){
                    clientRepository.delete(client);
                    return null;
                }
            }
            op2 = createContact(op, op2);
            op2.setClient(client);
        }

        return op2;
    }

    private Oportunity createContact(OportunityDTO op, Oportunity op2) {
        Contact contact = new Contact(op.getName(), op.getDescription(), LocalDate.now());
        if(!op.getEmail().isEmpty()) contact.setEmail(op.getEmail());
        if(!op.getPhone().isEmpty()) contact.setPhone(op.getPhone());
        contact.setOportunity(op2);
        contactRepository.save(contact);
        List<Contact> list = new ArrayList<>();
        list.add(contact);
        if (op.getFutureAction() != null && !op.getFutureAction().isEmpty()) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(op.getFutureAction(), formato);
            Contact contact2 = new Contact(op.getName(), op.getDescription(), fecha);
            if(!op.getEmail().isEmpty()) contact.setEmail(op.getEmail());
            if(!op.getPhone().isEmpty()) contact.setPhone(op.getPhone());
            contact2.setOportunity(op2);
            contactRepository.save(contact2);
            list.add(contact);
        }
        if(op2.getContacts() == null) op2.setContacts(list);
        else {
            List<Contact> list2 = op2.getContacts();
            for(Contact c: list){
                list2.add(c);
            }

            op2.setContacts(list2);
        }

        return op2;
    }

    @Override
    public Oportunity getOportunity(String name) {
        return oportunityRepository.findByName(name);
    }

    @Override
    public Oportunity isOportunity(Oportunity op) {
        return oportunityRepository.findByName(op.getName());
    }

    @Override
    public Client isClient(String name) {
        return clientRepository.findByName(name);
    }

    @Override
    public OportunityDTO checkInfo(OportunityDTO op) throws InvalidObjectException {
        if (op.getName() == null|| op.getName().isEmpty())
            throw new InvalidObjectException("The information must include name");
        else if ((op.getEmail() == null || op.getEmail().isEmpty())&& (op.getPhone() == null || op.getPhone().isEmpty()))
            throw new InvalidObjectException("The information must include email or phone");
        else if (op.getDescription() == null || op.getDescription().isEmpty())
            throw new InvalidObjectException("The information must include description");
        else if (op.getFutureClient().equals("T")) {
            if (op.getBussinesName() == null || op.getBussinesName().isEmpty())
                throw new InvalidObjectException("There is no BussinessName");
        }
        if (op.getFutureAction() != null && !op.getFutureAction().isEmpty()) {
            LocalDate fecha;
            try {
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                fecha = LocalDate.parse(op.getFutureAction(), formato);
            } catch (Exception e) {
                throw new InvalidObjectException("Not a valid Date");
            }
            if (fecha.isBefore(LocalDate.now()) || fecha.isEqual((LocalDate.now())))
                throw new InvalidObjectException("Future Date must be after today");
        }
        return op;
    }

    @Override
    public List<Oportunity> showOportunities() {
        return oportunityRepository.findAll();
    }

}
