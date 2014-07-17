/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PhysicsCalc;

import java.util.Set;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.*;

/**
 *
 * @author Administrator
 */
@Entity
public class Equation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String funcstring;
    
    @ManyToMany(targetEntity=Var.class)
    @JoinTable(name="Eq_Var")
    public Set var;
    
    public Equation(){
           funcstring = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
        
    public String getFuncstring(){
            return funcstring;
    }
    
    public void setFuncstring(String funcstring){
            this.funcstring = funcstring;
    }

    public Set<Var> getVar() {
        return var;
    }

    public void setVar(Set<Var> var) {
        this.var = var;
    }
    
    public void addVar(Var var){
        boolean addbool = false;
        addbool = this.var.add(var);
        if(!addbool)
            System.out.println("Failed to add var to varset");
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
        if (!(object instanceof Equation)) {
            return false;
        }
        Equation other = (Equation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PhysicsCalc.Equation[ id=" + id + " ]";
    }
    
}
