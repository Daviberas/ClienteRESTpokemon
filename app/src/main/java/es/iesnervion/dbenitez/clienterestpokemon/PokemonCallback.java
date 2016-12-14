package es.iesnervion.dbenitez.clienterestpokemon;


import java.util.Vector;

import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonCallback implements Callback<Vector<Pokemon>>
{

    @Override
    public void onFailure(Call<Vector<Pokemon>> arg0, Throwable arg1)
    {
        int i;

        i=0;
    }

    @Override
    public void onResponse(Call<Vector<Pokemon>> arg0, Response<Vector<Pokemon>> resp)
    {
            String contentType;
            int code;
            String message;
            boolean isSuccesful;

            MainActivity.pokes = resp.body();

            Headers cabeceras = resp.headers();
            contentType = cabeceras.get("Content-Type");
            code = resp.code();
            message = resp.message();
            isSuccesful = resp.isSuccessful();


    }
}