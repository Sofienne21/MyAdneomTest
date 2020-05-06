package Adneom;
import java.util.ArrayList;
import java.util.List;

public class MakePartition {
	
	public static <T> void checkParams(List<T> list , int n) {
		if(list==null){
			throw new IllegalArgumentException(RessourcePartition.LIST_IS_NULL.name());
		}
		if(n<=0){
			throw new IllegalArgumentException(RessourcePartition.PARTITION_NOT_POSSIBLE_SIZE_LESS_THAN_ONE.name());
		}
	}
	
	public static<T> List[] partition(List<T> myList, int n){
		
		//Vérifier les parametres
		checkParams(myList, n);
		
		//Prendre la taille de la liste
		int size = myList.size();
		
		//Calculer le nombre des partitions
		int nbrPart = size/n;
		if(size % n != 0){
			nbrPart++;
		}
		
		//Creation d'une nouvelle liste à partir de la liste initial
		List<T>[] toReturn = new ArrayList[nbrPart];
		
		for (int i = 0; i < nbrPart; i++)
		{
			int fromIndex = i*n;
			int toIndex = (i*n + n < size) ? (i*n + n) : size;

			toReturn[i] = new ArrayList(myList.subList(fromIndex, toIndex));
		}
		
		return toReturn;
		
	}
}
