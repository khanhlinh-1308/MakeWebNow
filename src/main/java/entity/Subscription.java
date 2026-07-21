package entity;

import java.io.Serializable;

import java.util.List;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity

@Table(name = "Subscriptions")

public class Subscription implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "PackageID")

    private Integer packageID;

    @Column(name = "PackageName", nullable = false)

    private String packageName;

    @Column(name = "Price", nullable = false)

    private BigDecimal price;

    @Column(name = "Duration", nullable = false)

    private Integer duration;

    @Column(name = "Description")

    private String description;

    @OneToMany(mappedBy = "subscription")

    private List<User> users;

    @OneToMany(mappedBy = "subscription")

    private List<Payment> payments;

    public Subscription() {

    }

    public Subscription(Integer packageID, String packageName, BigDecimal price,

            Integer duration, String description) {

        this.packageID = packageID;

        this.packageName = packageName;

        this.price = price;

        this.duration = duration;

        this.description = description;

    }

    public Integer getPackageID() {

        return packageID;

    }

    public void setPackageID(Integer packageID) {

        this.packageID = packageID;

    }

    public String getPackageName() {

        return packageName;

    }

    public void setPackageName(String packageName) {

        this.packageName = packageName;

    }

    public BigDecimal getPrice() {

        return price;

    }

    public void setPrice(BigDecimal price) {

        this.price = price;

    }

    public Integer getDuration() {

        return duration;

    }

    public void setDuration(Integer duration) {

        this.duration = duration;

    }

    public String getDescription() {

        return description;

    }

    public void setDescription(String description) {

        this.description = description;

    }

    public List<User> getUsers() {

        return users;

    }

    public void setUsers(List<User> users) {

        this.users = users;

    }

    public List<Payment> getPayments() {

        return payments;

    }

    public void setPayments(List<Payment> payments) {

        this.payments = payments;

    }

    @Override

    public String toString() {

        return packageName;

    }

}
