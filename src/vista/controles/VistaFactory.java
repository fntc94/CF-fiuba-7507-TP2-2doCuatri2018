package vista.controles;

import javafx.scene.control.Alert;
import modelo.edificios.Castillo;
import modelo.edificios.Cuartel;
import modelo.edificios.PlazaCentral;
import modelo.unidades.Aldeano;
import modelo.unidades.ArmaDeAsedio;
import modelo.unidades.Arquero;
import modelo.unidades.Espadachin;
import vista.controladores.IPosicionableController;
import vista.controladores.edificios.CastilloController;
import vista.controladores.edificios.CuartelControler;
import vista.controladores.edificios.PlazaCentralController;
import vista.controladores.unidades.AldeanoController;
import vista.controladores.unidades.ArmaDeAsedioController;
import vista.controladores.unidades.ArqueroController;
import vista.controladores.unidades.EspadachinController;

public class VistaFactory {

        private JuegoControl juegoControl;
        private MapaControl mapaControl;
        private String color;

        public VistaFactory(JuegoControl juegoControl, MapaControl mapaControl, String color){

            this.juegoControl = juegoControl;
            this.mapaControl = mapaControl;
            this.color = color;
        }


        public PosicionableVista crearVista(Aldeano aldeano){

            AldeanoController aldeanoController = new AldeanoController(aldeano, this.color, this.mapaControl, this.juegoControl);
            PosicionableVista vista = new PosicionableVista(aldeanoController);

            aldeano.onDestruido(atacable -> this.mapaControl.remover(vista));
            return vista;
        }

        public PosicionableVista crearVista(Castillo castillo){
            CastilloController controller = new CastilloController(castillo, this.color, mapaControl, this.juegoControl);
            PosicionableVista vista = new PosicionableVista(controller);
            castillo.onDestruido(atacable -> this.mapaControl.remover(vista));
            return vista;
        }

        public PosicionableVista crearVista (PlazaCentral plazaCentral){
            PlazaCentralController controller = new PlazaCentralController(plazaCentral, this.color, mapaControl, this.juegoControl);
            PosicionableVista vista = new PosicionableVista(controller);
            plazaCentral.onDestruido(atacable -> this.mapaControl.remover(vista));
            return vista;
        }

        public PosicionableVista crearVista(Espadachin espadachin){
            EspadachinController controller =  new EspadachinController(espadachin, this.color, this.mapaControl, this.juegoControl);
            PosicionableVista vista = new PosicionableVista(controller);
            espadachin.onDestruido(atacable -> this.mapaControl.remover(vista));
            return vista;
        }

        public PosicionableVista crearVista(Arquero arquero){
            ArqueroController controller = new ArqueroController(arquero, this.color, this.mapaControl, this.juegoControl);
            PosicionableVista vista = new PosicionableVista(controller);
            arquero.onDestruido(atacable -> this.mapaControl.remover(vista));
            return vista;

        }

        public PosicionableVista crearVista(ArmaDeAsedio armaDeAsedio){
            ArmaDeAsedioController controller = new ArmaDeAsedioController(armaDeAsedio, this.color, this.mapaControl, this.juegoControl);
            PosicionableVista vista = new PosicionableVista(controller);
            armaDeAsedio.onDestruido(atacable -> this.mapaControl.remover(vista));
            return vista;
        }

        public PosicionableVista crearVista(Cuartel cuartel){
            CuartelControler controler = new CuartelControler(cuartel, this.color, this.mapaControl, this.juegoControl);
            PosicionableVista vista = new PosicionableVista(controler);
            cuartel.onDestruido(atacable -> this.mapaControl.remover(vista));
            return vista;
        }

}
