package com.oestbalmer.android.pichal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    public static final int PICK_IMAGE = 1;

    public StorageReference ref = new StorageReference("something");

    @BindView(R.id.sendPictureButton) Button mUploadButton;
    @BindView(R.id.uploadedImage) ImageView mImageView;

    Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.sendPictureButton)
    public void onButtonClicked() {
        getImageFromGallery();

    }

    private void getImageFromGallery() {
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show();
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select a picture"), PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == PICK_IMAGE) {
            if(mBitmap != null) {
                mBitmap.recycle();
            }
            Toast.makeText(this, "Picture Recived", Toast.LENGTH_SHORT).show();
            Uri selectedImageUri = data.getData();
            Log.i("TAG", selectedImageUri.toString());
            Picasso.with(this).load(selectedImageUri).into(mImageView);
        }
    }
}
