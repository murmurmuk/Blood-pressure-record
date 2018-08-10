package murmur.bprecord.util

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date

object BpEntityUtil {
    fun parseDate(date: Long): String {
        val sdFormat = SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.US)
        return sdFormat.format(Date(date))
    }

    fun parseSystolic(systolic: Double): SpannableString {
        val tmp = "Systolic: "
        val string = SpannableString("$tmp $systolic")
        val colorSpan = ForegroundColorSpan(Color.parseColor("#ff2020"))
        if (systolic > 120.0f) {
            string.setSpan(colorSpan, tmp.length, string.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        return string
    }

    fun parseDiastolic(diastolic: Double): SpannableString {
        val tmp = "Diastolic: "
        val string = SpannableString("$tmp $diastolic")
        val colorSpan = ForegroundColorSpan(Color.parseColor("#ff2020"))
        if (diastolic > 80.0f) {
            string.setSpan(colorSpan, tmp.length, string.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        return string
    }

    fun parsePulse(pulse: Int): String {
        return "Pulse: $pulse"
    }
}