package ac.mz.registrofragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link New1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class New1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public New1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment New1.
     */
    // TODO: Rename and change types and number of parameters
    public static New1 newInstance(String param1, String param2) {
        New1 fragment = new New1();
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
        View view = inflater.inflate(R.layout.fragment_new1, container, false);

        EditText nome = view.findViewById(R.id.nome_ed);
        EditText curso = view.findViewById(R.id.curso_ed);
        EditText idade = view.findViewById(R.id.idade_ed);

        Button gravar = view.findViewById(R.id.salvar_btn);
        Button listar = view.findViewById(R.id.listar);



        gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nome.getText().toString();
                String crs = curso.getText().toString();
                String ageString = idade.getText().toString();

                if(!TextUtils.isEmpty(ageString)){
                    try {
                        int age = Integer.parseInt(ageString);
                        Estudantes estudantes = new Estudantes(name, crs, age);
                        DataAcessObject.estudantes.add(estudantes);

                        Toast.makeText(getContext(), "Estudante Registrado com sucesso", Toast.LENGTH_SHORT).show();

                    }catch (NumberFormatException e){
                        Toast.makeText(getContext(), "Idade invalida", Toast.LENGTH_SHORT).show();

                    }
                }else{
                    Toast.makeText(getContext(), "Preencha tos os campos", Toast.LENGTH_SHORT).show();
                }

                    nome.setText("");
                    curso.setText("");
                    idade.setText("");

                }
        });

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                New2 new2 = new New2();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.new2, new2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });


        return view;




    }
}