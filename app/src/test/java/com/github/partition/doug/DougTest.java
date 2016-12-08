package com.github.partition.doug;

import com.github.partition.doug.dagger.ComponentInjectee;
import com.github.partition.doug.dagger.DaggerDoughComponent;
import com.github.partition.doug.dagger.DoughComponent;
import com.github.partition.doug.dagger.DoughSubcomponent;
import com.github.partition.doug.dagger.Greeter;
import com.github.partition.doug.dagger.SubcomponentInjectee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DougTest {

    private static final String TEST_GREETING = "Test";

    @Mock
    Greeter greeter;

    @Test
    public void handles_component_injections() throws Exception {
        when(greeter.greet()).thenReturn(TEST_GREETING);

        ComponentInjectee injectee = new ComponentInjectee(component());

        assertThat(injectee.greet()).isEqualTo(TEST_GREETING);
    }

    @Test
    public void handles_subcomponent_injections() throws Exception {
        when(greeter.greet()).thenReturn(TEST_GREETING);

        SubcomponentInjectee injectee = new SubcomponentInjectee(subcomponent());

        assertThat(injectee.greet()).isEqualTo(TEST_GREETING);
    }

    private DoughComponent component() {
        DoughComponent doughComponent = DaggerDoughComponent.create();
        Doug.mock(doughComponent, greeter);
        return doughComponent;
    }

    private DoughSubcomponent subcomponent() {
        DoughSubcomponent doughComponent = DaggerDoughComponent
                .create()
                .subcomponent();
        Doug.mock(doughComponent, greeter);
        return doughComponent;
    }
}