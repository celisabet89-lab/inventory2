import { Component, OnInit } from '@angular/core';

interface Usuario {
  id: number;
  nombre: string;
  apellidos: string;
  ci: string;
  telefono: string;
  cargo: string;
}

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {
  usuarios: Usuario[] = [
    { id: 1, nombre: 'VICTOR', apellidos: 'GONZALEZ', ci: '12345678', telefono: '60012345', cargo: 'Administrador' },
    { id: 2, nombre: 'MARIA', apellidos: 'LOPEZ', ci: '87654321', telefono: '70054321', cargo: 'Técnico' },
    { id: 3, nombre: 'CARLOS', apellidos: 'RAMIREZ', ci: '11223344', telefono: '60098765', cargo: 'Técnico' }
  ];

  searchTerm: string = '';
  filterCargo: string = '';

  constructor() { }

  ngOnInit(): void {
  }

  get filteredUsuarios(): Usuario[] {
    return this.usuarios.filter(usuario =>
      usuario.nombre.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
      usuario.apellidos.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
      usuario.ci.includes(this.searchTerm)
    ).filter(usuario =>
      !this.filterCargo || usuario.cargo === this.filterCargo
    );
  }

  eliminarUsuario(id: number): void {
    if (confirm('¿Está seguro de que desea eliminar este usuario?')) {
      this.usuarios = this.usuarios.filter(u => u.id !== id);
    }
  }

  editarUsuario(usuario: Usuario): void {
    // Lógica para editar usuario
    console.log('Editando usuario:', usuario);
  }
}
