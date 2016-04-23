package package2;

public class OrdenarPerZeros {

	public static void main(String[] args) {
		int numeros [] = {500000, 40020, 7009, 100, 2014, 30, 302, 12};

		int i, j, aux;
		        for(i=0;i<numeros.length;i++)
		             for(j=0;j<numeros.length;j++)
		                  if(numeros[j+1]<numeros[j]){
		                     aux=numeros[j+1];
		                     numeros[j+1]=numeros[j];
		                     numeros[j]=aux;
		                    System.out.println(numeros[j-i]);
	}

}
	}
