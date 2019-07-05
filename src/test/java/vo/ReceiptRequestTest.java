package vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import reactor.util.annotation.NonNull;

import javax.annotation.Resources;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


/**
 * @author :  chenyongxiu
 * @description : 收款请求参数vo
 * @Date : 2019-06-19 15:27:08
 */
@Data
@NoArgsConstructor
@Component
@Slf4j
public class ReceiptRequestTest implements Cloneable{

    private   int value=123;

    @DateTimeFormat(pattern = "yyyy")
    @NonNull
    private Date timeStart=new Date();

    @DateTimeFormat(pattern = "yyyy")
    private Date timeEnd;

    public Object clone()
            throws CloneNotSupportedException
    {
        return super.clone();
    }



}
