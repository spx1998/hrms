package com.hrms.common.Utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Random;

@Component
public class CAPTCHAUtils {
    //TODO:应该存放在redis中，后续修改
    private volatile HashMap<String,String> CAPTCHAMap;
    public String generateCAPTCHA(String email){
        //用双重锁保证不会重复创建map
        if(CAPTCHAMap==null){
            synchronized(CAPTCHAUtils.class){
                if(CAPTCHAMap==null){
                    CAPTCHAMap = new HashMap<>();
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i=0;i<6;i++){
            sb.append(random.nextInt(10));
        }
        CAPTCHAMap.put(email, String.valueOf(sb));
        return String.valueOf(sb);
    }
    public boolean cheackCAPTCHA(String email,String CAPTCHA){
        if(CAPTCHAMap==null){
            return false;
        }
        if(CAPTCHA.equals(CAPTCHAMap.get(email))){
            CAPTCHAMap.remove(email);
            return true;
        }else {
            return false;
        }
    }
}
