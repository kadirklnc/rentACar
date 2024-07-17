package com.app.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "plate",unique = true)
    private String plate;
    private double dailyPrice;
    private int modelYear;
    private int state;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;


}
