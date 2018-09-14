//Written By: Avtar Singh Oct 2017

import java.util.Scanner;

public class ArrayHeap {
	public static int items = 0;

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		int[] a = { 3, 6, 5, 10, 4, 2, 9, 7, 1, 8 };
		items = a.length - 1;
		int item = 0;

		System.out.println("The original array a is: ");
		for (int x = 0; x <= items; x++)
			System.out.print(a[x] + " ");

		heapify(a);

		System.out.println("\nThe heapyfied array a is: ");
		for (int x = 0; x <= items; x++)
			System.out.print(a[x] + " ");
		do {
			System.out.println("\nRemove item: ");
			item = scan.nextInt();

			boolean deleted = delete(a, item);

			if (deleted) {
				System.out.println("\nThe heapyfied array a after removing the item: ");
				for (int x = 0; x <= items; x++)
					System.out.print(a[x] + " ");
			} else
				System.out.println("\nItem not found");
		} while (item >= 0);

	}

	public static void heapify(int[] a) {
		// last index in the array

		int start = (items) / 2;

		while (start >= 0) {

			moveDown(a, start);
			// decrement to the next lowest parent node
			start--;
		}
		// after sifting down the root all nodes/elements
		// are in heap order
	}

	public static void moveDown(int[] a, int start) {
		int root = start;
		// while the root has at least one child
		while ((2 * root + 1) <= items) {
			// start with the left child if its there
			int child = 2 * root + 1;
			if (child + 1 <= items && a[child] < a[child + 1]) {
				child = child + 1;
			}

			// if child is greater than root swap them
			if (a[root] < a[child]) {
				int tmp = a[root];
				a[root] = a[child];
				a[child] = tmp;

				root = child;
			} else {
				return;
			}
		} // End while
	}

	// deletes the item requested to be deleted
	static boolean delete(int[] a, int item) {
		int i = 0;
		boolean found = false;
		for (i = 0; i < a.length; i++) {
			if (a[i] == item) {
				found = true;
				break;
			}
		}
		// if the item is in the array
		if (found) {
			int tmp = a[items];
			a[items] = a[i];
			a[i] = tmp;
			// shrink the array lenght
			--items;

			heapify(a);
		}

		return found;
	}

}