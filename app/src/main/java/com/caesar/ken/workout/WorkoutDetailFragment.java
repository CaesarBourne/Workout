package com.caesar.ken.workout;

import android.media.MediaPlayer;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class WorkoutDetailFragment extends Fragment{//the workout detail fragment is the parent fragment for the stopwatch fragment
    private long workoutId;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (savedInstanceState != null){
            workoutId = savedInstanceState.getLong("workoutId"); //this is done before the view is created below
        }
        else{// this else statement ensures that fragment is only replaced if there was no previous runing fragment which means else code ran before
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();//this replaces when rotated below
        StopwatchFragment stopwatchFragment = new StopwatchFragment();
        ft.replace(R.id.stopwatch_container, stopwatchFragment);//this replaces the fragment with a new instance instead it should be if null(notin clicked)
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        ft.commit();}
        return inflater.inflate(R.layout.fragment_workout_detail,container,false);

    }
    public WorkoutDetailFragment(){

    }


    @Override
    public void onStart() {
        super.onStart();
        View view = getView();//this is used because the fragment parent clas does not have the view class that is in activity,to get title,descrip
        if ( view != null){

        TextView textn = (TextView) view.findViewById(R.id.title1); //view.finfbyId is used bcos fragment is not a subclass of activity
        Workout worki = Workout.workouts[(int) workoutId];
        textn.setText(worki.getName());
        TextView texta = (TextView) view.findViewById(R.id.description);
        texta.setText(worki.getDescription());
            GifImageView gifcalla = (GifImageView) view.findViewById(R.id.gigchangi);
            gifcalla.setImageResource(worki.getImageGif());
        };
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {//this gets called when the fragment is destroyed
        savedInstanceState.putLong("workoutId", workoutId);//save the workoutId in the savedInstancestate bundle retrieve it in on create view
    }                               // above the workoutId is saved in the global workoutId

    public void setWorkoutId(long id) {
        this.workoutId = id; //this workoutId that is set is used to gettthe value of the name of the workout that
                            // should be displayed in the workoutdetail fragment from the workout list fragment
    }
    public long getWorkoutId(){
        return this.workoutId;
    }
}