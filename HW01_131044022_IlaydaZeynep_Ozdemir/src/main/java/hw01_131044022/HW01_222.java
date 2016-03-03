/*
 *Test classi
 */
package hw01_131044022;

import java.util.ArrayList;

/**
 * Main-Test
 *
 * @author ilayda
 */
public class HW01_222 {

    public static void main(String[] args) {//duzenleeeee

        testScenario_1();
        testScenario_2();
        testScenario_3();
        testScenario_4();

    }

    //userlar sisteme kayit olabiliyor(admine kendilerini ekletiyorlar)
    //admin onlari sisteme ekliyor
    //admin ogretmeni derse atiyor
    //ogretmen birden fazla dersin yetkilisi olabiliyor
    //ogretmen kendi dersine ogrenci ekleyebiliyor
    //ogrenci kendini derse kayit ettirebiliyor(ogretmene kendilerini ekletiyorlar)
    //ogretmen derse assignment veriyor
    //default deadline 7 gun sonra
    //assignment deadline'i degistiriliyor
    //ogrenciler assignmentlari yukluyor
    //ogretmen dersinde ogrencilerin upload ettikleri odevleri listeliyor
    //ogrenci dersten cikmak istiyor
    //ogretmen kontrol ederek cikmak isteyenleri cikariyor
    //sonra ogrenci derslerini listeliyor
    //admin ders siliyor
    public static void testScenario_1() {
        System.out.println("#####SCENARIO_1#####");
        ArrayList<User> arrayOfUser = new ArrayList<>();

        CourseSystem systemOfCourses = new CourseSystem();

        Administrator admin = new Administrator("Admin");

        Teacher teacher1 = new Teacher("TeacherSevilgen");

        Student student1 = new Student("StudentOzdemir");
        Student student2 = new Student("StudentGungor");

        Course course1 = new Course("Bil222");
        Course course2 = new Course("Bil241");

        Document doc1_teacher = new File("file1");
        Assignment assignment1_222_teacher = new Homework("Homework1_222", doc1_teacher);
        Assignment assignment1_241_teacher = new Homework("Homework1_241", doc1_teacher);

        Document doc1_student = new File("file1_stu");
        Assignment assignment1_student_222 = new Homework("Homework1_222", doc1_student, assignment1_222_teacher.getDeadlines());
        Assignment assignment1_student1_241 = new Homework("Homework1_241_1", doc1_student, assignment1_241_teacher.getDeadlines());
        Assignment assignment1_student2_241 = new Homework("Homework1_241_2", doc1_student, assignment1_241_teacher.getDeadlines());

        arrayOfUser.add(admin);
        arrayOfUser.add(teacher1);
        arrayOfUser.add(student1);
        arrayOfUser.add(student2);
        System.out.println("Userlar sisteme yukleniyor");
        //admin disindaki tum kullanicilar admin tarafindan sisteme kaydolur
        //ama admin sistemi kendine kendini de sisteme kaydeder
        //polymorfizm sayesinde onun ulastigi registerSystem fonksiyonu kendi sinifindaki override olandir
        for (int i = 0; i < arrayOfUser.size(); ++i) {
            arrayOfUser.get(i).registerSystem(systemOfCourses);
        }
        System.out.println("Userlar sisteme yuklendi");
        System.out.println("");
        System.out.println("Admin dersleri ekliyor");
        admin.addCourse(course1);
        admin.addCourse(course2);
        System.out.println("Admin ayni ogretmeni iki derste gorevlendirdi");
        admin.appointTeacher(teacher1, course1);//admin ogretmeni ders ile gorevlendirir 
        admin.appointTeacher(teacher1, course2);//admin ogretmene bir tane daha ders verir
        System.out.println("ogretmen dersine ogrenciler ekledi");
        teacher1.addUser(student1, course2);
        teacher1.addUser(student2, course2);
        teacher1.listOfUser(course2);
        System.out.println("Ogretmen derse odev verdi");
        teacher1.giveAssignment(assignment1_241_teacher, course2);
        student1.listOfAssignments_StudentHas();
        System.out.println("ogrenci odevini yukledi");
        student1.uploadAssignment(course2, 0, assignment1_student1_241);
        student2.uploadAssignment(course2, 0, assignment1_student2_241);
        System.out.println("Ogretmen yuklenen odevleri goruntuledi");
        teacher1.listOfAssignment_uploaded(course2);
        System.out.println("Ogretmen sectigi dersteki odevleri notlandirdi");
        teacher1.graded_InThisCourse(course2);
        student1.viewAllGrades();
        System.out.println("ogretmen ders gorevinden ayrilmak istedi");
        teacher1.RequestToExit(course1);
        System.out.println("ogrenci  bil222 dersinten ayrilmak istedi");
        student2.RequestToExit(course1);
        System.out.println("admin sistemden cikmak isteyen ogretmen ya da dersten cikmak isteyen ogrenci var mi diye control etti");
        admin.controlled();
        student2.listOfCourses();
        System.out.println("ogretmen ogrenciyi bil241 dersinden cikarmayi uygun gordu");
        teacher1.RemoveUser(student2, course2);
        student2.listOfCourses();
        System.out.println("ama kullanici hala sistemde");
        System.out.println("#####################");

    }

