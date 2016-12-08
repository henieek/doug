package com.github.partition.doug;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.github.partition.doug.android.MainActivity;
import com.github.partition.doug.dagger.ActivityComponent;
import com.github.partition.doug.dagger.Greeter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class DougInstrumentationTest {

    private static final String TEST_GREET = "Test";

    private final Greeter fakeGreeter = new Greeter() {
        @Override
        public String greet() {
            return TEST_GREET;
        }
    };

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<MainActivity>(MainActivity.class) {
        @Override
        protected void beforeActivityLaunched() {
            TestDougApplication.setDougHook(new DougHook() {
                @Override
                void activityComponent(ActivityComponent activityComponent) {
                    Doug.mock(activityComponent, fakeGreeter, Greeter.class);
                }
            });
        }
    };

    @Test
    public void mocks_greeter() throws Exception {
        onView(withId(R.id.text)).check(matches(withText(TEST_GREET)));
    }
}
