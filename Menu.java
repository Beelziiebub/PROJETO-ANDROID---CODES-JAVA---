package com.example.q;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    // Declaração dos botões do menu
    private ImageButton btMNUContatos, btMNUAgendamento, btMNUMeusDados;
    private String email, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Inicializando os botões
        btMNUContatos = findViewById(R.id.btMNUContatos);
        btMNUAgendamento = findViewById(R.id.btMNUAgendamento);
        btMNUMeusDados = findViewById(R.id.btMNUMeusDados);

        // Adicionando os listeners de clique
        btMNUContatos.setOnClickListener(this);
        btMNUAgendamento.setOnClickListener(this);
        btMNUMeusDados.setOnClickListener(this);

        // Recebendo os parâmetros enviados pela intent
        Intent intencao = getIntent();
        if (intencao != null && intencao.getExtras() != null) {
            email = intencao.getStringExtra("email");
            senha = intencao.getStringExtra("senha");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btMNUContatos:
                // Ir para a tela de contatos
                Intent telaContatos = new Intent(this, MainActivity.class);
                startActivity(telaContatos);
                break;

            case R.id.btMNUAgendamento:
                // Ir para a tela de Agendamentos
                Intent telaAgendamento = new Intent(this, AgendamentoAtendimento.class);
                Bundle parametros = new Bundle();
                parametros.putString("email", email);
                parametros.putString("senha", senha);
                telaAgendamento.putExtras(parametros);
                startActivity(telaAgendamento);
                break;

            case R.id.btMNUMeusDados:
                // Ir para a tela de Meus Dados (Descomentado se implementado)
                // Intent telaMeusDados = new Intent(this, MeusDados.class);
                // startActivity(telaMeusDados);
                break;

            default:
                break;
        }
    }
}
