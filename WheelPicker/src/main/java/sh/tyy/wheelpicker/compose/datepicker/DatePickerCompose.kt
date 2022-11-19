package sh.tyy.wheelpicker.compose.datepicker

import android.content.Context
import sh.tyy.wheelpicker.core.WheelPickerActionSheet

class DatePickerCompose(context: Context, title: String = "") : WheelPickerActionSheet<DatePickerComposeView>(context) {
    init {
        setPickerView(DatePickerComposeView(context), title)
    }
}