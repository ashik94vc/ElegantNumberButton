package com.cepheuen.elegantnumberbuttonsample;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class MainActivity extends AppCompatActivity {

  public static final String TAG = MainActivity.class.getSimpleName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    final ElegantNumberButton elegantNumberButton = findViewById(R.id.number_button);
    final ElegantNumberButton elegantNumberButton2 = findViewById(R.id.number_button2);

    final TextView textView = findViewById(R.id.text_view);

    final View contentView = findViewById(R.id.parent_view);
    elegantNumberButton.setRange(1, 5);
    elegantNumberButton.setOnClickListener(new ElegantNumberButton.OnClickListener() {
      @Override
      public void onClick(View view) {
        String number = elegantNumberButton.getNumber();
        textView.setText(number);
      }
    });
    elegantNumberButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
      @Override
      public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
        Snackbar.make(contentView, "Old Value: " + oldValue + " New Value: "
            + newValue, Snackbar.LENGTH_SHORT).show();
      }
    });

    elegantNumberButton2.setOnClickListener(new ElegantNumberButton.OnClickListener() {
      @Override
      public void onClick(View view) {
        String number = elegantNumberButton2.getNumber();
        textView.setText(number);
      }
    });

  }
}
