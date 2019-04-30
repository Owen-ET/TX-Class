import com.testZC.wework.Wework;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;


/**
 * @author zc
 * @date 2019-04-30 13:49
 */

public class TestGetToken {

    @Test
    public void testToken(){
        String token = Wework.getToken();
        assertThat(token,not(equalTo(null)));
    }
}