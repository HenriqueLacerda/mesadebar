package br.com.sparksoftware.mesadebar;

import br.com.sparksoftware.mesadebar.model.Item;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AdicionarPedidoActivity extends Activity {
	
	private EditText edtNome;
	private EditText edtQuantidade;
	private EditText edtValorUnitario;
	
	private Button btnGravar;
	private Button btnCancelar;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_pedido);
        this.carregarComponentes();
        this.carregarAcoes();
    }
    
    private void carregarComponentes()
    {
    	edtNome = (EditText) findViewById(R.id.edtNome);
    	edtQuantidade = (EditText) findViewById(R.id.edtQuantidade);
    	edtValorUnitario = (EditText) findViewById(R.id.edtValorUnitario);
    	
    	btnGravar = (Button) findViewById(R.id.btnGravar);
    	btnCancelar = (Button) findViewById(R.id.btnCancelar);
    }
    
    private void carregarAcoes()
    {
    	btnGravar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Item item = new Item();
				item.setNome(edtNome.getText().toString());
				item.setQuantidade(Double.parseDouble(edtQuantidade.getText().toString()));
				item.setValorUnitario(Double.parseDouble(edtValorUnitario.getText().toString()));
				item.setValorTotal(item.getQuantidade() * item.getValorUnitario());
				
				PrincipalActivity.adapterListViewPedidos.add(item);
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
        getMenuInflater().inflate(R.menu.activity_adicionar_pedido, menu);
        return true;
    }
}
