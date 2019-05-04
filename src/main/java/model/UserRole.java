package model;


import enums.Roles;


public class UserRole {

    private Integer id;
    private Roles roles;

    public UserRole(Integer id, Roles role) {
        this.id = id;
        this.roles = role;
    }

    public UserRole(Roles roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Roles getRole() {
        return roles;
    }

    public void setRole(Roles role) {
        this.roles = role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", role=" + roles +
                '}';
    }
}
