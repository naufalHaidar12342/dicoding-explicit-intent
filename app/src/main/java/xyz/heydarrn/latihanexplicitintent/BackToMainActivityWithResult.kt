package xyz.heydarrn.latihanexplicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class BackToMainActivityWithResult : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnChoose: Button
    private lateinit var rgNumber: RadioGroup

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back_to_main_with_result)

        btnChoose = findViewById(R.id.button_pilih)
        rgNumber = findViewById(R.id.radio_group_number)

        btnChoose.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        //TODO("Not yet implemented")
        if (p0?.id == R.id.button_pilih){
            if (rgNumber.checkedRadioButtonId >0){
                var value=0
                when(rgNumber.checkedRadioButtonId){
                    R.id.radio_button_50 -> value=50
                    R.id.radio_button_100->value=100
                    R.id.radio_button_150->value=150
                    R.id.radio_button_200->value=200
                }

                val resultIntent =Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }
}