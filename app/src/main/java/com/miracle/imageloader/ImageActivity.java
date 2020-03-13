package com.miracle.imageloader;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.GridView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.miracle.imageloader.adapter.ImageAdapter;
import java.util.Arrays;

/**
 * @author -> miracle
 * @date -> 2020/3/13
 * @email -> ruanyandongai@gmail.com 729368173@qq.com
 * @phone -> 18983790146
 * @blog -> https://ruanyandong.github.io
 */

/**
 * 开启硬件加速加载更加流畅
 */
public class ImageActivity extends AppCompatActivity {

    private GridView mGridView;
    private ImageAdapter mImageAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        mGridView = findViewById(R.id.grid_view);
        mImageAdapter = new ImageAdapter(Arrays.asList(Images.imageThumbUrls),this);
        mGridView.setAdapter(mImageAdapter);
        mGridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                // 停滞的时候才加载图片
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE){
                    mImageAdapter.setGridViewIdle(true);
                    mImageAdapter.notifyDataSetChanged();
                }else {
                    mImageAdapter.setGridViewIdle(false);
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }
}
