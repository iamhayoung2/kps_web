package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import model.domain.PremiumMarketBean;
import model.domain.PriceMarketBean;
import service.currency.CurrencyKRWUSD;
import service.currentAbroad.CurBinance;
import service.currentAbroad.CurBitFinex;
import service.currentAbroad.CurBittrex;
import service.currentAbroad.CurGdax;
import service.currentAbroad.CurKraken;
import service.currentKor.CurBitthum;
import service.currentKor.CurCoinone;
import service.currentKor.CurUpbit;
import util.KRWMarketNameNumber;
import util.PreminumCalCulate;
import util.USDMarketNameNumber;

public class PremiumDAO {
	static float currency = 0;
	static ArrayList<PriceMarketBean> krwList = new ArrayList<>();
	static ArrayList<PriceMarketBean> usdList = new ArrayList<>();
	static ArrayList<PremiumMarketBean> preList = new ArrayList<>();
	static ArrayList<PremiumMarketBean> sortedPreList = new ArrayList<>();
	static ScheduledExecutorService service = null;
	static Runnable runnable = null;
	static {
		for(int i = 0 ; i < 3;i++) {
			krwList.add(new PriceMarketBean());
		}
		for(int i = 0 ; i < 5;i++) {
			usdList.add(new PriceMarketBean());
		}
		startCRW();
	}
	public static void startCRW() {
		runnable = new Runnable() {
			public void run() {
					calPremiumLists();
				}
			};
			service = Executors.newSingleThreadScheduledExecutor();
			service.scheduleWithFixedDelay(runnable, 0, 5, TimeUnit.SECONDS);
	}
	public static void printLists() {
		System.out.println(System.currentTimeMillis());
		for(int i = 0 ; i <krwList.size(); i++) {
			System.out.println(krwList.get(i));
		}
		for(int j = 0 ; j <usdList.size(); j++) {
			System.out.println(usdList.get(j));
		}
		System.out.println(currency);
	}
	
	public static void stopCRW() {
		service.shutdownNow();
		service=null;
		runnable=null;
	}
	public static void calPremiumLists() {
		getKrwList();
		getUsdList();
		getCurrency();
		pushDB();
		calculatePremium();
	}
	
	private static void pushDB() {
		// TODO Auto-generated method stub
		int curTime = (int) (System.currentTimeMillis()/1000);
		float pre = PreminumCalCulate.getPreminum(krwList.get(KRWMarketNameNumber.Bitthum).getValue(),
				usdList.get(USDMarketNameNumber.BitFinex).getValue(), currency);
		if(pre!= 100) {
		BitCoinDAO.addBitCoinPremium(curTime, pre);
		}
	}

	public static void getKrwList() {
		try {
			krwList.set(KRWMarketNameNumber.Bitthum,new PriceMarketBean(CurBitthum.getPrice()));
			krwList.set(KRWMarketNameNumber.Coinone,new PriceMarketBean(CurCoinone.getPrice()));
			krwList.set(KRWMarketNameNumber.Upbit,new PriceMarketBean(CurUpbit.getPrice()));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("한국 거래소 실패");
		}
	}
	public static void getUsdList() {
		try {
			usdList.set(USDMarketNameNumber.Binance, new PriceMarketBean(CurBinance.getPrice()));
			usdList.set(USDMarketNameNumber.BitFinex, new PriceMarketBean(CurBitFinex.getPrice()));
			usdList.set(USDMarketNameNumber.Bittrex, new PriceMarketBean(CurBittrex.getPrice()));
			usdList.set(USDMarketNameNumber.Gdax, new PriceMarketBean(CurGdax.getPrice()));
			usdList.set(USDMarketNameNumber.Kraken, new PriceMarketBean(CurKraken.getPrice()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("외국 거래소 코인 가져오는데 실패");
		}
	}
	public static void getCurrency() {
		try {
			currency = CurrencyKRWUSD.getPrice();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("환율 가져오는데 실패");
			currency = 1000;
		}
	}
	public static void calculatePremium() {
		preList = new ArrayList<>();
		sortedPreList = new ArrayList<>();
		for(int i  = 0 ; i < usdList.size(); i++) {
			for(int j = 0 ; j <krwList.size(); j++) {
				float pre = PreminumCalCulate.getPreminum(krwList.get(j).getValue(), usdList.get(i).getValue(), currency);
				preList.add(new PremiumMarketBean(pre,KRWMarketNameNumber.getName(j), USDMarketNameNumber.getName(i)));
				sortedPreList.add(new PremiumMarketBean(pre,KRWMarketNameNumber.getName(j), USDMarketNameNumber.getName(i)));
			}
		}
		sortList();
	}
	private static void sortList() {
		// TODO Auto-generated method stub
		Collections.sort(sortedPreList, new Comparator<PremiumMarketBean>() {
			@Override
			public int compare(PremiumMarketBean o1, PremiumMarketBean o2) {
				// TODO Auto-generated method stub
				if(o1.getValue() > o2.getValue()) {
					return -1;
				}else if(o1.getValue() <o2.getValue()) {
					return 1;
				}else {
					return 0;
				}
			}
		});
	}
	public static ArrayList<PremiumMarketBean>getPreList() {
		return preList;
	}
	public static ArrayList<PremiumMarketBean>getSortedPreList() {
		return sortedPreList;
	}
	public static ArrayList<PriceMarketBean> getKrwListArray(){
		return krwList;
	}
	public static ArrayList<PriceMarketBean> getUsdListArray(){
		return usdList;
	}
	public static float getCurrencyValue() {
		return currency;
	}
}
