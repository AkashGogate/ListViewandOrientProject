package com.example.listviewandorientationproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public int index;

    ListView listView;
    ArrayList<Character> characterArrayList;
    CustomAdapter adapter;


    TextView weapon;


    TextView home;


    TextView description;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        listView = findViewById(R.id.listview);
        // listView.setBackgroundColor(Color.BLUE);


        weapon = findViewById(R.id.weapon);



        home = findViewById(R.id.home);


        description = findViewById(R.id.description);



        if(savedInstanceState!= null){
            home.setText(savedInstanceState.getCharSequence("home"));
            weapon.setText(savedInstanceState.getCharSequence("weapon"));

            description.setText(savedInstanceState.getCharSequence("description"));
            characterArrayList = savedInstanceState.getParcelableArrayList("characters");

        }else{
            characterArrayList = new ArrayList<Character>();
            characterArrayList.add(new Character("Jedi", "Tython", "A Jedi was a devotee to the ways of the Jedi Order, which have the power to harness the power of the Force. They often use this power to help others and allow people to prosper. Those who succumb to their own desires for power fall to the dark side.", R.drawable.jedi, "Lightsaber (Colors blue, green, yellow, purple, etc)"));
            characterArrayList.add(new Character("Sith", "Moraband", "The Dark Side. They are an evil race of force users that use their power for their own profit. They use their power to gain control and dominion over the galaxy. As a result, they have many conflicts with the Jedi, who are the protectors of peace", R.drawable.sith, "LightSaber(Red)"));
            characterArrayList.add(new Character("Mandalorian", "Mandal'or", "They are a race of fighters that know how to use a wide variety of weapons proficiently. They have a code of honor and will abide by it until their death. They are honorable fighters that they Jedi respect, but have multiple conflicts with", R.drawable.mandalorian, "Amban Sniper Rifle"));
            characterArrayList.add(new Character("Hutt","Tatooine/Nal Hutta", "They are a family of slug looking creatures that own a crime and gambling empire.they hire mercenaries to protect themselves, as they can't really fight on their own. They  mostly hire Gamorreans, who are the pig warriors that often fight with axes", R.drawable.hutt, "N/A"));
            characterArrayList.add(new Character("Mon Calamari", "Mon Cala", "They are a species of amphibian creatures with fins as hands. A particularly famous one is Admiral Akbar who is mostly known for his line \"Its a Trap\"", R.drawable.calamari, "Spear Blaster"));
            characterArrayList.add(new Character("Wookie", "Kashyyyk","They are monstrous creatures that look like bears but walk upright. They grow a few feet taller than humans and often like to defeat their enemies with brute force. They are great companions and will always fight for what's right.", R.drawable.wookie, "Bowcaster"));



        }
        adapter = new CustomAdapter(this, R.layout.adapter_layout, characterArrayList);
        adapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                home.setText("Homeworld: ");
                weapon.setText("Weapon: ");
                description.setText("Description: ");
            }
        });
        listView.setAdapter(adapter);















        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.setSelectedIndex(i);
                weapon.setText( "Weapon: " + characterArrayList.get(i).getWeapon());
                home.setText( "Homeworld: " + characterArrayList.get(i).getHome());



                description.setText("Description: " + characterArrayList.get(i).getDescription());


            }
        });

    }



    @Override
    protected void onSaveInstanceState (Bundle outState){
        Log.d("LIFECYCLETAG", "onSaveInstanceState()");

        outState.putCharSequence("weapon", weapon.getText());
        outState.putCharSequence("home", home.getText());

        outState.putCharSequence("description", description.getText());

        outState.putParcelableArrayList("characters", characterArrayList);
        super.onSaveInstanceState(outState);


    }

    @Override
    protected void onRestoreInstanceState (@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

    }


}