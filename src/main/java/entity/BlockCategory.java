package entity;

import java.io.Serializable;

import java.util.List;

import jakarta.persistence.*;

@Entity

@Table(name = "BlockCategory")

public class BlockCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "CategoryID")

    private Integer categoryID;

    @Column(name = "CategoryName")

    private String categoryName;

    @OneToMany(mappedBy = "category")

    private List<Block> blocks;

    public BlockCategory() {

    }

    public Integer getCategoryID() {

        return categoryID;

    }

    public void setCategoryID(Integer categoryID) {

        this.categoryID = categoryID;

    }

    public String getCategoryName() {

        return categoryName;

    }

    public void setCategoryName(String categoryName) {

        this.categoryName = categoryName;

    }

    public List<Block> getBlocks() {

        return blocks;

    }

    public void setBlocks(List<Block> blocks) {

        this.blocks = blocks;

    }

    @Override

    public String toString() {

        return categoryName;

    }

}