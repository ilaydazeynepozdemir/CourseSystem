/*
 *
 */
package hw01_131044022;

/**
 *
 * @author ilayda
 */
public interface InterfaceCourse { //normal dersler ve constant interface dersler bu interfaceden turer

    /**
     * dersin ogretmenini set eder
     *
     * @param teacherforCourse ders icin verilen ogretmen
     */
    public void setTeacherOfcourse(Teacher teacherforCourse);

    /**
     * kursa ders ekleme
     *
     * @param addedUser eklenecek kullanici
     */
    public void addUsersOfCourse(User addedUser);

    /**
     * kurs adini set eder
     *
     * @param TakenName verilen isim
     */
    public void setCourseName(String TakenName);

    /**
     * cikis dilegini set eder
     *
     * @param wish set edilecek dilek
     */
    public void setWishForExit(boolean wish);
}
