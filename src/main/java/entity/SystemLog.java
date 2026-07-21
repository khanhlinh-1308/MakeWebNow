package entity;

import java.io.Serializable;

import java.util.Date;

import jakarta.persistence.*;

@Entity

@Table(name = "SystemLogs")

public class SystemLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "LogID")

    private Integer logID;

    @Column(name = "LogLevel")

    private String logLevel;

    @Lob

    @Column(name = "Message")

    private String message;

    @Temporal(TemporalType.TIMESTAMP)

    @Column(name = "CreatedDate")

    private Date createdDate;

    @Column(name = "Solved")

    private Boolean solved;

    public SystemLog() {

    }

    public Integer getLogID() {

        return logID;

    }

    public void setLogID(Integer logID) {

        this.logID = logID;

    }

    public String getLogLevel() {

        return logLevel;

    }

    public void setLogLevel(String logLevel) {

        this.logLevel = logLevel;

    }

    public String getMessage() {

        return message;

    }

    public void setMessage(String message) {

        this.message = message;

    }

    public Date getCreatedDate() {

        return createdDate;

    }

    public void setCreatedDate(Date createdDate) {

        this.createdDate = createdDate;

    }

    public Boolean getSolved() {

        return solved;

    }

    public void setSolved(Boolean solved) {

        this.solved = solved;

    }

    @Override

    public String toString() {

        return logLevel;

    }

}
