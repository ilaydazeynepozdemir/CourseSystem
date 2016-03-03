/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

import java.util.ArrayList;

/**
 *constant course
 * @author ilayda
 */
public interface InterfaceConstantCourse extends InterfaceCourse {

    /**
     *dersin ogretmenini set eder
     * @param teacherforCourse ders icin verilen ogretmen 
     */
    @Override
    public void setTeacherOfcourse(Teacher teacherforCourse);

    /**
     *kursa ders ekleme
     * @param addedUser eklenecek kullanici
     */
    @Override
    public void addUsersOfCourse(User addedUser);

    /**
     *kurs adini set eder
     * @param TakenName verilen isim
     */
    @Override
    public void setCourseName(String TakenName);

    /**
     * cikis dilegini set eder
     *
     * @param wish set edilecek dilek
     */
    @Override
    public void setWishForExit(boolean wish);

}
