package com.androidstudiocourse.c3t2_try2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmar_datos);

        TextView nameView1 = (TextView) findViewById(R.id.contactoName);
        nameView1.setText(getIntent().getExtras().getString("Name"));
        TextView nameView2 = (TextView) findViewById(R.id.contactoFecha);
        nameView2.setText(getIntent().getExtras().getString("Date"));
        TextView nameView3 = (TextView) findViewById(R.id.contactoPhone);
        nameView3.setText(getIntent().getExtras().getString("Phone"));
        TextView nameView4 = (TextView) findViewById(R.id.contactoMail);
        nameView4.setText(getIntent().getExtras().getString("Mail"));
        TextView nameView5 = (TextView) findViewById(R.id.contactoGeneral);
        nameView5.setText(getIntent().getExtras().getString("Descripcion"));

        Button b = (Button) findViewById(R.id.button_edit);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                //
                //
                startActivity(intent);
            }
        });
    }
}
