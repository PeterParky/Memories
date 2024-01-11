package app.main.memories.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.memories.R;

public class SetAva_Fragment extends Fragment {

    //initializing variables
    private static final String IMAGE = "src";
    private static final String TEXT = "txt";

    private ImageButton btn_SetImage;
    private TextView tv_SetName;

    public SetAva_Fragment() {
        // Required empty public constructor
    }

    private int ARG_IMAGE;
    private String ARG_TEXT;

    // Function to create a new instance of fragment
    public static SetAva_Fragment newInstance(int IMG, String TXT) {
        SetAva_Fragment fragment = new SetAva_Fragment();
        Bundle args = new Bundle();
        args.putInt(IMAGE, IMG);
        args.putString(TEXT, TXT);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ARG_IMAGE = getArguments().getInt(IMAGE);
            ARG_TEXT = getArguments().getString(TEXT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_ava, container, false);
        // assign variables
        btn_SetImage = view.findViewById(R.id.btn_setImage);
        tv_SetName = view.findViewById(R.id.tv_setName);

        // Change the properties of ImageButton and TextView
        changeUIProperties();

        // Inflate the layout for this fragment
        return view;
    }

    private void changeUIProperties() {
        // Change the properties of ImageButton and TextView
        btn_SetImage.setImageResource(ARG_IMAGE);
        tv_SetName.setText(ARG_TEXT);
    }
}