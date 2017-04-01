package comc.example.medbeji.tp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class NoteActivity extends AppCompatActivity {


    ListView  notesList ;
    AutoCompleteTextView matiereTV;
    String[] mesNotes  = { "12.5","4.75","15","10.25","7.5","16.75"};

    String[] mesNotes1  = { "2","25","25","15.25","7.5","2.75"};
    String[] mesNotes2 = { "10.5","7.5","10","10.5","7.0","16.00"};
    String[] mesNotes3 = { "12.5","4.75","15","10.25","7.5","16.75"};

    List notes = new ArrayList<String[]>();
    String[] mesMatieres = {"Matiere1","Matiere2","Matiere3"};

    int[] icones = {R.drawable.happy, R.drawable.sad};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);


        notesList = (ListView) findViewById(R.id.notesList);
       // ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mesNotes);
       // notesList.setAdapter(listAdapter);
        notesList.setAdapter(new MaLigneAdapter(this, mesNotes));

        notesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int j, long l) {


            for(int i=0 ; i < mesNotes.length ; i++ ) {
                float note = Float.parseFloat(mesNotes[i]);

                if (note > 10){
                    Toast.makeText(getApplicationContext(),"Reussi !!!",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Echoué !!!",Toast.LENGTH_LONG).show();
                }

            }
            }

        });


        // AutoComplete Code

        notes.add(mesNotes1);
        notes.add(mesNotes2);
        notes.add(mesNotes3);

        matiereTV = (AutoCompleteTextView) findViewById(R.id.matieresTV);
        matiereTV.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,mesMatieres));

        matiereTV.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int j, long l) {
                String[] noteX = (String[]) notes.get(j) ;
               // ArrayAdapter<String> newListAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, noteX );
              MaLigneAdapter newListAdapter = new MaLigneAdapter( getApplicationContext() , noteX);
                notesList.setAdapter(newListAdapter);
            }
        });



    }




}
