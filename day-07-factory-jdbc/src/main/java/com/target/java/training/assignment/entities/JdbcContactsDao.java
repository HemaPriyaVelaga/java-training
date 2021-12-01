package com.target.java.training.assignment.entities;

import com.target.java.training.utils.DbUtil;
import com.target.java.training.utils.KeyboardUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j

public class JdbcContactsDao implements ContactsDao {

    // Connecting to H2 jdbc server, creating table and inserting some elements by default
    public JdbcContactsDao()
    {
        String cmd = "Create table contacts(\n" +
                "id integer primary key,\n" +
                "firstname varchar(50) not null,\n" +
                "lastname varchar(50) not null,\n" +
                "gender varchar(50) not null,\n" +
                "email varchar(50) not null,\n" +
                "phone varchar(50) not null,\n" +
                "address varchar(50) not null,\n" +
                "city varchar(50) not null,\n" +
                "state varchar(50) not null,\n" +
                "pincode integer not null,\n" +
                "country varchar(50) not null,\n" +
                "birthDate date not null\n" +
                ");";


        String insertValues = "insert into contacts values (1, 'Venu', 'Velaga', 'MALE', 'venugopal@gmail.com', '9866366966', 'Tenali', 'Guntur', 'Andhra Pradesh', 222222, 'India', '1968-07-27'),\n" +
                "(2, 'Kavitha', 'Velaga', 'FEMALE', 'velagakavitha@gmail.com', '9866366566', 'Siripuram', 'Guntur', 'Andhra Pradesh', 111111, 'India','1972-11-14'),\n" +
                "(3, 'Hema', 'Priya', 'FEMALE', 'hemapriyavelaga@gmail.com', '8500903254', 'Kukatpally', 'Hyderabad', 'Telangana', 500072, 'India', '1997-11-20'),\n" +
                "(4, 'Hima', 'Bindu', 'FEMALE', 'himabinduvelaga@gmail.com', '8519848992', 'KPHB', 'Hyderabad', 'Telangana', 500072, 'India', '2005-02-21')";


         try(
                Connection conn = DbUtil.createConnection(); // Just establishes connection
                Statement stmt = conn.createStatement(); // To run the command in the DB
            )
        {
            stmt.execute(cmd); // Executes the Program in H2 Server
            log.debug("The SQL command was successfully executed server.");
            stmt.execute(insertValues);
            log.debug("Contacts table has been created with 4 initial contacts.");
        }// resources like connections get closed here
        catch (Exception e)
        {
            log.error("There was an error", e);
        }

    }

    @SneakyThrows
    @Override
    public void addContact(Contact contact) throws DaoException {

        String sql = "insert into contacts values (?,?,?,?,?,?,?,?,?,?,?,?)";
        int id = contact.getId();
        String firstname = contact.getFirstname();
        String lastname = contact.getLastname();
        Gender gender = contact.getGender();
        String email = contact.getEmail();
        String phone = contact.getPhone();
        String address = contact.getAddress();
        String city = contact.getCity();
        String state = contact.getState();
        Integer pincode = contact.getPincode();
        String country = contact.getCountry();
        Date birthDate = contact.getBirthDate();

        java.sql.Date sDate = new java.sql.Date(birthDate.getTime());
        String sgender = ((gender == Gender.FEMALE)? "FEMALE":"MALE");

        try(
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        )
        {
            try {

                stmt.setInt(1, id);
                stmt.setString(2, firstname);
                stmt.setString(3, lastname);
                stmt.setString(4, sgender);
                stmt.setString(5, email);
                stmt.setString(6, phone);
                stmt.setString(7, address);
                stmt.setString(8, city);
                stmt.setString(9, state);
                stmt.setInt(10, pincode);
                stmt.setString(11, country);
                stmt.setDate(12, sDate);


                stmt.execute();
                // Visit to DB server carrying the values to be assigned to the
                // Precompiled SQL command
                log.debug("New Product added with id = {}, firstname = {} and lastname = {}", id, firstname, lastname);

            } catch (Exception e) {
                log.warn("There was an error - {}", e.getMessage() );
            }
        }
        catch (Exception e)
        {
            log.debug("There was an error - " + e.getMessage());
        }
    }

