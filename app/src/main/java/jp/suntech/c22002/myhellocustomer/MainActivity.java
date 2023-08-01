package jp.suntech.c22002.myhellocustomer;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ボタンオブジェクトの用意
        Button btClick=findViewById(R.id.btClick);
        //リスナ・オブジェクトの用意
        ClickListener listener=new ClickListener();
        //ボタンにリスナを設定
        btClick.setOnClickListener(listener);

        //name
        Button btClearName=findViewById(R.id.btClearName);
        //クリアにリスナ設定
        btClearName.setOnClickListener(listener);

        //address
        Button btClearAddress=findViewById(R.id.btClearAddress);
        //クリアにリスナ設定
        btClearAddress.setOnClickListener(listener);

    }

    //ボタンをクリックしたときの処理
    private class ClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            EditText inputName=findViewById(R.id.etName);
            EditText inputAddress=findViewById(R.id.etAddress);

            int id=v.getId();

            //表示ボタン
            if(id==R.id.btClick){
                String inputStrName = inputName.getText().toString();
                String inputStrAddress = inputAddress.getText().toString();
                String show=inputStrAddress+"にお住いの"+inputStrName+"さんこんにちは！";
                Toast.makeText(MainActivity.this, show, Toast.LENGTH_SHORT).show();
            }else if(id==R.id.btClearName){
                inputName.setText("");
            }else if(id==R.id.btClearAddress){
                inputAddress.setText("");
            }
        }
    }
}