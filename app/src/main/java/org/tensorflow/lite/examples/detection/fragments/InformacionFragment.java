package org.tensorflow.lite.examples.detection.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.tensorflow.lite.examples.detection.R;
import org.tensorflow.lite.examples.detection.interfaces.IComunicaFragments;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformacionFragment extends Fragment {


    public InformacionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista= inflater.inflate(R.layout.fragment_informacion, container, false);
        cardinsectopm=vista.findViewById(R.id.cardinsectopm);
        cardinsectopm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceComunicafragments.ciclopm();
            }
        });
        cardminador=vista.findViewById(R.id.cardminador);
        cardminador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceComunicafragments.ciclominador();
            }
        });

        return vista;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof Activity ){
            actividad=(Activity) context;
            interfaceComunicafragments= (IComunicaFragments) actividad;
        }
    }

    View vista;
    Activity actividad;
    CardView cardinsectopm,cardminador;

    IComunicaFragments interfaceComunicafragments;

}
