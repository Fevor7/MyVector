package by.htp.Vector;

import java.lang.ArrayIndexOutOfBoundsException;

public class MyVictor<E> {
	public final static double COEF = (3.0 / 2.0);
	private int numberOfCells;
	private Object[] array;
	private int size;

	public MyVictor() {
		clear();
	}

	public MyVictor(int numberOfCells) {
		size = 0;
		this.numberOfCells = numberOfCells;
		array = new Object[numberOfCells];
	}

	public synchronized void add(E e) {
		if (size == numberOfCells) {
			increaseArray();
		}
		array[size] = e;
		size++;
	}

	public synchronized void add(int number, E e) {
		if (size == numberOfCells) {
			increaseArray();
		}
		int n = number - 1;
		for (int i = size; i > number; i--) {
			array[i] = array[i - 1];
		}
		array[number] = e;
		size++;
	}

	private void increaseArray() {
		int coeff;
		coeff = (int) ((size * COEF) + 1);
		Object[] arr = new Object[coeff];
		for (int i = 0; i < size; i++) {
			arr[i] = array[i];
		}
		array = arr;
		numberOfCells = coeff;
	}

	public synchronized E get(int namber) {
		if ((namber < 0) && (namber >= numberOfCells)) {
			exception();
		} else {
			E e = (E) array[namber];
			return e;
		}
		return null;
	}

	private void exception() {
		throw new ArrayIndexOutOfBoundsException();
	}

	public synchronized int size() {
		return size;
	}

	public synchronized void remove(int index) {
		if ((index >= 0) && (index < size)) {
			for (int i = index; i < (size - 1); i++) {
				array[i] = array[i + 1];
			}
			array[size - 1] = null;
			size--;
		}
	}

	public synchronized void remove(E e) {
		if (e == null) {
			return;
		}
		for (int i = 0; i < size; i++) {
			if (findElement(e, i)) {
				remove(i);
			}
		}
	}

	private boolean findElement(E e, int number) {
		if (e.equals(array[number])) {
			return true;
		}
		return false;
	}

	public synchronized void trimToSize() {
		Object[] tempArray = new Object[size];
		for (int i = 0; i < size; i++) {
			tempArray[i] = array[i];
		}
		array = tempArray;
		numberOfCells = size;
	}

	public synchronized void ensureCapacity(int size) {
		if (size <= 0) {
			exception();
			return;
		}
		Object[] tempArray = new Object[size];
		for (int i = 0; i < this.size; i++) {
			if (i < size) {
				tempArray[i] = array[i];
			}
		}

		if (size <= this.size) {
			this.size = size;
		}
		array = tempArray;
		numberOfCells = size;
	}

	public synchronized int indexOf(E e) {
		for (int i = 0; i < size; i++) {
			if (findElement(e, i)) {
				return i;
			}
		}
		return -1;
	}

	public synchronized boolean contains(E e) {
		for (int i = 0; i < size; i++) {
			if (findElement(e, i)) {
				return true;
			}
		}
		return false;
	}

	public synchronized void set(int number, E e) {
		if ((number >= 0) && (number < size)) {
			array[number] = e;
		} else {
			exception();
		}
	}

	public synchronized void clear() {
		size = 0;
		numberOfCells = 10;
		array = new Object[numberOfCells];
	}

	public synchronized E[] toArray(E[] e) {
		for (int i = 0; i < e.length; i++) {
			if (i < size) {
				e[i] = (E) array[i];
			}
		}
		return e;
	}
}
