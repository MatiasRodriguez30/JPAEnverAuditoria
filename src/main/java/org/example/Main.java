package org.example;

import entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("en marcha Alberto");

        try{
            entityManager.getTransaction().begin();
            /*Factura factura1 = new Factura();
            factura1.setNumero(12);
            factura1.setFecha("10/08/2020");
            System.out.println("Pipi cucu");

            Domicilio domicilio1 = new Domicilio("San Martin", 1222);
            Cliente cliente1 = new Cliente("Pablo","Muñoz",15245778);
            cliente1.setDomicilio(domicilio1);
            domicilio1.setCliente(cliente1);
            System.out.println("Pipi cucu");

            factura1.setCliente(cliente1);

            Categoria percederos = new Categoria("Percederos");
            Categoria lacteos = new Categoria("Lacteos");
            Categoria limpieza = new Categoria("Limpieza");
            System.out.println("Pipi cucu");

            Articulo articulo1= new Articulo(200, "Yogurt Ser, Sabro frutilla", 20);
            Articulo articulo2= new Articulo(300,"Detergente Magistral",80);
            System.out.println("Pipi cucu");

            articulo1.getCategoria().add(percederos);
            articulo1.getCategoria().add(lacteos);
            articulo2.getCategoria().add(limpieza);
            lacteos.getArticulo().add(articulo1);
            percederos.getArticulo().add(articulo1);
            limpieza.getArticulo().add(articulo2);
            System.out.println("Pipi cucu");
            DetalleFac det1 = new DetalleFac();
            det1.setArticulo(articulo1);
            det1.setCantidad(2);
            det1.setSubtotal(40);
            System.out.println("Pipi cucu");

            articulo1.getDetallefac().add(det1);
            factura1.getDetallesfac().add(det1);
            det1.setFactura(factura1);
            System.out.println("Pipi cucu");
            DetalleFac det2 = new DetalleFac();
            det2.setArticulo(articulo2);
            det2.setCantidad(1);
            det2.setSubtotal(80);
            System.out.println("Pipi cucu");
            articulo2.getDetallefac().add(det2);
            factura1.getDetallesfac().add(det2);
            det2.setFactura(factura1);

            factura1.setTotal(120);*/
            Factura factura1= entityManager.find(Factura.class, 1L);
            factura1.setNumero(85);

            entityManager.remove(factura1);
            System.out.println("CASI ULTIMO PASO");
            entityManager.flush();
            System.out.println("CASI");
            entityManager.getTransaction().commit();
            System.out.println("Pipi cucu");

        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}

