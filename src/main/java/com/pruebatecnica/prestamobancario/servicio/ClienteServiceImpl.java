package com.pruebatecnica.prestamobancario.servicio;

import com.pruebatecnica.prestamobancario.dao.ClienteDao;
import com.pruebatecnica.prestamobancario.dominio.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteDao iClienteDao;

    @Override
    @Transactional(readOnly = true)
    public Cliente buscarClienteCui(String cui) {
        return iClienteDao.findByCui(cui);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listarClientes() {
        return iClienteDao.findByEliminado("0");
    }

    @Override
    @Transactional
    public void guardar(Cliente cliente) {
        iClienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void eliminar(Cliente cliente) {
        iClienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente buscar(Cliente cliente) {
        return iClienteDao.findById(cliente.getIdcliente()).orElse(null);
    }


}
