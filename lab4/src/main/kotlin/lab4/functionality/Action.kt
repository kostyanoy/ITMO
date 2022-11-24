package lab4.functionality

class Action(
    name: String,
    description: Description,
    private val usable: Usable,
    val isDisposable: Boolean = false
) : Nameable(name, description) {

    fun use(player: Player, obj: Actionable) = usable.use(player, obj)
}