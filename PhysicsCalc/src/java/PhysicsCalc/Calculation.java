/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PhysicsCalc;

/**
 *
 * @author Administrator
 */
public class Calculation {
        private Double vzero;
    private Double timeval;
    private Double accel;
    private Double resultval;
    
    public Calculation(){
        vzero = 0.0;
        timeval = 0.0;
        accel = 0.0;
        resultval = 0.0;
    }
    
     public Double getVzero() {
        return vzero;
    }

    public void setVzero(Double vzero) {
        this.vzero = vzero;
    }
    
    public Double getTimeval() {
        return timeval;
    }

    public void setTimeval(Double timeval) {
        this.timeval = timeval;
    }
    
    public Double getAccel() {
        return accel;
    }

    public void setAccel(Double accel) {
        this.accel = accel;
    }

    public Double getResultval() {
        return resultval;
    }

    public void setResultval(Double resultval) {
        this.resultval = resultval;
    }
}
