package com.example.levis.materialthemenightmode;



/**
 * Created by Levis on 7/29/2017.
 */
public class Themes {
    public static Integer getTheme(int themid){
        Integer[] themes = {R.style.Light, R.style.Dark};
        return themes[themid];
    }
}
