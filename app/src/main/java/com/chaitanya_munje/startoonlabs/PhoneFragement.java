package com.chaitanya_munje.startoonlabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;


/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneFragement extends Fragment {

    private FirebaseAuth mAuth;
    EditText edt_phone;
    FloatingActionButton fab;
    private PhoneFragement fragment;
    String phno;

    public PhoneFragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_phone, container, false);
        mAuth = FirebaseAuth.getInstance();
        edt_phone = view.findViewById(R.id.phone_edt);
        fab = view.findViewById(R.id.next_fab);
        fragment = new PhoneFragement();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                phno = edt_phone.getText().toString();

                if (phno.length() != 10) {

                    edt_phone.setError("Enter valid phone number");
                } else {

                    String phoneNumber = "+" + "91" + phno;

                    Bundle args = new Bundle();
                    args.putString("phno", phoneNumber);
                    Fragment fragment = new OTPFragement();
                    fragment.setArguments(args);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.phone_frag, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                }
            }
        });


        return view;

    }
}
