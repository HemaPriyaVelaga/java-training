package com.target.java.training.assignment.programs;

import com.target.java.training.assignment.entities.*;
import com.target.java.training.utils.DateUtil;
import com.target.java.training.utils.KeyboardUtil;
import lombok.SneakyThrows;

import java.util.Date;
import java.util.List;

public class ContactsFactoryApplication {
    ContactsDao daolist;

    public static void main(String[] args) {
        new ContactsFactoryApplication().start();
    }

    void start()
    {
        try {
            daolist = ContactsDaoFactory.getContactsDao();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        int choice;

        while ((choice = menu())!=0){

            switch (choice)
            {
                case 1:
                    System.out.println("Adding new Product..... ");
                    acceptAndAddProduct();
                    break;
                case 2:
                {

                    System.out.println("Listing all Products...");
                    listProducts();
                    break;
                }
                case 3:
                    System.out.println("Searching by lastname.....: ");
                    getByLastName();
                    break;
                case 4:
                    System.out.println("Searching by email address.....: ");
                    getByEmail();
                    break;
                case 5:
                    System.out.println("Searching by phone number....: ");
                    getByPhone();
                    break;

                case 6:
                    System.out.println("Searching by city....: ");
                    getByCity();
                    break;

                case 7:
                    System.out.println("Searching by DOB range.....: ");
                    searchDOBrange();
                    break;

                case 8:
                    deleteContact();
                    System.out.println("Deleting Contact....:");
                    break;

                case 9:
                    System.out.println("Editing Contact...Provide the necessary Details : ");
                    //editContact();
                    searchAndUpdate();

                    break;
                default: break;
            }
        }

        System.out.println("END OF THE SESSION! THANK YOU!");

    }

    @SneakyThrows
    private void searchAndUpdate()
    {
        try {
            int id = KeyboardUtil.getInt("Enter id of the contact to be edited: ");
            Contact p = daolist.getContact(id);

            if(p==null)
            {
                System.out.println("No product data found for id " + id);
                return;
            }
            String input;
            boolean changed = false;
            System.out.println("Enter product details. Hit ENTER to keep the previous value");

            input = KeyboardUtil.getString("Enter Contact First Name: (" + p.getFirstname() + ") ");
            if(!input.trim().equals(""))
            {
                p.setFirstname(input);
                changed = true;
            }

            input = KeyboardUtil.getString("Enter Contact Last Name: (" + p.getLastname() + ") ");
            if(!input.trim().equals(""))
            {
                p.setLastname(input);
                changed = true;
            }

            input = KeyboardUtil.getString("Enter Contact Gender: (" + p.getGender() + ") ");

            if(!input.trim().equals("")) {
                Gender gen = KeyboardUtil.getGender();
                p.setGender(gen);
            }

            input = KeyboardUtil.getString("Enter Contact Email: (" + p.getEmail() + ") ");
            if(!input.trim().equals(""))
            {
                p.setEmail(input);
                changed = true;
            }

            input = KeyboardUtil.getString("Enter Contact Phone: (" + p.getPhone() + ") ");
            if(!input.trim().equals(""))
            {
                p.setPhone(input);
                changed = true;
            }

            input = KeyboardUtil.getString("Enter Contact Address: (" + p.getAddress() + ") ");
            if(!input.trim().equals(""))
            {
                p.setAddress(input);
                changed = true;
            }

            input = KeyboardUtil.getString("Enter Contact City: (" + p.getCity() + ") ");
            if(!input.trim().equals(""))
            {
                p.setCity(input);
                changed = true;
            }

            input = KeyboardUtil.getString("Enter Contact State: (" + p.getState() + ") ");
            if(!input.trim().equals(""))
            {
                p.setState(input);
                changed = true;
            }

            input = KeyboardUtil.getString("Enter Contact Pin Code: (" + p.getPhone() + ") ");
            if(!input.trim().equals(""))
            {
                p.setPincode(Integer.parseInt(input));
                changed = true;
            }


            input = KeyboardUtil.getString("Enter Contact Country: (" + p.getCountry() + ") ");
            if(!input.trim().equals(""))
            {
                p.setCountry(input);
                changed = true;
            }

            input = KeyboardUtil.getString("Enter Contact Birth Date: (" + p.getBirthDate() + ") ");
            if(!input.trim().equals(""))
            {
                p.setBirthDate(DateUtil.toDate(input));
                changed = true;
            }

            if(!changed)
            {
                System.out.println("No changes made. So not updating the contact!");
            }

            daolist.updateContact(p);
        }

        catch (Exception e) {
            throw new com.target.java.training.dao.DaoException(e);
        }

    }

    private void editContact()
    {
        int id = KeyboardUtil.getInt("Enter id of the contact to be edited: ");
        try {
            printContact(daolist.getContact(id));
        } catch (DaoException e) {
            e.printStackTrace();
        }

        String firstname = KeyboardUtil.getString("Enter First Name: ");
        String lastname = KeyboardUtil.getString("Enter Last Name: ");
        Gender gender = Gender.MALE;
        while(true)
        {
            String sex = KeyboardUtil.getString("Enter gender (MALE or FEMALE): ");
            if(sex.equals("MALE"))
            {
                gender = Gender.MALE;
                break;
            }
            else if(sex.equals("FEMALE"))
            {
                gender = Gender.FEMALE;
                break;
            }
            else
            {
                System.out.println("Wrong input entered. Please enter MALE or FEMALE");
            }
        }
        String email = KeyboardUtil.getString("Enter Email ID: ");
        String phone = KeyboardUtil.getString("Enter Phone number: ");
        String address = KeyboardUtil.getString("Enter Address: ");
        String city = KeyboardUtil.getString("Enter City: ");
        String state = KeyboardUtil.getString("Enter State: ");
        Integer pincode = KeyboardUtil.getInt("Enter PIN code: ");
        String country = KeyboardUtil.getString("Enter Country: ");
        Date date = KeyboardUtil.getDate("Please enter your DOB in dd/MM/yyyy format: ");

        Contact p = new Contact(id, firstname, lastname, gender, email, phone, address, city, state, pincode, country, date);

        try {
            daolist.updateContact(p);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        System.out.println("Contact Updated successfully......!%nUpdated Contact:");
        try {
            printContact(daolist.getContact(id));
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    private void searchDOBrange()
    {
        Date first = KeyboardUtil.getDate("Enter beginning date in dd/MM/yyyy: ");
        Date last = KeyboardUtil.getDate("Enter ending date in dd/MM/yyyy: ");
        try {
            if(daolist.getContactsByBirthDate(first, last).size()!=0)
                printMultipleContacts(daolist.getContactsByBirthDate(first, last));

            else
                System.out.println("No contacts found!");
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }


    private void getByCity()
    {
        String city = KeyboardUtil.getString("Enter City of the desired contact: ");
        try {
            if(daolist.getContactsByCity(city).size()!=0)
                printMultipleContacts(daolist.getContactsByCity(city));

            else
                System.out.println("No contacts found!");
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }



    private void getByPhone()
    {
        String phone = KeyboardUtil.getString("Enter Phone no of the desired contact: ");
        try {
            if(daolist.getContactByPhone(phone)!=null)
                printContact(daolist.getContactByPhone(phone));

            else
                System.out.println("No contacts found!");
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }



    private void getByLastName()
    {
        String lastname = KeyboardUtil.getString("Enter Last name of the desired contact: ");
        try {
            if(daolist.getContactsByLastname(lastname).size()!=0)
                printMultipleContacts(daolist.getContactsByLastname(lastname));

            else
                System.out.println("No contacts found!");
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }



    private void getByEmail()
    {
        String email = KeyboardUtil.getString("Enter Email id of the desired contact: ");
        try {
            if(daolist.getContactByEmail(email)!=null)
                printContact(daolist.getContactByEmail(email));
            else
                System.out.println("No such contact found!");
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }



    private void printContact(Contact p)
    {
        line('=');
        System.out.printf("%10s %15s %15s %15s %20s %15s %15s %15s %15s %15s %15s %15s%n", "ID", "First Name", "Last Name", "Gender",
                "Email", "Phone", "Address", "City", "State", "PIN code", "Country", "Birth Date");
        line('=');
        System.out.printf("%10s %15s %15s %15s %20s %15s %15s %15s %15s %15s %15s %15s%n", p.getId(), p.getFirstname(), p.getLastname(),
                p.getGender(), p.getEmail(), p.getPhone(), p.getAddress(), p.getCity(),
                p.getState(), p.getPincode(), p.getCountry(), p.getBirthDate());
        line('=');
    }



    private void printMultipleContacts(List<Contact> lst)
    {
        line('=');
        System.out.printf("%10s %15s %15s %15s %20s %15s %15s %15s %15s %15s %15s %15s%n", "ID", "First Name", "Last Name", "Gender",
                "Email", "Phone", "Address", "City", "State", "PIN code", "Country", "Birth Date");
        line('=');
        for(Contact p:lst) {

            System.out.printf("%10s %15s %15s %15s %20s %15s %15s %15s %15s %15s %15s %15s%n", p.getId(), p.getFirstname(), p.getLastname(),
                    p.getGender(), p.getEmail(), p.getPhone(), p.getAddress(), p.getCity(),
                    p.getState(), p.getPincode(), p.getCountry(), p.getBirthDate());
        }
        line('=');
    }



    private void deleteContact()
    {
        int n = KeyboardUtil.getInt("Enter id of the contact to be deleted: ");
        try {
            daolist.deleteContact(n);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }



    static void line(char pattern)
    {
        for(int i=1;i<=230;i++)
        {
            System.out.print(pattern);
        }
        System.out.println();
    }


    private void acceptAndAddProduct (){

        try
        {
            int id = KeyboardUtil.getInt("Enter id: ");
            String firstname = KeyboardUtil.getString("Enter First Name: ");
            String lastname = KeyboardUtil.getString("Enter Last Name: ");
            Gender gender = Gender.MALE;
            while(true)
            {
                String sex = KeyboardUtil.getString("Enter gender (MALE or FEMALE): ");
                if(sex.equals("MALE"))
                {
                    gender = Gender.MALE;
                    break;
                }
                else if(sex.equals("FEMALE"))
                {
                    gender = Gender.FEMALE;
                    break;
                }
                else
                {
                    System.out.println("Wrong input entered. Please enter MALE or FEMALE");
                }
            }

            String email = KeyboardUtil.getString("Enter Email ID: ");
            String phone = KeyboardUtil.getString("Enter Phone number: ");
            String address = KeyboardUtil.getString("Enter Address: ");
            String city = KeyboardUtil.getString("Enter City: ");
            String state = KeyboardUtil.getString("Enter State: ");
            Integer pincode = KeyboardUtil.getInt("Enter PIN code: ");
            String country = KeyboardUtil.getString("Enter Country: ");
            Date date = KeyboardUtil.getDate("Please enter your DOB in dd/MM/yyyy format: ");

            Contact p = new Contact(id, firstname, lastname, gender, email, phone, address, city, state, pincode, country, date);
            daolist.addContact(p);
            System.out.println("Contact Added successfully......!");

        }
        catch (Exception ex)
        {
            System.out.println("Problem occurred!! ");
        }

    }



    private void listProducts(){

        try {
            List<Contact> list = daolist.getContacts();
            line('=');
            System.out.printf("%10s %15s %15s %15s %20s %15s %15s %15s %15s %15s %15s %15s%n", "ID", "First Name", "Last Name", "Gender",
                    "Email", "Phone", "Address", "City", "State", "PIN code", "Country", "Birth Date");
            line('=');
            for(Contact p:list)
            {
                System.out.printf("%10s %15s %15s %15s %20s %15s %15s %15s %15s %15s %15s %15s%n", p.getId(), p.getFirstname(), p.getLastname(),
                        p.getGender(), p.getEmail(), p.getPhone(), p.getAddress(), p.getCity(),
                        p.getState(), p.getPincode(), p.getCountry(), p.getBirthDate());
            }
            line('=');
        }
        catch (DaoException ex)
        {
            System.out.println("There was a problem :(");
        }
    }


    int menu()
    {
        int choice = -1;
        do{
            System.out.println("0. Exit");
            System.out.println("1. Add new Contact");
            System.out.println("2. List all products");
            System.out.println("3. Search by lastname");
            System.out.println("4. Search by email address");
            System.out.println("5. Search by phone number");
            System.out.println("6. Search by city");
            System.out.println("7. Search by date of birth range");
            System.out.println("8. Delete contact");
            System.out.println("9. Edit contact");
            try {
                choice = KeyboardUtil.getInt("Enter your choice: ");
                if(choice<0 || choice>9)
                {
                    System.out.println("Invalid choice. Retry!");
                }
            }
            catch (Exception ex)
            {
                System.out.println("Invalid choice. Retry!");
            }

        }while (choice <0 || choice >9);

        return choice;
    }
}
