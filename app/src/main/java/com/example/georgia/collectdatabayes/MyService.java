package com.example.georgia.collectdatabayes;

import android.app.Service;
import android.content.Context;
import android.content.Intent;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyService extends Service {

    private  String date,cell,RSSID,RSSI;
    private WifiManager wifiManager;
    //  private WifiInfo wifiInfo;
    SensorsTable myTable;
    private String TAG="com.example.georgia.collectdatabayes";
    MyDbHandler myDbHandler;

    List<ScanResult> scanResults;


    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        cell=intent.getStringExtra("cell");
        myDbHandler=new MyDbHandler(this,null,null,1);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        date = sdf.format(new Date());
        // Set wifi manager.
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        // Start a wifi scan.
        wifiManager.startScan();
        // Store results in a list.
        scanResults = wifiManager.getScanResults();
        // Write results to a label
        Log.i(TAG,Integer.toString(scanResults.size()));
        for (ScanResult scanResult : scanResults) {
            RSSID=scanResult.BSSID;
            RSSI=Integer.toString(scanResult.level);
            myTable=new SensorsTable(date,Long.toString(System.currentTimeMillis()),RSSID,RSSI,cell);
            myDbHandler.addRow(myTable);
        }

        return START_STICKY;
    }
}

