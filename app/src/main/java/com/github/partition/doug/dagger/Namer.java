package com.github.partition.doug.dagger;

import javax.inject.Inject;

public class Namer {

    @Inject
    Namer() {

    }

    public String getName() {
        return "Mateusz";
    }
}
