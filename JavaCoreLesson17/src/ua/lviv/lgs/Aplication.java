package ua.lviv.lgs;

public class Aplication {
	public static void main(String[] args) {

	Integer[] arr = { 5, 26, 12, -150, 10, 41, 53, 4, 0, 77, 88 };
	Collection collection = new Collection(arr);

	System.out.println("The array from start to finish, replacing odd elements with null: ");
	Iterator iteratorForward = collection.createForward();

	while(iteratorForward.hasNext())
	{
		Integer next = iteratorForward.next();

		if (next % 2 != 0) {
			System.out.println("null");
		} else
			System.out.println(next);
	}

	System.out.println();

	System.out.println("The value of the array from the last to the first: ");
	Iterator iteratorBackward = collection.createBackward();

	while(iteratorBackward.hasNext())
	{
		Integer next = iteratorBackward.next();

		System.out.println(next);
	}

	System.out.println();

	System.out.println("Every third odd element of the array from end to beginning: ");
	Iterator iteratorAnonymous = collection.createAnonymousIterator();

	int i = 1;while(iteratorAnonymous.hasNext())
	{
		Integer next = iteratorAnonymous.next();

		if (i % 3 == 0) {
			if (next % 2 != 0) {
				System.out.println(next);
			}
		}

		i++;
	}

	System.out.println();

	System.out.println("Every fifth paired element minus 100 arrays from start to finish: ");
	Iterator iteratorLocal = collection.createLocalIterator();

	int j = 1;
	while(iteratorLocal.hasNext())
	{
		Integer next = iteratorLocal.next();

		if (j % 5 == 0) {
			if (next % 2 == 0) {
				System.out.println(next - 100);
			}
		}

		j++;
	}

	System.out.println();

	System.out.println("Every second element is odd: ");
	Iterator iteratorStatic = Collection.createStaticIterator();

	int k = 1;while(iteratorStatic.hasNext())
	{
		Integer next = iteratorStatic.next();

		if (k % 2 == 0) {
			if (next % 2 == 0) {
				System.out.println(next + 1);
			}
		}

		k++;
	}

}
}

