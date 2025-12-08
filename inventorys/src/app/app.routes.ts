import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () => import('./app.component').then(m => m.AppComponent)
  },
  {
    path: 'dashboard',
    loadComponent: () => import('./app.component').then(m => m.AppComponent)
  },

  {
    path: 'onus',
    loadComponent: () => import('./components/onus/onus.component').then(m => m.OnusComponent),
    title: 'Gestión de ONUs'
  }
];
