package com.flowmixa.vibrobutton1

import android.app.Activity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.content.Context
import android.widget.Button
import android.widget.LinearLayout
import android.view.Gravity

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val button = Button(this).apply {
            text = "VIBRATE"
            textSize = 24f

            setOnClickListener {
                val vibrator =
                    getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

                if (vibrator.hasVibrator()) {
                    vibrator.vibrate(
                        VibrationEffect.createOneShot(
                            1000,
                            VibrationEffect.DEFAULT_AMPLITUDE
                        )
                    )
                }
            }
        }

        val layout = LinearLayout(this).apply {
            gravity = Gravity.CENTER
            addView(button)
        }

        setContentView(layout)
    }
}