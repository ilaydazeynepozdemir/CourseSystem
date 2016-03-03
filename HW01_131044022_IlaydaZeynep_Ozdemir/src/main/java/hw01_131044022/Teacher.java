/*
 *sistemden cikma isteklerini dile getirebilirler
 */
package hw01_131044022;

import java.util.ArrayList;
import java.util.Date;

/**
 * Derse kullanici,tutor,document ekleme cikarma yapabilir
 *
 * @author ilayda
 */
public class Teacher extends Authorized implements InterfaceLessAuthority {

    /**
     * verilen assignmenti notlandirir private fonksiyondur
     *
     * @param grade_thisAssignment verilen odevi notlandirir
     * @throws MyException kendi exception classimdan exception olusturdum
     */
    private void graded_ThisAssignment(Assignment grade_thisAssignment) throws MyException {

        if (grade_thisAssignment == null) {

            throw new MyException("Null olan odev yollandi");
        }
        for (int i = 0; i < grade_thisAssignment.DocumentsOfStudents.size(); ++i) {
            if (grade_thisAssignment.getDocumentOfStudents(i) == null) {
                grade_thisAssignment.setGrade(0);
            } else if (grade_thisAssignment.getDeadlines().getSign_lateDeadline() == false
                    && grade_thisAssignment.getDeadlines().getSign_PassDeadlines() == false) {
                grade_thisAssignment.setGrade(100);
            } else if (grade_thisAssignment.getDeadlines().getSign_lateDeadline() == false) {
                grade_thisAssignment.setGrade(60);
            } else if (grade_thisAssignment.getDeadlines().getSign_PassDeadlines() == false) {
                grade_thisAssignment.setGrade(0);
            }
        }

    }

    /**
     * verilen derse verilen tutorun uygun olup olmadigina bakar
     *
     * @param voluntary gonullu tutor
     * @param thisCourse verilen derse bakilir
     * @return boolean doner
     * @throws MyException kendi exceptionimi firlatiyorum
     */
    private boolean approval(Tutor voluntary, Course thisCourse) throws MyException {

        if (existed(thisCourse, Courses)) {//ogretmenin kurslarinda bu kurs var mi
            if (existed(voluntary, thisCourse.getUsersOfCourse())) {//kullanicilarda bu tutor var mi
                return false;
            } else {
                return (!existed(voluntary, thisCourse.getTutorsOfCourse()));//tutor olarak var mi yok mu

            }
        } else {
            throw new MyException("Yollanan ders kayitli degil");
        }

    }

    /**
     * no paramater constructor
     */
    public Teacher() {
        super();
    }

    /**
     * constructor
     *
     * @param takenUsername ogretmenin kullanici adi
     */
    public Teacher(String takenUsername) {
        super(takenUsername);
    }

    /**
     * derse kullanici ekler
     *
     * @param added eklenecek kullanici
     * @param addedToHere eklenecek ders
     * @return eklenirse true eklenemezse false
     */
    @Override
    public boolean addUser(User added, Object addedToHere) {

        try {

            if ((addedToHere instanceof Course) && (added instanceof Student)) {

                Course addedHere = (Course) addedToHere;

                if (!existed(added, addedHere.getUsersOfCourse())) {//ders icinde bu ogranci yoksa

                    //ogrencinin odev yukleme arrayine ders icinde yer ayrilir!!!!!
                    //bi ogretmen o arrayliste ekleme yapamaz
                    addedHere.addUsersOfCourse(added);
                    addedHere.lastAddedUser().FillCoursesOfUser(addedHere);

                    addedHere.increaseNumberOfStudents();//ogrencinin odev arraylistlerini tutan arraylistindeki sirasi

                    addedHere.AssignmentsAllStudents.add(new ArrayList<Assignment>());

                    Student tempStudent = (Student) added;

                    int indexOfStudent = (addedHere.getNumberOfStudents() - 1);//array indexleri 0dan basladigi icin
                    tempStudent.setNumberOfStudent_InCourse(indexOfStudent);
                    // System.out.printf("Index=%d\n", indexOfStudent);

                    return true;
                } else {
                    return false;
                }

            } else {
                throw new MyException("Yanlis kullanici ya da yanlis yer yollandi\n");
            }
        } catch (Exception ex) {
            System.out.printf("%s \n", ex);
            return false;
        }

    }

    /**
     * dersten kullanici silme
     *
     * @param deleted silinecek kullanici
     * @param deletedFromHere silinecek yer
     * @return silinirse true silinemezse false
     */
    @Override
    public boolean RemoveUser(User deleted, Object deletedFromHere) {
        try {

            if (deletedFromHere instanceof Course) {//gelen sey kurs mu

                Course givenCourse = (Course) deletedFromHere;
                if (existed(deleted, givenCourse.getUsersOfCourse())) {
                    deleted.Courses.remove(givenCourse);//ogrencideki kurs listesinden kaldirildi

                    givenCourse.removedUser(deleted);//kurstan ogrenci kaldirirldi
                    return true;
                } else {
                    throw new MyException("ogrenci derste ekli degil");
                }
            } else {
                throw new MyException("Eklenecek yer bir ders degil");
            }
        } catch (Exception ex) {
            if (ex instanceof MyException) {
                System.out.printf("%s\n", ex);
            } else {
                System.out.println("Yanlis seyler gonderildi");
            }
            return false;
        }

    }

