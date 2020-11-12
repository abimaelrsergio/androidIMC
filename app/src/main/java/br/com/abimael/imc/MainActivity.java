package br.com.abimael.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TITULO = "Índice de Massa Corpórea";
    private EditText resultadoView;
    private EditText alturaView;
    private EditText pesoView;
    private Button btnCalcular;
    private Button btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(TITULO);
        buscarCampos();
        buscarBotoes();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.activity_main_btn_calcular) {
            calcularIMC();
        } else if (id == R.id.activity_main_btn_limpar){
            limparCampos();
        }
    }

    /**
     * Buscar os botẽos e Associa-los com a classe View.OnClickListener,
     * a qual está implementada aqui na MainActivity
     *
     */
    private void buscarBotoes() {
        btnCalcular = (Button)findViewById(R.id.activity_main_btn_calcular);
        btnLimpar = (Button)findViewById(R.id.activity_main_btn_limpar);
        btnCalcular.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);
    }

    /**
     * Buscar os campos da tela
     */
    private void buscarCampos() {
        alturaView = (EditText)findViewById(R.id.activity_main_altura);
        pesoView = (EditText)findViewById(R.id.activity_main_peso);
        resultadoView = (EditText)findViewById(R.id.activity_main_resultado);
    }

    /**
     * Limpar os campos da tela
     */
    private void limparCampos() {
        pesoView.setText("");
        alturaView.setText("");
        resultadoView.setText("");
    }

    /**
     * Calcular o IMC
     */
    private void calcularIMC() {
        double peso = Double.parseDouble(pesoView.getText().toString());
        double altura = Double.parseDouble(alturaView.getText().toString());
        double resultado = peso / Math.pow(altura, 2);
        resultadoView.setText(String.format("%.2f",resultado));
    }
}
