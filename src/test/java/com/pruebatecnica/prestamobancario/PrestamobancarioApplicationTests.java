package com.pruebatecnica.prestamobancario;

import com.pruebatecnica.prestamobancario.dao.PrestamoDao;
import com.pruebatecnica.prestamobancario.dominio.Prestamo;
import com.pruebatecnica.prestamobancario.servicio.PrestamoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PrestamoServiceTest {

	@Mock
	PrestamoDao prestamoDao;

	@InjectMocks
	PrestamoServiceImpl prestamoService;

	@Test
	void obtenerPrestamosActivosPorCui() {
		String cui = "1234567890101";
		List<Prestamo> prestamos = List.of(new Prestamo());

		when(prestamoDao.findPrestamosActivosPorCui(cui)).thenReturn(prestamos);

		List<Prestamo> resultado = prestamoService.obtenerPrestamosAprobadosPorCui(cui);
		System.out.println("Cantidad de préstamos encontrados: " + resultado.size());

		assertFalse(resultado.isEmpty());
		verify(prestamoDao).findPrestamosActivosPorCui(cui);
	}

	@Test
	void obtenerPrestamosPorCuiVacio() {
		String cui = "0000000000000";
		when(prestamoDao.findPrestamosActivosPorCui(cui)).thenReturn(Collections.emptyList());

		List<Prestamo> resultado = prestamoService.obtenerPrestamosAprobadosPorCui(cui);

		System.out.println("Resultado vacío: " + resultado.size());
		assertTrue(resultado.isEmpty());
	}

	@Test
	void buscarPrestamoPorId() {
		Prestamo prestamo = new Prestamo();
		prestamo.setIdprestamo(1);

		when(prestamoDao.findById(1)).thenReturn(Optional.of(prestamo));

		Prestamo resultado = prestamoService.buscarPorId(1);

		System.out.println("Préstamo encontrado: " + resultado.getIdprestamo());
		assertNotNull(resultado);
	}
}

