package co.com.sofka.demo.Controller;

import co.com.sofka.demo.Entities.Person;
import co.com.sofka.demo.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping
    public Mono<Void> post(@RequestBody Mono<Person> personMono){
//        return Mono.empty();
        return personMono.flatMap(personService::insert);
    }

    @GetMapping("/{id}")
    public Mono<Person> getPerson(@PathVariable("id") String id){
        return Mono.just(new Person());
    }

    @PutMapping
    public  Mono<Void> update (@RequestBody Mono<Person> personMono){
        return Mono.empty();
    }

    @DeleteMapping("/{id}")
    public  Mono<Void> delete (@PathVariable("id") String id){
        return Mono.empty();
    }

/*    @GetMapping
    public Flux<Person> list(){
        var persons = List.of(
                new Person("Raul Alzate"),
                new Person("Pedro")
        );
        return Flux.fromStream(persons.stream());
    }*/

    @GetMapping
    public Flux<Person> list(){
        return personService.listAll();
    }
}
