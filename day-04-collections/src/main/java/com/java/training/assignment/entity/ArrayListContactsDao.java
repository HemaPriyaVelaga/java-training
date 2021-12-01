package com.java.training.assignment.entity;

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
        Date dt = new Date();

        try {
            list.add(new Contact(1,"Hema", "Priya", Gender.FEMALE,"hemapriya@gmail.com", "8500903254", "Kukatpally", "Hyderabad", "Telangana", 500072, "India", sdf.parse("20/11/1997") ));
            list.add(new Contact(2,"Hima", "Bindu", Gender.FEMALE,"himabindu@gmail.com", "8519848992", "KPHB", "Hyderabad", "Telangana", 500072, "India", sdf.parse("21/02/2005") ));
            list.add(new Contact(3,"Kavitha", "Velaga", Gender.FEMALE,"kavitha@gmail.com", "9866366566", "Siripuram", "Guntur", "Andhra Pradesh", 111111, "India", sdf.parse("14/11/1974") ));
            list.add(new Contact(4,"Venu", "Velaga", Gender.MALE,"venuv@gmail.com", "9866366966", "Tenali", "Guntur", "Andhra Pradesh", 222222, "India", sdf.parse("27/05/1968") ));

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


        Contact cont = list.stream()
                .filter(customer -> id == customer.getId())
                .findAny()
                .orElse(null);

        return cont;

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
       // throw new DaoException("Method not yet implemented!");

    }

    @Override
    public Contact getContactByEmail(String email) throws DaoException {
        //throw new DaoException("Method not yet implemented!");


       List <Contact> emailContact = list.stream()
                .filter(p->p.getEmail().equals(email))
                .collect(Collectors.toList());
       if(emailContact.size()!=0)
        return emailContact.get(0);
       else return null;
        /*return (Contact) list.stream()
                .filter(p -> p.getEmail().equals(email));
        // Returning 1st find
        //return null;*/
    }

    @Override
    public Contact getContactByPhone(String phone) throws DaoException {
        //return null;
        //throw new DaoException("Method not yet implemented!");

        List <Contact> phones = list.stream()
                .filter(p->p.getPhone().equals(phone))
                .collect(Collectors.toList());
        if(phones.size()!=0)
            return phones.get(0);
        else return null;
    }

    @Override
    public List<Contact> getContactsByLastname(String lastname) throws DaoException {
        //throw new DaoException("Method not yet implemented!");
        List <Contact> lastName = list.stream()
                .filter(p->p.getLastname().equals(lastname))
                .collect(Collectors.toList());
        return lastName;
        // return null;
    }

    @Override
    public List<Contact> getContactsByCity(String city) throws DaoException {
        //throw new DaoException("Method not yet implemented!");

        //return null;

        List <Contact> cities = list.stream()
                .filter(p->p.getCity().equals(city))
                .collect(Collectors.toList());
        return cities;
    }

    @Override
    public List<Contact> getContacts() throws DaoException {
        //throw new DaoException("Method not yet implemented!");
        return this.list;
        //return null;
    }

    @Override
    public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {
        //throw new DaoException("Method not yet implemented!");

        List <Contact> dates = list.stream()
                .filter(p->p.getBirthDate().after(from))
                .filter(p -> p.getBirthDate().before(to))
                .collect(Collectors.toList());
        return dates;
        //return null;
    }
}
