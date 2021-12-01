package com.target.java.training.assignment.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class LinkedHashMapDao implements ContactsDao{

    private LinkedHashMap<Integer, Contact> list = new LinkedHashMap<>();

    public LinkedHashMapDao()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        try {
            list.put(1, new Contact(1,"Hema", "Priya", Gender.FEMALE,"hemapriya@gmail.com", "8500903254", "Kukatpally", "Hyderabad", "Telangana", 500072, "India", sdf.parse("20/11/1997") ));
            list.put(2, new Contact(2,"Hima", "Bindu", Gender.FEMALE,"himabindu@gmail.com", "8519848992", "KPHB", "Hyderabad", "Telangana", 500072, "India", sdf.parse("21/02/2005") ));
            list.put(3, new Contact(3,"Kavitha", "Velaga", Gender.FEMALE,"kavitha@gmail.com", "9866366566", "Siripuram", "Guntur", "Andhra Pradesh", 111111, "India", sdf.parse("14/11/1974") ));
            list.put(4, new Contact(4,"Venu", "Velaga", Gender.MALE,"venuv@gmail.com", "9866366966", "Tenali", "Guntur", "Andhra Pradesh", 222222, "India", sdf.parse("27/05/1968") ));

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

        if (list.containsKey(contact.getId()))
        {
            throw new DaoException("ID already exists. Please enter another ID");
        }

        list.put(contact.getId(), contact);
    }

    @Override
    public Contact getContact(int id) throws DaoException {


        ArrayList<Contact> values = new ArrayList<>(list.values());

        //Contact cont =

        return values.stream()
                .filter(customer -> id == customer.getId())
                .findAny()
                .orElse(null);

    }

    @Override
    public void updateContact(Contact contact) throws DaoException {

        ArrayList<Contact> values = new ArrayList<>(list.values());

        Contact c = getContact(contact.getId());

        int ind;

        ind = values.indexOf(c);
        if(ind!=-1 && c!=null)
        {
            list.put(ind, contact);
            System.out.println("Updated Successfully");
        }
        else
            System.out.println("No Contact with hat ID found!");


    }

    @Override
    public void deleteContact(int id) throws DaoException {

        try {

            ArrayList<Contact> values = new ArrayList<>(list.values());
            Contact cont = values.stream()
                    .filter(customer -> id ==customer.getId())
                    .findAny()
                    .orElse(null);
            if(list.containsKey(cont.getId()))
                list.remove(cont.getId());
            else
                System.out.println("No such contact found!");
        }
        catch (Exception ex)
        {
            System.out.println("Unable to delete!");
        }
        System.out.println("Element removed successfully");
    }

    @Override
    public Contact getContactByEmail(String email) throws DaoException {

        ArrayList<Contact> values = new ArrayList<>(list.values());
        List <Contact> emailContact = values.stream()
                .filter(p->p.getEmail().equals(email))
                .collect(Collectors.toList());
        if(emailContact.isEmpty()==false)
            return emailContact.get(0);
        else return null;
    }

    @Override
    public Contact getContactByPhone(String phone) throws DaoException {

        ArrayList<Contact> values = new ArrayList<>(list.values());

        List <Contact> phones = values.stream()
                .filter(p->p.getPhone().equals(phone))
                .collect(Collectors.toList());
        if(phones.isEmpty()==false)
            return phones.get(0);
        else return null;
    }

    @Override
    public List<Contact> getContactsByLastname(String lastname) throws DaoException {
        ArrayList<Contact> values = new ArrayList<>(list.values());


        //List <Contact> lastName =
        return values.stream()
                .filter(p->p.getLastname().equals(lastname))
                .collect(Collectors.toList());
    }

    @Override
    public List<Contact> getContactsByCity(String city) throws DaoException {

        ArrayList<Contact> values = new ArrayList<>(list.values());

        //List <Contact> cities =
        return values.stream()
                .filter(p->p.getCity().equals(city))
                .collect(Collectors.toList());
    }

    @Override
    public List<Contact> getContacts() throws DaoException {
        return new ArrayList<>(list.values());
    }

    @Override
    public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {
        ArrayList<Contact> values = new ArrayList<>(list.values());


        //List <Contact> dates =
        return values.stream()
                .filter(p->p.getBirthDate().after(from))
                .filter(p -> p.getBirthDate().before(to))
                .collect(Collectors.toList());
    }
}
