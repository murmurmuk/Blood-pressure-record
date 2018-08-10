package murmur.bprecord.view

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import murmur.bprecord.model.BpRepository
import murmur.bprecord.model.db.entity.BpEntity
import murmur.bprecord.util.toLiveData
import javax.inject.Inject

class MainViewModel  @Inject constructor(private val repository: BpRepository) : ViewModel() {
    val bpData: LiveData<List<BpEntity>> by lazy {
        repository.getAllData()
                .subscribeOn(Schedulers.io())
                .toLiveData()
    }

    fun addNewEntry(item: BpEntity) {
        repository.addNewEntry(item)
                .subscribeOn(Schedulers.io())
                .subscribeBy(
                        onComplete = {
                            Log.d("kanna", "add data success")
                        },
                        onError = {
                            Log.e("kanna", "error with ${it.message}")
                        }
                )
    }
}