package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public void addFunction(View view){
        EditText input1 = (EditText) findViewById(R.id.input1);
        EditText input2 = (EditText) findViewById(R.id.input2);
        TextView result = (TextView) findViewById(R.id.Result);
        int sum = Integer.parseInt(input1.getText().toString()) + Integer.parseInt(input2.getText().toString());
        goToActivity(Integer.toString(sum));;
    }

    public void subFunction(View view){
        EditText input1 = (EditText) findViewById(R.id.input1);
        EditText input2 = (EditText) findViewById(R.id.input2);
        TextView result = (TextView) findViewById(R.id.Result);
        int diff = Integer.parseInt(input1.getText().toString()) - Integer.parseInt(input2.getText().toString());
        goToActivity(Integer.toString(diff));
    }

    public void divFunction(View view){
        EditText input1 = (EditText) findViewById(R.id.input1);
        EditText input2 = (EditText) findViewById(R.id.input2);
        TextView result = (TextView) findViewById(R.id.Result);
        int quotient = 0;
        try {
            quotient = Integer.parseInt(input1.getText().toString()) / Integer.parseInt(input2.getText().toString());
        } catch (Exception e) {
            goToActivity("Error: cannot divide by zero");
        }
        if (!(Integer.parseInt(input2.getText().toString()) == 0)) {
            goToActivity(Integer.toString(quotient));
        }
    }

    public void multFunction(View view){
        EditText input1 = (EditText) findViewById(R.id.input1);
        EditText input2 = (EditText) findViewById(R.id.input2);
        TextView result = (TextView) findViewById(R.id.Result);
        int product = Integer.parseInt(input1.getText().toString()) * Integer.parseInt(input2.getText().toString());
        goToActivity(Integer.toString(product));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToActivity(String s) {
        Intent intent = new Intent (this, Result.class);
        intent.putExtra("Message", s);
        startActivity(intent);
    }
}