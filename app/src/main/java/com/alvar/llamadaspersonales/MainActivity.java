package com.alvar.llamadaspersonales;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;

import static android.Manifest.permission.CALL_PHONE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mnu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mnu_principal) {


        String telefono = "";

        switch (mnu_principal.getItemId()) {

            case R.id.opcion1:
                telefono = "682142166";
                break;
            case R.id.opcion2:
                telefono = "655444111";
                break;
            case R.id.opcion3:
                telefono = "666555888";
                break;
        }
        if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Intent i1 = new Intent(Intent.ACTION_CALL);
            i1.setData(Uri.parse("tel:" + telefono));
            startActivity(i1);
        } else {
            requestPermissions(new String[]{CALL_PHONE}, 1);
        }


            return true;
        }
    }


