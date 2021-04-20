class Game
{
    private Map map;
    private Player player;

    public Game(Map map)
    {
        setMap(map);
    }

    public void setMap(Map map)
    {
        this.map = map;
    }

    public void addPlayer(Player player)
    {
        this.player = player;
        this.player.setMap(map);
    }
}