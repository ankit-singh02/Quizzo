package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btn_start:Button
    private lateinit var et_name:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        btn_start=findViewById(R.id.btn_start)
        et_name=findViewById(R.id.et_name)

        btn_start.setOnClickListener {
            if(et_name.text.toString().isEmpty())
            {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent=Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME,et_name.text.toString())
                startActivity(intent)
                finish()
            }

        }
    }
}