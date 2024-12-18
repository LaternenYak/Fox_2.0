package com.oni42.api.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "person_id") // Fremdschlüssel in der Measurement-Tabelle
    private List<Measurement> measurements = new ArrayList<>();

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Measurement> getMeasurements() { return measurements; }
    public void addMeasurement(Measurement measurement) {
        this.measurements.add(measurement);
    }
}
