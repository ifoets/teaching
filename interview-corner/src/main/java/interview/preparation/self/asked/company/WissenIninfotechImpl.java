package interview.preparation.self.asked.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
	
	int val  = 10;
    public static void main(String[] args) {
    	WissenIninfotechImpl obj = new WissenIninfotechImpl();
        System.out.println(obj.val);
    }

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
			if (list.size() > 1) {
				Collections.sort(list);
				for (int i = 0; i < list.size(); i++)
					linkedHashMap.put(list.get(i), entry.getKey());
			}
			linkedHashMap.put(entry.getValue().get(0), entry.getKey());

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

	/** sum array with performance heaving n thread using ForkandJJoin */
	public int getSumX(Integer a[], int n) throws InterruptedException, ExecutionException {

		ForkJoinPool forkJoinPool = new ForkJoinPool(n);
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
		return forkJoinPool.invoke(rst);
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

		ForkJoinPool forkJoinPool = new ForkJoinPool(n);
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
		return forkJoinPool.invoke(rst);
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
}
