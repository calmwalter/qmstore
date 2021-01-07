package qmstore.imgapi.controller;


import com.qcloud.cos.*;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.*;
import qmstore.commodity.dao.CommodityMapper;

@RestController
@RequestMapping("/imgapi")
public class ImgapiController {

    private String resource = "mybatis-config.xml";


    /*传图片id，得到图片URL，URL有效时间两小时*/
    @GetMapping("/download")
    public  String getPicUrl(@RequestParam("picid") String picid) throws IOException {


        String neededKey=null;

        // 1 初始化用户身份信息（secretId, secretKey）。
        String secretId = "AKIDINQEmJv6D2lR4SjUVQ5UXp1xd5uq7AjZ";
        String secretKey = "lCUWCxDNGw1vcFihLrSvGMUzPc7kSFyT";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-shanghai");
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);


        String bucketName = "ikarosoqmstore-1302117865"; //存储桶名称，格式：BucketName-APPID
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
// 设置bucket名称
        listObjectsRequest.setBucketName(bucketName);
// prefix表示列出的object的key以prefix开始
        listObjectsRequest.setPrefix("qm/goods/");
// deliter表示分隔符, 设置为/表示列出当前目录下的object, 设置为空表示列出所有的object
        listObjectsRequest.setDelimiter("/");
// 设置最大遍历出多少个对象, 一次listobject最大支持1000
        listObjectsRequest.setMaxKeys(1000);
        ObjectListing objectListing = null;
        do {
            try {
                objectListing = cosClient.listObjects(listObjectsRequest);
            } catch (CosServiceException e) {
                e.printStackTrace();
                return "bad";
            } catch (CosClientException e) {
                e.printStackTrace();
                return "bad";
            }
            // common prefix表示表示被delimiter截断的路径, 如delimter设置为/, common prefix则表示所有子目录的路径
            List<String> commonPrefixs = objectListing.getCommonPrefixes();
            // object summary表示所有列出的object列表
            List<COSObjectSummary> cosObjectSummaries = objectListing.getObjectSummaries();
            for (COSObjectSummary cosObjectSummary : cosObjectSummaries) {

                // 文件的路径key
                String key = cosObjectSummary.getKey();
                // 文件的etag
                String etag = cosObjectSummary.getETag();
                // 文件的长度
                long fileSize = cosObjectSummary.getSize();
                // 文件的存储类型
                String storageClasses = cosObjectSummary.getStorageClass();

                if(!key.endsWith("/") &&key.split("\\.")[0].split("/")[2].equals(picid))
                {
                    System.out.println(key.split("\\.")[0].split("/")[2]);
                    System.out.println(key+"  finded");
                    neededKey=key;
                    break;
                }
            }
            String nextMarker = objectListing.getNextMarker();
            listObjectsRequest.setMarker(nextMarker);
        } while (objectListing.isTruncated());





        if(neededKey!=null){


            String key = neededKey;
            GeneratePresignedUrlRequest req =
                    new GeneratePresignedUrlRequest(bucketName, key, HttpMethodName.GET);
// 设置签名过期时间(可选), 若未进行设置, 则默认使用 ClientConfig 中的签名过期时间(1小时)
// 这里设置签名在2个小时后过期
            Date expirationDate = new Date(System.currentTimeMillis() + 120L * 60L * 1000L);
            req.setExpiration(expirationDate);
            URL url = cosClient.generatePresignedUrl(req);
            System.out.println(url.toString());

            cosClient.shutdown();

            return "success find:  "+url.toString();

        }
        else{
            return  "failed to find this picture";
        }








    }




    @GetMapping("/allimgkeys")
    public ArrayList<String> hello() throws IOException {

        ArrayList<String> allkeys=new ArrayList<>();

        System.out.println("hello");

        // 1 初始化用户身份信息（secretId, secretKey）。
        String secretId = "AKIDINQEmJv6D2lR4SjUVQ5UXp1xd5uq7AjZ";
        String secretKey = "lCUWCxDNGw1vcFihLrSvGMUzPc7kSFyT";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-shanghai");
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);


        String bucketName = "ikarosoqmstore-1302117865"; //存储桶名称，格式：BucketName-APPID
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
// 设置bucket名称
        listObjectsRequest.setBucketName(bucketName);
// prefix表示列出的object的key以prefix开始
        listObjectsRequest.setPrefix("qm/goods/");
// deliter表示分隔符, 设置为/表示列出当前目录下的object, 设置为空表示列出所有的object
        listObjectsRequest.setDelimiter("/");
// 设置最大遍历出多少个对象, 一次listobject最大支持1000
        listObjectsRequest.setMaxKeys(1000);
        ObjectListing objectListing = null;
        do {
            try {
                objectListing = cosClient.listObjects(listObjectsRequest);
            } catch (CosServiceException e) {
                e.printStackTrace();
                return allkeys;
            } catch (CosClientException e) {
                e.printStackTrace();
                return allkeys;
            }
            // common prefix表示表示被delimiter截断的路径, 如delimter设置为/, common prefix则表示所有子目录的路径
            List<String> commonPrefixs = objectListing.getCommonPrefixes();
            // object summary表示所有列出的object列表
            List<COSObjectSummary> cosObjectSummaries = objectListing.getObjectSummaries();
            for (COSObjectSummary cosObjectSummary : cosObjectSummaries) {

                // 文件的路径key
                String key = cosObjectSummary.getKey();
                // 文件的etag
                String etag = cosObjectSummary.getETag();
                // 文件的长度
                long fileSize = cosObjectSummary.getSize();
                // 文件的存储类型
                String storageClasses = cosObjectSummary.getStorageClass();

                if(!key.endsWith("/"))
                {
                    allkeys.add(key);
                    System.out.println(key);
                }
            }
            String nextMarker = objectListing.getNextMarker();
            listObjectsRequest.setMarker(nextMarker);
        } while (objectListing.isTruncated());


        cosClient.shutdown();


        //System.out.println("what happened");

        return allkeys;


    }


}
