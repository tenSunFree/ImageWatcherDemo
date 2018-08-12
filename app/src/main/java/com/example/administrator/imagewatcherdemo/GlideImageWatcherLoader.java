package com.example.administrator.imagewatcherdemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.github.ielse.imagewatcher.ImageWatcher;

class GlideImageWatcherLoader implements ImageWatcher.Loader {
    @Override
    public void load(Context context, Uri uri, final ImageWatcher.LoadCallback lc) {
        Glide.with(context).load(uri).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                lc.onResourceReady(resource);
                Log.v("more", "GlideImageWatcherLoader, onResourceReady");
            }

            @Override
            public void onLoadFailed(@Nullable Drawable errorDrawable) {
                lc.onLoadFailed(errorDrawable);
                Log.v("more", "GlideImageWatcherLoader, onLoadFailed");
            }

            @Override
            public void onLoadStarted(@Nullable Drawable placeholder) {
                lc.onLoadStarted(placeholder);
                Log.v("more", "GlideImageWatcherLoader, onLoadStarted");
            }
        });
    }
}
