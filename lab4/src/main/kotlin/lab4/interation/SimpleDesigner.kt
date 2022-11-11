package lab4.interation

import lab4.functionality.*

class SimpleDesigner(private val reader: Reader, private val writer: Writer, private val player: Player) : Designer {

    override fun interactionSession() {
        showVariants()
    }

    override fun endMessage(reason: String) {
        writer.writeln(reason)
    }

    private fun showVariants() {
        writer.writeln("Выберите, с чем взаимодействовать:\n1)Посмотреть состояние ${player.name}\n2)Локации\n3)Предметы")
        try {
            when (reader.readInt()) {
                1 -> chooseAction(player)
                2 -> chooseLocation()
                3 -> chooseItem()
                666 -> throw DemonInfiltratingTheSystem()
                else -> writer.writeln("Неверное число")
            }
        } catch (e: IndexOutOfBoundsException) {
            writer.writeln("Неверное число!")
        }
    }

    private fun chooseLocation() {
        writer.writeln("Выберите локацию:\n0)Вернуться\n1)Осмотреть ${player.location.name} (текущая)")
        val locations = player.location.locations
        showNames(locations, 2)
        when (val ind = reader.readInt()) {
            0 -> {}
            1 -> chooseAction(player.location)
            else -> {
                val loc = locations[ind - 2]
                player.location = loc
                writer.writeln(loc.enter(player))
            }
        }
    }

    private fun chooseItem() {
        writer.writeln("Выберите предмет:\n0)Вернуться")
        val items = player.location.items
        showNames(items, 1)
        val ind = reader.readInt()
        if (ind != 0) {
            val item = items[ind - 1]
            chooseAction(item)
            if (item.isConsumable && item.actions.size == 0) {
                items.removeAt(ind - 1)
            }
        }
    }

    private fun chooseAction(obj: Actionable) {
        showDescription(obj)
        writer.writeln("Выберите действие:\n0)Вернуться")
        val actions = obj.actions
        showNames(actions, 1)
        val ind = reader.readInt()
        if (ind != 0) {
            val action = actions[ind - 1]
            showDescription(action)
            actions[ind - 1].use(player, obj)
            if (actions[ind - 1].isDisposable) {
                actions.removeAt(ind - 1)
            }
        }
    }

    private fun showDescription(describable: Nameable) {
        val description = describable.description.getDescription(player)
        if (description.isNotEmpty()) {
            writer.writeln(description)
        }
        writer.writeln("")
    }

    private fun showNames(array: ArrayList<out Nameable>, shift: Int) {
        for (i in array.indices) {
            writer.writeln("${i + shift})${array[i].name}")
        }
    }
}