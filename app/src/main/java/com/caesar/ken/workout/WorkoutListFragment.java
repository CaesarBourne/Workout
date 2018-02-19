package com.caesar.ken.workout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.caesar.ken.workout.dummy.DummyContent;
import com.caesar.ken.workout.dummy.DummyContent.DummyItem;

import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class WorkoutListFragment extends ListFragment {
    public static interface WorkoutListListener{
        void itemclicked(long id);
    }
        private WorkoutListListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String arrayd [] = new String[Workout.workouts.length]; //this array is gotten from Workout array workouts


        for (int as = 0; as < arrayd.length; as++ ){  //workouts[indiidual member] of an array is an object and can call the methods
                arrayd[as] = Workout.workouts[as].getName();//this array is gotten from Workout array workouts arrayd[value] = workouts[value].getname
        }
        ArrayAdapter<String> sa = new CaesarsAdapter(inflater.getContext(),arrayd,Workout.arraye);
       setListAdapter(sa);
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onAttach(Context context) {// the on attach is called when main activity would listen for clicks i.e when fragment is attached 2 it
        super.onAttach(context);
        this.listener = (WorkoutListListener) context ; //this is used to typecast the context the listener would be used  context is better
                                                        // than using the specific activity name
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null){
        listener.itemclicked(id);}// this method is called in the context the listener is used as it passes the id of the clicked
                                    // listview item to the main activity to be set as the workout id of the workout detail fragment
    }
}
