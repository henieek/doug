package com.github.partition.doug.dagger;

import javax.inject.Inject;

public class ComponentInjectee {

    @Inject
    Greeter greeter;

    public ComponentInjectee(DoughComponent doughComponent) {
        doughComponent.inject(this);
    }

    public String greet() {
        return greeter.greet();
    }
}
