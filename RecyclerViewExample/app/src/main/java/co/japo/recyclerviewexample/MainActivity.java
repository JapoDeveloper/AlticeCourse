package co.japo.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = new String[1000];
        for(int i = 0; i < 1000; i++){
            items[i] = "Item id "+i;
        }

        RecyclerView rv = (RecyclerView) findViewById(R.id.myRecycleView);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        rv.setAdapter(new MyRecyclerViewAdapter(items));
    }


    private class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecycleViewHolder>{
        private final String[] items;

        public MyRecyclerViewAdapter(String[] items){
            super();
            this.items = items;
        }

        @Override
        public MyRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this)
                    .inflate(viewType,parent, false);
            MyRecycleViewHolder viewHolder = new MyRecycleViewHolder(view);
            return viewHolder;
        }

        @Override
        public int getItemViewType(int position){
            if(position %2 == 0){
                return R.layout.my_recycleview_item2;
            }
            return R.layout.my_recycleview_item;
        }

        @Override
        public void onBindViewHolder(MyRecycleViewHolder holder, int position) {
            String value = this.items[position];
            holder.myText.setText(value);
        }

        @Override
        public int getItemCount() {
            return this.items.length;
        }
    }

    private class MyRecycleViewHolder extends RecyclerView.ViewHolder{
        private final TextView myText;

        public MyRecycleViewHolder(View viewItem){
            super(viewItem);
            myText = (TextView) viewItem.findViewById(R.id.myText);
            viewItem.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Toast.makeText(view.getContext(),myText.getText(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
