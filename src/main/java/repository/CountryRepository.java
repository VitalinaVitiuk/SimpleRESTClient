package repository;

import domain.City;
import domain.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CountryRepository {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");

    public Country save(Country country) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(country);
        em.flush();
        for (City city : country.getCities()) {
            city.setCountry(country);
            em.persist(city);
        }
        transaction.commit();
        return country;
    }
}
