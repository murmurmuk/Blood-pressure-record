package murmur.bprecord.di

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import murmur.bprecord.model.db.AppDatabase
import murmur.bprecord.model.db.AppDatabase.Companion.DATABASE_NAME
import javax.inject.Singleton

@Module
object AppModule {
    @JvmStatic
    @Provides
    @Singleton
    fun provideAppDatabase(ctx: Context): AppDatabase {
        return Room.databaseBuilder(ctx.applicationContext,
                AppDatabase::class.java, DATABASE_NAME).build()
    }
}