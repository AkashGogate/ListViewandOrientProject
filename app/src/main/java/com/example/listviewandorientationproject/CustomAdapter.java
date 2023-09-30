package com.example.listviewandorientationproject;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Character> {
    List<Character> list;
    Context context;
    int xmlResource;
    int selectedIndex = -1;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Character> objects) {
        super(context, resource, objects);
        xmlResource = resource;
        list = objects;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View adapterLayout = layoutInflater.inflate(xmlResource, null);

        TextView name = adapterLayout.findViewById(R.id.type);
        ImageView image = adapterLayout.findViewById(R.id.imageView);
        Button remove = adapterLayout.findViewById(R.id.remove);
        remove.setText("Remove");

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });

        name.setText(list.get(position).getKind());
        image.setImageResource(list.get(position).getPic());
        image.setScaleType(ImageView.ScaleType.FIT_XY);
        image.setScaleX(0.6F);
        image.setScaleY(1F);
        return adapterLayout;

    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }
}