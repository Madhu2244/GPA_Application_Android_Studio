package com.example.gpa_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class semester_convert extends AppCompatActivity {
    EditText semester1;
    EditText semester2;
    EditText finalExam;
    TextView output;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_convert);
        semester1 = (EditText) findViewById(R.id.editText);
        semester2 = (EditText) findViewById(R.id.editText3);
        finalExam = (EditText) findViewById(R.id.editText4);
        calculate = (Button) findViewById(R.id.button5);
        output = (TextView) findViewById(R.id.textView3);
        output.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double convertNumber = Integer.valueOf(semester1.getText().toString()) *0.4 + Integer.valueOf(semester2.getText().toString()) * 0.4 + Integer.valueOf(finalExam.getText().toString()) *0.2;
                System.out.println(convertNumber);
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

                output.setText("Your average is " + convertNumber  + "\nRegular: " + reg_conversion[index] + "\nHonors: " + honor_conversion[index] + "\nAP: " + ap_conversion[index]);
                output.showContextMenu();

            }
        });
    }
}
