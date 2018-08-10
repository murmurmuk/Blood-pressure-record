package murmur.bprecord.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import murmur.bprecord.App
import murmur.bprecord.di.mainActivity.MainActivityBuilder
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ViewModelModule::class,
    AppModule::class,
    MainActivityBuilder::class
])
interface AppComponent : AndroidInjector<App> {
    override fun inject(instance: App?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appContext(ctx: Context): Builder

        fun build(): AppComponent
    }
}