package expo.modules.cyberwidget

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue

fun Int.dp(): Int {
    return (this * DisplayMetrics.DENSITY_DEFAULT / DisplayMetrics.DENSITY_DEFAULT)
}


fun Int.dpFloat(): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        DisplayMetrics()
    )
}
