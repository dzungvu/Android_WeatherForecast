package com.software.dzungvu.myweatherapp;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.software.dzungvu.configuration.Configuration;
import com.software.dzungvu.configuration.ConfigurationNow;
import com.software.dzungvu.connect.ConnectData;
import com.software.dzungvu.connect.ConnectDataNow;
import com.software.dzungvu.model.OpenWeatherMap;
import com.software.dzungvu.model2.OpenWeatherMapNow;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements LocationListener {

    TextView txtCity, txtTime, txtDescription, txtTemperature, txtTemperatureMin, txtTemperatureMax, txtll0Day, txtll1Day, txtll2Day, txtll3Day, txtll4Day, txtll5Day;
    ImageView imgDescriptor, imgll0, imgll1, imgll2, imgll3, imgll4, imgll5;
    LinearLayout llMain, ll0, ll1, ll2, ll3, ll4, ll5;

    LocationManager locationManager;
    OpenWeatherMap openWeatherMap;
    OpenWeatherMapNow openWeatherMapNow;
    String provider;
    int MY_PERMISSION = 0;
    static double lat, lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }


    private void addControls() {
        txtCity = (TextView) findViewById(R.id.txtCity);
        txtTime = (TextView) findViewById(R.id.txtTime);
        txtDescription = (TextView) findViewById(R.id.txtDescription);
        txtTemperature = (TextView) findViewById(R.id.txtTemperature);
        txtTemperatureMin = (TextView) findViewById(R.id.txtTemperatureMin);
        txtTemperatureMax = (TextView) findViewById(R.id.txtTemperatureMax);
        txtll0Day = (TextView) findViewById(R.id.txtll0Day);
        txtll1Day = (TextView) findViewById(R.id.txtll1Day);
        txtll2Day = (TextView) findViewById(R.id.txtll2Day);
        txtll3Day = (TextView) findViewById(R.id.txtll3Day);
        txtll4Day = (TextView) findViewById(R.id.txtll4Day);
        txtll5Day = (TextView) findViewById(R.id.txtll5Day);

        imgDescriptor = (ImageView) findViewById(R.id.imgDescriptor);

        imgll0 = (ImageView) findViewById(R.id.imgll0);
        imgll1 = (ImageView) findViewById(R.id.imgll1);
        imgll2 = (ImageView) findViewById(R.id.imgll2);
        imgll3 = (ImageView) findViewById(R.id.imgll3);
        imgll4 = (ImageView) findViewById(R.id.imgll4);
        imgll5 = (ImageView) findViewById(R.id.imgll5);

        llMain = (LinearLayout) findViewById(R.id.llMain);
        ll0 = (LinearLayout) findViewById(R.id.ll0);
        ll1 = (LinearLayout) findViewById(R.id.ll1);
        ll2 = (LinearLayout) findViewById(R.id.ll2);
        ll3 = (LinearLayout) findViewById(R.id.ll3);
        ll4 = (LinearLayout) findViewById(R.id.ll4);
        ll5 = (LinearLayout) findViewById(R.id.ll5);

        llMain.setBackgroundResource(R.drawable.animation_drawable);
        AnimationDrawable animationDrawable = (AnimationDrawable) llMain.getBackground();
        animationDrawable.start();

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        provider = locationManager.getBestProvider(new Criteria(), false);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{

                    Manifest.permission.INTERNET,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, MY_PERMISSION);
        }
        Location location = locationManager.getLastKnownLocation(provider);
        if (location == null) {
            Log.e("TAG", "No location");
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{

                    Manifest.permission.INTERNET,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, MY_PERMISSION);
        }
        locationManager.requestLocationUpdates(provider, 400, 1, this);
        Location location = locationManager.getLastKnownLocation(provider);

        lat = location.getLatitude();
        lng = location.getLongitude();
    }

    private void addEvents() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{

                    Manifest.permission.INTERNET,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, MY_PERMISSION);
        }
        locationManager.requestLocationUpdates(provider, 400, 1, this);
        Location location = locationManager.getLastKnownLocation(provider);

        lat = location.getLatitude();
        lng = location.getLongitude();
        GetWeatherForcast task = new GetWeatherForcast();
        task.execute(Configuration.apiRequest(String.valueOf(lat), String.valueOf(lng)));
        GetWeatherNow taskNow = new GetWeatherNow();
        taskNow.execute(ConfigurationNow.apiRequest(String.valueOf(lat), String.valueOf(lng)));

        ll0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectLL0();
            }
        });

        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectLL1();
            }
        });

        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectLL2();
            }
        });

        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectLL3();
            }
        });

        ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectLL4();
            }
        });

        ll5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectLL5();
            }
        });
    }

    private void selectLL5() {
        getInfor(5);

    }

    private void selectLL4() {
        getInfor(4);

    }

    private void selectLL3() {
        getInfor(3);

    }

    private void selectLL2() {
        getInfor(2);

    }

    private void selectLL1() {
        getInfor(1);
    }

    private void selectLL0() {
        getInfor(0);
    }

    //Take image from internet and set it as background
    private Bitmap getImageForBackground(String link){
        Bitmap bitmap = null;
        try {
            URL url = new URL(link);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    //Todo: get infor for day ith
    private void getInfor(int i){
        txtTime.setText(String.format("Weather show for: %s"
                , Configuration.unixTimeStampToDateTimeToShowBig(openWeatherMap.getList().get(i).getDt())));


        Picasso.with(MainActivity.this)
                .load(Configuration.getImage(openWeatherMap.getList().get(i).getWeather().get(0).getIcon()))
                .into(imgDescriptor);
        txtDescription.setText(String.format("%s"
                , openWeatherMap.getList().get(i).getWeather().get(0).getDescription()));
        txtTemperature.setText(String.format("Morn: %.2f °C\nDay: %.2f °C\nEve: %.2f °C\nNight: %.2f °C"
                , openWeatherMap.getList().get(i).getTemp().getMorn()
                , openWeatherMap.getList().get(i).getTemp().getDay()
                , openWeatherMap.getList().get(i).getTemp().getEve()
                , openWeatherMap.getList().get(i).getTemp().getNight()));


    }


    private class GetWeatherNow extends AsyncTask<String, Void, String>{
        protected String doInBackground(String... strings) {
            String stream = null;
            String urlString = strings[0];
            ConnectDataNow http = new ConnectDataNow();
            stream = http.getHTTPData(urlString);
            return stream;
        }

        @Override
        protected void onPostExecute(String s) {
            if (s == null){
                Toast.makeText(MainActivity.this, "Couldn't get temperature for now", Toast.LENGTH_LONG).show();
                return;
            }
            Gson gson = new Gson();
            Type mType = new TypeToken<OpenWeatherMapNow>(){}.getType();
            openWeatherMapNow = gson.fromJson(s,mType);
            txtTemperatureMin.setText(String.format("Now (%s)", ConfigurationNow.getDayNow().toString()));
            txtTemperatureMax.setText(String.format("%.2f °C", openWeatherMapNow.getMain().getTemp()-273.15));
        }
    }


    private class GetWeatherForcast extends AsyncTask<String, Void, String>{

        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setTitle("Please wait...");
            progressDialog.setMessage("Getting data");
            progressDialog.show();
        }


        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(String... strings) {

            String stream = null;
            String urlString = strings[0];
            ConnectData connectData = new ConnectData();
            stream = connectData.getHTTPData(urlString);
            return stream;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s == null){
                Toast.makeText(MainActivity.this, "Couldn't get data from server", Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
                return;
            }
            else{
                Gson gson = new Gson();
                Type mType = new TypeToken<OpenWeatherMap>(){}.getType();
                openWeatherMap = gson.fromJson(s, mType);
                progressDialog.dismiss();
                txtCity.setText(String.format("%s, %s", openWeatherMap.getCity().getName()
                        , openWeatherMap.getCity().getCountry()));
                getInfor(0);

                txtll0Day.setText(String.format("%s"
                        , Configuration.unixTimeStampToDateTime(openWeatherMap.getList().get(0).getDt())));
                txtll1Day.setText(String.format("%s"
                        , Configuration.unixTimeStampToDateTime(openWeatherMap.getList().get(1).getDt())));
                txtll2Day.setText(String.format("%s"
                        , Configuration.unixTimeStampToDateTime(openWeatherMap.getList().get(2).getDt())));
                txtll3Day.setText(String.format("%s"
                        , Configuration.unixTimeStampToDateTime(openWeatherMap.getList().get(3).getDt())));
                txtll4Day.setText(String.format("%s"
                        , Configuration.unixTimeStampToDateTime(openWeatherMap.getList().get(4).getDt())));
                txtll5Day.setText(String.format("%s"
                        , Configuration.unixTimeStampToDateTime(openWeatherMap.getList().get(5).getDt())));

                imgll0.setImageBitmap(getImageForBackground(Configuration.getImage(openWeatherMap.getList().get(0).getWeather().get(0).getIcon())));
                imgll1.setImageBitmap(getImageForBackground(Configuration.getImage(openWeatherMap.getList().get(1).getWeather().get(0).getIcon())));
                imgll2.setImageBitmap(getImageForBackground(Configuration.getImage(openWeatherMap.getList().get(2).getWeather().get(0).getIcon())));
                imgll3.setImageBitmap(getImageForBackground(Configuration.getImage(openWeatherMap.getList().get(3).getWeather().get(0).getIcon())));
                imgll4.setImageBitmap(getImageForBackground(Configuration.getImage(openWeatherMap.getList().get(4).getWeather().get(0).getIcon())));
                imgll5.setImageBitmap(getImageForBackground(Configuration.getImage(openWeatherMap.getList().get(5).getWeather().get(0).getIcon())));

            }
        }

    }

}
