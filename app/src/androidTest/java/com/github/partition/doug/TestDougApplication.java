package com.github.partition.doug;

import com.github.partition.doug.android.DougApplication;
import com.github.partition.doug.dagger.ActivityComponent;

public class TestDougApplication extends DougApplication {

    private static DougHook hook = new DougHook() {
    };

    public static void setDougHook(DougHook dougHook) {
        hook = dougHook;
    }

    @Override
    public ActivityComponent activityComponent() {
        ActivityComponent activityComponent = super.activityComponent();
        hook.activityComponent(activityComponent);
        return activityComponent;
    }
}
