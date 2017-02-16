package Dao.mapping;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by cangou on 28/11/16.
 */
public class UserEntity {
    @Id
    @Column(name="pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk;
    private String logine;
    private Date date;


public UserEntity(){

    //this.logine=logine;
  //  this.date=date;

}

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getLogine() {
        return logine;
    }

    public void setLogine(String logine) {
        this.logine = logine;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (pk != that.pk) return false;
        if (logine != null ? !logine.equals(that.logine) : that.logine != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }


    public int hashCode() {
        int result = pk;
        result = 31 * result + (logine != null ? logine.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
