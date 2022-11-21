package sh.tyy.wheelpicker.compose.timepicker

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.Window
import androidx.compose.ui.graphics.Color
import sh.tyy.wheelpicker.R

@SuppressLint("InflateParams")
fun timePickerComposeAction(
    value: String,
    context: Context,
    window: Window,
    title: String,
    buttonColor: Color = Color(0xFFE91639),
    titleCenter: Boolean = false,
    date: (date: String) -> Unit
) {
    lateinit var dayTimePickerView: TimePickerComposeView

    val valueArray = value.split(":").toTypedArray()

    val picker = TimePickerCompose(context = context, title = title, color = buttonColor, titleCenter = titleCenter)
    val view = LayoutInflater.from(context).inflate(R.layout.time_picker, null, false)
    dayTimePickerView = view.findViewById(R.id.custom_time_picker_views)
    picker.show(window = window)

    if (value.isNotBlank()) {
        picker.pickerView?.minutes = valueArray[0].toInt()
        picker.pickerView?.hours = valueArray[1].toInt()
    }

    picker.setOnClickOkButtonListener {
        val pickerView = picker.pickerView ?: return@setOnClickOkButtonListener
        dayTimePickerView.minutes = pickerView.minutes
        dayTimePickerView.hours = pickerView.hours

        Log.d("TAG ", "timePickerComposeAction: ${pickerView.minutes} ${pickerView.hours}")

        date("${String.format("%02d",pickerView.minutes)}:${String.format("%02d",pickerView.hours)}")

        picker.hide()
    }
    picker.setOnDismissListener {
//        Toast.makeText(context, "Action Sheet Dismiss", Toast.LENGTH_SHORT).show()
    }
}