package es.iesnervion.dbenitez.clienterestpokemon;

import java.util.Vector;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;



public interface PokemonInterface
{
    @GET("pokemon")
    Call<Vector<Pokemon>> getPokemon ();

}