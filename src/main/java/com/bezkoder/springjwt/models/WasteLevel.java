package com.bezkoder.springjwt.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class WasteLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int wasteLevel;


}
