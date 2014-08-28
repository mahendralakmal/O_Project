package codes.project.sameera.o_project;

import android.app.Activity;
import android.os.*;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Samy on 8/26/2014.
 */
public class Group_AddStudent_details extends Activity implements View.OnClickListener {
    EditText fName,mName, Address, sName, hNo, mNo, presentSpo;


    DatabaseAdapter databaseHelper;
    Button btnAdd;
    Button btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_add_student_details);
        fName=(EditText) findViewById(R.id.editTextfname);
        mName=(EditText) findViewById(R.id.editTextmName);
        Address = (EditText) findViewById(R.id.editTextAdd);
        sName = (EditText) findViewById(R.id.editTextsure);
        hNo = (EditText) findViewById(R.id.editTexttpH);
        mNo = (EditText) findViewById(R.id.editTextTPM);
        presentSpo = (EditText) findViewById(R.id.editTextPS);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        btnAdd.setOnClickListener(this);
        btnView.setOnClickListener(this);
        databaseHelper = new DatabaseAdapter(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
             case R.id.btnAdd:
                 addStudent(view);
                break;
             case R.id.btnView:
               viewDetails(view);

                break;

             default:
                 break;
        }

    }
    public void addStudent(View view){
        String fname = fName.getText().toString();
        String mname = mName.getText().toString();
        String sname = sName.getText().toString();
        String address = Address.getText().toString();
        String TPhome = hNo.getText().toString();
        String TPmobile = mNo.getText().toString();
        String presentsport = presentSpo.getText().toString();

        long id= databaseHelper.insertData(fname, mname, sname, address, TPhome, TPmobile, presentsport);
        if(id<0){
            Message.message(this,"Error inInsertiong Data");
        }else
        {
            Message.message(this,"Succecsfuly inserted to data");

        }
        
    }

    public void viewDetails(View view){
        String data = databaseHelper.getAllData();
        Message.message(this,data);
    }


}
