/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronesComportamiento.Observer;

import Entidades.Jugador;
import PatronesComportamiento.Observer.EventoJugadorDañado;
import PatronesComportamiento.Observer.EventoReaparicionJugador;
import PatronesComportamiento.Observer.EventoJugadorPoder;
import PatronesEstructurales.Adapter.AdaptadorEventosJugador;

/**
 *Patrón: Observer

 * @author LENOVO
 */
public class PoderLlamado extends AdaptadorEventosJugador{
    @Override
    public void onJugadordanado(EventoJugadorDañado event) {
        Jugador player = event.getSource();
        
        if (player.tieneMartillo()) {
            player.getPoderMartillo().desactivar();
            System.out.println("[POWERUP] Martillo desactivado por daño");
        }
    }
    
    @Override
    public void onJuegadorReaparece(EventoReaparicionJugador event) {
        Jugador player = event.getSource();
        
        if (player.tieneMartillo()) {
            player.getPoderMartillo().desactivar();
        }
        
        System.out.println("[POWERUP] Power-ups reseteados");
    }
    
    @Override
    public void onJugadorPoder(EventoJugadorPoder event) {
        System.out.println("[POWERUP] Activado: " + event.getPowerUpType());
    }
}
