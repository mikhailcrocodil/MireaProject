package ru.mirea.martynovmv.mireaproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mirea.martynovmv.mireaproject.databinding.FragmentMapBinding;
import ru.mirea.martynovmv.mireaproject.databinding.FragmentPracticeSixBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link practiceSix#newInstance} factory method to
 * create an instance of this fragment.
 */
public class practiceSix extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private FragmentPracticeSixBinding binding;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public practiceSix() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment practiceSix.
     */
    // TODO: Rename and change types and number of parameters
    public static practiceSix newInstance(String param1, String param2) {
        practiceSix fragment = new practiceSix();
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
        binding = FragmentPracticeSixBinding.inflate(inflater, container, false);
        View v = binding.getRoot();
        SharedPreferences preferences = getContext().getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);
        String breed = preferences.getString("Breed", "unknown");
        String catname = preferences.getString("Catname", "unknown");

        binding.edBreed.setText(breed);
        binding.edCatname.setText(catname);
        binding.btnSaveCatInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences_bt = getContext().getSharedPreferences("mirea_settings",	Context.MODE_PRIVATE);
                SharedPreferences.Editor editor_bt	= preferences_bt.edit();
                editor_bt.putString("Breed", binding.edBreed.getText().toString());
                editor_bt.putString("Catname",binding.edCatname.getText().toString());
                editor_bt.apply();
            }
        });
        return v;
    }
}