package sh.tyy.wheelpicker

import android.content.Context
import sh.tyy.wheelpicker.core.WheelPickerActionSheet

class DatePickerCompose(context: Context) : WheelPickerActionSheet<DatePickerComposeView>(context) {
    init {
        setPickerView(DatePickerComposeView(context))
    }
}