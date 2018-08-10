package murmur.bprecord.model.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import murmur.bprecord.model.db.entity.BpEntity

@Dao
interface BpDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: BpEntity)

    @Query("SELECT * FROM Bp ORDER BY id DESC")
    fun getBpAll(): Flowable<List<BpEntity>>

}