package com.example.realm_examples;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RealmClass
public class PersonTable extends RealmObject {
    private String name;
    private String surname;
    private String degree;
    private String age;

}

