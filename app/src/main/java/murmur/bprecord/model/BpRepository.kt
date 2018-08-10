package murmur.bprecord.model

import io.reactivex.Completable
import murmur.bprecord.model.db.AppDatabase
import murmur.bprecord.model.db.entity.BpEntity
import javax.inject.Inject

class BpRepository @Inject constructor(appDatabase: AppDatabase) {
    private val dao = appDatabase.bpDao()

    fun getAllData() = dao.getBpAll()

    fun addNewEntry(item: BpEntity): Completable {
        return Completable.fromCallable {
            dao.insert(item)
        }
    }
}