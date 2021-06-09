package com.example.realm_examples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;
import lombok.ToString;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Realm realm;
    EditText username, name, pass;
    Button button;
    RadioGroup sexRG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance(); // opens "myrealm.realm"
        defining();
        insert();
        show();

    }



    public void defining(){
        listView=findViewById(R.id.listView);
        username=findViewById(R.id.editTextUserName);
        name=findViewById(R.id.editTextName);
        pass=findViewById(R.id.editTextPass);
        sexRG=findViewById(R.id.SexRadio);
        button=(Button)findViewById(R.id.btnAdd);

    }

    public void insert(){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username_= username.getText().toString();
                String name_= name.getText().toString();
                String pass_= pass.getText().toString();
                RadioButton radioButton_=findViewById(sexRG.getCheckedRadioButtonId());
                String sex_ = radioButton_.getText().toString();
                transaction(name_,username_,pass_,sex_);
                username.setText("");
                name.setText("");
                pass.setText("");
                sexRG.clearCheck();
                show();
            }
        });
    }
    private void show() {
        realm.beginTransaction();
        RealmResults<PersonInfos> results = realm.where(PersonInfos.class).findAll();
        realm.commitTransaction();
        if(results.size()>0) {
            Adapter adapter = new Adapter(results,getApplicationContext());
            listView.setAdapter(adapter);

        }
    }
    private void transaction(String theName, String theUsername, String thePass, String theSex) {
        realm.beginTransaction();
        PersonInfos infos = realm.createObject(PersonInfos.class);
        infos.setName(theName);
        infos.setUsername(theUsername);
        infos.setPass(thePass);
        infos.setSex(theSex);
        realm.commitTransaction();
    }


    public void addPerson(){
        realm.beginTransaction();
        PersonTable person= realm.createObject(PersonTable.class);
        person.setName("John");
        person.setSurname("Bill");
        person.setAge("24");
        person.setDegree("B.S.");
        realm.commitTransaction();
    }

    public void showPersons(){
        realm.beginTransaction();
        RealmResults<PersonTable> results= realm.where(PersonTable.class).findAll();
        for(PersonTable p:results){
            Log.i("Out",p.toString());
        }
        realm.commitTransaction();

    }
}