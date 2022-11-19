package sh.tyy.wheelpicker.compose.datepicker

import android.content.Context
import androidx.compose.ui.graphics.Color
import sh.tyy.wheelpicker.core.WheelPickerActionSheet

class DatePickerCompose(context: Context, title: String = "", color: Color, titleCenter: Boolean) : WheelPickerActionSheet<DatePickerComposeView>(context) {
    init {
        setPickerView(DatePickerComposeView(context), title, color, titleCenter)
    }
}