package com.lqm.tomatoit.manager;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.FutureTarget;
import com.lqm.tomatoit.R;
import com.lqm.tomatoit.app.App;

import java.io.File;

/**
 * @user lqm
 * @desc 图片加载管理
 */
public class ImageLoaderManager {

//    @Override
//    public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
//        Glide.with(activity).load(new File(path))
//                .placeholder(R.mipmap.ic_lazy)
//                .dontAnimate()
//                .error(R.mipmap.default_img_test)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(imageView);
//    }

    public static void LoadImage(Context context, String imgUrl, ImageView imageView) {

        Glide.with(App.getmContext()).load(imgUrl)
                .placeholder(R.mipmap.default_img)
                .dontAnimate() //解决圆形图显示占位图问题
                .error(R.mipmap.default_img)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);

    }


    /**
     * 缓存图片到本地
     */
    public static File CacheFile(Context context, String imgUrl, ImageView imageView){
        File cacheFile = null;
        FutureTarget<File> future = Glide.with(context)
                .load(imgUrl)
                .downloadOnly(500, 500);
        try {
             cacheFile = future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cacheFile;
    }


}