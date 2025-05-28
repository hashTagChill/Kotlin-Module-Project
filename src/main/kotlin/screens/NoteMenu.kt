package screens

import  models.Archive
import models.Note
import utils.MenuUtils

class NoteMenu(
    private val archive: Archive,
    private val menuUtils: MenuUtils
) {
    fun show() {
        while (true) {
            val items = mutableListOf<MenuUtils.MenuItem>()

            items.add(MenuUtils.MenuItem("Создать заметку") {
                createNote()
            })

            archive.notes.forEachIndexed { index, note ->
                items.add(MenuUtils.MenuItem(note.name) {
                    NoteView(note, menuUtils).show()
                })
            }

            items.add(MenuUtils.MenuItem("Назад") {
                throw ExitMenuException()
            })

            try {
                menuUtils.showMenu("Архив: ${archive.name}", items)
            } catch (e: ExitMenuException) {
                break
            }
        }
    }

    private fun createNote() {
        val name = menuUtils.readNonEmptyLine("Введите имя заметки: ")
        val text = menuUtils.readNonEmptyLine("Введите текст заметки: ")
        archive.notes.add(Note(name, text))
        println("Заметка \"$name\" добавлена.")
    }

    private class ExitMenuException : RuntimeException()
}