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

    @GetMapping
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person nicht gefunden"));
    }


    @PostMapping
    public Person addPerson(@RequestParam String name) {
        Person person = new Person(name);
        return personRepository.save(person);
    }


    @PostMapping("/{id}/measurements")
    public Person addMeasurement(@PathVariable Long id, @RequestBody Measurement measurement) {
        return personRepository.findById(id).map(person -> {
            person.addMeasurement(measurement);
            return personRepository.save(person);
        }).orElseThrow(() -> new RuntimeException("Person nicht gefunden"));
    }
}
