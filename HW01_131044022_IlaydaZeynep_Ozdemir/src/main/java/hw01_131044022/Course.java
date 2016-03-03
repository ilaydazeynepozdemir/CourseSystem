/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

import java.util.ArrayList;

/**
 * Course Classi
 *
 * @author ilayda
 */
public class Course implements InterfaceCourse {

    private String CourseName;
    protected Teacher teacherOfcourse;//bir kursu bir hoca yonetebilir
    private boolean wishForExit;//eger ogretmen kurstan cikmak isterse true yapar ogretmen de cikarir
    private ArrayList<Tutor> TutorsOfCourse;
    private ArrayList<Assignment> assignmentsOfCourse_givenTeacher;//hocanin verdigi odevler
    public ArrayList<Document> DocumentsOfCourse;//hoca olusturur digerlerinde bos olusur

    public ArrayList<User> usersOfCourse;

    public ArrayList< ArrayList<Assignment>> AssignmentsAllStudents;//ogrencilerin yil icinde yolladigi assignment arraylarini tutan array

    int numberOfStudents = 0;

    /**
     * constructor
     */
    public Course() {
        CourseName = "isimsizDers";//set hata firlatiyor diye
        usersOfCourse = new ArrayList<>();
        assignmentsOfCourse_givenTeacher = new ArrayList<>();
        AssignmentsAllStudents = new ArrayList<>();
        TutorsOfCourse = new ArrayList<>();
        DocumentsOfCourse = new ArrayList<>();
    }

    /**
     * constuctor
     *
     * @param taken_name verilen ders adi
     */
    public Course(String taken_name) {
        CourseName = taken_name;
        usersOfCourse = new ArrayList<>();
        assignmentsOfCourse_givenTeacher = new ArrayList<>();
        AssignmentsAllStudents = new ArrayList<>();//kurs olusturuldugunda bos ogrenci gelince ekleme yapilacak
        TutorsOfCourse = new ArrayList<>();
        setTeacherOfcourse(null);
        DocumentsOfCourse = new ArrayList<>();
    }

    /**
     * constuctor
     *
     * @param taken_name verilen isim
     * @param teacher_InCourse verilen ders
     */
    public Course(String taken_name, Teacher teacher_InCourse) {
        CourseName = taken_name;
        usersOfCourse = new ArrayList<>();
        assignmentsOfCourse_givenTeacher = new ArrayList<>();
        AssignmentsAllStudents = new ArrayList<>();//kurs olusturuldugunda bos ogrenci gelince ekleme yapilacak
        TutorsOfCourse = new ArrayList<>();
        setTeacherOfcourse(teacher_InCourse);
        DocumentsOfCourse = new ArrayList<>();
    }

    /**
     * dersin documentini return eder
     *
     * @param index arraylist icin
     * @return istenilen documenti return eder
     */
    public Document getDocumentsOfCourse(int index) {//kurs yetkisi olmayanlar da alsin diye
        return DocumentsOfCourse.get(index);
    }

    /**
     * ders icindeki document arrayi return edilir
     *
     * @return arraylisti return eder
     */
    public ArrayList<Document> getDocumentsOfCourse() {
        return DocumentsOfCourse;
    }

    /**
     * kursun ogretmenini set eder
     *
     * @param givenTeacher set edilmesi icin verilen ogretmen
     */
    @Override
    public void setTeacherOfcourse(Teacher givenTeacher) {
        this.teacherOfcourse = givenTeacher;
    }

    /**
     * ders adini set eder
     *
     * @param TakenName set edilmesi icin verilen isim
     */
    @Override
    public void setCourseName(String TakenName) {
        CourseName = TakenName;
    }

    /**
     * derse kullanici ekler
     *
     * @param addedUser eklenecek kullanici
     */
    @Override
    public void addUsersOfCourse(User addedUser) {
        usersOfCourse.add(addedUser);
        // addedUser.
    }

    /**
     * ogretmen odevi yenilemek isterse bu fonksiyonu kullanir verilen
     * parametredeki assignmenti set eder
     *
     * @param givenTeacher
     * @param numOfAssignment
     */
    public void setAssignmentsOfCourse_givenTeacher(Assignment givenTeacher, int numOfAssignment) {
        assignmentsOfCourse_givenTeacher.add(numOfAssignment, givenTeacher);
    }
    /**
     * ogretmenlerin yukledikleri odev size'ini dondurur
     * @return integer size
     */
     public int getSizeAssignmentsOfCourse_givenTeacher() {
       return assignmentsOfCourse_givenTeacher.size();
    }

