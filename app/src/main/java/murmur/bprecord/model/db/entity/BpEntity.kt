package murmur.bprecord.model.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Bp")
data class BpEntity(@PrimaryKey(autoGenerate = true)
                    var id: Long?,
                    val date: Long,
                    val systolic: Double,
                    val diastolic: Double,
                    val pulse: Int)