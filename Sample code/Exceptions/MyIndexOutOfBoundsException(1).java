//======================================================================
//
// Class: MyIndexOutOfBoundsException
// Description:
//   This class represents an index-out-of-bounds exception.
//
//======================================================================
package wsu.Exceptions;

//======================================================================
// class MyIndexOutOfBoundsException
//======================================================================
public class MyIndexOutOfBoundsException 
	extends ArrayIndexOutOfBoundsException
{

	//==================================================================
    // Fields
    //==================================================================
	private static final long serialVersionUID = 1L;
    
    //==================================================================
    // Constructors
    //==================================================================

	public MyIndexOutOfBoundsException(String message)
	{
		//super(message);
		System.out.println("### DEBUG ### " + message);
	}

}
