package ru.mirea.martynovmv.mireaproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ru.mirea.martynovmv.mireaproject.databinding.FragmentPracticeFiveBinding;
import ru.mirea.martynovmv.mireaproject.databinding.FragmentPracticeFourBinding;
import ru.mirea.martynovmv.mireaproject.databinding.FragmentPracticeSixBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link practiceFive#newInstance} factory method to
 * create an instance of this fragment.
 */
public class practiceFive extends Fragment implements SensorEventListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private SensorManager sensorManager;
    private Sensor pressureSensor;

    private Context mContext;

    private boolean isWork = false;

    private static final int REQUEST_CODE_PERMISSION = 100;

    private FragmentPracticeFiveBinding binding;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public practiceFive() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment practiceFive.
     */
    // TODO: Rename and change types and number of parameters
    public static practiceFive newInstance(String param1, String param2) {
        practiceFive fragment = new practiceFive();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentPracticeFiveBinding.inflate(inflater, container, false);
        View v = binding.getRoot();
        mContext = inflater.getContext();
        sensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
        pressureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_PRESSURE);
        if (sensorList.isEmpty()) {
            Toast.makeText(mContext, "Данный датчик не поддерживается на вашем устройстве", Toast.LENGTH_SHORT).show();
        }

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        sensorManager.registerListener(this, pressureSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause() {
        super.onPause();

        sensorManager.unregisterListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PRESSURE) {
            float pressure = event.values[0];
            if (pressure>=950)
            {
                binding.textViewPressureStatus.setText("Крайне высокое давление:"+pressure);
            }
            if (pressure>=780 && pressure<950)
            {
                binding.textViewPressureStatus.setText("Высокое давление:"+pressure);
            }
            if (pressure>=740 && pressure<780)
            {
                binding.textViewPressureStatus.setText("Нормальное давление:"+pressure);
            }
            if(pressure<740)
            {
                binding.textViewPressureStatus.setText("Низкое давление:"+pressure);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}