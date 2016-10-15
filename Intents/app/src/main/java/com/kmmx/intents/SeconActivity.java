package com.kmmx.intents;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

public class SeconActivity extends BaseActivity {

    private static final int REQUEST_CAMERA = 10;
    private static final String TAG = SeconActivity.class.getSimpleName();
    Button btnCamera, btnMail;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secon);

        btnCamera = (Button) findViewById(R.id.btnCamera);
        btnMail = (Button) findViewById(R.id.btnMail);
        imageView = (ImageView) findViewById(R.id.imgCamera);

//        showToast("Hey!");
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnMail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{
                    "sebastian@mail.com", "mail@mail.com", "evil@corp.com", "android@kmmx.com"
            });
            intent.putExtra(Intent.EXTRA_SUBJECT, "Este es un texto de subject");
            intent.putExtra(Intent.EXTRA_TEXT, "Este es un texto de nuestro body del mensaje!");
            startActivity(intent);

        });

        btnCamera.setOnClickListener(v -> {
            Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intentCamera, REQUEST_CAMERA);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CAMERA) {
            if (resultCode == RESULT_OK) {
                Log.e("-------DataIntent------", "onActivityResult: " + data.toString());
                Log.e(TAG, "onActivityResult: " + data.getExtras().toString());
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(bitmap);
            } else {
                showToast("No tomaste ninguna foto");
            }
        }
    }
}
