package ru.job4j.di;

import org.springframework.stereotype.Component;

@Component
public class StartUI {
    private Store store;

    private ConsoleInput input;

    public StartUI(Store store, ConsoleInput input) {
        this.store = store;
        this.input = input;
    }

    public void add() {
        String value = input.askStr("Введите строку для добавления в хранилище ");
        store.add(value);
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }
}
