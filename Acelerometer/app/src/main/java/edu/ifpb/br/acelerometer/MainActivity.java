package edu.ifpb.br.acelerometer;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener{

    private TextView xText;
    private TextView yText;
    private TextView zText;
    private Sensor sensor;
    private SensorManager SM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Criando o SensorManager
        SM = (SensorManager) getSystemService(SENSOR_SERVICE);

        //Sensor do Acelerometro
        sensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //SensorListener
        SM.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        //TextViews
        xText = (TextView) findViewById(R.id.xTextView);
        yText = (TextView) findViewById(R.id.yTextView);
        zText = (TextView) findViewById(R.id.zTextView);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        xText.setText("X : " + event.values[0]);

        Log.i("Accelerometer", "onSensorChanged" + event.values[0]);

        yText.setText("Y : " + event.values[1]);

        Log.i("Accelerometer", "onSensorChanged" + event.values[1]);

        zText.setText("Z : " + event.values[2]);

        Log.i("Accelerometer", "onSensorChanged" + event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

        //Não será utilizado
        Log.i("Accelerometer", "onSensorChanged");

    }
}
