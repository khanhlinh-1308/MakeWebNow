package entity;

import java.io.Serializable;

import java.util.Date;

import jakarta.persistence.*;

@Entity

@Table(name = "Backups")

public class Backup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "BackupID")

    private Integer backupID;

    @Column(name = "BackupName")

    private String backupName;

    @Temporal(TemporalType.TIMESTAMP)

    @Column(name = "BackupDate")

    private Date backupDate;

    @Column(name = "FilePath")

    private String filePath;

    @Column(name = "Status")

    private String status;

    public Backup() {

    }

    public Integer getBackupID() {

        return backupID;

    }

    public void setBackupID(Integer backupID) {

        this.backupID = backupID;

    }

    public String getBackupName() {

        return backupName;

    }

    public void setBackupName(String backupName) {

        this.backupName = backupName;

    }

    public Date getBackupDate() {

        return backupDate;

    }

    public void setBackupDate(Date backupDate) {

        this.backupDate = backupDate;

    }

    public String getFilePath() {

        return filePath;

    }

    public void setFilePath(String filePath) {

        this.filePath = filePath;

    }

    public String getStatus() {

        return status;

    }

    public void setStatus(String status) {

        this.status = status;

    }

    @Override

    public String toString() {

        return backupName;

    }

}
