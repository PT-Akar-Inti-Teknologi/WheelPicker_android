package sh.tyy.wheelpicker

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.Window
import java.util.*

@SuppressLint("InflateParams")
fun datePickerAction(
    context: Context,
    window: Window,
    date: (date: String) -> Unit
) {
    lateinit var dayTimePickerView: DatePickerComposeView

    val picker = DatePickerCompose(context = context)
    val view = LayoutInflater.from(context).inflate(R.layout.wheel_picker, null, false)
    dayTimePickerView = view.findViewById(R.id.custom_picker_views)
    picker.show(window = window)

    picker.pickerView?.day = dayTimePickerView.day
    picker.pickerView?.months = dayTimePickerView.months
    picker.pickerView?.year = dayTimePickerView.year
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