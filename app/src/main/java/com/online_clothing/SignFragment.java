package com.online_clothing;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignFragment extends Fragment implements View.OnClickListener{

    private EditText etUsername, etPassword, etCPassword;
    private Button btnSignup, btnLogin;

    public SignFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sign, container, false);

        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);
        etCPassword = view.findViewById(R.id.etCPassword);
        btnSignup = view.findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        if(Validationn())
        {
            Signup();
        }

    }


    private void Signup()
    {
        SharedPreferences sp = getActivity().getSharedPreferences("User", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("Username", etUsername.getText().toString());
        editor.putString("Password", etPassword.getText().toString());
        editor.commit();

        Toast.makeText(getActivity(), "Successfully Registererd", Toast.LENGTH_SHORT).show();
    }

    public boolean Validationn ()
    {

        boolean flag = true;

        String a = etPassword.getText().toString();
        String b = etCPassword.getText().toString();

        if (etUsername.getText().toString().isEmpty()) {
            etUsername.setError("Enter Username");
            etUsername.requestFocus();
            flag = false;
        } else if (etPassword.getText().toString().isEmpty()) {
            etPassword.setError("Enter Password");
            flag = false;
        } else if (etCPassword.getText().toString().isEmpty()) {
            etCPassword.setError("Enter Confirm Password");
            flag = false;
        } else if (!(a.equals(b)))
        {
            etCPassword.setError("Confirm password doesnot match");
            flag = false;
        }
        return flag;
    }


}
