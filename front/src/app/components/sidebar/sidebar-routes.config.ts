import {  RouteInfo } from './sidebar.metadata';

export const ROUTES: RouteInfo[] = [
    { path: '/home/dashboard', title: 'Accueil',  icon: 'dashboard', class: '', role: 'all' },
    { path: '/qcm/all', title: 'Liste des QCMs',  icon: 'content_paste', class: '', role: 'admin' },
    { path: '/qcm/all', title: 'Liste des QCMs',  icon: 'content_paste', class: '', role: 'professor' },
    { path: '/qcm', title: 'Créer QCM',  icon: 'dashboard', class: '', role: 'professor' },
    { path: '/qcm/list', title: 'Répondre aux QCM',  icon: 'content_paste', class: '', role: 'student' },
    { path: '/admin/students', title: 'Gestion des utilisateurs',  icon:'person', class: '', role: 'admin' },
  { path: '/admin/enseignants', title: 'Gestion des enseignants',  icon:'person', class: '', role: 'admin' },
  { path: '/admin/ue', title: 'Gestion des UEs',  icon:'content_paste', class: '', role: 'admin' },
  { path: 'typography', title: 'Typography',  icon:'library_books', class: '', role: '' },
  { path: 'icons', title: 'Icons',  icon:'bubble_chart', class: '', role: '' },
  { path: '/home/user-profile', title: 'User Profile',  icon:'person', class: '', role: '' },
  { path: 'maps', title: 'Maps',  icon:'location_on', class: '', role: '' },
    { path: 'notifications', title: 'Notifications',  icon:'notifications', class: '', role: '' },
    { path: 'upgrade', title: 'Upgrade to PRO',  icon:'unarchive', class: 'active-pro', role: '' },
];
