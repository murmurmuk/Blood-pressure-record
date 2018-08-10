package murmur.bprecord.di.mainActivity

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import murmur.bprecord.di.ViewModelKey
import murmur.bprecord.view.MainViewModel

@Module
interface MainActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModell(mainViewModel: MainViewModel): ViewModel
}