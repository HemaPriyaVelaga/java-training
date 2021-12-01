package com.target.java.training.assignment.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListContactsDao implements ContactsDao {

    private List<Contact> list = new ArrayList<>();


    public ArrayListContactsDao()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String myIndia = "India";

        try {
            list.add(new Contact(1,"Hema", "Priya", Gender.FEMALE,"hemapriya@gmail.com", "8500903254", "Kukatpally", "Hyderabad", "Telangana", 500072, myIndia, sdf.parse("20/11/1997") ));
            list.add(new Contact(2,"Hima", "Bindu", Gender.FEMALE,"himabindu@gmail.com", "8519848992", "KPHB", "Hyderabad", "Telangana", 500072, myIndia, sdf.parse("21/02/2005") ));
            list.add(new Contact(3,"Kavitha", "Velaga", Gender.FEMALE,"kavitha@gmail.com", "9866366566", "Siripuram", "Guntur", "Andhra Pradesh", 111111, myIndia, sdf.parse("14/11/1974") ));
            list.add(new Contact(4,"Venu", "Velaga", Gender.MALE,"venuv@gmail.com", "9866366966", "Tenali", "Guntur", "Andhra Pradesh", 222222, myIndia, sdf.parse("27/05/1968") ));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void addContact(Contact contact) throws DaoException {

        if(contact==null)
        {
            throw new DaoException("Product can not be null !");

        }

        if(contact.getId()<=0)
        {
            throw new DaoException("ID can not be less than 0.");
        }

        list.add(contact);

    }

    @Override
    public Contact getContact(int id) throws DaoException {


        return list.stream()
                .filter(customer -> id == customer.getId())
                .findAny()
                .orElse(null);

    }

    @Override
    public void updateContact(Contact contact) throws DaoException {

        Contact c = getContact(contact.getId());
        int ind;

        ind = list.indexOf(c);
        if(ind!=-1 && c!=null)
        {
            list.set(ind, contact);
            System.out.println("Updated Successfully");
        }
        else
            System.out.println("No Contact with hat ID found!");

    }

    @Override
    public void deleteContact(int id) throws DaoException {

        try {

            Contact james = list.stream()
                    .filter(customer -> id ==customer.getId())
                    .findAny()
                    .orElse(null);
            list.remove(james);
        }
        catch (Exception ex)
        {
            System.out.println("Unable to delete!");
        }
        System.out.println("Element removed successfully");


    }

    @Override
    public Contact getContactByEmail(String email) throws DaoException {

        List <Contact> emailContact = list.stream()
                .filter(p->p.getEmail().equals(email))
                .collect(Collectors.toList());
        if(!emailContact.isEmpty())
            return emailContact.get(0);
        else return null;
    }

    @Override
    public Contact getContactByPhone(String phone) throws DaoException {

        List <Contact> phones = list.stream()
                .filter(p->p.getPhone().equals(phone))
                .collect(Collectors.toList());
        if(!phones.isEmpty())
            return phones.get(0);
        else return null;
    }

    @Override
    public List<Contact> getContactsByLastname(String lastname) throws DaoException {

        return list.stream()
                .filter(p->p.getLastname().equals(lastname))
                .collect(Collectors.toList());

    }

    @Override
    public List<Contact> getContactsByCity(String city) throws DaoException {

        return list.stream()
                .filter(p->p.getCity().equals(city))
                .collect(Collectors.toList());
    }

    @Override
    public List<Contact> getContacts() throws DaoException {

        return this.list;

    }

    @Override
    public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {

        return list.stream()
                .filter(p->p.getBirthDate().after(from))
                .filter(p -> p.getBirthDate().before(to))
                .collect(Collectors.toList());

    }
}
