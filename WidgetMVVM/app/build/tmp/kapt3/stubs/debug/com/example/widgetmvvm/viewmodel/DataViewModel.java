package com.example.widgetmvvm.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/widgetmvvm/viewmodel/DataViewModel;", "Landroidx/lifecycle/ViewModel;", "listener", "Lcom/example/widgetmvvm/LoginResultCallBacks;", "(Lcom/example/widgetmvvm/LoginResultCallBacks;)V", "DB", "Lcom/example/widgetmvvm/model/DataBaseHelper;", "getDB", "()Lcom/example/widgetmvvm/model/DataBaseHelper;", "setDB", "(Lcom/example/widgetmvvm/model/DataBaseHelper;)V", "TextWatcher", "Landroid/text/TextWatcher;", "getTextWatcher", "()Landroid/text/TextWatcher;", "adapter", "Lcom/example/widgetmvvm/adapter/ListViewAdapter;", "getAdapter", "()Lcom/example/widgetmvvm/adapter/ListViewAdapter;", "setAdapter", "(Lcom/example/widgetmvvm/adapter/ListViewAdapter;)V", "data", "Lcom/example/widgetmvvm/model/Data;", "onAddClicked", "", "v", "Landroid/view/View;", "test", "app_debug"})
public final class DataViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.widgetmvvm.model.Data data = null;
    @org.jetbrains.annotations.Nullable()
    private com.example.widgetmvvm.model.DataBaseHelper DB;
    @org.jetbrains.annotations.Nullable()
    private com.example.widgetmvvm.adapter.ListViewAdapter adapter;
    private final com.example.widgetmvvm.LoginResultCallBacks listener = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.text.TextWatcher getTextWatcher() {
        return null;
    }
    
    public final void test(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.widgetmvvm.model.DataBaseHelper getDB() {
        return null;
    }
    
    public final void setDB(@org.jetbrains.annotations.Nullable()
    com.example.widgetmvvm.model.DataBaseHelper p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.widgetmvvm.adapter.ListViewAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.Nullable()
    com.example.widgetmvvm.adapter.ListViewAdapter p0) {
    }
    
    public final void onAddClicked(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public DataViewModel(@org.jetbrains.annotations.NotNull()
    com.example.widgetmvvm.LoginResultCallBacks listener) {
        super();
    }
}