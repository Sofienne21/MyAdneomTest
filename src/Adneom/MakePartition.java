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

	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<>();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.add(4);
		myList.add(5);
		
		List[] finalList = partition(myList, 2);
		for(int i=0; i<finalList.length; i++){
			System.out.print("[");
			for(int j=0; j<finalList[i].size(); j++){
				System.out.print(finalList[i].get(j));
				if(j<finalList[i].size()-1){
					System.out.print(",");
				}
			}
			System.out.print("]");
		}
	}

}
