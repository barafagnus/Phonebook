package ru.vysokov.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private static final String TAG = "test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageNewUser = (ImageView) findViewById(R.id.newUser);
        Intent newUserActivity = new Intent(this, NewUserActivity.class);

        imageNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(newUserActivity);
            }
        });

        ListView mainList = (ListView) findViewById(R.id.mainList);
        List<User> users = NewUserActivity.getUserList();

        PhoneAdapter phoneAdapter = new PhoneAdapter(this, users);
        mainList.setAdapter(phoneAdapter);



//        String userData = user.toString();
//        System.out.println("USERDATA\n" + userData);
//        buttonWrite.setOnClickListener(view -> {
//            try {
//                FileReadWrite.writeFile(userData);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//
//        buttonRead.setOnClickListener(view -> {
//            try {
//                FileReadWrite.readFile();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });

//        try {
//            JsonReadWrite.writeJson(user);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            JsonReadWrite.readJson();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}