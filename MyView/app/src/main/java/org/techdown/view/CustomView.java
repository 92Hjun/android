package org.techdown.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by fribel on 2017-07-26.
 */

public class CustomView extends View {

    Paint paint;
    int deviceWidth;
    int deviceHight;
    ShapeDrawable drawable;

    public CustomView(Context context) {
        super(context);
        init(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init (Context context) {
        paint = new Paint();
        paint.setColor(Color.RED);

        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();

        deviceWidth = display.getWidth();
        deviceHight = display.getHeight();

        drawable = new ShapeDrawable();
        RectShape rect = new RectShape();

        rect.resize(deviceWidth, deviceHight);

        drawable.setShape(rect);
        drawable.setBounds(0,0, deviceWidth, deviceHight);

        LinearGradient gradient = new LinearGradient(0, 0, 0, deviceHight, Color.BLUE, Color.YELLOW, Shader.TileMode.CLAMP);

        Paint curPaint = drawable.getPaint();
        curPaint.setShader(gradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawRect(100, 100, 200, 200, paint);
        /*
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4.0f);
        paint.setColor(Color.GREEN);
        canvas.drawRect(10,10,100,100,paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setARGB(128, 0 ,0, 255);
        canvas.drawRect(120,10,210,100, paint);

        DashPathEffect dashEffect = new DashPathEffect(new float[]{5,5}, 1);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5.0f);
        paint.setPathEffect(dashEffect);
        paint.setColor(Color.GREEN);
        canvas.drawRect(120, 10, 210, 100, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(40.0f);
        canvas.drawText("안녕하세요", 20 , 320, paint);
        */

        drawable.draw(canvas);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {

            Toast.makeText(getContext().getApplicationContext(), "눌렸습니다.", Toast.LENGTH_SHORT).show();
        }
        return true;

    }

    // 실행순서 init > draw > TouchEvent 인데 TouchEvent 는 그린것에 아이디를 부여하여  아이디값에 이벤트를 부여할것.
    // 아니면 화면전체를 인식해서 이벤트를 호출함.
}
