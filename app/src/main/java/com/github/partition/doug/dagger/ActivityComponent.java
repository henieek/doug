package com.github.partition.doug.dagger;

import com.github.partition.doug.android.MainActivity;

import dagger.Component;

@Component
public interface ActivityComponent {

    void inject(MainActivity injectee);
}
