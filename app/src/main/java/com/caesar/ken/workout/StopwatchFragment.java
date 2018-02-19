package com.caesar.ken.workout;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



public class StopwatchFragment extends Fragment implements View.OnClickListener { //on click listener is an interface that responds to click
    private boolean running = false;
    private int seconds = 0;
    private boolean wasRunning;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null ){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        if (wasRunning){
            running = true;
        }
        }//get the wasRunning state befpore start

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_stopwatch,container,false);// this layout object gets the view
        runTimer(layout);
        //layout that has gtten the view of the Layout is used as a view object to get the id's of the individual view button objects
        //below the setOnClickListener() is an interface that is used to make the buttons to respond to clicks
        Button startbut = (Button) layout.findViewById(R.id.start);// get the id of the button with the layout
        startbut.setOnClickListener(this);// make the button respond to clicks
        Button stopbut = (Button) layout.findViewById(R.id.stop);
        stopbut.setOnClickListener(this);
        Button resetbut = (Button) layout.findViewById(R.id.reset);
        resetbut.setOnClickListener(this);
        return layout;
    }

    @Override
    public void onClick(View view) {//this methods deteermines what happens when the buttons are clicked
        switch (view.getId()){ //v.getId() is used inplace of findviewbyid() when the is is to be used diiectly and not just referenced
            case R.id.start:
                onClickStart(view);
                break;
            case R.id.stop:
                onClickStop(view);
                break;
            case R.id.reset:
                onClickReset(view);
                break;
        }

    }

    @Override
    public void onPause() {//this can be used in place of onStop because a call is even  ade first to it before onStop
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (wasRunning)
        { running = true;}

    }
    @Override //this method is just to save the state but doesnt save if it was running or not which is done below
    public void onSaveInstanceState(Bundle savedInstanceState) {//thois gets called after activity is destroyed before onStart
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);//this saves the wasRunning state
    }

    public void onClickStart(View view){

        running = true;
    }
    public void onClickStop(View view){
        running = false;
    }

    public void onClickReset(View view){

        running = false;
        seconds = 0;
    }

    public void runTimer(View view) {
        final TextView texn = (TextView) view.findViewById(R.id.textn);

        final Handler handle = new Handler() ;

        Runnable run = new Runnable() {
            @Override
            public void run() {

                int secs = seconds % 60;
                int hour = seconds / 3600;
                int minute = (seconds % 3600) / 60;

                String fal = String.format("%d:%02d:%02d", hour, minute, secs);
                texn.setText(fal);

                if (running) {
                    seconds++;
                }
                handle.postDelayed(this,1000);
            }
        };
        handle.post(run);
    }



}
