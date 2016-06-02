package com.example.houshuai.broadcastreceivedemo_03;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.widget.Toast;

/**
 * Created by HouShuai on 2016/6/2.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
/**
 * 获得网络管理者实例
 */
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo != null) {
            if (networkInfo.isConnected()) {
                int type = networkInfo.getType();
                switch (type) {
                    case ConnectivityManager.TYPE_BLUETOOTH:
                        Toast.makeText(context, "恭喜！蓝牙已经链接。。。", Toast.LENGTH_LONG)
                                .show();
                        break;
                    case ConnectivityManager.TYPE_WIFI:
                        Toast.makeText(context, "恭喜！WiFI已经链接。。。", Toast.LENGTH_LONG)
                                .show();
                        break;
                    case ConnectivityManager.TYPE_ETHERNET:
                        Toast.makeText(context, "恭喜！以太网已经链接。。。", Toast.LENGTH_LONG)
                                .show();
                        break;
                    case ConnectivityManager.TYPE_MOBILE:
                        Toast.makeText(context, "恭喜！移动网络已经链接。。。", Toast.LENGTH_LONG)
                                .show();
                    default:
                        Toast.makeText(context, "恭喜！网络可以链接。。。", Toast.LENGTH_LONG)
                                .show();
                        break;
                }
            } else {
                Toast.makeText(context, "网络不可用。", Toast.LENGTH_LONG)
                        .show();
            }

        } else {
            Toast.makeText(context, "没有网络。", Toast.LENGTH_LONG)
                    .show();
            Intent traget = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
            traget.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(traget);
        }
    }
}
