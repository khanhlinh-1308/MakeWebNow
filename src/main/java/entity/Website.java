package entity;

import java.io.Serializable;

import java.util.Date;

import java.util.List;

import jakarta.persistence.*;

@Entity

@Table(name = "Websites")

public class Website implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "WebsiteID")

    private Integer websiteID;

    @Column(name = "WebsiteName")

    private String websiteName;

    @Column(name = "Description")

    private String description;

    @Column(name = "Domain")

    private String domain;

    @Column(name = "Version")

    private Integer version;

    @Column(name = "IsPublished")

    private Boolean isPublished;

    @Temporal(TemporalType.TIMESTAMP)

    @Column(name = "LastSaved")

    private Date lastSaved;

    @Temporal(TemporalType.TIMESTAMP)

    @Column(name = "CreatedDate")

    private Date createdDate;

    @Column(name = "Status")

    private Boolean status;
    
    @Column(name = "WebsiteContent", columnDefinition = "NVARCHAR(MAX)")

    private String websiteContent;

    // ============================

    // Relationship

    // ============================

    @ManyToOne

    @JoinColumn(name = "UserID")

    private User user;

    @ManyToOne

    @JoinColumn(name = "TemplateID")

    private Template template;

    @OneToMany(mappedBy = "website")

    private List<Block> blocks;

    // ============================

    // Constructor

    // ============================

    public Website() {

    }

    // ============================

    // Getter Setter

    // ============================

    public Integer getWebsiteID() {

        return websiteID;

    }

    public void setWebsiteID(Integer websiteID) {

        this.websiteID = websiteID;

    }

    public String getWebsiteName() {

        return websiteName;

    }

    public void setWebsiteName(String websiteName) {

        this.websiteName = websiteName;

    }

    public String getDescription() {

        return description;

    }

    public void setDescription(String description) {

        this.description = description;

    }

    public String getDomain() {

        return domain;

    }

    public void setDomain(String domain) {

        this.domain = domain;

    }

    public Integer getVersion() {

        return version;

    }

    public void setVersion(Integer version) {

        this.version = version;

    }

    public Boolean getIsPublished() {

        return isPublished;

    }

    public void setIsPublished(Boolean isPublished) {

        this.isPublished = isPublished;

    }

    public Date getLastSaved() {

        return lastSaved;

    }

    public void setLastSaved(Date lastSaved) {

        this.lastSaved = lastSaved;

    }

    public Date getCreatedDate() {

        return createdDate;

    }

    public void setCreatedDate(Date createdDate) {

        this.createdDate = createdDate;

    }

    public Boolean getStatus() {

        return status;

    }

    public void setStatus(Boolean status) {

        this.status = status;

    }

    public User getUser() {

        return user;

    }

    public void setUser(User user) {

        this.user = user;

    }

    public Template getTemplate() {

        return template;

    }

    public void setTemplate(Template template) {

        this.template = template;

    }

    public List<Block> getBlocks() {

        return blocks;

    }

    public void setBlocks(List<Block> blocks) {

        this.blocks = blocks;

    }
    
    public String getWebsiteContent() {

        return websiteContent;

    }

    public void setWebsiteContent(String websiteContent) {

        this.websiteContent = websiteContent;

    }

    @Override

    public String toString() {

        return websiteName;

    }

}