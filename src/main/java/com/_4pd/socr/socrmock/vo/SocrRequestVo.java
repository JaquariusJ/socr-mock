package com._4pd.socr.socrmock.vo;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class SocrRequestVo {

    private String scene;

    private String image;

    private Map parameters = new HashMap();


}
