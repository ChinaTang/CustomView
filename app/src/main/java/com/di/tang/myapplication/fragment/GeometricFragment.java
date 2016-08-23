package com.di.tang.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.di.tang.myapplication.R;
import com.di.tang.myapplication.geometricview.FinguerView;

/**
 * Created by tangdi on 2016/8/19.
 */
public class GeometricFragment extends Fragment {

    private FinguerView finguerView;
    @Override
    public void onCreate(Bundle saveInstanceBundle){
        super.onCreate(saveInstanceBundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.geometric_fragment, container, false);
        //finguerView = (FinguerView)view.findViewById(R.id.fingure_view);
        return view;
    }


}
