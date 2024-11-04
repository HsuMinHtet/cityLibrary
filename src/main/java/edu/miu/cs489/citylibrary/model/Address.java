package edu.miu.cs489.citylibrary.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer address_Id;
    private String street;
    private String city;
    private String state;
    private Integer zip;
    @OneToOne(mappedBy = "primaryAddress",fetch = FetchType.LAZY)
    private Publisher publisher; //Foreign key is publisherId

    public Address(String street, String city, String state, Integer zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }
}
