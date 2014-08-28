package codes.project.sameera.o_project;

import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by samd90 on 8/27/14.
 */
public class Fragment_tests extends Fragment {
    TextView text;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test,container,false);
        text = (TextView) view.findViewById(R.id.textViewp);
        return view;
    }

    public void changeData(int index){
        String[] test= getResources().getStringArray(R.array.test);
        text.setText(test[index]);
    }

}
