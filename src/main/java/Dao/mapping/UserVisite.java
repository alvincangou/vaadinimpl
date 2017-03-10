package Dao.mapping;

import java.sql.Date;

/**
 * Created by cangou on 08/03/17.
 */
public class UserVisite {
    private int count;
    private Date date;

    public UserVisite() {

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
