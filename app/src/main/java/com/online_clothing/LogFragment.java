package com.online_clothing;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LogFragment extends Fragment implements View.OnClickListener{

    private EditText etUsername, etPassword;
    private Button btnLoginn;


    public LogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_log, container, false);

        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);
        btnLoginn = view.findViewById(R.id.btnLoginn);

        btnLoginn.setOnClickListener(this);


        return view;

    }

    private void checkUser()
    {
        SharedPreferences sp = getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);

        String username = sp.getString("Username","");
        String password = sp.getString("Password","");

        if (username.equals(etUsername.getText().toString()) && password.equals(etPassword.getText().toString()))
        {
            Toast.makeText(getActivity(), "Succesfully Logged In", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LogFragment.this.getActivity(), MainActivity.class);
            startActivity(intent);

        }else
        {
            Toast.makeText(getActivity(), "Invalid Username or password", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean Validationn ()
    {

        boolean flag = true;

        if (etUsername.getText().toString().isEmpty()) {
            etUsername.setError("Enter Username");
            etUsername.requestFocus();
            flag = false;
        } else if (etPassword.getText().toString().isEmpty()) {
            etPassword.setError("Enter Password");
            flag = false;
        }
        return flag;
    }

    @Override
    public void onClick(View v) {

        if (Validationn())
        {
            checkUser();
        }

    }
}
