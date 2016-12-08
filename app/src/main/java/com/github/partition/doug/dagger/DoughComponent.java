package com.github.partition.doug.dagger;

import dagger.Component;

@Component
public interface DoughComponent {

    DoughSubcomponent subcomponent();

    void inject(ComponentInjectee injectee);
}
