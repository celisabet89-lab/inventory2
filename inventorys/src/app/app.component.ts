import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule, NavigationEnd } from '@angular/router';
import { filter } from 'rxjs/operators';
import {UsuariosComponent} from './components/usuarios/usuarios.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule, UsuariosComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  // Sidebar state
  sidebarOpen = false;
  activeMenu = 'dashboard';
  currentRouteTitle = 'Panel de Control - Gestión de Inventario';

  constructor(private router: Router) {}

  ngOnInit() {
    // Suscribirse a los cambios de ruta
    this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe((event: any) => {
        this.updateActiveMenu(event.urlAfterRedirects || event.url);
        this.updateRouteTitle(event.urlAfterRedirects || event.url);
      });
  }

  updateActiveMenu(url: string) {
    const route = url.split('/')[1] || 'dashboard';
    this.activeMenu = route;
  }

  updateRouteTitle(url: string) {
    const route = url.split('/')[1] || 'dashboard';
    const titles: { [key: string]: string } = {
      'dashboard': 'Panel de Control - Gestión de Inventario',
      'users': 'Gestión de Usuarios',
      'technicians': 'Gestión de Técnicos',
      'movements': 'Movimientos de Inventario',
      'onus': 'Gestión de ONUs',
      'reports': 'Reportes y Estadísticas'
    };
    this.currentRouteTitle = titles[route] || 'Panel de Control';
  }

  navigateTo(route: string) {
    this.router.navigate([`/${route}`]);
    this.setActiveMenu(route);
  }

  // Sidebar methods
  toggleSidebar() {
    this.sidebarOpen = !this.sidebarOpen;
  }

  setActiveMenu(menu: string) {
    this.activeMenu = menu;
    if (window.innerWidth <= 767) {
      this.sidebarOpen = false;
    }
  }
}