    /**
     * dersteki ogrenci sayilarini bir arttirir
     */
    public void increaseNumberOfStudents() {
        this.numberOfStudents = (++this.numberOfStudents);
    }

    /**
     * ogretmenin verdigi odevleri ekler
     *
     * @param givenTeacher verilen odev
     */
    public void addAssignmentsOfCourse_givenTeacher(Assignment givenTeacher) {
        assignmentsOfCourse_givenTeacher.add(givenTeacher);
    }

    /**
     * istenilen numaradaki odevi return eder
     *
     * @param numOfAssignment odevin numarasi
     * @return /assignment return eder
     */
    public Assignment getAssignmentsOfCourse_givenTeacher(int numOfAssignment) {
        return assignmentsOfCourse_givenTeacher.get(numOfAssignment);
    }

    /**
     * ders icindeki tutor arrayini return eder
     *
     * @return arraylist return eder
     */
    public ArrayList<Tutor> getTutorsOfCourse() {
        return TutorsOfCourse;
    }

    /**
     * tutor eklenmek istediginde arraye ekleme yapar
     *
     * @param added eklenecek tutor
     */
    public void addTutorsOfCourse(Tutor added) {
        TutorsOfCourse.add(added);
    }

    /**
     * ogretmeni get eder
     *
     * @return ogretmen return eder
     */
    public Teacher getTeacherOfcourse() {
        return teacherOfcourse;
    }

    /**
     * ogrenci sayisini return eder
     *
     * @return integer return eder
     */
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    /**
     * dersteki kullanici arrayini verir
     *
     * @return arraylist return eder
     */
    public ArrayList<User> getUsersOfCourse() {
        return usersOfCourse;
    }

    /**
     * ders adini get eder
     *
     * @return string return eder
     */
    public String getCourseName() {
        return CourseName;
    }

    /**
     * dersteki verilen indexteki kullaniciyi return eder
     *
     * @param index bu indexteki kullanici isteniyor
     * @return kullanici return eder
     */
    public User get_userOfCourse(int index) {
        return usersOfCourse.get(index);
    }

    /**
     * dersteki kullanici sayisini return eder
     *
     * @return integer return eder
     */
    public int getSize_usersOfCourse() {
        return usersOfCourse.size();
    }

    /**
     * private usersOfCourse arraylistinin RemoveUser fonksiyonu icin
     *
     * @param deleted silinecek kullanici
     */
    public void removedUser(User deleted) {
        usersOfCourse.remove(deleted);
        //return deleted;
    }

    /**
     * son eklenen kullaniciyi verir
     *
     * @return User return eder
     */
    public User lastAddedUser() {
        return usersOfCourse.get(usersOfCourse.size() - 1);
    }

    /**
     * kurstaki kullanicilari listeler
     */
    public void listOfUsers_InCourse() {
        System.out.printf("%s dersine kayitli kullanicilar\n", this.getCourseName());
        for (int i = 0; i < usersOfCourse.size(); ++i) {
            System.out.printf("%d-%s\n", i, usersOfCourse.get(i));
        }
    }

    /**
     * dersteki assignmentlari listeler
     */
    public void listOfAssignments_InCourse() {//ogretmenin verdiklerini listeler
        System.out.printf("%s gorevleri \n", this.getCourseName());
        for (int i = 0; i < assignmentsOfCourse_givenTeacher.size(); ++i) {
            System.out.printf("%d-%s\n", i, assignmentsOfCourse_givenTeacher.get(i));
        }
    }

    /**
     * dersin string olarak bastirilmasini kolaylastirir
     *
     * @return string
     */
    @Override
    public String toString() {
        return getCourseName();
    }

    /**
     * esitligini kontrol eder
     *
     * @param given karsilastirilan
     * @return esitse true degilse false
     */
    @Override
    public boolean equals(Object given) {
        if (given == null) {
            return false;
        }
        if (given == this) {
            return true;
        }
        if (!(given instanceof Course)) {
            return false;
        }
        Course other = (Course) given;

        if (this.getCourseName().equals(other.getCourseName())) {
            return (other.getTeacherOfcourse() == null ? getTeacherOfcourse() == null
                    : other.getTeacherOfcourse().equals(getTeacherOfcourse()));
        } else {
            return false;
        }
    }

    /**
     * ogretmenin ders ogretmenliginden cikis istegini set eder
     *
     * @param wish istege eklenecek sey
     */
    @Override
    public void setWishForExit(boolean wish) {
        wishForExit = wish;
    }

    /**
     * ogretmenin cikis istegini get eder
     *
     * @return true ya da false
     */
    public boolean getWishForExit_teacher() {
        return wishForExit;
    }

}
