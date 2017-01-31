package Bean;

import DAO.ClienteDAO;
import Model.Pessoa;
import Model.Cliente;
import java.util.Date;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class ClienteBean {        
             
    private Cliente cliente = new Cliente();
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public void adicionarCliente()
    {
        clientes.add(cliente);
        new ClienteDAO().create(cliente);
        cliente = new Cliente();
    }
    
    public void removerCliente()
    {
        clientes.remove(cliente);
        new ClienteDAO().create(cliente);
        cliente = new Cliente();
    }
    
    public void alterarCliente()
    {
        clientes.add(cliente);
        new ClienteDAO().create(cliente);
        cliente = new Cliente();
    }
    
    public Pessoa getCliente()
    {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public ArrayList<Cliente> getClientes()
    {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes)
    {
        this.clientes = clientes;
    }
}
