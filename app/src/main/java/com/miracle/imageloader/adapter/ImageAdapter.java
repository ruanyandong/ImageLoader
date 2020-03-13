package com.miracle.imageloader.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.miracle.imageloader.R;
import com.miracle.imageloader.imageloader.ImageLoader;
import com.miracle.imageloader.screen.ScreenUtil;

import java.util.List;

/**
 * @author -> miracle
 * @date -> 2020/3/13
 * @email -> ruanyandongai@gmail.com 729368173@qq.com
 * @phone -> 18983790146
 * @blog -> https://ruanyandong.github.io
 */
public class ImageAdapter extends BaseAdapter {

    private List<String> mUrlList;
    private Context mContext;
    private LayoutInflater mInflater;
    private Drawable mDefaultBitmapDrawable;
    private ImageLoader mImageLoader;
    private boolean mIsGridViewIdle = true;

    private int mImageWidth;
    private int mImageHeight;

    public boolean getGridViewIdle(){
        return mIsGridViewIdle;
    }

    public void setGridViewIdle(boolean GridViewIdle) {
        this.mIsGridViewIdle = GridViewIdle;
    }

    public ImageAdapter(List<String> list, Context context) {
        this.mUrlList = list;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mDefaultBitmapDrawable = mContext.getDrawable(R.mipmap.default_image);
        this.mImageLoader = ImageLoader.init(mContext);
        this.mImageWidth = ScreenUtil.dp2px(mContext,150);
        this.mImageHeight = ScreenUtil.dp2px(mContext,150);
    }

    @Override
    public int getCount() {
        return mUrlList.size();
    }

    @Override
    public String getItem(int position) {
        return mUrlList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = mInflater.inflate(R.layout.item,parent,false);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        ImageView imageView = holder.imageView;
        final String tag = (String) imageView.getTag();
        final String url = getItem(position);
        if (!url.equals(tag)){
            imageView.setImageDrawable(mDefaultBitmapDrawable);
        }
        if (mIsGridViewIdle){
            imageView.setTag(url);
            mImageLoader.bindBitmap(url,imageView,mImageWidth,mImageHeight);
        }
        return convertView;
    }

    static class ViewHolder{
        ImageView imageView;
    }
}
