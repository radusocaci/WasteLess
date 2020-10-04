import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {GroceryListsComponent} from "./grocery-lists/grocery-lists.component";
import {GroceryListDetailComponent} from "./grocery-list-detail/grocery-list-detail.component";
import {ReportComponent} from "./report/report.component";
import {LoginComponent} from "./login/login.component";
import {AuthGuardService} from "./auth-guard.service";


const routes: Routes = [
  {path: '', redirectTo: 'grocery-lists', pathMatch: 'full', canActivate: [AuthGuardService]},
  {path: 'grocery-lists', component: GroceryListsComponent, canActivate: [AuthGuardService]},
  {path: 'grocery-lists/:id', component: GroceryListDetailComponent, canActivate: [AuthGuardService]},
  {path: 'report', component: ReportComponent, canActivate: [AuthGuardService]},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
