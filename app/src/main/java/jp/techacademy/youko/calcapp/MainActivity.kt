package jp.techacademy.youko.calcapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plus.setOnClickListener(this)
        minus.setOnClickListener(this)
        times.setOnClickListener(this)
        devided.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        if ((value1.length() == 0) || (value2.length() == 0)) {
            Snackbar.make(v,"数値を入力してください",Snackbar.LENGTH_LONG)
                .setAction("OK", null).show()
        } else {
            val value1 = value1.text.toString().toDouble()
            val value2 = value2.text.toString().toDouble()
            var result = 0.0

            Log.d("numbercheck",value1.toString() +"," + value2.toString() + "," + result.toString())
            when (v.id) {
                R.id.plus -> result = value1 + value2
                R.id.minus -> result = value1 - value2
                R.id.times -> result = value1 * value2
                R.id.devided -> result = value1 / value2
            }
            Log.d("numbercheck",value1.toString() +"," + value2.toString() + "," + result.toString())
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT", result)
            startActivity(intent)
        }
    }

}
