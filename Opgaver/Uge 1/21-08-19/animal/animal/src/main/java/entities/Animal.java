/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Marcus
 */
public class Animal {
    private String type;
    private Integer birthYear;
    private String sound;
    
    public Animal() {}
    public Animal(String type, Integer birthYear, String sound) {
        this.type = type;
        this.birthYear = birthYear;
        this.sound = sound;
    }
    
    
}
