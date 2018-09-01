//==========================================================
//
// Title: Factorial Calculator
// Description:
//   This application prompts for and reads a whole number
// from the user until it is between 0 and 170.  It then 
// calculates and display its factorial.
//
//==========================================================
#include <conio.h> // For function getch()
#include <iostream>  // For cin, cout, and system
using namespace std;  // So "std::cout" may be abbreviated to "cout", for example.

int main()
{

  // Declare variables
  int number;
  double fact; // Declared 'double' to hold larger numbers 
  // than 'int'

  // Show application header
  cout << "Welcome to Factorial Calculator" << endl;
  cout << "-------------------------------" << endl << endl;

  // Loop to get number.
  // -Factorial is not defined for numbers less than 0.
  // -double cannot hold number larger than 170!.
  cout << "Enter a whole number to calculate the factorial "
    << "of (between 0 and 170): ";
  cin >> number;
  while (number < 0 || number > 170)
  {
    cout << "\nEnter a whole number to calculate the "
      << "factorial of (between 0 and 170): ";
    cin >> number;
  }

  // Test which number entered
  if (number == 0 || number == 1)
    fact = 1;

  // Calculate factorial of numbers greater than 1
  else
  {

    // Loop to calculate factorial
    fact = 1;
    for (int i = number; i > 1; i--)
      fact = fact * i;

  }

  // Show factorial
  cout << number << "! = " << fact << endl;

  // Show application close
  cout << "\nEnd of Factorial Calculator" << endl << endl;

  // Pause before application window closes
  cout << "Press any key to exit ..." << endl;
  _getch();

}
