public class Player {
    String playerId;
    int currPosition;

    public Player(String id, int currPosition){
        this.playerId = id;
        this.currPosition = currPosition;
    }
    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getCurrPosition() {
        return currPosition;
    }

    public void setCurrPosition(int currPosition) {
        this.currPosition = currPosition;
    }
}
