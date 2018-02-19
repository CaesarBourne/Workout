package com.caesar.ken.workout;

//This ty
public class Workout {

    private String name;
    private String description;
    private int gifImage;

    static final Workout exer = new Workout("The Limb loosener", "5 Handstand pushups\n 10 1-legged squats\n15 Pullups", R.drawable.jumper);
    static final Workout exer2 = new Workout("Core Agony", "100 Pull-ups\n 100 push-ups\n100 Sit-ups\n100 Squats",R.drawable.fwjumper);
    static final Workout exer3 = new Workout("The Wimp special", "5 Pullups\n 10 Pushups\n 15 Squats",R.drawable.waist);
    static final Workout exer4 = new Workout("Strength and Length", "500 meter run\n 21 x 1.5 pood ketleball swing\n21 x pullups",R.drawable.raiseup);
    public static final   Workout workouts [] = {exer,exer2,exer3,exer4};// thi are objects or types of class workout usec to created array
   public static final int arraye[] = {R.drawable.carrywe,R.drawable.fwjumper,R.drawable.waist,R.drawable.raiseup};
        public Workout(String name, String description, int gifImage){
            this.name = name;
            this.description = description;
            this.gifImage = gifImage;
        }

    public String toString(){
        return this.name;
    }
    public String getDescription(){
        return description;
    }

    public String getName(){
        return name;
    }
    public int getImageGif(){
        return gifImage;
    }
}
