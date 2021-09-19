package com.gentlekboy.dependencyinjectionclasswork.dependencyInjection

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//My Application class extends Application() which tells hilt to make use of the application context with respect to our dependencies
@HiltAndroidApp
class MyApplication: Application()