package developer.com.pe.carritocompras;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private ArrayList<elemento> elementos;
    private Context context;

    public Adaptador(ArrayList<elemento> elementos, Context context) {
        this.elementos = elementos;
        this.context = context;
    }

    @Override
    public Adaptador.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adaptador.ViewHolder holder, int position) {
        elemento lista=elementos.get(position);
        holder.TxtDes.setText(lista.getDescripcion());
        holder.TxtDetalle.setText(lista.getDetalle());
        Picasso.with(context).load("http://192.168.1.103/Publicaciones/Imagenes/"+lista.getImg()).resize(400,400).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return elementos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView TxtDes,TxtDetalle;

        public ViewHolder(View itemView) {
            super(itemView);
            img=(ImageView) itemView.findViewById(R.id.img);
            TxtDes=(TextView) itemView.findViewById(R.id.txtDesPro);
            TxtDetalle=(TextView) itemView.findViewById(R.id.txtDetalle);
        }

    }
}
