package com.java.cute.rest;

import com.google.gson.Gson;
import org.junit.Test;

public class JsonTest {

    @Test
    public void test(){
        String json = "{\"gift\":123,\"video_name\":\" Ketsuekigata Kun - 11\",\"view\":231,\"video_url\":\"https://outin-92ff4d3d6fa211e8bb6600163e024c6a.oss-cn-shanghai.aliyuncs.com/video/3613d67a-1644580a2e3-0006-511b-9a5-569ad.mkv?Expires\\u003d1530178189\\u0026OSSAccessKeyId\\u003dLTAInFumgYEtNMvC\\u0026Signature\\u003dww%2FhJm5Muwd5P0bl982vOMoapMU%3D\",\"m_cat_id\":1,\"share\":12321,\"favorite\":2321,\"video_id\":\"254b1b5c7a644ad0923bb8587d7da7bb\",\"video_type_id\":2,\"video_desc\":\"血型君1\",\"m_id\":2},{\"gift\":23,\"video_name\":\"Ketsuekigata Kun - 12 \",\"video_type_id\":2,\"upload_time\":\"Jun 26, 2018 9:40:31 AM\",\"view\":21,\"video_url\":\"https://outin-92ff4d3d6fa211e8bb6600163e024c6a.oss-cn-shanghai.aliyuncs.com/video/27a0957c-1644580a2e5-0006-511b-9a5-569ad.mkv?Expires\\u003d1530178222\\u0026OSSAccessKeyId\\u003dLTAInFumgYEtNMvC\\u0026Signature\\u003d%2FVoMDnlQONuZLXmF2Den0fD6t%2Bo%3D\",\"m_cat_id\":1,\"share\":56,\"comment\":43,\"favorite\":23,\"video_id\":\"6c81579a40c3472fb4bd88deb9f94f37\",\"video_desc\":\"血型君2\",\"m_id\":2},{\"gift\":500,\"video_name\":\"宝具\",\"video_type_id\":1,\"upload_time\":\"Jun 25, 2018 8:58:30 PM\",\"view\":300,\"video_url\":\"https://outin-92ff4d3d6fa211e8bb6600163e024c6a.oss-cn-shanghai.aliyuncs.com/video/453a1955-164457dcb94-0006-511b-9a5-569ad.mp4?Expires\\u003d1530177873\\u0026OSSAccessKeyId\\u003dLTAInFumgYEtNMvC\\u0026Signature\\u003dWTEQmmWPhVkBMsq01d3%2FsfiAbOc%3D\",\"m_cat_id\":1,\"share\":20,\"comment\":5000,\"favorite\":30,\"video_id\":\"856b16d563b644eaad5e6f2a38073c6\",\"video_desc\":\"贞德宝具\",\"m_id\":1}";
        String s = new Gson().fromJson(json, String.class);
        System.out.println(s);
    }
}
