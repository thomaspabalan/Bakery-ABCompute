// helper class, what actually handles the items
// all methods assume inputs are valid
// this is fine since the main class handles
// error correction and the like

package caseStudy;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileReader;

public class CaseStudyG51ACompute {

	static List<String> bread = new ArrayList<>();
    static List<Double> price = new ArrayList<>();
    static List<Integer> stock = new ArrayList<>();
    static File dir = new File(System.getProperty("user.dir").concat("\\userfiles\\"));
    static int orderTotal;
    static int itemsSold;
    static double totalSold;
    static String name; 
    static String[][] convert2D;
    static List<Integer> itemOrdered = new ArrayList<>();
    static List<Integer> quantityOrdered = new ArrayList<>();;
    static double pay;
    static double total;
	
	static void orderUI(int inp1Num, int inp2Quant) {
		
		itemOrdered.add(inp1Num);
		total += price.get(inp1Num -1) * inp2Quant;
		totalSold += total;
		quantityOrdered.add(inp2Quant);
		stock.set(inp1Num - 1, stock.get(inp1Num - 1) - inp2Quant);
		itemsSold += inp2Quant;
		
	}

    static void addItem(String inp1, double inp2, int inp3) {
    	
    	bread.add(inp1);
    	price.add(inp2);
    	stock.add(inp3);

    }

    static void removeItem(int num) {
        
    	bread.remove(num - 1);
    	price.remove(num - 1);
    	stock.remove(num - 1);

    }

    static void addStock(int index, int num) {
        
    	int temp = stock.get(index - 1);
    	stock.set(index - 1, num + temp);
    	
    }

