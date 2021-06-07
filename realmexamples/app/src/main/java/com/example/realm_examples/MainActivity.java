package com.example.realm_examples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import io.realm.Realm;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm realm = Realm.getDefaultInstance(); // opens "myrealm.realm"
        try {
            // ... Do something ...
        } finally {
            realm.close();
        }
    }
}