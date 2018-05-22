package id.co.blogbasbas.belajarawal;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpinnerActivity extends AppCompatActivity {

    //buat array untuk si spinner, kita copy pada projek yang sudah di sediakan
    String namabuah []= {"alpukat","duruian","jambuair","manggis","strawbery"};
    //array untuk mendklarasi file gambar
    int gambarbuah[]= {R.drawable.alpukat,R.drawable.durian,R.drawable.jambuair,
            R.drawable.manggis,R.drawable.strawberry};
    //masih merah, karena di folder raw, belum ada file mp3, jadi kita copy dulu di projek sbelumnya
    int suarabuah[]= {R.raw.alpukat,R.raw.durian,R.raw.jambuair,
            R.raw.manggis,R.raw.strawberry};


    //variabel di dekalarsi dan di inisialisasi oelh libarary
    @BindView(R.id.spinnerbuah)
    Spinner spinnerbuah;
    @BindView(R.id.imgBuah)
    ImageView imgBuah;
    @BindView(R.id.txtBuah)
    TextView txtBuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        ButterKnife.bind(this);
        //setelah buat array kita buat adapternya

        ArrayAdapter adapter = new ArrayAdapter(SpinnerActivity.this, android.R.layout.simple_spinner_item,namabuah);
        //kita copy lanjutannya di projek sbelumnya
        //adapter di set pada spinner yang dropdwon
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //objek dari spinner yang telah kita buat di set adpater
        spinnerbuah.setAdapter(adapter);


        //skrang kuta buat si spinner bisa di pilih
        spinnerbuah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posisi, long l) {
               //nama buah di set sesuai posisi di set text
                txtBuah.setText(namabuah[posisi]);
                //ambil gambar dan set sesusai posisi
                imgBuah.setImageResource(gambarbuah[posisi]);

                //set suara ketika gambar buah di pilih akan ada suara dengan menggunakan kelas mediaplayer
                MediaPlayer mediaPlayer = new MediaPlayer();
                Uri lokasi = Uri.parse("android.resource://"+getPackageName()+"/"
                        +suarabuah[posisi]);
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try{
                    mediaPlayer.setDataSource(SpinnerActivity.this,lokasi);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {




            }
        });
    }
}
