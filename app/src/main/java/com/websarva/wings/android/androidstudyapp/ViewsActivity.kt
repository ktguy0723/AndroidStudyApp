package com.websarva.wings.android.androidstudyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ViewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views)

        // 戻る矢印を追加（xmlの追記は不要）
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // ボタン押下リスナの設定
        val btClick = findViewById<Button>(R.id.btClick)
        val listener = ButtonClickListener()
        btClick.setOnClickListener(listener)

        val btClear = findViewById<Button>(R.id.btClear)
        btClear.setOnClickListener(listener)
    }

    // 戻る矢印押下を処理する
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var returnVal = true
        // 戻るボタンのR値はandroid.R.id.home
        if(item.itemId == android.R.id.home) {
            // アクティビティ終了
            finish()
        } else {
            returnVal = super.onOptionsItemSelected(item)
        }
        return returnVal
    }

    // タップイベントに対してのリスナクラス（View.OnClickListener）
    //    リスナインターフェースは、ほとんどViewクラスのメンバインターフェースとして定義されている
    private inner class ButtonClickListener: View.OnClickListener {
        override fun onClick(view: View) {
            val input = findViewById<EditText>(R.id.etInput)
            val output = findViewById<TextView>(R.id.tvOutput)

            when(view.id) {
                R.id.btClick -> {
                    val inputStr = input.text.toString()
                    output.text = inputStr
                }
                R.id.btClear -> {
                    input.setText("")
                    output.text = ""
                }
            }
        }
    }
}
