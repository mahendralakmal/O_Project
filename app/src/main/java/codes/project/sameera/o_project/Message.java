package codes.project.sameera.o_project;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Samy on 8/27/2014.
 */
public class Message {
    public static void message(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();;
    }
}
