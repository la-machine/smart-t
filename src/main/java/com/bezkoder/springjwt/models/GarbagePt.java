package com.bezkoder.springjwt.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "garbage_point")
public class GarbagePt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String town;
    private String lat;
    private String lon;
    private LocalDate createdOn;
    @OneToOne
    private Board board;
    public LocalDate getCreatedOn() {
        return LocalDate.now();
    }
}
