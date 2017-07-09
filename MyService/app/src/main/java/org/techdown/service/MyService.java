package org.techdown.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {}

    private static final String TAG = "MyService";

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate() 호출됨");

    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy() 호출됨");
        super.onDestroy();


    }

    // Service는 Create를 1번만 실행함으로 반복실행해서 데이터를 처리할경우
    // onStartCommand 에서 처리한다. Service는
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d(TAG, "onStartCommand() 호출됨");

        if (intent == null) {
            // STICKY는 서비스가 종료되어도 다시 자동으로 실행되게 한다.
            return Service.START_STICKY;
        }else {
            processCommand(intent);
        }

        return super.onStartCommand(intent,flags,startId);
    }

    private void processCommand(Intent intent) {
        String command = intent.getStringExtra("command");
        String name = intent.getStringExtra("name");

        Log.d(TAG, "전달받은 데이터 : " + command + ", " + name);
        try{
            Thread.sleep(5000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);

        //화면이 없는 서비스에서 화면이 있는 서비스에 데이터를 띄울때 사용
        // 화면은 Task로 묶여 있는데, 단말에있는 기본브라우저나, 전화거는화면이 연속적으로 띄울때 Task로 묶는다.
        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|
                Intent.FLAG_ACTIVITY_SINGLE_TOP|
                Intent.FLAG_ACTIVITY_CLEAR_TOP);

        showIntent.putExtra("command", "show");
        showIntent.putExtra("name", name + "from Service");

        startActivity(showIntent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
