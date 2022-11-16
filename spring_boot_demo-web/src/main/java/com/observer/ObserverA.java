package com.observer;

import org.springframework.stereotype.Component;

@Component
public class ObserverA implements Observer {
    @Override
    public void doSomeThing() {
        System.out.println("A do some thing");
    }
}
