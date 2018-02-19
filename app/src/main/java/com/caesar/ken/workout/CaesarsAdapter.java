package com.caesar.ken.workout;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class CaesarsAdapter extends ArrayAdapter<String>{

    int[] aser;
    WorkoutListFragment werek;
    public CaesarsAdapter( Context context,  String imagwork [],  int ase[]) {
        super(context, R.layout.activity_caesars_adapter, imagwork);
        aser  = ase;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater emmasinflater =  LayoutInflater.from(getContext());//you must get context to use a inflater
        View customisedView = emmasinflater.inflate(R.layout.activity_caesars_adapter,parent,false);

        String singleExer = getItem(position);
        TextView textcall = (TextView) customisedView.findViewById(R.id.giftext);
        textcall.setText(singleExer);
        int arrayer[] = {Workout.arraye.length};
        for (int i =0; i<arrayer.length;i++ ){
            arrayer[i] = this.aser[i];
        }
        GifImageView giffa = (GifImageView) customisedView.findViewById(R.id.gifview);
        giffa.setImageResource(R.drawable.carrywe);
        return customisedView;
    }
}
