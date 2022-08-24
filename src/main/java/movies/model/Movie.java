package movies.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "MOVIES")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    @NotEmpty(message = "Movie name field can't be empty")
    private String name;

    @Column(name = "CATEGORY")
    @NotEmpty(message = "Movie category field can't be empty")
    private String category;

    @Column(name = "RATING")
    @Min(value = 1)
    @Max(value = 10)
    private int rating;

    @Column(name = "DESCRIPTION")
    @NotEmpty(message = "Movie description field can't be empty")
    private String description;

    public Movie() {
    }

    public Movie(Long id, String name, String category, int rating, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class MovieBuilder {

        private Long id;
        private String name;
        private String category;
        private int rating;
        private String description;

        public MovieBuilder setNameBuilder(String name) {
            this.name = name;
            return this;
        }

        public MovieBuilder setCategoryBuilder(String category) {
            this.category = category;
            return this;

        }

        public MovieBuilder setDescriptionBuilder(String description) {
            this.description = description;
            return this;
        }

        public MovieBuilder setRatingBuilder(int rating) {
            this.rating = rating;
            return this;
        }

        public MovieBuilder setIdBuilder(Long id) {
            this.id = id;
            return this;
        }

        public Movie build() {
            return new Movie(id, name, category, rating, description);
        }
    }
}
