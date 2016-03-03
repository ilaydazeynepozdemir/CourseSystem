/*
 * icinde late deadline icerir
 */
package hw01_131044022;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Deadline,odevlerin son yukleme tarihlerini icerir(deadline,lateDeadline)
 *
 * @author ilayda
 */
public class Deadline {

    private Calendar deadline;
    private Calendar lateDeadline;
    private boolean sign_lateDeadline;
    private boolean sign_PassDeadlines;

    /**
     * constructor
     *
     * @param addedDay suana eklenecek gun
     */
    public Deadline(int addedDay) {
        deadline = new GregorianCalendar();
        lateDeadline = new GregorianCalendar();
        setDeadline(addedDay);
        setLateDeadline(addedDay);
    }

    /**
     * passDeadline'i set eder
     *
     * @param sign bununla doldurulacak
     */
    public void setSign_PassDeadlines(boolean sign) {
        this.sign_PassDeadlines = sign;
    }

    /**
     * lateDeadline'i set eder
     *
     * @param sign bununla dolduracak
     */
    public void setSign_lateDeadline(boolean sign) {
        this.sign_lateDeadline = sign;
    }

    /**
     * Deadline'in gecip gecmedigini verir
     *
     * @return true false doner
     */
    public boolean getSign_PassDeadlines() {
        return sign_PassDeadlines;
    }

    /**
     * LateDeadline'in gecip gecmedigini verir
     *
     * @return true false doner
     */
    public boolean getSign_lateDeadline() {
        return sign_lateDeadline;
    }

    /**
     * deadline'i set eder verilen yeni gunu ekler
     *
     * @param givenDay_forAssignment assignment icin verilen gun
     */
    public void setDeadline(int givenDay_forAssignment) {
        deadline = Calendar.getInstance();
        deadline.add(Calendar.DATE, givenDay_forAssignment);
    }

    /**
     * latedeadline'i set eder verilen yeni gunu ekler
     *
     * @param givenDay_forAssignment assignment icin verilen gun
     */
    public void setLateDeadline(int givenDay_forAssignment) {
        lateDeadline = Calendar.getInstance();
        lateDeadline.add(Calendar.DATE, givenDay_forAssignment + 1);
    }

    /**
     * deadline'in string halini return eder
     *
     * @return String
     */
    public String getDeadline_string() {
        return (deadline.getTime().toString());
    }

    /**
     * latedeadline'in string halini return eder
     *
     * @return string
     */
    public String getLateDeadline_string() {
        return (lateDeadline.getTime().toString());
    }

    /**
     * deadline'i set eder
     *
     * @param deadline deadline'i alir
     */
    public void setDeadline(Calendar deadline) {
        this.deadline = deadline;
    }

    /**
     * lateDeadline'i set eder
     *
     * @param lateDeadline lateDeadline'i alir
     */
    public void setLateDeadline(Calendar lateDeadline) {
        this.lateDeadline = lateDeadline;
    }

    /**
     * deadline'i get eder
     *
     * @return Calender
     */
    public Calendar getDeadline() {
        return deadline;
    }

    /**
     * lateDeadline'i get eder
     *
     * @return Calender
     */
    public Calendar getLateDeadline() {
        return lateDeadline;
    }



    /**
     * deadline'i ekrana bastirmaya kolaylik saglar
     *
     * @return string
     */
    @Override
    public String toString() {
        return ("Deadline=" + getDeadline_string() + "\n" + " LateDeadline=" + getLateDeadline_string());
    }

}
