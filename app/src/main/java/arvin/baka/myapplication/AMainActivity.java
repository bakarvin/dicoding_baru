package arvin.baka.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AMainActivity extends AppCompatActivity {

    @BindView(R.id.pjg)
    EditText pjg;

    @BindView(R.id.lbr)
    EditText lbr;

    @BindView(R.id.ting)
    EditText ting;

    @BindView(R.id.btn_calculate)
    Button btnhasil;

    @BindView(R.id.result)
    TextView hasil;

    @BindView(R.id.asg2)
    Button asg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        //Enable butterKnife
        ButterKnife.bind(this);

        btnhasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId()==R.id.btn_calculate){
                    String length = pjg.getText().toString().trim();
                    String width = lbr.getText().toString().trim();
                    String heigt = ting.getText().toString().trim();
                    boolean isEmptyFields = false;
                    if (TextUtils.isEmpty(length)){
                        isEmptyFields= true;
                        pjg.setError("Tidak Boleh Kosong");
                    }
                    if (TextUtils.isEmpty(width)){
                        isEmptyFields=true;
                        lbr.setError("Tidak Boleh Kosong");
                    }
                    if (TextUtils.isEmpty(heigt)){
                        isEmptyFields=true;
                        ting.setError("Tidak Boleh Kosong");
                    }
                    if (!isEmptyFields){
                        double l = Double.parseDouble(length);
                        double w= Double.parseDouble(width);
                        double h=Double.parseDouble(heigt);
                        double volume = l * w * h;
                        hasil.setText(String.valueOf(volume));
                    }
                }
            }
        });
        if (savedInstanceState != null){
            String hasilz = savedInstanceState.getString(STATE_HASIL);
            hasil.setText(hasilz);
        }
    }
    private static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString(STATE_HASIL, hasil.getText().toString());
        super.onSaveInstanceState(outState);
    }
    @OnClick(R.id.asg2)
    void intent(){
        Intent pindah = new Intent(AMainActivity.this, contoh.class);
            startActivity(pindah);
    }
}
