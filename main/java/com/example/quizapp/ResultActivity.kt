package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private lateinit var tv_name:TextView
    private lateinit var tv_score:TextView
    private lateinit var btn_finish:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        tv_name=findViewById(R.id.tv_name)
        tv_score=findViewById(R.id.tv_score)
        btn_finish=findViewById(R.id.btn_finish)

        val userName=intent.getStringExtra(Constants.USER_NAME)
        tv_name.text=userName
        val totalQuestions=intent.getIntExtra(Constants.TOTAL_QUESTION,0)
        val correctAnswers=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tv_score.text="Your score is $correctAnswers out of $totalQuestions"
        btn_finish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}