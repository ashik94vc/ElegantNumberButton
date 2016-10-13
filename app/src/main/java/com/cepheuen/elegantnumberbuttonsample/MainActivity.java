package com.cepheuen.elegantnumberbuttonsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ElegantNumberButton elegantNumberButton = (ElegantNumberButton) findViewById(R.id.number_button);
        final ElegantNumberButton elegantNumberButton2 = (ElegantNumberButton) findViewById(R.id.number_button2);
        final TextView textView = (TextView) findViewById(R.id.text_view);
        elegantNumberButton.setRange(1,5);
        elegantNumberButton.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = elegantNumberButton.getNumber();
                textView.setText(number);
                elegantNumberButton2.setNumber(number);
            }
        });
        elegantNumberButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                Log.d(TAG, String.format("oldValue: %d   newValue: %d", oldValue, newValue));
            }
        });

        elegantNumberButton2.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = elegantNumberButton2.getNumber();
                textView.setText(number);
                elegantNumberButton.setNumber(number);
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // setting a number out of range notifying listeners
                        elegantNumberButton.setNumber("200", true);
                    }
                });

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // setting a number in range without notifying listeners
                        elegantNumberButton.setNumber("1");
                    }
                });
            }
        }).start();

    }

    private ElegantNumberButton.OnValueChangeListener mOnValueChangeListener = new ElegantNumberButton.OnValueChangeListener() {
        @Override
        public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
            Log.d(TAG, String.format("oldValue: %d   newValue: %d", oldValue, newValue));
        }
    };
}
