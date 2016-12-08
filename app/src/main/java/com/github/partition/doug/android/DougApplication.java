package com.github.partition.doug.android;

import android.app.Application;
import android.content.Context;

import com.github.partition.doug.dagger.ActivityComponent;
import com.github.partition.doug.dagger.DaggerActivityComponent;

public class DougApplication extends Application {

    private static DougApplication instance;

    public static DougApplication getInstance() {
        return instance;
    }

    public ActivityComponent activityComponent() {
        return DaggerActivityComponent.create();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        instance = this;
    }
}
