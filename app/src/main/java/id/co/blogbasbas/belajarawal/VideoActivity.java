package id.co.blogbasbas.belajarawal;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    //deklarasi variabel
    VideoView videoView;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        //inisialiasasi komponen
        inisialiasivideo();

        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.requestFocus();
        //kita buat folder raw di res
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.imastudio));
        //jika ingin memutar video streaming bisa pakai yang dibawah ini
       // videoView.setVideoURI(Uri.parse("http://idn.id/semarang/tes/tatacara.mp4"));
        videoView.start();



    }

    private void inisialiasivideo() {
        videoView = (VideoView) findViewById(R.id.videoView);

    }
}
