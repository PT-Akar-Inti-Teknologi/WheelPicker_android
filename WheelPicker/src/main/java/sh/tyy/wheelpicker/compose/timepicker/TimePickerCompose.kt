package sh.tyy.wheelpicker.compose.timepicker

import android.content.Context
import sh.tyy.wheelpicker.core.WheelPickerActionSheet

class TimePickerCompose(context: Context, title: String) : WheelPickerActionSheet<TimePickerComposeView>(context) {
    init {
        setPickerView(TimePickerComposeView(context), title)
    }
}