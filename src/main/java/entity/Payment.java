package entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import jakarta.persistence.*;

@Entity

@Table(name = "Payments")

public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "PaymentID")

    private Integer paymentID;

    @Column(name = "PaymentMethod")

    private String paymentMethod;

    @Column(name = "Amount")

    private BigDecimal amount;

    @Column(name = "PaymentStatus")

    private String paymentStatus;

    @Temporal(TemporalType.TIMESTAMP)

    @Column(name = "PaymentDate")

    private Date paymentDate;

    @Column(name = "TransactionCode")

    private String transactionCode;

    @Temporal(TemporalType.TIMESTAMP)

    @Column(name = "ExpiredDate")

    private Date expiredDate;

    @Column(name = "Note")

    private String note;

    // ================= Relationship =================

    @ManyToOne

    @JoinColumn(name = "UserID")

    private User user;

    @ManyToOne

    @JoinColumn(name = "PackageID")

    private Subscription subscription;

    // ================= Constructor =================

    public Payment() {

    }

    // ================= Getter & Setter =================

    public Integer getPaymentID() {

        return paymentID;

    }

    public void setPaymentID(Integer paymentID) {

        this.paymentID = paymentID;

    }

    public String getPaymentMethod() {

        return paymentMethod;

    }

    public void setPaymentMethod(String paymentMethod) {

        this.paymentMethod = paymentMethod;

    }

    public BigDecimal getAmount() {

        return amount;

    }

    public void setAmount(BigDecimal amount) {

        this.amount = amount;

    }

    public String getPaymentStatus() {

        return paymentStatus;

    }

    public void setPaymentStatus(String paymentStatus) {

        this.paymentStatus = paymentStatus;

    }

    public Date getPaymentDate() {

        return paymentDate;

    }

    public void setPaymentDate(Date paymentDate) {

        this.paymentDate = paymentDate;

    }

    public String getTransactionCode() {

        return transactionCode;

    }

    public void setTransactionCode(String transactionCode) {

        this.transactionCode = transactionCode;

    }

    public Date getExpiredDate() {

        return expiredDate;

    }

    public void setExpiredDate(Date expiredDate) {

        this.expiredDate = expiredDate;

    }

    public String getNote() {

        return note;

    }

    public void setNote(String note) {

        this.note = note;

    }

    public User getUser() {

        return user;

    }

    public void setUser(User user) {

        this.user = user;

    }

    public Subscription getSubscription() {

        return subscription;

    }

    public void setSubscription(Subscription subscription) {

        this.subscription = subscription;

    }

    @Override

    public String toString() {

        return transactionCode;

    }

}
