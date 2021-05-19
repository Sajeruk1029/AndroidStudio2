package com.example.widgetmvvm.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\"\u0010\u0016\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cJ\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cR\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b\u00a8\u0006\u001e"}, d2 = {"Lcom/example/widgetmvvm/model/DataBaseHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "COL", "", "getCOL", "()Ljava/lang/String;", "COL2", "getCOL2", "TABLE_NAME", "getTABLE_NAME", "addData", "", "text", "check", "", "onCreate", "", "p0", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "p1", "p2", "select", "Ljava/util/ArrayList;", "Lcom/example/widgetmvvm/model/Data;", "Lkotlin/collections/ArrayList;", "selectTrue", "app_debug"})
public final class DataBaseHelper extends android.database.sqlite.SQLiteOpenHelper {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TABLE_NAME = "data_table";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String COL = "TEXT_TASK";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String COL2 = "CHEKED";
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTABLE_NAME() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCOL() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCOL2() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.database.sqlite.SQLiteDatabase p0) {
    }
    
    @java.lang.Override()
    public void onUpgrade(@org.jetbrains.annotations.Nullable()
    android.database.sqlite.SQLiteDatabase p0, int p1, int p2) {
    }
    
    public final boolean addData(@org.jetbrains.annotations.NotNull()
    java.lang.String text, int check) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.widgetmvvm.model.Data> select() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.widgetmvvm.model.Data> selectTrue() {
        return null;
    }
    
    public DataBaseHelper(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        super(null, null, null, 0);
    }
}