/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

import java.util.ArrayList;

/**
 *Yetkililer abstract sinifi
 * @author ilayda
 */
public abstract class Authorized extends User {

    /**
     * eski kurslari tutan arraylist
     */
    private final ArrayList<Course> olderCourse = new ArrayList<>();

    /**
     *no parameter construtor
     */
    public Authorized() {//hata firlatabilirsin, isimsiz sifresiz
        super();
    }

    /**
     *construtor
     * @param takenUsername verilen isim
     */
    public Authorized(String takenUsername) {
        super(takenUsername);
    }

    /**
     *Kullanici ekleme fonksiyonu
     * @param added eklenen kullanici
     * @param addedFromHere eklenecek yer
     * @return boolean doner
     */
    abstract public boolean addUser(User added, Object addedFromHere);

    /**
     *Kullanici silme fonksiyonu
     * @param deleted silinen kullanici
     * @param deletedFromHere silinecek yer
     * @return boolean doner
     */
    abstract public boolean RemoveUser(User deleted, Object deletedFromHere);

    /**
     *verilen yeri kontrol eder
     * @param controlThis kontrol edilecek yer
     */
    abstract public void controlled(Object controlThis);
    /**
     * verilen yerdeki kullanicilari listeler
     * @param InThis buradakileri
     */
    abstract public void listOfUser(Object InThis);

}
