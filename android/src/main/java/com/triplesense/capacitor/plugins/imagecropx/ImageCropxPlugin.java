package com.triplesense.capacitor.plugins.imagecropx;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import com.getcapacitor.AndroidProtocolHandler;
import com.getcapacitor.FileUtils;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.ActivityCallback;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

@CapacitorPlugin(name = "ImageCropx")
public class ImageCropxPlugin extends Plugin {

    @PluginMethod
    public void show(PluginCall call) {
        try {
            String source = call.getString("source");
            int width = call.getInt("width", 300);
            int height = call.getInt("height", 300);
            boolean lock = call.getBoolean("lock", false);

            File dest = new File(getActivity().getCacheDir().getAbsolutePath() + "/CAP_CROP.jpg");

            boolean isAppPath = false;

            if (source.contains("~")) {
                isAppPath = true;
                source = source.replace("~", "");
            }

            AndroidProtocolHandler protocolHandler = new AndroidProtocolHandler(getActivity().getApplicationContext());

            File tempSource;
            if (isAppPath) {
                File f = new File("file:///android_asset/public" + source);
                InputStream is = protocolHandler.openAsset("public" + source);
                tempSource = new File(getActivity().getCacheDir().getAbsolutePath() + f.getName());
                FileOutputStream os = new FileOutputStream(tempSource);
                IOUtils.copy(is, os);
                os.close();
            } else {
                if (source.startsWith("file:")) {
                    Uri uri = Uri.parse(source);
                    tempSource = new File(uri.getPath());
                } else {
                    tempSource = new File(source);
                }
            }

            bridge.saveCall(call);

            UCrop crop = UCrop.of(Uri.fromFile(tempSource), Uri.fromFile(dest));

            if (lock) {
                crop = crop.useSourceImageAspectRatio();
            }

            Intent intent = crop.withMaxResultSize(width, height).getIntent(getActivity()); //.start(getActivity());

            startActivityForResult(call, intent, "cropCallback");
        } catch (IOException e) {
            Log.v(getLogTag(), "Error: " + e.getMessage());
            call.reject(e.getLocalizedMessage());
        }
    }

    /**
     * Completes the plugin call after permission request
     *
     * @param call the plugin call
     */
    @ActivityCallback
    private void cropCallback(PluginCall call, ActivityResult result) {
        Intent data = result.getData();
        if (result.getResultCode() == Activity.RESULT_OK) {
            final Uri resultUri = UCrop.getOutput(data);
            JSObject object = new JSObject();
            object.put("value", FileUtils.getPortablePath(getContext(), bridge.getLocalUrl(), resultUri));
            call.resolve(object);
        } else {
            final Throwable cropError = UCrop.getError(data);
            call.reject(cropError.getLocalizedMessage());
        }
    }
}
