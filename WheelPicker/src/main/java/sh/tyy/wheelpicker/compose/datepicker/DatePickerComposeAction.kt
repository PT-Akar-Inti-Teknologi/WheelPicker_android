package sh.tyy.wheelpicker

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.Window
import sh.tyy.wheelpicker.compose.datepicker.DatePickerCompose
import sh.tyy.wheelpicker.compose.datepicker.DatePickerComposeView
import java.util.*

@SuppressLint("InflateParams")
fun datePickerComposeAction(
    value: String,
    context: Context,
    window: Window,
    title: String,
    date: (date: String) -> Unit
) {
    lateinit var dayTimePickerView: DatePickerComposeView

    val valueArray = value.split("-").toTypedArray()

    val picker = DatePickerCompose(context = context, title = title)
    val view = LayoutInflater.from(context).inflate(R.layout.wheel_picker, null, false)
    dayTimePickerView = view.findViewById(R.id.custom_picker_views)
    picker.show(window)

    if (value.isNotBlank()) {
        picker.pickerView?.day = valueArray[0].toInt()
        picker.pickerView?.months = valueArray[1].toInt()
        picker.pickerView?.year = valueArray[2].toInt()
    }

    picker.setOnClickOkButtonListener {
        val pickerView = picker.pickerView ?: return@setOnClickOkButtonListener

        dayTimePickerView.day = pickerView.day
        dayTimePickerView.months = pickerView.months
        dayTimePickerView.year = pickerView.year

        date("${String.format("%02d", pickerView.day)}-${String.format("%02d", pickerView.months)}-${pickerView.year}")

        picker.hide()
    }
    picker.setOnDismissListener {
//        Toast.makeText(context, "Action Sheet Dismiss", Toast.LENGTH_SHORT).show()
    }
}