package dlhc.com.listviewimagenes;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorListado extends ArrayAdapter<String>{

    private Activity activity;
    private String listaNombres[];
    private String listaImagenes[];

    public AdaptadorListado(Activity activity, String listaNombres[], String listaImagenes[]) {
        super(activity, R.layout.item_lista, listaNombres);

        this.activity = activity;
        this.listaNombres = listaNombres;
        this.listaImagenes = listaImagenes;

    }

    @Override
    public View getView(int posicion, View vista, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View rootView = inflater.inflate(R.layout.item_lista, null);

        TextView txtTitulo = (TextView)rootView.findViewById(R.id.txtTitulo);
        TextView txtDescripcion = (TextView)rootView.findViewById(R.id.txtDescripcion);
        ImageView imgImagen = (ImageView) rootView.findViewById(R.id.imgImagen);

        txtTitulo.setText(listaNombres[posicion]);
        txtDescripcion.setText("Descripcion de " + listaNombres[posicion]);

        Bitmap  imagenDescargada = new Funciones().descargarImagen(listaImagenes[posicion]);
        imgImagen.setImageBitmap(imagenDescargada);

        return rootView;
    }
}
