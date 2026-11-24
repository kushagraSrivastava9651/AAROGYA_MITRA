<h1 align="center">Aarogya Mitra</h1>

<p align="center">A 10-minute guided home-workout app for Android, with exercise timers, rest breaks and progress tracking.</p>

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-3DDC84?style=flat-square&logo=android&logoColor=white" />
  <img src="https://img.shields.io/badge/Kotlin-7F52FF?style=flat-square&logo=kotlin&logoColor=white" />
  <img src="https://img.shields.io/badge/UI-XML%20%2B%20ViewBinding-orange?style=flat-square" />
</p>

## Features

- A guided routine of bodyweight exercises (Jumping Jacks, High Knees, Squats, Side Leg Raise, Russian Twist and more), each with an illustration.
- A `CountDownTimer`-driven **rest → exercise** cycle with a circular progress bar.
- **Voice cues** with Android `TextToSpeech` that announce the next exercise.

## Structure

| File | Role |
| --- | --- |
| `MainActivity.kt` | Start screen |
| `Exercise_Activity.kt` | Timer loop, TTS, progress UI |
| `ExerciseModel.kt` | Exercise data model (id, name, image, selected / completed) |
| `Constant.kt` | Default exercise list |

## Run

Open the project in Android Studio and run it on an emulator or device.

**Tech:** Kotlin · Android SDK · ViewBinding · Material Components · TextToSpeech
