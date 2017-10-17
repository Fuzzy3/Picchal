package com.oestbalmer.android.pichal.UploadImage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.oestbalmer.android.pichal.R;
import com.oestbalmer.android.pichal.FindFriend.FindFriendActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImageActivity extends AppCompatActivity implements IImageActivity{
    public static final int PICK_IMAGE = 1;

    @BindView(R.id.uploadedImage) ImageView mImageView;

    boolean hasUploadedImage = false;
    StorageReference mStorage;

    Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);
        ButterKnife.bind(this);

        mStorage = FirebaseStorage.getInstance().getReference();

        Toolbar toolbar = findViewById(R.id.picchal_toolbar);
        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.send_picture_button)
    public void onUploadButtonClicked() {
        getImageFromGallery();
    }

    @OnClick(R.id.share_button)
    public void onShareButtonClicked() {
        startActivity(FindFriendActivity.newIntent(this));
    }

    private void getImageFromGallery() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select a picture"), PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if ((requestCode == PICK_IMAGE) && (resultCode == RESULT_OK)) {

            final Uri selectedImageUri = data.getData();

            StorageReference filepath = mStorage.child("Photos").child(selectedImageUri.getLastPathSegment());

            filepath.putFile(selectedImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Picasso.with(ImageActivity.this).load(selectedImageUri).into(mImageView);
                }
            });
        }
    }

    public static Intent newIntentClearActivityHistory(Context packageContext) {
        Intent i = new Intent(packageContext, ImageActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return i;
    }

    

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
