package com.example.widgetmvvm

import android.content.Intent
import android.widget.RemoteViewsService
import com.example.widgetmvvm.adapter.ListViewAdapterWidget

class MyService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory {
        return ListViewAdapterWidget(applicationContext, intent)
    }
}
