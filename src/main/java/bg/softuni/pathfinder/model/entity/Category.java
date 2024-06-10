package bg.softuni.pathfinder.model.entity;

import bg.softuni.pathfinder.model.enums.CategoryType;
import jakarta.persistence.*;


@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private CategoryType name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryType getName() {
        return name;
    }

    public void setName(CategoryType name) {
        this.name = name;
    }
}
