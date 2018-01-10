package com.ingsw_20.forbob;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText locationIndirizzoText = findViewById(R.id.locationIndirizzoText);
        final EditText locationNameText = findViewById(R.id.locationNameText);
        final EditText nomeSettoreText = findViewById(R.id.nomeSettoreText);
        final EditText numeroPostiText = findViewById(R.id.numeroPostiText);
        Button inserisciButton = findViewById(R.id.inserisciButton);

        final EditText cercaText = findViewById(R.id.cercaText);
        Button cercaButton = findViewById(R.id.cercaButton);
        final TextView queryRis = findViewById(R.id.queryRis);

        final DBClass dbClass = new DBClass();
        inserisciButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(locationIndirizzoText.getText().toString()) &&
                        !TextUtils.isEmpty(locationNameText.getText().toString()) &&
                        !TextUtils.isEmpty(nomeSettoreText.getText().toString()) &&
                        !TextUtils.isEmpty(numeroPostiText.getText().toString())){

                    dbClass.insert(
                            locationNameText.getText().toString(),
                            creaLista(nomeSettoreText.getText().toString(), Integer.valueOf(numeroPostiText.getText().toString())),
                            locationIndirizzoText.getText().toString());
                }
            }
        });

        cercaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(cercaText.getText().toString())) {
                    queryRis.setText(dbClass.risultatoQuery(cercaText.getText().toString()));
                }
            }
        });
    }

    private List<PostiSettori> creaLista(String nomeSettore, Integer numeroPosti){
        List<PostiSettori> listaSettori = new ArrayList<>();

        listaSettori.add(new PostiSettori(nomeSettore,numeroPosti));

        return listaSettori;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
