package com.consumers.qms.features.appointment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.consumers.qms.R;

public class AppointmentActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnMakeAppointment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_appointment);
        btnMakeAppointment = findViewById(R.id.btnMakeAppointment);
        btnMakeAppointment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnMakeAppointment) {
            startActivity(new Intent(this, SpSearchActivity.class));
        }
    }
}
