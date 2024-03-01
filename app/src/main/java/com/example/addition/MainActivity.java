package com.example.addition;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtNumber1;
    private EditText edtNumber2;
    private Button btnAdd;
    private Button btnSubtract;
    private Button btnMultiply;
    private Button btnDivide;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        edtNumber1 = findViewById(R.id.edtNumber1);
        edtNumber2 = findViewById(R.id.edtNumber2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addClicked();
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subClicked();
            }
        });


        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mulClicked();
            }
        });


        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                divClicked();
            }
        });
    }

    private void addClicked() {
        NumberData numberData = getNumberData();
        if (numberData != null) {
            Double sum = numberData.getNumber1() + numberData.getNumber2();
            setResult(sum);
        }
    }

    private void subClicked() {
        NumberData numberData = getNumberData();
        if (numberData != null) {
            Double sub = numberData.getNumber1() - numberData.getNumber2();
            setResult(sub);
        }
    }

    private void mulClicked() {
        NumberData numberData = getNumberData();
        if (numberData != null) {
            Double mul = numberData.getNumber1() * numberData.getNumber2();
            setResult(mul);

        }
    }

    private void divClicked() {
        NumberData numberData = getNumberData();
        if (numberData != null) {
            Double div = numberData.getNumber1() / numberData.getNumber2();
            setResult(div);
        }
    }

    private NumberData getNumberData() {
        String e = edtNumber1.getText().toString();
        String f = edtNumber2.getText().toString();
        if (e.length() == 0 || f.length() == 0) {
            Toast.makeText(MainActivity.this, "Please enter the value", Toast.LENGTH_SHORT).show();
            return null;
        } else {
            Double num1 = Double.parseDouble(e);
            Double num2 = Double.parseDouble(f);
            return new NumberData(num1, num2);
        }
    }

    private void setResult(double value) {
        tvResult.setText(String.format("The calculated value is: %.2f", value));
        Toast.makeText(MainActivity.this, "Results are here", Toast.LENGTH_SHORT).show();
    }
}

