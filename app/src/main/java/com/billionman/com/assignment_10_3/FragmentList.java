package com.billionman.com.assignment_10_3;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class FragmentList extends Fragment {

    private ListView listView;
    private List<Details> menuItems;
    private DescAdapter mAdapter;

    public FragmentList() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_list,
                container, false);
        listView = (ListView) rootView.findViewById(R.id.listView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        menuItems = setData();
        mAdapter = new DescAdapter(getActivity(), android.R.id.list, menuItems);
        listView.setAdapter(mAdapter);
    }

    private List<Details> setData() {
        List<Details> listD = new ArrayList<>();
        Details d = new Details();
        d.setName("Youtube");
        d.setDesc("www.youtube.com");
        d.setImageName(R.drawable.image_1);
        listD.add(d);
        Details d2 = new Details();
        d2.setName("Blogger");
        d2.setDesc("www.blooger.com");
        d2.setImageName(R.drawable.image_2);
        listD.add(d2);
        return listD;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public class DescAdapter extends ArrayAdapter<Details> {
        Context context;
        List<Details> lc = null;
        public DescAdapter(Context context, int textViewResourceId, List<Details> objects) {
            super(context, textViewResourceId, objects);
            // TODO Auto-generated constructor stub
            this.context = context;
        }

        /*private view holder class*/
        private class ViewHolder {
            ImageView imageView;
            TextView txtMenuName;
            TextView txtMenuDesc;
            TextView txtPrice;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            Details rowItem = getItem(position);

            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.item_data, null);
                holder = new ViewHolder();
                holder.txtMenuName = (TextView) convertView.findViewById(R.id.name);
                holder.txtMenuDesc = (TextView) convertView.findViewById(R.id.description);
                holder.imageView = (ImageView) convertView.findViewById(R.id.image);
                convertView.setTag(holder);
            } else
                holder = (ViewHolder) convertView.getTag();

            holder.txtMenuDesc.setText(rowItem.getDesc());
            holder.txtMenuName.setText(rowItem.getName());
            holder.imageView.setImageResource(rowItem.getImageName());

            return convertView;
        }


    }
}
