package com.example.bina_mandiri.myapplication_inten_ok;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button alarmbutton ;
    private TextView textView1;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        alarmbutton = (Button) findViewById(R.id.alarmbutton);
        textView1 = (TextView) findViewById(R.id.textView1);
        imageButton = (ImageButton) findViewById(R.id.imageButton) ;

        alarmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dengan methode
                createAlarm("WAKTUNYA PULANG",8, 00 );

            }
        });

textView1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        openWabPage("https://developer.android.com");
    }
});
imageButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Uri geolocation = Uri.parse("geo:0,0?=-6.870628), 107.587594(Tel U)?z=18");
        shawMap(geolocation);
    }

    private void shawMap(Uri geolocation) {

        Intent mapInten = new Intent(Intent.ACTION_VIEW);
        mapInten.setData(geolocation);
        if (mapInten.resolveActivity(getPackageManager())!=null){
            startActivity(mapInten);
        }
    }
});}



    private void openWabPage(String url) {
        Toast.makeText(MainActivity.this, "opening Dev Doc", Toast.LENGTH_LONG).show();
        Uri webpage = Uri.parse(url);
        Intent broserintent  = new Intent( Intent.ACTION_VIEW, webpage);
        startActivity(broserintent);
    }

    // Methode
    public void  createAlarm(String message, int hour, int minutes){
    // signature
        Intent alarmInten = new Intent(AlarmClock.ACTION_SET_ALARM);
        alarmInten.putExtra(AlarmClock.EXTRA_MESSAGE,message);
        alarmInten.putExtra(AlarmClock.EXTRA_HOUR, hour);
        alarmInten.putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (alarmInten.resolveActivity(getPackageManager())!=null)
            startActivity(alarmInten);



    }

}
