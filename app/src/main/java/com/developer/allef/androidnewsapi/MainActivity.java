package com.developer.allef.androidnewsapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Person[] personArray =  {new Person("Allef","Sousa"),new Person("Paulo","Sousa")};
        List<Person> list = Arrays.asList(personArray);
        Stream<Person> stream1 = list.stream();
        Optional<Person> resul = stream1.filter(person -> person.firstName.contains("Alle")).findFirst();

        resul.ifPresent(obj -> Log.d(MainActivity.class.getSimpleName(),"Nome= "+obj.firstName) );

//or
        Stream<Person> stream2 = Stream.of(personArray);

//or
        Stream.Builder<Person> streamBuilder = Stream.builder();
        for (Person p: personArray){
            streamBuilder.accept(p);
        }
        Stream<Person> stream3 = streamBuilder.build();


    }
}
