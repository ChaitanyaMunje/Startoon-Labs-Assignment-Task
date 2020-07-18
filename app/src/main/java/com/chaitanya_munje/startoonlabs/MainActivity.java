package com.chaitanya_munje.startoonlabs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private PhoneFragement phoneFragement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneFragement=new PhoneFragement();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame1, phoneFragement)
                .commit();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void successmessage(){
        final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.success_dialog,null);

        alert.setView(mView);
        final AlertDialog alertDialog = alert.create();
        alertDialog.setCanceledOnTouchOutside(false);
        ImageButton btn_cancel = (ImageButton) mView.findViewById(R.id.cancel_btn);
        TextView time_txt=mView.findViewById(R.id.time_txt);
        Calendar calendar = Calendar.getInstance();
        String date = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        time_txt.setText(date);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
            }
        });
        alertDialog.show();
    }
}
