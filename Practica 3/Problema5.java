import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Scanner;

public class Problema5 {
    private static DefaultMutableTreeNode uranos;
    private static DefaultMutableTreeNode zeus;
    private static Scanner sc;

    public Problema5() {
        // Crear los nodos para los personajes
        uranos = new DefaultMutableTreeNode("Uranos");
        DefaultMutableTreeNode cronos = new DefaultMutableTreeNode("Cronos");

        zeus = new DefaultMutableTreeNode("Zeus");
        DefaultMutableTreeNode ades = new DefaultMutableTreeNode("Ades");
        DefaultMutableTreeNode hestia = new DefaultMutableTreeNode("Hestia");
        DefaultMutableTreeNode demeter = new DefaultMutableTreeNode("Deméter");
        DefaultMutableTreeNode hera = new DefaultMutableTreeNode("Hera");
        DefaultMutableTreeNode poseidon = new DefaultMutableTreeNode("Poseidón");

        DefaultMutableTreeNode hefesto = new DefaultMutableTreeNode("Hefesto");
        DefaultMutableTreeNode ares = new DefaultMutableTreeNode("Ares");
        DefaultMutableTreeNode dioniso = new DefaultMutableTreeNode("Dioniso");
        DefaultMutableTreeNode hermes = new DefaultMutableTreeNode("Hermes");
        DefaultMutableTreeNode atenea = new DefaultMutableTreeNode("Atenea");
        DefaultMutableTreeNode artemisa = new DefaultMutableTreeNode("Artemisa");
        DefaultMutableTreeNode apolo = new DefaultMutableTreeNode("Apolo");
        DefaultMutableTreeNode afrodita = new DefaultMutableTreeNode("Afrodita");

        // Construir el árbol genealógico
        uranos.add(cronos);

        cronos.add(zeus);
        cronos.add(poseidon);
        cronos.add(ades);
        cronos.add(hestia);
        cronos.add(demeter);
        cronos.add(hera);
        cronos.add(poseidon);

        zeus.add(hefesto);
        zeus.add(ares);
        zeus.add(dioniso);
        zeus.add(hermes);
        zeus.add(atenea);
        zeus.add(artemisa);
        zeus.add(apolo);
        zeus.add(afrodita);

        sc = new Scanner(System.in);
    }

    public TreeNode buscarDescendiente(TreeNode root, String nombre) {
        if (root.toString().equalsIgnoreCase(nombre)) {
            return root;
        }
        for (int i = 0; i < root.getChildCount(); i++) {
            TreeNode resultado = buscarDescendiente(root.getChildAt(i), nombre);
            if (resultado != null) {
                return resultado;
            }
        }
        return null;
    }

    public void printTree(TreeNode root, String indent) {
        System.out.println(indent + root);
        for (int i = 0; i < root.getChildCount(); i++) {
            printTree(root.getChildAt(i), indent + " | ");
        }
    }

    public void buscarUnDescendiente() {
        // Buscar un descendiente
        System.out.print("\nIngresa el nombre que deseas buscar: ");
        String nombreABuscar = sc.nextLine();
        TreeNode nodoEncontrado = buscarDescendiente(uranos, nombreABuscar);
        if (nodoEncontrado != null) {
            System.out.println("Descendiente encontrado: " + nodoEncontrado);
            if (nodoEncontrado.getParent() != null)
                System.out.println("\nPadre: " + nodoEncontrado.getParent());
            else
                System.out.println("\nPadre: No tiene");
            // desendientes
            if (nodoEncontrado.getChildCount() == 0)
                System.out.println("\nHijos: No tiene");
            else {
                System.out.println("\nHijos: ");
                for (int i = 0; i < nodoEncontrado.getChildCount(); i++) {
                    System.out.println(" - " + nodoEncontrado.getChildAt(i));
                }
            }
        } else {
            System.out.println("Descendiente no encontrado: " + nombreABuscar);
        }
    }

    public void agregarUnDescendiente() {
        System.out.println("\nAgregar un descendiente a Zeus:");
        System.out.print("Ingresa el nombre del nuevo descendiente: ");
        String descendiente = sc.nextLine();
        DefaultMutableTreeNode nuevoDescendiente = new DefaultMutableTreeNode(descendiente);
        zeus.add(nuevoDescendiente);
        System.out.println("Descendiente agregado a Zeus: " + descendiente);
    }

    public void eliminarUnDescendiente() {
        System.out.println("\nEliminar un descendiente de Zeus:");
        System.out.print("Ingresa el nombre del descendiente a eliminar: ");
        String descendiente = sc.nextLine();
        DefaultMutableTreeNode nodoAEliminar = (DefaultMutableTreeNode) buscarDescendiente(zeus, descendiente);
        if (nodoAEliminar != null) {
            zeus.remove(nodoAEliminar);
            System.out.println("Descendiente eliminado de Zeus: " + nodoAEliminar);
        } else {
            System.out.println("Descendiente no encontrado en Zeus: " + descendiente);
        }
    }

    public static void main(String[] args) {
        Problema5 programa = new Problema5();

        // Menu
        int opcion = 0;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Imprimir arbol genealogico");
            System.out.println("2. Buscar un descendiente");
            System.out.println("3. Agregar un descendiente a Zeus");
            System.out.println("4. Eliminar un descendiente de Zeus");
            System.out.println("5. Salir");
            System.out.print("Ingresa una opcion: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    System.out.println();
                    programa.printTree(uranos, "");
                    break;
                case 2:
                    programa.buscarUnDescendiente();
                    break;
                case 3:
                    programa.agregarUnDescendiente();
                    break;
                case 4:
                    programa.eliminarUnDescendiente();
                    break;
                case 5:
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 5);

        sc.close();
    }
}