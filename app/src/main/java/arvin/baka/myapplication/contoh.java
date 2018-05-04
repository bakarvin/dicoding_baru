package arvin.baka.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class contoh extends AppCompatActivity implements View.OnClickListener {

    private Button btnMoveAct,btnMoveData,btnDial,btnImel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_contoh);

        btnMoveAct = (Button)findViewById(R.id.btn_moveAct);
        btnMoveAct.setOnClickListener(this);
        btnMoveData = (Button)findViewById(R.id.btn_moveData);
        btnMoveData.setOnClickListener(this);
        btnDial = (Button)findViewById(R.id.btn_dial);
        btnDial.setOnClickListener(this);
        btnImel = (Button)findViewById(R.id.btn_imel);
        btnImel.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_moveAct:
                Intent moveIntent = new Intent(contoh.this, MoveActivity.class);
                startActivity(moveIntent);
            break;
            case R.id.btn_moveData:
                Intent MoveDataIntent = new Intent(contoh.this, MoveData.class);
                MoveDataIntent.putExtra(MoveData.EXTRA_NAME, "hoboiii");
                MoveDataIntent.putExtra(MoveData.EXTRA_AGE, 5);
                startActivity(MoveDataIntent);
                break;
            case R.id.btn_dial:
                String phoneNumber = "0215328485";
                Intent dialPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+phoneNumber));
                startActivity(dialPhone);
                break;
            case R.id.btn_imel:
                String Email = "arviin.maulana17@gmail.com";
                Intent imel = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" +Email));
                imel.putExtra(Intent.EXTRA_SUBJECT, "Fanmail");
                startActivity(imel);
        }
    }
}
