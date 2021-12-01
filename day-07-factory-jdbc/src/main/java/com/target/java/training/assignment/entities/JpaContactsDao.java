package com.target.java.training.assignment.entities;

import com.target.java.training.utils.JpaUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
public class JpaContactsDao implements ContactsDao {

    @SneakyThrows
    public JpaContactsDao()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String myIndia = "India";
        Contact cont1 = new Contact(1,"Hema", "Priya", Gender.FEMALE,"hemapriya@gmail.com", "8500903254", "Kukatpally", "Hyderabad", "Telangana", 500072, myIndia, sdf.parse("20/11/1997") );
        Contact cont2 = new Contact(2,"Hima", "Bindu", Gender.FEMALE,"himabindu@gmail.com", "8519848992", "KPHB", "Hyderabad", "Telangana", 500072, myIndia, sdf.parse("21/02/2005") );
        Contact cont3 = new Contact(3,"Kavitha", "Velaga", Gender.FEMALE,"kavitha@gmail.com", "9866366566", "Siripuram", "Guntur", "Andhra Pradesh", 111111, myIndia, sdf.parse("14/11/1974") );
        Contact cont4 = new Contact(4,"Venu", "Velaga", Gender.MALE,"venuv@gmail.com", "9866366966", "Tenali", "Guntur", "Andhra Pradesh", 222222, myIndia, sdf.parse("27/05/1968") );

        EntityManager em = JpaUtil.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();
            em.persist(cont1);
            em.persist(cont2);
            em.persist(cont3);
            em.persist(cont4);
            tx.commit();

            log.debug("Contact table created with default entries.");
        } catch (Exception e) {
            tx.rollback();
            log.error("Error occurred " + e.getMessage());
            e.printStackTrace();
        }
        em.close();

    }

    @Override
    public void addContact(Contact contact) throws DaoException {

        EntityManager em = JpaUtil.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            em.persist(contact);
            tx.begin();
            em.persist(contact);
            tx.commit();
            log.debug("Contact data saved!");
        }
        catch (Exception e) {
            tx.rollback();
            log.error("Error occurred " + e.getMessage());
        }
        em.close();

    }

    @Override
    public Contact getContact(int id) throws DaoException {

        EntityManager em = JpaUtil.createEntityManager();
        Contact emp = em.find(Contact.class, id);
        em.close();
        if(emp==null)
        {
            log.debug("No data found for employee with id " + id);
            return null;
        }

        else
        {
            return emp;
        }
    }

    @Override
    public void updateContact(Contact contact) throws DaoException {

        EntityManager em = JpaUtil.createEntityManager();
        Contact emp = em.find(Contact.class,contact.getId());
        emp.setId(contact.getId());
        emp.setAddress(contact.getAddress());
        emp.setFirstname(contact.getFirstname());
        emp.setBirthDate(contact.getBirthDate());
        emp.setCountry(contact.getCountry());
        emp.setCity(contact.getCity());
        emp.setEmail(contact.getEmail());
        emp.setGender(contact.getGender());
        emp.setLastname(contact.getLastname());
        emp.setPhone(contact.getPhone());
        emp.setPincode(contact.getPincode());
        emp.setState(contact.getState());

        EntityTransaction tx = em.getTransaction();

        em.persist(emp);
        tx.begin();
        tx.commit();
        em.close();

    }

    @Override
    public void deleteContact(int id) throws DaoException {

        EntityManager em = JpaUtil.createEntityManager();
        Contact emp = em.find(Contact.class, id);
        if(emp==null)
        {
            log.debug("No data found for employee with id " + id);
        }
        else
        {
            em.getTransaction().begin();
            em.remove(emp);
            em.getTransaction().commit();
        }
        em.close();
    }

    @Override
    public Contact getContactByEmail(String email) throws DaoException {
        String jpql = "from com.target.java.training.assignment.entities.Contact where email = ?0 ";
        // JPA Query Landuage

        EntityManager em = JpaUtil.createEntityManager();

        TypedQuery<Contact> qru = em.createQuery(jpql, Contact.class);
        qru.setParameter(0,email);
        Contact contact = qru.getSingleResult();
        em.close();
        return contact;
    }

    @Override
    public Contact getContactByPhone(String phone) throws DaoException {

        String jpql = "from com.target.java.training.assignment.entities.Contact where phone = ?0 ";
        EntityManager em = JpaUtil.createEntityManager();

        TypedQuery<Contact> qru = em.createQuery(jpql, Contact.class);
        qru.setParameter(0,phone);
        Contact contact = qru.getSingleResult();
        em.close();
        return contact;
    }

    @Override
    public List<Contact> getContactsByLastname(String lastname) throws DaoException {

        String jpql = "from com.target.java.training.assignment.entities.Contact where lastname = ?0 ";
        EntityManager em = JpaUtil.createEntityManager();

        TypedQuery<Contact> qru = em.createQuery(jpql, Contact.class);
        qru.setParameter(0, lastname);
        List<Contact> list = qru.getResultList();
        em.close();
        return list;
    }

    @Override
    public List<Contact> getContactsByCity(String city) throws DaoException {

        String jpql = "from com.target.java.training.assignment.entities.Contact where city = ?0 ";
        EntityManager em = JpaUtil.createEntityManager();

        TypedQuery<Contact> qru = em.createQuery(jpql, Contact.class);
        qru.setParameter(0, city);
        List<Contact> list = qru.getResultList();
        em.close();
        return list;
    }

    @Override
    public List<Contact> getContacts() throws DaoException {

        String jpql = "from com.target.java.training.assignment.entities.Contact";
        EntityManager em = JpaUtil.createEntityManager();

        TypedQuery<Contact> qru = em.createQuery(jpql, Contact.class);

        List<Contact> list = qru.getResultList();
        em.close();
        return list;
    }

    @Override
    public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {

        String jpql = "from com.target.java.training.assignment.entities.Contact where birthdate >= ?0 and birthdate <= ?1";
        EntityManager em = JpaUtil.createEntityManager();

        TypedQuery<Contact> qru = em.createQuery(jpql, Contact.class);
        qru.setParameter(0, from);
        qru.setParameter(1, to);
        List<Contact> list = qru.getResultList();
        em.close();
        return list;
    }
}
