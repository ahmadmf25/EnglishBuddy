package com.dicoding.englishbuddy.utils

import android.widget.EditText

object ValidateType{
    const val REQUIRED = 0
    const val MIN_CHAR = 1
    const val MAX_CHAR = 2
    const val EMAIL = 3
}

fun EditText.validate(
    name: String = "field",
    validateType: Int,
    num: Int = 0,
    msg: String? = null
): Boolean {
    val text = this.text.toString().trim()
    when (validateType) {
        ValidateType.MIN_CHAR -> {
            if (text.isEmpty() ) {
                var errorMessage = msg
                if (errorMessage == null){
                    errorMessage =
                        context.getString(com.dicoding.englishbuddy.R.string.err_msg_required)
                }
                this.error = errorMessage
                return false
            }
        }
        ValidateType.MIN_CHAR -> {
            if (text.length < num ) {
                var errorMessage = msg
                if (errorMessage == null){
                    errorMessage =
                        context.getString(com.dicoding.englishbuddy.R.string.err_msg_min_char, num)
                }
                this.error = errorMessage
                return false
            }
        }
        ValidateType.MAX_CHAR -> {
            if (text.length > num) {
                var errorMessage = msg
                if (errorMessage == null){
                    errorMessage =
                        context.getString(com.dicoding.englishbuddy.R.string.err_msg_min_char, num)
                }
                this.error = errorMessage
                return false
            }
        }

        ValidateType.EMAIL -> {
            if (!text.contains("@")) {
                var errorMessage = msg
                if (errorMessage == null) {
                    errorMessage =
                        context.getString(com.dicoding.englishbuddy.R.string.err_msg_email)
                }
                this.error = errorMessage
                return false
            }
        }
    }
    return true
}