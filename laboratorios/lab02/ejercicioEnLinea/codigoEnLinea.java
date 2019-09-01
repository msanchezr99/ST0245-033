//Ejercicios CodingBat Array-2

public int countEvens(int[] nums) {

  int total=0;

  for (int i=0; i<nums.length; i++){

    if (nums [i]%2==0){

      total+=1;

    }

  }

  return total;

}





public int bigDiff(int[] nums) {

  if (nums.length<2){

    return 0;

  }

  int mayor=Math.max(nums[0],nums[1]);

  int menor=Math.min(nums[0],nums[1]);

  
  for (int i=0;i<nums.length;i++){

    mayor=Math.max(mayor,nums[i]);

    menor=Math.min(menor, nums[i]);

  }

  return mayor-menor;

}




public int centeredAverage(int[] nums) {

  int suma=0;

  int mayor=Math.max(nums[0],nums[1]);

  int menor=Math.min(nums[0],nums[1]);

  
  for (int i=0;i<nums.length;i++){

    mayor=Math.max(mayor,nums[i]);

    menor=Math.min(menor, nums[i]);

  }

  for (int i=0;i<nums.length;i++){

    suma+=nums[i];

  }

  
return (suma-mayor-menor) / (nums.length-2);

}




public int sum13(int[] nums) {

  if (nums.length==0){

    return  0;

  }

  
int sum=0;

  int i=0;

  while (i<nums.length){

    if (nums[i]!=13){

      sum+=nums[i];

      i++;

    }else{

      
      i+=2;

    }

  }

  return sum;

}



public boolean has22(int[] nums) {

  boolean ans=false;
 
  for (int i=0;i<nums.length-1;i++){

    if ((nums[i]==2)&& (nums[i+1]==2)){

      ans=true;

    }

  }

  return ans;

}





//Ejercicios Array-3



public int maxSpan(int[] nums) {

  int resp=0;

  for(int i =0;i<nums.length;i++){

    int j=nums.length-1;


    while(nums[i]!=nums[j]){

      j--;

    }

    int span=j-i+1;

    if(span>resp)resp=span;

  }

  return resp;

}


public int[] fix34(int[] nums) {

  int j=0;

  int i=0;

  while (i<nums.length){

    if (nums[i]==3){

      int aux;
      while( (nums[j]!=4)){

        j++;

      }

      aux=nums[i+1];

      nums[i+1]=nums[j];

      nums[j]=aux;

      i+=2;

    }else{

      i++;

    }

  }

  return nums;

}





public boolean canBalance(int[] nums) 
int sumaTotal=0;

  int sumaParcial=0;

  for (int i=0;i<nums.length; i++){

    sumaTotal+=nums[i];

  }

  
  for (int i=0;i<nums.length;i++){

    sumaParcial+=nums[i];

    if (sumaParcial== sumaTotal-sumaParcial){

      return true;
    }

  }

  return false;

}
//Algoritmo tomadode clase, profesor Mauricio Toro


public int countClumps(int[] nums) {

  int contador = 0;

  boolean entrada = false;

  for (int i = 0; i < nums.length-1; i++) {

    if (nums[i] == nums[i+1] && entrada==false) {

      entrada = true;

      contador++;

    }

    else {
      if (nums[i] != nums[i+1])entrada = false;

    }

  }

  return contador;

}