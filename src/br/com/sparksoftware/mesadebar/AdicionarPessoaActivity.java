package br.com.sparksoftware.mesadebar;

import br.com.sparksoftware.mesadebar.adapters.AdapterListViewPedidos;
import br.com.sparksoftware.mesadebar.adapters.AdapterListViewPessoas;
import br.com.sparksoftware.mesadebar.model.Pessoa;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AdicionarPessoaActivity extends Activity {
	
	private EditText edtNome;
	private Button btnGravar;
	private Button btnCancelar;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_pessoa);
        this.carregarComponentes();
        this.carregarAcoes();
        
    }
    
    private void carregarComponentes()
    {
    	edtNome = (EditText) findViewById(R.id.edtNome);
    	btnGravar = (Button) findViewById(R.id.btnGravar);
    	btnCancelar = (Button) findViewById(R.id.btnCancelar);
    }
    
    private void carregarAcoes()
    {
    	btnGravar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(edtNome.getText().toString());
				PrincipalActivity.adapterListViewPessoas.add(pessoa);
				finish();
			}
		});
    	
    	btnCancelar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_adicionar_pessoa, menu);
        return true;
    }
}
