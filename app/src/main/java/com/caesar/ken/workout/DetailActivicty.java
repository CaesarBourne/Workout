package com.caesar.ken.workout;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivicty extends AppCompatActivity {
        public static final String EXTRA_WORKOUT_ID ="id";
    MediaPlayer voices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        WorkoutDetailFragment workoutdetail = (WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        int workoutId = (Integer) getIntent().getExtras().get(EXTRA_WORKOUT_ID); //this typecast to integer isfrom string
        workoutdetail.setWorkoutId(workoutId);
        voices = MediaPlayer.create(DetailActivicty.this,R.raw.voices);
        voices.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        voices.stop();
    }


}
