package codes.project.sameera.o_project;

import android.app.Activity;

import android.app.FragmentManager;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Samy on 8/26/2014.
 */
public class Group_Add_test extends Activity implements Fragment_name_list.Communicator{
    private Spinner spinner;
    private Button save;
    String [] test = {
            "Test 1",
            "Test 2",
            "Test 3",
            "Test 4"

    };
    Fragment_name_list f1;
    Fragment_tests f2;
    FragmentManager manager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_add_test);

        save = (Button) findViewById(R.id.btnSave);
        spinner = (Spinner) findViewById(R.id.spinner);

        manager=getFragmentManager();
        f1 = (Fragment_name_list) manager.findFragmentById(R.id.fragment);
        f1.setCommunicator(this);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,test);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int sid = spinner.getSelectedItemPosition();
                Toast.makeText(getBaseContext(),"You Have Selected : " + test[sid],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    @Override
    public void respond(int index) {
        f2=(Fragment_tests) manager.findFragmentById(R.id.fragment2);

            f2.changeData(index);

    }
}
