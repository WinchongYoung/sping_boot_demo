package com.observer;

import org.springframework.stereotype.Component;

@Component
public class ObserverB implements Observer {
    @Override
    public void doSomeThing() {
        System.out.println("B do some thing");
    }
}
