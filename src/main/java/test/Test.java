package test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Test {

public static void main(String[] args) throws IOException {
        
		String body = "key=AIzaSyBWJxPZFiG_3QbcXlfIG71_VGDDUuZS5Oc";
        URL url = new URL("https://www.googleapis.com/geolocation/v1/geolocate");
        
        // 문자열로 URL 표현
        System.out.println("URL :" + url.toExternalForm());
        
        // HTTP Connection 구하기 
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        // 요청 방식 설정 ( GET or POST or .. 별도로 설정하지않으면 GET 방식 )
        conn.setRequestMethod("POST"); 
        
        // 연결 타임아웃 설정 
        conn.setConnectTimeout(3000); // 3초 
        // 읽기 타임아웃 설정 
        conn.setReadTimeout(3000); // 3초 
        
        // 요청 방식 구하기
        System.out.println("getRequestMethod():" + conn.getRequestMethod());
        // 응답 콘텐츠 유형 구하기
        System.out.println("getContentType():" + conn.getContentType());
        // 응답 코드 구하기
        System.out.println("getResponseCode():"    + conn.getResponseCode());
        // 응답 메시지 구하기
        System.out.println("getResponseMessage():" + conn.getResponseMessage());
        
        
        // 응답 헤더의 정보를 모두 출력
        for (Map.Entry<String, List<String>> header : conn.getHeaderFields().entrySet()) {
            for (String value : header.getValue()) {
                System.out.println(header.getKey() + " : " + value);
            }
        }
        
        // 응답 내용(BODY) 구하기        
        try (InputStream in = conn.getInputStream();
                ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            
            byte[] buf = new byte[1024 * 8];
            int length = 0;
            while ((length = in.read(buf)) != -1) {
                out.write(buf, 0, length);
            }
            System.out.println(new String(out.toByteArray(), "UTF-8"));            
        }
        
        // 접속 해제
        conn.disconnect();
    }


}
