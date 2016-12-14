package es.iesnervion.dbenitez.clienterestpokemon;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PokeProfile extends AppCompatActivity
{

    private TextView nombre;
    private TextView numeroPokedex;
    private TextView tipos;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_profile);

        Pokemon poke = getIntent().getExtras().getParcelable("pokemon");

        nombre = (TextView) findViewById(R.id.nombre);
        numeroPokedex = (TextView) findViewById(R.id.numeroPokedex);
        tipos = (TextView) findViewById(R.id.tipos);

        nombre.setText("Nombre:\n"+poke.getNombre());
        numeroPokedex.setText("\nNº Pokédex: \n"+poke.getNumero());
        if(poke.getTipoPrimario()!=(poke.getTipoSecundario()))
        {
            tipos.setText("\nTipo: "+poke.getTipoPrimario()+"/"+poke.getTipoSecundario());
        }
        else
            tipos.setText("\nTipo: "+poke.getTipoPrimario());
    }
}
