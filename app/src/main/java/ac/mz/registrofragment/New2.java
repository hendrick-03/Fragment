package ac.mz.registrofragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link New2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class New2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public New2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment New2.
     */
    // TODO: Rename and change types and number of parameters
    public static New2 newInstance(String param1, String param2) {

        New2 fragment = new New2();
        Bundle args = new Bundle();
        args.putString("listaEstudantes", param1);
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
        View view = inflater.inflate(R.layout.fragment_new2, container, false);

        TextView textView = view.findViewById(R.id.textView);
        TextView listartodos = view.findViewById(R.id.Listartodos_2);


        String listaEstudantes = "listaEstudantes";

        New2 fragment = New2.newInstance(listaEstudantes, null);




        StringBuilder stringBuilder = new StringBuilder();
        for(Estudantes estudantes : DataAcessObject.estudantes){
            stringBuilder.append(estudantes.getNome())
                    .append(" - ")
                    .append(estudantes.getCurso())
                    .append(" - ")
                    .append(estudantes.getIdade())
                    .append("\n");

        }

        textView.setText(stringBuilder.toString());




        return  view;
    }

    public void setListaEstudante(ArrayList<Estudantes> estudantes){
        StringBuilder stringBuilder = new StringBuilder();
        for(Estudantes estudante : estudantes){
            stringBuilder.append(estudante.toString()).append("\n");
        }
        String listaFormtada = stringBuilder.toString();
        TextView textView = getView().findViewById(R.id.listartodos);
        textView.setText(listaFormtada);
    }

}