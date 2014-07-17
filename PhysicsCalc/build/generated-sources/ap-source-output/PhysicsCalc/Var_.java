package PhysicsCalc;

import PhysicsCalc.Equation;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-18T08:31:51")
@StaticMetamodel(Var.class)
public class Var_ { 

    public static volatile SingularAttribute<Var, Integer> id;
    public static volatile SingularAttribute<Var, String> unit;
    public static volatile SingularAttribute<Var, String> symbol;
    public static volatile SetAttribute<Var, Equation> equation;

}