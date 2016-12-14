package es.iesnervion.dbenitez.clienterestpokemon;

import android.os.Parcel;
import android.os.Parcelable;

public class Pokemon implements Parcelable
{
    private int numero;
    private String nombre;
    private int tipoPrimario;
    private int tipoSecundario;

    public Pokemon(int numero, String nombre, int tipoPrimario, int tipoSecundario)
    {
        this.numero = numero;
        this.nombre = nombre;
        this.tipoPrimario = tipoPrimario;
        this.tipoSecundario = tipoSecundario;
    }

    protected Pokemon(Parcel in) {
        numero = in.readInt();
        nombre = in.readString();
        tipoPrimario = in.readInt();
        tipoSecundario = in.readInt();
    }

    public static final Creator<Pokemon> CREATOR = new Creator<Pokemon>() {
        @Override
        public Pokemon createFromParcel(Parcel in) {
            return new Pokemon(in);
        }

        @Override
        public Pokemon[] newArray(int size) {
            return new Pokemon[size];
        }
    };

    public int getNumero()
    {
        return numero;
    }

    public void setNumero(int numero)
    {
        this.numero = numero;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getTipoPrimario()
    {
        return tipoPrimario;
    }

    public void setTipoPrimario(int tipoPrimario)
    {
        this.tipoPrimario = tipoPrimario;
    }

    public int getTipoSecundario()
    {
        return tipoSecundario;
    }

    public void setTipoSecundario(int tipoSecundario)
    {
        this.tipoSecundario = tipoSecundario;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(numero);
        dest.writeString(nombre);
        dest.writeInt(tipoPrimario);
        dest.writeInt(tipoSecundario);
    }
}
