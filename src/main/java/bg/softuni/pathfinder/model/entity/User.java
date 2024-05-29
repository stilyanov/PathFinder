package bg.softuni.pathfinder.model.entity;

import bg.softuni.pathfinder.model.enums.LevelType;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column
    private Integer age;

    @Column
    private String email;

    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private LevelType userLevel;

    @ManyToMany
    private Set<Role> roles;

    public User() {
        roles = new HashSet<>();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LevelType getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(LevelType userLevel) {
        this.userLevel = userLevel;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
