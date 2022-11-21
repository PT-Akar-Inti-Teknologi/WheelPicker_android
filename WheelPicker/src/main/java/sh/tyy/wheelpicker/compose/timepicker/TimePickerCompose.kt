package sh.tyy.wheelpicker.compose.timepicker

import android.content.Context
import androidx.compose.ui.graphics.Color
import sh.tyy.wheelpicker.core.WheelPickerActionSheet

class TimePickerCompose(context: Context, title: String, color: Color, titleCenter: Boolean) : WheelPickerActionSheet<TimePickerComposeView>(context) {
    init {
        setPickerView(TimePickerComposeView(context), title, color, titleCenter)
    }
}