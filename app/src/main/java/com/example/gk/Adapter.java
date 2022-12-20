package com.example.gk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Context context;
    private  int layout;
    private List<Club> ClubList;

    public Adapter(Context context, int layout, List<Club> clubList) {
        this.context = context;
        this.layout = layout;
        ClubList = clubList;
    }

    @Override
    public int getCount() {
        return ClubList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view =  inflater.inflate(layout, null);
        TextView txtten = (TextView) view.findViewById(R.id.name);
        TextView txtdescription = (TextView) view.findViewById(R.id.description);
        ImageView img = (ImageView) view.findViewById(R.id.image);
        Club club = ClubList.get(i);
        txtten.setText(club.getTen());
        txtdescription.setText(club.getMota());
        img.setImageResource(club.getHinhanh());
        return view;
    }
}
