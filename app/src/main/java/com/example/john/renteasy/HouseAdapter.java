package com.example.john.renteasy;

//adapter details

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.john.renteasy.R;
import com.example.john.renteasy.SingleItems;

import java.util.ArrayList;



public class HouseAdapter extends BaseAdapter {
    private static final String TAG = ListBuildingActivity.class.getSimpleName();

    ArrayList<SingleItems> list;

    Context context;

    HouseAdapter(Context context){
        this.context = context;

        list = new ArrayList<SingleItems>();



        Resources res = context.getResources();
        String[] rentalNames = res.getStringArray(R.array.rental_names);
        int[] rentalImages = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4,
                R.drawable.img5, R.drawable.img6,};
        for (int i = 0; i <rentalImages.length; i++){
            SingleItems tempItems = new SingleItems(rentalImages[i], rentalNames[i]);

            list.add(tempItems);
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }
//get(int i)
    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    //int i
    @Override
    public long getItemId(int i) {
        // return i
        return i;
    }


    class ViewHolder {
        ImageView myRental;
        TextView txtRental;

        ViewHolder( View v) {
            myRental = (ImageView) v.findViewById(R.id.imageView);
            txtRental = (TextView) v.findViewById(R.id.txtView);
        }
    }

    //int i, View view, ViewGroup viewGroup

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        View row = view;

        ViewHolder holder = null;

        if(row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_item, viewGroup,false);

            holder = new ViewHolder(row);

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        SingleItems temp = list.get(i);
        holder.myRental.setImageResource(temp.imageId);
        holder.txtRental.setText(temp.imageName);
        return row;
    }
}
