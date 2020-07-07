package elerning.Model;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    private int id;

    @Column(name="USR_LOGIN")
    @NotNull
    private String login;

    @Column(name="USR_NAME")
    private String name;

    @Column(name="USR_SURNAME")
    private String surname;

    @Column(name="USR_ROLE")
    private String role;

    @Column(name="USR_PASSWORD")
    private String password;

    @Column(name="USR_EMAIL")
    @NotBlank(message = "Please enter email address")
    @Email(message = "Wrong email format")
    private String email;

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "USR_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles;

    public User() {
    }

    public User(String login,String name, String surname,  String password, String email ) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
