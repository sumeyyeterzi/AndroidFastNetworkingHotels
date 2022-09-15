package com.example.hotelsfan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv_hotels;
    ArrayList<Hotels>  listHotels;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      rcv_hotels=findViewById(R.id.rcv_hotels);

      loadData();

    }

    private void loadData(){
        AndroidNetworking.get("https://mocki.io/v1/0ff3fccd-c894-4404-93d0-10af0f4923c7")
                .setPriority(Priority.LOW)
                .build()
                //buraya getAsJsonObject metodu gelecek
                //sonra json object içerisinden hotels json array ini çekeceksin
                //for döngüsü sadece json array i aldıktan sonra dönecek
                //döngüdeki her ininci eleman bir objeye dönüşecek, sonra hotels e aktarılabilr
                .getAsJSONObject(new JSONObjectRequestListener(){
                    @Override
                    public void onResponse(JSONObject response) {
                        listHotels =new ArrayList<>();
                        try {
                            JSONArray jsonArray = response.getJSONArray("hotels");
                            for(int i =0; i<jsonArray.length(); i++){
                                Hotels hotels = new Hotels();
                                hotels.setId(jsonArray.getJSONObject(i).getString("id"));
                                hotels.setTitle(jsonArray.getJSONObject(i).getString("title"));
                                hotels.setSpot(jsonArray.getJSONObject(i).getString("spot"));
                                hotels.setImage(jsonArray.getJSONObject(i).getString("image"));
                                hotels.setText(jsonArray.getJSONObject(i).getString("text"));
                                hotels.setServices_type(jsonArray.getJSONObject(i).getString("services_type"));
                                hotels.setStatus(jsonArray.getJSONObject(i).getString("status"));
                                hotels.setCreated_at(jsonArray.getJSONObject(i).getString("created_at"));
                                hotels.setUpdated_at(jsonArray.getJSONObject(i).getString("updated_at"));

                                listHotels.add(hotels);


                            }

                            HotelsAdapter adapter = new HotelsAdapter(getApplicationContext(),listHotels);
                            rcv_hotels.setHasFixedSize(true);
                            rcv_hotels.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            rcv_hotels.setAdapter(adapter);
                        }

                     catch (JSONException e) {
                        e.printStackTrace();
                    }

                      // rcv_hotels.notifyDataSetChanged()
                    }


                    @Override
                    public void onError(ANError anError) {

                    }
                });


    }
}


