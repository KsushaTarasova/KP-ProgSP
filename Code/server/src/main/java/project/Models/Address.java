package project.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name="city")
    String city;
    @Column(name="street")
    String street;
    @Column(name="house_number")
    int houseNumber;
    @Column(name="flat_number")
    int flatNumber;
}
