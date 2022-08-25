import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { NgCircleProgressModule } from 'ng-circle-progress';
import { ComponentsComponent } from './components/components.component';
import { HysComponent } from './components/hys/hys.component';
import { HeaderComponent } from './components/header/header.component';
import { LogoApComponent } from './components/logo-ap/logo-ap.component';

import { BannerComponent } from './components/banner/banner.component';
import { AcercaComponent } from './components/acerca/acerca.component';
import { ExperienciaComponent } from './components/experiencia/experiencia.component';
import { EducacionComponent } from './components/educacion/educacion.component';
import { ProyectoComponent } from './components/proyecto/proyecto.component';
import { FooterComponent } from './components/footer/footer.component';

import { HttpClient, HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component'

import { FormsModule } from '@angular/forms';
import { interceptorProvider } from './service/interceptor-service';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia.component';
import { NeweducacionComponent } from './components/educacion/neweducacion.component';
import { EditeducacionComponent } from './components/educacion/editeducacion.component';
import { NewacercaComponent } from './components/acerca/newacerca.component';
import { EditacercaComponent } from './components/acerca/editacerca.component';
import { NewproyectoComponent } from './components/proyecto/newproyecto.component';
import { EditproyectoComponent } from './components/proyecto/editproyecto.component';

@NgModule({
  declarations: [
    AppComponent,
    ComponentsComponent,
    HysComponent,
    HeaderComponent,
    LogoApComponent,
    
    BannerComponent,
    AcercaComponent,
    ExperienciaComponent,
    EducacionComponent,
    ProyectoComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    NewExperienciaComponent,
    EditExperienciaComponent,
    NeweducacionComponent,
    EditeducacionComponent,
    NewacercaComponent,
    EditacercaComponent,
    NewproyectoComponent,
    EditproyectoComponent
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,

    NgCircleProgressModule.forRoot({}),
    
    HttpClientModule,

    FormsModule

  ],

  providers: [
    interceptorProvider
  ],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