    /**
     * ogretmenlerin esitligini kontrol eder
     *
     * @param given karsilastirilacak ogretmen
     * @return esitse true doner
     */
    public boolean equals(Teacher given) {
        if (given == null) {
            return false;
        }
        if (given == this) {
            return true;
        }
        if (!(given instanceof Teacher)) {
            return false;
        }
        Teacher temp = (Teacher) given;
        return temp.getUsername().equals(this.getUsername());
    }

    /**
     * dersindeki ogrencilere odev vermek icin
     *
     * @param givenFromTeacher ogretmenin verdigi assignment
     * @param InthisCourse bu derse assignment verecek
     * @return assignment duzgun yuklenirse true doner
     */
    public boolean giveAssignment(Assignment givenFromTeacher, Course InthisCourse) {
        try {
            if (givenFromTeacher != null) {
                if (existed(InthisCourse, Courses)) {
                    InthisCourse.addAssignmentsOfCourse_givenTeacher(givenFromTeacher);
                    return true;
                } else {
                    throw new MyException("Bu ders hocanin dersi degil");
                }
            } else {
                throw new NullPointerException("Yanlis seyler gonderildi");
            }
        } catch (Exception ex) {
            System.out.printf("%s\n", ex);
            return false;
        }
    }

    /**
     * silinen kurslari gormesini saglar
     */
    @Override
    public void viewOlderCourse() {
        System.out.println("Silinen derslerin listesi");
        for (int i = 0; i < olderCourse.size(); ++i) {
            System.out.printf(" %d- %s\n", i, olderCourse.get(i));
        }
    }

    /**
     * ogrenciler tarafindan eklenen assignmentlari listeler
     *
     * @param InThisCourse bu dersteki assignmentlar
     */
    public void listOfAssignment_uploaded(Course InThisCourse) {

        for (int i = 0; i < InThisCourse.AssignmentsAllStudents.size(); ++i) {
            for (int j = 0; j < InThisCourse.AssignmentsAllStudents.get(i).size(); ++j) {
                System.out.printf("%s yuklendi\n", InThisCourse.AssignmentsAllStudents.get(i).get(j));

            }
        }
    }

