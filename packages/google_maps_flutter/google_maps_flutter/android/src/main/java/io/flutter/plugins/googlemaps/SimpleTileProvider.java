package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.UrlTileProvider;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by gurun on 06.02.2020.
 */
public class SimpleTileProvider extends UrlTileProvider {

    private final String urlPattern;

    public SimpleTileProvider(String urlPattern, int width, int height) {
        super(width, height);
        this.urlPattern = urlPattern;
    }

    @Override
    public URL getTileUrl(int x, int y, int zoom) {
        /* Define the URL pattern for the tile images */
        String url = String.format(urlPattern, zoom, x, y);

        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            throw new AssertionError(e);
        }
    }
}
