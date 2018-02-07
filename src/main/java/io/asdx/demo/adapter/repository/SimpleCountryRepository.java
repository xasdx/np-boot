package io.asdx.demo.adapter.repository;

import static java.util.Arrays.asList;

import io.asdx.demo.domain.model.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpleCountryRepository implements CountryRepository {

    private static final List<Country> countries = asList(
        Country.builder().id("0").name("Hungary").build(),
        Country.builder().id("1").name("Canada").build()
    );

    @Override
    public List<Country> getAllCountry() {
        return countries;
    }
}
