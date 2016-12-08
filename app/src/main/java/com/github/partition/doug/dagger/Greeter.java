package com.github.partition.doug.dagger;

import javax.inject.Inject;

public class Greeter {

    private final Namer namer;

    @Inject
    public Greeter(Namer namer) {
        this.namer = namer;
    }

    public String greet() {
        return "Hello " + namer.getName();
    }
}
