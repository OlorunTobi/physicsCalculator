/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PhysicsCalc;

import java.util.Set;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Administrator
 */
@Entity
public class Var implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String symbol;
    
    private String unit;

    @ManyToMany(targetEntity=Equation.class, mappedBy="var")
    public Set equation;
    
    public Var() {
        symbol = null;
        unit = null;
    }
    
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    public String getUnit() {
        return unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    public Boolean containsEquation(Equation equationtemp) {
        if(equation.contains(equationtemp))
            return true;
        else
            return false;
    }
    
    public void addEquation(Equation equationtemp) {
        this.equation.add(equationtemp);
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Var)) {
            return false;
        }
        Var other = (Var) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PhysicsCalc.Variable[ id=" + id + " ]";
    }
    
}
