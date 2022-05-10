package com.example.restfulwebservices.versoning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping(path = "v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(path = "v2/person")
    public PersonV2 personV2(){
        Name name=new Name("Bob", "Charlie");
        return new PersonV2(name);
    }

    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramV2(){
        Name name=new Name("Bob", "Charlie");
        return new PersonV2(name);
    }


    @GetMapping(value = "/person/header",headers = "X_API_VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(value = "/person/header",headers = "X_API_VERSION=2")
    public PersonV2 headerV2(){
        Name name=new Name("Bob", "Charlie");
        return new PersonV2(name);
    }
}
