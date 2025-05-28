package screens

import models.Note
import utils.MenuUtils

class NoteView(
    private val note: Note,
    private val menuUtils: MenuUtils
) {
    fun show() {
        while (true) {
            println("\nЗаметка: ${note.name}")
            println(note.text)
            println("\n0. Назад")

            val input = menuUtils.readNonEmptyLine("Выберите пункт: ")

            if (input == "0") {
                return
            } else {
                println("Ошибка: введите цифру 0, чтобы вернуться назад.")
            }
        }
    }
}