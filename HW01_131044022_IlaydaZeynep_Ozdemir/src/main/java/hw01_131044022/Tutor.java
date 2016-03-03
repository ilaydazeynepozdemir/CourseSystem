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
public class Tutor extends Student implements InterfaceLessAuthority {

    /**
     * no parameter constructor
     */
    public Tutor() {
        super();
    }

    /**
     * constructor
     *
     * @param takenUsername tutorun kullanici adi
     */
    public Tutor(String takenUsername) {
        super(takenUsername);
    }

    /**
     * tutor eski dersleri gorebilir
     */
    @Override
    public void viewOlderCourse() {
        System.out.printf("%s eski ders listesini goruntuledi", this);
        for (int i = 0; i < olderCourse.size(); ++i) {
            System.out.printf(" %d- %s\n", i, olderCourse.get(i));
        }
    }



    /**
     * tutor olan biri tutor oldugu derse assignment ekleme yapamaz tutoru
     * degilse ekleme yapabilir
     *
     * @param ToThisCourse assignment eklenecek ders
     * @param numOfAssignment eklenecek ders numarasi
     * @param uploaded eklenmek istenen assignment
     * @return eklenirse true eklenemezse false
     */
    @Override
    public boolean uploadAssignment(Course ToThisCourse, int numOfAssignment, Assignment uploaded) {
        try {
            if (existed(this, ToThisCourse.getTutorsOfCourse())) {
                throw new MyException("Bu derste tutorsun. Odev yukleyemezsin");
            } else {
                return super.uploadAssignment(ToThisCourse, numOfAssignment, uploaded);

            }
        } catch (MyException ex) {
            System.out.printf("%s\n", ex);
            return false;
        }
    }

}
