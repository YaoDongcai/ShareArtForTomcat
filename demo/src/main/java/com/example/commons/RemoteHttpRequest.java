package com.example.commons;

/**
 * Created by dcyao on 2016/11/2.
 */

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;


/**
 * Created by hong.wang on 2015/4/13.
 */
public class RemoteHttpRequest {

    private static final Logger logger = LoggerFactory.getLogger(RemoteHttpRequest.class);



    /**
     * 专用于获取远程信息
     * @param url   请求地址
     * @param param  请求实体中的参数
     * @return
     */

    public static String getHttpPostResponse(String url, String param) {
        String result = "";
        InputStream inputStream = null;
        logger.info("param: "+param);
        try {
            HttpClient httpClient = new HttpClient();
            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(60000);
            httpClient.getHttpConnectionManager().getParams().setSoTimeout(60000);
            PostMethod postMethod = new PostMethod(url);
            postMethod.addRequestHeader("Accept", "application/json");
            postMethod.addRequestHeader("Content-Type", "application/json;charset=UTF-8");
            postMethod.addRequestHeader("X-LC-Id","MPPgPonVVgoN8d3YDQaJ7TWN-gzGzoHsz");
            postMethod.addRequestHeader("X-LC-Key","WHTzQQg2fLDectWzUhDMBk22");
            byte[] bytes = param.getBytes(CharEncoding.UTF_8);
            RequestEntity requestEntity = new ByteArrayRequestEntity(bytes);
            postMethod.setRequestEntity(requestEntity);
            httpClient.executeMethod(postMethod);

            inputStream = postMethod.getResponseBodyAsStream();
            logger.info(String.valueOf(postMethod.getStatusCode()));
            result = IOUtils.toString(inputStream, CharEncoding.UTF_8);
        } catch (Exception e) {
            logger.error(e.toString());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.error(e.toString());
            }
        }
        return result;
    }


    public static String httpGet(String url) {
        String result = "";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {

            HttpGet httpget = new HttpGet(url);

            httpget.addHeader("X-LC-Id","MPPgPonVVgoN8d3YDQaJ7TWN-gzGzoHsz");
            httpget.addHeader("X-LC-Key","WHTzQQg2fLDectWzUhDMBk22");
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                HttpEntity entity = response.getEntity();
                if (response.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
                    result =  EntityUtils.toString(entity, CharEncoding.UTF_8);
                }

            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


}