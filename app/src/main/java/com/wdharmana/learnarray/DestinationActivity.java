package com.wdharmana.learnarray;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DestinationActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<String> lists = new ArrayList<>();

    String destinationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        listView = (ListView) findViewById(R.id.listView);

        destinationName = getIntent().getStringExtra("destinationname");

        if(destinationName.equals("Bali")) {

            lists.add("Tanah Lot");
            lists.add("Taman Sukasada");
            lists.add("Pantai Sanur");
            lists.add("Puri Ubud");
            lists.add("Benoa Watersport");

        } else if (destinationName.equals("Lombok")) {

            lists.add("Gili Trawangan");
            lists.add("Rinjani");
            lists.add("Mandalika");

        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                lists
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String name = lists.get(position);
                String shareText = "[TEST] Saat saya pergi ke "+destinationName+", saya akan mengunjungi "+name;

                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                shareIntent.setType("text/plain");
                startActivity(shareIntent);

            }
        });


    }


}
