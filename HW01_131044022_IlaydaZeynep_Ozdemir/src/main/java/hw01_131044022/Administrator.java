/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

/**
 * sisteme kullanici ve ders ekleme,cikarma yapar
 *
 * @author ilayda
 */
public class Administrator extends Authorized {

    CourseSystem system;

    /**
     * No parameter Constructor
     */
    public Administrator() {
        super();
    }

    /**
     *
     * @param givenSystem adminin yonetecegi sistem
     */
    public Administrator(CourseSystem givenSystem) {
        super("admin");
        InstallSystem(givenSystem);
    }

    /**
     *
     * @param takenUsername kullanici adi
     */
    public Administrator(String takenUsername) {
        super(takenUsername);
        setSystem(null);
    }

    /**
     *
     * @param takenUsername kullanici adi
     * @param createdSystem yonetecegi sistem
     */
    public Administrator(String takenUsername, CourseSystem createdSystem) {
        super(takenUsername);
        InstallSystem(createdSystem);
    }

    /**
     * private sisteme erisilemesin diye
     *
     * @return sistemi return eder
     */
    private CourseSystem getSystem() {
        return system;
    }

    /**
     * admin icindeki sistemi verilen sistemle doldurur
     *
     * @param InstallSystem yuklenecek sistem
     */
    public void setSystem(CourseSystem InstallSystem) {
        this.system = InstallSystem;
    }

    /**
     * sistemi yukler
     *
     * @param Install yuklenecek sistem
     * @return yuklenemezse false doner
     */
    public boolean InstallSystem(CourseSystem Install) {
        try {
            if (Install != null) {
                setSystem(Install);
                system.setAdmin(this);
                return true;
            } else {
                throw new MyException("Sistem hatali");
            }
        } catch (MyException ex) {
            System.out.printf("%s\n", ex);
            return false;
        }
    }

    /**
     * admini sisteme kaydeder
     *
     * @param toRegister kaydolunucak yer
     * @return sistem hataliysa false doner
     */
    @Override
    public boolean registerSystem(CourseSystem toRegister) {
        try {
            if (toRegister != null) {
                InstallSystem(toRegister);
                return true;

            } else {
                throw new MyException("Sistem hatali");
            }
        } catch (MyException ex) {
            System.out.printf("%s\n", ex);
            return false;
        }
    }

