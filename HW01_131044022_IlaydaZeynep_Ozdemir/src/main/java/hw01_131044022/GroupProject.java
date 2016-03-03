/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

import java.util.ArrayList;

/**
 *
 * @author ilayda
 */
public class GroupProject extends Assignment {
    private ArrayList<User> teamMate;

    /**
     *constructor
     * @param name projenin adi
     * @param doc verilen document 
     */
    public GroupProject(String name, Document doc,User SelectedteamMate) {
        super(name, doc);
        teamMate = new ArrayList<>();
        FillTeamMate(SelectedteamMate);
    }
    /**
     * constructor
     * @param name projenin adi
     * @param doc verilen document
     */
    public GroupProject(String name, Document doc) {
        super(name, doc);
        teamMate = new ArrayList<>();
    }
    /**
     * takim arkadasini doldurur
     * @param forTeam takim arkadasi
     */
    public void FillTeamMate(User forTeam ){
        teamMate.add(forTeam);
    }//ogrenci kendisi belirler takim arkadaslarini
    
    /**
     * verilen indexteki takim arkadasini verir
     * @param index bu indexteki takim arkadasi
     * @return user doner
     */
    public User getTeamMate(int index){
        return teamMate.get(index);
    }

    
    

    


}
