package xyz.heydarrn.latihanexplicitintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btn1:Button
    lateinit var btnWithData:Button
    lateinit var btnKirimDenganParcelable:Button
    lateinit var btnTelponNomer:Button
    lateinit var btnPindahActivityWithResult: Button
    lateinit var textViewResult:TextView

    private val resultLauncher = registerForActivityResult( ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == BackToMainActivityWithResult.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(BackToMainActivityWithResult.EXTRA_SELECTED_VALUE, 0)
            textViewResult.text = "Hasil : $selectedValue"
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1=findViewById(R.id.btn_move_activity)
        btn1.setOnClickListener(this)

        btnWithData=findViewById(R.id.btn_move_activity_with_data)
        btnWithData.setOnClickListener(this)

        btnKirimDenganParcelable=findViewById(R.id.btn_kirim_parcelable)
        btnKirimDenganParcelable.setOnClickListener(this)

        btnTelponNomer=findViewById(R.id.btn_implicit_intent)
        btnTelponNomer.setOnClickListener(this)

        btnPindahActivityWithResult=findViewById(R.id.button_move_with_result)
        btnPindahActivityWithResult.setOnClickListener(this)
        textViewResult=findViewById(R.id.tv_result)


    }

    //TODO("Not yet implemented")
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity ->{
                val intentMove= Intent(this@MainActivity,ActivityKedua::class.java)
                startActivity(intentMove)

            }
            R.id.btn_move_activity_with_data->{
                val intentMoveWithData=Intent(this@MainActivity,ActivityKetigaDenganData::class.java)
                intentMoveWithData.putExtra(ActivityKetigaDenganData.EXTRA_NAME,"Naufal")
                intentMoveWithData.putExtra(ActivityKetigaDenganData.EXTRA_AGE,21)
                intentMoveWithData.putExtra("friends-name","Dicoding")
                intentMoveWithData.putExtra("friends-age",5)
                startActivity(intentMoveWithData)
            }
            R.id.btn_kirim_parcelable ->{
                val penduduk1=Orang(nama = "mr tono", umur = 20, kota = "Jakarta", email = "tono111@rocket.com")
                val intentDenganParcel = Intent(this@MainActivity, ActivityDenganParcelable::class.java)
                intentDenganParcel.putExtra(ActivityDenganParcelable.EXTRA_PERSON,penduduk1)
                startActivity(intentDenganParcel)
            }
            R.id.btn_implicit_intent ->{
                val nomerHP="082112345678"
                val panggilNomer=Intent(Intent.ACTION_DIAL, Uri.parse("tel:$nomerHP"))
                startActivity(panggilNomer)
            }
            R.id.button_move_with_result->{
                val moveWithResultToMain=Intent(this@MainActivity,BackToMainActivityWithResult::class.java)
                resultLauncher.launch(moveWithResultToMain)
            }
        }
    }
}