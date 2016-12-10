package edu.mnstate.cw3967me.lab18;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final Context context = this;
    private Button btnAddEmp;
    private TextView lblFirstName;
    private TextView lblLastName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblFirstName = (TextView)findViewById(R.id.txtFirstName);
        lblLastName  = (TextView) findViewById(R.id.txtLastName);

        btnAddEmp = (Button) findViewById(R.id.btnNewEmp);
        btnAddEmp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                LayoutInflater li = LayoutInflater.from(context);
                View getInfoView = li.inflate(R.layout.get_emp_info, null);
                AlertDialog.Builder alertDlgBld = new AlertDialog.Builder(context);
                alertDlgBld.setView(getInfoView);
                final EditText newFirstName = (EditText) getInfoView.findViewById(R.id.txtFirstName);
                final EditText newLastName = (EditText) getInfoView.findViewById(R.id.txtLastName);
                //set dialog message
                alertDlgBld.setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        lblFirstName.setText(newFirstName.getText());
                        lblLastName.setText(newLastName.getText());
                    }
                })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = alertDlgBld.create();
                alertDialog.show();
            }
        });
    }
}
