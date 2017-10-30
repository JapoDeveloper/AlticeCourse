package co.japo.layoutsapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by japodeveloper on 9/15/17.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.amazon,R.drawable.app_store,R.drawable.dropbox,R.drawable.evernote,
            R.drawable.facebook,R.drawable.github,R.drawable.google_drive,R.drawable.google_plus,
            R.drawable.instagram,R.drawable.itunnes,R.drawable.linkedin,R.drawable.pinterest,
            R.drawable.play_store,R.drawable.playstation,R.drawable.reddit,R.drawable.sound_cloud,
            R.drawable.stackoverflow,R.drawable.steam,R.drawable.twitter,R.drawable.whatsapp,R.drawable.wordpress
    };

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;

        if (view == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,164));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        else
        {
            imageView = (ImageView) view;
        }
        imageView.setId(i);
        imageView.setImageResource(mThumbIds[i]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Hola todo! "+view.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        return imageView;
    }
}
