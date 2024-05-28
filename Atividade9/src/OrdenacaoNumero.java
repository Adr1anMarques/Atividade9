
public class OrdenacaoNumero {
	private int[] numeros;

    public void OrdenacaoNumeros() {
        numeros = new int[10]; 
    }

    
    public void setNumero(int indice, int numero) {
        if (indice >= 0 && indice < 10) {
            numeros[indice] = numero;
        } else {
            System.out.println("Índice inválido.");
        }
    }

    
    public void mostrarNumeros() {
        System.out.println("Números armazenados:");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    
    public void insertionSort() {
        for (int i = 1; i < numeros.length; i++) {
            int atual = numeros[i];
            int j = i - 1;
            while (j >= 0 && numeros[j] > atual) {
                numeros[j + 1] = numeros[j];
                j--;
            }
            numeros[j + 1] = atual;
        }
    }

    
    public void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int indicePivot = particionar(inicio, fim);
            quickSort(inicio, indicePivot - 1);
            quickSort(indicePivot + 1, fim);
        }
    }

   
    private int particionar(int inicio, int fim) {
        int pivot = numeros[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (numeros[j] <= pivot) {
                i++;
                int temp = numeros[i];
                numeros[i] = numeros[j];
                numeros[j] = temp;
            }
        }
        int temp = numeros[i + 1];
        numeros[i + 1] = numeros[fim];
        numeros[fim] = temp;
        return i + 1;
    }



    public static void main(String[] args) {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();

       
        ordenacaoNumeros.setNumero(0, 5);
        ordenacaoNumeros.setNumero(1, 3);
        ordenacaoNumeros.setNumero(2, 9);
        ordenacaoNumeros.setNumero(3, 1);
        ordenacaoNumeros.setNumero(4, 7);
        ordenacaoNumeros.setNumero(5, 2);
        ordenacaoNumeros.setNumero(6, 8);
        ordenacaoNumeros.setNumero(7, 4);
        ordenacaoNumeros.setNumero(8, 10);
        ordenacaoNumeros.setNumero(9, 6);

        
        System.out.println("Números antes da ordenação:");
        ordenacaoNumeros.mostrarNumeros();

        
        ordenacaoNumeros.insertionSort();
        System.out.println("\nNúmeros ordenados usando Insertion Sort:");
        ordenacaoNumeros.mostrarNumeros();

        
        ordenacaoNumeros.setNumero(0, 5);
        ordenacaoNumeros.setNumero(1, 3);
        ordenacaoNumeros.setNumero(2, 9);
        ordenacaoNumeros.setNumero(3, 1);
        ordenacaoNumeros.setNumero(4, 7);
        ordenacaoNumeros.setNumero(5, 2);
        ordenacaoNumeros.setNumero(6, 8);
        ordenacaoNumeros.setNumero(7, 4);
        ordenacaoNumeros.setNumero(8, 10);
        ordenacaoNumeros.setNumero(9, 6);

       
        System.out.println("\nNúmeros antes da ordenação:");
        ordenacaoNumeros.mostrarNumeros();

        
        ordenacaoNumeros.quickSort(0, 9);
        System.out.println("\nNúmeros ordenados usando Quick Sort:");
        ordenacaoNumeros.mostrarNumeros();
    }
}
