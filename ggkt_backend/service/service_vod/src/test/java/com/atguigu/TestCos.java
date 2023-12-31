package com.atguigu;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;

import java.io.File;
import java.util.List;

// 测试腾讯云对象存储服务
public class TestCos {
    public static void main(String[] args) {
        // 1 初始化用户身份信息（secretId, secretKey）。
// SECRETID 和 SECRETKEY 请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        String secretId = "AKIDqVxAD3iAPtBHJF0awJYeaKvLchbJqARX";//用户的 SecretId，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        String secretKey = "xiIgsrdEdw30kKhtthIfswoX6SedQ4Zs";//用户的 SecretKey，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
// 2 设置 bucket 的地域, COS 地域的简称请参见 https://cloud.tencent.com/document/product/436/6224
// clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-nanjing");
        ClientConfig clientConfig = new ClientConfig(region);
// 这里建议设置使用 https 协议
// 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
// 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);

//        String bucket = "ggkt-1319089695"; //存储桶名称，格式：BucketName-APPID
//        CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucket);
//// 设置 bucket 的权限为 Private(私有读写)、其他可选有 PublicRead（公有读私有写）、PublicReadWrite（公有读写）
//        createBucketRequest.setCannedAcl(CannedAccessControlList.Private);
//        try{
//            Bucket bucketResult = cosClient.createBucket(createBucketRequest);
//        } catch (CosServiceException serverException) {
//            serverException.printStackTrace();
//        } catch (CosClientException clientException) {
//            clientException.printStackTrace();
//        }

        List<Bucket> buckets = cosClient.listBuckets();

        // 指定要上传的文件
        File localFile = new File("C:\\Users\\z7605\\Pictures\\壁纸1.jpg");
// 指定文件将要存放的存储桶
        String bucketName = buckets.get(0).getName();
// 指定文件上传到 COS 上的路径，即对象键。例如对象键为 folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        String key = "exampleKey";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        System.out.println("-------------------");
        System.out.println(putObjectResult);
        System.out.println("-------------------");

    }
}
