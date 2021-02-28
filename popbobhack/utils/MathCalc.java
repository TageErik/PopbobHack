package popbobhack.utils;
import net.minecraft.src.Minecraft;
import net.minecraft.src.MathHelper;

public class MathCalc {
	public static int OperatorPlacement = 0;
	public static int[] ClosestOperators2 = new int[2];
	public static double[] Numbers = new double[2];
	public static void DoMath(String Math) {
		String OriginalQuestion = Math;
		while(Math.contains("(")) {
			String Math2 = Math.substring(Math.lastIndexOf("(") + 1, Math.substring(Math.lastIndexOf("(")).indexOf(")") + Math.lastIndexOf("("));
			Math = Math.substring(0, Math.lastIndexOf("(")) + AfterParenthesis(Math2) + Math.substring(Math.substring(Math.lastIndexOf("(")).indexOf(")") + Math.lastIndexOf("(") + 1);
		}
		Math = AfterParenthesis(Math);
		if(Double.parseDouble(Math) < 10000000D && Double.parseDouble(Math) > -10000000D) {
			if(Double.parseDouble(Math) == Double.parseDouble(Math.substring(0,Math.length() - 2))) {
				Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> " + OriginalQuestion + "=" + Math.substring(0, Math.length() - 2));
			} else {
				Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> " + OriginalQuestion + "=" + Math);
			}
			} else {
				Minecraft.getMinecraft().thePlayer.addChatMessage("<popbob> " + OriginalQuestion + "=" + Math);
			}
	}
	
	public static String AfterParenthesis(String Math) {
		Math = Math.replaceAll(" ", "");
		while(Math.contains("/")) {
			OperatorPlacement = Math.indexOf("/") + 1;
			ClosestOperators2 = FindClosestOperatorsToOperator(Math, OperatorPlacement);
			Numbers = new double[2];
			Numbers[0] = Double.parseDouble(Math.substring(ClosestOperators2[0] + 1,OperatorPlacement - 1));
			Numbers[1] = Double.parseDouble(Math.substring(OperatorPlacement, ClosestOperators2[1] - 1 + OperatorPlacement + 1));
			Math = Math.substring(0, ClosestOperators2[0] + 1) + Divide(Numbers) + Math.substring(ClosestOperators2[1] + OperatorPlacement);
			}
		while(Math.contains("*")) {
			OperatorPlacement = Math.indexOf("*") + 1;
			ClosestOperators2 = FindClosestOperatorsToOperator(Math, OperatorPlacement);
			Numbers = new double[2];
			Numbers[0] = Double.parseDouble(Math.substring((int) (ClosestOperators2[0] + 1),OperatorPlacement - 1));
			Numbers[1] = Double.parseDouble(Math.substring(OperatorPlacement, (int) (ClosestOperators2[1] - 1 + OperatorPlacement + 1)));
			Math = Math.substring(0, ClosestOperators2[0] + 1) + Multiply(Numbers) + Math.substring(ClosestOperators2[1] + OperatorPlacement);
		}
		while(Math.contains("+")) {
			OperatorPlacement = Math.indexOf("+") + 1;
			ClosestOperators2 = FindClosestOperatorsToOperator(Math, OperatorPlacement);
			Numbers = new double[2];
			Numbers[0] = Double.parseDouble(Math.substring(ClosestOperators2[0] + 1,OperatorPlacement - 1));
			Numbers[1] = Double.parseDouble(Math.substring(OperatorPlacement, ClosestOperators2[1] - 1 + OperatorPlacement + 1));
			Math = Math.substring(0, ClosestOperators2[0] + 1) + Add(Numbers) + Math.substring(ClosestOperators2[1] + OperatorPlacement);
			}
		while(Math.substring(1).contains("-")) {
				OperatorPlacement = Math.indexOf("-")+ 1;
				ClosestOperators2 = FindClosestOperatorsToOperator(Math, OperatorPlacement);
				Numbers = new double[2];
				Numbers[0] = Double.parseDouble(Math.substring(ClosestOperators2[0] + 1,OperatorPlacement - 1));
				Numbers[1] = Double.parseDouble(Math.substring(OperatorPlacement, ClosestOperators2[1] - 1 + OperatorPlacement + 1));
				Math = Math.substring(0, ClosestOperators2[0] + 1) + Subtract(Numbers) + Math.substring(ClosestOperators2[1] + OperatorPlacement);
			}
		return Math;
	}
	
	public static int[] FindClosestOperatorsToOperator(String Math, int OGOperatorPlacement) {
		String Below = Math.substring(1, OGOperatorPlacement - 1);
		String Above = Math.substring(OGOperatorPlacement);
		int ClosestBelow = Integer.max(Below.lastIndexOf("*"), Below.lastIndexOf("/"));
		ClosestBelow = Integer.max(ClosestBelow, Below.lastIndexOf("+"));
		ClosestBelow = Integer.max(ClosestBelow, Below.lastIndexOf("-"));
		
		int ClosestAbove = Integer.min(Above.indexOf("*"), Above.indexOf("/"));
		if(!Above.contains("*")) {
			ClosestAbove = Above.indexOf("/");
		}
		if(!Above.contains("/")) {
			ClosestAbove = Above.indexOf("*");
		}
		if(ClosestAbove == -1) {
			ClosestAbove = Integer.MAX_VALUE;
		}
		if(Above.contains("+")) {
			ClosestAbove = Integer.min(ClosestAbove, Above.indexOf("+"));
		}
		if(ClosestAbove == -1) {
			ClosestAbove = Integer.MAX_VALUE;
		}
		String Above2 = Above;
		if(Above2.contains("-")) {
			while(isNegativeNumber(Above2, Above2.indexOf("-")) && Above2.contains("-")) {
				Above2 = Above2.substring(Above2.indexOf("-") + 1);
			}
			if(Above2.contains("-")) { 
				ClosestAbove = Integer.min(ClosestAbove, Above2.indexOf("-") + Above.length() - Above2.length() + 1);
			}
		}
		System.out.println(Above);
		
		if(ClosestBelow == -1) {
			ClosestBelow = -2;
		}
		if(ClosestAbove == -1 || ClosestAbove > 10000000) {
			ClosestAbove = Above.length();
		}
		int[] ClosestOperators = new int[2];
		ClosestOperators[0] = ClosestBelow + 1;
		ClosestOperators[1] = ClosestAbove;
		return ClosestOperators;
	}
	
	public static double Multiply(double[] numbers2) {
		double answer = 1;
		for(int i = 0; i < numbers2.length; i++) {
			answer *= numbers2[i];
		}
		return answer;
	}
	
	public static double Divide(double[] numbers) {
		double answer = numbers[0];
		for(int i = 1; i < numbers.length; i++) {
			answer /= numbers[i];
		}
		return answer;
	}
	
	public static double Add(double[] numbers) {
		double answer = 0;
		for(int i = 0; i < numbers.length; i++) {
			answer += numbers[i];
		}
		return answer;
	}
	
	public static double Subtract(double[] numbers) {
		double answer = (double) numbers[0];
		for(int i = 1; i < numbers.length; i++) {
			answer -= numbers[i];
		}
		return answer;
	}
	
	public static boolean isNegativeNumber(String Math, int minusPlacement) {
		if(Math.indexOf("-") == 0) {
			return true;
			}
		return false;
	}
	
}