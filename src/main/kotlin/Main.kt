import models.Archive
import screens.ArchiveMenu
import utils.MenuUtils

fun main() {
    val archives = mutableListOf<Archive>()
    val menuUtils = MenuUtils()

    var isRunning = true

    val archiveMenu = ArchiveMenu(archives, menuUtils) {
        isRunning = false
    }

    while (isRunning) {
        archiveMenu.show()
    }

    println("Выход из программы. До свидания!")
}