package xyz.heydarrn.latihanexplicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ActivityKetigaDenganData : AppCompatActivity() {

    companion object{
        const val EXTRA_AGE="extra_age"
        const val EXTRA_NAME="extra_name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ketiga_dengan_data)
        val textViewDataReceived:TextView=findViewById(R.id.textView_data_received)

        val name=intent.getStringExtra(EXTRA_NAME)
        val age=intent.getIntExtra(EXTRA_AGE,0)

        val setTextDiActivity="Nama : $name, Your age : $age"
        textViewDataReceived.text=setTextDiActivity

        val tvFriendsData:TextView=findViewById(R.id.textView_friends_data_received)

        val friendsName=intent.getStringExtra("friends-name")
        val friendsAge=intent.getIntExtra("friends-age",0)

        val setTVFriends="Hai! Saya adalah $friendsName, teman dari $name .\n Umur saya adalah $friendsAge "
        tvFriendsData.text=setTVFriends

    }
}