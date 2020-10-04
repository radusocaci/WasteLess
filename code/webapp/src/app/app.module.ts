import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {GroceryListsComponent} from './grocery-lists/grocery-lists.component';
import {GroceryService} from "./grocery.service";
import {GroceryListDetailComponent} from './grocery-list-detail/grocery-list-detail.component';
import {FaIconLibrary, FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import {faDonate, faUserEdit} from "@fortawesome/free-solid-svg-icons";
import {GroceryItemService} from "./grocery-item.service";
import {ReportComponent} from './report/report.component';
import {ReportService} from "./report.service";
import {GoalService} from "./goal.service";
import {AuthService} from "./auth.service";
import {LoginComponent} from './login/login.component';
import {BasicTokenInterceptor} from "./basic-token-interceptor.service";
import {AuthGuardService} from "./auth-guard.service";

@NgModule({
  declarations: [
    AppComponent,
    GroceryListsComponent,
    GroceryListDetailComponent,
    ReportComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    FontAwesomeModule
  ],
  providers: [
    GroceryService,
    GroceryItemService,
    ReportService,
    GoalService,
    AuthService,
    AuthGuardService,
    {provide: HTTP_INTERCEPTORS, useClass: BasicTokenInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {

  constructor(private library: FaIconLibrary) {
    library.addIcons(faUserEdit, faDonate)
  }
}