    //Ogrenciler kendileri derse kaydolur 
    //ogrenciler sistemden cikmak ister
    //var olmayan bir ogrenci derse eklenince admin kontroluyle dersten silinir
    //tutor ekleme yapildi
    public static void testScenario_2() {

        System.out.println("#####SCENARIO_2#####");
        CourseSystem system1 = new CourseSystem();
        CourseSystem system2 = new CourseSystem();
        Administrator admin = new Administrator("Admin");
        Teacher teacher1 = new Teacher("TeacherSevilgen");
        Teacher teacher2 = new Teacher("TeacherAkgul");
        Student student1 = new Student("StudentOzdemir");
        Student student2 = new Student("StudentGungor");
        Student student3 = new Student("StudentErturac");
        Student student4 = new Student("StudentYaman");
        Course bil222 = new Course("Bil222");
        Course bil241 = new Course("Bil241");
        try {
            System.out.println("sistemi yuklemeden admine kullanici ekletmeye calistik");
            admin.addUser(teacher1, system1);//
            admin.InstallSystem(system1);//sistemi yuklemesi
            System.out.println("admin sisteme kullanicilari ekliyor");
            System.out.println("admine sistem degil de ders yollarsak eklemeyi yapmaz");
            admin.addUser(teacher1, bil222);
            System.out.println("admin olmadigi bir sisteme ekleme yapmasini istersek");
            admin.addUser(teacher1, system2);//
            System.out.println("dogru sisteme bir ogretmen yuklettik");
            admin.addUser(teacher1, system1);//
            System.out.println("dogru sisteme bir ogrenci yuklettik");
            admin.addUser(student1, system1);//
            System.out.println("Admine ders eklettik");
            admin.addCourse(bil222);//ders eklettik
            admin.listOfCourses();
            System.out.println("Ogrenciler sisteme kayit olmak istediler");
            student2.registerSystem(system1);
            student3.registerSystem(system1);
            System.out.println("admin ogretmenleri derslere gorevlendiriyor");
            System.out.println("eger sistemde bu ders yoksa once sisteme eklenir sonra ogretmen gorevlendirilir");
            //
            admin.appointTeacher(teacher2, bil222);//
            admin.appointTeacher(teacher1, bil241);//
            /////////////////////////////////////////
            admin.listOfCourses();
            student1.enrolMe_InCourse(bil222);//ogrenci kursa kayit olmak istiyor
            student2.enrolMe_InCourse(bil241);//
            student3.enrolMe_InCourse(bil241);
            //kursun basindaki yetkili ogretmen tarafindan gerceklestiriliyor
            System.out.println("ogretmen derse tutor olarak derste kayitli birini eklemeye calisti");
            teacher1.addTutor_InCourse(student2, bil241);//ogretmen derse tutor olarak derste kayitli birini eklemeye calisirsa
            System.out.println("");
            teacher1.listOfTutor(bil241);
            System.out.println("Ogrenci dersten cikmak istiyor. ");
            System.out.println("Ogretmen uygun bulursa onu dersten cikarir");
            student2.RequestToExit(bil241);//ogrenci bil241'den cikmak isteyecek
            teacher1.listOfUser(bil241);//ogretmen dersindeki ogrencileri listeledi
            System.out.println("");
            System.out.println("sisteme kayitli olmak isteyen bir ogrenci derse kayit oluyor ama sonra admin kontrolu onu siliyor");
            if (student4.enrolMe_InCourse(bil241)) {//sisteme kayitli olmayan bir kisi bir kursa kayit edilmek istendi
                admin.controlled();//sistemde ekli olmatan biri kurslara alinmis mi alindiysa siler
            }
            admin.listOfUser(system1);
        } catch (Exception ex) {
            System.out.println("Bazi hatalar olustu.Duzgun seyler yollanmadi");
        }
        System.out.println("#####################");

    }
//ogretmen dosya ekler

