package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestConntction {

	public static void main(String[] args) {
		reqAdv();
//		String str="adfadsfvzxcvasdfqwadsf";
//		String [] asr= getStrArrByTime(str, 6);
//		for (String string : asr) {
//			
//			System.out.println(string);
//		}
//		System.out.println(asr.length);
	}
	
	private static String[] getStrArrByTime(String str,int splitNum){
		int division = str.length()/splitNum;
		int rema = str.length()%splitNum;
		if(rema!=0){
			division+=1;
		}
		String [] arr = new String[division];
		String arrStr="";
		for (int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			arrStr+=String.valueOf(ch);
			if(arrStr.length()==splitNum){
				arr[i/splitNum]=arrStr;
				arrStr="";
			}
		}
		if(rema!=0){
			arr[arr.length-1]=arrStr;
		}
		return arr;
	}
	private CloseableHttpClient httpClient =HttpClients.custom().build();
	
	@Test
	public void insertAdvertiserReq(){
		String url="http://localhost:8080/ROOT/openapi/advertiser";
		String json = getAdvJson();
		httpPostMethod(url, json);
	}
	
	@Test
	public void updateAdvertiserReq(){
		String url="http://localhost:8080/ROOT/openapi/advertiser/1";
		//设置form信息
		String json = getAdvJson();
		httpPutMethod(url, json);
	}
	
	@Test
	public void deleteAdvertiserReq(){
		String url="http://localhost:8080/ROOT/openapi/advertiser/1";
		HttpRequestBase req = new HttpDelete(url);
		//设置头部信息
		setHeader(req);
		//设置form信息
//		String json = getAdvJson();
//		ByteArrayEntity se = new ByteArrayEntity(json.getBytes());
//		((HttpEntityEnclosingRequestBase) req).setEntity(se);
		//执行http并返回信息
		executeHttp(httpClient, req);
	}
	
	@Test
	public void getAllAdvertiserReq(){
		String url="http://localhost:8080/ROOT/openapi/advertiser";
		HttpRequestBase req = new HttpGet(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	
	@Test
	public void getAdvertiserReq(){
		String url="http://localhost:8080/ROOT/openapi/advertiser/1";
		HttpRequestBase req = new HttpGet(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	
	@Test
	public void insertCampaignReq(){
		String url="http://localhost:8080/ROOT/openapi/advertiser/1/campaign";
		String json = getCamJson();
		httpPostMethod(url, json);
	}
	
	@Test
	public void updateCampaignReq(){
		String url="http://localhost:8080/ROOT/openapi/advertiser/1/campaign/1";
		//设置form信息
		String json = getCamJson();
		httpPutMethod(url, json);
	}
	
	@Test
	public void closeCampaignReq(){
		String url="http://localhost:8080/ROOT/openapi/campaign/1/close";
		//设置form信息
		String json = "";
		httpPutMethod(url, json);
	}
	
	@Test
	public void openCampaignReq(){
		String url="http://localhost:8080/ROOT/openapi/campaign/1/open";
		//设置form信息
		String json = "";
		httpPutMethod(url, json);
	}
	
	@Test
	public void deleteCampaignReq(){
		String url="http://localhost:8080/ROOT/openapi/campaign/1";
		HttpRequestBase req = new HttpDelete(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	@Test
	public void getAllCampaignReq(){
		String url="http://localhost:8080/ROOT/openapi/campaign";
		HttpRequestBase req = new HttpGet(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	
	@Test
	public void getCampaignReq(){
		String url="http://localhost:8080/ROOT/openapi/campaign/1";
		HttpRequestBase req = new HttpGet(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	
	@Test
	public void insertStrategyReq(){
		String url="http://localhost:8080/ROOT/openapi/campaign/1/strategy";
		String json = getStrJson();
		httpPostMethod(url, json);
	}
	
	@Test
	public void updateStrategyReq(){
		String url="http://localhost:8080/ROOT/openapi/campaign/1/strategy/1";
		//设置form信息
		String json = getStrJson();
		httpPutMethod(url, json);
	}
	
	@Test
	public void closeStrategyReq(){
		String url="http://localhost:8080/ROOT/openapi/strategy/1/close";
		//设置form信息
		String json = "";
		httpPutMethod(url, json);
	}
	
	@Test
	public void openStrategyReq(){
		String url="http://localhost:8080/ROOT/openapi/strategy/1/open";
		//设置form信息
		String json = "";
		httpPutMethod(url, json);
	}
	
	@Test
	public void deleteStrategyReq(){
		String url="http://localhost:8080/ROOT/openapi/strategy/1";
		HttpRequestBase req = new HttpDelete(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	
	@Test
	public void getAllStrategyReq(){
		String url="http://localhost:8080/ROOT/openapi/strategy";
		HttpRequestBase req = new HttpGet(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	
	@Test
	public void getStrategyReq(){
		String url="http://localhost:8080/ROOT/openapi/strategy/1";
		HttpRequestBase req = new HttpGet(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	
	/**
	 * 创建创意并和策略关联
	 */
	@Test
	public void insertStrategyCreativeReq(){
		String url="http://localhost:8080/ROOT/openapi/strategy/1/creative";
		String json = getCreJson();
		httpPostMethod(url, json);
	}
	
	@Test
	public void strategyCreativeRelReq(){
		String url="http://localhost:8080/ROOT/openapi/strategy/1/creative/1";
		String json = "";
		httpPostMethod(url, json);
	}
	
	/**
	 * 8. 策略与已有创意批量进行关联，并删除策略与之前创意的关联
	 */
	@Test
	public void strategyCreativeBatchRelReq(){
		String url="http://localhost:8080/ROOT/openapi/strategy/1/creative_batch?creId=1,2";
		String json = "";
		httpPostMethod(url, json);
	}
	
	@Test
	public void strategyCookieSetReq(){
		String url="http://localhost:8080/ROOT/openapi/strategy/1/coookie";
		String json = getCookiesetJson();
		httpPostMethod(url, json);
	}
	
	@Test
	public void outStrategyCookieSetReq(){
		String url="http://localhost:8080/ROOT/openapi/outer/strategy/1/coookie";
		String json = getCookiesetJson();
		httpPostMethod(url, json);
	}
	
	
	
	@Test
	public void insertCreativeReq(){
		String url="http://localhost:8080/ROOT/openapi/advertiser/1/creative";
		String json = getCreJson();
		httpPostMethod(url, json);
	}
	
	@Test
	public void updateCreativeReq(){
		String url="http://localhost:8080/ROOT/openapi/advertiser/1/creative";
		//设置form信息
		String json = getCreJson();
		httpPutMethod(url, json);
	}
	
	@Test
	public void closeStrategyCreativeReq(){
		String url="http://localhost:8080/ROOT/openapi/strategy/1/creative/1/close";
		//设置form信息
		String json = "";
		httpPutMethod(url, json);
	}
	
	@Test
	public void openStrategyCreativeReq(){
		String url="http://localhost:8080/ROOT/openapi/strategy/1/creative/1/open";
		//设置form信息
		String json = "";
		httpPutMethod(url, json);
	}
	
	@Test
	public void deleteStrategyCreativeRelReq(){
		String url="http://localhost:8080/ROOT/openapi/strategy/1creative/1";
		HttpRequestBase req = new HttpDelete(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	
	@Test
	public void deleteCreativeReq(){
		String url="http://localhost:8080/ROOT/openapi/creative/1";
		HttpRequestBase req = new HttpDelete(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	
	@Test
	public void getAllCreativeReq(){
		String url="http://localhost:8080/ROOT/openapi/creative";
		HttpRequestBase req = new HttpGet(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	
	@Test
	public void getCreativeReq(){
		String url="http://localhost:8080/ROOT/openapi/creative/1";
		HttpRequestBase req = new HttpGet(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}

	@Test
	public void reportStrategy(){
		String begindate="";
		String enddate="";
		String type="strategy";
		String strategyId="";
		report(begindate, enddate, type, strategyId);
	}
	
	@Test
	public void reportCreative(){
		String begindate="";
		String enddate="";
		String type="creative";
		String strategyId="";
		report(begindate, enddate, type, strategyId);
	}
	
	@Test
	public void reportPlatform(){
		String begindate="";
		String enddate="";
		String type="platform";
		String strategyId="";
		report(begindate, enddate, type, strategyId);
	}
	
	@Test
	public void reportProvince(){
		String begindate="";
		String enddate="";
		String type="province";
		String strategyId="";
		report(begindate, enddate, type, strategyId);
	}
	
	@Test
	public void reportCity(){
		String begindate="";
		String enddate="";
		String type="city";
		String strategyId="";
		report(begindate, enddate, type, strategyId);
	}
	
	@Test
	public void reportStrDomain(){
		String begindate="";
		String enddate="";
		String type="str_domain";
		String strategyId="";
		report(begindate, enddate, type, strategyId);
	}
	
	@Test
	public void reportStrHour(){
		String begindate="";
		String enddate="";
		String type="strategy_hour";
		String strategyId="";
		report(begindate, enddate, type, strategyId);
	}
	@Test
	public void reportCreHour(){
		String begindate="";
		String enddate="";
		String type="creative_hour";
		String strategyId="";
		report(begindate, enddate, type, strategyId);
	}
	
	public void report(String begindate,String enddate ,String type,String strategyId){
		String url ="http://localhost:8080/ROOT/openapi/report?begindate="+begindate+"&enddate"+enddate+"&reporttype="+type;
		if(strategyId!=null && "".equals(strategyId)){
			url+="&strategyId="+strategyId;
		}
		HttpRequestBase req = new HttpGet(url);
		//设置头部信息
		setHeader(req);
		String reportStr = executeHttp(httpClient, req);
	}
	
	
	public static void reqAdv(){
		
//		String url="http://localhost:8080/ROOT/openapi/advertiser/11/campaign";
		
//		String url="http://localhost:8080/ROOT/openapi/advertiser/10/creative";
		
		CloseableHttpClient httpClient =HttpClients.custom().build();
//		String url="http://localhost:8080/ROOT/openapi/advertiser/112/backDistribute";
//		String url="http://localhost:8080/ROOT/openapi/advertiser/11/campaign";
//		String url="http://localhost:8080/ROOT/openapi/campaign/13/strategy";
		String url="http://localhost:8080/ROOT/openapi/advertiser/145/creative/4";
		
//		String url="http://localhost:8080/ROOT/openapi/strategy/4/creative/4";
//		HttpPost post = new HttpPost(url);
		HttpEntityEnclosingRequestBase post = new HttpPut(url);
		
		
		
//		String url="http://localhost:8080/ROOT/openapi/advertiser/11/campaign/12";
//		String url="http://localhost:8080/ROOT/openapi/campaign/12/open";
//		String url="http://localhost:8080/ROOT/openapi/campaign/12/strategy/12";
//		String url="http://localhost:8080/ROOT/openapi/campaign/13/strategy/1";
//		String url="http://localhost:8080/ROOT/openapi/campaign/11/close";
//		String url="http://localhost:8080/ROOT/openapi/strategy/12/close";
		
//		String url="http://localhost:8080/ROOT/openapi/strategy/12/creative/1/open";
//		HttpPut post = new HttpPut(url);
		
		
//		String url="http://localhost:8080/ROOT/openapi/advertiser/10";
//		String url="http://localhost:8080/ROOT/openapi/campaign/12";
//		String url="http://localhost:8080/ROOT/openapi/strategy/2";
//		String url="http://localhost:8080/ROOT/openapi/creative/4";
//		HttpDelete post = new HttpDelete(url);
		
//		String url="http://localhost:8080/ROOT/openapi/advertiser";
		
//		String url="http://localhost:8080/ROOT/openapi/advertiserAudit?beginDate=20160110&endDate=20160112";
//		String url="http://localhost:8080/ROOT/openapi/advertiserAudit/11";
//		HttpGet post = new HttpGet(url);
		
		setHeader(post);
//		post.setConfig(requestConfig);
		
//		String url ="http://192.168.1.175:8080/audienceStatisticTool/audienceTool";
//		String url = "http://192.168.1.13:8080/ROOT/sync/?logName=73&level=creative";
//		HttpPost post = new HttpPost(url);
		//传递信息
//		String json = getJson();
//	
//		String json = getBill();
//	
//		String json = getCamJson();
//	
//		String json = getStrJson();
		
		String json = getCreJson();
//		String json = getBaifendian();
		ByteArrayEntity se = new ByteArrayEntity(json.getBytes());
		post.setEntity(se);
		
		executeHttp(httpClient, post);
			
	}
	
	private void httpPutMethod(String url, String json) {
		HttpEntityEnclosingRequestBase req = new HttpPut(url);
		//设置头部信息
		setHeader(req);
		ByteArrayEntity se = new ByteArrayEntity(json.getBytes());
		req.setEntity(se);
		//执行http并返回信息
		executeHttp(httpClient, req);
	}
	
	private void httpPostMethod(String url, String json) {
		HttpEntityEnclosingRequestBase req = new HttpPost(url);
		//设置头部信息
		setHeader(req);
		ByteArrayEntity se = new ByteArrayEntity(json.getBytes());
		req.setEntity(se);
		//执行http并返回信息
		executeHttp(httpClient, req);
	}
	
	private static String executeHttp(CloseableHttpClient httpClient,
			HttpRequestBase req) {
		StringBuilder sb = new StringBuilder();
		try {
			HttpResponse response = httpClient.execute(req);
			HttpEntity entity = response.getEntity();
			if(entity!=null){
				BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));   
				
				String line = null;
				try {
					while ((line = reader.readLine()) != null) {
						sb.append(line + "/n");
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						entity.getContent().close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				System.out.println(sb.toString());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	private static String getBill() {
		JSONObject request =new JSONObject();
		request.put("tradeAmount", 100);
		JSONObject root =new JSONObject();
		root.put("request", request);
		
		return root.toString();
	}

	private static String getBaifendian() {
		
		JSONObject request =new JSONObject();
//		{'detail': {'status': 0, 'landing_page': u'http://baifendian.com?bmm_source=bfd_1947_2637_4467', 
//		'account_id': 1517, 'creative_type': '1', 'order_id': 1947, 'creative_id': 4467, 'campaign_id': 1941, 
//		'high': 250, 'width': 250, 'member_id': 30, 'creative_url': 'http://img.bmm.baifendian.com/upload/advertise/images/20160428/146183433628478200.jpg'}, 'method': 'add'}
		request.put("status", 0);
		request.put("landing_page", "http://baifendian.com?bmm_source=bfd_1947_2637_4467");
		request.put("account_id", 1525);	
		request.put("creative_type", "1");
		//曝光投放周期
		request.put("order_id", 1901);
		//点击投放周期
		request.put("creative_id", 4467);
		
		request.put("campaign_id", 1900);
		request.put("high", 250);
		request.put("width", 250);
		request.put("member_id", 30);
		request.put("creative_url", "http://img.bmm.baifendian.com/upload/advertise/images/20160428/146183433628478200.jpg");
		request.put("member_id", 30);
		
		JSONObject root =new JSONObject();
		root.put("method", "add");
		root.put("detail", request);
		System.out.println(root.toString());
		return root.toString();
	}

	private static void setHeader(HttpRequestBase req) {
		String reqTime = ""+System.currentTimeMillis()/1000;
		String tokenTime ="kcgw47wSiJr1QohgrSOZ7jhrZn0pS5dJ"+reqTime;
		String sha1Token="";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA1");
			sha1Token = byteToHexString(sh.digest(tokenTime.getBytes()));
		} catch (NoSuchAlgorithmException e) {
		}
		Header[] h=new Header[3];
		h[0]=new BasicHeader("userId", "55");
		h[1]=new BasicHeader("token", sha1Token);
		h[2]=new BasicHeader("reqTime", reqTime);
		req.setHeaders(h);
		System.out.println(sha1Token);
	}
	
	private static void setHeader(HttpPut post) {
		String reqTime = ""+System.currentTimeMillis()/1000;
		String tokenTime ="kcgw47wSiJr1QohgrSOZ7jhrZn0pS5dJ"+reqTime;
		String sha1Token="";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA1");
			sha1Token = byteToHexString(sh.digest(tokenTime.getBytes()));
		} catch (NoSuchAlgorithmException e) {
		}
		Header[] h=new Header[3];
		h[0]=new BasicHeader("userId", "55");
		h[1]=new BasicHeader("token", sha1Token);
		h[2]=new BasicHeader("reqTime", reqTime);
		post.setHeaders(h);
		System.out.println(sha1Token);
	}
	
	public static String getAdvJson(){
		JSONObject extecd =new JSONObject();
		extecd.put("ad", "11");
		extecd.put("cx", "rs");
		extecd.put("ss", "s");
		extecd.put("zz", "cc");
		extecd.put("qq", "asdf");
		
		JSONObject request =new JSONObject();
		request.put("advertiserId", "1");
		request.put("name", "测试api广告主1");
		request.put("registerName", "openApi");
		request.put("contactName", "cc");
		request.put("website", "http://www.baidu.com");
		request.put("email", "rs@qq.com");
		request.put("telephone", "8585855");
		request.put("organizationCode", "150");
		request.put("remark", "openapi测试数据");
		request.put("industryId", 180);
		
		request.put("extend", extecd);
		
		
		JSONObject root =new JSONObject();
		root.put("request", request);
		
		return root.toString();
	}
	
	public static String getCamJson(){
		JSONObject extecd =new JSONObject();
		extecd.put("ad", "11");
		extecd.put("cx", "rs");
		extecd.put("ss", "s");
		extecd.put("zz", "cc");
		extecd.put("qq", "asdf");
		
		JSONObject request =new JSONObject();
		
		request.put("campaignId", "1");
		request.put("active", 0);
		request.put("name", "测试api计划1");
		request.put("beginDate", "20160104");
		request.put("endDate", "20160106");
		request.put("totalBudget", "1000");
		request.put("dailyBudget", "80");
		request.put("impTotalLimit", "150");
		request.put("clickTotalLimit", "1101");
		request.put("impDailyLimit", "10");
		request.put("clickDailyLimit", "120");
		
		request.put("impLimit", "3");	
		request.put("clickLimit", "3");
		//曝光投放周期
		request.put("impPeriod", "Day");
		//点击投放周期
		request.put("clickPeriod", "Day");
		
		request.put("remark", "remark");
		request.put("extend", extecd);
		
		JSONObject root =new JSONObject();
		root.put("request", request);
		
		return root.toString();
	}
	
	
	public static String getStrJson(){
		JSONObject extecd =new JSONObject();
		extecd.put("ad", "11");
		extecd.put("cx", "rs");
		extecd.put("ss", "s");
		extecd.put("zz", "cc");
		extecd.put("qq", "asdf");
		
		JSONArray track = new JSONArray();
		track.add("http://www.baidu.com");
		track.add("http://www.tanx.com");
		track.add("http://www.paiyue.com");
		JSONObject request =new JSONObject();
		request.put("strategyId", "1");
		request.put("strategyType", 0);
		request.put("targetUrl", "http://www.paiyue.com");
		request.put("clickUrl", "http://www.paiyue.com");
		request.put("trackUrls", track);
		request.put("active", 1);
		request.put("name", "测试api策略4");
		request.put("beginDate", "20160104");
		request.put("endDate", "20160106");
		request.put("totalBudget", 1000);
		request.put("dailyBudget", 80);
		request.put("impTotalLimit", 150);
		request.put("clickTotalLimit", 1101);
		request.put("impDailyLimit", 10);
		request.put("clickDailyLimit", 120);
			
		request.put("impLimit", 20);
		request.put("clickLimit", 3);
		//曝光投放周期
		request.put("impPeriod", "Day");
		//点击投放周期
		request.put("clickPeriod", "Day");
		
		request.put("remark", "remark");
		request.put("extend", extecd);
		
		JSONObject week =new JSONObject();
		
		JSONArray jarr = new JSONArray();
		jarr.add(1);
		jarr.add(3);
		jarr.add(5);
		jarr.add(7);
		jarr.add(10);
		week.put("monday", jarr);
		week.put("tuesday", jarr);
		week.put("wednesday", jarr);
		week.put("thursday", jarr);
		week.put("friday", jarr);
		JSONArray saturday = new JSONArray();
		saturday.add(12);
		week.put("saturday", saturday);
		
		request.put("timeInterval", week);
		System.out.println(request);
		
		JSONArray exarr = new JSONArray();
		exarr.add("Tanx");
		exarr.add("Miaozhen");
		exarr.add("Youku");
		exarr.add("Baidu");
		request.put("exchange", exarr);
		
		JSONObject root =new JSONObject();
		root.put("request", request);
		
		return root.toString();
	}
	
	public static String getCookiesetJson(){
		JSONArray cookiset = new JSONArray();
		cookiset.add("..9xYZP8fS");
		cookiset.add("..AuzTmhhS");
		cookiset.add("..13YZP8fS");
		cookiset.add("..A54TmhhS");
		cookiset.add("..A5tTah5s");
		JSONObject request =new JSONObject();
		request.put("cookieSet", cookiset);
		JSONObject root =new JSONObject();
		root.put("request", request);
		
		return root.toString();
	}
	
	
	
	public static String getCreJson(){
		JSONObject request =new JSONObject();
		
		request.put("creativeId", "1");
//		request.put("active", 0);
		request.put("name", "测试api创意1");
		request.put("width", "300");
		request.put("height", "300");
		request.put("creativeUrl", "http://img0.imgtn.bdimg.com/it/u=2856683511,3854984833&fm=21&gp=0.jpg");
		request.put("creativeType", "2");
			
		
		JSONObject root =new JSONObject();
		root.put("request", request);
		
		return root.toString();
	}
	

	public static String byteToHexString(byte[] b) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            hexString.append(hex.toLowerCase());
        }
        return hexString.toString();
    }

}
