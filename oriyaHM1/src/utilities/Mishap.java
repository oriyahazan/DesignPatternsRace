/**
 * Oriya Hazan. id:211987102
 * A class representing "Mishap".
 */

package utilities;

import java.text.DecimalFormat;

public class Mishap {
    private boolean fixable;
    private double reductionFactor;
    private int turnsToFix;

    /**
     * constructor
     * @param fixable -Is the mishap repairable?
     * @param turnsToFix-The turns until the mishap is fixed
     * @param reductionFactor-the deceleration factor
     */
    public Mishap(boolean fixable,int turnsToFix, double reductionFactor){
        this.fixable=fixable;
        this.turnsToFix=turnsToFix;
        this.reductionFactor=reductionFactor;
    }

    /**
     * Reduces the number of turns for repair
     */
    public void nextTurn(){
        if(fixable)
            this.turnsToFix--;
    }

    /**
     * getters and setters
     */
    public double getReductionFactor(){
        return reductionFactor;
    }
    public int getTurnsToFix(){
        return turnsToFix;
    }

    public boolean getFixAble(){
        return fixable;
    }
    public boolean setFixAble(boolean f){
        fixable=f;
        return true;
    }
    public boolean setReductionFactor(double r){
        if(r>=0) {
            reductionFactor = r;
            return true;
        }
        return false;
    }
    public boolean setTurnsToFix(int t){
        if(t>0){
            turnsToFix=t;
            return true;
        }
        return false;
    }

    /**
     * To string function
     */
    public String toString() {
        return "(" + fixable + " , " + turnsToFix + " , " + String.format("%.2f", reductionFactor) + ")";
    }
}
