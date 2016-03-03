/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

/**
 * Tum methodlarini assignment abstract classindan alir
 *
 * @author ilayda
 */
public class Quiz extends Assignment {

    /**
     * no parameter constructor
     */
    public Quiz() {
        super();
    }

    /**
     * constructor
     *
     * @param name quiz adi
     * @param doc
     */
    public Quiz(String name, Document doc) {
        super(name, doc);
    }

    /**
     * constructor
     *
     * @param name quiz adi
     * @param doc quiz documenti
     * @param given quiz icin verilen deadline
     */
    public Quiz(String name, Document doc, Deadline given) {
        super(name, doc, given);
    }

    /**
     * constructor
     *
     * @param name quiz adi
     * @param doc quiz documenti
     * @param giveTime quiz icin verilen zaman
     */
    public Quiz(String name, Document doc, int giveTime) {
        super(name, doc, giveTime);
    }

}
