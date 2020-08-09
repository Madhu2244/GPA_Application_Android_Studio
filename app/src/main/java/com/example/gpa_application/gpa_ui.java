package com.example.gpa_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class gpa_ui extends AppCompatActivity {
    Button convert;
    TextView numberOutput;
    EditText numInput;
    int convertNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa_ui);
        numInput = (EditText) findViewById(R.id.editText2);
        convert = (Button) findViewById(R.id.button3);
        numberOutput = (TextView) findViewById(R.id.textView3);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertNumber = Integer.valueOf(numInput.getText().toString());
                double[] gpa_conversion = new double[]{96.5,92.5,89.5,86.5,82.5,79.5,76.5,72.5,70.5,69.5,0};
                double[] reg_conversion = new double[] {4,3.8,3.6,3.4,3.2,3.0,2.8,2.6,2.4,2.0,0};
                double[] honor_conversion = new double[] {4.5,4.3,4.1,3.9,3.7,3.5,3.3,3.1,2.9,2.5,0};
                double[] ap_conversion = new double[] {5,4.8,4.6,4.4,4.2,4,3.8,3.6,3.4,3,0};
                int index = -1;
                for (int i = 0; i < gpa_conversion.length; i++)
                {
                    if (convertNumber >= gpa_conversion[i])
                    {
                        index = i;
                        break;
                    }
                }
                numberOutput.setText("Regular: " + reg_conversion[index] + "\nHonors: " + honor_conversion[index] + "\nAP: " + ap_conversion[index]);

            }
        });

    }

}
