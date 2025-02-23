package com.example.hospitalqueueingapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class queueUp extends AppCompatActivity {

    ImageButton back;
    Button proceed;
    Context context;
    EditText firstName;
    EditText lastName;
    EditText middleName;
    EditText houseAddress;
    EditText mobnum;
    TextView firstNameErrorText;
    TextView lastNameErrorText;
    TextView middleNameErrorText;
    TextView addressErrorText;
    TextView mobileNumberErrorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_queue_up);
        back = findViewById(R.id.btn_back);
        proceed = findViewById(R.id.btn_proceed);
        mobnum = findViewById(R.id.et_mobile_number);
        firstName = findViewById(R.id.et_first_name);
        lastName = findViewById(R.id.et_last_name);
        middleName = findViewById(R.id.et_middle_name);
        houseAddress = findViewById(R.id.et_house_address);
        firstNameErrorText = findViewById(R.id.tv_first_name_error);
        lastNameErrorText = findViewById(R.id.tv_last_name_error);
        middleNameErrorText = findViewById(R.id.tv_middle_name_error);
        addressErrorText = findViewById(R.id.tv_house_address_error);
        mobileNumberErrorText = findViewById(R.id.tv_mobile_number_error);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(queueUp.this, MainActivity.class);
                startActivity(intent);
            }
        });

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isValid = true;

                firstNameErrorText.setText("");
                lastNameErrorText.setText("");
                middleNameErrorText.setText("");
                mobileNumberErrorText.setText("");
                addressErrorText.setText("");

                if (firstName.getText().toString().trim().isEmpty()) {
                    firstNameErrorText.setText(getString(R.string.error_first_name_blank));
                    isValid = false;
                }

                if (lastName.getText().toString().trim().isEmpty()) {
                    lastNameErrorText.setText(getString(R.string.error_last_name_blank));
                    isValid = false;
                }

                if (middleName.getText().toString().trim().isEmpty()) {
                    middleNameErrorText.setText(getString(R.string.error_middle_name_blank));
                    isValid = false;
                }

                if (houseAddress.getText().toString().trim().isEmpty()) {
                    addressErrorText.setText(getString(R.string.error_house_address_blank));
                    isValid = false;
                }

                String mobNumText = mobnum.getText().toString().trim();
                if (mobNumText.isEmpty()) {
                    mobileNumberErrorText.setText(getString(R.string.error_mobile_number_blank));
                    isValid = false;
                } else if (!mobNumText.startsWith("09") || mobNumText.length() != 11) {
                    mobileNumberErrorText.setText(getString(R.string.error_invalid_mobile_number));
                    isValid = false;
                }


                if (isValid) {
                    Intent intent = new Intent(queueUp.this, DepartmentsActivity.class);
                    startActivity(intent);
                }
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.queueUp), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}