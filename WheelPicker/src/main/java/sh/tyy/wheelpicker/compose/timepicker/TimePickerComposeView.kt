package sh.tyy.wheelpicker.compose.timepicker

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import sh.tyy.wheelpicker.core.BaseWheelPickerView
import sh.tyy.wheelpicker.core.TextWheelAdapter
import sh.tyy.wheelpicker.core.TextWheelPickerView
import sh.tyy.wheelpicker.databinding.TimePickerComposeViewBinding
import sh.tyy.wheelpicker.databinding.TriplePickerComposeViewBinding
import java.text.SimpleDateFormat
import java.util.*

class TimePickerComposeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), BaseWheelPickerView.WheelPickerViewListener {

    interface Listener {
        fun didSelectData(minute: Int, hour: Int)
    }

    @SuppressLint("SimpleDateFormat")
    val sdf = SimpleDateFormat("yyyy")
    private val currentDate = sdf.format(Date()).toInt()
    private val yearRange = 1960 until currentDate+1

    private val minutePickerView: TextWheelPickerView
    private val hourPickerView: TextWheelPickerView

    private var listener: Listener? = null

    fun setWheelListener(listener: Listener) {
        this.listener = listener
    }

    private var yearsList: List<Int> = yearRange.toList()

    var minutes: Int
        set(value) {
            minutePickerView.selectedIndex = value - 1
        }
        get() = minutePickerView.selectedIndex + 1

    var hours: Int
        set(value) {
            hourPickerView.selectedIndex = value - 1
        }
        get() = hourPickerView.selectedIndex + 1

    var isCircular: Boolean = false
        set(value) {
            field = value
            minutePickerView.isCircular = value
            hourPickerView.isCircular = value
            minutePickerView.isCircular = value
        }

    private val dayAdapter = TextTimeWheelAdapter()
    private val monthAdapter = TextTimeWheelAdapter()

    private val binding: TimePickerComposeViewBinding =
        TimePickerComposeViewBinding.inflate(LayoutInflater.from(context), this)

    override fun setHapticFeedbackEnabled(hapticFeedbackEnabled: Boolean) {
        super.setHapticFeedbackEnabled(hapticFeedbackEnabled)
        minutePickerView.isHapticFeedbackEnabled = hapticFeedbackEnabled
        hourPickerView.isHapticFeedbackEnabled = hapticFeedbackEnabled
    }

    init {
        minutePickerView = binding.leftPicker
        minutePickerView.setAdapter(dayAdapter)
        dayAdapter.values = (0..59).map {
            TextTimePickerView.Item(
                "$it",
                "$it".padStart(2, '0')
            )
        }
        hourPickerView = binding.rightPicker
        hourPickerView.setAdapter(monthAdapter)
        monthAdapter.values = (0..59).map {
            TextTimePickerView.Item(
                "$it",
                "$it".padStart(2, '0')
            )
        }

        minutePickerView.setWheelListener(this)
        hourPickerView.setWheelListener(this)
    }

    // region BaseWheelPickerView.WheelPickerViewListener
    override fun didSelectItem(picker: BaseWheelPickerView, index: Int) {
        listener?.didSelectData(minutes, hours)
    }
    // endregion
}