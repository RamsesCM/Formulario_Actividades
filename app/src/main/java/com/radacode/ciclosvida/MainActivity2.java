package com.radacode.ciclosvida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tvName, tvDate, tvTel, tvEmail, tvDesc;
    String name, email, desc, cel, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle parametros = getIntent().getExtras();
        name = parametros.getString(getResources().getString(R.string.pnombre));
        email = parametros.getString(getResources().getString(R.string.pemail));
        desc = parametros.getString(getResources().getString(R.string.pdesc));
        cel = parametros.getString(getResources().getString(R.string.pcel));
        date = parametros.getString(getResources().getString(R.string.pfecha));

        tvName = (TextView) findViewById(R.id.tvName);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvTel = (TextView) findViewById(R.id.tvTel);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDesc = (TextView) findViewById(R.id.tvDesc);

        tvName.setText(getResources().getString(R.string.tvNameTxt) + " " + name);
        tvDate.setText(getResources().getString(R.string.tvDateTxt) + " " + date);
        tvTel.setText(getResources().getString(R.string.tvTelTxt) + " " + cel);
        tvEmail.setText(getResources().getString(R.string.tvEmailTxt) + " " + email);
        tvDesc.setText(getResources().getString(R.string.tvDescTxt) + " " + desc);
    }

    public void regresarBtn(View view){
        Intent intent = new Intent();
        intent.putExtra(getResources().getString(R.string.pnombre), name);
        intent.putExtra(getResources().getString(R.string.pemail), email);
        intent.putExtra(getResources().getString(R.string.pdesc), desc);
        intent.putExtra(getResources().getString(R.string.pcel), cel);
        intent.putExtra(getResources().getString(R.string.pfecha), date);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra(getResources().getString(R.string.pnombre), name);
        intent.putExtra(getResources().getString(R.string.pemail), email);
        intent.putExtra(getResources().getString(R.string.pdesc), desc);
        intent.putExtra(getResources().getString(R.string.pcel), cel);
        intent.putExtra(getResources().getString(R.string.pfecha), date);
        setResult(RESULT_OK, intent);
        finish();
    }

    /*public void regresarBtn(View view){
        Intent i = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent i = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(i);
        }
        return super.onKeyDown(keyCode, event);
    }*/
}