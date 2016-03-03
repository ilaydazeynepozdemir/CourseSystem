/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

import java.util.ArrayList;

/**
 *
 * @author ilayda
 */
public class CourseSystem {

    private Administrator admin;
    public ArrayList<User> Users;

    /**
     *no parameter constructor
     */
    public CourseSystem() {
        Users = new ArrayList<>();
    }

    /**
     *constructor
     * @param given kursa eklenecek admin
     */
    public CourseSystem(Administrator given) {
        setAdmin(admin);
        Users = new ArrayList<>();
    }

    /**
     *admini verir
     * @return Administrator 
     */
    public Administrator getAdmin() {
        return admin;
    }

    /**
     *verilen administratorle admin memberi set edilir
     * @param Givenadmin set edilecek admin
     */
    public void setAdmin(Administrator Givenadmin) {
        this.admin = Givenadmin;
    }

    /**
     *sistemlerin esitligine bakar
     * @param thisSystem karsilastirilacak sistem
     * @return boolean doner
     */
    @Override
    public boolean equals(Object thisSystem) {
        if (thisSystem == null) {
            return false;
        }
        if (thisSystem == this) {
            return true;
        }
        if (!(thisSystem instanceof MyException)) {
            return false;
        }
        CourseSystem other = (CourseSystem) thisSystem;
        return other.getAdmin().equals(this.getAdmin());
    }

}