    static boolean intCheck(String val) {

        try {
            Integer.parseInt(val);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    static boolean doubleCheck(String val) {

        try {
            Double.parseDouble(val);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    static void defaultFile() {
    	
    	bread.clear();
    	price.clear();
    	stock.clear();

        String[] breadOG = {"Cheese Bread", "Ensaymada", "Ham and Cheese", "Hopia", "Monay", "Pan De Coco",
			"Pandesal", "Spanish Bread", "Putok", "Tasty"};
        double[] priceOG = {7, 6, 6, 5, 5, 5, 3, 5, 5, 7};
        int[] stockOG = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100};

        for (int x = 0; x < breadOG.length; x++) {
            bread.add(breadOG[x]);
            price.add(priceOG[x]);
            stock.add(stockOG[x]);
        }

        orderTotal = 0;
        itemsSold = 0;
        totalSold = 0.0;

    }

    static String saveFile(String namePath) {
        List<Double> salesReport = new ArrayList<>();

        salesReport.add((double) orderTotal);
        salesReport.add((double) itemsSold);
        salesReport.add(totalSold);
        PrintWriter output = null;

        try {

        	output = new PrintWriter(namePath);
        	output.println(bread);
            output.println(price);
            output.println(stock);
            output.println(salesReport);
            return "File successfully saved!";
            
        } catch (Exception e) {
            return "Error saving.";
        } finally {
        	output.close();
        }


    }

    static String openFile(String namePath) {
		
		bread.clear();
		price.clear();
		stock.clear();

        String breadTemp;
        String priceTemp;
        String stockTemp;
        String reportTemp;
        String[] breadTempArr;
        String[] priceTempArr;
        String[] stockTempArr;
        String[] reportTempArr;
        FileReader reader = null;
        Scanner read = null;

        try {

        	reader = new FileReader(namePath);
            read = new Scanner(reader);
            breadTemp = read.nextLine();
            breadTemp = breadTemp.substring(1, breadTemp.length() - 1);
            breadTempArr = breadTemp.split(", ");
            for (int x = 0; x < breadTempArr.length; x++) {
                bread.add(breadTempArr[x]);
            }

            priceTemp = read.nextLine();
            priceTemp = priceTemp.substring(1, priceTemp.length() - 1);
            priceTempArr = priceTemp.split(", ");
            for (int x = 0; x < priceTempArr.length; x++) {
                price.add(Double.parseDouble(priceTempArr[x]));
            }

            stockTemp = read.nextLine();
            stockTemp = stockTemp.substring(1, stockTemp.length() - 1);
            stockTempArr = stockTemp.split(", ");
            for (int x = 0; x < stockTempArr.length; x++) {
                stock.add((int) Double.parseDouble(stockTempArr[x]));
            }

            reportTemp = read.nextLine();
            reportTemp = reportTemp.substring(1, reportTemp.length() - 1);
            reportTempArr = reportTemp.split(", ");
            orderTotal = (int) Double.parseDouble(reportTempArr[0]);
            itemsSold = (int) Double.parseDouble(reportTempArr[1]);
            totalSold = Double.parseDouble(reportTempArr[2]);
            return "File successfully opened!";

        } catch (Exception e) {
            return "Error opening! Invalid file.";
        } finally {
        	
        	//old code
        	// read.close();
        	
        	// working code
        	if (read != null) {
        		read.close();
        	}
        	
        }

    }

    static String deleteFile(String namePath) {

            File del = new File(namePath);
            
            if (del.delete()) {
            	return "File successfully deleted!";
            } else {
            	return "Error deleting";
            }

    }

    static String endsWith(String name) {
    	
    	if (name.endsWith(".tabledata")) {
    		return name;
    	} else if (name.endsWith(".TABLEDATA")) {
    		return name;
    	} else {
    		return name.concat(".tabledata");
    	}
    	
    }
    
    static String[][] convert2DArrayItems() {
    	convert2D = new String[bread.size()][3];
		
		for (int x = 0; x < convert2D.length; x++) {
			convert2D[x][0] = Integer.toString(x + 1);
			convert2D[x][1] = bread.get(x);
			convert2D[x][2] = Double.toString(price.get(x));
		}
		
		return convert2D;
    }
    
    static String[][] convert2DArrayStocks() {
    	convert2D = new String[bread.size()][3];
		
		for (int x = 0; x < convert2D.length; x++) {
			convert2D[x][0] = Integer.toString(x + 1);
			convert2D[x][1] = bread.get(x);
			convert2D[x][2] = Integer.toString(stock.get(x));
		}
		
		return convert2D;
    }
    
    static String[][] convertOrderSummary1() {
    	convert2D = new String[2][2];
    	convert2D[0][0] = "Name of Customer:";
    	convert2D[0][1] = name;
    	convert2D[1][0] = "Number of Items Ordered:";
    	convert2D[1][1] = Integer.toString(itemOrdered.size());
    	return convert2D;
    }
    
    static String[][] convertOrderSummary2() {
    	convert2D = new String[itemOrdered.size()][5];
    	
    	for (int x = 0; x < convert2D.length; x++) {
    		convert2D[x][0] = Integer.toString(x + 1);
    		convert2D[x][1] = bread.get(itemOrdered.get(x) - 1);
    		convert2D[x][2] = Double.toString(price.get(itemOrdered.get(x) - 1));
    		convert2D[x][3] = Integer.toString(quantityOrdered.get(x));
    		convert2D[x][4] = Double.toString(price.get(itemOrdered.get(x) - 1) * quantityOrdered.get(x));
    	}
    	
    	return convert2D;
    }
    
    static String[][] convertOrderSummary3() {
    	convert2D = new String[3][2];
    	convert2D[0][0] = "Total Amount:";
    	convert2D[0][1] = Double.toString(total);
    	convert2D[1][0] = "Amount Paid:";
    	convert2D[1][1] = Double.toString(pay);
    	convert2D[2][0] = "Change:";
    	convert2D[2][1] = Double.toString(pay - total);
    	return convert2D;
    }
    
    static String[][] convertReport() {
    	convert2D = new String[3][2];
    	convert2D[0][0] = "Number of Customers:";
    	convert2D[0][1] = Integer.toString(orderTotal);
    	convert2D[1][0] = "Number of Items Sold:";
    	convert2D[1][1] = Integer.toString(itemsSold);
    	convert2D[2][0] = "Total Amount Sold:";
    	convert2D[2][1] = Double.toString(totalSold);
    	return convert2D;
    }
    
    static void Convert2DArrayToList(String[][] inputArr) {
    	
    	for (int x = 0; x < inputArr.length; x++) {
    		bread.add(inputArr[x][0]);
    		price.add(Double.parseDouble(inputArr[x][1]));
    		stock.add(Integer.parseInt(inputArr[x][2]));
    	}
    	
    }
    
    static void convertToList(String[][] tempTableData) {
    	
    	// since this method is for creating a custom file, we'll need to clear the contents
    	// of the old list as well as the old constants
    	bread.clear();
    	price.clear();
    	stock.clear();
    	orderTotal = 0;
    	itemsSold = 0;
    	totalSold = 0.0;
    	
    	for (int x = 0; x < tempTableData.length; x++) {
    		bread.add(tempTableData[x][0]);
    		price.add(Double.parseDouble(tempTableData[x][1]));
    		stock.add(Integer.parseInt(tempTableData[x][2]));
    	}
    	
    }
    
}