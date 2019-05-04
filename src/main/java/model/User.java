package model;

public class User {
    private Integer id;
    private String name;
    private String lastname;
    private Integer age;
    private UserRole userRole;

    public User(Integer id, String name, String lastname, Integer age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }
    public User( String name, String lastname, Integer age, UserRole userRole) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.userRole = userRole;
    }

    public User(Integer id, String name, String lastname, Integer age, UserRole userRole) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.userRole = userRole;
    }


    public UserRole getUserRole() {
        return userRole;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", userRole=" + userRole +
                '}';
    }
}
