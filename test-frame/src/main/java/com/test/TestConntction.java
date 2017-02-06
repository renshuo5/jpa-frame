package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

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

	private CloseableHttpClient httpClient =HttpClients.custom().build();
	
	//此处设置id
	private static final String advertiserId ="1";
	private static final String campaignId ="1";
	private static final String strategyId ="2";
	private static final String outerStrategyId ="1";
	private static final String creativeId ="1";
	
	@Test
	public void insertAdvertiserReq(){
		//测试通过
		String url="http://localhost:8080/ROOT/openapi/advertiser";
		String json = getAdvJson();
		httpPostMethod(url, json);
	}
	
	@Test
	public void updateAdvertiserReq(){
		
		String url="http://localhost:8080/ROOT/openapi/advertiser/"+advertiserId;
		//设置form信息
		String json = getUpdAdvJson();
		httpPutMethod(url, json);
	}
	
	@Test
	public void deleteAdvertiserReq(){
		String url="http://localhost:8080/ROOT/openapi/advertiser/"+advertiserId;
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
		String url="http://localhost:8080/ROOT/openapi/advertiser/"+advertiserId;
		HttpRequestBase req = new HttpGet(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	
	@Test
	public void insertCampaignReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/advertiser/"+advertiserId+"/campaign";
		String json = getCamJson();
		httpPostMethod(url, json);
	}
	
	@Test
	public void updateCampaignReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/advertiser/"+advertiserId+"/campaign/"+campaignId;
		//设置form信息
		String json = getUpdCamJson();
		httpPutMethod(url, json);
	}
	
	@Test
	public void closeCampaignReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/campaign/"+campaignId+"/close";
		//设置form信息
		String json = "";
		httpPutMethod(url, json);
	}
	
	@Test
	public void openCampaignReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/campaign/"+campaignId+"/open";
		//设置form信息
		String json = "";
		httpPutMethod(url, json);
	}
	
	@Test
	public void deleteCampaignReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/campaign/"+campaignId;
		HttpRequestBase req = new HttpDelete(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	@Test
	public void getAllCampaignReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/campaign";
		HttpRequestBase req = new HttpGet(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	
	@Test
	public void getCampaignReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/campaign/"+campaignId;
		HttpRequestBase req = new HttpGet(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	
	@Test
	public void insertStrategyReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/campaign/"+campaignId+"/strategy";
		
//		String url="http://dsp.paiyue.com/openapi/campaign/52/strategy";
		
		String json = getStrJson();
		httpPostMethod(url, json);
	}
	
	@Test
	public void updateStrategyReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/campaign/"+campaignId+"/strategy/"+strategyId;
		//设置form信息
		String json = getUpdStrJson();
		httpPutMethod(url, json);
	}
	
	@Test
	public void closeStrategyReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/strategy/"+strategyId+"/close";
		//设置form信息
		String json = "";
		httpPutMethod(url, json);
	}
	
	@Test
	public void openStrategyReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/strategy/"+strategyId+"/open";
		//设置form信息
		String json = "";
		httpPutMethod(url, json);
	}
	
	@Test
	public void deleteStrategyReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/strategy/"+strategyId;
		HttpRequestBase req = new HttpDelete(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	
	@Test
	public void getAllStrategyReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/strategy";
		HttpRequestBase req = new HttpGet(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	
	@Test
	public void getStrategyReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/strategy/"+strategyId;
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
		//通过
		String url="http://localhost:8080/ROOT/openapi/strategy/"+strategyId+"/creative";
		String json = getCreJson();
		httpPostMethod(url, json);
	}
	
	@Test
	public void strategyCreativeRelReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/strategy/"+strategyId+"/creative/"+creativeId;
		String json = "";
		httpPostMethod(url, json);
	}
	
	/**
	 * 8. 策略与已有创意批量进行关联，并删除策略与之前创意的关联
	 */
	@Test
	public void strategyCreativeBatchRelReq(){
		
		String url="http://localhost:8080/ROOT/openapi/strategy/"+strategyId+"/creative_batch";
		String json = getCreBatch();
		httpPostMethod(url, json);
	}
	
	private String getCreBatch() {
		JSONObject request = new JSONObject();
		request.put("creIds", "1,2");
		JSONObject root=new JSONObject();
		root.put("request", request);
		
		return root.toString();
	}

	@Test
	public void strategyCookieSetReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/strategy/"+strategyId+"/cookie";
		String json = getCookiesetJson();
		httpPostMethod(url, json);
	}
	
	@Test
	public void outStrategyCookieSetReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/outer/strategy/"+outerStrategyId+"/cookie";
		String json = getCookiesetJson();
		httpPostMethod(url, json);
	}
	
	
	
	@Test
	public void insertCreativeReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/advertiser/"+advertiserId+"/creative";
		String json = getCreJson();
		httpPostMethod(url, json);
	}
	
	@Test
	public void updateCreativeByAdvReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/advertiser/"+advertiserId+"/creative/"+creativeId;
		//设置form信息
		String json = getUpdCreJson();
		httpPutMethod(url, json);
	}
	
	@Test
	public void updateCreativeReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/creative/"+creativeId;
		//设置form信息
		String json = getUpdCreJson();
		httpPutMethod(url, json);
	}
	
	@Test
	public void closeStrategyCreativeReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/strategy/"+strategyId+"/creative/"+creativeId+"/close";
		//设置form信息
		String json = "";
		httpPutMethod(url, json);
	}
	
	@Test
	public void openStrategyCreativeReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/strategy/"+strategyId+"/creative/"+creativeId+"/open";
		//设置form信息
		String json = "";
		httpPutMethod(url, json);
	}
	
	@Test
	public void deleteStrategyCreativeRelReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/strategy/"+strategyId+"/creative/"+creativeId;
		HttpRequestBase req = new HttpDelete(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	
	@Test
	public void deleteCreativeReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/creative/"+creativeId;
		HttpRequestBase req = new HttpDelete(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	
	@Test
	public void getAllCreativeReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/creative";
		HttpRequestBase req = new HttpGet(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	
	@Test
	public void getCreativeReq(){
		//通过
		String url="http://localhost:8080/ROOT/openapi/creative/"+creativeId;
		HttpRequestBase req = new HttpGet(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	
	@Test
	public void getCreativeAudit(){
		String url="http://localhost:8080/ROOT/openapi/creativeAudit/"+creativeId;
		HttpRequestBase req = new HttpGet(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}
	@Test
	public void getCreativeAuditAll(){
		String url="http://localhost:8080/ROOT/openapi/creativeAudit?beginDate=20170118&endDate=20170125";
		HttpRequestBase req = new HttpGet(url);
		//设置头部信息
		setHeader(req);
		executeHttp(httpClient, req);
	}

	@Test
	public void reportStrategy(){
		//通过
		String begindate="20161002";
		String enddate="20161015";
		String type="strategy";
		String strategyId="";
		report(begindate, enddate, type, strategyId);
	}
	
	@Test
	public void reportCreative(){
		//通过
		String begindate="20161002";
		String enddate="20161015";
		String type="creative";
		String strategyId="";
		report(begindate, enddate, type, strategyId);
	}
	
	@Test
	public void reportPlatform(){
		//通过
		String begindate="20161002";
		String enddate="20161015";
		String type="platform";
		String strategyId="";
		report(begindate, enddate, type, strategyId);
	}
	
	@Test
	public void reportProvince(){
		//通过
		String begindate="20161002";
		String enddate="20161015";
		String type="province";
		String strategyId="";
		report(begindate, enddate, type, strategyId);
	}
	
	@Test
	public void reportCity(){
		//通过
		String begindate="20161002";
		String enddate="20161015";
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
		//通过
		String begindate="20161002";
		String enddate="20161015";
		String type="strategy_hour";
		String strategyId="";
		report(begindate, enddate, type, strategyId);
	}
	@Test
	public void reportCreHour(){
		//通过
		String begindate="20161002";
		String enddate="20161015";
		String type="creative_hour";
		String strategyId="";
		report(begindate, enddate, type, strategyId);
	}
	
	public void report(String begindate,String enddate ,String type,String strategyId){
		String url ="http://localhost:8080/ROOT/openapi/report?begindate="+begindate+"&enddate="+enddate+"&reporttype="+type;
		if(strategyId!=null && "".equals(strategyId)){
			url+="&strategyId="+strategyId;
		}
		HttpRequestBase req = new HttpGet(url);
		//设置头部信息
		setHeader(req);
		String reportStr = executeHttp(httpClient, req);
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
				byte [] by = new byte[1024*1024];
				InputStream ips =  entity.getContent();
				int nread=1;
				int nTotalRead = 0;  
				while(nread>0){
					nread = ips.read(by, nTotalRead, by.length-nTotalRead);
					if(nread>0){
						nTotalRead = nTotalRead+nread;
					}
				}
				
				String result = new String(by,0,nTotalRead,"utf-8");
				System.out.println(result);
				
//				BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));   
//				
//				String line = null;
//				try {
//					while ((line = reader.readLine()) != null) {
//						sb.append(line + "\n\t");
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				} finally {
//					try {
//						entity.getContent().close();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//				System.out.println(sb.toString());
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


	private static void setHeader(HttpRequestBase req) {
		String reqTime = ""+System.currentTimeMillis()/1000;
		String tokenTime ="kcgw47wSiJr1QohgrSOZ7jhrZn0pS5dJ"+reqTime;
//		String tokenTime ="25f9e794323b453885f5181f1b624d0b"+reqTime;
		
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
	
	
	public static String getAdvJson(){
		JSONObject extecd =new JSONObject();
		extecd.put("ad", "11");
		extecd.put("cx", "rs");
		extecd.put("ss", "s");
		extecd.put("zz", "cc");
		extecd.put("qq", "asdf");
		
		JSONObject request =new JSONObject();
		request.put("advertiserId", advertiserId);
		request.put("name", "测试api广告主1");
		request.put("registerName", "openApi");
		request.put("contactName", "cc");
		request.put("website", "http://www.baidu.com");
		request.put("email", "rs@qq.com");
		request.put("telephone", "8585855");
		request.put("organizationCode", "150");
		request.put("remark", "openapi测试数据");
//		request.put("industryId", 160);
		request.put("extend", extecd);
		JSONObject root =new JSONObject();
		root.put("request", request);
		
		return root.toString();
	}
	
	public static String getUpdAdvJson(){
		JSONObject extecd =new JSONObject();
		extecd.put("update", "任硕修改广告主");
		extecd.put("cx", "rs");
		extecd.put("ss", "s");
		extecd.put("zz", "cc");
		extecd.put("qq", "asdf");
		JSONObject request =new JSONObject();
		request.put("advertiserId", "1");
		request.put("name", "修改测试api广告主1");
		request.put("registerName", "openApi");
		request.put("contactName", "cc");
		request.put("website", "http://www.baidu.com");
		request.put("email", "rs@qq.com");
		request.put("telephone", "8585855");
		request.put("organizationCode", "150");
		request.put("remark", "openapi测试数据");
		request.put("industryId", 8101);
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
		
		request.put("campaignId", campaignId);
		request.put("active", 0);
		request.put("name", "测试api计划"+campaignId);
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
	
	public static String getUpdCamJson(){
		JSONObject extecd =new JSONObject();
		extecd.put("ad", "11");
		extecd.put("cx", "rs");
		extecd.put("ss", "s");
		extecd.put("zz", "cc");
		extecd.put("qq", "asdf");
		
		JSONObject request =new JSONObject();
		request.put("campaignId", campaignId);
		request.put("active", 0);
		request.put("name", "修改测试api计划"+campaignId);
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
		request.put("strategyId", strategyId);
		request.put("strategyType", 0);
		request.put("targetUrl", "");
		request.put("clickUrl", "");
		request.put("trackUrls", null);
		request.put("active", 1);
		request.put("name", "测试api策略"+strategyId);
		request.put("beginDate", "20160104");
		request.put("endDate", "20160106");
		
		request.put("cpmBidPrice", 2.5);
		
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
		jarr.add("1");
		jarr.add("3");
		jarr.add("5");
		jarr.add("7");
		jarr.add("10");
		week.put("monday", jarr);
		week.put("tuesday", jarr);
		week.put("wednesday", jarr);
		week.put("thursday", jarr);
		week.put("friday", jarr);
		JSONArray saturday = new JSONArray();
		saturday.add("12");
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
	
	public static String getUpdStrJson(){
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
		request.put("strategyId", strategyId);
		request.put("strategyType", 0);
		request.put("targetUrl", "http://www.paiyue.com");
		request.put("clickUrl", "http://www.paiyue.com");
		request.put("trackUrls", track);
		request.put("active", 1);
		request.put("name", "修改测试api策略"+strategyId);
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
		jarr.add("1");
		jarr.add("3");
		jarr.add("5");
		jarr.add("7");
		jarr.add("10");
		week.put("monday", jarr);
		week.put("tuesday", jarr);
		week.put("wednesday", jarr);
		week.put("thursday", jarr);
		week.put("friday", jarr);
		JSONArray saturday = new JSONArray();
		saturday.add("12");
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
		
		request.put("creativeId", creativeId);
//		request.put("active", 0);
		request.put("name", "测试api创意"+creativeId);
		request.put("width", "300");
		request.put("height", "300");
		request.put("creativeUrl", "http://img0.imgtn.bdimg.com/it/u=2856683511,3854984833&fm=21&gp=0.jpg");
		request.put("creativeType", "1");
			
		JSONObject root =new JSONObject();
		root.put("request", request);
		
		return root.toString();
	}
	
	public static String getUpdCreJson(){
		JSONObject request =new JSONObject();
		request.put("creativeId", creativeId);
//		request.put("active", 0);
		request.put("name", "修改测试api创意"+creativeId);
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
