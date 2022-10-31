package lab3.functionality;

public abstract class Quest {
    protected final Designer designer;
    protected final Player player;

    public Quest(Designer designer, Player player) {
        this.designer = designer;
        this.player = player;
    }

    public void start() {
        while (!player.isCompletedQuest()) {
            designer.interactionSession();
            checkPlayer();
        }
    }

    private void end(String reason) {
        designer.endMessage(reason);
        player.setCompletedQuest(true);
    }

    private void checkPlayer() {
        if (player.getHealth() == Health.DEAD) {
            end(String.format("%s умер!", player.getName()));
        } else if (player.isCompletedQuest()){
            end("Поздравляем с завершением квеста");
        }
    }
}
