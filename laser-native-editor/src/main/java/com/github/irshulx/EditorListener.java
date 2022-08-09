package com.github.irshulx;

import android.arch.core.util.Function;
import android.graphics.Bitmap;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.util.Map;

/**
 * Created by IRSHU on 27/2/2017.
 */

public interface EditorListener{
    void onTextChanged(EditText editText, Editable text);
    void onUpload(Bitmap image, File file, String uuid);
    void onRemoved(View view, File file);
    View onRenderMacro(String name, Map<String, Object> props, int index);
}