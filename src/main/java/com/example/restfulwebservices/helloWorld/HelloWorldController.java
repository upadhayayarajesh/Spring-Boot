package com.example.restfulwebservices.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

//controller
@RestController
public class HelloWorldController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world")
    public String HelloWorld() {
        return "Hello WOrld";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean HelloWorldBean() {
        System.out.println(new HelloWorldBean("Hello World"));
        return new HelloWorldBean("Hello World");
    }

    //hello-world/path-variable/in28Minutes.
    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWOrldPathVariable(@PathVariable String name) {
        System.out.println(new HelloWorldBean("Hello World"));
        return new HelloWorldBean(String.format("Hello WOrld, %s", name));
    }

    @GetMapping(path = "/hello-world-internalized")
    public String HelloWorldInternationalized(
//            @RequestHeader(name = "Accept-Language", required = false) Locale locale
    ) {
            return messageSource.getMessage("good.morning.message",null,"Default Message", LocaleContextHolder.getLocale());
//        return "Hello World";
    }


}
