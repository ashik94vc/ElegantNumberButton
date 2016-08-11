package com.cepheuen.elegantnumberbuttonsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ElegantNumberButton elegantNumberButton = (ElegantNumberButton) findViewById(R.id.number_button);
        final TextView textView = (TextView) findViewById(R.id.text_view);

        elegantNumberButton.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(elegantNumberButton.getNumber());
            }
        });
    }
}
