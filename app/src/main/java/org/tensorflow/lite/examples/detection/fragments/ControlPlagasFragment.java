package org.tensorflow.lite.examples.detection.fragments;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.tensorflow.lite.examples.detection.AporqueDialog;
import org.tensorflow.lite.examples.detection.DesyerbaDialog;
import org.tensorflow.lite.examples.detection.EmergenciaDialog;
import org.tensorflow.lite.examples.detection.FloracionDialog;
import org.tensorflow.lite.examples.detection.MaduracionDialog;
import org.tensorflow.lite.examples.detection.R;
import org.tensorflow.lite.examples.detection.SiembraDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class ControlPlagasFragment extends Fragment {


    public ControlPlagasFragment() {
        // Required empty public constructor
    }

    private View view;
    private CardView cardSiembra;
    private CardView cardEmergencia;
    private CardView cardDesyerba;
    private CardView cardAporque;
    private CardView cardFloracion;
    private CardView cardMaduracion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_control_plagas, container, false);
        cardSiembra = view.findViewById(R.id.cardsiembra);
        cardEmergencia = view.findViewById(R.id.cardemergencia);
        cardDesyerba = view.findViewById(R.id.carddesyerba);
        cardAporque = view.findViewById(R.id.cardaporque);
        cardFloracion = view.findViewById(R.id.cardfloracion);
        cardMaduracion = view.findViewById(R.id.cardmaduracion);
        cardSiembra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSiembra();
            }
        });
        cardEmergencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEmergencia();
            }
        });
        cardDesyerba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDesyerba();
            }
        });
        cardAporque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAporque();
            }
        });
        cardFloracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFloracion();
            }
        });
        cardMaduracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMaduracion();
            }
        });
        return view;
    }

    private void openSiembra() {
        SiembraDialog siembraDialog = new SiembraDialog();
        siembraDialog.show(getFragmentManager(),"Siembra");
    }
    private void openEmergencia() {
        EmergenciaDialog emergenciaDialog = new EmergenciaDialog();
        emergenciaDialog.show(getFragmentManager(),"Emergencia");
    }
    private void openDesyerba() {
        DesyerbaDialog desyerbaDialog = new DesyerbaDialog();
        desyerbaDialog.show(getFragmentManager(),"Desyerba");
    }
    private void openAporque() {
        AporqueDialog aporqueDialog = new AporqueDialog();
        aporqueDialog.show(getFragmentManager(),"Aporque");
    }
    private void openFloracion() {
        FloracionDialog floracionDialog = new FloracionDialog();
        floracionDialog.show(getFragmentManager(),"Floración");
    }
    private void openMaduracion() {
        MaduracionDialog maduracionDialog = new MaduracionDialog();
        maduracionDialog.show(getFragmentManager(),"Maduración");
    }
}
