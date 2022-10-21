package com.example.menu_makanan_ademohsatrio;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;


public class MenuDaftarMakanan extends AppCompatActivity {

    ListView lvItem;
    EditText Edtcari;
    ListViewAdapter adapter;
    ArrayList<ListViewAdapterMenu> arraylist = new ArrayList<ListViewAdapterMenu>();

    int[] Gambar;
    String[] NamaItem;
    String[] HargaItem;
    String[] Deskripsi;
    String[] NomorHP;
    String[] Lat;
    String[] Long;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_daftar_makanan);

        lvItem		= (ListView)findViewById(R.id.listView1);
        Edtcari     = (EditText)findViewById(R.id.editText1);


        Gambar		= new int[]{
                R.mipmap.a_orakarik,
                R.mipmap.b_magelangan,
                R.mipmap.c_nasigoreng,
                R.mipmap.d_buburkacangijo,
                R.mipmap.e_omelet};

        NamaItem 	= new String[]{
                "Orak Arik Ayam",
                "Magelangan",
                "Nasi Goreng",
                "Bubur Kacang Ijo",
                "Omelet"};

        HargaItem 	= new String[]{
                "Rp. 12.000",
                "Rp. 13.000",
                "Rp. 10.000",
                "Rp. 7.000",
                "Rp. 11.000"};

        Deskripsi 	= new String[]{
                "Orak Arik Ayam merupakan makanan kesukaan para mahasiswa" +
                        " dengan harga yang murah, anda bisa menikmati ayam yang lezat",

                "Magelangan adalah makanan kesukaan para anak kost, karena" +
                        " di dalam magelangan terkandung banyak nasi dan mie yang mengenyangkan",

                "Nasi Goreng yang jelas makanan favorit masyarakat" +
                        " Nasi Goreng ini banyak varian menunya anda tinggal pilih",

                "Bubur Kacang Ijo yaitu kacang hijau yang dibuat seperti bubur"+
                        " Bubur Kacang Ijo sangat cocok untuk anda yng ingin memakan selain nasi",

                "Omelet merupakan campuran antara telur dan mie"};


        NomorHP  = new String[]{
                "+6285227338132",
                "+6285227338132",
                "+6285227338132",
                "+6285227338132",
                "+6285227338132"
        };

        Lat  = new String[]{
                "-7.0268812",
                "-7.0268812",
                "-7.0268812",
                "-7.0268812",
                "-7.0268812"
        };

        Long  = new String[]{
                "110.424669",
                "110.424669",
                "110.424669",
                "110.424669",
                "110.424669"
        };


        for (int i = 0; i < NamaItem.length; i++)
        {
            ListViewAdapterMenu wp = new ListViewAdapterMenu(NamaItem[i], HargaItem[i], Deskripsi[i], Gambar[i], NomorHP[i], Lat[i], Long[i]);
            arraylist.add(wp);
        }

        adapter = new ListViewAdapter(this, arraylist);
        lvItem.setAdapter(adapter);

        Edtcari.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                String text = Edtcari.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
                showToastMessage("Pencarian dilakukan");
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
        });

    }

    void showToastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
