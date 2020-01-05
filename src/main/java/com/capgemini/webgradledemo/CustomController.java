package com.capgemini.webgradledemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class CustomController {

    private static Map<Integer, Person> personMap = new HashMap<>();
    static {
        personMap.put(1, new Person(1, "Nishant", "Pune"));
        personMap.put(2, new Person(2, "Niranjan", "Lucknow"));
        personMap.put(3, new Person(3, "Nishant Niranjan", "Maharashtra"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> get(@PathVariable("id") String id){
        Person person =  personMap.get(Integer.valueOf(id));
        return (person==null)? ResponseEntity.noContent().build():ResponseEntity.ok(person);

    }

    @GetMapping("/count")
    public long getCount(){
       return personMap.size();

    }

    @PostMapping("/{name}/{city}")
    public ResponseEntity<Person> get(@PathVariable("name") String name, @PathVariable("city") String city){
        int id = personMap.size()+1;
        Person person = new Person(id, name, city);
        personMap.put(id, person);
        return ResponseEntity.ok(person);
    }
}
