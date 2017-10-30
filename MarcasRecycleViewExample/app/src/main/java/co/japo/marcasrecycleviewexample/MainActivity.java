package co.japo.marcasrecycleviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Marca> marcas = new ArrayList(){
            {
                add(new Marca("Honda","Japón","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas orci arcu, varius vitae accumsan id, pulvinar eget eros. Integer sagittis tincidunt dignissim. Duis molestie ex id magna placerat pellentesque."));
                add(new Marca("Toyota","Japón"));
                add(new Marca("Nissan","Japón","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas orci arcu, varius vitae accumsan id, pulvinar eget eros. Integer sagittis tincidunt dignissim. Duis molestie ex id magna placerat pellentesque."));
                add(new Marca("Ford","Estados Unidos"));
                add(new Marca("Chevrolet","Estados Unidos"));
                add(new Marca("Kia","Corea del Sur"));
                add(new Marca("Hyundai","Corea del Sur"));
                add(new Marca("Ferrari","Italia"));
                add(new Marca("Maserati","Italia"));
            }
        };

        RecyclerView marcasView = (RecyclerView) findViewById(R.id.marcasView);
        marcasView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        marcasView.setAdapter(new MarcasAdapter(marcas));

    }

    private class MarcasAdapter extends RecyclerView.Adapter<MarcasViewHolder>{
        private final List<Marca> items;

        public MarcasAdapter(List<Marca> items){
            super();
            this.items = items;
        }

        @Override
        public MarcasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View item = LayoutInflater.from(parent.getContext())
                    .inflate(viewType,parent,false);
            return new MarcasViewHolder(item);
        }

        @Override
        public void onBindViewHolder(MarcasViewHolder holder, int position) {
           final Marca current = this.items.get(position);
            holder.marca.setText(current.marca);
            holder.pais.setText(current.pais);
            if(holder.descripcion != null){
                holder.descripcion.setText(current.descripcion);
            }
            if(holder.showDescription != null){
                holder.showDescription.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,current.descripcion,Toast.LENGTH_LONG).show();
                    }
                });
            }
        }

        @Override
        public int getItemViewType(int position){
            position++;
            if(position == 1){
                return R.layout.item_two_lines;
            }else if(position % 2 == 0){
                return R.layout.item_no_line;
            }else{
                return R.layout.item_one_line;
            }
        }
        @Override
        public int getItemCount() {
            return items.size();
        }
    }

    private class MarcasViewHolder extends RecyclerView.ViewHolder{
        private final TextView marca;
        private final TextView pais;
        private final TextView descripcion;
        private final Button showDescription;

        public MarcasViewHolder(final View viewItem){
            super(viewItem);
            marca = (TextView) viewItem.findViewById(R.id.marca);
            pais = (TextView) viewItem.findViewById(R.id.pais);
            descripcion = (TextView) viewItem.findViewById(R.id.descripcion);
            showDescription = (Button) viewItem.findViewById(R.id.showDetail);
        }
    }

    private class Marca{
        String marca;
        String pais;
        String descripcion;

        public Marca(String marca, String pais){
            this.marca = marca;
            this.pais = pais;
            this.descripcion = "Sin descripción";
        }

        public Marca(String marca, String pais, String descripcion){
            this.marca = marca;
            this.pais = pais;
            this.descripcion = descripcion;
        }
    }
}
