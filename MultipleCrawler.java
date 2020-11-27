package com.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MultipleCrawler {
	
	public static void main(String[] args) {
		
		try {
			
			/*
			int i=0;
		    HashMap<Integer, ArrayList<String>> hashMap = new LinkedHashMap<Integer, ArrayList<String>>();
		    
		    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		    BufferedReader bReader = new BufferedReader(inputStreamReader);
		    
		    System.out.println("Enter city name : - ");
		    String cityname = bReader.readLine();
		    
		    System.out.println("Enter what you are looking for ?");
		    String search = bReader.readLine();
		    
		    System.out.println("Enter number of pages to be crawled.");
		    //int pageno = Integer.parseInt(bReader.readLine());
*/		    
			/*final String rootdir = System.getProperty("user.dir");
		    String urlStr = "https://www.tatacliq.com/search/?searchCategory=all&text=sony%20led%20tv";
		    
		   
		    System.out.println(input.canRead());*/
			
		/*	WebClient webClient = new WebClient(BrowserVersion.getDefault());
			webClient.setJavaScriptEnabled(true);
			webClient.waitForBackgroundJavaScript(5000);*/
			
			/*final String rootdir = System.getProperty("user.dir");
		    File input = new File(rootdir + "\\html\\temp.html");*/
			/*WebDriver driver = new FirefoxDriver();
			driver.get("http:www.tatacliq.com/search/?searchCategory=all&text=sony%20led%20tv");*/
			//Document doc = Jsoup.parse(input,"UTF-8","http://www.tatacliq.com/search/?searchCategory=all&text=sony tv");
			/*
		    Document doc = Jsoup.connect("https://www.tatacliq.com/search/?searchCategory=all&text=sony%20led%20tv")
		    		.timeout(10 * 1000).get();*/
		   // System.out.println(doc);
		    
		   /* WebDriver webDriver = new ChromeDriver();
		    webDriver.get("http:www.tatacliq.com/search/?searchCategory=all&text=sony%20led%20tv");
		    String content = webDriver.getPageSource();
		    System.out.println(content);*/
		    
		    Document doc = Jsoup.connect("https://www.amazon.in/s?k=Apple+iPhone+X+%28256GB%29+-+Space+Grey")
		    		.header("authority", "www.amazon.in")
    				.header("method", "GET")
    				.header("path", "/s?k=Apple+iPhone+X+%28256GB%29+-+Space+Grey")
    				.header("scheme", "https")
    				.header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
    				.header("accept-encoding", "gzip, deflate, br")
    				.header("accept-language", "en-GB,en-US;q=0.9,en;q=0.8")
    				.header("cache-control", "no-cache")
    				.header("pragma", "no-cache")
    				.header("upgrade-insecure-requests", "1")
    				.header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36")
		    		.timeout(10 * 1000).get();    
		    //*/
		    //for(int j=1;j<=pageno;j++){
		    	//doc = Jsoup.parse(myPage.asXml()); 
		    	//System.out.println("URL : " + urlStr);
			    Elements innerDiv = doc.getElementsByClass("sg-col-inner");
			    System.out.println("Data" + innerDiv);
			    /*int p = 0;
			    String lasthref = "";
			    for (Element element : innerDiv) {
			    	ArrayList<String> arrayList = new ArrayList<String>();
			    	
			    	if(p>=0) {
			    		
			    		// Name 
						Elements name = element.getElementsByClass("lng_cont_name");
						arrayList.add(name.text());
						
						//Address
						Elements address = element.getElementsByClass("cont_fl_addr");
						arrayList.add(address.text());
						
						//Contact Number
						Elements element4 = element.getElementsByClass("mobilesv");
						
						List<?> phoneno = element4.eachAttr("class");
						String contact = "";
						
						for(Object phoneTemp : phoneno) {
							
							String switchtemp = (String) phoneTemp;
							
							switch (switchtemp) {
							
							case "mobilesv icon-dc":
								switchtemp = "+";
								break;
								
							case "mobilesv icon-fe":
								switchtemp = "(";
								break;
							
							case "mobilesv icon-hg":
								switchtemp = ")";
								break;
								
							case "mobilesv icon-ba":
								switchtemp = "-";
								break;
								
							case "mobilesv icon-acb":
								switchtemp = "0";
								break;
								
							case "mobilesv icon-yz":
								switchtemp = "1";
								break;
							
							case "mobilesv icon-wx":
								switchtemp = "2";
								break;
							
							case "mobilesv icon-vu":
								switchtemp = "3";
								break;
							
							case "mobilesv icon-ts":
								switchtemp = "4";
								break;
								
							case "mobilesv icon-rq":
								switchtemp = "5";
								break;
								
							case "mobilesv icon-po":
								switchtemp = "6";
								break;
							
							case "mobilesv icon-nm":
								switchtemp = "7";
								break;
								
							case "mobilesv icon-lk":
								switchtemp = "8";
								break;
								
							case "mobilesv icon-ji":
								switchtemp = "9";
								break;
								
							default:
								break;
							}
							contact += switchtemp;
						}
						arrayList.add(2, contact);
						
						//Sub-Pages
						Elements element5 = element.getElementsByClass("cntanr");
						
						String href = element5.attr("data-href");
						if(null!=href && href.trim().length()>0 && !lasthref.equals(href)){
							lasthref = href;
							String tempTime = "";
							doc = Jsoup.connect(href).get();
							
							//Timings
							try {
								Element timings = doc.getElementById("hoprte");
								tempTime = timings.text();
							}
							catch (Exception e) {
								tempTime = "N.A.";
							} 
							String Time = tempTime.replace("Today :", "");
							arrayList.add(3, Time);
						
							//Quick-info
							Elements element6 = doc.getElementsByClass("mreinfwpr");
							String quickInfo = element6.text();
							arrayList.add(4, quickInfo);
							
							//Ratings
							String rating = "";
							try {
								Elements element7 = doc.getElementsByClass("star_m");
								String ratingTemp = element7.attr("aria-label");
								rating = ratingTemp.replaceAll("[^\\d.]", "");
								if (rating.equals(null) || rating.equals("")) {
									rating = "N.A."; 
								}
							}
							catch (Exception e) {
								rating = "N.A.";
							}
							arrayList.add(5, rating);
						}
							// Storing all list data in HashMap
							hashMap.put(i, arrayList);
			    	}
					p++;
					i++;
				}
			    
		    }
			    
		    //String filePath = "D:\\";
		    
		    String filePath = System.getProperty("user.dir");
		    
		    String fileName = cityname + "_" + search + ".xlsx";
			
			File f = new File(filePath + File.separator + fileName);
			
			File	theDir =  new File(filePath);
	  		if (!theDir.exists()) 
	  			theDir.mkdirs();	 

			if (!f.exists())
				f.createNewFile();

			Cell cell = null;
			Row row = null;
			OutputStream outputStream = new FileOutputStream(f);
			XSSFWorkbook xwb = new XSSFWorkbook();
			Sheet sheet1 = xwb.createSheet("Sheet1");
			
			XSSFFont defaultFont= xwb.createFont();
		    defaultFont.setBold(true);
			int rowCount = 0;
			
			XSSFCellStyle style = xwb.createCellStyle();
			style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex()); 
			style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
			style.setBorderRight(XSSFCellStyle.BORDER_THIN);
			style.setRightBorderColor(IndexedColors.BLACK.getIndex());
			style.setBorderTop(XSSFCellStyle.BORDER_THIN);
			style.setTopBorderColor(IndexedColors.BLACK.getIndex());
			XSSFFont font = xwb.createFont();
			font.setColor(IndexedColors.WHITE.getIndex());
	        style.setFont(font);
			font.setBold(true);
			style.setFont(font);
			row = sheet1.getRow(4);
			cell = row.getCell(0);
			
			XSSFCellStyle style2 = xwb.createCellStyle();
			style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			style2.setLeftBorderColor(IndexedColors.BLACK.getIndex());
			style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
			style2.setRightBorderColor(IndexedColors.BLACK.getIndex());
			style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
			style2.setTopBorderColor(IndexedColors.BLACK.getIndex());
			
			XSSFCellStyle alignCenterstyle = xwb.createCellStyle();
			alignCenterstyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			alignCenterstyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			alignCenterstyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			alignCenterstyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			alignCenterstyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
			alignCenterstyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
			alignCenterstyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
			alignCenterstyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
			alignCenterstyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
			
			row = sheet1.createRow(rowCount++);
			int columnCount = 0;
			
			cell = row.createCell(columnCount++);
			cell.setCellValue("Name");
			cell.setCellStyle(style);
			
			cell = row.createCell(columnCount++);
			cell.setCellValue("Address");
			cell.setCellStyle(style);
			
			cell = row.createCell(columnCount++);
			cell.setCellValue("Phone");
			cell.setCellStyle(style);
			
			cell = row.createCell(columnCount++);
			cell.setCellValue("Timings");
			cell.setCellStyle(style);
			
			cell = row.createCell(columnCount++);
			cell.setCellValue("Quick Info");
			cell.setCellStyle(style);
			
			cell = row.createCell(columnCount++);
			cell.setCellValue("Rating");
			cell.setCellStyle(style);
			
			cell = row.createCell(columnCount++);
			cell.setCellValue("Facilities");
			cell.setCellStyle(style);
			
			cell = row.createCell(columnCount++);
			cell.setCellValue("Listed as");
			cell.setCellStyle(style);
			
			cell = row.createCell(columnCount++);
			cell.setCellValue("Phone No");
			cell.setCellStyle(style);
			
			cell = row.createCell(columnCount++);
			cell.setCellValue("Cuisines");
			cell.setCellStyle(style);
			
			cell = row.createCell(columnCount);
			cell.setCellValue("Featured");
			cell.setCellStyle(style);
			
			for (Map.Entry<Integer, ArrayList<String>> iterator : hashMap.entrySet() ) {
				ArrayList<String> arrayList = iterator.getValue();
				row = sheet1.createRow(rowCount++);
	    		columnCount = 0;
	    		
	    		cell = row.createCell(columnCount++);
				cell.setCellValue(arrayList.get(0));
				
				cell = row.createCell(columnCount++);
				cell.setCellValue(arrayList.get(1));
				
				cell = row.createCell(columnCount++);
				cell.setCellValue(arrayList.get(2));
				
				cell = row.createCell(columnCount++);
				cell.setCellValue(arrayList.get(3));
				
				cell = row.createCell(columnCount++);
				cell.setCellValue(arrayList.get(4));
				
				cell = row.createCell(columnCount++);
				cell.setCellValue(arrayList.get(5));
				
				cell = row.createCell(columnCount++);
				cell.setCellValue(arrayList.get(3));
				
				cell = row.createCell(columnCount++);
				cell.setCellValue(arrayList.get(6));
				
				cell = row.createCell(columnCount++);
				cell.setCellValue(arrayList.get(10));
				
				
				
				cell = row.createCell(columnCount++);
				cell.setCellValue(arrayList.get(8));
				
				cell = row.createCell(columnCount);
				cell.setCellValue(arrayList.get(9));
				
			}
		    
		    xwb.write(outputStream);
			outputStream.flush();
			
			System.out.println("Crawled successfully!");*/
			
		   }catch (Exception e) {
			e.printStackTrace();
			System.out.println("Operation failed!");
		}
		
}
}
