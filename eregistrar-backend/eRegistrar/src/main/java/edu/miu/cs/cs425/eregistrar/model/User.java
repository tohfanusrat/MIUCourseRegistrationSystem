package edu.miu.cs.cs425.eregistrar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;
    @NotNull
    @NotEmpty
    @NotBlank
    @Column(nullable = false, unique = true)
    private String userNumber;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String password;
    @Embedded
    private Address address;
    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="user_id", referencedColumnName="user_id")},
            inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="role_id")})
    private List<Role> roles;

    /*

     */

    public User() {
    }

    public User(Long userId, String userNumber, String firstName, String lastName, String password, Address address, List<Role> roles) {
        this.userId = userId;
        this.userNumber = userNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
        this.roles = roles;
    }

    public User(String userNumber, String firstName, String lastName, String password, Address address) {
        this.userNumber = userNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public String getPassword() {
//        return password;
//    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Address getAddress() {
//        return address;
//    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    public List<Role> getRoles() {
//        return roles;
//    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(userNumber, user.userNumber) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName)  && Objects.equals(password, user.password) && Objects.equals(address, user.address) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userNumber, firstName, lastName, password, address, roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userNumber='" + userNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                ", roles=" + roles +
                '}';
    }
}
