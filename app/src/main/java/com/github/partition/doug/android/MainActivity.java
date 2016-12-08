package com.github.partition.doug.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.partition.doug.R;
import com.github.partition.doug.dagger.DaggerActivityComponent;
import com.github.partition.doug.dagger.Greeter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Greeter greeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DougApplication.getInstance().activityComponent().inject(this);

        TextView text = (TextView) findViewById(R.id.text);
        text.setText(greeter.greet());
    }
}
