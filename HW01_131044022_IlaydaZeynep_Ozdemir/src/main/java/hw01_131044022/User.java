/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

import java.util.ArrayList;

/**
 *Kullanicilar bu siniftan turer
 * @author ilayda
 */
public abstract class User {

    private String username;
    protected ArrayList<Course> Courses;

    private boolean wishOfUSer;

    /**
     * no parameter constructor
     */
    public User() {
        Courses = new ArrayList<>();
        setUsername("isimsiz");
    }

    /**
     * constructor
     *
     * @param Taken_username kullanici adi
     */
    public User(String Taken_username) {//hata firlatabilirsin, isimsiz sifresiz
        setUsername(Taken_username);
        Courses = new ArrayList<>();
    }

    /**
     * kullanicinin adini verir
     *
     * @return string
     */
    public String getUsername() {
        return username;
    }

    /**
     * kullanici icindeki cikis dilegi set edilir
     *
     * @param wish
     */
    public void setWishOfUser(boolean wish) {
        this.wishOfUSer = wish;
    }

    /**
     * kullanicinin cikis diklegini verir
     *
     * @return cikmak isterse true cikmak istemezse false doner
     */
    public boolean getWishOfUser() {
        return wishOfUSer;
    }

    /**
     * kullanici adini set eder
     *
     * @param TakenUsername alinan kullanici adi
     */
    public void setUsername(String TakenUsername) {
        username = TakenUsername;
    }

    /**
     * kullanicilarin esitligini kontrol eder
     *
     * @param givenUser karsilastirilacak kullanici
     * @return ayniysa true degilse false
     */
    @Override
    public boolean equals(Object givenUser) {

        if (givenUser == null) {
            return false;
        }
        if (givenUser == this) {
            return true;
        }
        if (!(givenUser instanceof User)) {
            return false;
        }
        User other = (User) givenUser;
        return (other.getUsername().equals(this.getUsername()));
    }

    /**
     * kullaniciyi string olarak ekrana bastirmada yarar saglar
     *
     * @return
     */
    @Override
    public String toString() {
        return getUsername();
    }

    /**
     * Eger array icinde belirtilen sey varsa true doner template bir methodtur
     *
     * @param <T> T herhangi bir tip olabilir
     * @param thisThing aranan set budur
     * @param array aranacak array budur
     * @return boolean doner varsa true yoksa false
     */
    public <T> boolean existed(T thisThing, ArrayList<T> array) {

        int sign = 0;

        for (int i = 0; i < array.size(); ++i) {

            if (array.get(i).equals(thisThing)) {
                ++sign;
            }
        }
        if (sign == 0)//kayitli degil false doner
        {
            return false;
        } else {
            return true;
        }

    }

    /**
     * kullanicinin derslerini doldurur
     *
     * @param courseOfUser derslere eklenecek ders
     */
    public void FillCoursesOfUser(Course courseOfUser) {
        Courses.add(courseOfUser);
    }

    /**
     * kullanicinin kurslarini listeler adminse olan tum kurslari,ogretmense
     * yetkili oldugu kurslari,ogrenciyse kaydoldugu kurslari
     *
     */
    public void listOfCourses() {//admin cagirisa bulunna kurslarin hepsi
        if (Courses.size() != 0) {
            System.out.printf("%s kullanicisinin dersleri\n", this.getUsername());
            for (int i = 0; i < this.Courses.size(); ++i) {
                System.out.printf("%d-%s\n", i, Courses.get(i));
            }
        } else {
            System.out.printf("%s kullanicinin dersi yok\n", this.getUsername());
        }
    }

    /**
     * verilen yerden cikis istegini doldurur ders yollanirsa ve ogretmense
     * ogretmen dersten cikarilir sistem yollanir ve adminse komple sistemi
     * siler sistem yollanir ve diger kullanicilarsa sistemden cikarilir-admin
     * tarafindan
     *
     * @param fromHere buradan
     * @return cikarilirsa true cikarilamazsa false
     */
    abstract public boolean RequestToExit(Object fromHere);

    /**
     * sisteme kayit yaptirilir
     *
     * @param toRegister kayit olunacak sistem
     * @return
     */
    public boolean registerSystem(CourseSystem toRegister) {
        try {
            if (toRegister != null && toRegister.getAdmin() != null) {
                if (toRegister.getAdmin().addUser(this, toRegister)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                throw new MyException("Sistem duzgun olusturulamadi");
            }
        } catch (MyException ex) {
            System.out.printf("%s\n", ex.toString());
            return false;
        }

    }

}
