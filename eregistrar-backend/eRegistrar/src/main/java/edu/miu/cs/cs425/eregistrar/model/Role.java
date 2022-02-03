package edu.miu.cs.cs425.eregistrar.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private Long roleId;
    @NotNull
    private String title;
    @ManyToMany(mappedBy="roles")
    private List<User> users;

    public Role() {
    }

    public Role(Long roleId, String title, List<User> users) {
        this.roleId = roleId;
        this.title = title;
        this.users = users;
    }

    public Role(String title, List<User> users) {
        this.title = title;
        this.users = users;
    }

    public Role(String title) {
        this.title = title;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(roleId, role.roleId) && title.equals(role.title) && Objects.equals(users, role.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, title, users);
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", title='" + title + '\'' +
                ", users=" + users +
                '}';
    }
}
