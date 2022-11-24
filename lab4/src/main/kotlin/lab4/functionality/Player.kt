package lab4.functionality

class Player(
    name: String,
    var location: Location
) : Actionable(
    name,
    { p -> "Состояние ${p.name}\nЗдоровье: ${p.health.state}" }
) {
    var health: Health = Health.HEALTHY
    var completedQuest: Boolean = false

    fun enterLocation(location: Location){
        this.location = location
        location.enter(this)
    }

    fun damage(){
        health = health.next()
    }

    fun heal() {
        health = health.previous()
    }
}


