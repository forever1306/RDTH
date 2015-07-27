/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.NumberFormat;

/**
 *
 * @author Minh-IT
 */
public class MyUtils {
    public static NumberFormat getCurrencyFormat(){
        return NumberFormat.getCurrencyInstance();
    }
}
