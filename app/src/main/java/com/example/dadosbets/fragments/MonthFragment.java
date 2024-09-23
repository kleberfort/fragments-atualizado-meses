package com.example.dadosbets.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dadosbets.R;
import com.example.dadosbets.adapter.MonthRecyclerViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MonthFragment extends Fragment {

    private static final String ARG_MONTH_NAME = "month_name";
    private static final String ARG_YEAR = "year";
    private String monthName;
    private int year;





    public static MonthFragment newInstance(String monthName, int year) {
        MonthFragment fragment = new MonthFragment();
        Bundle args = new Bundle();
        args.putString(ARG_MONTH_NAME, monthName);
        args.putInt(ARG_YEAR, year);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            monthName = getArguments().getString(ARG_MONTH_NAME);
            year = getArguments().getInt(ARG_YEAR);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar o layout para este fragmento
        View view = inflater.inflate(R.layout.fragment_month, container, false);

        // Configura o TextView para exibir o nome do mês e o ano
        TextView monthTextView = view.findViewById(R.id.text_month);
        monthTextView.setText(String.format("%s %d", monthName, year));

        // Configurar o RecyclerView (caso tenha)
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MonthRecyclerViewAdapter(new ArrayList<>()));

        // Configurar o FloatingActionButton
        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            // Ação do botão flutuante
            Toast.makeText(getContext(), "Floating button clicked", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}