package com.miracle.imageloader.screen;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

/**
 * @author -> miracle
 * @date -> 2020/3/13
 * @email -> ruanyandongai@gmail.com 729368173@qq.com
 * @phone -> 18983790146
 * @blog -> https://ruanyandong.github.io
 */

/**
 * 屏幕工具类
 */
public class ScreenUtil {

    public static int px2dp(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    public static int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static int px2sp(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (px / scale + 0.5f);
    }

    public static int sp2px(Context context, float sp) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (sp * scale + 0.5f);
    }
//======================  获取屏幕宽高=====================
//    方法1
//    Display defaultDisplay = getWindowManager().getDefaultDisplay();
//    Point point = new Point();
//    defaultDisplay.getSize(point);
//    int x = point.x;
//    int y = point.y;
    //Log.i(TAG, "x = " + x + ",y = " + y);
    //x = 1440,y = 2768

    // 方法2
    //    Rect outSize = new Rect();
    //    getWindowManager().getDefaultDisplay().getRectSize(outSize);
    //    int left = outSize.left;
    //    int top = outSize.top;
    //    int right = outSize.right;
    //    int bottom = outSize.bottom;
    //Log.d(TAG, "left = " + left + ",top = " + top + ",right = " + right + ",bottom = " + bottom);
    //left = 0,top = 0,right = 1440,bottom = 2768

    // 方法3
//    DisplayMetrics outMetrics = new DisplayMetrics();
//    getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
//    int widthPixels = outMetrics.widthPixels;
//    int heightPixels = outMetrics.heightPixels;
    //Log.i(TAG, "widthPixels = " + widthPixels + ",heightPixels = " + heightPixels);
    //widthPixels = 1440, heightPixels = 2768

// 方法4
//    Point outSize = new Point();
//    getWindowManager().getDefaultDisplay().getRealSize(outSize);
//    int x = outSize.x;
//    int y = outSize.y;
    //Log.w(TAG, "x = " + x + ",y = " + y);
    //x = 1440,y = 2960

    //  方法5
//    DisplayMetrics outMetrics = new DisplayMetrics();
//    getWindowManager().getDefaultDisplay().getRealMetrics(outMetrics);
//    int widthPixel = outMetrics.widthPixels;
//    int heightPixel = outMetrics.heightPixels;
//    Log.w(TAG, "widthPixel = " + widthPixel + ",heightPixel = " + heightPixel);
//    //widthPixel = 1440,heightPixel = 2960


//    我们注意到方法1,2,3显示屏幕的分辨率是 1440x2768，而方法4,5显示的屏幕的分辨率是1440x2960。为什么是这样了？
//
//    答：显示区域以两种不同的方式描述。包括应用程序的显示区域和实际显示区域。
//    应用程序显示区域指定可能包含应用程序窗口的显示部分，不包括系统装饰。 应用程序显示区域可以小于实际显示区域，因为系统减去诸如状态栏之类的装饰元素所需的空间。 使用以下方法查询应用程序显示区域：getSize（Point），getRectSize（Rect）和getMetrics（DisplayMetrics）。
//    实际显示区域指定包含系统装饰的内容的显示部分。 即便如此，如果窗口管理器使用（adb shell wm size）模拟较小的显示器，则实际显示区域可能小于显示器的物理尺寸。 使用以下方法查询实际显示区域：getRealSize（Point），getRealMetrics（DisplayMetrics）。
//

    public static int getScreenWidth(Context context) {
        DisplayMetrics outMetrics = new DisplayMetrics();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (manager != null){
            manager.getDefaultDisplay().getMetrics(outMetrics);
        }
        return outMetrics.widthPixels;
    }

    public static int getScreenHeight(Context context){
        DisplayMetrics outMetrics = new DisplayMetrics();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (manager != null){
            manager.getDefaultDisplay().getMetrics(outMetrics);
        }
        return outMetrics.heightPixels;
    }
}
