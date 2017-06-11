package me.anky.retrofityoutube;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import me.anky.retrofityoutube.model.Student;
import me.anky.retrofityoutube.service.APIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText editName;
    TextView textDetails;
    Button btnGetData, btnInsertData;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textDetails = (TextView) findViewById(R.id.textDetails);
        btnGetData = (Button) findViewById(R.id.btnGetData);
//        btnInsertData = (Button) findViewById(R.id.btnInsert);
//        editName = (EditText) findViewById(R.id.editName);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPeopleDetails();
            }
        });
    }

    private void getPeopleDetails(){
        showpDialog();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.shaoniiuc.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<List<Student>> call = service.getPeopleDetails();

        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                List<Student> students = response.body();

                String details = "";
                for (int i = 0; i < students.size(); i++){
                    String name = students.get(i).getName();

                    details += "\n\nname: " + name;
                }
                textDetails.setText(details);
                hidepDialog();
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                Log.v("testing", "Failed");
                hidepDialog();
            }
        });

    }

    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
