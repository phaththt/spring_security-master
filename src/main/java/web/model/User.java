package web.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    private Long id;


    @Column(name = "name")
    private String name;


    @Column(name = "lastname")
    private String lastname;

    @Column(name = "age")
    private Long age;

    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;



    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinTable(name = "t_users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {

    }

    public User(String name, String lastname, Long age, String password, Set<Role> roles) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.roles = roles;
        this.password = password;

    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }
}


