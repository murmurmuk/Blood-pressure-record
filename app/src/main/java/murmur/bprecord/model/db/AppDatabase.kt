package murmur.bprecord.model.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import murmur.bprecord.model.db.dao.BpDao
import murmur.bprecord.model.db.entity.BpEntity


@Database(entities = [BpEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bpDao(): BpDao

    companion object {
        const val DATABASE_NAME = "bp_db"
    }
}