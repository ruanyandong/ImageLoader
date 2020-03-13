package com.miracle.imageloader.imageloader;

/**
 * @author miracle
 * @date 2020-03-12
 * @email ruanyandongai@gmail.com
 * @blog https://ruanyandong.github.io
 */

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileDescriptor;

/**
 * 修改采样率进行图片的压缩功能
 */
public class ImageResizer {

    private static final String TAG = "ImageResizer";

    public ImageResizer(){
    }

    public Bitmap decodeSampledBitmapFromResource(Resources res, int resId,int reqWidth,int reqHeight){
        final BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res,resId,options);
        options.inSampleSize = calculateInSampleSize(options,reqWidth,reqHeight);
        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeResource(res,resId,options);

    }

    public Bitmap decodeSampledBitmapFromFileDescriptor(FileDescriptor fd,int reqWidth,int reqHeight){
        final BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fd,null,options);
        options.inSampleSize = calculateInSampleSize(options,reqWidth,reqHeight);
        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeFileDescriptor(fd,null,options);
    }


    // 计算缩放比率
    public int calculateInSampleSize(BitmapFactory.Options options,int reqWidth,int reqHeight){
        if (reqHeight == 0 || reqHeight == 0){
            return 1;
        }
        final int height = options.outHeight;
        final int width = options.outWidth;

        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth){
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth){
                inSampleSize = inSampleSize * 2;
            }
        }
        return inSampleSize;
    }
}
