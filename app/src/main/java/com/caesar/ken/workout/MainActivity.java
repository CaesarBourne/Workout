package com.caesar.ken.workout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public void itemclicked(long id){

        View fragmentcontainer = findViewById(R.id.fragment_container);
        if (fragmentcontainer != null) {
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();//an acivity uses fragment manager to commune with a fragment
            details.setWorkoutId(id);// this is when the workout detail starts before clicking;

            ft.replace(R.id.fragment_container, details);//afterclicking the fragment selected is displayed with its workoutId
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
        else{
            Intent intent = new Intent(this, DetailActivicty.class);
            intent.putExtra( DetailActivicty.EXTRA_WORKOUT_ID, (int)id); //this typecast is from long to string
            startActivity(intent);
        }

    }
}
