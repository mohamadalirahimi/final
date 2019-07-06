package ir.mohamadalirahimi.bookreader.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ir.mohamadalirahimi.bookreader.R;
import ir.mohamadalirahimi.bookreader.Classes.book;

public class BookAdapters extends RecyclerView.Adapter<BookAdapters.MyViewHolder> {

    Context context;
    ArrayList<book> arrayList;

    public BookAdapters(Context c, ArrayList a) {
        arrayList = a;
        context = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View item = LayoutInflater.from(context).inflate(R.layout.item_book, viewGroup, false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int p) {

        holder.name.setText(arrayList.get(p).name);
        holder.year.setText("سال چاپ : " + arrayList.get(p).printYear+"");
        holder.page.setText("تعداد صفحات : " + arrayList.get(p).pageCount+"");

        holder.category.setText(arrayList.get(p).categoryName);
        holder.category.setText(arrayList.get(p).categoryName);

        Picasso.with(context).load(arrayList.get(p).picture).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView year;
        TextView category;
        TextView page;

        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            year = itemView.findViewById(R.id.year);
            category = itemView.findViewById(R.id.category);
            page = itemView.findViewById(R.id.page);

            image = itemView.findViewById(R.id.image);
        }
    }
}
