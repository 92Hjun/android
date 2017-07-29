package org.techdown.coverflow;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.Gallery;
import android.widget.ImageView;


public class CoverFlow extends Gallery {

    Camera camera = new Camera();
    public static int maxRataionAngle = 55;
    public static int maxZoom = -60;
    private int centerPoint;

    public CoverFlow(Context context) {
        super(context);
        init(context);
    }

    public CoverFlow(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init (Context context) {

        // 아이템 변형가능케하는 메소드
        setStaticTransformationsEnabled(true);

    }

    @Override
    protected boolean getChildStaticTransformation(View child, Transformation t) {
        int childCenter = child.getLeft() + child.getWidth() /2;
        int childWidth = child.getWidth();

        int rotationAngle = 0;
        t.clear();
        t.setTransformationType(Transformation.TYPE_MATRIX);

        if (childCenter == centerPoint) {
            transformImageBitmap((ImageView) child, t, 0);
        }else {
            rotationAngle = (int) (((float)(centerPoint - childCenter)/childWidth) * maxRataionAngle);
            if (Math.abs(rotationAngle) > maxRataionAngle) {
                rotationAngle = (rotationAngle < 0) ? -maxRataionAngle: maxRataionAngle;
            }
            transformImageBitmap((ImageView) child, t, rotationAngle);
        }
        return true;
    }

    private void transformImageBitmap(ImageView child, Transformation t, int rotationAngle){
        camera.save();
        Matrix matrix = t.getMatrix();

        int imageHeight = child.getLayoutParams().height;
        int imageWidth = child.getLayoutParams().width;
        int rotation = Math.abs(rotationAngle);

        camera.translate(0.0f, 0.0f, 100.0f);

        if (rotation < maxRataionAngle) {
            float zoomAmount = (float) (maxZoom + (rotation * 1.5));
            camera.translate(0.0f,0.0f,zoomAmount);
        }

        camera.rotateZ(rotationAngle);
        camera.getMatrix(matrix);

        matrix.preTranslate(-(imageWidth/2),-(imageHeight)/2);
        matrix.postTranslate((imageWidth)/2,(imageHeight/2));

        camera.restore();

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        centerPoint = (getWidth() - getPaddingLeft() - getPaddingRight()) / 2 + getPaddingLeft();

    }


}
