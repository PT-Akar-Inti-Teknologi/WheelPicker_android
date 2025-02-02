package sh.tyy.wheelpicker.compose.timepicker

import android.content.Context
import android.util.AttributeSet
import android.view.*
import android.widget.TextView
import androidx.core.content.ContextCompat
import sh.tyy.wheelpicker.R
import sh.tyy.wheelpicker.core.BaseWheelPickerView

class TextWheelViewHolder(private val textView: TextView) :
    BaseWheelPickerView.ViewHolder<TextTimePickerView.Item>(textView) {
    override fun onBindData(data: TextTimePickerView.Item) {
        textView.text = data.text
        textView.isEnabled = data.isEnabled
    }
}

class TextTimeWheelAdapter :
    BaseWheelPickerView.Adapter<TextTimePickerView.Item, TextWheelViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextWheelViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.text_wheel_picker, parent, false) as TextView
        return TextWheelViewHolder(view)
    }
}

class TextTimePickerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseWheelPickerView(context, attrs, defStyleAttr) {
    data class Item(val id: String, val text: CharSequence, val isEnabled: Boolean = true)

    private val highlightView: View = run {
        val view = View(context)
        view.background = ContextCompat.getDrawable(context, R.drawable.text_wheel_highlight_bg)
        view
    }

    var isHighlightingVisible: Boolean
        set(value) {
            highlightView.visibility = if (value) View.VISIBLE else View.INVISIBLE
        }
        get() {
            return highlightView.visibility == View.VISIBLE
        }

    init {
        addView(highlightView)
        (highlightView.layoutParams as? LayoutParams)?.apply {
            width = ViewGroup.LayoutParams.MATCH_PARENT
            height =
                context.resources.getDimensionPixelSize(R.dimen.text_wheel_picker_item_height)
            gravity = Gravity.CENTER_VERTICAL
        }

        attrs?.let {
            context.theme.obtainStyledAttributes(
                it,
                R.styleable.TextWheelPickerView,
                defStyleAttr,
                0
            ).apply {
                for (i in 0 until indexCount) {
                    when (getIndex(i)) {
                        R.styleable.TextWheelPickerView_highlighting_visible -> {
                            isHighlightingVisible = getBoolean(
                                R.styleable.TextWheelPickerView_highlighting_visible,
                                true
                            )
                        }
                    }
                }
            }
        }
    }
}
