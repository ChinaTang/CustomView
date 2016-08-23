package com.di.tang.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.di.tang.myapplication.R;
import com.di.tang.myapplication.geometricview.AccordPlot;
import com.di.tang.myapplication.geometricview.FinguerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by tangdi on 2016/8/19.
 */
public class GeometricFragment extends Fragment {

    private FinguerView finguerView;
    private AccordPlot<Integer, Integer> accordPlot;
    @Override
    public void onCreate(Bundle saveInstanceBundle){
        super.onCreate(saveInstanceBundle);
    }

    private ArrayList<Integer> Xais = new ArrayList<Integer>();

    private ArrayList<Integer>Yais = new ArrayList<Integer>();

    private HashMap<Integer, Integer>XYmap = new HashMap<>();
    private Random random;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.geometric_fragment, container, false);
        //finguerView = (FinguerView)view.findViewById(R.id.fingure_view);
        random = new Random();
        for(int i = 0; i < 12; i++){
            Xais.add(i + 1);
            Yais.add(10 + i);
            XYmap.put(i + 1, random.nextInt(21));
        }

        accordPlot = (AccordPlot<Integer, Integer>)view.findViewById(R.id.accord_plot);
        accordPlot.setXaxis(Xais);
        accordPlot.setYaxis(Yais);
        accordPlot.setXYmap(XYmap);
        accordPlot.setXYaxis();
        return view;
    }


}
