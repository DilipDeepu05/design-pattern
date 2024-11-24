package com.strategy.pattern;

interface SortingStreagy {
	void sort(int[] a);
}

class BubbleSorting implements SortingStreagy {

	@Override
	public void sort(int[] a) {
		System.out.println("Bubble sorting");
	}
}

class MergeSorting implements SortingStreagy {

	@Override
	public void sort(int[] a) {
		System.out.println("Merge sorting");
	}
}

class SortingContext {
	SortingStreagy s;

	public void setSortingStreagy(SortingStreagy s) {
		this.s = s;
	}

	public void performSort(int[] array) {
        s.sort(array);
    }
}

class StrategyPatternDemo {

	public static void main(String[] args) {
		SortingContext s = new SortingContext();
		s.setSortingStreagy(new BubbleSorting());
		s.performSort(new int []{0,1});
	}

}
