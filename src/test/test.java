package test;

import java.util.LinkedList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		
		List<String> result = choose("1234567890qwertyuiopasdfghjklzxcv", 6);
		
		//List<String> result2 = choose("1234567890qwertyuiopasdfghjklzxcv", 6);
		//System.out.println(result.toString());
		System.out.println(result.size()*16);
		

	}
	
//	public static List<String> choose(String target, int num) {
//		 
//	    List<String> resultList = new LinkedList<>();
//	 
//	    if (num > target.length()) {
//	        return resultList;
//	    }
//	    if (num == target.length()) {
//	        resultList.add(target);
//	        return resultList;
//	    }
//	    // ��target���֣�0 ~ bound - 1��bound ~ end��
//	    int bound = target.length() / 2;
//	    String left = target.substring(0, bound);
//	    String right = target.substring(bound, target.length());
//	    // Ҫѡ���num��Ԫ�ؿ���ȫ������left
//	    resultList.addAll(choose(left, num));
//	    // ����ȫ������right
//	    resultList.addAll(choose(right, num));
//	    // �������߶��У���ʱ��num�����֣�num = l + r��l��ʾ����left��Ԫ�صĸ�����r��ʾ����right��Ԫ�صĸ�����
//	    for (int l = 1; l < num; l++) {
//	        int r = num - l;
//	        // ��left����ѡl��Ԫ��
//	        List<String> fromLeftList = choose(left, l);
//	        // ��right����ѡr��Ԫ��
//	        List<String> fromRightList = choose(right, r);
//	        // �������
//	        for (String fromLeft : fromLeftList) {
//	            for (String fromRight : fromRightList) {
//	                // ��ӵ����������
//	                resultList.add(fromLeft + fromRight);
//	            }
//	        }
//	    }
//	    return resultList;
//	}
	
	public static List<String> choose(String target, int m) {
	    List<String> resultList = new LinkedList<>();
	    doChoose(resultList, target, "", m, 0);
	    return resultList;
	}
	 
	private static void doChoose(List<String> resultList, String target, String resultStr, int m, int head) {
	 
	    // �ݹ�ͷ
	    if (resultStr.length() == m) {
	        resultList.add(resultStr);
	        return;
	    }
	 
	    // �ݹ���
	    for (int i = head; i < target.length(); i++) {
	        doChoose(resultList, target, resultStr + target.charAt(i), m, i+1);
	    }
	}

}
