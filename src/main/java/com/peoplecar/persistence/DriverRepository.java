package com.peoplecar.persistence;

import com.peoplecar.domain.Driver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DriverRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public DriverRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Driver> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from com.peoplecar.domain.Driver").list();
    }

    public int create(Driver driver) {
        sessionFactory.getCurrentSession().save(driver);
        return driver.getId();
    }

    public Driver find(int id) {
        return (Driver) sessionFactory.getCurrentSession().get(Driver.class, id);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Driver driver = (Driver) session.get(Driver.class, id);
        session.delete(driver);
    }

    public void update(int id, Driver driver) {
        Session session = sessionFactory.getCurrentSession();
        Driver driverFromDB = (Driver) session.get(Driver.class, id);
        driverFromDB.setName(driver.getName());
        driverFromDB.setBirthday(driver.getBirthday());
        driverFromDB.setGender(driver.getGender());
        session.update(driverFromDB);
    }
}
