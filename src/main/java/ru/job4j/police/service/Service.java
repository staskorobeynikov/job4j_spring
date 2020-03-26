package ru.job4j.police.service;

import java.util.List;

public interface Service<T> {

    List<T> findAll();
}
