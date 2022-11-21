package sh.tyy.wheelpicker.compose.datepicker

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.Window
import androidx.compose.ui.graphics.Color
import sh.tyy.wheelpicker.R
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("InflateParams", "SimpleDateFormat")
fun datePickerComposeAction(
    value: String,
    context: Context,
    window: Window,
    title: String,
    titleCenter: Boolean = false,
    color: Color = Color(0xFF1D4ED8),
    date: (date: String) -> Unit
) {
    lateinit var dayTimePickerView: DatePickerComposeView

    val valueArray = value.split("-").toTypedArray()

    val picker = DatePickerCompose(
        context = context,
        title = title,
        color = color,
        titleCenter = titleCenter
    )

    val view = LayoutInflater.from(context).inflate(R.layout.wheel_picker, null, false)
    dayTimePickerView = view.findViewById(R.id.custom_picker_views)
    picker.show(window)

    if (value.isNotBlank()) {
        picker.pickerView?.day = valueArray[0].toInt()
        picker.pickerView?.months = valueArray[1].toInt()
        picker.pickerView?.year = valueArray[2].toInt()
    } else {
        val sdf = SimpleDateFormat("dd-MM-yyyy")
        val currentDate = sdf.format(Date())
        val currentDateArray = currentDate.split("-").toTypedArray()

        picker.pickerView?.day = currentDateArray[0].toInt()
        picker.pickerView?.months = currentDateArray[1].toInt()
        picker.pickerView?.year = currentDateArray[2].toInt()
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