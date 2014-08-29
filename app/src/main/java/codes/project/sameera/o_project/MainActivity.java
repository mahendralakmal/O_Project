package codes.project.sameera.o_project;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by sameera on 8/29/14.
 */
public class MainActivity extends Activity implements Fragment_name_list.Communicator {
    Fragment_name_list f1;
    Fragment_tests f2;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        manager=getFragmentManager();
        f1 = (Fragment_name_list) manager.findFragmentById(R.id.fragment);
        f1.setCommunicator(this);
        //ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,result);

    }

    @Override
    public void respond(int index) {
        f2 = (Fragment_tests) manager.findFragmentById(R.id.fragment2);
        //if(f2!=null && f2.isVisible()){
            f2.changeData(index);
     //   }
       // else{
      //      Intent i = new Intent(this,Another_Activity.class);
      //      i.putExtra("index",index);

       //     startActivity(i);
      //  }


    }
}
