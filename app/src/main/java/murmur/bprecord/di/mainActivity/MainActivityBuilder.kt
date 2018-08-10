package murmur.bprecord.di.mainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import murmur.bprecord.view.MainActivity

@Module
interface MainActivityBuilder {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun contributeMainActivity(): MainActivity
}