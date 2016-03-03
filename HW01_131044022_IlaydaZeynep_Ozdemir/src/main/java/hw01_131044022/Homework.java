/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

import java.util.Date;

/**
 * Tum methodlarini assignment abstract classindan alir
 * @author ilayda
 */
public class Homework extends Assignment {

    /**
     *no parameter constructor
     */
    public Homework() {
        super();
    }

    /**
     *constructor
     * @param name odevin adi
     * @param doc odevin document 
     */
    public Homework(String name, Document doc) {//odev süresi default olarak bir hafta olsun
        super(name, doc);
    }

    /**
     *constructor
     * @param name odevin adi
     * @param doc odevin document 
     * @param give_assignmentTime odev icin verilen sure
     */
    public Homework(String name, Document doc, int give_assignmentTime) {
        super(name, doc, give_assignmentTime);
    }

    /**
     *constructor
     * @param name odevin adi
     * @param doc odevin document 
     * @param given verilen deadline
     */
    public Homework(String name, Document doc, Deadline given) {
        super(name, doc, given);
    }

}
