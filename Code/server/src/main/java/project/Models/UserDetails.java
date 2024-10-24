package project.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_details")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "firstname")
    String firstname;
    @Column(name = "lastname")
    String lastname;
    @Column(name = "email")
    String email;
    @Column(name = "phone")
    String phone;
    @Column(name = "icon_url")
    String iconUrl;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    Address address;
}
