package com.chaitanya_munje.startoonlabs;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResetCode extends Fragment {

    Button send_btn;
    public ResetCode() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_reset_code, container, false);
        send_btn=view.findViewById(R.id.send_btn);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] TO = {"support@pheezee.com"};
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, TO);
                intent.putExtra(Intent.EXTRA_SUBJECT, "assignment body - Chaitanya Munje");
                intent.putExtra(Intent.EXTRA_TEXT, "I don't have access code..");
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Choose an email client"));



            }
        });



        return view;
    }

}
