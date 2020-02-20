package com.example.programming_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double numberOfPrints = 0;
    double costOfPrints;

    double smallPrice = 0.19;
    double mediumPrice = 0.49;
    double largePrice = 0.79;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText printsInput = (EditText) findViewById(R.id.editText);
        final RadioButton smallPrint = (RadioButton) findViewById(R.id.radSmall);
        final RadioButton mediumPrint = (RadioButton) findViewById(R.id.radMedium);
        final RadioButton largePrint = (RadioButton) findViewById(R.id.radLarge);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button convert = (Button) findViewById(R.id.button);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(smallPrint.isChecked() == false && mediumPrint.isChecked() == false && largePrint.isChecked() == false) {
                    Toast.makeText(MainActivity.this, "Select on of the options below first!", Toast.LENGTH_LONG).show();
                } else {
                    numberOfPrints = Double.parseDouble(printsInput.getText().toString());
                    DecimalFormat tenth = new DecimalFormat("$##.##");

                    if(smallPrint.isChecked()){
                        costOfPrints = numberOfPrints * smallPrice;
                        result.setText("The order cost is " + tenth.format(costOfPrints));
                        smallPrint.setChecked(false);
                    }

                    if(mediumPrint.isChecked()){
                        costOfPrints = numberOfPrints * mediumPrice;
                        result.setText("The order cost is " + tenth.format(costOfPrints));
                        mediumPrint.setChecked(false);
                    }

                    if(largePrint.isChecked()){
                        costOfPrints = numberOfPrints * largePrice;
                        result.setText("The order cost is " + tenth.format(costOfPrints));
                        largePrint.setChecked(false);
                    }
                }
            }
        });
    }
}
