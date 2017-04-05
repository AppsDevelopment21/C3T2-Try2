package com.androidstudiocourse.c3t2_try2;
import android.app.Dialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.support.v4.app.DialogFragment;

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.app.DatePickerDialog;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{


    public Button button_next;

    public void init(){
        button_next = (Button)findViewById(R.id.button_next);
        //button_next.setOnClickListener(new View.OnClickListener()
        //{
        //    @Override
        //    public void onClick(View v) {
        //Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        //intent.putExtra("Name", et1.getText().toString());
        //intent.putExtra("Date", et2.getText().toString());
        //intent.putExtra("Phone", et3.getText().toString());
        //intent.putExtra("Mail", et4.getText().toString());
        //intent.putExtra("Descripcion", et5.getText().toString());
        //startActivity(intent);
        //    }
        //});


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        til_mail = (TextInputLayout) findViewById(R.id.til_mail);
        til_phone = (TextInputLayout) findViewById(R.id.til_phone);
        til_name = (TextInputLayout) findViewById(R.id.til_name);

        //final EditText et1 = (EditText) findViewById(R.id.editName);
        //final TextView et2 = (TextView) findViewById(R.id.showDate);
        //final EditText et3 = (EditText) findViewById(R.id.editPhone);
        //final EditText et4 = (EditText) findViewById(R.id.editMail);
        //Button b = (Button) findViewById(R.id.button_next);

        //b.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        //        //
        //        intent.putExtra("Name", et1.getText().toString());
        //        intent.putExtra("Date", et2.getText().toString());
        //        intent.putExtra("Phone", et3.getText().toString());
        //        intent.putExtra("Mail", et4.getText().toString());
        //        //
        //        startActivity(intent);
        //    }
        //});

    }

    public void datePicker (View view) {

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "date");

    }

    private void setDate(final Calendar calendar){
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        ((TextView) findViewById(R.id.showDate)).setText(dateFormat.format(calendar.getTime()));
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int day){
        Calendar cal = new GregorianCalendar(year, month, day);
        setDate(cal);
    }

    public static class DatePickerFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(),
                    (DatePickerDialog.OnDateSetListener)
                            getActivity(), year, month, day);
        }


    }
    TextInputLayout til_mail;
    TextInputLayout til_name;
    TextInputLayout til_phone;
    //DATOS NOMBRE, TELEFONO, CORREO
    public void siguiente (View view){
        String mail = til_mail.getEditText().getText().toString().trim();
        String name = til_name.getEditText().getText().toString().trim();
        String phone = til_phone.getEditText().getText().toString().trim();
        //EDIT para que verifique si el nombre, mail y telefono están ingresados

        init();

        if (TextUtils.isEmpty(name)){
            til_name.setError("Nombre no ingresado");
            return;

        }
        if (TextUtils.isEmpty(phone)){
            til_phone.setError("Teléfono no ingresado");
            return;
        }
        if (TextUtils.isEmpty(mail)){
            til_mail.setError("Email no ingresado");
            return;
        }

        final EditText et1 = (EditText) findViewById(R.id.editName);
        final TextView et2 = (TextView) findViewById(R.id.showDate);
        final EditText et3 = (EditText) findViewById(R.id.editPhone);
        final EditText et4 = (EditText) findViewById(R.id.editMail);
        final EditText et5 = (EditText) findViewById(R.id.editDescripcion);

        //button_next.setOnClickListener(new View.OnClickListener()
        //{
        //    @Override
        //    public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("Name", et1.getText().toString());
                intent.putExtra("Date", et2.getText().toString());
                intent.putExtra("Phone", et3.getText().toString());
                intent.putExtra("Mail", et4.getText().toString());
                intent.putExtra("Descripcion", et5.getText().toString());
                startActivity(intent);
        //    }
        //});

    }

}
