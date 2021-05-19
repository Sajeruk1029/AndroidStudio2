package com.example.widgetmvvm;

import java.lang.System;

/**
 * Implementation of App Widget functionality.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\"\u0010\u0010\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/example/widgetmvvm/ListViewAppWidget;", "Landroid/appwidget/AppWidgetProvider;", "()V", "onUpdate", "", "context", "Landroid/content/Context;", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "appWidgetIds", "", "setList", "rv", "Landroid/widget/RemoteViews;", "appWidgetId", "", "setListClick", "setUpdateTV", "updateWidget", "app_debug"})
public final class ListViewAppWidget extends android.appwidget.AppWidgetProvider {
    
    @java.lang.Override()
    public void onUpdate(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.appwidget.AppWidgetManager appWidgetManager, @org.jetbrains.annotations.NotNull()
    int[] appWidgetIds) {
    }
    
    public final void updateWidget(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.appwidget.AppWidgetManager appWidgetManager, int appWidgetId) {
    }
    
    public final void setUpdateTV(@org.jetbrains.annotations.NotNull()
    android.widget.RemoteViews rv, @org.jetbrains.annotations.Nullable()
    android.content.Context context, int appWidgetId) {
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    android.widget.RemoteViews rv, @org.jetbrains.annotations.Nullable()
    android.content.Context context, int appWidgetId) {
    }
    
    public final void setListClick(@org.jetbrains.annotations.Nullable()
    android.widget.RemoteViews rv, @org.jetbrains.annotations.Nullable()
    android.content.Context context, int appWidgetId) {
    }
    
    public ListViewAppWidget() {
        super();
    }
}