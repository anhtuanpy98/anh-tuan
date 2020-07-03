package org.o7planning.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.o7planning.model.CTTruyens;
import org.o7planning.model.DSTruyen;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
 
@Controller
public class HelloWorldController {
	
	static final String URL_EMPLOYEES = "http://apitruyenptit.somee.com/api/DSTruyenAPI";
	
	static final String URL_EMPLOYEES_2 = "http://apitruyenptit.somee.com/api/CTTruyenAPI/1";
	
	public static DSTruyen ds1 = new DSTruyen();
	public static CTTruyens ctt = new CTTruyens();
	public static int		dem = 0;
	
	public static void xuLyChuoi(String str1) {
		
		String[] words = str1.split("\\,");

		words[0] = words[0].substring(13);
		ds1.setMATRUYEN(words[0]);
		
		words[1] = words[1].substring(13);
		int length = words[1].length();
		words[1] = words[1].substring(0, (length-1));
		ds1.setTENTRUYEN(words[1]);
		
		words[2] = words[2].substring(13);
		length = words[2].length();
		words[2] = words[2].substring(0, (length-1));
		ds1.setTENTACGIA(words[2]);
		
	}
	
	public static void xuLyChuoi2(String str2) {
				String[] words = str2.split("\\,");
				dem=0;
				for(String w : str2.split("\\,")) {
					dem++;
				}
		
				//Chi Tiet Truyen
				words[0] = words[0].substring(7);
				//System.out.println("Words0: " + words[0]);
				int length = words[0].length();
				//words[5] = words[5].substring(0, (length-1));
				ctt.setMACT(words[0]);
				
				words[1] = words[1].substring(11);
				//System.out.println("Words1: " + words[1]);
				length = words[1].length();
				//words[6] = words[6].substring(0, (length-1));
				ctt.setMATRUYEN(words[1]);
				
				words[2] = words[2].substring(11);
				length = words[2].length();
				//words[7] = words[7].substring(0, (length-1));
				ctt.setMACHUONG(words[2]);
				
				words[3] = words[3].substring(13);
				//System.out.println("Words3: " + words[3]);
				length = words[3].length();
				words[3] = words[3].substring(0, (length-1));
				ctt.setTENCHUONG(words[3]);
				
				for(int i1=5;i1<dem-1;i1++) {
					words[4] += words[i1];
				}
				//System.out.println("Words4: " + words[3]);
				//System.out.println("Words4_1: " + words[4]);
				words[4] = words[4].substring(11);
				//System.out.println("Words4_2: " + words[4]);
				String[] words2 = words[4].split("\\\"");
				words[4] = words2[0];
				words[4].trim();
				//System.out.println("Words4: " + words[4]);
				
				//length = words[4].length();
				//words[4] = words[4].substring(0, (length-1));
				ctt.setNOIDUNG(words[4]);
		
	}
	
 
    @RequestMapping(value = { "/hello"}, method = RequestMethod.GET)
    public String hello(ModelMap model) {

        String a2 = "Hello Spring MVC";
        model.addAttribute("greeting", a2);

     // HttpHeaders
        HttpHeaders headers = new HttpHeaders();

 
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        // Yêu cầu trả về định dạng XML
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("my_other_key", "my_other_value");
        
     // RestTemplate
        RestTemplate restTemplate = new RestTemplate();
 
        // HttpEntity<String>: To get result as String.
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        //System.out.println("Entity: " + entity);
        
        ResponseEntity<String> response = restTemplate.exchange(URL_EMPLOYEES, //
                HttpMethod.GET, entity, String.class);
        String result = response.getBody();
        
        xuLyChuoi(result);
        model.addAttribute("truyen", ds1);
        //System.out.println("TEN truyen: " + ds1.getTENTRUYEN());
        
        
        //CTTruyen
        ResponseEntity<String> response2 = restTemplate.exchange(URL_EMPLOYEES_2, //
                HttpMethod.GET, entity, String.class);
        result = response2.getBody();
        //System.out.println("RESULT: " + result);
        
        xuLyChuoi2(result);
        System.out.println("Chi tiet truyen: " + ctt.getNOIDUNG());
        model.addAttribute("cttruyen", ctt);
        
        
        
        return "helloworld";
        
    }
    
    @RequestMapping(value = { "/hello"}, method = RequestMethod.POST)
    public String hello1(ModelMap model, HttpServletRequest request,
            HttpServletResponse reponses) {

        String a2 = "Hello Spring MVC";
        model.addAttribute("greeting", a2);

     // HttpHeaders
        HttpHeaders headers = new HttpHeaders();
 
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        // Yêu cầu trả về định dạng XML
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("my_other_key", "my_other_value");
        
     // RestTemplate
        RestTemplate restTemplate = new RestTemplate();
 
        // HttpEntity<String>: To get result as String.
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        //System.out.println("Entity: " + entity);
        
        ResponseEntity<String> response = restTemplate.exchange(URL_EMPLOYEES, //
                HttpMethod.GET, entity, String.class);
        String result = response.getBody();
        
        xuLyChuoi(result);
        model.addAttribute("truyen", ds1);
        
        
        //CTTruyen
        response = restTemplate.exchange(URL_EMPLOYEES_2, //
                HttpMethod.GET, entity, String.class);
        result = response.getBody();
        
        xuLyChuoi2(result);
        System.out.println("Chi tiet truyen: " + ctt.getNOIDUNG());
        model.addAttribute("cttruyen", ctt);
        
        
        
        return "helloworld";
        
    }
 
}
