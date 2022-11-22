package ru.vysokov.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        Button buttonWrite = (Button) findViewById(R.id.buttonWrite);
        Button buttonRead = (Button) findViewById(R.id.buttonRead);
        User user = new User("asd", "asd", "asd");
        User user1 = new User("a2sd", "asd", "asd");
        Company eltex = new Company("Vasya1", "124", "spb", "asd@", "aaa", "gfd");
        Company eltex1 = new Company("Vasya2", "124", "spb", "asd@", "aaa", "gfd");
        Individual ind = new Individual("Vasya3", "124", "spb", "asdgag@", "aaa", "gfd");
        Individual ind1 = new Individual("Vasya3", "124", "spb", "asd333@", "aaa", "gfd");

        button.setOnClickListener(view -> {
            System.out.println(user.getId() + user.getName());
            System.out.println(user1.getId() + user1.getName());
            System.out.println(eltex.getId() + eltex.getName());
            System.out.println(eltex1.getId() + eltex1.getName());
            System.out.println(ind.getId() + ind.getName());
            System.out.println(ind1.getId() + ind1.getName());
        });

        buttonWrite.setOnClickListener(view -> {
            try {
                FileReadWrite.writeFile("asddd");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        buttonRead.setOnClickListener(view -> {
            try {
                FileReadWrite.readFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}