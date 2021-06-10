package ua.lviv.lgs;

public interface Iterator {
	public boolean hasNext();
	public Integer next();
}

class Collection {
	private static Integer[] arr;

	Collection(Integer[] arr) {
		Collection.arr = arr;
	}

	public class Forward implements Iterator {

		private int count = 0;

		@Override
		public boolean hasNext() {
			return count < arr.length;
		}

		@Override
		public Integer next() {
			return arr[count++];
		}

	}

	public Forward createForward() {
		return new Forward();
	}

	public class Backward implements Iterator {
		private int count = arr.length - 1;

		@Override
		public boolean hasNext() {
			return count >= 0;
		}

		@Override
		public Integer next() {
			count = count - 2;
			return arr[count + 2];
		}
	}

	public Backward createBackward() {
		return new Backward();
	}

	public Iterator createAnonymousIterator() {
		return new Iterator() {
			private int count = arr.length - 1;

			@Override
			public boolean hasNext() {
				return count >= 0;
			}

			@Override
			public Integer next() {
				return arr[count--];
			}
		};
	}

	public Iterator createLocalIterator() {
		class LocalIterator implements Iterator {

			private int count = 0;

			@Override
			public boolean hasNext() {
				return count < arr.length;
			}

			@Override
			public Integer next() {
				return arr[count++];
			}
		}

		return new LocalIterator();
	}

	static class StaticIterator implements Iterator {
		private int count = 0;

		@Override
		public boolean hasNext() {
			return count < arr.length;
		}

		@Override
		public Integer next() {
			return arr[count++];
		}
	}

	static StaticIterator createStaticIterator() {
		return new StaticIterator();
	}
}
