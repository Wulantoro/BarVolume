package com.wulantorodev.calculatordicoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.wulantorodev.calculatordicoding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding

//    private lateinit var edtLength: EditText
//    private lateinit var edtWidth: EditText
//    private lateinit var edtHeight: EditText
//    private lateinit var btnCalculate: Button
//    private lateinit var tvResult: TextView


    //for orientation scren, so that the value is not lost
    companion object {
        private const val STATE_RESULT = "state_result"
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)


        outState.putString(STATE_RESULT, binding.tvResult.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)



//        edtLength  = findViewById(R.id.edt_lenght)
//        edtWidth  = findViewById(R.id.edt_width)
//        edtHeight  = findViewById(R.id.edt_height)
//        btnCalculate  = findViewById(R.id.btn_calculate)
//        tvResult  = findViewById(R.id.tv_result)

            binding.btnCalculate.setOnClickListener (this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            binding.tvResult.text = result
        }
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_calculate) {
            val inputLenght = binding.edtLenght.text.toString().trim()
            val inputWidth = binding.edtWidth.text.toString().trim()
            val inputHeight = binding.edtHeight.text.toString().trim()

            var isEmptyField = false

            if (inputLenght.isEmpty()) {
                isEmptyField = true
                binding.edtLenght.error = "fie;d ini tidak boleh kossong"
            }

            if (inputWidth.isEmpty()) {
                isEmptyField = true
                binding.edtWidth.error = "fie;d ini tidak boleh kossong"
            }

            if (inputHeight.isEmpty()) {
                isEmptyField = true
                binding.edtHeight.error = "fie;d ini tidak boleh kossong"
            }

            if (!isEmptyField) {
                val volume = inputLenght.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                binding.tvResult.text = volume.toString()
            }
        }
    }
}