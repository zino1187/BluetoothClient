package com.example.zino.bluetoothclient;

import android.bluetooth.BluetoothDevice;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/*
 * Created by zino on 2016-07-05.
 */
public class ListAdapter extends BaseAdapter{
    ArrayList<BluetoothDevice> list=new ArrayList<BluetoothDevice>();

    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
