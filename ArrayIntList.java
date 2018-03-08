
//CSE 143, Winter 2011, Marty Stepp
//An ArrayIntList object stores an ordered list of integers using
//an unfilled array.
//Today's version adds:
//* toString method so that clients can easily print lists,
//* indexOf and contains methods for searching lists,
//* second constructor that accepts a capacity parameter,
//* checks preconditions on several methods (add, get, set, remove) and
//  throws exceptions if the indexes passed are out of range.


import java.util.*;   // for Arrays

public class ArrayIntList {
 private static final int INITIAL_CAPACITY = 10;
 
 // fields - the data inside each ArrayIntList object
 private int size;
 private int[] elementData;
 
 // Initializes a new empty list with initial capacity of 10 integers.
 public ArrayIntList() {
     this(INITIAL_CAPACITY);   // call the (int) constructor
 }
 
 // Initializes a new empty list with the given initial capacity.
 // Precondition: capacity > 0
 public ArrayIntList(int capacity) {
     if (capacity <= 0) {
         throw new IllegalArgumentException("capacity must be positive: " + capacity);
     }
     size = 0;
     elementData = new int[capacity];
 }
 
 // Adds the given value to the end of the list.
 // If necessary, resizes the array to fit the value.
 public void add(int value) {
     // just call the other add method (to remove redundancy)
     add(size, value);
 }

 // Inserts the given value into the list at the given index.
 // If necessary, resizes the array to fit the value.
 // Precondition: 0 <= index <= size
 public void add(int index, int value) {
     checkIndex(index, 0, size);     // okay to add at index == size (end of list)
     checkResize();
     
     // slide elements to the right to make room
     for (int i = size; i > index; i--) {
         elementData[i] = elementData[i - 1];
     }
     
     // insert the value in the hole we just made
     elementData[index] = value;
     size++;
 }
 
 // Returns the value in the list at the given index.
 // Precondition: 0 <= index < size
 public int get(int index) {
     checkIndex(index, 0, size - 1);
     return elementData[index];
 }
 
 // Sets the given index to store the given value.
 // Precondition: 0 <= index < size
 public void set(int index, int value) {
     checkIndex(index, 0, size - 1);
     elementData[index] = value;
 }
 
 // Returns the number of elements in the list.
 public int size() {
     return size;
 }
 
 // Returns true if the list does not contain any elements.
 public boolean isEmpty() {
     return size == 0;   // "boolean zen"
 }
 
 // Removes the value from the given index, shifting following elements left
 // by 1 slot to cover the hole.
 // Precondition: 0 <= index < size
 public void remove(int index) {
     checkIndex(index, 0, size - 1);
     for (int i = index; i <= size - 1; i++) {
         elementData[i] = elementData[i + 1];
     }
     size--;
 }
 
 // Returns a String representation of the elements in the list, such as
 // "[42, -3, 17, 99]", or "[]" for an empty list.
 public String toString() {
     if (size > 0) {
         String result = "[" + elementData[0];
         for (int i = 1; i < size; i++) {
             result = result + ", " + elementData[i];
         }
         result += "]";
         return result;
     } else {
         return "[]";   // empty list
     }
 }
 
 // Returns the index of the first occurrence of the given value in the list,
 // or -1 if the value is not found in the list.
 public int indexOf(int value) {
     for (int i = 0; i < size; i++) {
         if (elementData[i] == value) {
             return i;
         }
     }
     return -1;   // not found
 }
 
 // Returns true if the given value is found in this list.
 public boolean contains(int value) {
     return indexOf(value) >= 0;
 }
 
 // A "private helper method" to resize the array if necessary.
 // Checks whether the list's array is full, and if so,
 // doubles its size so that more elements can be added.
 private void checkResize() {
     if (size == elementData.length) {
         // resize the array
         elementData = Arrays.copyOf(elementData, 2 * size);
     }
 }
 
 // A helper that throws an exception unless the given index is between the
 // given minimum / maximum values, inclusive.
 private void checkIndex(int index, int min, int max) {
     if (index < min || index > max) {
         throw new ArrayIndexOutOfBoundsException();
     }
 }
}
