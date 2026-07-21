package entity;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity

@Table(name = "Blocks")

public class Block implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "BlockID")

    private Integer blockID;

    @Column(name = "BlockType", length = 50)

    private String blockType;

    @Lob

    @Column(name = "Content")

    private String content;

    @Column(name = "Position")

    private Integer position;

    @Column(name = "Color")

    private String color;

    @Column(name = "FontSize")

    private Integer fontSize;

    @Column(name = "ImageUrl")

    private String imageUrl;

    @Column(name = "Width")

    private Integer width;

    @Column(name = "Height")

    private Integer height;

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "WebsiteID")

    private Website website;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryID")
    private BlockCategory category;

    public Block() {

    }

    public Integer getBlockID() {

        return blockID;

    }

    public void setBlockID(Integer blockID) {

        this.blockID = blockID;

    }

    public String getBlockType() {

        return blockType;

    }

    public void setBlockType(String blockType) {

        this.blockType = blockType;

    }

    public String getContent() {

        return content;

    }

    public void setContent(String content) {

        this.content = content;

    }

    public Integer getPosition() {

        return position;

    }

    public void setPosition(Integer position) {

        this.position = position;

    }

    public String getColor() {

        return color;

    }

    public void setColor(String color) {

        this.color = color;

    }

    public Integer getFontSize() {

        return fontSize;

    }

    public void setFontSize(Integer fontSize) {

        this.fontSize = fontSize;

    }

    public String getImageUrl() {

        return imageUrl;

    }

    public void setImageUrl(String imageUrl) {

        this.imageUrl = imageUrl;

    }

    public Integer getWidth() {

        return width;

    }

    public void setWidth(Integer width) {

        this.width = width;

    }

    public Integer getHeight() {

        return height;

    }

    public void setHeight(Integer height) {

        this.height = height;

    }

    public Website getWebsite() {

        return website;

    }

    public void setWebsite(Website website) {

        this.website = website;

    }
    
    public BlockCategory getCategory() {
        return category;
    }

    public void setCategory(BlockCategory category) {
        this.category = category;
    }
    
    @Override

    public String toString() {

        return blockType;

    }

}
