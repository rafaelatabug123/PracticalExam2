package com.example.rafaelatabug.practicalexam2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText examNumber1;
    EditText examNumber2;
    TextView viewAverage;
    Button btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        examNumber1 = (EditText) findViewById(R.id.examNumber1);
        examNumber2 = (EditText) findViewById(R.id.examNumber2);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);
        viewAverage = (TextView) findViewById(R.id.viewAverage);

        findViewById(R.id.btnDisplay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                String str_num1 = examNumber1.getText().toString();
                String str_num2 = examNumber2.getText().toString();
                int num1 = Integer.parseInt(str_num1);
                int num2 = Integer.parseInt(str_num2);
                int sum = (num1 + num2)/2;

                viewAverage.setText(Integer.toString(sum));
            }
        });

        String fName = firstName.getText().toString();
        String lName = lastName.getText().toString();
        String average = viewAverage.getText().toString();
        SharedPreferences sp = getSharedPreferences("My Data", MODE_PRIVATE);
        SharedPreferences.Editor writer = sp.edit();
        writer.putString("First Name",fName);
        writer.putString("Last Name",lName);
        writer.putString("Average", average);
        writer.commit();
        Toast.makeText(this,"Data is saved...",Toast.LENGTH_LONG).show();

    }

    public void saveData(View v){


    }



}
