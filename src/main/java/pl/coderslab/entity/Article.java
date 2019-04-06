package pl.coderslab.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.validator.LimitCollection;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    @NotNull(message = "Can't be empty")
    @NotBlank(message = "Can't be empty")
    @Length(max = 200, message = "Has to be less than 200 characters")
    private String title;

    @ManyToOne(fetch = EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany(fetch = EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "articles_categories",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @NotEmpty(groups = None.class)
    @LimitCollection(limit = 1)
    private Set<Category> categories = new HashSet<Category>();

    @Column(length = 2000)
    @NotNull(message = "Can't be empty")
    @Length(min = 500, message = "Has to be at least 500 characters")
    private String content;

    @Column(columnDefinition = "DATETIME")
    private String created;

    @Column(columnDefinition = "DATETIME")
    private String updated;

    public Article() {
    }

    public Article(String title, Author author, Set<Category> categories, String content, String created, String updated) {
        this.title = title;
        this.author = author;
        this.categories = categories;
        this.content = content;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", categories=" + categories +
                ", content='" + content + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @PrePersist
    public void setCreatedDate() {
        this.setCreated(String.valueOf(LocalDateTime.now()));
    }

    @PreUpdate
    public void setUpdatedDate() {
        this.setUpdated(String.valueOf(LocalDateTime.now()));
    }
}
