package ru.mirea.martynovmv.mireaproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mirea.martynovmv.mireaproject.databinding.FragmentPracticeSevenBinding;
import ru.mirea.martynovmv.mireaproject.databinding.FragmentPracticeSixBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link practiceSeven#newInstance} factory method to
 * create an instance of this fragment.
 */
public class practiceSeven extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private FragmentPracticeSevenBinding binding;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public practiceSeven() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment practiceSeven.
     */
    // TODO: Rename and change types and number of parameters
    public static practiceSeven newInstance(String param1, String param2) {
        practiceSeven fragment = new practiceSeven();
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
        binding = FragmentPracticeSevenBinding.inflate(inflater, container, false);
        View v = binding.getRoot();
        Intent intent = new Intent(getContext(), RegistrationActivity.class);
        startActivity(intent);
        return v;
    }
}