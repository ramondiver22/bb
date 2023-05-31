package com.casinobbbrss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.ImageView

class Game : AppCompatActivity() {
    private lateinit var wheelImageView: ImageView
    private lateinit var spinButton: ImageView
    private lateinit var jackpot: ImageView
    private var playerScore: Int = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        wheelImageView = findViewById(R.id.imageView7)
        jackpot = findViewById(R.id.imageView11)
        spinButton = findViewById(R.id.imageView9)
        val imageView2 = findViewById<ImageView>(R.id.imageView10)

        imageView2.setOnClickListener {
        }
        spinButton.setOnClickListener {
            spinWheel()
        }
    }

    private fun spinWheel() {
        val sectorValues = arrayOf(
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            10,
            11,
            12
        )

        val randomIndex = (0 until sectorValues.size).random()

        val sectorValue = sectorValues[randomIndex]
        val rotationAngle = 360 / sectorValues.size * randomIndex

        // Вращаем колесо
        wheelImageView.animate().rotationBy(rotationAngle.toFloat()).setDuration(3000).start()

        playerScore *= sectorValue


        if (sectorValue == 7){
                val fadeIn = AlphaAnimation(0f, 1f)
                fadeIn.duration = 1000

                val fadeOut = AlphaAnimation(1f, 0f)
                fadeOut.startOffset = 1000
                fadeOut.duration = 1000


                jackpot.startAnimation(fadeIn)
                jackpot.visibility = ImageView.VISIBLE

                Handler().postDelayed({

                    jackpot.startAnimation(fadeOut)
                    jackpot.visibility = ImageView.INVISIBLE
                }, 2000)

        }

    }
}