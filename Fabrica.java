import java.util.*;

/**
 * Evaluacion 4.
 * 
 * @author (Sebastian Ahern) 
 * @version (2.0)
 */
public class Fabrica
{
    // declarar atributo minimo para poder fabricar
    private String contenedor;
    private int [] metales;
    private ArrayList<String> estados;
    private final int minimoMat = 50;
    /**
     * Constructor for objects of class Fabrica
     */
    
     
    public Fabrica()
    {
        // initialise instance variables
        metales = new int [5];
        estados = new ArrayList();
       // for (int m: metales)
      //  {
      //      m=0;
      //  }
    }
    
    public String getContenedor()
    {
        return this.contenedor;
    }
    
    public void setContenedor(String value)
    {
         this.contenedor=value;
    }
    
    //ArrayList<ArrayList<Integer>> agregarmaterial = new ArrayList();  
    //return devuelve una cadena de tipo String con el estado de la operacion
    public String agregarMaterial (int cantidad, int contenedor)
    {
       
        if(contenedor < 0)
        {
            return "El numero de contenedor debe ser mayor a 0";
        }

        if(contenedor >= 5)
        {
            return "El numero de contenedor no puede ser mayor a 5";
        }

        if (cantidad < 0)
        {
            return "El material no puede ser inferior a 0";
        }

        metales[contenedor] = cantidad;
        return "Material agregado al contenedor.";
        // boolean fabripro=false;
        // for(int x=0;x<5;x++)
        // {
            // if(metales[x]==0)
            // {
                // metales[x]=cantidad;
                // fabripro=true;
                // break;                
            // }
        // }
        // return fabripro;
    }

     // Metodo para verificar fabricacion
    public String fabricar()
    {
        // StringBuilder salida = new StringBuilder();
        // salida.append("Reporte de Fabrica");
        // return salida.toString();
        StringBuilder salida = new StringBuilder();
        salida.append("**#### ");
        salida.append("Reporte Fabrica ");
        salida.append(" ####**");

        for (int i=0; i<=4; i++)
        {
            if (metales[i] < minimoMat)
            {
                salida.append("Material insuficiente");
                estados.add("ERROR");
            }
            else
            {
                salida.append("Fabricado Exitosamente");
                estados.add("OK");
            }
        }

        return salida.toString();
    }
    
    public int getOKs()
    {
        int cantok = 0;

            if (estados.size() <= 0)
            {
                return -1;
            }

        for (int i = 0; i < estados.size(); i++)
        {
            if(estados.get(i).equals("OK"))
            {
                cantok++;
            }
        }

    return cantok;
}
 
    public int getFallidos()
    {
        int canterror = 0;

            if (estados.size() <= 0)
            {
                return -1;
            }

        for (int i = 0; i < estados.size(); i++)
        {
            if(estados.get(i).equals("ERROR"))
            {
                canterror++;
            }
        }

    return canterror;
}
    
}

