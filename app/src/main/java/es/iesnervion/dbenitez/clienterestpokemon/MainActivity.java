package es.iesnervion.dbenitez.clienterestpokemon;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.io.IOException;
import com.google.gson.Gson;
import okio.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Vector;

public class MainActivity extends ListActivity
{
    private ListView lista;
    public static Vector<Pokemon> pokes;
    private Retrofit retrofit;
    private final static String SERVER_URL = "http://apirestpokemon.iesnervion.com/";
    private Pokemon[] array;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PokemonCallback pokemonCallback = new PokemonCallback();

        retrofit = new Retrofit.Builder().baseUrl(SERVER_URL).addConverterFactory(GsonConverterFactory.create()).build();

        PokemonInterface pokemonInterface = retrofit.create(PokemonInterface.class);

        pokemonInterface.getPokemon().enqueue(pokemonCallback);

        lista = (ListView) findViewById(android.R.id.list);
        array = (Pokemon[]) pokes.toArray();
        lista.setAdapter(new AdapterIcono(this,R.layout.row,R.id.texto,array));
    }

    public void onListItemClick(ListView parent, View v, int position, long id)
    {
        Intent intent = new Intent(this, PokeProfile.class);

        intent.putExtra(getString(R.string.pokemon), pokes.get(position));
        startActivity(intent);
    }

    class AdapterIcono<T> extends ArrayAdapter<T>
    {
        AdapterIcono(Context c, int resourceId, int textId, T[] objects)
        {
            super(c, resourceId, textId, objects);
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            View row = convertView;
            ViewHolder holder;

            if (row==null){
                LayoutInflater inflater=getLayoutInflater();
                row=inflater.inflate(R.layout.row, parent, false);

                TextView tv = (TextView) row.findViewById(R.id.texto);


                holder = new ViewHolder (tv);
                row.setTag(holder);
            }
            else
            {
                holder = (ViewHolder) row.getTag();
            }

            holder.getTv().setText(pokes.get(position).getNombre());

            return (row);
        }
    }
    class ViewHolder
    {
        TextView tv;

        ViewHolder (TextView tv){
            this.tv = tv;
        }

        public TextView getTv (){
            return this.tv;
        }
    }
}

