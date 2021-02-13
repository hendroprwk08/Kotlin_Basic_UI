package com.example.kotlinbasicui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    var radioGroup: RadioGroup? = null
    lateinit var radioButton: RadioButton
    var hobi: String = "" // default kosong

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inisialisasi objek
        val etNama = findViewById<EditText>(R.id.et_nama)
        val etAlamat = findViewById<EditText>(R.id.et_alamat)
        val etNpm = findViewById<EditText>(R.id.et_npm)
        val spProdi = findViewById<Spinner>(R.id.sp_prodi)
        val cbTeknologi = findViewById<CheckBox>(R.id.cb_teknologi)
        val cbKuliner = findViewById<CheckBox>(R.id.cb_kuliner)
        val btDetil = findViewById<Button>(R.id.bt_detil)
        val btToast = findViewById<Button>(R.id.bt_toast)
        val btDialog = findViewById<Button>(R.id.bt_dialog)
        val btNotif = findViewById<Button>(R.id.bt_notif)
        val btSnack = findViewById<Button>(R.id.bt_snack)
        val btKeluar = findViewById<Button>(R.id.bt_keluar)

        // Assigning id of RadioGroup
        radioGroup = findViewById(R.id.rg_domisili)

        btDetil.setOnClickListener {
            // from the radio group
            val selectedOption: Int = radioGroup!!.checkedRadioButtonId
            // Assigning id of the checked radio button
            radioButton = findViewById(selectedOption)

            // cek hobi
            hobi = ""
            if ( cbKuliner.isChecked ) hobi += "Kuliner, "
            if ( cbTeknologi.isChecked ) hobi += "Teknologi, "
            hobi = hobi.subSequence(0, hobi.length - 2).toString();

            var pesan = "Nama: "+etNama.text.toString() +"\nAlamat: "+ etAlamat.text.toString() +"\nNPM: " + etNpm.text.toString() +"\nDomisili: " + radioButton.text.toString() +"\nHobi: "+ hobi +"\nProdi: "+ spProdi.selectedItem.toString()
            Toast.makeText(baseContext, pesan, Toast.LENGTH_SHORT).show()
        }
    }
}