package org.o7planning.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.o7planning.model.CTTruyens;
import org.o7planning.model.DSTruyen;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;



@Controller
public class IndexController {
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	//Chi tiet 1 Truyen
	static final String URL_EMPLOYEES = "http://apitruyenptit.somee.com/api/DSTruyenAPI/";
	
	//Chi tiet 1 chuong truyen
	static final String URL_EMPLOYEES_2 = "http://apitruyenptit.somee.com/api/CTTruyenAPI/";
	
	public List<DSTruyen> ds1 = new ArrayList<DSTruyen>();
	public List<CTTruyens> ctt = new ArrayList<CTTruyens>();
	public static int		dem = 0;
	
	public static DSTruyen xuLyChuoi(String str1) {
		// HttpHeaders
        HttpHeaders headers = new HttpHeaders();
 
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_XML }));
        // Yêu cầu trả về định dạng XML
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.set("my_other_key", "my_other_value");
 
        // HttpEntity<DSTruyen[]>: To get result as DSTruyen[].
        HttpEntity<DSTruyen[]> entity = new HttpEntity<DSTruyen[]>(headers);
 
        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();
 
        // Gửi yêu cầu với phương thức GET, và các thông tin Headers.
        ResponseEntity<String> response = restTemplate.exchange(str1, //
                HttpMethod.GET, entity, String.class);
        String result = response.getBody();
        
        DSTruyen ds2 = new DSTruyen();
        
        if(result.equalsIgnoreCase("null")) {
        	ds2 = null;
        	return ds2;
        }
		
		
		
		
		String[] words = result.split("\\,");

		words[0] = words[0].substring(12);
		ds2.setMATRUYEN(words[0]);
		
		words[1] = words[1].substring(13);
		int length = words[1].length();
		words[1] = words[1].substring(0, (length-1));
		ds2.setTENTRUYEN(words[1]);
		//System.out.println("TEN TRUYEN : " + ds2.getTENTRUYEN());
		
		words[2] = words[2].substring(13);
		length = words[2].length();
		words[2] = words[2].substring(0, (length-1));
		ds2.setTENTACGIA(words[2]);
		
		words[3] = words[3].substring(8);
		length = words[3].length();
		words[3] = words[3].substring(0, (length-1));
		words[3] = words[3].trim();
		//System.out.println("HINH : " + words[3]);
		ds2.setHINH(words[3]);
		
		return ds2;
	}
	
	public static int maCTBatDau(String str2) {
		// HttpHeaders
        HttpHeaders headers = new HttpHeaders();
 
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_XML }));
        // Yêu cầu trả về định dạng XML
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.set("my_other_key", "my_other_value");
 
        // HttpEntity<DSTruyen[]>: To get result as DSTruyen[].
        HttpEntity<String> entity = new HttpEntity<String>(headers);
 
        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();
 
        // Gửi yêu cầu với phương thức GET, và các thông tin Headers.
        ResponseEntity<String> response = restTemplate.exchange(str2, //
                HttpMethod.GET, entity, String.class);
        String result = response.getBody();
		
		DSTruyen ds2 = new DSTruyen();
		
		String[] words2 = result.split("\\DeleteFlag");
		//System.out.println("Wo 0: " + words2[0]);
		//System.out.println("Wo 1: " + words2[1]);
		String maCT1 = words2[1].substring(29,30);
		
		//System.out.println("MACT " + maCT1);
		int ma = Integer.parseInt(maCT1);
		
		return ma;
	}
	
	public static CTTruyens xuLyChuoi2(String str2) {
		
		// HttpHeaders
        HttpHeaders headers = new HttpHeaders();
 
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_XML }));
        // Yêu cầu trả về định dạng XML
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.set("my_other_key", "my_other_value");
 
        // HttpEntity<DSTruyen[]>: To get result as DSTruyen[].
        HttpEntity<String> entity = new HttpEntity<String>(headers);
 
        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();
 
        // Gửi yêu cầu với phương thức GET, và các thông tin Headers.
        ResponseEntity<String> response = restTemplate.exchange(str2, //
                HttpMethod.GET, entity, String.class);
        String result = response.getBody();

		CTTruyens ctt2 = new CTTruyens();
		
		if(result.equalsIgnoreCase("null")) {
			ctt2 = null;
			return ctt2;
		}
		
		String[] words = result.split("\\,");
		
		dem=0;
		for(String w : result.split("\\,")) {
			dem++;
		}
		
		//Chi Tiet Truyen
		words[0] = words[0].substring(7);
		int length = words[0].length();
		words[0] = words[0].substring(1, length);
		System.out.println("MA CT 2 " + words[0]);
		ctt2.setMACT(words[0]);
				
		words[1] = words[1].substring(11);
		length = words[1].length();
		ctt2.setMATRUYEN(words[1]);

		words[2] = words[2].substring(11);
		length = words[2].length();
		ctt2.setMACHUONG(words[2]);

		words[3] = words[3].substring(13);
		length = words[3].length();
		words[3] = words[3].substring(0, (length-1));
		ctt2.setTENCHUONG(words[3]);

		for(int i1=5;i1<dem-1;i1++) {
			words[4] += words[i1];
		}

		words[4] = words[4].substring(11);
		String[] words3 = words[4].split("\\\"");
		words[4] = words3[0];
		words[4].trim();
		ctt2.setNOIDUNG(words[4]);
				
				
		return ctt2;
	}
	
	public static int soLg(String str) {
		int soLg=-1;
		final String URL_EMPLOYEES_2_2 = str;
		
		// HttpHeaders
        HttpHeaders headers = new HttpHeaders();
 
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_XML }));
        // Yêu cầu trả về định dạng XML
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.set("my_other_key", "my_other_value");
 
        // HttpEntity<DSTruyen[]>: To get result as DSTruyen[].
        HttpEntity<DSTruyen[]> entity = new HttpEntity<DSTruyen[]>(headers);
 
        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();
 
        // Gửi yêu cầu với phương thức GET, và các thông tin Headers.
        ResponseEntity<String> response = restTemplate.exchange(URL_EMPLOYEES_2_2, //
                HttpMethod.GET, entity, String.class);

        String result = response.getBody();
        for(String w : result.split("\\HINH")) {
			soLg++;
		}

		return soLg;
	}
	
	public static int soLg2(String str) {
		int soLg=-1;
		final String URL_EMPLOYEES_2_2 = str;
		
		// HttpHeaders
        HttpHeaders headers = new HttpHeaders();
 
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_XML }));
        // Yêu cầu trả về định dạng XML
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.set("my_other_key", "my_other_value");
 
        // HttpEntity<DSTruyen[]>: To get result as DSTruyen[].
        HttpEntity<DSTruyen[]> entity = new HttpEntity<DSTruyen[]>(headers);
 
        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();
 
        // Gửi yêu cầu với phương thức GET, và các thông tin Headers.
        ResponseEntity<String> response = restTemplate.exchange(URL_EMPLOYEES_2_2, //
                HttpMethod.GET, entity, String.class);

        String result = response.getBody();
        if(result.equalsIgnoreCase("null")) {
        	return soLg;
        }
        for(String w : result.split("\\DeleteFlag")) {
			soLg++;
		}

		return soLg;
	}
	
	
	
	@RequestMapping("/index2")
	public String index2(ModelMap model) {
		ds1.clear();
		ds1.removeAll(ds1);
		int soLg = soLg(URL_EMPLOYEES);
		System.out.println("ds1 sl: " + soLg);
		int dem5 = 1;
		int dem6 = 1;
		
		while(dem5<=soLg) {
			String i3 = Integer.toString(dem6);			
			DSTruyen ds = new DSTruyen();
			String str2 = URL_EMPLOYEES + i3;
			
			ds = xuLyChuoi(str2);
			if(ds==null) {
				
			}else {
				ds1.add(ds);
				dem5++;
			}
			dem6++;
			
		}

		//System.out.println("MA TRUYEN : " + ds1.get(0).getMATRUYEN());
	    model.addAttribute("dstruyen", ds1);
		

		return "index2";
	}
	
	@RequestMapping("list/{MATRUYEN}")
	public String list(ModelMap model, @PathVariable("MATRUYEN")String MATRUYEN) {
		ctt.clear();
		ctt.removeAll(ctt);
		
		int maTruyen1 = Integer.parseInt(MATRUYEN);
		
		String str3 = URL_EMPLOYEES + MATRUYEN;
		//System.out.println("URL " + str3);
		int soLg = soLg2(str3) - 1;
		System.out.println("So luong CT : " + soLg);
		if(soLg<=0) {
			CTTruyens ct1 = new CTTruyens();
			
			ct1.setMACT("Không có thông tin");
			ct1.setMACHUONG("Không có thông tin");
			ct1.setTENCHUONG("Không có thông tin");
			ct1.setNOIDUNG("Không có thông tin");
			
			ctt.add(ct1);
		}else {
		
			int ma1 = maCTBatDau(str3);
			System.out.println("MA 1 " + ma1);
			
			int demA = ma1, i4=0;
			while(i4<soLg) {
				String i3 = Integer.toString(demA);			
				CTTruyens ctt1 = new CTTruyens();
				String str2 = URL_EMPLOYEES_2 + i3;
	
				ctt1 = xuLyChuoi2(str2);
				if(ctt1 != null) {
					if(ctt1.getMATRUYEN().equalsIgnoreCase(MATRUYEN)) {
						ctt.add(ctt1);
						i4 = i4 + 1;
						System.out.println("i4 : " + i4 + " MACT : " + ctt1.getMACT());
					}
				}
				demA++;	
			}
			/*
			for(int i=0;i<soLg;i++) {
				int i2 = demA;
				String i3 = Integer.toString(i2);			
				CTTruyens ctt1 = new CTTruyens();
				String str2 = URL_EMPLOYEES_2 + i3;
	
				ctt1 = xuLyChuoi2(str2);
				ctt.add(ctt1);
			}*/
		}
		//System.out.println("MA 2_2 " + ctt.get(0).getMACT());
	    model.addAttribute("cttruyen", ctt);
		

		return "ctTruyen";
	}
	
	@RequestMapping("list2/{MACT}")
	public String list2(ModelMap model, @PathVariable("MACT")String MACT) {
		//ctt.clear();
		int maCT = Integer.parseInt(MACT);
		CTTruyens ct1 = new CTTruyens();
		
		String maCT2 = Integer.toString(maCT);
		for(CTTruyens ct2 : ctt) {
			if(ct2.getMACT().equalsIgnoreCase(maCT2)) {
				ct1 = ct2;
			}
		}

		//System.out.println("TEN CHUONG: "+ ct1.getTENCHUONG());
	    model.addAttribute("cttruyen_1", ct1);
		

		return "noiDungTruyen";
	}
	
	@RequestMapping("/admin")
	public String admin(ModelMap model) {
		org.o7planning.model.Account acc = new org.o7planning.model.Account();
		model.addAttribute("acc", acc);
		

		return "admin";
	}
	
	@RequestMapping(value="/admin2", method = RequestMethod.POST, produces="application/json")
	public String admin2(ModelMap model, HttpServletRequest request,
			@Validated @ModelAttribute("acc")org.o7planning.model.Account acc) {
		
		if((acc.getUsername().equalsIgnoreCase("admin")) && acc.getPassword().equalsIgnoreCase("admin")) {
			String query = acc.getQuery();
			String result="";
			final String URL_EMPLOYEES_2_2 = query;
			
			if(acc.getMethod().equalsIgnoreCase("delete")) {
				// HttpHeaders
		        HttpHeaders headers = new HttpHeaders();
		 
		        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_XML }));
		        // Yêu cầu trả về định dạng XML
		        headers.setContentType(MediaType.APPLICATION_XML);
		        headers.set("my_other_key", "my_other_value");
		 
		        // HttpEntity<DSTruyen[]>: To get result as DSTruyen[].
		        HttpEntity<String> entity = new HttpEntity<String>(headers);
		 
		        // RestTemplate
		        RestTemplate restTemplate = new RestTemplate();
		 
		        // Gửi yêu cầu với phương thức GET, và các thông tin Headers.
		        ResponseEntity<String> response = restTemplate.exchange(URL_EMPLOYEES_2_2, //
		                HttpMethod.DELETE, entity, String.class);

		        result = response.getBody();
			}else if(acc.getMethod().equalsIgnoreCase("put")) {
				// HttpHeaders
		        HttpHeaders headers = new HttpHeaders();
		 
		        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_XML }));
		        // Yêu cầu trả về định dạng XML
		        headers.setContentType(MediaType.APPLICATION_XML);
		        headers.set("my_other_key", "my_other_value");
		 
		        // HttpEntity<DSTruyen[]>: To get result as DSTruyen[].
		        HttpEntity<String> entity = new HttpEntity<String>(headers);
		 
		        // RestTemplate
		        RestTemplate restTemplate = new RestTemplate();
		 
		        // Gửi yêu cầu với phương thức GET, và các thông tin Headers.
		        ResponseEntity<String> response = restTemplate.exchange(URL_EMPLOYEES_2_2, //
		                HttpMethod.PUT, entity, String.class);

		        result = response.getBody();
			}else if(acc.getMethod().equalsIgnoreCase("post")) {
				// HttpHeaders
		        HttpHeaders headers = new HttpHeaders();
		 
		        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_XML }));
		        // Yêu cầu trả về định dạng XML
		        headers.setContentType(MediaType.APPLICATION_XML);
		        headers.set("my_other_key", "my_other_value");
		 
		        // HttpEntity<DSTruyen[]>: To get result as DSTruyen[].
		        HttpEntity<String> entity = new HttpEntity<String>(headers);
		 
		        // RestTemplate
		        RestTemplate restTemplate = new RestTemplate();
		 
		        // Gửi yêu cầu với phương thức GET, và các thông tin Headers.
		        ResponseEntity<String> response = restTemplate.exchange(URL_EMPLOYEES_2_2, //
		                HttpMethod.POST, entity, String.class);

		        result = response.getBody();
			}
			
	        System.out.println("Result : " + result);
		}
		

		return "admin";
	}
	
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public String search(ModelMap model,@RequestParam(value="search", required=true)String search) {
		List<DSTruyen> ds2 = new ArrayList<DSTruyen>();
		int dem9=-1;
		for(DSTruyen ds3 : ds1) {
			if(ds3.getTENTRUYEN().equalsIgnoreCase(search)) {
				ds2.add(ds3);
				dem9 = 3;
				System.out.println(dem9);
			}
		}
		if(dem9 ==-1) {
			DSTruyen ct1 = new DSTruyen();
			
			ct1.setMATRUYEN("Không có thông tin");
			ct1.setTENTRUYEN("Không có thông tin");
			ct1.setTENTACGIA("Không có thông tin");
			ct1.setHINH("Không có thông tin");
			System.out.println(dem9);
			ds2.add(ct1);
		}else {
			
		}
		model.addAttribute("dstruyen", ds2);

		return "index2";
	}
	
	
}
