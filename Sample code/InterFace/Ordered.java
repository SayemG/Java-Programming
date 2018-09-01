//======================================================================
//
// Interface: Ordered
// Description:
//   This interface enforces object sorting.
//
//======================================================================
package wsu.InterfaceType;

//======================================================================
// interface Ordered
//======================================================================
public interface Ordered
{
    
    //==================================================================
    // Methods
    //==================================================================
    
    public abstract boolean precedes(Object b);
    public abstract boolean follows(Object b);

}
