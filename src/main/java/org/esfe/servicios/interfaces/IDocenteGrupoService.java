package org.esfe.servicios.interfaces;

import org.esfe.modelos.DocenteGrupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IDocenteGrupoService {
    Page<DocenteGrupo> buscarTodosPaginados(Pageable pageable);

    List<DocenteGrupo> obtenerTodos();

    DocenteGrupo buscarPorId(Integer id);

    DocenteGrupo crearOEditar(DocenteGrupo docenteGrupo);

    void eliminarPorId(Integer docente);
}
