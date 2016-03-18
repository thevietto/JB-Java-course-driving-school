package ru.kpfu.driving_school.service.util.impl;

public class RusToEng {

    private String alpha = new String("абвгдеёжзиыйклмнопрстуфхцчшщьэюя");
    private String[] _alpha = {"a","b","v","g","d","e","yo","g","z","i","y","i",
            "k","l","m","n","o","p","r","s","t","u",
            "f","h","tz","ch","sh","sh","'","e","yu","ya"};



    public String translate(String str){
        str = str.toLowerCase();
        char[] chs = str.toCharArray();
        StringBuffer result = new StringBuffer("");
        for(int i=0; i<chs.length;i++){
            int k = alpha.indexOf(chs[i]);
            if(k != -1)
                result.append(_alpha[k]);
            else{
                result.append(chs[i]);
            }
        }
        return result.toString();
    }
}