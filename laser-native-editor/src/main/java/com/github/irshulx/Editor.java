/*
 * Copyright (C) 2016 Muhammed Irshad
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.irshulx;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.ColorRes;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.github.irshulx.Components.CustomEditText;
import com.github.irshulx.models.EditorControl;
import com.github.irshulx.models.EditorTextStyle;
import com.github.irshulx.models.EditorContent;
import com.github.irshulx.models.RenderType;

import java.io.File;
import java.util.Map;

public class Editor extends EditorCore {

    public Editor(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setEditorListener(null);
        //  initialize(context,parentView,renderType,_PlaceHolderText);
    }

    public void setEditorListener(EditorListener _listener) {
        super.setEditorListener(_listener);
    }

    public EditorContent getContent() {
        return super.getContent();
    }

    public String getContentAsSerialized() {
        return super.getContentAsSerialized();
    }

    public String getContentAsSerialized(EditorContent state) {
        return super.getContentAsSerialized(state);
    }

    public EditorContent getContentDeserialized(String EditorContentSerialized) {
        return super.getContentDeserialized(EditorContentSerialized);
    }

    public String getContentAsHTML() {
        return getHTMLContent();
    }

    public String getContentAsHTML(EditorContent content) {
        return getHTMLContent(content);
    }

    public String getContentAsHTML(String editorContentAsSerialized) {
        return getHTMLContent(editorContentAsSerialized);
    }

    public void render(EditorContent _state) {
        super.renderEditor(_state);
    }

    public void render(String HtmlString) {
        renderEditorFromHtml(HtmlString);
    }

    public void render() {
        if (getRenderType() == RenderType.Editor) {
            getInputExtensions().insertEditText(0, this.getPlaceHolder(), null);
        }
    }

    private void restoreState() {
        EditorContent state = getStateFromString(null);
        render(state);
    }

    public void clearAllContents() {
        super.clearAllContents();
        if (getRenderType() == RenderType.Editor) {
            getInputExtensions().insertEditText(0, this.getPlaceHolder(), null);
        }
    }
//
//    @Override
//    public int removeParent(View view) {
//        int indexOfDeleteItem = super.removeParent(view);
//        if (indexOfDeleteItem < 0)
//            render();
//        return indexOfDeleteItem;
//    }

    //region Miscellanious getters and setters

    /*
     *
     * Input extension
     *
     */
    public int getH1TextSize() {
        return getInputExtensions().getH1TextSize();
    }

    /**
     * size in sp
     * @param size
     */
    public void setH1TextSize(int size) {
        getInputExtensions().setH1TextSize(size);
    }

    public int getH2TextSize() {
        return getInputExtensions().getH2TextSize();
    }

    /**
     * size in sp
     * @param size
     */
    public void setH2TextSize(int size) {
        getInputExtensions().setH2TextSize(size);
    }

    public int getH3TextSize() {
        return getInputExtensions().getH3TextSize();
    }

    /**
     * size in sp
     * @param size
     */
    public void setH3TextSize(int size) {
        getInputExtensions().setH3TextSize(size);
    }

    /**
     * size in sp
     * @param size
     */
    public void setNormalTextSize(int size){
        getInputExtensions().setNormalTextSize(size);
    }


    /**
     * set dafault text color in hex
     * @param color
     */
    public void setEditorTextColor(String color) {
        getInputExtensions().setDefaultTextColor(color);
    }

    /**
     * Set the fontface for the editor
     *
     * @deprecated use {@link #setContentTypeface(Map)} and {@link #setHeadingTypeface(Map)} (Map)} ()} instead.
     */
    @Deprecated
    public void setFontFace(int StringResource) {
        getInputExtensions().setFontFace(StringResource);
    }


    public void updateTextStyle(EditorTextStyle style) {
        getInputExtensions().UpdateTextStyle(style, null);
    }

    public void updateTextColor(String color){
        getInputExtensions().updateTextColor(color, null);
    }

    public void insertLink() {
        getInputExtensions().insertLink();
    }

    public void insertLink(String link) {
        getInputExtensions().insertLink(link);
    }

    public void appendText(Editable text) {
        getInputExtensions().appendText(text);
    }


    /**
     * setup the fontfaces for editor content
     * For eg:
     * Map<Integer, String> typefaceMap = new HashMap<>();
     * typefaceMap.put(Typeface.NORMAL,"fonts/GreycliffCF-Medium.ttf");
     * typefaceMap.put(Typeface.BOLD,"fonts/GreycliffCF-Bold.ttf");
     * typefaceMap.put(Typeface.ITALIC,"fonts/GreycliffCF-Medium.ttf");
     * typefaceMap.put(Typeface.BOLD_ITALIC,"fonts/GreycliffCF-Medium.ttf");
     *
     * @param map
     */

    public void setContentTypeface(Map<Integer, String> map) {
        getInputExtensions().setContentTypeface(map);
    }

    public Map<Integer, String> getContentTypeface() {
        return getInputExtensions().getContentTypeface();
    }

    /**
     * setup the fontfaces for editor heding tags (h1,h2,h3)
     * for Eg:
     * Map<Integer, String> typefaceMap = new HashMap<>();
     * typefaceMap.put(Typeface.NORMAL,"fonts/GreycliffCF-Medium.ttf");
     * typefaceMap.put(Typeface.BOLD,"fonts/GreycliffCF-Bold.ttf");
     * typefaceMap.put(Typeface.ITALIC,"fonts/GreycliffCF-Medium.ttf");
     * typefaceMap.put(Typeface.BOLD_ITALIC,"fonts/GreycliffCF-Medium.ttf");
     *
     * @param map
     */
    public void setHeadingTypeface(Map<Integer, String> map) {
        getInputExtensions().setHeadingTypeface(map);
    }

    public Map<Integer, String> getHeadingTypeface() {
        return getInputExtensions().getHeadingTypeface();
    }


        /*
         *
         * Divider extension
         *
         */

    public void setDividerLayout(int layout) {
        this.getDividerExtensions().setDividerLayout(layout);
    }

    public void insertDivider() {
        getDividerExtensions().insertDivider(-1);
    }

        /*
         *
         * Image Extension
         *
         */

    public void setEditorImageLayout(int layout) {
        this.getImageExtensions().setEditorImageLayout(layout);
    }

    public void openImagePicker() {
        getImageExtensions().openImageGallery();
    }

    public void insertImage(Bitmap bitmap) {
        getImageExtensions().insertImage(bitmap, null,null, -1,null, true);
    }

    public void insertImage(Bitmap bitmap, File file) {
        getImageExtensions().insertImage(bitmap, file,null, -1,null, true);
    }

    public void onImageUploadComplete(String url, Bitmap bitmap, String imageId) {
        getImageExtensions().onPostUpload(url, bitmap, imageId);
    }

    public void onImageUploadFailed(String imageId) {
        getImageExtensions().onPostUpload(null, null, imageId);
    }
    /*
     *
     *List Item extension
     *
     */
    public void setListItemLayout(int layout) {
        this.getListItemExtensions().setListItemTemplate(layout);
    }

    public void insertList(boolean isOrdered) {
        this.getListItemExtensions().insertlist(isOrdered);
    }


    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event, CustomEditText editText) {
        boolean onKey = super.onKey(v, keyCode, event, editText);
        if (getParentChildCount() == 0)
            render();
        return onKey;
    }

    public void setLineSpacing(float lineSpacing) {
        this.getInputExtensions().setLineSpacing(lineSpacing);
    }

    public void setListItemLineSpacing(float lineSpacing){
        this.getListItemExtensions().setLineSpacing(lineSpacing);
    }

    public void insertMacro(String name, View view, Map<String,Object> settings) {
        this.getMacroExtensions().insertMacro(name, view, settings, -1);
    }
}
