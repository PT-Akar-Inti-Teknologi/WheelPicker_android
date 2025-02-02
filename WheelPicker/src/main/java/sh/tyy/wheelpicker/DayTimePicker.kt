package sh.tyy.wheelpicker

import android.content.Context
import sh.tyy.wheelpicker.core.WheelPickerActionSheet

class DayTimePicker(context: Context) : WheelPickerActionSheet<DayTimePickerView>(context) {
    init {
        setPickerView(DayTimePickerView(context), "")
    }
}