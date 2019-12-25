package com.sreeyainfotech.fragwithtabs.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataModel implements Serializable {

    @SerializedName("id")
    String id;

    @SerializedName("name")
    String name;

    @SerializedName("arabicName")
    String arabicName;

    @SerializedName("isActive")
    String isActive;

    @SerializedName("featuresType")
    String featuresType;

    @SerializedName("code")
    String code;

//
//    // Decodes business json into business model object
//    public static DataModel fromJson(JSONObject jsonObject) {
//        DataModel data = new DataModel();
//        // Deserialize json into object fields
//        try {
//            data.id = jsonObject.getString("id");
//            data.name = jsonObject.getString("name");
//            data.arabicName = jsonObject.getString("arabicName");
//            data.isActive = jsonObject.getString("isActive");
//            data.isActive = jsonObject.getString("featuresType");
//            data.isActive = jsonObject.getString("code");
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return data;
//    }

//    // Decodes array of business json results into business model objects
//    public static ArrayList<DataModel> fromJson(JSONArray jsonArray) {
//        JSONObject businessJson;
//        ArrayList<DataModel> businesses = new ArrayList<DataModel>(jsonArray.length());
//        // Process each result in json array, decode and convert to business object
//        for (int i=0; i < jsonArray.length(); i++) {
//            try {
//                businessJson = jsonArray.getJSONObject(i);
//            } catch (Exception e) {
//                e.printStackTrace();
//                continue;
//            }
//
//            DataModel business = DataModel.fromJson(businessJson);
//            if (business != null) {
//                businesses.add(business);
//            }
//        }
//
//        return businesses;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getFeaturesType() {
        return featuresType;
    }

    public void setFeaturesType(String featuresType) {
        this.featuresType = featuresType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

//    @NonNull
//    @Override
//    public String toString() {
//        return getFeaturesType() ;
//    }
}
