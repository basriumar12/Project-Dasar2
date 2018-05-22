package id.co.blogbasbas.belajarawal;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.io.IOException;

public class RadioActivity extends AppCompatActivity {
    //deklarsi dua button dan 1 progresbar

    Button btnStop, btnPlay;
    ProgressBar pd;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        //inisilisasi
        btnStop = (Button) findViewById(R.id.btnStop);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        pd = (ProgressBar) findViewById(R.id.proggressbar);

        // progresbar di setInderterminate
        pd.setIndeterminate(true);

        //progresbar di buat tidak terlihat dulu pada saat app dijalankan
        pd.setVisibility(View.INVISIBLE);
        //btn stop juga di buat tidak terlihat
        btnStop.setVisibility(View.GONE);

        //setelah itu kita buat btnPlay ada event klik
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //player masih merah, karena kita belum deklarasi klass media player
                try {
                    //di pakai try dan catch agar bisa menangkap error dari program
                    player = new MediaPlayer();
                    //ini alamat url radio streaming
                    player.setDataSource("http://103.16.198.36:9160/stream");
                    player.prepareAsync();

                    player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            player.start();
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }

                // ketika button play di klik, maka button play di sembunyikan
                btnPlay.setVisibility(View.GONE);
                //btnstop di tampilkan
                btnStop.setVisibility(View.VISIBLE);
                //progresbar di jalankan
                pd.setVisibility(View.VISIBLE);


            }
        });

        //buat event stop
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if (player.isPlaying()){
                        player.stop();
                    }
                }catch (IllegalStateException e){
                    e.printStackTrace();
                }

               //btnplay di perlihatkan
                btnPlay.setVisibility(View.VISIBLE);
                //ketika btn stop di klik, maka btn stop di sembunyikan
                btnStop.setVisibility(View.GONE);
                //progras bar di sembyikan
                pd.setVisibility(View.INVISIBLE);
            }
        });





    }
}
