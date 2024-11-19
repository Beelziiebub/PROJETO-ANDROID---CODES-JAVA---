package com.example.q;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Menu extends AppCompatActivity implements View.OnClickListener {
    ImageButton btMNUContatos, btMNUAgendamento, btMNUMeusDados;
    String email, senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.menu), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        btMNUContatos = (ImageButton) findViewById(R.id.btMNUContatos);
        btMNUAgendamento = (ImageButton) findViewById(R.id.btMNUAgendamento);
        btMNUMeusDados = (ImageButton) findViewById(R.id.btMNUMeusDados);


        btMNUContatos.setOnClickListener(this);
        btMNUAgendamento.setOnClickListener(this);
        btMNUMeusDados.setOnClickListener(this);


        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();
        email = parametros.getString("email");
        senha = parametros.getString("senha");
    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btMNUContatos) {
            // ir para a tela de contatos (activity_main)
            Intent telaContatos = new Intent(this, MainActivity.class);
            startActivity(telaContatos);
        }
        if (v.getId()==R.id.btMNUMeusDados) {
            // ir para a tela de meus dados
            //Intent telaMeusDados = new Intent(this, MeusDados.class);
            //startActivity(telaMeusDados);
        }
        if (v.getId()==R.id.btMNUAgendamento) {
            // ir para a tela de Agendamentos
            Intent telaAgendamento = new Intent(this, AgendamentoAtendimento.class);
            Bundle parametros = new Bundle();
            parametros.putString("email",email);
            parametros.putString("senha",senha);
            telaAgendamento.putExtras(parametros);
            startActivity(telaAgendamento);
        }
    }
}
