package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener{
    private var mCurrentPosition:Int=1
    private var mQuestionsList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0
    private var mCorrectAnswers:Int=0
    private var mUserName:String?=null

    private lateinit var progressBar:ProgressBar
    private lateinit var tv_progress:TextView
    private lateinit var tv_question:TextView
    private lateinit var iv_image:ImageView
    private lateinit var tv_option_one:TextView
    private lateinit var tv_option_two:TextView
    private lateinit var tv_option_three:TextView
    private lateinit var tv_option_four:TextView
    private lateinit var btn_submit:Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName=intent.getStringExtra(Constants.USER_NAME)

        progressBar=findViewById(R.id.progressBar)
        tv_progress=findViewById(R.id.tv_progress)
        tv_question=findViewById(R.id.tv_question)
        iv_image=findViewById(R.id.iv_image)
        tv_option_one=findViewById(R.id.tv_option_one)
        tv_option_two=findViewById(R.id.tv_option_two)
        tv_option_three=findViewById(R.id.tv_option_three)
        tv_option_four=findViewById(R.id.tv_option_four)
        btn_submit=findViewById(R.id.btn_submit)

        mQuestionsList=Constants.getQuestions()

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)

        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion(){


        val question= mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        if(mCurrentPosition==mQuestionsList!!.size)
        {
            btn_submit.text="FINISH"
        }else
        {
            btn_submit.text="SUBMIT"
        }

        progressBar.progress=mCurrentPosition
        tv_progress.text="$mCurrentPosition"+"/"+progressBar.max
        tv_question.text=question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text=question.optionOne
        tv_option_two.text=question.optionTwo
        tv_option_three.text=question.optionThree
        tv_option_four.text=question.optionFour
    }

    private fun defaultOptionsView(){
        val options=ArrayList<TextView>()
        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.tv_option_one->
            {
                selectedOptionView(tv_option_one,1)
            }
            R.id.tv_option_two->
            {
                selectedOptionView(tv_option_two,2)
            }
            R.id.tv_option_three->
            {
                selectedOptionView(tv_option_three,3)
            }
            R.id.tv_option_four->
            {
                selectedOptionView(tv_option_four,4)
            }
            R.id.btn_submit->
            {
                if(mSelectedOptionPosition==0)
                {
                    mCurrentPosition++

                    when
                    {
                        mCurrentPosition<=mQuestionsList!!.size->
                        {
                            setQuestion()
                        }
                        else-> {
                            val intent=Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTION,mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }

                }else{
                    val question=mQuestionsList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer!=mSelectedOptionPosition)
                    {
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else
                    {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)

                    if (mCurrentPosition==mQuestionsList!!.size)
                    {
                        btn_submit.text="FINISH"
                    }else
                    {
                        btn_submit.text="NEXT QUESTION"
                    }
                    mSelectedOptionPosition=0
                }
            }
        }
    }

    private fun answerView(answer:Int,drawableView: Int){
        when(answer)
        {
            1->
            {
                tv_option_one.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->
            {
                tv_option_two.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->
            {
                tv_option_three.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->
            {
                tv_option_four.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }
}