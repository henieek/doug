package com.github.partition.doug.dagger;

import dagger.Subcomponent;

@Subcomponent
public interface DoughSubcomponent {
    void inject(SubcomponentInjectee injectee);
}
