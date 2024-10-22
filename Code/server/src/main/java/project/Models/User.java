package project.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.Converters.RolesConverter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    int id;
    @Column(name="username")
    String username;
    @Column(name="password")
    String password;
    @OneToOne
    @JoinColumn(name = "user_details_id")
    UserDetails userDetails;
    @ManyToOne
    @JoinColumn(name="role_id")
    Role role;
}
