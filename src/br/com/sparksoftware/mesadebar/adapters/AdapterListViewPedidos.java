package br.com.sparksoftware.mesadebar.adapters;

import java.util.ArrayList;
import java.util.List;

import br.com.sparksoftware.mesadebar.R;
import br.com.sparksoftware.mesadebar.model.Item;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterListViewPedidos extends BaseAdapter{

	private LayoutInflater mInflater;
    private ArrayList<Item> itens;
    private ViewHolder holder;
    
    public AdapterListViewPedidos(Context context) {
        // Itens que preencheram o listview
        ArrayList<Item> a = new ArrayList<Item>();
        this.itens = a;
        mInflater = LayoutInflater.from(context);
    }
    
    public AdapterListViewPedidos(Context context, List<Item> itens) {
        // Itens que preencheram o listview
        ArrayList<Item> a = new ArrayList<Item>();
        for (Item _item : itens) {
            a.add(_item);
        }
        this.itens = a;
        mInflater = LayoutInflater.from(context);
    }
    
    public void add(Item _item)
    {
    	this.itens.add(_item);
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
            view = mInflater.inflate(R.layout.adapter_pedido_item, null);
            holder = new ViewHolder();
            holder.tvNome = (TextView) view.findViewById(R.id.tvNomeItem);
            //holder.tvEndereco = (TextView) view.findViewById(R.id.tvEndereco);
            //holder.tvCidade = (TextView) view.findViewById(R.id.tvCidade);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Item _item = itens.get(position);

        holder.tvNome.setText(String.valueOf(_item.getNome()));
//        holder.tvDocumento.setText(String.valueOf(_cliente.getDocumento()));
//        Typeface font1 = Typeface.createFromAsset(view.getContext().getAssets(), "fonts/Roboto-Light.ttf");
//        holder.tvId.setTypeface(font1);
//        holder.tvNome.setTypeface(font1);
//        holder.tvDocumento.setTypeface(font1);
        return view;
	}
	
	static class ViewHolder {
        private TextView tvNome;
                
    }
}