    @Override
    public Contact getContact(int id) throws DaoException {
        List<Contact> listOfContacts= new ArrayList<>();
        String sql = "SELECT * FROM contacts WHERE id = ?";
        try(
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {

            stmt.setInt(1, id);

            try {

                ResultSet rs = stmt.executeQuery();
                listOfContacts =  getContactsAsListFromJdbc(rs);

            }

            catch (Exception ex)
            {
                log.debug("Error while displaying contacts!" + ex.getMessage());
            }
        }
        catch (Exception ex)
        {
            log.debug("Problem occurred! " + ex.getMessage());
        }

        return listOfContacts.get(0);
    }

    @Override
    public void updateContact(Contact contact) throws DaoException {


        int id = contact.getId();
        String firstname = contact.getFirstname();
        String lastname = contact.getLastname();
        Gender gender = contact.getGender();
        String email = contact.getEmail();
        String phone = contact.getPhone();
        String address = contact.getAddress();
        String city = contact.getCity();
        String state = contact.getState();
        Integer pincode = contact.getPincode();
        String country = contact.getCountry();
        Date birthDate = contact.getBirthDate();
        String sql = "UPDATE contacts SET firstname=?, lastname = ?, gender = ?, email = ?, phone =?, address = ?, " +
                "city = ?, state = ?, pincode = ?, country = ?, birthdate =?  WHERE id=? ;";

        java.sql.Date sDate = new java.sql.Date(birthDate.getTime());
        String sgender = ((gender == Gender.FEMALE)? "FEMALE":"MALE");

        try(
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        )
        {
            try {

                stmt.setString(1, firstname);
                stmt.setString(2, lastname);
                stmt.setString(3, sgender);
                stmt.setString(4, email);
                stmt.setString(5, phone);
                stmt.setString(6, address);
                stmt.setString(7, city);
                stmt.setString(8, state);
                stmt.setInt(9, pincode);
                stmt.setString(10, country);
                stmt.setDate(11, sDate);
                stmt.setInt(12, id);


                stmt.execute();
                // Visit to DB server carrying the values to be assigned to the
                // Precompiled SQL command
                log.debug("Contact with id = {}, firstname = {} and lastname = {} has been updated!", id, firstname, lastname);

            } catch (Exception e) {
                log.warn("There was an error - {}", e.getMessage() );
                e.printStackTrace();
            }
        }
        catch (Exception e)
        {
            log.debug("There was an error - " + e.getMessage());
        }
    }

    @Override
    public void deleteContact(int id) throws DaoException {
        String sql = "DELETE FROM contacts WHERE id = " + id + ";";

        try(
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
        ) {

            try {

                stmt.executeUpdate(sql);

            }

            catch (Exception ex)
            {
                log.debug("Error while deleting contacts!" + ex.getMessage());
            }
        }
        catch (Exception ex)
        {
            log.debug("Problem occurred! " + ex.getMessage());
        }
    }

    @Override
    public Contact getContactByEmail(String email) throws DaoException {
        List<Contact> listOfContacts= new ArrayList<>();

        try(
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
        ) {

            try {

                ResultSet rs = stmt.executeQuery("SELECT * FROM contacts WHERE email = '" + email + "'");

                listOfContacts =  getContactsAsListFromJdbc(rs);

            }

            catch (Exception ex)
            {
                log.debug("Error while displaying contacts!" + ex.getMessage());
            }
        }
        catch (Exception ex)
        {
            log.debug("Problem occurred! " + ex.getMessage());
        }

        if(listOfContacts.isEmpty())
        {
            return null;
        }
        else
        return listOfContacts.get(0);
    }

    @Override
    public Contact getContactByPhone(String phone) throws DaoException {
        List<Contact> listOfContacts= new ArrayList<>();

        try(
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
        ) {

            try {

                ResultSet rs = stmt.executeQuery("SELECT * FROM contacts WHERE phone = '" + phone + "'");

                listOfContacts =  getContactsAsListFromJdbc(rs);

            }

            catch (Exception ex)
            {
                log.debug("Error while displaying contacts!" + ex.getMessage());
            }
        }
        catch (Exception ex)
        {
            log.debug("Problem occurred! " + ex.getMessage());
        }

        if(listOfContacts.isEmpty())
        {
            return null;
        }
        else
            return listOfContacts.get(0);
    }

    @Override
    public List<Contact> getContactsByLastname(String lastname) throws DaoException {

        List<Contact> listOfContacts= new ArrayList<>();

        try(
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
        ) {

            try {

                ResultSet rs = stmt.executeQuery("SELECT * FROM contacts WHERE lastname = '" + lastname + "'");

                listOfContacts =  getContactsAsListFromJdbc(rs);

            }

            catch (Exception ex)
            {
                log.debug("Error while displaying contacts!" + ex.getMessage());
            }
        }
        catch (Exception ex)
        {
            log.debug("Problem occurred! " + ex.getMessage());
        }

        return listOfContacts;
    }

    @Override
    public List<Contact> getContactsByCity(String city) throws DaoException {
        List<Contact> listOfContacts= new ArrayList<>();

        try(
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
        ) {

            try {

                ResultSet rs = stmt.executeQuery("SELECT * FROM contacts WHERE city = '" + city + "'");

                listOfContacts =  getContactsAsListFromJdbc(rs);

            }

            catch (Exception ex)
            {
                log.debug("Error while displaying contacts!" + ex.getMessage());
            }
        }
        catch (Exception ex)
        {
            log.debug("Problem occurred! " + ex.getMessage());
        }

        return listOfContacts;
    }

    @Override
    public List<Contact> getContacts() throws DaoException {

        List<Contact> listOfContacts= new ArrayList<>();
        //String sql = "SELECT * FROM TASKS";
        try(
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
                ) {

            try {
                ResultSet rs = stmt.executeQuery("SELECT * FROM contacts");

                listOfContacts =  getContactsAsListFromJdbc(rs);
            }
            catch (Exception ex)
            {
                log.debug("Error while displaying contacts!" + ex.getMessage());
            }
        }
        catch (Exception ex)
        {
            log.debug("Problem occurred! " + ex.getMessage());
        }

        return listOfContacts;
    }

    @Override
    public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {

        List<Contact> listOfContacts= new ArrayList<>();

        try(
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
        ) {

            try {
                java.sql.Date fromDate = new java.sql.Date(from.getTime());
                java.sql.Date toDate = new java.sql.Date(to.getTime());
                ResultSet rs = stmt.executeQuery("SELECT * FROM contacts WHERE birthdate >= '"+ fromDate + "' AND birthdate <= '" + toDate +"'");

                listOfContacts =  getContactsAsListFromJdbc(rs);

                }

            catch (Exception ex)
            {
                log.debug("Error while displaying contacts!" + ex.getMessage());
            }
        }
        catch (Exception ex)
        {
            log.debug("Problem occurred! " + ex.getMessage());
        }

        return listOfContacts;
    }

    private List<Contact> getContactsAsListFromJdbc(ResultSet rs)
    {
        List<Contact> listOfContacts= new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String gender = rs.getString("gender");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String state = rs.getString("state");
                Integer pincode = rs.getInt("pincode");
                String country = rs.getString("country");

                Gender contactGender = ((gender.equals("MALE"))? Gender.MALE : Gender.FEMALE);
                java.sql.Date sDate = rs.getDate("birthdate");
                Date birthdate = new java.util.Date(sDate.getTime());
                ;

                Contact newContact = new Contact(id, firstname, lastname, contactGender, email, phone, address, city, state, pincode, country, birthdate);

                listOfContacts.add(newContact);

            }
        }
        catch (Exception ex)
        {
            log.debug("Error while retriving Information! " + ex.getMessage());
        }
        return listOfContacts;
    }
}