    public static void testScenario_3() {
        System.out.println("#####SCENARIO_3#####");
        CourseSystem system1 = new CourseSystem();
        Administrator admin = new Administrator("Admin");
        Teacher teacher1 = new Teacher("TeacherSevilgen");
        Teacher teacher2 = new Teacher("TeacherAkgul");
        Student student1 = new Student("StudentOzdemir");
        Student student2 = new Student("StudentGungor");
        Student student3 = new Student("StudentErturac");
        Student student4 = new Student("StudentYaman");
        Course bil222 = new Course("Bil222");
        Course bil241 = new Course("Bil241");
        System.out.println("Admin ogretmenleri derslere ekledi");
        admin.addUser(teacher1, system1);

        admin.addUser(student2, system1);
        admin.addUser(student3, system1);
        admin.addUser(student4, system1);
        System.out.println("Bir ogretmen ve bir ogrenci sisteme kaydolmak istedi ve admin onlari ekledi");
        teacher2.registerSystem(system1);
        student1.registerSystem(system1);

        admin.listOfUser(admin);
        admin.appointTeacher(teacher2, bil241);
        admin.appointTeacher(teacher1, bil222);
        admin.listOfCourses();
        teacher1.listOfCourses();
        teacher2.listOfCourses();
        System.out.println("Ogrenciler derslere kayit olmak istediler dersin ogretmeneleri onlari ekledi");
        student1.enrolMe_InCourse(bil241);
        student2.enrolMe_InCourse(bil222);
        System.out.println("");
        System.out.println("ogretmen sisteme dosya ekledi");
        teacher1.removeDocument_InCourse(new File("newFile"), bil241);
        System.out.println("derse tutor eklendi");
        teacher1.addTutor_InCourse(student4, bil241);
        teacher1.listOfTutor(bil241);
        System.out.println("#####################");

    }

    public static void testScenario_4() {
        System.out.println("#####SCENARIO_4#####");
        CourseSystem system1 = new CourseSystem();
        CourseSystem system2 = new CourseSystem();
        Administrator admin = new Administrator("Admin");
        Teacher teacher1 = new Teacher("TeacherSevilgen");
        Teacher teacher2 = new Teacher("TeacherAkgul");
        Student student1 = new Student("StudentOzdemir");
        Student student2 = new Student("StudentGungor");
        Student student3 = new Student("StudentErturac");
        Student student4 = new Student("StudentYaman");
        Course bil222 = new Course("Bil222");
        Course bil241 = new Course("Bil241");
        try {
            admin.InstallSystem(system1);//sistemi yuklemesi
            System.out.println("admin sisteme kullanicilari ekliyor");

            System.out.println(" sisteme bir ogrenci yuklettik");
            admin.addUser(student1, system1);//
            System.out.println("Admine ders eklettik");
            admin.addCourse(bil222);//ders eklettik
            admin.addCourse(bil241);
            
            admin.listOfCourses();
            System.out.println("ogretmen gorevlendirildi");
            admin.appointTeacher(teacher2, bil222);//
            admin.appointTeacher(teacher2, bil241);//
            System.out.println("admin bir ders sildi");
            admin.removeCourse(bil241);
            admin.listOfCourses();
            teacher1.viewOlderCourse();
            
            
            
            
        } catch (Exception ex) {
            System.out.println("Bazi hatalar olustu.Duzgun seyler yollanmadi");
        }
        System.out.println("#####################");
    }
}
