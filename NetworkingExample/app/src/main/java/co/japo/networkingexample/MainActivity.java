package co.japo.networkingexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView itemsView = (RecyclerView) findViewById(R.id.itemsView);
        itemsView.setLayoutManager(
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://vinrosa.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyRemoteService myRemoteService = retrofit.create(MyRemoteService.class);

        myRemoteService.getItems().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                itemsView.setAdapter(new ItemsAdapter(response.body()));
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }
        });
    }

    public class ItemsAdapter extends RecyclerView.Adapter<ItemViewHolder>{
        private final List<Item> items;

        public ItemsAdapter(List<Item> items){
            super();
            this.items = items;
        }

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.item_layout, parent,false);
            ItemViewHolder holder = new ItemViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, int position) {
            Item item = this.items.get(position);

                holder.label.setText(item.label);
                holder.description.setText(item.description);
              holder.priority.setText(item.priority+"");

        }

        @Override
        public int getItemCount() {
            return this.items.size();
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        public TextView label;
        public TextView description;
        public TextView priority;

        public ItemViewHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.label);
            description = (TextView) itemView.findViewById(R.id.description);
            priority = (TextView) itemView.findViewById(R.id.priority);
        }
    }
}
