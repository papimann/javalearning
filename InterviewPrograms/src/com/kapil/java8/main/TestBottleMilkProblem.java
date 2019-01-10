package com.kapil.java8.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestBottleMilkProblem {
	static class BottleData {

		private int bottleNumber;

		private long volume;

		private long price;

		private double pricePerVolume;

		public int getBottleNumber() {
			return bottleNumber;
		}

		public void setBottleNumber(int bottleNumber) {
			this.bottleNumber = bottleNumber;
		}

		public long getVolume() {
			return volume;
		}

		public void setVolume(long volume) {
			this.volume = volume;
		}

		public long getPrice() {
			return price;
		}

		public void setPrice(long price) {
			this.price = price;
		}

		public double getPricePerVolume() {
			return pricePerVolume;
		}

		public void setPricePerVolume(double pricePerVolume) {
			this.pricePerVolume = pricePerVolume;
		}

		public String toString() {
			return (bottleNumber + "_" + volume + "_" + pricePerVolume);
		}

		public int hashCode() {
			return (bottleNumber + "_" + volume + "_" + pricePerVolume).hashCode();
		}

		BottleData(int number, long vol, long p) {
			bottleNumber = number;
			volume = vol;
			price = p;
			pricePerVolume = (double) ((double) p / vol);
		}

	}

	public static void main(String[] args) {

		int no_types = 1;

		long requireAmount = 1;

		Scanner sc = new Scanner(System.in);

		String line1 = sc.nextLine();

		String line2 = sc.nextLine();

		sc.close();

		String[] data = line1.split(" ");

		no_types = Integer.parseInt(data[0]);
		requireAmount = Long.parseLong(data[1]);

		List<Long> costs = new ArrayList<Long>(no_types);

		for (String token : line2.split(" ")) {
			costs.add(Long.parseLong(token));
		}

		List<BottleData> bottleList = new ArrayList<>(costs.size());

		for (int n = 1; n <= no_types; n++) {
			Double vol = Math.pow(2, n - 1);
			BottleData bData = new BottleData(n, vol.longValue(), costs.get(n - 1));
			bottleList.add(bData);
		}

		Map<BottleData, Integer> result = new HashMap<BottleData, Integer>();

		deduceData(bottleList, requireAmount, result);
		System.out.println("====================Greedy choice==> ");

		long cost = 0;
		long volume = 0;
		for (Map.Entry<BottleData, Integer> b : result.entrySet()) {
			BottleData bottle = b.getKey();
			volume += bottle.getVolume() * b.getValue();
			System.out.print("bottle#: " + bottle.getBottleNumber() + "==>" + b.getValue() + " ==Volume==> "
					+ bottle.getVolume() * b.getValue());
			System.out.println();
			cost += b.getValue() * bottle.getPrice();
		}

		System.out.println("volume==> " + volume + " cost==> " + cost);
	}

	static class TestComparator implements Comparator<BottleData> {

		@Override
		public int compare(BottleData o1, BottleData o2) {
			if (o1.getPricePerVolume() == o2.getPricePerVolume()) {
				if (o1.getVolume() < o2.getVolume()) {
					return 1;
				} else {
					return -1;
				}
			} else if (o1.getPricePerVolume() > o2.getPricePerVolume()) {
				return 1;
			} else {
				return -1;
			}
		}

	}

	/**
	 * @param result1
	 * @param bData
	 * @param result
	 */
	static private void minimumValue(Map<BottleData, Integer> result1, BottleData bData,
			Map<BottleData, Integer> result) {
		int price = 0;
		for (Map.Entry<BottleData, Integer> b : result1.entrySet()) {
			BottleData bottle = b.getKey();
			price += bottle.price * b.getValue();
		}

		if (price < bData.getPrice()) {
			result.putAll(result1);
		} else {
			result.put(bData, 1);
		}
	}

	/**
	 * @param bottleList
	 * @param requireAmount
	 * @param result
	 */
	static void deduceData(List<BottleData> bottleList, long requireAmount, Map<BottleData, Integer> result) {

		// sort the bottle based on price
		Collections.sort(bottleList, new TestComparator());
		BottleData bData = bottleList.get(0);

		if (requireAmount < bData.getVolume()) {
			Map<BottleData, Integer> result1 = new HashMap<BottleData, Integer>();
			List<BottleData> newBottleList = new ArrayList<>();
			for (BottleData b : bottleList) {
				if (b.getBottleNumber() != bData.getBottleNumber()) {
					if (b.getVolume() < bData.getVolume()) {
						newBottleList.add(b);
					}
				}
			}

			if (newBottleList.size() > 0) {
				deduceData(newBottleList, requireAmount, result1);
				minimumValue(result1, bData, result);
			} else {
				result.put(bData, 1);
			}

		} else {

			int count = (int) requireAmount / (int) bData.getVolume();
			int remainder = (int) requireAmount % (int) bData.getVolume();

			result.put(bData, count);

			if (remainder != 0) {
				List<BottleData> newBottleList = new ArrayList<>();
				for (BottleData b : bottleList) {
					if (b.getBottleNumber() != bData.getBottleNumber()) {
						if (b.volume < bData.volume) {
							newBottleList.add(b);
						}
					}
				}
				if (newBottleList.size() > 0) {
					deduceData(newBottleList, remainder, result);
				}

			}
		}
	}

}
