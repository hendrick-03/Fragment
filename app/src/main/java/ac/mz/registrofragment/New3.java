package ac.mz.registrofragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link New3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class New3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public New3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment New3.
     */
    // TODO: Rename and change types and number of parameters
    public static New3 newInstance(String param1, String param2) {
        New3 fragment = new New3();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new3, container, false);

        RadioButton listaleit = view.findViewById(R.id.listarLeitbtn);
        RadioButton listarTodos = view.findViewById(R.id.Listartodos_2);
        RadioButton listarmaiores = view.findViewById(R.id.listarpaenas_25);

        Button listarbtn = view.findViewById(R.id.listarbtn);

        listarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (listarTodos.isChecked()){
                    exibirListaEstudante(DataAcessObject.estudantes);


                }else if(listarmaiores.isChecked()){
                    ArrayList<Estudantes> estudantesMaiores = obterEstudantesMaiorDe25();
                    exibirListaEstudante(estudantesMaiores);


                }

            }
        });


        return view;

    }

    public void exibirListaEstudante(ArrayList<Estudantes>estudantes){
        New2 new2Fragment = new New2();
        new2Fragment.setListaEstudante(estudantes);

        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.new2, new2Fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }

    private ArrayList<Estudantes> obterEstudantesMaiorDe25(){
        ArrayList<Estudantes> estudantesMaiores = new ArrayList<>();

        for(Estudantes estudantes: DataAcessObject.estudantes){
            if (estudantes.getIdade()> 25){
                estudantesMaiores.add(estudantes);
            }
        }
        return estudantesMaiores;
    }

}