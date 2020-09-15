@file:Suppress("unused", "NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS")

package com.mars.toolkit.text


import android.text.InputType.*
import com.mars.toolkit.text.InputType.Class.Number
import com.mars.toolkit.text.InputType.Class.Text

/*
 * author: 凛
 * date: 2020/9/9 下午10:48
 * github: https://github.com/oh-Rin
 * fork: https://github.com/LouisCAD/Splitties/blob/54df2cfdf7d851ffaba05f22efa0b5db9b35469b/modules/views/src/androidMain/kotlin/splitties/views/InputType.kt
 */
inline class InputType<T : InputType.Class> @PublishedApi internal constructor(val value: Int) {
  sealed class Class {
    object DateTime : Class()
    object Number : Class()
    object Phone : Class()
    sealed class Text : Class() {
      companion object : Text()
      object FinalFlag : Text()
    }
  }

  companion object {
    inline val dateTime get() = InputType<Class.DateTime>(TYPE_CLASS_DATETIME or TYPE_DATETIME_VARIATION_NORMAL)
    inline val date get() = InputType<Class.DateTime>(TYPE_CLASS_DATETIME or TYPE_DATETIME_VARIATION_DATE)
    inline val time get() = InputType<Class.DateTime>(TYPE_CLASS_DATETIME or TYPE_DATETIME_VARIATION_TIME)
    inline val number get() = InputType<Number>(TYPE_CLASS_NUMBER or TYPE_NUMBER_VARIATION_NORMAL)
    inline val numberPassword get() = InputType<Number>(TYPE_CLASS_NUMBER or TYPE_NUMBER_VARIATION_PASSWORD)
    inline val phone get() = InputType<Class.Phone>(TYPE_CLASS_PHONE)
    inline val text get() = InputType<Text.Companion>(TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_NORMAL)
    inline val emailAddress get() = InputType<Text.Companion>(TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_EMAIL_ADDRESS)
    inline val emailSubject get() = InputType<Text.Companion>(TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_EMAIL_SUBJECT)
    inline val filter get() = InputType<Text.Companion>(TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_FILTER)
    inline val longMessage get() = InputType<Text.Companion>(TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_LONG_MESSAGE)
    inline val password get() = InputType<Text.Companion>(TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD)
    inline val personName get() = InputType<Text.Companion>(TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PERSON_NAME)
    inline val phonetic get() = InputType<Text.Companion>(TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PHONETIC)
    inline val postalAddress get() = InputType<Text.Companion>(TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_POSTAL_ADDRESS)
    inline val shortMessage get() = InputType<Text.Companion>(TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_SHORT_MESSAGE)
    inline val uri get() = InputType<Text.Companion>(TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_URI)
    inline val visiblePassword get() = InputType<Text.Companion>(TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
    inline val webEditText get() = InputType<Text.Companion>(TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_WEB_EDIT_TEXT)
    inline val webEmailAddress get() = InputType<Text.Companion>(TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS)
    inline val webPassword get() = InputType<Text.Companion>(TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_WEB_PASSWORD)
  }
}

inline val InputType<Number>.signed: InputType<Number>
  get() = InputType(value or TYPE_NUMBER_FLAG_SIGNED)

inline val InputType<Number>.decimal: InputType<Number>
  get() = InputType(value or TYPE_NUMBER_FLAG_DECIMAL)


inline val InputType<Text.Companion>.autoCorrect: InputType<Text.Companion>
  get() = InputType(value or TYPE_TEXT_FLAG_AUTO_CORRECT)

inline val InputType<Text.Companion>.noSuggestions: InputType<Text.Companion>
  get() = InputType(value or TYPE_TEXT_FLAG_NO_SUGGESTIONS)

inline val InputType<Text.Companion>.multiLine: InputType<Text.Companion>
  get() = InputType(value or TYPE_TEXT_FLAG_MULTI_LINE)

inline val InputType<Text.Companion>.multiLineIme: InputType<Text.Companion>
  get() = InputType(value or TYPE_TEXT_FLAG_IME_MULTI_LINE)

inline val InputType<Text.Companion>.autoComplete: InputType<Text.Companion>
  get() = InputType(value or TYPE_TEXT_FLAG_AUTO_COMPLETE)


inline val InputType<Text.Companion>.capCharacters: InputType<Text.FinalFlag>
  get() = InputType(value or TYPE_TEXT_FLAG_CAP_CHARACTERS)

inline val InputType<Text.Companion>.capWords: InputType<Text.FinalFlag>
  get() = InputType(value or TYPE_TEXT_FLAG_CAP_WORDS)

inline val InputType<Text.Companion>.capSentences: InputType<Text.FinalFlag>
  get() = InputType(value or TYPE_TEXT_FLAG_CAP_SENTENCES)