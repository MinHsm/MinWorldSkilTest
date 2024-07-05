package com.min.b_module_test.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.updateLayoutParams
import com.min.b_module_test.R

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var ivHead: ImageView
    private lateinit var btnSignIn: Button
    private lateinit var btnSignUp: Button
    private lateinit var btnSign: Button
    private lateinit var tvForget: TextView
    private lateinit var llHead: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        binds()
        init()

    }

    private fun binds() {
        ivHead = findViewById(R.id.iv_head)
        btnSignIn = findViewById(R.id.btn_sign_in)
        btnSignUp = findViewById(R.id.btn_sign_up)
        btnSign = findViewById(R.id.btn_sign)
        tvForget = findViewById(R.id.tv_forgot)
        llHead = findViewById(R.id.ll_head)
    }

    private fun init() {
        btnSignIn.setOnClickListener(this@LoginActivity)
        btnSignUp.setOnClickListener(this@LoginActivity)
        btnSign.setOnClickListener(this@LoginActivity)
    }

    private fun changeUIForSignIn() {
        ivHead.setImageResource(R.drawable.sigin_boy_img)
        btnSignIn.setTextColor(Color.WHITE)
        btnSignIn.setBackgroundColor(getColor(R.color.blue))
        tvForget.visibility = View.VISIBLE
        btnSignUp.setTextColor(getColor(R.color.blue))
        btnSignUp.setBackgroundColor(Color.WHITE)
        val marginInDp = -260
        val marginInPixels = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, marginInDp.toFloat(), resources.displayMetrics
        ).toInt()
        llHead.updateLayoutParams<FrameLayout.LayoutParams> {
            topMargin = marginInPixels
        }
    }

    private fun changeUIForSignUp() {
        ivHead.setImageResource(R.drawable.sigin_boy_img)
        btnSignIn.setTextColor(getColor(R.color.blue))
        btnSignIn.setBackgroundColor(Color.WHITE)
        tvForget.visibility = View.GONE
        btnSignUp.setTextColor(Color.WHITE)
        btnSignUp.setBackgroundColor(getColor(R.color.blue))
        val marginUpDp = -205
        val marginUpPixels = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, marginUpDp.toFloat(), resources.displayMetrics
        ).toInt()
        llHead.updateLayoutParams<FrameLayout.LayoutParams> {
            topMargin = marginUpPixels
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            btnSignIn -> {
                changeUIForSignIn()
            }

            btnSignUp -> {
                changeUIForSignUp()
            }

            btnSign -> {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}