package codes.project.sameera.o_project;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.zip.Inflater;

/**
 * Created by samd90 on 8/27/14.
 */
public class Fragment_name_list extends Fragment implements AdapterView.OnItemClickListener {
    ListView nameList;
    Communicator communicator;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_name_list,container,false);
        nameList = (ListView) view.findViewById(R.id.listViewname);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),R.array.test,android.R.layout.simple_list_item_1);
        nameList.setAdapter(adapter);
        nameList.setOnItemClickListener(this);
        return view;
    }

    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        communicator.respond(i);
    }

    public interface Communicator{
        public void respond(int index);
    }
}
