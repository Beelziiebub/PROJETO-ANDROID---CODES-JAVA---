package com.example.q;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnContacts, btnSchedule, btnMyData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Layout da tela de boas-vindas

        // Associando os botões ao layout
        btnContacts = findViewById(R.id.btnContacts);
        btnSchedule = findViewById(R.id.btnSchedule);
        btnMyData = findViewById(R.id.btnMyData);

        // Adicionando listeners aos botões
        btnContacts.setOnClickListener(this);
        btnSchedule.setOnClickListener(this);
        btnMyData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnContacts) {
            // Navegar para a tela de Contatos
            Intent intent = new Intent(this, ContactsActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btnSchedule) {
            // Navegar para a tela de Agendamentos
            Intent intent = new Intent(this, ScheduleActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btnMyData) {
            // Navegar para a tela de Meus Dados
            Intent intent = new Intent(this, MyDataActivity.class);
            startActivity(intent);
        }
    }
}
