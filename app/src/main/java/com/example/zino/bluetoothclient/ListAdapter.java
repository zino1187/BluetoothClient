package com.example.zino.bluetoothclient;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/*
 * Created by zino on 2016-07-05.
 */
public class ListAdapter extends BaseAdapter{
    Context context;
    ArrayList<BluetoothDevice> list=new ArrayList<BluetoothDevice>();
    LayoutInflater layoutInflater;

    public ListAdapter(Context context) {
        this.context = context;
        layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view=null;

        if(convertView == null){
            view= layoutInflater.inflate(R.layout.item_layout, viewGroup, false);
        }else{
            view=convertView;
        }

        //블루투스 디바이스로부터 정보를 추출하여, 이름과 어드레스 주소 넣기!!
        BluetoothDevice bluetoothDevice=list.get(i);

        TextView txt_name=(TextView)view.findViewById(R.id.txt_name);
        TextView txt_address=(TextView)view.findViewById(R.id.txt_address);

        txt_name.setText(bluetoothDevice.getName());
        txt_address.setText(bluetoothDevice.getAddress());

        return view;
    }
}
