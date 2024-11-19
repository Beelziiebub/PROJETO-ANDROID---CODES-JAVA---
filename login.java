package com.example.q;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    // Declaração das variáveis dos elementos da interface
    private EditText editTextEmail, editTextPassword;
    private Button loginButton;
    private TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Define o layout para a activity

        // Inicializa os elementos da interface
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.loginButton);
        forgotPassword = findViewById(R.id.forgotPassword);

        // Configuração do listener para o botão de login
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtém os dados inseridos nos campos de e-mail e senha
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Validação simples dos campos (você pode personalizar conforme necessário)
                if (email.isEmpty()) {
                    Toast.makeText(login.this, "Por favor, insira o e-mail.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.isEmpty()) {
                    Toast.makeText(login.this, "Por favor, insira a senha.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Exemplo de validação fictícia para e-mail e senha
                if (email.equals("usuario@exemplo.com") && password.equals("senha123")) {
                    // Aqui você pode adicionar a navegação para uma nova Activity após o login bem-sucedido
                    Toast.makeText(login.this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(login.this, "E-mail ou senha incorretos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configuração do listener para o link "Esqueci a Senha"
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ação ao clicar em "Esqueci a senha", por exemplo, abrir uma nova Activity ou mostrar uma mensagem
                Toast.makeText(login.this, "Redirecionando para recuperação de senha...", Toast.LENGTH_SHORT).show();
            }


        });
    }
}
