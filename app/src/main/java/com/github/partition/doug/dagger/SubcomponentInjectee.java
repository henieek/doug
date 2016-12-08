package com.github.partition.doug.dagger;

import javax.inject.Inject;

public class SubcomponentInjectee {

    @Inject
    Greeter greeter;

    public SubcomponentInjectee(DoughSubcomponent subcomponent) {
        subcomponent.inject(this);
    }

    public String greet() {
        return greeter.greet();
    }
}
