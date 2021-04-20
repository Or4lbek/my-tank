


class Position
{
    private int x;
    private int y;

    Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void setX(int new_x)
    {
        this.x = new_x;
    }

    public void setY(int new_y)
    {
        this.y = new_y;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public String toString(){//toString вывести х и у
        return "(" + String.valueOf(getX() + "," + getY()) + ")";
    }

    public  boolean equals(Position another_position)
    {
        if (this.x == another_position.getX() && this.y == another_position.getY())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
