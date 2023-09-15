package com.example.a10minuteworkoutapp

import android.content.IntentSender.OnFinished
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.TestLooperManager
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.a10minuteworkoutapp.databinding.ActivityExerciseBinding
import java.util.Locale

class Exercise_Activity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private var binding: ActivityExerciseBinding? = null
    private var restTimer: CountDownTimer? = null
    private var restProgress = 0

    private var exerciseTimer: CountDownTimer? = null
    private var exerciseProgress = 0


    private var exerercieList: ArrayList<ExerciseModel>? = null
    private var exerciseNumber = -1

    private var tts:TextToSpeech?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolBarExercise)

        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        exerercieList = Constant.defaultExerciseList()
tts= TextToSpeech(this,this)
        binding?.toolBarExercise?.setNavigationOnClickListener {
            onBackPressed()
        }
        setRestView()
    }

    private fun setRestView() {
        binding?.flRestView?.visibility = View.VISIBLE
        binding?.tvTitle?.visibility = View.VISIBLE
        binding?.tvExerciseName?.visibility = View.INVISIBLE
        binding?.flExerciseView?.visibility = View.INVISIBLE
        binding?.imageView?.visibility = View.INVISIBLE
        binding?.tvUpcomingLabel?.visibility=View.VISIBLE
        binding?.tvUpcomingExerciseName?.visibility=View.VISIBLE

        if (restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }

        binding?.tvUpcomingExerciseName?.text=exerercieList!![exerciseNumber+1].getName()

        setRestProgressBar()
    }

    fun setRestProgressBar() {
        binding?.progressBar?.progress = restProgress
        restTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                restProgress++;
                binding?.progressBar?.progress = 10 - restProgress
                binding?.tvTimer?.text = (10 - restProgress).toString()
            }

            override fun onFinish() {
                exerciseNumber++
                setUpExerciseView()

            }
        }.start()
    }

    private fun setUpExerciseView() {
        binding?.flRestView?.visibility = View.INVISIBLE
        binding?.tvTitle?.visibility = View.INVISIBLE
        binding?.tvExerciseName?.visibility = View.VISIBLE
        binding?.flExerciseView?.visibility = View.VISIBLE
        binding?.imageView?.visibility = View.VISIBLE
        binding?.tvUpcomingLabel?.visibility=View.INVISIBLE
        binding?.tvUpcomingExerciseName?.visibility=View.INVISIBLE

        if (exerciseTimer != null) {
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }

        SpeakOut(exerercieList!![exerciseNumber].getName())

        binding?.imageView?.setImageResource(exerercieList!![exerciseNumber].getImage())
        binding?.tvExerciseName?.text = exerercieList!![exerciseNumber].getName()
        setExerciseProgressBar()


    }

    fun setExerciseProgressBar() {
        binding?.flProgressBarExercise?.progress = exerciseProgress
        exerciseTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                exerciseProgress++;
                binding?.flProgressBarExercise?.progress = 30 - exerciseProgress
                binding?.tvTimerExercise?.text = (30 - exerciseProgress).toString()
            }

            override fun onFinish() {
                if (exerciseNumber < exerercieList?.size!! - 1) {
                    setRestView()
                } else {
                    Toast.makeText(
                        this@Exercise_Activity,
                        "Hurray,You Completed The Task ",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }.start()

    }


    override fun onDestroy() {

        if (restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }

        super.onDestroy()
        if(tts!=null){
            tts!!.stop()
            tts!!.shutdown()
        }
        binding = null
    }

    override fun onInit(status: Int) {
        if(status==TextToSpeech.SUCCESS) {
            val result = tts?.setLanguage(Locale.ENGLISH)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "The Language Specified Not Supported")
            }
        }
            else{
                Log.e("TTS","Initialization Failed")

        }
    }
    private fun SpeakOut(text:String){
        tts!!.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }
}


