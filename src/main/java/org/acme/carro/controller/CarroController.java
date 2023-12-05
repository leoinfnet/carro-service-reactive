package org.acme.carro.controller;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.acme.carro.model.Carro;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Path("/")
public class CarroController {
    @GET
    public Uni<List<Carro>> getAll(){
        Uni<List<Carro>> carros = Carro.listAll();
        return carros;
    }
    @GET @Path("/{id}")
    public Uni<Carro> getById(Long id){
        Uni<Carro> carro = Carro.findById(id);
        return carro;

    }
    @POST
    @Transactional
    public Uni<RestResponse<Carro>> create(Carro carro){
        return Panache.withTransaction(carro::persist)
                .replaceWith(RestResponse.status(RestResponse.Status.CREATED,carro));
    }
}
