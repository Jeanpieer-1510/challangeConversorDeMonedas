package com.piero.Conversor.servicios;

import com.piero.Conversor.conexiones.ConsultaApi;
import com.piero.Conversor.modelos.Transformacion;

public class ConversorMonedaService {

    private final ConsultaApi consultaApi;

    public ConversorMonedaService() {
        this.consultaApi = new ConsultaApi();
    }

    /**
     * Realiza la conversión predefinida de monedas.
     */
    public Transformacion convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad) {
        return consultaApi.convertirMoneda(monedaOrigen, monedaDestino, cantidad);
    }

    /**
     * Realiza la conversión personalizada dada por el usuario.
     */
    public Transformacion convertirMonedaPersonalizada(String monedaOrigen, String monedaDestino, double cantidad) {
        return consultaApi.convertirMoneda(monedaOrigen, monedaDestino, cantidad);
    }
}
