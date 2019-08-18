
public class CodigoEnLinea2_1
{
  public int triangle(int rows) {
      return rows==0 ? 0:rows+triangle(rows-1);
  
  }
  
  public int count7(int n) {
  int acum=0;
     
     if (n/10==0){
      acum= n%7==0? 1:0;
      return acum;
     }else{
       acum=+ n%10 ==7? 1+ count7(n/10):count7(n/10);
       return acum;
     }
}


public int countX(String str) {
  
  if (str.length()<=1){
    return str.equals("x")? 1:0;
  }else{
    return str.charAt(str.length()-1)=='x'?
    1+countX(str.substring (0, str.length()-1)):
    countX(str.substring (0, str.length()-1));
  }
}

public int powerN(int base, int n) {
  if (n==0){
    return 1;
  }else{
    return base*powerN(base, n-1);
  }
}

public int countHi(String str) {
  if (str.length()<2){
    return 0;
  }
  if (str.length()==2){
    return str.equals("hi")? 1:0;
  }else{
    return str.substring(str.length()-2, str.length()).equals("hi")?1+countHi(str.substring (0, str.length()-1)):
    countHi(str.substring (0, str.length()-1));
  }
}



}