    /**
     * Admin cikmak isterse tum sistemi siler
     *
     * @param fromHere cikilmak istenilen yer
     * @return
     */
    @Override
    public boolean RequestToExit(Object fromHere) {
        if (fromHere instanceof CourseSystem) {
            CourseSystem thisSystem = (CourseSystem) fromHere;
            if (!thisSystem.equals(this.getSystem())) {
                return false;
            }
            for (int i = 0; i < getSystem().Users.size(); ++i) {
                RemoveUser(getSystem().Users.get(i), getSystem());
            }
            for (int i = 0; i < Courses.size(); ++i) {
                removeCourse(Courses.get(i));
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * ogretmenleri atama islemi gerceklesir
     *
     * @param thisTeacher atanacak ogretmen
     * @param addedCourse atandigi ders
     * @return bir hata olusursa false doner
     */
    public boolean appointTeacher(Teacher thisTeacher, Course addedCourse) {
        if (thisTeacher != null && addedCourse != null) {
            if (existed(addedCourse, Courses)) {
                if (addedCourse.getTeacherOfcourse() != null && existed(addedCourse, addedCourse.getTeacherOfcourse().Courses)) {
                    //derse daha once hic ogretmen atanmamissa buraya girmez
                    //eger dersin basinda bir ogretmen varsa
                    //o ogretmenin dersleri arasindan bu ders cikarilir
                    addedCourse.getTeacherOfcourse().Courses.remove(addedCourse);
                }
                thisTeacher.FillCoursesOfUser(addedCourse);
                addedCourse.setTeacherOfcourse(thisTeacher);
                return true;
            } else {//ders sistemde kayitli degilse kaydeder
                addCourse(addedCourse);//kurs sisteme eklenir ve sonra tekrardan bu fonksiyon cagirilir
                appointTeacher(thisTeacher, addedCourse);
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * kullaniciyi sistemden siler
     *
     * @param deletedsilinecek kullanici
     * @param deletedFromHere silinecegi yer
     * @return silinrse true silinemezse false
     */
    @Override
    public boolean RemoveUser(User deleted, Object deletedFromHere) {

        if (deletedFromHere instanceof CourseSystem) {
            if (deletedFromHere.equals(getSystem())) {

                if (existed(deleted, getSystem().Users))//kayitliysa bir doner{
                {
                    if (deleted instanceof Teacher) {//eger ogretmense yetkilisi oldugu derslerin ogretmenlerine null atanir
                        for (int i = 0; i < deleted.Courses.size(); ++i) {
                            deleted.Courses.get(i).setTeacherOfcourse(null);
                        }
                    }
                    for (int i = 0; i < deleted.Courses.size(); ++i) {
                        for (int j = 0; j < deleted.Courses.get(i).getTeacherOfcourse().Courses.size(); ++j) {
                            deleted.Courses.get(i).getTeacherOfcourse().Courses.get(j).removedUser(deleted);
                            //ogretmenindeki kayitli derslerinden silinir
                        }
                        deleted.Courses.get(i).removedUser(deleted);//kaydoldugu derslerinden ismi silinir   
                    }

                    deleted.Courses.clear();//kendi icindeki dersler temizleniyor

                    this.Courses.remove(deleted);//kayitli kisi sistemden silinir
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    /**
     * sisteme kullanici ekler
     *
     * @param added eklenecek kullanici
     * @param addedFromHere eklenecegi yer
     * @return eklenemezse false eklenirse true doner
     */
    @Override
    public boolean addUser(User added, Object addedFromHere) {
        try {
            if (this.getSystem() == null) {
                throw new MyException("Sistem yuklenmeden islem yapilamaz");
            }

            if (addedFromHere instanceof CourseSystem) {
                if (addedFromHere.equals(getSystem())) {

                    if (!existed(added, getSystem().Users))//kayitli degilse ekler{
                    {
                        getSystem().Users.add(added);
                        return true;
                    } else {
                        throw new MyException("Bu kisi var zaten");
                    }
                } else {
                    throw new MyException("Dogru sisteme yukleme yapmiyorsunuz");
                }
            } else {
                throw new MyException("Eklenecek yer dogru degil");
            }
        } catch (MyException ex) {
            System.out.printf("%s\n", ex);
            return false;
        }

    }

    /**
     * sisteme ders ekler
     *
     * @param added eklenecek kullanici
     * @return eklenirse true eklenemezse false doner
     */
    public boolean addCourse(Course added) {
        try {
            if (added != null) {
                if (!existed(added, Courses))//kayitli degilse ekler{
                {
                    Courses.add(added);
                    return true;
                } else {
                    return false;
                }
            } else {
                throw new Exception("Eklenecek ders hatali");
            }
        } catch (Exception ex) {
            System.out.printf("%s\n", ex);
            return false;
        }

    }

    /**
     * Sistemden ders siler
     *
     * @param deleted silinecek ders
     * @return silinirse true silinemezse false
     */
    public boolean removeCourse(Course deleted) {
        try {
            if (existed(deleted, Courses))//kayitliysa siler{
            {
                deleted.getTeacherOfcourse().olderCourse.add(deleted);
                //kurs icindeki ogrencilerden cikarilmali
                for (int i = 0; i < deleted.getSize_usersOfCourse(); ++i) {
                    deleted.get_userOfCourse(i).Courses.remove(deleted);
                }
                //ogretmenin derslerinden kurs silindi;
//                deleted.getTeacherOfcourse().Courses.remove(deleted);

                Courses.remove(deleted);
                deleted = new ConstantCourse(deleted.getCourseName(), deleted.getTeacherOfcourse());
                ConstantCourse constDeleted = (ConstantCourse) deleted;

                return true;
            } else {
                throw new MyException("Bu ders yok");
            }
        } catch (MyException ex) {
            System.out.printf("%s\n", ex);
            return false;
        }
    }

    /**
     * sistemden cikmak isteyen yetkili kullanicilari cikarir eger yollanan sey
     * bir dersse dersin ogretmenininin dersten cikip cikmayacagini kontrol eder
     * cikmak isterse dersten cikarip dersi ogretmensiz birakir ogrenciyse
     * cikmak isteyen sistemden siler
     *
     * @param fromHere burayi kontrol eder
     */
    @Override
    public void controlled(Object fromHere) {

        try {

            if (fromHere != null) {
                if (fromHere instanceof Course) {//ders icinde ogretmenin cikis istegi olduysa

                    Course thisCourse = (Course) fromHere;
                    if (thisCourse.getWishForExit_teacher()) {//kurs kontrolu istenirse ogretmense
                        thisCourse.getTeacherOfcourse().Courses.remove(thisCourse);//ogretmenin derslerinden bu ders cikarilir
                        thisCourse.setTeacherOfcourse(null);//dersin ogretmeninden de ogretmen cikarilip null atanir
                    }
                    //thisCourse.getTeacherOfcourse().controlled(thisCourse);//dersin
                } else if (fromHere instanceof CourseSystem) {

                    if (fromHere.equals(getSystem())) {
                        for (int i = 0; i < getSystem().Users.size(); ++i) {
                            if (getSystem().Users.get(i) instanceof Teacher) {
                                if (getSystem().Users.get(i).getWishOfUser()) {
                                    RemoveUser(getSystem().Users.get(i), getSystem());
                                }
                            } else if (getSystem().Users.get(i) instanceof Student) {
                                RemoveUser(getSystem().Users.get(i), getSystem());
                            }
                        }

                    } else {
                        throw new MyException("kontrol etmek istediginiz system hatali veya yanlis");
                    }
                }
            } else {
                throw new MyException("bos bir sey yolladiniz");
            }
        } catch (MyException ex) {
            System.out.printf("%s\n", ex);
        }
    }

    /**
     * eger sistemde olmayan bir ogrenci derslere eklendiyse admin kontrol
     * sirasinda mudahale edip kaldiriyor ayrica diger controlled fonksiyonunu
     * cagirarak cikmak isteyen ogretmen varsa onu cikariyor Yani tum kontroller
     * yapiliyor
     */
    public void controlled() {
        try {
            for (int i = 0; i < Courses.size(); ++i) {
                controlled(Courses.get(i));
                for (int j = 0; j < Courses.get(i).getSize_usersOfCourse(); ++j) {
                    if (!existed(Courses.get(i).get_userOfCourse(j), getSystem().Users)) {//kursun kullanici sistemde yoksa 
                        RemoveUser(Courses.get(i).get_userOfCourse(j), getSystem());     //dersten siler

                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Sistemde hata olustu. Isler ters gidiyor");
        }
    }

    /**
     * sistemdeki dersleri listeler
     */
    @Override
    public void listOfCourses() {//admin cagirisa bulunna kurslarin hepsi
        if (Courses.size() != 0) {
            System.out.printf("%s kullanicisi dersleri goruntuledi\n", this.getUsername());
            for (int i = 0; i < this.Courses.size(); ++i) {
                System.out.printf("%d-%s\n", i, Courses.get(i));
            }
        } else {
            System.out.printf("%s - hic ders yok\n", this.getUsername());
        }
    }

    /**
     * Verilen sistemdeki kisileri listeler
     *
     * @param InThis buradaki kullanicilar listelenir
     */
    @Override
    public void listOfUser(Object InThis) {
        if (InThis instanceof CourseSystem) {
            CourseSystem InThisSystem = (CourseSystem) InThis;
            if (InThisSystem.Users.isEmpty()) {
                System.out.println("Sistemin ogrencisi yok");
                return;
            }
            System.out.println("Sistemdeki kullanici");
            for (int i = 0; i < InThisSystem.Users.size(); ++i) {
                System.out.printf("%d- %s\n", i, InThisSystem.Users.get(i));
            }
        }
    }

}
