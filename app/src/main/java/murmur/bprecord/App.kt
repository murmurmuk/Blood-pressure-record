package murmur.bprecord

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import murmur.bprecord.di.DaggerAppComponent

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().appContext(this).build()
    }
}