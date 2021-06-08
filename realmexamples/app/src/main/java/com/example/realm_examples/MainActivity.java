package com.example.realm_examples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends Activity {
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = Realm.getDefaultInstance(); // opens "myrealm.realm"
        try {
           addPerson();
           showPersons();
        } finally {
            realm.close();
        }
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