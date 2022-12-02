package ru.vysokov.phonebook;

import static ru.vysokov.phonebook.R.color.grey;
import static ru.vysokov.phonebook.R.color.light_teal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewUserActivity extends AppCompatActivity {
    private static List<User> userList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        ImageView imageBack = (ImageView) findViewById(R.id.back);
        Intent mainActivity = new Intent(this, MainActivity.class);
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mainActivity);
            }
        });

        ImageView entityImg = (ImageView) findViewById(R.id.entityImg);
        EditText edit1 = (EditText) findViewById(R.id.edit1);
        EditText edit2 = (EditText) findViewById(R.id.edit2);
        EditText edit3 = (EditText) findViewById(R.id.edit3);
        EditText edit4 = (EditText) findViewById(R.id.edit4);
        EditText edit5 = (EditText) findViewById(R.id.edit5);
        EditText edit6 = (EditText) findViewById(R.id.edit6);
        Button buttonSave = (Button) findViewById(R.id.buttonSave);

        TextView navIndividual = (TextView) findViewById(R.id.navIndividual);
        TextView navCompany = (TextView) findViewById(R.id.navCompany);
        final boolean[] companyIsActive = {true};
        final boolean[] individualIsActive = {false};

        navIndividual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                individualIsActive[0] = true;
                companyIsActive[0] = false;
                entityImg.setImageResource(R.drawable.ic_avatar);
                navIndividual.setBackgroundResource(R.drawable.button_teal_left);
                navCompany.setBackgroundResource(R.drawable.button_grey_right);
                edit1.setHint("Имя");
                edit2.setHint("Телефон");
                edit3.setHint("Адрес");
                edit4.setHint("Возраст");
                edit5.setHint("Образование");
                edit6.setHint("Профессия");
            }
        });

        navCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                individualIsActive[0] = false;
                companyIsActive[0] = true;
                entityImg.setImageResource(R.drawable.ic_company);
                navIndividual.setBackgroundResource(R.drawable.button_grey_left);
                navCompany.setBackgroundResource(R.drawable.button_teal_right);
                edit1.setHint("Имя");
                edit2.setHint("Телефон");
                edit3.setHint("Адрес");
                edit4.setHint("E-mail");
                edit5.setHint("Деятельность");
                edit6.setHint("Штат");
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (individualIsActive[0] == true & companyIsActive[0] == false) {
                    userList.add(new Individual(
                            edit1.getText().toString(),
                            edit2.getText().toString(),
                            edit3.getText().toString(),
                            edit4.getText().toString(),
                            edit5.getText().toString(),
                            edit6.getText().toString()
                    ));
                }
                else if (individualIsActive[0] == false & companyIsActive[0] == true) {
                    userList.add(new Company(
                            edit1.getText().toString(),
                            edit2.getText().toString(),
                            edit3.getText().toString(),
                            edit4.getText().toString(),
                            edit5.getText().toString(),
                            edit6.getText().toString()
                    ));
                }
                startActivity(mainActivity);
            }
        });
    }

    public static List<User> getUserList() {
        return userList;
    }
}