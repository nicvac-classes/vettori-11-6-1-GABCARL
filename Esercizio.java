
//LEGGERE LE ISTRUZIONI NEL FILE README.mdclass Esercizio {

    static void Rimuovi(String[] V, int N, int ie){
        for(int i = ie; i < N-1; i++){
            V[i] =  V[i+1];
        }
    }
    
    static void Aggiungi(String[] V, int N, String parola, int ie){
        for(int i = N-1; i > ie; i--){
            V[i] = V[i-1];
        }
        V[ie] = parola;
    }

    static void VisualizzaBiblioteca(String[] V, int N){
        if(V.length != 0){
            for(int i = 0; i < N; i++){
                System.out.println((i+1) + "° Libro: " + V[i]);
            }
        }else{
            System.out.println("La biblioteca è vuota, Aspettare che vengano restituiti libri!");
        }
    }

    static void VisualizzaPrestito(String[] V, int N){
        if(V[0] != null){
            for(int i = 0; i < N; i++){
                System.out.println((i+1) + "° Libro in prestito: " + V[i]);
            }
        }else{
            System.out.println("Al momento non ci sono prestiti!");
        }
    }

    static void PrendiLibro(String[] V, String[] W, String libro, int N){
        boolean trovato = false;
        int i = 0;

        while(i < N && trovato == false){
            if(V[i].equals(libro)){
                trovato = true;
                Rimuovi(V, N, i);
                Aggiungi(W, N, libro, i);
                System.out.println("Il libro da te cercato è stato preso in prestito!");
            }else{
                i++;
            }
        }
        if(!trovato){
            System.out.println("Il libro che cerchi non è presente in bibblioteca");
        }
    }

    static void RestituisciLibro(String[] V, String[] W, int N, int ie){
        String parola;

        parola = V[ie];
        Rimuovi(W, N, ie);
        Aggiungi(V, N, parola, ie);
    }

    public static void main(String args[]){
        
        Scanner in = new Scanner(System.in);
        int scelta;
        int N;
        int ie;
        String libro;

        do{
            System.out.print("Inserire grandezza biblioteca: ");
            N = in.nextInt();
            if(N <= 0){
                System.err.println("Inserire una grandezza valida (compresa tra 1 e infinito)");
            }
        }while(N <= 0);

        String[] biblioteca = new String[N];
        String[] prestito = new String[N];

        biblioteca[0] = "Harry potter";
        biblioteca[1] = "Paperino";
        biblioteca[2] = "Jojo";
        biblioteca[3] = "Bluelock";
        biblioteca[4] = "Naruto";

        do{
            System.out.println("\nBiblioteca: \n1)Visualizza biblioteca \n2)Visualizza libri in prestito \n3)Prendi in prestito un libro \n4)Restituisci un libro \n5)Esci dal programma");
            System.out.print("Input: ");
            scelta = in.nextInt();
            if(scelta == 1){
                VisualizzaBiblioteca(biblioteca, N);
            }
            if(scelta == 2){
                VisualizzaPrestito(prestito, N);
            }
            if(scelta == 3){
                do{
                    System.out.print("Inserire il nome del libro da cercare: ");
                    libro = in.next();
                    if(libro.equals("")){
                        System.out.println("Inserire un nome valido");
                    }
                }while(libro.equals(""));
                PrendiLibro(biblioteca, prestito, libro, N);
            }
            if(scelta == 4){
                VisualizzaPrestito(prestito, N);
                do{
                    System.out.println("Inserire il numero del libro da restituire: ");
                    ie = in.nextInt();
                    if(ie < 0 || ie > prestito.length - 1){
                        System.out.println("Inserire un valore valido");
                    }
                }while(ie < 0 || ie > prestito.length - 1);
                RestituisciLibro(biblioteca, prestito, N, ie);
            }
            if(scelta < 1 || scelta > 5){
                System.out.println("Inserire un valore valido");
            }
        }while(scelta != 5);

    }
}