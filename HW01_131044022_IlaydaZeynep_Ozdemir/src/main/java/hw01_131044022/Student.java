/*
 * Ogrenciler sadece dersten cikma isteklerini dile getirebilirler
 */
package hw01_131044022;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Student Classi Userdan turer
 *
 * @author ilayda
 */
public class Student extends Unauthorized {

    /**
     * ogrencinin dersler icindeki assingment arrayListi tutan arrayin
     * numarasini tutar her ogrencinin farklidir ogrenci course numarasi
     */
    int numberOfStudent_InCourse;

    /**
     * no parameter constructor
     */
    public Student() {
        super();
        numberOfStudent_InCourse = 0;
    }

    /**
     * constructor
     *
     * @param takenUsername kullanicinin adi
     */
    public Student(String takenUsername) {
        super(takenUsername);
        numberOfStudent_InCourse = 0;
    }

    /**
     * ogrencinin assignment yukleme methodu
     *
     * @param ToThisCourse bu derse yuklenir
     * @param numOfAssignment kacinci odev oldugu
     * @param Student_Assignment ogrencinin yukleyecegi assignment
     * @return boolean return eder
     */
    public boolean uploadAssignment(Course ToThisCourse, int numOfAssignment, Assignment Student_Assignment) {
        try {
            if (existed(ToThisCourse, Courses)) {
                if (ToThisCourse.getAssignmentsOfCourse_givenTeacher(numOfAssignment) != null) {
                    //odev verilmisse
                    Calendar now = Calendar.getInstance();
                    //ilk durum uygun zamanda yukleme
                    //ikincisi lateDeadline zamaninda yukleme
                    //ucuncusu yukleyeme zamanini kacirma
                    if ((now.compareTo(ToThisCourse.getAssignmentsOfCourse_givenTeacher(numOfAssignment).getDeadlines().getDeadline()) == -1)
                            || (now.compareTo(ToThisCourse.getAssignmentsOfCourse_givenTeacher(numOfAssignment).getDeadlines().getDeadline()) == 0)) {

                        if ((now.compareTo(ToThisCourse.getAssignmentsOfCourse_givenTeacher(numOfAssignment).getDeadlines().getLateDeadline()) == -1)
                                || (now.compareTo(ToThisCourse.getAssignmentsOfCourse_givenTeacher(numOfAssignment).getDeadlines().getLateDeadline()) == 0)) {

                            ToThisCourse.AssignmentsAllStudents.get(getNumberOfStudent_InCourse()).add(numOfAssignment, Student_Assignment);
                        }
                    } else if ((now.compareTo(ToThisCourse.getAssignmentsOfCourse_givenTeacher(numOfAssignment).getDeadlines().getLateDeadline()) == -1)
                            || (now.compareTo(ToThisCourse.getAssignmentsOfCourse_givenTeacher(numOfAssignment).getDeadlines().getLateDeadline()) == 0)) {

                        Student_Assignment.getDeadlines().setSign_lateDeadline(true);
                        ToThisCourse.AssignmentsAllStudents.get(getNumberOfStudent_InCourse()).add(numOfAssignment, Student_Assignment);
                    }

                    if (now.compareTo(ToThisCourse.getAssignmentsOfCourse_givenTeacher(numOfAssignment).getDeadlines().getDeadline()) == 1) {
                        if (now.compareTo(ToThisCourse.getAssignmentsOfCourse_givenTeacher(numOfAssignment).getDeadlines().getDeadline()) == 1) {

                            Student_Assignment.getDeadlines().setSign_PassDeadlines(true);//yukluyo ama notlandirilirken 0 olur
                            ToThisCourse.AssignmentsAllStudents.get(getNumberOfStudent_InCourse()).add(numOfAssignment, Student_Assignment);
                        }
                    }

                    return true;
                } else {
                    throw new MyException("Odev verilmemis");
                }
            } else {
                throw new MyException("yanlis ders");
            }
        } catch (MyException ex) {
            System.out.printf("%s\n", ex);
            return false;
        }
    }

    /**
     * ogrenci kendi ders notlarini goruntuler
     *
     * @param ThisCourse bu dersteki notlari goruntuler
     */
    public void viewMyGrades(Course ThisCourse) {
        if (ThisCourse == null) {
            return;
        }
        if (ThisCourse.AssignmentsAllStudents.size() == 0) {
            return;
        }
        for (int i = 0; i < ThisCourse.AssignmentsAllStudents.get(getNumberOfStudent_InCourse()).size(); ++i) {
            System.out.printf("%s - Grade = %s\n",
                    ThisCourse.AssignmentsAllStudents.get(getNumberOfStudent_InCourse()).get(i),
                    ThisCourse.AssignmentsAllStudents.get(getNumberOfStudent_InCourse()).get(i).getGrade());

        }

    }

    /**
     * ogrenci butun notlarini goruntuler
     */
    public void viewAllGrades() {
        for (int i = 0; i < Courses.size(); ++i) {
            System.out.printf("%s\n", Courses.get(i));
            viewMyGrades(Courses.get(i));
        }
    }

    /**
     * ogrenci derse kaydolmak icin bu fonksiyonu cagirir
     *
     * @param enrolThisCourse bu kursa kaydolmak ister
     * @return kaydolabilirse true kaydolamazsa false doner
     */
    @Override
    public boolean enrolMe_InCourse(Course enrolThisCourse) {
        try {
            if (enrolThisCourse.getTeacherOfcourse() == null) {
                throw new NullPointerException();
            }
            return enrolThisCourse.getTeacherOfcourse().addUser(this, enrolThisCourse);
        } catch (Exception ex) {
            System.out.println("dersin ogretmeni yok");
            return false;
        }
    }

    /**
     * ders numarasi set edilir
     *
     * @param given verilen numara
     */
    public void setNumberOfStudent_InCourse(int given) {
        this.numberOfStudent_InCourse = given;
    }

    /**
     * ders numarasi get edilir
     *
     * @return integer doner
     */
    public int getNumberOfStudent_InCourse() {
        return numberOfStudent_InCourse;
    }

    /**
     * assignmentlarini listeler
     */
    public void listOfAssignments_StudentHas() {
        
        for (int i = 0; i < Courses.size(); ++i) {
            System.out.printf("%s ogrencinin gorevleri -", this.getUsername());
            Courses.get(i).listOfAssignments_InCourse();
        }
    }

    /**
     * kursa ekledigi assignmentlarini listeler
     *
     * @param InThisCourse
     */
    public void listOfAssingment_uploaded(Course InThisCourse) {
        if (InThisCourse.AssignmentsAllStudents.size() == 0) {
            return;
        }
        for (int i = 0; i < InThisCourse.AssignmentsAllStudents.get(getNumberOfStudent_InCourse()).size(); ++i) {
            System.out.printf("%s odevi %s kullanicisi\n", InThisCourse.AssignmentsAllStudents.get(getNumberOfStudent_InCourse()).get(i), this);
        }
    }

    /**
     * cikis istegi olursa bu fonksiyonu cagirir
     * sadece dersten cikar
     *
     * @param fromHere cikmak istedikleri ders
     * @return boolean doner
     */
    @Override
    public boolean RequestToExit(Object fromHere) {

        if (fromHere instanceof Course) {
            Course thisCourse = (Course) fromHere;
            if (existed(this, thisCourse.getUsersOfCourse())) {
                this.setWishOfUser(true);
                return true;
            } else {
                return false;
            }
        }else return false;
    }

}
