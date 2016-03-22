package edu.ifpb.br.ontouchlistener;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnTouchListener;

public class MainActivity extends Activity {

    private TextView myTouchEvent;
    private ImageView myImageView;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTouchEvent = (TextView) findViewById(R.id.textViewEvent);
        myImageView = (ImageView) findViewById(R.id.imageView);

        bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.download);
        myImageView.setImageBitmap(bitmap);


        myImageView.setOnTouchListener(onTouchListener);
    }
    OnTouchListener onTouchListener = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {


            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    //O Mouse com botão esquerdo foi pressionado
                    myTouchEvent.setText("ACTION_DOWN");
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    //O Mouse com botão direito foi pressionado
                    myTouchEvent.setText("ACTION_POINTER_DOWN");
                    break;
                case MotionEvent.ACTION_MOVE:
                    //Enquanto um botão estava pressionado houveram mudanças
                    myTouchEvent.setText("ACTION_MOVE");
                    break;
                case MotionEvent.ACTION_UP:
                    //Parou de pressionar
                    myTouchEvent.setText("ACTION_UP");
                    break;
            }
            return true;
        }

    };
}




