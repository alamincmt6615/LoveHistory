package com.example.sweetlovestory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adView = new AdView(this, (getString(R.string.facebook_banner)), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);
        String deviceId = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        Log.d("id: ",deviceId);

        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                AdvertisingIdClient.Info idInfo = null;
                try {
                    idInfo = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext());
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String advertId = null;
                try{
                    advertId = idInfo.getId();
                }catch (NullPointerException e){
                    e.printStackTrace();
                }

                return advertId;
            }

            @Override
            protected void onPostExecute(String advertId) {
              //  Toast.makeText(getApplicationContext(), advertId, Toast.LENGTH_SHORT).show();
            }

        };
        task.execute();






        adView.setAdListener(new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(MainActivity.this, "Error: " + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show();
            }


            @Override
            public void onAdLoaded(Ad ad) {
                // Ad loaded callback
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
            }
        });


        // Request an ad
        adView.loadAd();


        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(this);
        btn10 = findViewById(R.id.btn10);
        btn10.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                return;
            case R.id.btn2:
                Intent intent2 = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent2);
                return;
            case R.id.btn3:
                Intent intent3 = new Intent(MainActivity.this,Main4Activity.class);
                startActivity(intent3);
                return;
            case R.id.btn4:
                Intent intent4 = new Intent(MainActivity.this,Main5Activity.class);
                startActivity(intent4);
                return;
            case R.id.btn5:
                Intent intent5 = new Intent(MainActivity.this,Main6Activity.class);
                startActivity(intent5);
                return;
            case R.id.btn6:
                Intent intent6 = new Intent(MainActivity.this,Main7Activity.class);
                startActivity(intent6);
                return;
            case R.id.btn7:
                Intent intent7 = new Intent(MainActivity.this,Main8Activity.class);
                startActivity(intent7);
                return;
            case R.id.btn8:
                Intent intent8 = new Intent(MainActivity.this,Main9Activity.class);
                startActivity(intent8);
                return;
            case R.id.btn9:
                Intent intent9 = new Intent(MainActivity.this,Main10Activity.class);
                startActivity(intent9);
                return;
            case R.id.btn10:
                Intent intent10 = new Intent(MainActivity.this,Main11Activity.class);
                startActivity(intent10);
                return;
        }
    }
}
