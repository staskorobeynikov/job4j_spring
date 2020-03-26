package ru.job4j.police.repository;

import ru.job4j.police.model.Accident;

import java.util.List;

public interface Repository<T> {

    List<T> findAll();
}
