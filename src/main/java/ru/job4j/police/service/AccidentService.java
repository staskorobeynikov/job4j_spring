package ru.job4j.police.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.job4j.police.model.Accident;
import ru.job4j.police.repository.Repository;

import java.util.List;

@Component
public class AccidentService implements Service<Accident> {

    private final Repository<Accident> repository;

    @Autowired
    public AccidentService(Repository<Accident> repository) {
        this.repository = repository;
    }

    @Override
    public List<Accident> findAll() {
        return repository.findAll();
    }
}
