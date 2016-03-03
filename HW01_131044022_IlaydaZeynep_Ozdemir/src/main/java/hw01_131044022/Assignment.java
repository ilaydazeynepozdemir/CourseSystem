/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

import java.util.ArrayList;

/**
 * Assignment olusturulurken ogretmenin verdigi document yeri bos olur
 *
 * @author ilayda
 */
abstract public class Assignment {

    private String AssignmentName;
    private Deadline deadlines;
    private int grade;
    Document DocumentOfTeacher;
    ArrayList<Document> DocumentsOfStudents;//tek bir dokumani da olabilir
    private int AssignmentTime;//kac gun sonrasi

    /**
     * no parameter constructor
     */
    public Assignment() {//odev yok
        setAssignmentName("bos");
        DocumentsOfStudents = new ArrayList<>();
        DocumentOfTeacher = null;
        setAssignmentTime(7);
    }

    /**
     *
     * @param nameAssignment assignment adi
     * @param doc assignment icindeki dosya//sonradan ekleme yapilabilir
     */
    public Assignment(String nameAssignment, Document doc) {//odev süresi default olarak bir hafta olsun
        setAssignmentName(nameAssignment);
        setDocumentOfTeacher(doc);
        DocumentOfTeacher = null;
        deadlines = new Deadline(7);
        DocumentsOfStudents = new ArrayList<>();
        DocumentsOfStudents.add(doc);
    }

    /**
     * constructor
     *
     * @param nameAssignment assignment adi
     * @param doc assignment icindeki dosya
     * @param give_assignmentTime odevin yapilmasi icin verilen sure
     */
    public Assignment(String nameAssignment, Document doc, int give_assignmentTime) {//odev süresi default olarak bir hafta olsun
        setAssignmentName(nameAssignment);
        setDocumentOfTeacher(doc);
        DocumentOfTeacher = null;
        deadlines = new Deadline(give_assignmentTime);
        DocumentsOfStudents = new ArrayList<>();
        DocumentsOfStudents.add(doc);
        // setDates( give_assignmentTime);
    }

    /**
     * constructor
     *
     * @param nameAssignment assignment adi
     * @param doc assignment documenti
     * @param given deadline (olusturulup verilir)
     */
    public Assignment(String nameAssignment, Document doc, Deadline given) {//odev süresi default olarak bir hafta olsun
        setAssignmentName(nameAssignment);
        setDocumentOfTeacher(doc);
        DocumentOfTeacher = null;
        deadlines = given;
        DocumentsOfStudents = new ArrayList<>();
        DocumentsOfStudents.add(doc);
        // setDates( give_assignmentTime);
    }

    /**
     * verilen sure set edilir
     *
     * @param givenAssignmentTime odev icin verilen sure
     */
    public void setAssignmentTime(int givenAssignmentTime) {
        this.AssignmentTime = givenAssignmentTime;
    }

    /**
     * odev suresini get eder
     *
     * @return integer odev suresi
     */
    public int getAssignmentTime() {
        return AssignmentTime;
    }

    /**
     * assignment adi set edilir
     *
     * @param Name verilen assignment adi
     */
    public void setAssignmentName(String Name) {
        this.AssignmentName = Name;
    }

    /**
     * assignment adini verir
     *
     * @return assignment adi dondurulur
     */
    public String getAssignmentName() {
        return AssignmentName;
    }

    /**
     * ogrenci documentlarini eklemeye yarar
     *
     * @param DocOfStudent
     */
    public void addDocumentOfStudents(Document DocOfStudent) {
        DocumentsOfStudents.add(DocOfStudent);
    }

    /**
     * verilen indexteki odevi verir
     *
     * @param index arraylist icin
     * @return document return eder
     */
    public Document getDocumentOfStudents(int index) {
        return DocumentsOfStudents.get(index);
    }

    /**
     * ogretmenin ekledigi document set edilir
     *
     * @param DocOfTeacher verilen document
     */
    public void setDocumentOfTeacher(Document DocOfTeacher) {
        this.DocumentOfTeacher = DocOfTeacher;
    }

    /**
     * ogretmenin ekledigi documenti verir
     *
     * @return document return eder
     */
    public Document getDocumentOfTeacher() {
        return DocumentOfTeacher;
    }

    /**
     * notu set eder
     *
     * @param givenGrade verilen not
     */
    public void setGrade(int givenGrade) {
        this.grade = givenGrade;
    }

    /**
     * notu return eder
     *
     * @return integer return eder
     */
    public int getGrade() {
        return grade;
    }

    /**
     * deadline'i return eder
     *
     * @return deadlines elemani
     */
    public Deadline getDeadlines() {
        return deadlines;
    }

    /**
     * Object sinifindan gelen equals fonksiyonu override
     *
     * @param thisAssignment esitligi karsilastirilacak assignment
     * @return boolean doner
     */
    @Override
    public boolean equals(Object thisAssignment) {

        if (thisAssignment == null) {
            return false;
        }
        if (thisAssignment == this) {
            return true;
        }
        if (!(thisAssignment instanceof Assignment)) {
            return false;
        }
        Assignment temp = (Assignment) thisAssignment;
        return (((temp.getAssignmentName() == null ? getAssignmentName() == null : temp.getAssignmentName().equals(getAssignmentName()))
                && (temp.getDocumentOfTeacher() == null ? getDocumentOfTeacher() == null : temp.getDocumentOfTeacher().equals(getDocumentOfTeacher())))
                && temp.getAssignmentTime() == getAssignmentTime());

    }

    /**
     * sinifin String olarak kullanilmasinda kolaylik saglar
     *
     * @return String return eder
     */
    @Override
    public String toString() {
        return getAssignmentName();
    }

}
