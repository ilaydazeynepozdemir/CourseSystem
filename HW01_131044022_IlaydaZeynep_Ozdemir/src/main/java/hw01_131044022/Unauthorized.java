/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

/**
 *
 * @author ilayda
 */
public abstract class Unauthorized extends User {

    /**
     * no parameter constructor
     */
    public Unauthorized() {
        super();
    }

    /**
     * constructor
     *
     * @param takenUsername yetkisiz kullanicinin adi
     */
    public Unauthorized(String takenUsername) {
        super(takenUsername);
    }

    /**
     * yetkisizler derse kayit edilmek isterler ogretmenler tarafindan
     * eklenir/eklenmez
     *
     * @param enrolThisCourse kayit olmak istenilen ders
     * @return eklenirse true eklenemezse false
     */
    abstract public boolean enrolMe_InCourse(Course enrolThisCourse);

}
