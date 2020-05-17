package com.example.buttomsheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textview.MaterialTextView;
import java.util.List;

public class AdapterList extends RecyclerView.Adapter<ListHolder> {

    private List<String> sampleList;
    private Context context;

    public AdapterList(List<String> sampleList) {
        this.sampleList = sampleList;
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        context = parent.getContext();
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder holder, int position) {
        String string = sampleList.get(position);
        holder.viewItemName.setText(string);
    }

    @Override
    public int getItemCount() {
        return sampleList.size();
    }
}

class ListHolder extends RecyclerView.ViewHolder {

    MaterialTextView viewItemName;

    ListHolder(@NonNull View itemView) {
        super(itemView);
        viewItemName = itemView.findViewById(R.id.list_item_name_view);
    }
}
