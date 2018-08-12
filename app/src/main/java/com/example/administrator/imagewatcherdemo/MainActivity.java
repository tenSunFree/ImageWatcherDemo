package com.example.administrator.imagewatcherdemo;

import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.github.ielse.imagewatcher.ImageWatcher;
import com.github.ielse.imagewatcher.ImageWatcherHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MessagePicturesLayout.Callback {

    private int isNumber;
    private boolean isTranslucentStatus;

    private List<Data> dataArrayList = new ArrayList<>();

    private ImageView imageView, thumbnailImageView, thumbnail2ImageView, thumbnail3ImageView;
    private ImageWatcher imageWatcher;
    private Button selectButton, select2Button, select3Button;
    private MessagePicturesLayout messagePicturesLayout;
    private LinearLayout checkoutLinearLayout, promptMessageLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializationView();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            isTranslucentStatus = true;
        }

        /** 动态 addView */
        imageWatcher = ImageWatcherHelper.with(this)                                                 // 一般来讲, ImageWatcher需要占据全屏的位置
                .setTranslucentStatus(                                                              // 如果不是透明状态栏, 你需要给ImageWatcher标记一个偏移值, 以修正点击ImageView查看的启动动画的Y轴起点的不正确
                        !isTranslucentStatus ? Utils.calcStatusBarHeight(this) : 0)
                .setErrorImageRes(R.mipmap.error_picture)                                               // 配置error图标, 如果不介意使用lib自带的图标, 并不一定要调用这个API
                .setOnPictureLongPressListener(new ImageWatcher.OnPictureLongPressListener() {      // 长按图片的回调, 你可以显示一个框继续提供一些复制, 发送等功能
                    @Override
                    public void onPictureLongPress(ImageView v, Uri uri, int pos) {                 // 對圖片長按的監聽
                    }
                })
                .setLoader(new GlideImageWatcherLoader())
                .setOnStateChangedListener(new ImageWatcher.OnStateChangedListener() {
                    @Override
                    public void onStateChangeUpdate(ImageWatcher imageWatcher, ImageView clicked, int position, Uri uri, float animatedValue, int actionTag) {
                    }

                    @Override
                    public void onStateChanged(ImageWatcher imageWatcher, int position, Uri uri, int actionTag) {

                        /** 先判斷是否拖曳結束, 如果是的話 就隱藏提示訊息, 然後顯示圖片, 最後再判斷 3個圖片都顯示時, 就呼叫結帳的layout */
                        if (actionTag == ImageWatcher.STATE_EXIT_HIDING) {
                            promptMessageLinearLayout.setVisibility(View.INVISIBLE);
                            switch (isNumber) {
                                case 1:
                                    Glide.with(getApplicationContext())
                                            .load(uri)
                                            .into(thumbnailImageView);
                                    break;
                                case 2:
                                    Glide.with(getApplicationContext())
                                            .load(uri)
                                            .into(thumbnail2ImageView);
                                    break;
                                case 3:
                                    Glide.with(getApplicationContext())
                                            .load(uri)
                                            .into(thumbnail3ImageView);
                                    break;
                            }
                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    if (thumbnailImageView.getDrawable() != null
                                            && thumbnail2ImageView.getDrawable() != null
                                            && thumbnail3ImageView.getDrawable() != null) {
                                        checkoutLinearLayout.setVisibility(View.VISIBLE);
                                    } else {
                                        checkoutLinearLayout.setVisibility(View.GONE);
                                    }
                                }
                            }, 200);
                        }
                    }
                })
                .setLoadingUIProvider(new ImageWatcher.LoadingUIProvider() {
                    final FrameLayout.LayoutParams lpCenterInParent = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                    @Override
                    public View initialView(ViewGroup parent) {
                        ImageView load = new ImageView(parent.getContext());
                        lpCenterInParent.gravity = Gravity.CENTER;
                        load.setLayoutParams(lpCenterInParent);
                        load.setImageResource(R.drawable.dice_action);
                        return load;
                    }

                    @Override
                    public void start(View loadView) {
                        loadView.setVisibility(View.VISIBLE);
                        ((AnimationDrawable) ((ImageView) loadView).getDrawable()).start();
                    }

                    @Override
                    public void stop(View loadView) {
                        ((AnimationDrawable) ((ImageView) loadView).getDrawable()).stop();
                        loadView.setVisibility(View.GONE);
                    }
                })
                .create();

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /** 先將資料設置為第一筆, 然後呼叫圖片選擇畫面 */
                messagePicturesLayout.set(dataArrayList.get(0).getPictureThumbList(), dataArrayList.get(0).getPictureList());
                messagePicturesLayout.notifyDataChanged();
                isNumber = 1;
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        imageWatcher.show(imageView, messagePicturesLayout.mVisiblePictureList, messagePicturesLayout.mDataList);
                        promptMessageLinearLayout.setVisibility(View.VISIBLE);
                    }
                }, 200);
            }
        });

        select2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /** 先將資料設置為第二筆, 然後呼叫圖片選擇畫面 */
                messagePicturesLayout.set(dataArrayList.get(1).getPictureThumbList(), dataArrayList.get(1).getPictureList());
                messagePicturesLayout.notifyDataChanged();
                isNumber = 2;
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        imageWatcher.show(imageView, messagePicturesLayout.mVisiblePictureList, messagePicturesLayout.mDataList);
                        promptMessageLinearLayout.setVisibility(View.VISIBLE);
                    }
                }, 200);
            }
        });

        select3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /** 先將資料設置為第三筆, 然後呼叫圖片選擇畫面 */
                messagePicturesLayout.set(dataArrayList.get(2).getPictureThumbList(), dataArrayList.get(2).getPictureList());
                messagePicturesLayout.notifyDataChanged();
                isNumber = 3;
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        imageWatcher.show(imageView, messagePicturesLayout.mVisiblePictureList, messagePicturesLayout.mDataList);
                        promptMessageLinearLayout.setVisibility(View.VISIBLE);
                    }
                }, 200);
            }
        });
    }

    /**
     * 初始化view
     */
    private void initializationView() {
        messagePicturesLayout = findViewById(R.id.messagePicturesLayout);
        checkoutLinearLayout = findViewById(R.id.checkoutLinearLayout);
        promptMessageLinearLayout = findViewById(R.id.promptMessageLinearLayout);
        thumbnailImageView = findViewById(R.id.thumbnailImageView);
        thumbnail2ImageView = findViewById(R.id.thumbnail2ImageView);
        thumbnail3ImageView = findViewById(R.id.thumbnail3ImageView);
        selectButton = findViewById(R.id.selectButton);
        select2Button = findViewById(R.id.select2Button);
        select3Button = findViewById(R.id.select3Button);

        dataArrayList = Data.get();
        messagePicturesLayout.set(dataArrayList.get(0).getPictureThumbList(), dataArrayList.get(0).getPictureList());
        isNumber = 1;
        messagePicturesLayout.setCallback(this);
        messagePicturesLayout.setVisibility(View.INVISIBLE);
        imageView = messagePicturesLayout.iPictureList.get(0);
    }

    @Override
    public void onThumbPictureClick(ImageView i, SparseArray<ImageView> imageGroupList, List<Uri> urlList) {
    }
}
