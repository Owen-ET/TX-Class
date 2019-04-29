import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


/**
 * @author zc
 * @date 2019-04-29 11:06
 */

public class TestDemo {
    @Test
    public void testGetHtml(){
        given().log().all().get("https://www.baidu.com")
                .then().log().all().statusCode(200);
    }

    @Test
    public void testMp3(){
        given() // 表明输入信息
                .queryParam("wd","mp3")
        .when() // 发送的get
                .get("https://www.baidu.com/")
        .then() // 断言
                .log().all().statusCode(200);
    }

    @Test
    public void testSearch(){
        // 信任https的任何证书
        useRelaxedHTTPSValidation();
        //表示输入数据
        given().log().all()
                //query请求
                .queryParam("code","sogo")
                //头信息
                .header("Cookie","_ga=GA1.2.81071137.1556179570; device_id=6a7b63f05c922c867eea4cd0ab7a77df; aliyungf_tc=AQAAAMyviRnEdQ0AJmYJddmjOylExrJo; xq_a_token=bf5c8346954dcb67fc800e6a8b0274be547423c0; xq_a_token.sig=c0ca-9ydxJfWBWHWuDP7p-WHNmE; xq_r_token=0a984dacce003bb8c446221929a2c80e7cb5b2c6; xq_r_token.sig=L_Wf0-2063SwurwmV9iJTdu0yCI; _gid=GA1.2.916559972.1556509920; Hm_lvt_1db88642e346389874251b5a1eded6e3=1556179570,1556256193,1556412035,1556509920; u=871556509920133; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1556517332; _gat=1")
        //表示触发条件
        .when()
                .get("https://xueqiu.com/stock/search.json")
        //对结果断言
        .then()
                .log().all()
                //状态码断言
                .statusCode(200)
                //字段断言
                .body("stocks[0].name",equalTo("搜狗"))
                .body("stocks[0].code",equalTo("SOGO"));
    }
}
