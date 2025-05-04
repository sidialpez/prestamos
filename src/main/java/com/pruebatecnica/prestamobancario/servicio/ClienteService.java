package com.pruebatecnica.prestamobancario.servicio;

import com.pruebatecnica.prestamobancario.dominio.Cliente;

import java.util.List;

public interface ClienteService {

    public List<Cliente> listarClientes();

    public void guardar(Cliente cliente);

    public void eliminar(Cliente cliente);

    public Cliente buscar(Cliente cliente);
}
