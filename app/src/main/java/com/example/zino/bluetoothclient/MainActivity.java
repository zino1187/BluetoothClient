package com.example.zino.bluetoothclient;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> list=new ArrayList<String>();

    BluetoothAdapter bluetoothAdapter;

    //NFC만 유달리 보통의 BroadCastReceiver를 사용하지 않을뿐이다...왜? 빨리 전달받으려고....
    BroadcastReceiver broadcastReceiver;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        broadcastReceiver = new BroadcastReceiver() {
            //필터로 등록한 액션이 발견되면 onReceive메서드가 호출되며, 인수로 전달되는 Intent에
            //발견된 디바이스 정보가 들어있다!!
            public void onReceive(Context context, Intent intent) {
                //시스템이 Intent에 데이터를심을때 아래처럼 심었다~!!
                BluetoothDevice bluetoothDevice=(BluetoothDevice)intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                Toast.makeText(getApplicationContext(), bluetoothDevice.getName()+"발견", Toast.LENGTH_LONG).show();

                //발견된 디바이스들을 목록에 채워넣자!!
                list.add(bluetoothDevice.getName());
                adapter.notifyDataSetChanged();
            }
        };
        //어떤 브로드케스팅 정보를 받을지 필터를 적용하자!!
        //디바이스가 발견되었을때 방송되는 인텐트만 받겠다!!
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(broadcastReceiver, filter); //청취시작!!


        //리스트뷰와 리스너와의 연결
        listView.setOnItemClickListener(this);
    }

    //다른 기기 검색(페어링 말고...)
    public void scanDevice(){
        //기존의 list를 전부 삭제한 후....
        list.removeAll(list);

        bluetoothAdapter.startDiscovery(); //지금부터 검색 시작해!!
    }
    public void btnClick(View view){
        scanDevice();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //쓰레드 생성하여 서버와 접속하자!!
        //ConnectThread connectThread = new ConnectThread(bluetoothAdapter, );

    }
}







