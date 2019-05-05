package com.online_clothing;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder> {

    Context mContext;
    List<Items> itemlist;

    public ItemsAdapter(Context mContext, List<Items>itemlist)
    {

        this.mContext = mContext;
        this.itemlist = itemlist;

    }


    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_itemview,viewGroup, false);

        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder itemsViewHolder, int i) {

        final Items items = itemlist.get(i);
        itemsViewHolder.img.setImageResource(items.getImage());
        itemsViewHolder.tvItemName.setText(items.getName());

        itemsViewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, itemdesc.class);
                intent.putExtra("image",items.getImage());
                intent.putExtra("name",items.getName());
                intent.putExtra("price",items.getPrice());
                intent.putExtra("desc",items.getDesc());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder {

        CircleImageView img;
        TextView tvItemName;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            tvItemName = itemView.findViewById(R.id.tvItemName);

        }
    }
}
