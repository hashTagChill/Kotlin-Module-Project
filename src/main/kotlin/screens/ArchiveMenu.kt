package screens

import models.Archive
import utils.MenuUtils

class ArchiveMenu(
    private val archives: MutableList<Archive>,
    private val menuUtils: MenuUtils,
    private val onExit: () -> Unit
) {
    fun show() {
        while (true) {
            val items = mutableListOf<MenuUtils.MenuItem>()

            items.add(MenuUtils.MenuItem("Создать архив\n") {
                createArchive()
            })

            archives.forEach { archive ->
                items.add(MenuUtils.MenuItem(archive.name) {
                    NoteMenu(archive, menuUtils).show()
                })
            }


            var exitSelected = false
            items.add(MenuUtils.MenuItem("Выход из программы\n") {
                onExit()
                exitSelected = true
            })

            menuUtils.showMenu("Список архивов:", items)

            if (exitSelected) break
        }
    }

    private fun createArchive() {
        val name = menuUtils.readNonEmptyLine("Введите имя архива: ")
        archives.add(Archive(name))
        println("Архив \"$name\" создан.")
    }
}