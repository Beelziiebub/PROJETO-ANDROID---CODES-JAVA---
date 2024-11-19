package com.example.q;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaCompraVendaAluguel extends AppCompatActivity implements View.OnClickListener {

    // Definindo os componentes da tela
    private Button btnFinalizarCompra;
    private EditText edtDescricaoProduto, edtPrecoProduto, edtNumeroCartao, edtValidadeCartao, edtCvvCartao, edtChavePix;
    private RadioGroup radioGroupTransacao, radioGroupPagamento;
    private LinearLayout layoutCartao, layoutPix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_compra_venda_aluga);  // Aqui é o layout que contém o XML

        // Aplicando Padding para os system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.TelaCompraVendaAluguel), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializando os componentes
        btnFinalizarCompra = findViewById(R.id.btnFinalizarCompra);
        edtDescricaoProduto = findViewById(R.id.edtDescricaoProduto);
        edtPrecoProduto = findViewById(R.id.edtPrecoProduto);
        edtNumeroCartao = findViewById(R.id.edtNumeroCartao);
        edtValidadeCartao = findViewById(R.id.edtValidadeCartao);
        edtCvvCartao = findViewById(R.id.edtCvvCartao);
        edtChavePix = findViewById(R.id.edtChavePix);

        radioGroupTransacao = findViewById(R.id.radioGroupTransacao);
        radioGroupPagamento = findViewById(R.id.radioGroupPagamento);

        layoutCartao = findViewById(R.id.layoutCartao);
        layoutPix = findViewById(R.id.layoutPix);

        // Definindo onClickListeners
        btnFinalizarCompra.setOnClickListener(this);
        radioGroupPagamento.setOnCheckedChangeListener((group, checkedId) -> {
            // Controla os campos de pagamento visíveis dependendo da seleção
            if (checkedId == R.id.rbCartao) {
                layoutCartao.setVisibility(View.VISIBLE);
                layoutPix.setVisibility(View.GONE);
            } else if (checkedId == R.id.rbPix) {
                layoutCartao.setVisibility(View.GONE);
                layoutPix.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnFinalizarCompra) {
            if (VerificaDados()) {
                // Aqui você processaria a transação e mostraria uma mensagem de sucesso
                Toast.makeText(getApplicationContext(), "Transação Finalizada com Sucesso!", Toast.LENGTH_LONG).show();
                // Você pode fazer uma transição para a tela de confirmação, por exemplo
                Intent intent = new Intent(this, TelaConfirmacao.class);
                startActivity(intent);
            }
        }
    }

    // Função que valida se os campos estão preenchidos corretamente
    public boolean VerificaDados() {
        String descricao = edtDescricaoProduto.getText().toString();
        String preco = edtPrecoProduto.getText().toString();

        if (descricao.isEmpty()) {
            Toast.makeText(getApplicationContext(), "O campo Descrição do Produto deve ser preenchido!", Toast.LENGTH_LONG).show();
            return false;
        }

        if (preco.isEmpty()) {
            Toast.makeText(getApplicationContext(), "O campo Preço deve ser preenchido!", Toast.LENGTH_LONG).show();
            return false;
        }

        // Valida se o usuário selecionou um método de pagamento
        int selectedPaymentId = radioGroupPagamento.getCheckedRadioButtonId();
        if (selectedPaymentId == -1) {
            Toast.makeText(getApplicationContext(), "Selecione um método de pagamento!", Toast.LENGTH_LONG).show();
            return false;
        }

        // Verifica os dados de pagamento
        if (selectedPaymentId == R.id.rbCartao) {
            if (edtNumeroCartao.getText().toString().isEmpty() ||
                    edtValidadeCartao.getText().toString().isEmpty() ||
                    edtCvvCartao.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Preencha todos os campos do Cartão de Crédito!", Toast.LENGTH_LONG).show();
                return false;
            }
        } else if (selectedPaymentId == R.id.rbPix) {
            if (edtChavePix.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Preencha a Chave PIX!", Toast.LENGTH_LONG).show();
                return false;
            }
        }

        return true;
    }
}
