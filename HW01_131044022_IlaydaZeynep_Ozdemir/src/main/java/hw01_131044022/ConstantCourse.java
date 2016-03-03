/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

import java.util.ArrayList;

/**
 *ConstantCourse,silinen Courselar uzerinde degisiklik yapilmasina izin verilmemesi icin
 * @author ilayda
 */
public class ConstantCourse extends Course implements InterfaceConstantCourse {

    private ArrayList<User> usersOfConstantCourse;
    private Teacher teacherOfConstantCourse;

    /**
     * no parameter constructor
     */
    public ConstantCourse() {
        super(null);

    }

    /**
     * Constructor
     *
     * @param takenName Constant ders icin verilen isim
     * @param takenTeacher Constant ders icin verilen ogretmen
     */
    public ConstantCourse(String takenName, Teacher takenTeacher) {
        super(takenName, takenTeacher);

    }

    /**
     * Constructor dersin ogretmeni kismini set etmek icin
     *
     * @param teacherforCourse dersin ogretmeni
     */
    @Override
    public void setTeacherOfcourse(Teacher teacherforCourse) {
        try {
            throw new MyException("Bu ders artik yok");
        } catch (MyException ex) {
            System.out.printf("%s\n", ex);
        }
    }

    /**
     * Kullanicilar eklenir
     *
     * @param addedUser eklenecek kullanici
     */
    @Override
    public void addUsersOfCourse(User addedUser) {
        try {
            throw new MyException("Bu ders artik yok");
        } catch (MyException ex) {
            System.out.printf("%s\n", ex);
        }
    }

    /**
     * ders adini set eder
     *
     * @param TakenName verilen ders adi
     */
    @Override
    public void setCourseName(String TakenName) {
        try {
            throw new MyException("Bu ders artik yok");
        } catch (MyException ex) {
            System.out.printf("%s\n", ex);
        }
    }

    /**
     * dilek kismini set eder
     *
     * @param wish verilen coolean isaret
     */
    @Override
    public void setWishForExit(boolean wish) {
        try {
            throw new MyException("Bu ders artik yok");
        } catch (MyException ex) {
            System.out.printf("%s\n", ex);
        }
    }

}