    /**
     * ogretmen sistemden cikmak isterse kendi icindeki dilegi true yapar
     * dersinden ayrilmak isterse dersin icindeki dilegi true yapar
     *
     * @param fromHere
     * @return
     */
    @Override
    public boolean RequestToExit(Object fromHere) {
        if (fromHere instanceof Course) {
            Course thisCourse = (Course) fromHere;
            if (this.equals(thisCourse.getTeacherOfcourse())) {
                thisCourse.setWishForExit(true);//coursetan cikmak icin
                return true;
            } else {
                return false;
            }
        } else if (fromHere instanceof CourseSystem) {
            CourseSystem thisSystem = (CourseSystem) fromHere;
            if (existed(this, thisSystem.Users)) {
                setWishOfUser(true);//coursetan cikmak icin
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * ogrenciyse dersinden cikarir ve dilek gerceklestirilecek diye bosaltilir
     *
     * @param fromHere bu dersten cikarilir
     */
    @Override
    public void controlled(Object fromHere) {

        if (fromHere instanceof Course) {
            Course thisCourse = (Course) fromHere;
            for (int j = 0; j < thisCourse.getSize_usersOfCourse(); ++j) {
                //ogrenciyse dersinden cikarir
                if (thisCourse.get_userOfCourse(j) instanceof Student) {
                    if (thisCourse.get_userOfCourse(j).getWishOfUser()) {
                        thisCourse.get_userOfCourse(j).setWishOfUser(false);
                        //dilek gerceklestirilince bosaltilir
                        RemoveUser(thisCourse.get_userOfCourse(j), thisCourse);
                    }
                }

            }

        }

    }

    /**
     * verilen assignmentlarin istege bagli olarak deadline ve latedeadline'i
     * yeniden duzenlenir
     *
     * @param newDay belirlenen yeni deadline gunu
     * @param numOfAssingment verilen assignment numarasi
     * @param InThisCourse assignmentin bulundugu ders
     */
    public void editDeadlines(int newDay_forAssignment, int numOfAssingment, Course InThisCourse) {
        if (InThisCourse.getSizeAssignmentsOfCourse_givenTeacher() == 0) {
            return;
        }
        InThisCourse.getAssignmentsOfCourse_givenTeacher(numOfAssingment).getDeadlines().setDeadline(newDay_forAssignment);
        InThisCourse.getAssignmentsOfCourse_givenTeacher(numOfAssingment).getDeadlines().setLateDeadline(newDay_forAssignment);
    }

    /**
     * tum derslerdeki tum ogrencileri notlandirir
     */
    public void graded_AllCourses() {
        for (int i = 0; i < Courses.size(); ++i) {
            graded_InThisCourse(Courses.get(i));
        }
    }

    /**
     * verilen dersteki ogrencilerin assignmentlarini notlandirir
     *
     * @param InThisCourse verilen ders
     */
    public void graded_InThisCourse(Course InThisCourse) {
        try {
            for (int i = 0; i < InThisCourse.AssignmentsAllStudents.size(); ++i) {
                for (int j = 0; j < InThisCourse.AssignmentsAllStudents.get(i).size(); ++j) {
                    graded_ThisAssignment(InThisCourse.AssignmentsAllStudents.get(i).get(j));
                }
            }
        } catch (MyException ex) {
            System.out.printf("%s\n", ex.toString());

        }
    }

    /**
     * derse tutor ekleme
     *
     * @param addedTutor tutor yapilmasi dusunulen ogrenci
     * @param ThisCourse bu derse eklenecek
     * @return boolean doner eklenirse true eklenemezse false
     */
    public boolean addTutor_InCourse(Student addedTutor, Course ThisCourse) {
        try {
            if (addedTutor != null && ThisCourse != null) {
                if (existed(addedTutor, ThisCourse.getUsersOfCourse())) {//ogrenci zaten kursta varsa
                    return false;
                } else {
                    Tutor volunterTutor = new Tutor(addedTutor.getUsername());
                    if (approval(volunterTutor, ThisCourse)) {
                        ThisCourse.addTutorsOfCourse(volunterTutor);
                        ThisCourse.addUsersOfCourse(addedTutor);//kullancilara ve tutorlara ekler
                        volunterTutor.Courses.add(ThisCourse);//tutorun kurslarina bu kursu ekler
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                throw new MyException("Istenilenler duzgun yollanmadi");
            }
        } catch (MyException ex) {
            System.out.printf("%s \n", ex);
            return false;
        }
    }

    /**
     * dersten tutor cikarma
     *
     * @param deleted derste tutor ogrenci
     * @param ThisCourse bu derse eklenecek
     * @return silinirse true silinemezse false
     */
    public boolean removeTutor_InCourse(Tutor deleted, Course ThisCourse) {//silmek istediginde tutor olarak gelir
        try {
            if (deleted != null && ThisCourse != null) {
                if (existed(deleted, ThisCourse.getTutorsOfCourse())) {
                    deleted.Courses.remove(ThisCourse);//tutorun kurslarindan kurs ckarildi
                    ThisCourse.removedUser(deleted);//kullanicilardan sildi
                    ThisCourse.getTutorsOfCourse().remove(deleted);//tutor listesinden sildi
                    return true;
                } else {
                    throw new MyException("Zaten bu derste yok");
                }
            } else {
                throw new MyException("Istenilenler duzgun yollanmadi");
            }
        } catch (MyException ex) {
            System.out.printf("%s \n", ex);
            return false;
        }
    }

    /**
     * tutorlari listeler
     *
     * @param InThisCourse bu dersteki tutorlari
     */
    public void listOfTutor(Course InThisCourse) {

        if (InThisCourse.getTutorsOfCourse().isEmpty()) {
            System.out.println("Dersin tutoru yok");
            return;
        }
        System.out.println("Dersteki tutorlarin listesi");
        for (int i = 0; i < InThisCourse.getUsersOfCourse().size(); ++i) {
            for (int j = 0; j < InThisCourse.getTutorsOfCourse().size(); ++j) {
                System.out.printf("%s \n", InThisCourse.getTutorsOfCourse().get(j));
            }
        }
    }

    /**
     * kullanicilari listeler
     *
     * @param InThis bu dersteki
     */
    public void listOfUser(Object InThis) {
        if (InThis instanceof Course) {
            Course InThisCourse = (Course) InThis;
            if (InThisCourse.getUsersOfCourse().isEmpty()) {
                System.out.println("Dersin ogrencisi yok");
                return;
            }
            System.out.println("Dersteki ogrenci listesi");
            InThisCourse.listOfUsers_InCourse();
        }
    }

    /**
     * derse document eklenir
     *
     * @param addedDoc eklenecek document
     * @param InThisCourse bu derse document ekler
     *///yetki sadece ogretmenlerde degil
    public void addDocument_InCourse(Document addedDoc, Course InThisCourse) {
        InThisCourse.getDocumentsOfCourse().add(addedDoc);
    }

    /**
     * dersten document siler
     *
     * @param deletedDoc silinecek document
     * @param InThisCourse bu dersten silinir
     */
    public void removeDocument_InCourse(Document deletedDoc, Course InThisCourse) {
        if (existed(deletedDoc, InThisCourse.DocumentsOfCourse)) {
            InThisCourse.DocumentsOfCourse.remove(deletedDoc);
        }
    }

}
