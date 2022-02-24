package xyz.heydarrn.latihanexplicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ActivityDenganParcelable : AppCompatActivity() {
    lateinit var tvActivityDenganParcelable: TextView
    companion object{
        const val EXTRA_PERSON="nama_orang"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dengan_parcelable)
        tvActivityDenganParcelable=findViewById(R.id.tv_hasil_parcelable)

        val penduduk=intent.getParcelableExtra<Orang>(EXTRA_PERSON) as Orang
        val teks="Nama :${penduduk.nama.toString()}, \n Email : ${penduduk.email.toString()}, \n Umur : ${penduduk.umur.toString()}, \n Lokasi: ${penduduk.kota.toString()}"
        tvActivityDenganParcelable.text=teks

    }
}