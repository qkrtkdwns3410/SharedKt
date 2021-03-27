package com.example.sharedkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { //해당 액태비티가 처음 실행될때 한번 수행하는 곳 (초기화)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO:저장된 데이터를 로드

        loadData() //editText 저장되어 있던 값을 setText
    }


     private fun loadData() {
         val pref = getSharedPreferences("pref",0) //0번은 저장옵션.. pref로 저장된다.
         et_Hello.setText(pref.getString("name","")) //1번째 인자 키값.. 저장할 당시의 키값을 저장
         //2번째는 키값의 데이터가 존재하지 않을 경우 대체 값을 적어줍니다



    }

     private fun saveData() {
         val pref = getSharedPreferences("pref",0) //0번은 저장옵션.. pref로 저장된다.
         val edit = pref.edit() //수정모드
         edit.putString("name",et_Hello.text.toString()) //키값,실제 담아둘 값을 ..
         edit.apply() //값을 저장완료
    }
    override fun onDestroy() { //액티비티가 종료되는 시점이 다가올때 호출
        super.onDestroy()

        saveData() //editText  값을 저장
    }
}