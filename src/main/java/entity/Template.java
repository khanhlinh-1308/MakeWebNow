package entity;

import java.io.Serializable;

import java.util.List;

import jakarta.persistence.*;
@Entity

@Table(name = "Templates")

public class Template implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "TemplateID")

    private Integer templateID;

    @Column(name = "TemplateName", nullable = false)

    private String templateName;

    @Column(name = "Category")

    private String category;

    @Column(name = "Thumbnail")

    private String thumbnail;

    @Column(name = "HtmlFile")

    private String htmlFile;

    @Column(name = "CssFile")

    private String cssFile;

    @Column(name = "PreviewImage")

    private String previewImage;

    @Column(name = "Status")

    private Boolean status;

    @OneToMany(mappedBy = "template")

    private List<Website> websites;

    @OneToMany(mappedBy = "template")

    private List<TemplateKeyword> templateKeywords;
    
    public Template() {

    }

    public Integer getTemplateID() {

        return templateID;

    }

    public void setTemplateID(Integer templateID) {

        this.templateID = templateID;

    }

    public String getTemplateName() {

        return templateName;

    }

    public void setTemplateName(String templateName) {

        this.templateName = templateName;

    }

    public String getCategory() {

        return category;

    }

    public void setCategory(String category) {

        this.category = category;

    }

    public String getThumbnail() {

        return thumbnail;

    }

    public void setThumbnail(String thumbnail) {

        this.thumbnail = thumbnail;

    }

    public String getHtmlFile() {

        return htmlFile;

    }

    public void setHtmlFile(String htmlFile) {

        this.htmlFile = htmlFile;

    }

    public String getCssFile() {

        return cssFile;

    }

    public void setCssFile(String cssFile) {

        this.cssFile = cssFile;

    }

    public String getPreviewImage() {

        return previewImage;

    }

    public void setPreviewImage(String previewImage) {

        this.previewImage = previewImage;

    }

    public Boolean getStatus() {

        return status;

    }

    public void setStatus(Boolean status) {

        this.status = status;

    }

    public List<Website> getWebsites() {

        return websites;

    }

    public void setWebsites(List<Website> websites) {

        this.websites = websites;

    }
    
    public List<TemplateKeyword> getTemplateKeywords() {

        return templateKeywords;

    }

    public void setTemplateKeywords(List<TemplateKeyword> templateKeywords) {

        this.templateKeywords = templateKeywords;

    }

    @Override

    public String toString() {

        return templateName;

    }

}