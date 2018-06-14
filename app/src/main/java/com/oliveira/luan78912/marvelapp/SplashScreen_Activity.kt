package com.oliveira.luan78912.marvelapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashScreen_Activity : AppCompatActivity() {

    private val Splash_Display_Length = 3500L

    lateinit var ivLogo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_)

        ivLogo = findViewById(R.id.ivLogo)
        Carregar()
    }

    fun Carregar() {
        val anim = AnimationUtils.loadAnimation(this, R.anim.animacao_splash)
        anim.reset()

        ivLogo!!.clearAnimation()
        ivLogo!!.startAnimation(anim)

        Handler().postDelayed({
            val intent = Intent(this@SplashScreen_Activity,
                    ListaActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            this@SplashScreen_Activity.finish()
        }, Splash_Display_Length)
    }


}

