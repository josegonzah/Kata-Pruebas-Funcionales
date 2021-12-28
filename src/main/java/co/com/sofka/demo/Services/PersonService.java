package co.com.sofka.demo.Services;

import co.com.sofka.demo.Entities.Person;
import co.com.sofka.demo.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

@Service
public class PersonService {
    @Autowired
    PersonRepository repository;

    public Flux<Person> listAll(){
        return repository.findAll();
    }

    public Mono<Void> insert(Person capture){
        return validateBeforeInsert.apply(repository, capture)
                .switchIfEmpty(Mono.defer(() -> repository.save(capture)))
                .then();
    }

    private final BiFunction<PersonRepository, Person, Mono<Person>> validateBeforeInsert
            = (repo, person) -> repo.findByNombre(person.getNombre());
}
