package com.wdharmana.learnarray;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spDestination;

    ArrayList<String> destinations = new ArrayList<>();

    String destinationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spDestination = (Spinner) findViewById(R.id.spDestination);

        destinations.add("Bali");
        destinations.add("Lombok");
        destinations.add("Bandung");

        ArrayAdapter<String> destinationAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, destinations);

        spDestination.setAdapter(destinationAdapter);

        spDestination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                destinationName = destinations.get(position);

                Toast.makeText(MainActivity.this,
                        destinationName, Toast.LENGTH_LONG
                        ).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button btnBrowse = (Button) findViewById(R.id.btnBrowse);

        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent destinationIntent = new Intent(MainActivity.this, DestinationActivity.class);
                destinationIntent.putExtra("destinationname", destinationName);
                startActivity(destinationIntent);
            }
        });

    }


}
