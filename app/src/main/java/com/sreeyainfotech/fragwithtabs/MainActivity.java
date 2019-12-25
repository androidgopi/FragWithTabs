package com.sreeyainfotech.fragwithtabs;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.sreeyainfotech.fragwithtabs.model.DataModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    Context context;
    ArrayList<DataModel> dataModelArrayList = new ArrayList<>();
    HashMap<String, ArrayList<DataModel>> hashMap = new HashMap<>();
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareJsonData();
        setKey_Value_Pair();


        ArrayList<DataModel> value = null;
        ArrayList<String> keys_list = new ArrayList<>();
        Iterator myVeryOwnIterator = hashMap.keySet().iterator();
        while (myVeryOwnIterator.hasNext()) {
            String key = (String) myVeryOwnIterator.next();
            keys_list.add(key);
            value = (ArrayList<DataModel>) hashMap.get(key);
            Toast.makeText(this, "Key: " + key + " Value: " + value.size(), Toast.LENGTH_LONG).show();
            Log.e("data1", "Key: " + key + " Value: " + value.size());
        }

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout.setupWithViewPager(viewPager);


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), hashMap, keys_list);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }


    private void prepareJsonData() {
        try {
            JSONObject object = new JSONObject(loadJSONFromAssets());
            JSONObject obj = object.getJSONObject("data");
            JSONArray array1 = obj.getJSONArray("features");

            for (int i = 0; i < array1.length(); i++) {
                DataModel dataModel = new DataModel();
                dataModel.setId(array1.getJSONObject(i).optString("id").toString());
                dataModel.setName(array1.getJSONObject(i).optString("name").toString());
                dataModel.setArabicName(array1.getJSONObject(i).optString("arabicName").toString());
                dataModel.setIsActive(array1.getJSONObject(i).optString("isActive").toString());
                dataModel.setFeaturesType(array1.getJSONObject(i).optString("featuresType").toString());
                dataModel.setCode(array1.getJSONObject(i).optString("code").toString());

                dataModelArrayList.add(dataModel);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {

        }
    }

    private void setKey_Value_Pair() {

        ArrayList<String> arrsting = new ArrayList<>();
        for (int i = 0; i < dataModelArrayList.size(); i++) {
            String featuresType = dataModelArrayList.get(i).getFeaturesType();
            if (!arrsting.contains(featuresType)) {
                arrsting.add(featuresType);
            }
        }

        for (int j = 0; j < arrsting.size(); j++) {
            String str = arrsting.get(j);
            ArrayList<DataModel> list = new ArrayList<>();
            for (int i = 0; i < dataModelArrayList.size(); i++) {
                if (str.equalsIgnoreCase(dataModelArrayList.get(i).getFeaturesType())) {
                    list.add(dataModelArrayList.get(i));
                }
            }

            Log.d("stri", str);
            hashMap.put(str, list);
        }

        Toast.makeText(getApplicationContext(), String.valueOf(arrsting.size()), Toast.LENGTH_LONG).show();
    }

    public String loadJSONFromAssets() {
        String json = null;
        try {
            InputStream is = getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
