package codes.project.sameera.o_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by sameera on 8/29/14.
 */
public class Another_Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_activity);

        Intent intent =getIntent();
        int index = intent.getIntExtra("index",0);
        Fragment_tests f2 = (Fragment_tests) getFragmentManager().findFragmentById(R.id.fragment);
        if(f2!=null);
        f2.changeData(index);
    }
}
