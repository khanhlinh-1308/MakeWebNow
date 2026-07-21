package entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity

@Table(name = "Permissions")

public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "PermissionID")

    private Integer permissionID;

    @Column(name = "PermissionName")

    private String permissionName;

    @ManyToOne

    @JoinColumn(name = "RoleID")

    private Role role;

    public Permission() {

    }

    public Integer getPermissionID() {

        return permissionID;

    }

    public void setPermissionID(Integer permissionID) {

        this.permissionID = permissionID;

    }

    public String getPermissionName() {

        return permissionName;

    }

    public void setPermissionName(String permissionName) {

        this.permissionName = permissionName;

    }

    public Role getRole() {

        return role;

    }

    public void setRole(Role role) {

        this.role = role;

    }

    @Override

    public String toString() {

        return permissionName;

    }

}