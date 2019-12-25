package com.sreeyainfotech.fragwithtabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.sreeyainfotech.fragwithtabs.model.DataModel;

import java.util.ArrayList;

public class TabFragment extends Fragment {

    int position;
    private TextView textView;
    ArrayList<DataModel> dataModels;
    private View view;


    public static Fragment getInstance(ArrayList<DataModel> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("pos", arrayList);
        TabFragment tabFragment = new TabFragment();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataModels = (ArrayList<DataModel>) getArguments().getSerializable("pos");
        //   position = getArguments().getSerializable("pos");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tab, container, false);
        dataModels = (ArrayList<DataModel>) getArguments().getSerializable("pos");
        GridView recyclerView = (GridView) view.findViewById(R.id.recyclerview);

//        arrayList = getArguments().getParcelableArrayList("someInt");
//        GridView gridview = (GridView) view.findViewById(R.id.gridView);

        String[] mStrings = new String[dataModels.size()];
        for (int i = 0; i < dataModels.size(); i++) {
            mStrings[i] = dataModels.get(i).getName();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mStrings);

        recyclerView.setAdapter(adapter);


        return view;


//        return inflater.inflate(R.layout.fragment_tab, container, false);
    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        textView = (TextView) view.findViewById(R.id.textView);
//
//        textView.setText("Fragment " + (position + 1));
//
//    }
}