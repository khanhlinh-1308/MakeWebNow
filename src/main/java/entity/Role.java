package entity;

import java.io.Serializable;

import java.util.List;

import jakarta.persistence.*;

@Entity

@Table(name = "Roles")

public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "RoleID")

    private Integer roleID;

    @Column(name = "RoleName", nullable = false, unique = true)

    private String roleName;

    @OneToMany(mappedBy = "role")

    private List<User> users;

    @OneToMany(mappedBy = "role")

    private List<Permission> permissions;

    public Role() {

    }

    public Role(Integer roleID, String roleName) {

        this.roleID = roleID;

        this.roleName = roleName;

    }

    public Integer getRoleID() {

        return roleID;

    }

    public void setRoleID(Integer roleID) {

        this.roleID = roleID;

    }

    public String getRoleName() {

        return roleName;

    }

    public void setRoleName(String roleName) {

        this.roleName = roleName;

    }

    public List<User> getUsers() {

        return users;

    }

    public void setUsers(List<User> users) {

        this.users = users;

    }

    public List<Permission> getPermissions() {

        return permissions;

    }

    public void setPermissions(List<Permission> permissions) {

        this.permissions = permissions;

    }

    @Override

    public String toString() {

        return roleName;

    }

}