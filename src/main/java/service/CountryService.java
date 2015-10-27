package service;

import domain.Country;
import repository.CountryRepository;

public class CountryService {
    CountryRepository countryRepository = new CountryRepository();

    public Country save(Country country){
        return countryRepository.save(country);
    }
}
