package com.example.a10minuteworkoutapp

object Constant {
    fun defaultExerciseList():ArrayList<ExerciseModel>{
        val exerciseList=ArrayList<ExerciseModel>()
        val jumpingJacks=ExerciseModel(1,
            "Jumping  Jacks",
            R.drawable.jumpingjack,false,false)
        exerciseList.add(jumpingJacks)


        val HighKnees=ExerciseModel(2,
            "High Knees",
            R.drawable.highknees,false,false)
        exerciseList.add(HighKnees)


        val squats=ExerciseModel(3,
            "Squats",
            R.drawable.squats,false,false)
        exerciseList.add(squats)


        val SideLegRaise=ExerciseModel(4,
            "Side Leg Raise",
            R.drawable.sidelegraise,false,false)
        exerciseList.add(SideLegRaise)

        val RussianTwist=ExerciseModel(5,
            "Russian  Twist",
            R.drawable.russiantwist,false,false)
        exerciseList.add(RussianTwist)

        val DonkeyKicks=ExerciseModel(6,
            "Donkey  Kicks",
            R.drawable.donkeykicks,false,false)
        exerciseList.add(DonkeyKicks)

        val SideLunges=ExerciseModel(7,
            "Side  Lunges",
            R.drawable.sidelunges,false,false)
        exerciseList.add(SideLunges)

        val WindShieldWiper=ExerciseModel(8,
            "WindShield  Wipers",
            R.drawable.windshieldwiper,false,false)
        exerciseList.add(WindShieldWiper)

        val Plank=ExerciseModel(9,
            "Plank",
            R.drawable.secondplank,false,false)
        exerciseList.add(Plank)

        val Marching=ExerciseModel(10,
            "Marching Glute Bridge",
            R.drawable.marchingglute,false,false)
        exerciseList.add(Marching)

        return exerciseList
    }

}