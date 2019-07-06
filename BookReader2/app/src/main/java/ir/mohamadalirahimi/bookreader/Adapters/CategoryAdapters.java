package ir.mohamadalirahimi.bookreader.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ir.mohamadalirahimi.bookreader.BookListActivity;
import ir.mohamadalirahimi.bookreader.Classes.category;
import ir.mohamadalirahimi.bookreader.R;
import ir.mohamadalirahimi.bookreader.Classes.book;

public class CategoryAdapters extends RecyclerView.Adapter<CategoryAdapters.MyViewHolder> {

    Context context;
    ArrayList<category> arrayList;

    public CategoryAdapters(Context c, ArrayList a) {
        arrayList = a;
        context = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View item = LayoutInflater.from(context).inflate(R.layout.item_category, viewGroup, false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int p) {

        holder.name.setText(arrayList.get(p).name);
        holder.item.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, BookListActivity.class);
                        intent.putExtra("id", arrayList.get(p).id + "");
                        intent.putExtra("name", arrayList.get(p).name + "");

                        context.startActivity(intent);

                    }
                }
        );
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        CardView item;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.category);
            item = itemView.findViewById(R.id.item);
        }
    }
}
