package sh.tyy.wheelpicker.compose.timepicker

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.Window
import sh.tyy.wheelpicker.R
import sh.tyy.wheelpicker.compose.datepicker.DatePickerCompose
import sh.tyy.wheelpicker.compose.datepicker.DatePickerComposeView

@SuppressLint("InflateParams")
fun timePickerComposeAction(
    context: Context,
    window: Window,
    title: String,
    date: (date: String) -> Unit
) {
    lateinit var dayTimePickerView: TimePickerComposeView

    val picker = TimePickerCompose(context = context, title = title)
    val view = LayoutInflater.from(context).inflate(R.layout.time_picker, null, false)
    dayTimePickerView = view.findViewById(R.id.custom_time_picker_views)
    picker.show(window = window)

    picker.pickerView?.minutes = dayTimePickerView.minutes
    picker.pickerView?.hours = dayTimePickerView.hours
    picker.setOnClickOkButtonListener {
        val pickerView = picker.pickerView ?: return@setOnClickOkButtonListener
        dayTimePickerView.minutes = pickerView.minutes
        dayTimePickerView.hours = pickerView.hours

        Log.d("TAG ", "timePickerComposeAction: ${pickerView.minutes} ${pickerView.hours}")

        date("${pickerView.minutes} : ${pickerView.hours}")

        picker.hide()
    }
    picker.setOnDismissListener {
//        Toast.makeText(context, "Action Sheet Dismiss", Toast.LENGTH_SHORT).show()
    }
}