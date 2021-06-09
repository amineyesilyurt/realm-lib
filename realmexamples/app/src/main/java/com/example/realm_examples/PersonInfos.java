package com.example.realm_examples;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@RealmClass
public class PersonInfos extends RealmObject {
    private String username;
    private String name;
    private String sex;
    private String pass;
}
