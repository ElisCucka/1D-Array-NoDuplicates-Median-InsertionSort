/*******************************************************************
 * New York Institute of Technology  
 * Elis Cucka                      
 * Data Structures - CSCI 260 M05 
 * Spring 2019 Semester                 
 * Assignment 3: Chapter 3 Programming Projects
 * Goal: Finding the median item for an array and removing duplicates.
 * Editing the OrdArray and OrderedApp class.
 * Instructor's name: Michael Kadri    
 * Date of program's creation:      
 * February 2, 2019     Version 0.11
 ********************************************************************/

///////////////////////////////////////////////////////////////////
//-----------------------------------------------------------------
class ArrayIns  // ArrayIns class
{
	private long[] a;                 // ref to array a
	private int nElems;               // number of data items
	//--------------------------------------------------------------
	public ArrayIns(int max)          // constructor
	{
		a = new long[max];                 // create the array
		nElems = 0;                        // no items yet
	} //end ArrayIns()
	//--------------------------------------------------------------
	public void insert(long value)    // put element into array
	{
		a[nElems] = value;             // insert it
		nElems++;                      // increment size
	} // end insert() 
	//--------------------------------------------------------------
	public void display()             // displays array contents
	{
		for(int j=0; j<nElems; j++)       // for each element,
			System.out.print(a[j] + " ");  // display it
		System.out.println("");
	} // end display() 
	//--------------------------------------------------------------
	public void insertionSort()        // insertion sort method
	{
		int j, i;

		for(i=1; i<nElems; i++)     // out is dividing line
		{
			long temp = a[i];            // remove marked item
			j = i;                      // start shifts at out
			while(j>0 && a[j-1] >= temp) // until one is smaller,
			{
				a[j] = a[j-1];            // shift item to right
				--j;                       // go left one position
			}
			a[j] = temp;                  // insert marked item
		}  // end for
	}  // end insertionSort()
	//--------------------------------------------------------------
	public boolean delete(long value)  // deleting an item from an array
	{
		int j;
		for(j=0; j<nElems; j++)        // look for it
			if( value == a[j] )
				break;
		if(j==nElems)                  // can't find it
			return false;
		else                           // found it
		{
			for(int k=j; k<nElems; k++) // move higher ones down
				a[k] = a[k+1];
			nElems--;                   // decrement size
			return true;
		}
	}  // end delete()
	//--------------------------------------------------------------
	public double median()               // finding the median
	{
		double median;
		if(nElems % 2 == 0)   // if number of elements is even
		{
			median = (double)(a[nElems/2] + a[(nElems/2)-1])/2;  // calculating the median
		}
		else                    // if number of elements is odd
			median = a[(nElems/2)];  // finding the median
		return median;
	} // end median()
	//--------------------------------------------------------------
	/*public void noDups()              // duplicate remover
	{
		for(int j = 0; j < nElems; j++)
			//for(int i = 0; i < nElems; i++)
			if(a[j]==a[j+1])        // condition for duplicate
				delete(a[j+1]);     // deleting a duplicate 
	}*/
	//--------------------------------------------------------------
	public void noDupps2()  //removes the duplicates
	{
		int iCount = 0;
		for (int i = 1; i < nElems; i++) 
		{
			//
			long test = a[i];

			if (a[iCount] != a[i]) 
			{
				iCount++;
				a[iCount] = test;
			}
		}

		nElems = iCount + 1;

		System.out.print("arr[] = {");
		for (int i = 0; i < nElems; i++) 
		{
			if (i < nElems - 1) 
			{
				System.out.print(a[i] + ", ");
			} 
			else 
			{
				System.out.println(a[i] + "}");
			}
		}
		System.out.println("New Size = " + nElems);
	}



	public static void main(String[] args)  // main method
	{
		int maxSize = 100;            // array size
		ArrayIns arr;                 // reference to array
		arr = new ArrayIns(maxSize);  // create the array

		arr.insert(77);               // inserting items
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(88);
		arr.insert(88);
		/*arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		arr.insert(58);
		arr.insert(84);
		arr.insert(36);
		arr.insert(50);*/

		System.out.println("The elements of the array are: ");
		arr.display();                // display items
		System.out.println("The sorted array: ");
		arr.insertionSort();          // insertion-sort them

		arr.display();                // display them again

		System.out.println("The median of the array is: " + arr.median());
		arr.noDupps2();                 // removing duplication
		System.out.println("The array without duplication (items moving no more than once: )");
		arr.display();                // display them again
	}  // end main()
}  // end class InsertSortApp
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////