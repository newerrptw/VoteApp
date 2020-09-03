package th.ac.su.voteapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Votecheck extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votecheck2);

        Intent i = getIntent();
        Button checkButton = findViewById(R.id.check_button);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText zipEditText = findViewById(R.id.zip_number);
                String zipNum = zipEditText.getText().toString()+"";
                String trueNum = "1111111111111";
                String trueNum2 = "2222222222222";
                if(zipNum.length()==13){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(Votecheck.this);
                    dialog.setTitle("ผลการตรวจสอบสิทธิเลือกตั้ง");
                    dialog.setPositiveButton("OK",null);
                    if(zipNum.equals(trueNum) || zipNum.equals(trueNum2)){
                        dialog.setMessage("คุณเป็นผู้มีสิทธิเลือกตั้ง");
                    }
                    else{
                        dialog.setMessage("คุณไม่มีสิทธิเลือกตั้ง");
                    }
                    dialog.show();
                }
                else{
                    Toast toast = Toast.makeText(
                            Votecheck.this,
                            "กรุณากรอกหมายเลขบัตรประชาชน 13 หลัก",
                            Toast.LENGTH_LONG
                    );
                    toast.show();
                }
            }
        });
    }
}