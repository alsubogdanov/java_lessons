public class Team {
    private String teamName;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    class Player{
        private String playerName;

        public Player(String playerName) {
            this.playerName = playerName;
        }

        public void printInfo(){
            System.out.println("Player "+ playerName +" plays for "+ teamName);
        }
    }
}
