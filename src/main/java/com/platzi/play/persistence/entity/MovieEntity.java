package com.platzi.play.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="Movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150, unique = true)
    private String title;

    @Column(nullable = false, precision = 3)
    private Integer duration;

    @Column(nullable = false, length = 150)
    private String gender;

    @Column(nullable = false)
    private LocalDate movieDate;

    @Column(nullable = false, precision = 3, scale = 2)
    private BigDecimal clasification;

    @Column(nullable = false, length = 1)
    private String state;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(LocalDate movieDate) {
        this.movieDate = movieDate;
    }

    public BigDecimal getClasification() {
        return clasification;
    }

    public void setClasification(BigDecimal clasification) {
        this.clasification = clasification;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
