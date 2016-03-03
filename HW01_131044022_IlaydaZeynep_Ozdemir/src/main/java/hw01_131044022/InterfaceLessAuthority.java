package hw01_131044022;

import java.util.ArrayList;

/**
 * Az yetki verilmesi gereken yerler icin eski courselari tutar
 *
 * @author ilayda
 */
public interface InterfaceLessAuthority {

    public ArrayList<Course> olderCourse = new ArrayList<>();

    /**
     * eski dersleri goruntuler
     */
    public void viewOlderCourse();


}
