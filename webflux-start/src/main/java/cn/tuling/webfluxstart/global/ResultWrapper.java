package cn.tuling.webfluxstart.global;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultWrapper {

    private String message;
}
