package com.dicoding.englishbuddy.ui.custom_view

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import com.dicoding.englishbuddy.R
import com.google.android.material.textfield.TextInputEditText

class PasswordEditText : TextInputEditText {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {

        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // do nothing
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().isNotEmpty() && s.toString().length < 8) {
                    error = context.getString(R.string.err_msg_min_char, 8)
                }
            }

            override fun afterTextChanged(s: Editable) {
                // do nothing
            }
        })
    }
}