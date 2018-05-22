package id.co.blogbasbas.belajarawal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //deklarasi variabel si button
    Button btnVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisialiasasi komponen, dengan buat method baru
        //tekan alt + enter
        iniasilisasiKomponen();
        //buat fungsi onklik pada button video
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, VideoActivity.class));
            }
        });

    }

    private void iniasilisasiKomponen() {

        //inisialisasi buttonvideo
        btnVideo = (Button) findViewById(R.id.btnvideo);
    }

    //ini method onclik dari button radio
    public void radioActivity(View view) {
        startActivity(new Intent(MainActivity.this, RadioActivity.class));
    }

    public void SpinnerActivity(View view) {
        startActivity(new Intent(MainActivity.this, SpinnerActivity.class));
    }
}
