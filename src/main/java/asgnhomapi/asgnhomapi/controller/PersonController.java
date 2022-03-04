package asgnhomapi.asgnhomapi.controller;

import asgnhomapi.asgnhomapi.entity.Person;
import asgnhomapi.asgnhomapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/persons")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    //create
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody Person person) {
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    //findall
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getList() {
        ArrayList<Person> response = new ArrayList<>();
        response.addAll(personRepository.findAll());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    //findbyid
    @RequestMapping(method = RequestMethod.GET, path = "personid/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        Optional<Person> road = personRepository.findById(id);
        return new ResponseEntity<>(road, HttpStatus.OK);
    }

    //update
    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Person personupdate) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            Person person1 = person.get();
            person1.setName(personupdate.getName());
            person1.setAddress(personupdate.getAddress());
            person1.setMobilephone(personupdate.getMobilephone());
            person1.setCmnd(personupdate.getCmnd());
            person1.setBudget(personupdate.getBudget());
            personRepository.save(person1);
            return new ResponseEntity<>(person1,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
