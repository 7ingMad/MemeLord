package com.example.soone.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    Integer[] imgid={
            R.drawable.goodguygreg,
            R.drawable.jackywtf,
            R.drawable.onedoesnotsimply,
            R.drawable.scumbagsteve,
            R.drawable.thelistofpeople,
            R.drawable.whatifkeanu,
    };
    ListView list;
    String[] itemname = {
            "Good Guy Greg",
            "Jacky WTF",
            "One Does Not Simply",
            "Scumbag Steve",
            "The List of People",
            "What if Keanu"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Popular Memes");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        MemeListAdapter adapter = new MemeListAdapter(this, itemname, imgid);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem = itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, CaptionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("imgid", imgid[position]);
                intent.putExtras(bundle);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
