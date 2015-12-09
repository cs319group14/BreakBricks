/**
 * Created by Kaan on 27/10/15.
 */

public class PowerUp {

    int id;
    int remainingTime;
    String name;
    String names[] = {"FIREBALL"};

    public PowerUp(int id)
    {
        this.id = id;
        if (id < names.length)
            name = names[id];
        else
            name = "None";
    }

    public int getId()
    {
        return id;
    }
    public int getRemainingTime() { return remainingTime; }
    public String getName() { return name; }
}
