package codes.project.sameera.o_project;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by sameera on 8/28/14.
 */
public class Indi_AddStudentDetail extends Activity implements View.OnClickListener {
    EditText fName,mName, Address, sName, hNo, mNo, presentSpo;
    Button save;
    DatabaseAdapter databaseHelper;
    private ImageButton ib;
    private Calendar cal;
    private int day;
    private int month;
    private int year;
    private EditText et;

    private Calendar dateTime=Calendar.getInstance();
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM dd, yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indi_add_student_detail);
        fName = (EditText) findViewById(R.id.enterFname);
        mName = (EditText) findViewById(R.id.enterMname);
        sName = (EditText) findViewById(R.id.enterSureName);
        Address =(EditText) findViewById(R.id.enterAddress);
        hNo = (EditText) findViewById(R.id.entertph);
        mNo = (EditText) findViewById(R.id.entertpm);
        presentSpo = (EditText) findViewById(R.id.enterpres_sport);
        
        save = (Button) findViewById(R.id.btnsave);

        ib = (ImageButton) findViewById(R.id.imageButton1);
        cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);
        et = (EditText) findViewById(R.id.editText);

        ib.setOnClickListener(this);
        save.setOnClickListener(this);
        
        databaseHelper = new DatabaseAdapter(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnsave:
                addStudent(v);
                break;
            case R.id.imageButton1:
                showDialog(0);
                break;
        }

        
    }

    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, datePickerListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            et.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
                    + selectedYear);
        }
    };
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
