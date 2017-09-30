public interface Boardgame {
    public void move(int x, int y);
    public String getStatus(int x, int y);
    public String getMessage();
}
