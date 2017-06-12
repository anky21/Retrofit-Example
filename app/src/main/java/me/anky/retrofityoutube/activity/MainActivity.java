package me.anky.retrofityoutube.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import me.anky.retrofityoutube.R;
import me.anky.retrofityoutube.adapter.RecyclerViewAdapter;
import me.anky.retrofityoutube.model.Student;
import me.anky.retrofityoutube.network.ApiClient;
import me.anky.retrofityoutube.service.APIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    LinearLayoutManager layoutManager;
    Button btnGetData;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetData = (Button) findViewById(R.id.btnGetData);

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

        try {
            APIService service = ApiClient.getClient().create(APIService.class);
            Call<List<Student>> call = service.getPeopleDetails();

            call.enqueue(new Callback<List<Student>>() {
                @Override
                public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                    List<Student> rowListItem = response.body();

                    layoutManager = new LinearLayoutManager(MainActivity.this);

                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                    recyclerView.setLayoutManager(layoutManager);

                    RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(rowListItem);
                    recyclerView.setAdapter(recyclerViewAdapter);

                    hidepDialog();
                }

                @Override
                public void onFailure(Call<List<Student>> call, Throwable t) {
                    Log.v("testing", "Failed");
                    hidepDialog();
                }
            });
        } catch (Exception e){
            Log.e("exception", String.valueOf(e));
        }

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
