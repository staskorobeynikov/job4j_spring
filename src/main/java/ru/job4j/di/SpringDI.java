package ru.job4j.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDI {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.job4j.di");
        context.refresh();
        StartUI first = context.getBean(StartUI.class);
        first.add();
        first.add();
        StartUI second = context.getBean(StartUI.class);
        second.add();
        second.add();
        second.print();
    }
}
