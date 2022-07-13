package com.mveril.documentationmanager.entity;

import java.net.URL;
import javax.persistence.*;

@Entity
@Table(name="documentations")
public class Documentation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER")
    private long id;    
    private String title;
    private URL url;
    private String description;
    @ManyToOne()
    @JoinColumn(name="category_id")
    private Category category;

    public Documentation() {
    }
    
    public Documentation(String title, URL url, String description) {
        this.title = title;
        this.url = url;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
