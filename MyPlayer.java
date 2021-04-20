class MyPlayer implements Player
{
    private Map map;
    private Position position = new Position(-1,-1);// by default

    MyPlayer(){}

    @Override
    public void moveRight()
    {
        if (getPosition().getX()+1 > map.getSize()-1 || String.valueOf(map.getValue(getPosition().getY(),getPosition().getX()+1)).equals("1"))
        {
            return;
        }
        else
        {
            map.setValueatPosition(getPosition().getY(),getPosition().getX(), '0');
            map.setValueatPosition(getPosition().getY(),getPosition().getX()+1, 'P');
        }
    }

    @Override
    public void moveLeft()
    {
        if (getPosition().getX() - 1 < 0 || String.valueOf(map.getValue(getPosition().getY(),getPosition().getX()-1)).equals("1"))
        {
            return;
        }
        else
        {
            map.setValueatPosition(getPosition().getY(),getPosition().getX(), '0');
            map.setValueatPosition(getPosition().getY(),getPosition().getX()-1, 'P');
        }
    }

    @Override
    public void moveUp()
    {
        if (getPosition().getY() - 1 < 0 || String.valueOf(map.getValue(getPosition().getY() - 1,getPosition().getX())).equals("1"))
        {
            return;
        }
        else
        {
            map.setValueatPosition(getPosition().getY(),getPosition().getX(), '0');
            map.setValueatPosition(getPosition().getY() - 1,getPosition().getX(), 'P');
        }
    }

    @Override
    public void moveDown()
    {
        if (getPosition().getY()+1 > map.getSize()-1 || String.valueOf(map.getValue(getPosition().getY()+1,getPosition().getX())).equals("1"))
        {
            return;
        }
        else
        {
            map.setValueatPosition(getPosition().getY(),getPosition().getX(), '0');
            map.setValueatPosition(getPosition().getY() + 1,getPosition().getX(), 'P');
        }
    }


    public Position getPosition()
    {
        int z = 0;
        while(z < map.getSize())
        {
            int s = 0;
            while(s < map.getSize())
            {
                switch(String.valueOf(map.getValue(z, s)))
                {
                    case "P":
                        position.setY(z);
                        position.setX(s);
                        break;
                } s++;
            } z++;
        }
        return position;
    }
    

    @Override
    public void setMap(Map map)
    {
        this.map = map;
    }
}
