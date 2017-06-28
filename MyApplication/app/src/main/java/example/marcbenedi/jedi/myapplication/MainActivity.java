package example.marcbenedi.jedi.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView textView;
    private EditText editText;
    private EditText editText2;
    private Button button;

    private int result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG,"onCreate");
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        editText2 = (EditText) findViewById(R.id.editText2);

        String texto1 = editText.getText().toString();
        String texto2 = editText2.getText().toString();

        Log.v(TAG,"El texto en el oncreate es "+texto1+ " "+ texto2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(editText.getText().toString());
                int b = Integer.parseInt(editText2.getText().toString());
                result = a+b;
                textView.setText(String.valueOf(a+b));

            }
        });



    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.v(TAG,"Se ha llamado onRestore");
        result = savedInstanceState.getInt("resultado");
        textView.setText(String.valueOf(result));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v(TAG,"Se ha llamado onSaveInstanceState");
        outState.putInt("resultado",result);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,"onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"onDestroy");
    }
}
