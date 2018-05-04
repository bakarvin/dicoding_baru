package arvin.baka.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MoveData extends AppCompatActivity {
    public static String EXTRA_AGE ="extra_age";
    public static String EXTRA_NAME ="extra_name";
    private TextView DataReceived;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_movedata);
        DataReceived = (TextView)findViewById(R.id.Data_received);
        String name =getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE, 0);
        String text ="Name : "+name+", Your Age : "+age;
        DataReceived.setText(text);
    }
}
