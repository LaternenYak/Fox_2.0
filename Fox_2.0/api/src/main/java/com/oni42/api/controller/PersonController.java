package com.oni42.api.controller;

import com.oni42.api.model.Measurement;
import com.oni42.api.model.Person;
import com.oni42.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/people")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    // Alle Personen abrufen
    @GetMapping
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    // Einzelne Person abrufen
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person nicht gefunden"));
    }

    // Neue Person hinzufügen
    @PostMapping
    public Person addPerson(@RequestParam String name) {
        Person person = new Person(name);
        return personRepository.save(person);
    }

    // Messungen hinzufügen
    @PostMapping("/{id}/measurements")
    public Person addMeasurement(@PathVariable Long id, @RequestBody Measurement measurement) {
        return personRepository.findById(id).map(person -> {
            person.addMeasurement(measurement);
            return personRepository.save(person);
        }).orElseThrow(() -> new RuntimeException("Person nicht gefunden"));
    }

    // Messung löschen
    @DeleteMapping("/{personId}/measurements/{measurementId}")
    public Person deleteMeasurement(@PathVariable Long personId, @PathVariable Long measurementId) {
        return personRepository.findById(personId).map(person -> {
            person.getMeasurements().removeIf(m -> m.getId().equals(measurementId));
            return personRepository.save(person);
        }).orElseThrow(() -> new RuntimeException("Person nicht gefunden"));
    }
}
