package service;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import entity.Person;
import java.util.*;

public class CsvFakerGenerator {

    private static final Map<LocaleRegion, String[]> COUNTRIES = new HashMap<>();
    static {
        COUNTRIES.put(LocaleRegion.US, new String[]{"United States of America", "USA", "United States"});
        COUNTRIES.put(LocaleRegion.RU, new String[]{"Российская Федерация", "RUS", "Россия"});
        COUNTRIES.put(LocaleRegion.UKR, new String[]{"UKR", "Украина"});
    }

    public String getFakerToCsvFormat(LocaleRegion localeRegion) {
        Faker faker = new Faker(new Locale(localeRegion.getTitle()));

        String fullName = faker.name().fullName();

        StringBuilder sb = new StringBuilder();
        Address address = faker.address();

        String countryName = getCountryName(localeRegion);
        String cityName = address.city();
        String streetAddressName = address.streetAddress();
        String zipcodeName = address.zipCode();
        String phoneNumber = faker.phoneNumber().phoneNumber();

        sb.append(countryName).append(", ").append(cityName).append(", ").append(streetAddressName).append(", ").append(zipcodeName);
        Person person = Person.newBuilder()
                .setFullName(fullName)
                .setFullAddress(sb.toString())
                .setPhone(phoneNumber)
                .build();

        return (String.format("%s;%s;%s", person.getFullName(), person.getFullAddress(), person.getPhone()));
    }

    private String getCountryName(LocaleRegion localeRegion) {
        return COUNTRIES.get(localeRegion)[new Random().nextInt(COUNTRIES.get(localeRegion).length)];
    }
}
