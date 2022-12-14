package id.med.helpets.ui.login.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import id.med.helpets.R

class EditTextPassword : AppCompatEditText {
    private lateinit var backgroundEditText: Drawable

    constructor(context: Context) : super(context){
        init()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
        init()
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        init()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        hint = ""
    }

    private fun init(){
        maxLines = 1
        backgroundEditText = ContextCompat.getDrawable(context, R.drawable.layout_shape) as Drawable
        addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
                transformationMethod = PasswordTransformationMethod.getInstance()
                text?.let { setSelection(it.length) }
                if (s != null){
                    error = when{
                        s.isEmpty() -> {
                            "Password tidak boleh kosong"
                        }
                        s.length < 6 -> {
                            "Password tidak boleh kurang dari 6 !"
                        }
                        else -> {
                            null
                        }
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }
}