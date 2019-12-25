package com.sreeyainfotech.fragwithtabs;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.sreeyainfotech.fragwithtabs.model.DataModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class ViewPagerAdapter extends FragmentPagerAdapter {
    Map<String, ArrayList<DataModel>> arrylist = new LinkedHashMap<>();
    private List<String> mFragmentTitleList = new ArrayList<>();
    int count;
    Object[] keys;


    private String[] title = {"One", "Two", "Three", "Four"};
    // private String title[]= Arrays.copyOf(keys, keys.length, String[].class);

    public ViewPagerAdapter(FragmentManager manager, HashMap<String, ArrayList<DataModel>> arrylist, ArrayList<String> mFragmentTitleList) {
        super(manager);
        this.arrylist = arrylist;
        this.mFragmentTitleList = mFragmentTitleList;
        keys = arrylist.keySet().toArray();

    }

    @Override
    public Fragment getItem(int position) {

        //  return TabFragment.newInstance(arrObj.get(keys[position]));
        return TabFragment.getInstance(arrylist.get(keys[position]));
    }

    @Override
    public int getCount() {
        return arrylist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}