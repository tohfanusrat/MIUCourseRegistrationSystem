package edu.miu.cs.cs425.eregistrar.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Embeddable
public class Address implements ValueObject{
    private String buildingNo;
    private String street;
    private String city;
    private String postalCode;
    private String state;
    private String country;
    private String emailAddress;

    public Address() {
        // This constructor is for Hibernate's use only
    }

    public Address(String buildingNo, String street, String city, String postalCode, String state, String country, @NotNull String emailAddress) {
        this.buildingNo = buildingNo;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.state = state;
        this.country = country;
        this.emailAddress = emailAddress;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(buildingNo, address.buildingNo) && Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(postalCode, address.postalCode) && Objects.equals(state, address.state) && Objects.equals(country, address.country) && emailAddress.equals(address.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buildingNo, street, city, postalCode, state, country, emailAddress);
    }

    @Override
    public String toString() {
        return "Address{" +
                "buildingNo='" + buildingNo + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
