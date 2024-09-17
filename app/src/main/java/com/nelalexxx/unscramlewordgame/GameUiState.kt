package com.nelalexxx.unscramlewordgame

import android.view.animation.AnimationUtils
import com.nelalexxx.unscramlewordgame.views.button.UpdateButton
import com.nelalexxx.unscramlewordgame.views.editText.CustomEditText
import com.nelalexxx.unscramlewordgame.views.editText.UpdateLayout
import com.nelalexxx.unscramlewordgame.views.word.UpdateText
import java.io.Serializable

// интерфейс для выбора реализации обновления экрана приложения
interface GameUiState : Serializable {

    // основная функция обновления состояний экрана
    fun update(
        wordTextView: UpdateText,
        editText: CustomEditText,
        inputFieldLayout: UpdateLayout,
        checkButton: UpdateButton,
        nextButton: UpdateButton,
    )

    // наша функция update может реализовывать обновление всех элементов экрана, но нам этого
    // нужно не всегда, поэтому мы создаем обьекты которые в зависимости от состояния экрана
    // реализуют update() по своему, чтобы изменить нужны элементы интерфейса

    object Empty : GameUiState {
        override fun update(
            wordTextView: UpdateText,
            editText: CustomEditText,
            inputFieldLayout: UpdateLayout,
            checkButton: UpdateButton,
            nextButton: UpdateButton
        ) = Unit
    }

    //    Cостояние 1 - Получено новое слово
//    1. Обновить текст (текст нужно получить из нашей бд, или репозитория
//    2. Очистить текстовое поле и сделать его доступным для ввода
//    3. Убрать видимость кнопки check c ui
//    4. Задать имя кнопке получения нового слова на skip (при правильном ответе next, по умолчанию skip)
    data class ScrambleWordReceived(
        val text: String
    ) : GameUiState {
        override fun update(
            wordTextView: UpdateText,
            editText: CustomEditText,
            inputFieldLayout: UpdateLayout,
            checkButton: UpdateButton,
            nextButton: UpdateButton
        ) {
            wordTextView.update(text)
            editText.update(enabled = true, "")
            inputFieldLayout.update(R.color.white, R.string.hint)
            checkButton.update(visibility = false)
            nextButton.update(text = R.string.skip)

        }

    }

    //    Cостояние 2 - Внесено изменение в поле ввода
//    1. Сделать кнопку check видимой (при пустом поле ввода кнопка check не должна быть видна), для этого
//    я снаружи проверяю что EditText пустой с помощью флага, также флаг помогает мне различать cостояние экрана
//    когда поле ввода заполнили и удалили, чтобы программа понимала, что это не состояние 1
//    2. Сделать поле доступным для ввода и задать базовый цвет
//    3. Установить текст для кнопки перехода на следующее слово "skip"
    data class TextEdited(private val flag: Int = 1) : GameUiState {
        override fun update(
            wordTextView: UpdateText,
            editText: CustomEditText,
            inputFieldLayout: UpdateLayout,
            checkButton: UpdateButton,
            nextButton: UpdateButton
        ) {
            if (flag == -1) {
                checkButton.update(visibility = false)
            } else
                checkButton.update(visibility = true)
            nextButton.update(text = R.string.skip)
            editText.update(enabled = true)
            inputFieldLayout.update(R.color.white, R.string.hint)
        }
    }


    //    Cостояние 3 - Нажата кнопка check - результат слово введено верно
//    1. сделать Текстовое поле недоступным для ввода, задать ему цвет правильного ответа(зеленый)
//    2. Убрать видимость кнопки check c ui
//    3. Задать имя кнопке получения нового слова на next (при правильном ответе next, по умолчанию skip)
    object CorrectWord : GameUiState {
        override fun update(
            wordTextView: UpdateText,
            editText: CustomEditText,
            inputFieldLayout: UpdateLayout,
            checkButton: UpdateButton,
            nextButton: UpdateButton
        ) {
            checkButton.update(visibility = false)
            nextButton.update(R.string.next)
            editText.update(enabled = false)
            inputFieldLayout.update(R.color.Correct, R.string.correct)
        }

    }

    //    Cостояние 4 - Нажата кнопка check - результат слово введено неверно
//    1. сделать Текстовое поле доступным для ввода, задать ему цвет неправильного ответа(красный)
    object InCorrectWord :
        GameUiState {
        override fun update(
            wordTextView: UpdateText,
            editText: CustomEditText,
            inputFieldLayout: UpdateLayout,
            checkButton: UpdateButton,
            nextButton: UpdateButton
        ) {
            checkButton.update(visibility = true)
            editText.update(enabled = true)
            inputFieldLayout.update(R.color.Incorrect, R.string.incorrect)


            val shakeAnimation = AnimationUtils.loadAnimation(editText.context, R.anim.shake)
            editText.startAnimation(shakeAnimation)


        }
    }


}
