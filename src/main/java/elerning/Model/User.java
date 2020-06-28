package elerning.Model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    private int id;

    @Column(name="USR_LOGIN")
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
    private String email;

   /* @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="coruse_id")
    private List<Course> courses;*/

    public User() {
    }

    public User(String login,String name, String surname, String role, String password, String email ) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
}
