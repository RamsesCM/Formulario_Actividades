package com.radacode.ciclosvida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private EditText editTextName, editTextEmail, editTextDesc, editTextCel;
    private DatePicker datePicker;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextDesc = findViewById(R.id.editTextDesc);
        editTextCel = findViewById(R.id.editTextCel);
        datePicker = findViewById(R.id.calendarView);

        // Configurar el listener para capturar los cambios de fecha
        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Aquí puedes capturar la fecha seleccionada por el usuario
                // La fecha está representada por year, monthOfYear y dayOfMonth
                // Puedes guardarla en un String o realizar otras operaciones según tu lógica
                date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                // Ahora puedes usar la variable selectedDate como necesites
            }
        });
    }

    public void siguienteBtn(View view) {
        String name = editTextName.getText().toString();
        String mail = editTextEmail.getText().toString();
        String desc = editTextDesc.getText().toString();
        String cel = editTextCel.getText().toString();

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra(getResources().getString(R.string.pnombre),name);
        intent.putExtra(getResources().getString(R.string.pemail),mail);
        intent.putExtra(getResources().getString(R.string.pdesc),desc);
        intent.putExtra(getResources().getString(R.string.pcel),cel);
        intent.putExtra(getResources().getString(R.string.pfecha),date);

        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String name = data.getStringExtra(getResources().getString(R.string.pnombre));
            String email = data.getStringExtra(getResources().getString(R.string.pemail));
            String desc = data.getStringExtra(getResources().getString(R.string.pdesc));
            String cel = data.getStringExtra(getResources().getString(R.string.pcel));
            String date = data.getStringExtra(getResources().getString(R.string.pfecha));

            editTextName.setText(name);
            editTextEmail.setText(email);
            editTextDesc.setText(desc);
            editTextCel.setText(cel);

            // Establecer la fecha en el DatePicker
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date fecha = sdf.parse(date);
                Calendar cal = Calendar.getInstance();
                cal.setTime(fecha);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                datePicker.updateDate(year, month, day);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

}