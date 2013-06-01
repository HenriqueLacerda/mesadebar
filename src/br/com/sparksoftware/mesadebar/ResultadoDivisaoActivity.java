package br.com.sparksoftware.mesadebar;

import br.com.sparksoftware.mesadebar.adapters.AdapterListViewPedidos;
import br.com.sparksoftware.mesadebar.adapters.AdapterListViewPessoas;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class ResultadoDivisaoActivity extends Activity {

	private ListView listViewPedidoItens;
	private ListView listViewPessoas;
	private Button btnFechar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultado_divisao);
		this.carregarComponentes();
        this.carregarAcoes();
	}
	
	private void carregarComponentes()
    {
    	btnFechar = (Button) findViewById(R.id.btnFechar);
    	listViewPedidoItens = (ListView) findViewById(R.id.listViewDivisaoPedidoItens);
    	listViewPessoas = (ListView) findViewById(R.id.listViewDivisaoPessoas);
    }
    
    private void carregarAcoes()
    {
    	btnFechar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
    }

}
