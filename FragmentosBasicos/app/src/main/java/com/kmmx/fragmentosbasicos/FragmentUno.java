package com.kmmx.fragmentosbasicos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentUno extends Fragment {

    Button button;
    EditText editText;


    public FragmentUno() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_uno, container, false);

        button = (Button) rootView.findViewById(R.id.btnUno);
        editText = (EditText) rootView.findViewById(R.id.edtxFragmentuno);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                Toast.makeText(getActivity(), name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
