package utils

import java.util.Scanner

class MenuUtils {
    private val scanner = Scanner(System.`in`)

    data class MenuItem(
        val title: String,
        val action: () -> Unit
    )

    fun showMenu(title: String, items: List<MenuItem>) {
        while (true) {
            println("\n$title\n")
            items.forEachIndexed { index, item ->
                println("$index. ${item.title}")
            }
            print("Введите пункт меню: ")

            val input = scanner.nextLine()
            val choice = input.toIntOrNull()

            if (choice == null) {
                println("Ошибка: введите ЦИФРУ.")
                continue
            }

            if (choice < 0 || choice >= items.size) {
                println("Ошибка: такой цифры нет.")
                continue
            }


            items[choice].action.invoke()
            break
        }
    }

    fun readNonEmptyLine(prompt: String): String {
        while (true) {
            print(prompt)
            val input = scanner.nextLine().trim()
            if (input.isNotEmpty()) {
                return input
            } else {
                println("Ошибка: поле не может быть пустым.")
            }
        }
    }
}