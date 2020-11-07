package com.appr.formula6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;

public class SignUpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;
    @BindView(R.id.retypePassword) EditText mRetypePassword;
    @BindView(R.id.nameEditText) EditText mNameEditText;
    @BindView(R.id.countrySpinner) Spinner mCountrySpinner;
    @BindView(R.id.userTypeSpinner) Spinner mUserTypeSpinner;
    @BindView(R.id.phoneEditText) EditText mPhoneEditText;
    @BindView(R.id.projectEditText) EditText mProjectEditText;
    @BindView(R.id.createUserButton) Button mCreateUserButton;
    @BindView(R.id.loginTextView) TextView mLoginTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Spinner spinner = findViewById(R.id.userTypeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.UserType, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((adapter));
        spinner.setOnItemSelectedListener(this);

        Spinner spinner2 = findViewById(R.id.countrySpinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter((adapter2));
        spinner2.setOnItemSelectedListener(this);

         mCreateUserButton.setOnClickListener(this);
         mLoginTextView.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        if (view == mLoginTextView) {
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        if (view == mCreateUserButton) {
            createNewUser();
        }
    }
}