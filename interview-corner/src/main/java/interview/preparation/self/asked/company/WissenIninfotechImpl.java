package interview.preparation.self.asked.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

import com.design.analysis.company.preparation.model.LNode;
import com.design.analysis.company.preparation.utils.SListUtils;

public class WissenIninfotechImpl implements IWissenIninfotech {

	/**
	 * 1. Add values in map so it map print sorted order based on values if values
	 * match then sort based on the key
	 */

	public Map<String, String> getMapOrderByValues(Map<String, String> map) {

		Map<String, List<String>> treeMap = new TreeMap<>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (treeMap.containsKey(entry.getValue())) {
				List<String> list = treeMap.get(entry.getValue());
				list.add(entry.getKey());
				treeMap.put(entry.getValue(), list);
			} else {
				List<String> list = new ArrayList<>();
				list.add(entry.getKey());
				treeMap.put(entry.getValue(), list);
			}
		}
		Map<String, String> linkedHashMap = new LinkedHashMap<>();
		for (Map.Entry<String, List<String>> entry : treeMap.entrySet()) {
			List<String> list = entry.getValue();
			Collections.sort(list);
			for (int i = 0; i < list.size(); i++)
				linkedHashMap.put(list.get(i), entry.getKey());

		}
		return linkedHashMap;
	}

	public Map<String, String> getMapOrderByValuesX(Map<String, String> map) {
		Map<String, String> linkedHasMap = new LinkedHashMap<>();
		List<Map.Entry<String, String>> list = new LinkedList<Map.Entry<String, String>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				if (o1.getValue().equals(o2.getValue()))
					return (o1.getKey()).compareTo(o2.getKey());
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		for (Map.Entry<String, String> innMap : list) {
			linkedHasMap.put(innMap.getKey(), innMap.getValue());
		}
		return linkedHasMap;
	}

	/* sort by only values only */
	public Map<String, String> getMapOrderByValuesY(Map<String, String> map) {

		return map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	/** 1. Create biggest number from array element using string addition */

	public String getBiggestNumber(int a[]) {

		class BigestInt {
			String num;

			public BigestInt(String num) {
				super();
				this.num = num;
			}

			@Override
			public String toString() {
				return num;
			}

		}

		List<BigestInt> numList = new ArrayList<BigestInt>();
		// comparison algorithm tell before and other each others for decreasing order
		for (int i : a) {
			numList.add(new BigestInt(String.valueOf(i)));
		}

		Collections.sort(numList, new Comparator<BigestInt>() {
			@Override
			public int compare(BigestInt o1, BigestInt o2) {
				String st1 = o1.num;
				String st2 = o2.num;
				int n1 = st1.length();
				int n2 = st2.length();

				int i = 0;
				int j = 0;

				if (st1.equals(st2))
					return 0;
				while (i != n1 && j != n2) {
					if (st1.charAt(i) == st2.charAt(j)) {
						if (i != n1 - 1)
							i++;
						if (j != n2 - 1)
							j++;
					} else {
						return st2.charAt(j) - st1.charAt(i);
					}
				}
				return 0;
			}
		});

		StringBuilder sbr = new StringBuilder();
		for (BigestInt num : numList)
			sbr.append(num.num);
		return sbr.toString();
	}

	@Override
	public String getBiggestNumberX(int a[]) {

		List<String> list = new ArrayList<>();
		for (Integer x : a)
			list.add(String.valueOf(x));
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				if (str1.equals(str2))
					return 0;
				else {
					int n1 = str1.length();
					int n2 = str2.length();
					int i = 0;
					int j = 0;

					while (i != n1 && j != n2) {
						if (str1.charAt(i) == str2.charAt(j)) {
							if (i != n1 - 1)
								i++;
							if (j != n2 - 1)
								j++;
						} else
							return str2.charAt(j) - str1.charAt(i);
					}
				}
				return 0;
			}
		});
		StringBuilder sbr = new StringBuilder();
		for (String num : list)
			sbr.append(num);
		return sbr.toString();
	}

	/**
	 * 3. sum array with performance heaving n thread
	 * 
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public int getSum(Integer a[], int n) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(n);
		Set<Callable<List<Integer>>> callables = new HashSet<Callable<List<Integer>>>();
		int slot = a.length / n;
		for (int i = 0; i < a.length; i += slot) {
			List<Integer> list = Arrays.asList(Arrays.copyOfRange(a, i, i + slot < a.length ? i + slot : a.length));
			callables.add(new Callable<List<Integer>>() {
				public List<Integer> call() throws Exception {
					int chunKsum = 0;
					for (Integer inte : list)
						chunKsum += inte;
					// int chunKsum = list.stream().reduce(0, (a, b) -> a + b);
					List<Integer> listNew = new ArrayList<>();

					listNew.add(chunKsum);
					return listNew;
				}
			});
		}
		List<Future<List<Integer>>> futures = executorService.invokeAll(callables);
		int totalSum = 0;
		for (Future<List<Integer>> future : futures) {
			totalSum += future.get().get(0);
		}
		return totalSum;
	}

	@Override
	public int getSumAX(Integer a[], int n) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(n);

		List<Callable<Integer>> callables = new ArrayList<>();
		int N = a.length;
		int slot = N / n;

		for (int i = 0; i < N; i += slot) {
			List<Integer> list = Arrays.asList(Arrays.copyOfRange(a, i, slot + i < N ? i + slot : N));
			callables.add(new Callable<Integer>() {
				public Integer call() throws Exception {
					int sum = 0;
					for (Integer x : list)
						sum += x;
					return sum;
				}
			});
		}
		int totalSum = 0;
		List<Future<Integer>> futures = executorService.invokeAll(callables);
		for (Future<Integer> future : futures)
			totalSum += future.get();
		return totalSum;

	}

	/** sum array with performance heaving n thread using ForkandJJoin */
	public int getSumX(Integer a[], int n) throws InterruptedException, ExecutionException {

	//	try(ForkJoinPool forkJoinPool = new ForkJoinPool(n)) {
			class RecursiveSumTask extends RecursiveTask<Integer> {
				private static final long serialVersionUID = 1L;
				final int workload;
				final int from;
				final int to;

				public RecursiveSumTask(int from, int to, int workload) {
					this.workload = workload;
					this.from = from;
					this.to = to;
				}

				@Override
				protected Integer compute() {
					if (workload > n) {
						/* creating subtask in some part */
						List<RecursiveSumTask> subTaskList = new ArrayList<>();
						int mid = (from + to) / 2;
						subTaskList.add(new RecursiveSumTask(from, mid, workload / 2));
						subTaskList.add(new RecursiveSumTask(mid, to, workload / 2));
						/*
						 * split/fork to the subtask it recursively call the compute() with current
						 * workload for more splitting
						 */
						for (RecursiveSumTask subTask : subTaskList)
							subTask.fork();

						/* joining the result. it is tail recursion */
						int sum = 0;
						for (RecursiveSumTask subTask : subTaskList)
							sum += subTask.join();
						return sum;
					} else {

						int sum = 0;
						for (int i = from; i < to; sum += a[i], i++)
							;
						return sum;
					}
				}
			}

			RecursiveSumTask rst = new RecursiveSumTask(0, a.length, a.length);
			//return forkJoinPool.invoke(rst);
		//} 
			return 0;
	}

	@Override
	public int getSumY(Integer a[], int n) throws InterruptedException, ExecutionException {
		//try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {

			class ResursiveTaskSum extends RecursiveTask<Integer> {
				private static final long serialVersionUID = 1L;
				private int workload;
				private int from;
				private int to;

				public ResursiveTaskSum(int from, int to, int worload) {
					this.from = from;
					this.to = to;
					this.workload = worload;
				}

				@Override
				protected Integer compute() {
					if (workload > n) {

						List<ResursiveTaskSum> subTaskList = new ArrayList<>();
						int mid = (from + to) / 2;

						subTaskList.add(new ResursiveTaskSum(from, mid, workload / 2));
						subTaskList.add(new ResursiveTaskSum(mid, to, workload / 2));

						// recursively fork till workload come under thread
						for (ResursiveTaskSum subTask : subTaskList)
							subTask.fork();

						int sum = 0;
						//// recursively fork till workload come under thread
						for (ResursiveTaskSum subTask : subTaskList)
							sum += subTask.join();
						return sum;
					} else {
						int sum = 0;
						for (Integer x : a)
							sum += x;
						return sum;
					}
				}

			}
			ResursiveTaskSum rst = new ResursiveTaskSum(0, a.length, a.length);
			//return forkJoinPool.invoke(rst);
		//}
			return 0;
	}

	public int getMaxOrMin(Integer a[], int n, boolean maxOrMin) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(n);
		Set<Callable<List<Integer>>> callables = new HashSet<Callable<List<Integer>>>();
		int slot = a.length / n;
		for (int i = 0; i < a.length; i += slot) {
			List<Integer> list = Arrays.asList(Arrays.copyOfRange(a, i, i + slot < a.length ? i + slot : a.length));
			callables.add(new Callable<List<Integer>>() {
				public List<Integer> call() throws Exception {
					Optional<Integer> maxMinNumber = maxOrMin ? list.stream().max((i, j) -> i.compareTo(j))
							: list.stream().min((i, j) -> i.compareTo(j));
					List<Integer> listNew = new ArrayList<>();
					listNew.add(maxMinNumber.get());
					return listNew;
				}
			});
		}
		List<Future<List<Integer>>> futures = executorService.invokeAll(callables);
		List<Integer> result = new ArrayList<>();
		for (Future<List<Integer>> future : futures) {
			result.add(future.get().get(0));
		}
		return maxOrMin ? result.stream().max((i, j) -> i.compareTo(j)).get()
				: result.stream().min((i, j) -> i.compareTo(j)).get();
	}

	/** max or min number with performance heaving n thread ForkandJJoin */
	public int getMaxOrMinX(Integer a[], int n, boolean maxOrMin) throws InterruptedException, ExecutionException {

		//try (ForkJoinPool forkJoinPool = new ForkJoinPool(n)) {
			class RecursiveMaxMinTask extends RecursiveTask<Integer> {
				private static final long serialVersionUID = 1L;
				final int workload;
				final int from;
				final int to;

				public RecursiveMaxMinTask(int from, int to, int workload) {
					this.workload = workload;
					this.from = from;
					this.to = to;
				}

				@Override
				protected Integer compute() {
					if (workload > n) {
						/* creating subtask in some part */
						List<RecursiveMaxMinTask> subTaskList = new ArrayList<>();
						int mid = (from + to) / 2;
						subTaskList.add(new RecursiveMaxMinTask(from, mid, workload / 2));
						subTaskList.add(new RecursiveMaxMinTask(mid, to, workload / 2));
						/*
						 * split/fork to the subtask it recursively call the compute() with current
						 * workload for more splitting
						 */
						for (RecursiveMaxMinTask subTask : subTaskList)
							subTask.fork();

						/* joining the result. it is tail recursion */
						List<Integer> subResultList = new ArrayList<Integer>();
						for (RecursiveMaxMinTask subTask : subTaskList)
							subResultList.add(subTask.join());

						return maxOrMin ? subResultList.stream().max((i, j) -> i.compareTo(j)).get()
								: subResultList.stream().min((i, j) -> i.compareTo(j)).get();
					} else {
						List<Integer> list = Arrays.asList(Arrays.copyOfRange(a, from, to));
						return maxOrMin ? list.stream().max((i, j) -> i.compareTo(j)).get()
								: list.stream().min((i, j) -> i.compareTo(j)).get();
					}
				}
			}
			RecursiveMaxMinTask rst = new RecursiveMaxMinTask(0, a.length, a.length);
			//return forkJoinPool.invoke(rst);
		//}
			return 0;
	}

	/** 5 find intersection node, node value may be duplicate */
	public LNode getInterSectionNode(LNode x, LNode y) {
		int l1 = SListUtils.length(x);
		int l2 = SListUtils.length(y);
		int d = Math.abs(l1 - l2);
		if (l1 > l2) {
			while (d != 0) {
				x = x.next;
				d--;
			}
		} else {
			while (d != 0)
				y = y.next;
			d--;
		}
		while (x.compareTo(y) != 0) {
			x = x.next;
			y = y.next;
		}
		return x;
	}

	/** 5 find start circular node */
	public LNode getCirculrPointNode(LNode x) {
		Set<LNode> set = new HashSet<>();
		while (!Objects.isNull(x)) {
			if (set.contains(x)) {
				return x;
			} else {
				set.add(x);
				x = x.next;
			}
		}
		return x;
	}

	// 2022 interview
	// chunk array of all possible size
	public void chunkArray(int ar[]) {

		for (int i = 1; i <= ar.length; i++) {
			chuncking(ar, i);
		}
	}

	public void chuncking(int ar[], int size) {
		int index = 0;
		while (index < ar.length) {
			List<Integer> l = new ArrayList<>();
			for (int i = index; i < index + size && i < ar.length; i++)
				l.add(ar[i]);
			System.out.println(l);
			index += size;
		}
	}

	@Override
	public List<int[]> splitArray(int ar[], int splitSize) {
		int n = ar.length;
		List<int[]> lla = new ArrayList<>();

		int index = 0;
		int k;
		while (index < n) {
			int arSize = (n - index) >= splitSize ? splitSize : n - index;
			int a[] = new int[arSize];
			k = 0;
			for (int i = 0; i < arSize; i++) {
				a[k++] = ar[i + index];
			}
			lla.add(a);
			index += splitSize;
		}
		return lla;
	}

	@Override
	public String commonCharacters(String a, String b) {

		StringBuilder sb = new StringBuilder();

		int x[] = new int[26];
		int y[] = new int[26];
		char ach[] = a.toCharArray();
		char bch[] = b.toCharArray();

		for (int i = 0; i < a.length(); x[ach[i] - 97]++, i++)
			;

		for (int i = 0; i < b.length(); y[bch[i] - 97]++, i++)
			;

		for (int i = 0; i < 26; i++) {
			if (x[i] != 0 && y[i] != 0) {
				int size = x[i] == y[i] ? x[i] : (x[i] > y[i] ? y[i] : x[i]);

				for (int j = 0; j < size; j++) {
					sb.append((char) (i + 97));
				}

			}
		}
		return sb.toString();
	}

	public Map<String, String> getMapOrderByValuesThenByKey(Map<String, String> map) {
		return

		map.entrySet().stream()
				.sorted(Map.Entry.<String, String>comparingByValue()
						.thenComparing(Map.Entry.<String, String>comparingByKey()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	@Override
	public void createTwoTread() throws InterruptedException {

		Runnable t1 = () -> {
			System.out.println("Th1");
			for (int i = 0; i <= 100; i++) {

				System.out.println("Th1- " + i);
			}
		};
		Runnable t2 = () -> {
			System.out.println("Th2");
			for (int i = 0; i <= 100; i++) {

				System.out.println("Th2- " + i);
			}
		};

		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);
		th1.start();
		th1.join();
		th2.start();

	}

	// 2023 interview question
	@Override
	public List<int[]> splitArrayOfNSize(int a[], int ns) {

		List<int[]> rl = new ArrayList<>();

		int N = a.length;
		int k = 0;
		for (int i = 0; i < N; k = 0, i += ns) {
			int size = N - i >= ns ? ns : N - i;
			int x[] = new int[size];
			while (size-- > 0) {
				x[k] = a[i + k];
				k++;
			}
			rl.add(x);
		}
		return rl;
	}

	// Convert Snake Case string to Camel Case geeks_for_geeks” Output:
	// GeeksForGeeks
	@Override
	public String snakeToCamel(String str) {

		int N = str.length();
		char chrA[] = str.toLowerCase().toCharArray();
		StringBuilder sb = new StringBuilder();
		sb.append(Character.toUpperCase(chrA[0]));

		for (int i = 1; i < N; i++) {
			if (chrA[i] == '_') {
				sb.append(Character.toUpperCase(chrA[i + 1]));
				i++;
				continue;
			}
			sb.append(chrA[i]);
		}
		return sb.toString();
	}

	@Override
	public String camelToSnake(String str) {
		int N = str.length();
		char chrA[] = str.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			if (chrA[i] >= 65 && chrA[i] <= 90) {
				sb.append("_");
				sb.append(Character.toLowerCase(chrA[i]));
				continue;
			}
			sb.append(chrA[i]);
		}
		return sb.toString();
	}

//0 special, 1 constlower,2 volwel lowr, 3, constupper, 4 vowel upper, 5 for numeric
	@Override
	public Map<Integer, List<Character>> segerateChars(String str) {
		List<Character> loVowels = List.of('a', 'e', 'i', 'o', 'u');
		List<Character> upVowels = List.of('A', 'E', 'I', 'O', 'U');
		int l = str.length();
		char chrs[] = str.toCharArray();
		Map<Integer, List<Character>> map = new HashMap<>();

		for (int i = 0; i < l; i++) {
			char ch = chrs[i];
			if (ch >= 48 && ch <= 57)
				putMap(map, ch, 5);
			else if (ch >= 65 && ch <= 90) {
				if (upVowels.contains(ch))
					putMap(map, ch, 4);
				else
					putMap(map, ch, 3);
			} else if (ch >= 97 && ch <= 122) {
				if (loVowels.contains(ch))
					putMap(map, ch, 2);
				else
					putMap(map, ch, 1);
			} else {
				putMap(map, ch, 0);
			}
		}
		return map;
	}

	@Override
	public void putMap(Map<Integer, List<Character>> map, char ch, int key) {
		if (map.containsKey(key)) {
			List<Character> chr = map.get(key);
			chr.add(ch);
			map.put(key, chr);

		} else {
			List<Character> chr = new ArrayList<>();
			chr.add(ch);
			map.put(key, chr);
		}
	}

	// check a string is permutation of palindrome
	@Override
	public boolean isPermutationOfPalindrome(String str) {

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else
				map.put(ch, 1);
		}
		int oddCount = 0;
		for (Map.Entry<Character, Integer> set : map.entrySet()) {
			if (set.getValue() % 2 == 1) {
				oddCount++;
				if (oddCount > 1)
					return false;
			}
		}
		return true;
	}
}
