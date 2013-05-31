package br.com.sparksoftware.mesadebar.adapters;

import java.util.ArrayList;
import java.util.List;

import br.com.sparksoftware.mesadebar.R;
import br.com.sparksoftware.mesadebar.model.Pessoa;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterListViewPessoas extends BaseAdapter{

	private LayoutInflater mInflater;
    private ArrayList<Pessoa> itens;
    private ViewHolder holder;
    
    public AdapterListViewPessoas(Context context) {
        // Itens que preencheram o listview
        ArrayList<Pessoa> a = new ArrayList<Pessoa>();
        this.itens = a;
        mInflater = LayoutInflater.from(context);
    }
    
    public AdapterListViewPessoas(Context context, List<Pessoa> itens) {
        // Itens que preencheram o listview
        ArrayList<Pessoa> a = new ArrayList<Pessoa>();
        for (Pessoa _pessoa : itens) {
            a.add(_pessoa);
        }
        this.itens = a;
        mInflater = LayoutInflater.from(context);

    }
    
    public void add(Pessoa _pessoa)
    {
    	this.itens.add(_pessoa);
    }
    
	@Override
	public int getCount() {
		return itens.size();
	}

	@Override
	public Object getItem(int position) {
		return itens.get(position);
	}

	@Override
	public long getItemId(int position) {
		return itens.get(position).getId();
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		 if (view == null) {
            view = mInflater.inflate(R.layout.adapter_pessoa_item, null);
            holder = new ViewHolder();
            holder.tvNomePessoa = (TextView) view.findViewById(R.id.tvNomePessoa);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Pessoa _pessoa = itens.get(position);
        holder.tvNomePessoa.setText(String.valueOf(_pessoa.getNome()));
        /*Typeface font1 = Typeface.createFromAsset(view.getContext().getAssets(), "fonts/Roboto-Light.ttf");
        holder.tvId.setTypeface(font1);
        holder.tvNome.setTypeface(font1);
        holder.tvDocumento.setTypeface(font1);*/
        return view;
	}
	
	static class ViewHolder {
        private TextView tvNomePessoa;
        private ImageView imgRemover;
        
    }
}
