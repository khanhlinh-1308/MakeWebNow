package entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity

@Table(name = "TemplateKeywords")

public class TemplateKeyword implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "KeywordID")

    private Integer keywordID;

    @Column(name = "Keyword")

    private String keyword;

    @ManyToOne

    @JoinColumn(name = "TemplateID")

    private Template template;

    public TemplateKeyword() {

    }

    public Integer getKeywordID() {

        return keywordID;

    }

    public void setKeywordID(Integer keywordID) {

        this.keywordID = keywordID;

    }

    public String getKeyword() {

        return keyword;

    }

    public void setKeyword(String keyword) {

        this.keyword = keyword;

    }

    public Template getTemplate() {

        return template;

    }

    public void setTemplate(Template template) {

        this.template = template;

    }

    @Override

    public String toString() {

        return keyword;

    }

}
