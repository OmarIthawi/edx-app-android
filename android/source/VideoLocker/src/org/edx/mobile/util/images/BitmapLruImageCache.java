package org.edx.mobile.util.images;

import com.android.volley.toolbox.ImageLoader.ImageCache;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;

import org.edx.mobile.logger.OEXLogger;

/**
 * Basic LRU Memory cache.
 */
public class BitmapLruImageCache extends LruCache<String, Bitmap> implements ImageCache{

    private final OEXLogger logger = new OEXLogger(getClass().getName());
    
    public BitmapLruImageCache(int maxSize) {
        super(maxSize);
    }
    
    @Override
    protected int sizeOf(String key, Bitmap value) {
        return value.getRowBytes() * value.getHeight();
    }
    
    @Override
    public Bitmap getBitmap(String url) {
        logger.debug("Retrieved item from Mem Cache");
        return get(url);
    }
 
    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        logger.debug("Added item to Mem Cache");
        put(url, bitmap);
    }
}
