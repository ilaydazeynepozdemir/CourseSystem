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
public class MyException extends Exception {

    private String nameOfException;

    /**
     * Constructor
     *
     * @param nameOfExc hatanin adi
     */
    public MyException(String nameOfExc) {
        super(nameOfExc);
        setNameOfException(nameOfExc);
    }

    /**
     * hata adini set eder
     *
     * @param name hata adi
     */
    private void setNameOfException(String name) {
        nameOfException = name;
    }

    /**
     * hata adini get eder
     *
     * @return string
     */
    public String getNameOfException() {
        return nameOfException;
    }

    /**
     * hatalarin esitligini kontrol eder
     *
     * @param thisException karsilastirilacak hata
     * @return boolean doner
     */
    @Override
    public boolean equals(Object thisException) {
        if (thisException == null) {
            return false;
        }
        if (thisException == this) {
            return true;
        }
        if (!(thisException instanceof MyException)) {
            return false;
        }
        MyException other = (MyException) thisException;
        return other.getNameOfException().equals(this.getNameOfException());
    }

    /**
     * ekrana bastirmada kolaylik saglar
     *
     * @return string
     */
    @Override
    public String toString() {
        return getNameOfException();
    }

}
