package entity;

import java.io.Serializable;

import java.util.Date;

import java.util.List;

import jakarta.persistence.*;

@Entity

@Table(name = "Users")

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "UserID")

    private Integer userID;

    @Column(name = "FullName", nullable = false)

    private String fullName;

    @Column(name = "Email", nullable = false, unique = true)

    private String email;

    @Column(name = "Password", nullable = false)

    private String password;

    @Column(name = "Phone")

    private String phone;

    @Column(name = "Avatar")

    private String avatar;

    @Column(name = "Status")

    private Boolean status;

    @Temporal(TemporalType.TIMESTAMP)

    @Column(name = "CreatedDate")

    private Date createdDate;

    // ================== Relationship ==================

    @ManyToOne

    @JoinColumn(name = "RoleID")

    private Role role;

    @ManyToOne

    @JoinColumn(name = "PackageID")

    private Subscription subscription;

    @OneToMany(mappedBy = "user")

    private List<Website> websites;

    @OneToMany(mappedBy = "user")

    private List<Payment> payments;

 
    // ================== Constructor ==================

    public User() {

    }

    // ================== Getter Setter ==================

    public Integer getUserID() {

        return userID;

    }

    public void setUserID(Integer userID) {

        this.userID = userID;

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

    public String getPassword() {

        return password;

    }

    public void setPassword(String password) {

        this.password = password;

    }

    public String getPhone() {

        return phone;

    }

    public void setPhone(String phone) {

        this.phone = phone;

    }

    public String getAvatar() {

        return avatar;

    }

    public void setAvatar(String avatar) {

        this.avatar = avatar;

    }

    public Boolean getStatus() {

        return status;

    }

    public void setStatus(Boolean status) {

        this.status = status;

    }

    public Date getCreatedDate() {

        return createdDate;

    }

    public void setCreatedDate(Date createdDate) {

        this.createdDate = createdDate;

    }

    public Role getRole() {

        return role;

    }

    public void setRole(Role role) {

        this.role = role;

    }

    public Subscription getSubscription() {

        return subscription;

    }

    public void setSubscription(Subscription subscription) {

        this.subscription = subscription;

    }

    public List<Website> getWebsites() {

        return websites;

    }

    public void setWebsites(List<Website> websites) {

        this.websites = websites;

    }

    public List<Payment> getPayments() {

        return payments;

    }

    public void setPayments(List<Payment> payments) {

        this.payments = payments;

    }


    @Override

    public String toString() {

        return fullName;

    }

}
