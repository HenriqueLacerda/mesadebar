package br.com.sparksoftware.mesadebar;

import java.util.List;

import br.com.sparksoftware.mesadebar.adapters.AdapterListViewPedidos;
import br.com.sparksoftware.mesadebar.adapters.AdapterListViewPessoas;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;

public class PrincipalActivity extends Activity {

	private ImageView imgViewAddPessoas;
	private ImageView imgViewAddPedidos;
	private ListView listViewPessoas;
	private ListView listViewPedidos;
	public static AdapterListViewPessoas adapterListViewPessoas;
	public static AdapterListViewPedidos adapterListViewPedidos;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        this.carregarComponentes();
        this.carregarAcoes();

    }
   
    private void carregarComponentes()
    {
    	imgViewAddPessoas = (ImageView) findViewById(R.id.imageViewAddPessoas);
    	imgViewAddPedidos = (ImageView) findViewById(R.id.ImageViewAddPedidos);
    	listViewPessoas = (ListView) findViewById(R.id.listViewPessoas);
    	listViewPedidos = (ListView) findViewById(R.id.listViewPedidos);
    	
    	adapterListViewPessoas = new AdapterListViewPessoas(getApplicationContext());
    	adapterListViewPedidos = new AdapterListViewPedidos(getApplicationContext());
    }
    
    private void carregarAcoes()
    {
    	imgViewAddPessoas.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent I = new Intent(PrincipalActivity.this, AdicionarPessoaActivity.class);
				startActivity(I);
				preencheListas();
			}
		});
    	
    	imgViewAddPedidos.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent I = new Intent(PrincipalActivity.this, AdicionarPedidoActivity.class);
				startActivity(I);
				preencheListas();
			}
		});
    }
    
    private void preencheListas()
    {
    	listViewPessoas.setAdapter(adapterListViewPessoas);
    	listViewPedidos.setAdapter(adapterListViewPedidos);
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_principal, menu);
        return true;
    }
}
