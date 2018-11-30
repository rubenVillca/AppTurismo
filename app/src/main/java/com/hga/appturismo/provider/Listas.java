package com.hga.appturismo.provider;

import com.hga.appturismo.modelo.ModeloHotel;
import com.hga.appturismo.modelo.ModeloImagen;
import com.hga.appturismo.modelo.ModeloLugarTuristico;
import com.hga.appturismo.modelo.ModeloPuntaje;
import com.hga.appturismo.modelo.ModeloRestaurante;
import com.hga.appturismo.modelo.ModeloUsuario;
import com.hga.appturismo.util.Constants;

import java.util.ArrayList;

public class Listas {
    private ArrayList<ModeloHotel> listaHoteles;
    private ArrayList<ModeloLugarTuristico> listaLugares;
    private ArrayList<ModeloRestaurante> listaRestaurantes;
    private ArrayList<ModeloUsuario> listaUsuarios;
    private ArrayList<ModeloPuntaje> listaPuntaje;

    public Listas() {
        this.listaHoteles = new ArrayList<>();
        this.listaLugares = new ArrayList<>();
        this.listaRestaurantes = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        this.listaPuntaje = new ArrayList<>();

        int idLugar = setListaLugarTuristico();
        setListaAcontecimientos(idLugar);
        setListaHoteles();
        setListaRestaurantes();
        setListaUsuarios();
    }

    public ArrayList<ModeloHotel> getListaHoteles() {
        return listaHoteles;
    }

    public ArrayList<ModeloLugarTuristico> getListaLugares() {
        return listaLugares;
    }

    public ArrayList<ModeloRestaurante> getListaRestaurantes() {
        return listaRestaurantes;
    }

    public ArrayList<ModeloUsuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public ArrayList<ModeloPuntaje> getListaPuntaje() {
        return listaPuntaje;
    }

    private void setListaHoteles() {
        int idHotel = 0;
        ModeloHotel hotel;

        hotel=new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Adara Suites Apart Hotel ");
        //hotel.setDescripcion("Hospedaje, administración y manejo de hoteles, apart hoteles, prestación de todo tipo de servicios hoteleros, organización de eventos, recepciones, servicios de restaurant, cafetería, spa, café, bar, etc.");
        //hotel.setLinea("");
        hotel.setGpsX(-17.38467001063881f);
        hotel.setGpsY(-66.16149187088013f);
        hotel.setDireccion("Calle Junín nro. 867 Zona: Central");
        hotel.setImagenesFirebaseArreglo(ModeloImagen.TIPO_HOTEL, new String[]{"adara suites apart hotel3.jpg", "adara suites apart hotel4.jpg", "adara suites apart hotel1.jpg", "adara suites apart hotel2.jpg"});
        hotel.setTelefono(4662020);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("");
        hotel.setEmail("info@adarahotel.com.bo");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel=new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Americana Hotel");
        //hotel.setDescripcion("Rubro de la hotelería, turismo, convenciones y actividades comerciales, importación, equipamiento hotelero, importación de maquinaria pesada, liviana y pequeña, textiles, insumos plásticos, etc.");
        //hotel.setLinea("");
        hotel.setGpsX(-17.399221249840263f);
        hotel.setGpsY(-66.15543812513351f);
        hotel.setDireccion("Calle Esteban Arze nro. 788 Edificio: Americana Hotel Zona: Sud-Oeste");
        hotel.setImagenesFirebaseArreglo(ModeloImagen.TIPO_HOTEL, new String[]{"americana hotel0.jpg", "americana hotel2.jpg", "americana hotel3.jpg", "americana hote1.jpg"});
        hotel.setTelefono(4250552);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.americanahotel.com.bo");
        hotel.setEmail("americanahotel@email.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel=new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Anteus Apart Hotel");
        //hotel.setDescripcion("Hospedaje");
        //hotel.setLinea("");
        hotel.setGpsX(-17.375887515468104f);
        hotel.setGpsY(-66.15400180220604f);
        hotel.setDireccion("Av. Potosi nro. 1365 Zona: Recoleta");
        hotel.setImagenesFirebaseArreglo(ModeloImagen.TIPO_HOTEL, new String[]{"anteus apart hotel3.jpg", "anteus apart hotel1.jpg", "anteus apart hotel2.jpg" });
        hotel.setTelefono(4245067);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.hotelanteus.com");
        hotel.setEmail("reservas@hotelanteus.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel=new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Apart Hotel Regina");
        //hotel.setDescripcion("Hospedaje");
        //hotel.setLinea("");
        hotel.setGpsX(-17.38629988377598f);
        hotel.setGpsY(-66.15779981017113f);
        hotel.setDireccion("C. España nro.636");
        hotel.setImagenesFirebaseArreglo(ModeloImagen.TIPO_HOTEL, new String[]{"apart hotel regina1.jpg", "apart hotel regina2.jpg", "apart hotel regina3.jpg", "apart hotel regina4.jpg", "apart hotel regina5.jpg", "apart hotel regina7.jpg", "apart hotel regina8.jpg" });
        hotel.setTelefono(0);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("hotelregina.com-hotel.com");
        hotel.setEmail("");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel=new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Armenia Hotel");
        //hotel.setDescripcion("Servicios de hotelería");
        //hotel.setLinea("");
        hotel.setGpsX(-17.394268583333226f);
        hotel.setGpsY(-66.16348877549171f);
        hotel.setDireccion("General Achá nro. 560 Edificio: Hotel Mundial Piso: Pb Zona: Barrio Noroeste");
        hotel.setImagenesFirebaseArreglo(ModeloImagen.TIPO_HOTEL, new String[]{"armenia hotel5.jpg", "armenia hotel1.jpg", "armenia hotel2.jpg", "armenia hotel3.jpg" });
        hotel.setTelefono(0);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("");
        hotel.setEmail("virbaba@hotmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel=new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Banana Tropic");
        //hotel.setDescripcion("Brinda servicios de hotelería");
        //hotel.setLinea("");
        hotel.setGpsX(-16.998434127224467f);
        hotel.setGpsY(-65.43705940246582f);
        hotel.setDireccion("Carretera Cbba - Snt. Cruz");
        hotel.setImagenesFirebaseArreglo(ModeloImagen.TIPO_HOTEL, new String[]{"banana tropic2.jpg", "banana tropic3.jpg", "banana tropic1.jpg" });
        hotel.setTelefono(4700956);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("");
        hotel.setEmail("");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel=new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Casa Campestre");
        //hotel.setDescripcion("Hospedaje");
        //hotel.setLinea("");
        hotel.setGpsX(-17.380707573002113f);
        hotel.setGpsY(-66.25139951705933f);
        hotel.setDireccion("Av. Elías Meneces");
        hotel.setImagenesFirebaseArreglo(ModeloImagen.TIPO_HOTEL, new String[]{"casa campestre4.jpg", "casa campestre0.jpg", "casa campestre1.jpg", "casa campestre2.jpg", "casa campestre3.jpg" });
        hotel.setTelefono(4350312);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("lacasacampestre.com");
        hotel.setEmail("");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel=new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Cesar's Plaza Hotel");
        //hotel.setDescripcion("Hospedaje, servicio gastronómico, servicio de bebida");
        //hotel.setLinea("");
        hotel.setGpsX(-17.39313661785511f);
        hotel.setGpsY(-66.15532882511616f);
        hotel.setDireccion("C. 25 de Mayo entre Bolívar y Sucre nro. 210 Zona: Central");
        hotel.setImagenesFirebaseArreglo(ModeloImagen.TIPO_HOTEL, new String[]{"cesar's plaza hotel.jpg", "cesar's plaza hotel1.jpg", "cesar's plaza hotel2.jpg", "cesar's plaza hotel3.jpg" });
        hotel.setTelefono(4254032);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.cesarsplaza.com");
        hotel.setEmail("info@cesarsplaza.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel=new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("City Hotel");
        //hotel.setDescripcion("Realizar actividades de la industria de la hotelería. Servicios en el rubro de hotelería y todas las actividades que tengan relación con la misma.");
        //hotel.setLinea("");
        hotel.setGpsX(-17.39501597105829f);
        hotel.setGpsY(-66.15571975708008f);
        hotel.setDireccion("C. Jordán nro. 341 entre 25 de mayo y Esteban Arze Zona: Central");
        hotel.setImagenesFirebaseArreglo(ModeloImagen.TIPO_HOTEL, new String[]{"city hotel ltda5.jpg", "city hotel ltda1.jpg", "city hotel ltda2.jpg", "city hotel ltda3.jpg"});
        hotel.setTelefono(4222993);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.cityhotelbolivia.com");
        hotel.setEmail("cityhotel42@hotmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel=new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Gran Hotel Ambassador");
        //hotel.setDescripcion("Servicios de hotelería.");
        //hotel.setLinea("");
        hotel.setGpsX(-17.389441204120267f);
        hotel.setGpsY(-66.15731835365295f);
        hotel.setDireccion("C. España nro. 349 Zona: Central");
        hotel.setImagenesFirebaseArreglo(ModeloImagen.TIPO_HOTEL, new String[]{"gran hotel ambassador ltda2.jpg", "gran hotel ambassador ltda1.jpg" });
        hotel.setTelefono(4257832);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("");
        hotel.setEmail("granhotelambassador@gmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel=new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Gran Hotel Cochabamba");
        //hotel.setDescripcion("Hotelería, gastronomía, spa.");
        //hotel.setLinea("");
        hotel.setGpsX(-17.378048621747695f);
        hotel.setGpsY(-66.15223087370396f);
        hotel.setDireccion("Plaza Ubaldo Anze E-415, La Recoleta, Cochabamba, Bolivia");
        hotel.setImagenesFirebaseArreglo(ModeloImagen.TIPO_HOTEL, new String[]{"gran hotel cochabamba s.a1.jpg", "gran hotel cochabamba s.a2.jpg", "gran hotel cochabamba s.a6.jpg", "gran hotel cochabamba.jpg", "gran hotel cochabamba 2.jpg", "gran hotel cochabamba 3.jpg" });
        hotel.setTelefono(4489420);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.granhotelcochabamba.com.bo");
        hotel.setEmail("info@granhotelcochabamba.com.bo");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel=new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal \"BONAIRENSE\"");
        //hotel.setDescripcion("Hospedaje");
        //hotel.setLinea("");
        hotel.setGpsX(-17.389546148501218f);
        hotel.setGpsY(-66.15610867738724f);
        hotel.setDireccion("C. 25 de Mayo entre Ecuador y Mayor Rocha nro. 0329");
        hotel.setImagenesFirebaseArreglo(ModeloImagen.TIPO_HOTEL, new String[]{"hostal bonairense4.jpg", "hostal bonairense7.jpg", "hostal bonairense9.jpg", "hostal bonairense.jpg", "hostal bonairense1.jpg"});
        hotel.setTelefono(4567452);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("hostal-bonairense.com");
        hotel.setEmail("");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel=new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal Arévalo");
        //hotel.setDescripcion("Servicios de hospedaje y turísticos");
        //hotel.setLinea("");
        hotel.setGpsX(-17.375053015722237f);
        hotel.setGpsY(-66.16297513246536f);
        hotel.setDireccion("Av. Teófilo Vargas nro. 110 Edificio: Hostal Arévalo Piso:1 ofi.:101 Zona Cala Cala");
        hotel.setImagenesFirebaseArreglo(ModeloImagen.TIPO_HOTEL, new String[]{"hostal arebalo1.jpg", "hostal arebalo2.jpg"});
        hotel.setTelefono(4287283 );
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("");
        hotel.setEmail("harold_a123@hotmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel=new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal Maya Bolivia");
        //hotel.setDescripcion("Servicio de hospedaje");
        //hotel.setLinea("");
        hotel.setGpsX(-17.39239882086965f);
        hotel.setGpsY(-66.16528317332268f);
        hotel.setDireccion("C. Colombia nro. 710 Zona: Noroeste");
        hotel.setImagenesFirebaseArreglo(ModeloImagen.TIPO_HOTEL, new String[]{"hostal maya bolivia1.jpg", "hostal maya bolivia2.jpg" });
        hotel.setTelefono(4259701);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("");
        hotel.setEmail("ricardo_pol-acha@hotmial.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel=new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Apart Hotel La Corona");
        //hotel.setDescripcion("Hospedaje");
        //hotel.setLinea("");
        hotel.setGpsX(-17.388023169265743f);
        hotel.setGpsY(-66.16324067115784f);
        hotel.setDireccion("C. Juan de la Reza nro. 433 entre c. Tumusla y Av. Rafael Urquidi (Central)");
        hotel.setImagenesFirebaseArreglo(ModeloImagen.TIPO_HOTEL, new String[]{"apart hotel la corona1.jpg"});
        hotel.setTelefono(4520269);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("reserve.affiniaspence.com");
        hotel.setEmail("lacorona@supernet.com.bo");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel=new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Boston");
        //hotel.setDescripcion("Servicios de hotelería");
        //hotel.setLinea("");
        hotel.setGpsX(-17.39149976674768f);
        hotel.setGpsY(-66.15580558776855f);
        hotel.setDireccion("C. 25 De Mayo nro. 167 Edificio: Hotel Boston Zona: Central");
        hotel.setImagenesFirebaseArreglo(ModeloImagen.TIPO_HOTEL, new String[]{"hotel boston1.jpg"});
        hotel.setTelefono(4224421);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("");
        hotel.setEmail("hboston@supernet.com.bo");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel=new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Briston");
        //hotel.setDescripcion("Servicios de hotel");
        //hotel.setLinea("");
        hotel.setGpsX(-17.394549813918648f);
        hotel.setGpsY(-66.16483876481652f);
        hotel.setDireccion("C. Suipacha nro. 181 Zona: Central");
        hotel.setImagenesFirebaseArreglo(ModeloImagen.TIPO_HOTEL, new String[]{"hotel briston.jpg", "hotel briston1.jpg", "hotel briston3.jpg"});
        hotel.setTelefono(0);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("");
        hotel.setEmail("");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel=new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Camino Plaza");
        //hotel.setDescripcion("Servicios de hotelería");
        //hotel.setLinea("");
        hotel.setGpsX(-17.36868151040645f);
        hotel.setGpsY(-66.1634150147438f);
        hotel.setDireccion("C.  Huallparimachi nro. 1862 Zona: Cala Cala");
        hotel.setImagenesFirebaseArreglo(ModeloImagen.TIPO_HOTEL, new String[]{"hotel camino plaza.jpg", "hotel camino plaza2.jpg", "hotel camino plaza3.jpg", "hotel camino plaza5.jpg"});
        hotel.setTelefono(4200306);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.caminoplaza.com");
        hotel.setEmail("hotel@hotelcaminoplaza.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);
    }

    private void setListaRestaurantes() {
        int idRestaurante = 0;
        ModeloRestaurante restaurante;

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Carne y Fuego");
        //restaurante.setDescripcion("Restaurant - churrasquería");
        //restaurante.setLinea("");
        restaurante.setGpsX(-17.376764248067403f);
        restaurante.setGpsY(-66.17607034742832f);
        restaurante.setDireccion("Av. Melchor Pérez nro. 1555 Zona: Sarco");
        restaurante.setImagenesFirebaseArreglo(ModeloImagen.TIPO_RESTAURANTE, new String[]{"carne y fuego3.png", "carne y fuego2.png" });
        restaurante.setTelefono(4243800);
        restaurante.setHorario("Martes a Viernes 18:00-23:00 Sábado 18:00-23:00 Domingo 11:00-15:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Carniclub");
        //restaurante.setDescripcion("Preparación, elaboración y venta de comida rápida, venta de bebidas");
        //restaurante.setLinea("");
        restaurante.setGpsX(-17.37802494378927f);
        restaurante.setGpsY(-66.15633934736252f);
        restaurante.setDireccion("C. Aniceto Padilla nro. 339 Zona: Norte");
        restaurante.setImagenesFirebaseArreglo(ModeloImagen.TIPO_RESTAURANTE, new String[]{"carniclub1.jpg", "carniclub2.jpg"  });
        restaurante.setTelefono(4036494);
        restaurante.setHorario("Lunes a Sábado: 17:00-22:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Chicken´s Kingdom");
        //restaurante.setDescripcion("Expendio de comida rápida, subsidiaria- mente a toda otra actividad comercial e industrial tendiente o relacionada con la venta de comida rápida, elaborar y comercializar productos lácteos, helados, bebidas aderezadas con jugo y/o aguas naturales, envasadas. Importar y comercializar insumos y maquinaria, equipos y materiales para la industria alimenticia, etc.");
        //restaurante.setLinea("");
        restaurante.setGpsX(-17.391429377982195f);
        restaurante.setGpsY(-66.15454092621803f);
        restaurante.setDireccion("Av. San Martin nro. 150 Zona: Central");
        restaurante.setImagenesFirebaseArreglo(ModeloImagen.TIPO_RESTAURANTE, new String[]{"chicken s kingdom s.r.l.2.jpg", "chicken s kingdom s.r.l.1.jpg" });
        restaurante.setTelefono(4660328);
        restaurante.setHorario("Lunes a Domingo 10:00 - 23:45");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Paprika");
        //restaurante.setDescripcion("Preparado, suministro y venta de alimentación, servicio de restaurant, bar y café, catering, venta de comidas nacionales e internacionales; importar, exportar productos alimenticios, industrialización, procesamiento, comercialización, transformación y reexcepto condimentos; importar maquinaria y equipos relacionadas con alimentos, etc.");
        //restaurante.setLinea("");
        restaurante.setGpsX(-17.38526897630569f);
        restaurante.setGpsY(-66.15441352128983f);
        restaurante.setDireccion("C. Chuquisaca nro. 688 Zona: Noreste");
        restaurante.setImagenesFirebaseArreglo(ModeloImagen.TIPO_RESTAURANTE, new String[]{"paprika 3.jpg", "paprika 1.jpg", "paprika 2.jpg" });
        restaurante.setTelefono(4662400);
        restaurante.setHorario("Lunes a Sábado 11:30 - 01:30 Domingo 11:30 -00:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("La Chingada");
        //restaurante.setDescripcion("Restaurant, venta de comida y bebidas");
        //restaurante.setLinea("");
        restaurante.setGpsX(-17.376025745120195f);
        restaurante.setGpsY(-66.16588532924652f);
        restaurante.setDireccion("C. José Quintín Mendoza nro. 1489 Zona: Cala Cala");
        restaurante.setImagenesFirebaseArreglo(ModeloImagen.TIPO_RESTAURANTE, new String[]{"la chingada1.jpg", "la chingada2.jpg", "la chingada.jpg"});
        restaurante.setTelefono(4501156);
        restaurante.setHorario("Lunes a Sábado de 18:00 – 23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Apthapi World Street Food");
        //restaurante.setDescripcion("Venta de café, jugos , sandwiches y comida al paso");
        //restaurante.setLinea("");
        restaurante.setGpsX(-17.371657381677554f);
        restaurante.setGpsY(-66.16151869297028f);
        restaurante.setDireccion("C. Juan Capriles nro. 170 Zona: Cala Cala");
        restaurante.setImagenesFirebaseArreglo(ModeloImagen.TIPO_RESTAURANTE, new String[]{ });
        restaurante.setTelefono(67426557);
        restaurante.setHorario("Lunes a Viernes: 12:00 – 14:00  17:00 – 22:30 Sábado 18:00 – 21:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Con Yapa");
        //restaurante.setDescripcion("Local de comida silpanchería.");
        //restaurante.setLinea("");
        restaurante.setGpsX(-17.37377630054552f);
        restaurante.setGpsY(-66.14937096834183f);
        restaurante.setDireccion("Av. Melchor Urquidi nro. 1430 Zona: Queru Queru");
        restaurante.setImagenesFirebaseArreglo(ModeloImagen.TIPO_RESTAURANTE, new String[]{ });
        restaurante.setTelefono(4548627);
        restaurante.setHorario("Lunes a Domingo de 11:00 - 22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);
    }

    private int setListaLugarTuristico() {
        int idLugTur = 0;
        ModeloLugarTuristico lugarTuristico;

        //SITIOS NATURALES
        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_SITIOS_NATURALES);
        lugarTuristico.setNombre("Árbol de Jarka");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"arbol jarka2.jpg", "arbol jarka1.jpg" });
        lugarTuristico.setDescripcion("Árbol “Jarka”, es un árbol con el tronco torcido ubicado en la Plazuela 27 de mayo," +
                " también denominado árbol de la juventud. En años anteriores esta zona se llamaba “loza katu” por la venta de cerámica.");
        lugarTuristico.setHorario("");
        lugarTuristico.setDireccion("Tarata, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.6144987102532f);
        lugarTuristico.setGpsY(-66.02461002767086f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);



        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_TIRAQUE);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_SITIOS_NATURALES);
        lugarTuristico.setNombre("Árbol milenario");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"arbol milenario 2.jpg", "arbol milenario 1.jpg" });
        lugarTuristico.setDescripcion("Tan solo caminar por sus calles, como en sus alrededores, esta región encanta por sus diferentes atractivos de carácter cultural y la belleza natural de sus paisajes interandinos." +
                " Sin pasar desapercibido un gigantesco árbol de muchos años de vida que tiene una gran frondosidad.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Tiraque, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.42138f);
        lugarTuristico.setGpsY(-65.71503f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CHAPARE);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_SITIOS_NATURALES);
        lugarTuristico.setNombre("Laguna San Isidro");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{ "laguna san isidro1.jpg", "laguna san isidro.jpg" });
        lugarTuristico.setDescripcion("La laguna de san isidro es principalmente atractivo de la comunidad, de aguas cristalinas en su interior conviven especies de peces como el pejerrey dorado. Este espejo de agua natural posee una diversidad de ofertas en cuanto a actividades re-creativas, que van desde la simple pesca deportiva, paseos en botes, natación.\n" +
                "Durante el mes de abril se realiza el Festival turístico gastronómico y la competencia de motociclismo, donde participan de esta actividad autoridades municipales y departamentales.\n" +
                "Galeón Morgan es la representación artística del barco pirata ingles el cual navegaba por el atlántico, robando riquezas del nuevo mundo a los barcos mercaderes españoles, galeón es un mirador turístico y centro de atención turística, construido de madera y hierro.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Sacaba, Chapare");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.408908635978058f);
        lugarTuristico.setGpsY(-65.89654862880707f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_TIRAQUE);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_SITIOS_NATURALES);
        lugarTuristico.setNombre("Ch’ejta Rumi");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"chetjta rumi2.jpg", "chejta rumi.jpg" });
        lugarTuristico.setDescripcion("Ch’ejta Rumi también conocida como la “Piedra del Inca”, una piedra enorme partida por un rayo, por el que pasa el río Millu Mayo, además de ser un espacio en el que los turistas pueden acampar y estar junto a la naturaleza, nutrido por frondosos alisos, eucaliptos y kewiñas.\n" +
                "Allí mismo se encuentra un antiguo molino de piedra, que, a pesar de varios años de su construcción, continúa funcionando.\n");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Tiraque, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.41091f);
        lugarTuristico.setGpsY(-65.71453f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_SITIOS_NATURALES);
        lugarTuristico.setNombre("Colina de San Sebastián La Coronilla");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"colinas de san sebastian la coronilla2.jpg", "colinas de san sebastian la coronilla1.jpg" });
        lugarTuristico.setDescripcion("En la zona sur de la ciudad, muy cerca de la Terminal de Buses, se encuentra la colina de San Sebastián en cuya cuesta se halla el monumento a las Heroínas de la Coronilla, el Paseo de Los Héroes y el Monumento a las Armas, monumentos que son considerado Sitio de Interés Histórico, Cultural y Nacional. El monumento a las Heroínas, esculpida en bronce en 1922, representa simbólicamente la participación de un grupo de valerosas mujeres que resistieron a las tropas del General Goyeneche, durante la guerra de la independencia.\n" +
                "\n" +
                "El día de la Madre en Bolivia se celebra el 27 de Mayo en memoria del movimiento heroico de las mujeres cochabambinas al enfrentarse en desigual lucha ante los realistas y por ser el único movimiento libertario en Latinoamérica que demostró el valor de las mujeres para la consolidación de la soberanía de la patria.\n");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Av. Aroma frente a la plaza Esteban Arce, Cochabamba");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.4047292f);
        lugarTuristico.setGpsY(-66.1604894f);
        lugarTuristico.setLinea("212");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_SITIOS_NATURALES);
        lugarTuristico.setNombre("Parque Nacional Tunari");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"parque nacional tunari3.jpg", "parque nacional tunari1.jpg" });
        lugarTuristico.setDescripcion("El parque Nacional Tunari, fue creado y declarado Parque Nacional el 30 de marzo de 1962. Este pico del Tunari, se encuentra a 5.200 m.s.n.m. y es uno de los atractivos turísticos naturales más representativos de la ciudad de Cochabamba.\n" +
                "\n" +
                "En el Parque Tunari se puede disfrutar de grandes momentos de recreación y esparcimiento, sobre todo para quienes acuden al encuentro con la naturaleza. El parque brinda la posibilidad de disfrutar de la naturaleza, practicar ecoturismo, turismo de aventura y paisajismo ya que desde sus faldas se puede apreciar esta bella ciudad.\n" +
                "\n" +
                "En la ladera sur del área existen bosque implantados de pinos y eucaliptos, esto contribuye a estabilizar las pendientes de las zonas torrenteras y también para mantener el equilibrio ambiental de los valles. A la fecha se registraron más de 30 especies de mamíferos, 136 especies de aves, dos especies de reptiles y dos anfibios. Cuenta con bosques naturales y artificiales de diversas especies y principalmente algunas típicas de la cordillera. Es el hábitat de cóndores, llamas, alpacas, vizcachas y gansos andinos. Uno de los tantos valores biológicos del area y su aspecto más relevante, es su condición de fuente de recursos hídricos, superficiales y subterráneos que beneficia a los valles de Cochabamba. \n" +
                "El parque Tunari es un área protegida de Bolivia, ubicado en el oeste del departamento de Cochabamba. Abarca las provincias de Ayopaya, Cercado, Quillacollo, Chapare y Tapacarí. Los municipios involucrados son: Morochata, Cochabamba, Quillacollo, Sipe Sipe, Tiquipaya, Vinto, Colcapirhua, Sacaba, Colomi, Villa Tunari y Tapacarí.\n");
        lugarTuristico.setHorario("Abierto ");
        lugarTuristico.setDireccion("Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.334508645845624f);
        lugarTuristico.setGpsY(-66.14096760749817f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ARANI);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_SITIOS_NATURALES);
        lugarTuristico.setNombre("Puya Raymundi");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"puya raymondi2.jpg", "puya raymondi1.jpg" });
        lugarTuristico.setDescripcion("La Puya Raymundi, planta catalogada como especie en extinción, habita en la región, la cual florece cada cien años aproximadamente, siendo polinizada por el picaflor de pico curvo, especie que también se encuentra en peligro de extinción.");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Vacas, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.611618844895645f);
        lugarTuristico.setGpsY(-65.53942054510117f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CHAPARE);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_SITIOS_NATURALES);
        lugarTuristico.setNombre("Laguna Corani");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"laguna corani0.jpg", "laguna corani.jpg"  });
        lugarTuristico.setDescripcion("Laguna artificial de mágico encanto rodeada de bosques de pinos y ríos, donde la brisa del altiplano se transforma en un encuentro placentero con lo telúrico y enigmático de un lugar de pesca y recreación tradicional.");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Colomi, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.272670015135095f);
        lugarTuristico.setGpsY(-65.90230464935303f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_GERMAN_JORDAN);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_SITIOS_NATURALES);
        lugarTuristico.setNombre("Cascada Toro Warkhu");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"cascada toro warkhu.jpg"});
        lugarTuristico.setDescripcion("Toro Warkhu, una cascada de al menos 50 m. de altura, maravilla natural que está a menos de tres horas de caminata de la plaza principal del municipio de Vacas, que desde hace un par de años impulsa el turismo para fortalecer su economía.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Vacas, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.635535799397076f);
        lugarTuristico.setGpsY(-65.51352381706238f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_GERMAN_JORDAN);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_SITIOS_NATURALES);
        lugarTuristico.setNombre("Cascadas Rosas Pampa");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"cascadas rosas pampa1.jpg"});
        lugarTuristico.setDescripcion("Cascadas Rosas Pampa ubicada en la provincia de Arani de aguas cristalinas para pasar un momento de diversión además de la vista agradable que posee este atractivo natural. ");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Vacas, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.62798987749787f);
        lugarTuristico.setGpsY(-65.53587198257446f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_SITIOS_NATURALES);
        lugarTuristico.setNombre("Chocalla");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"chocalla3.jpg", "chocalla1.jpg", "chocalla2.jpg" });
        lugarTuristico.setDescripcion("Del extremo norte de Quillacollo, en una colina a más de 3.200 metros sobre el nivel del mar, a la distancia se observa la ciudad de Cochabamba envuelta en una nube gris que la aprisiona. El bosque tiene 40 hectáreas con más de 10 variedades de pinos, eucaliptos, kewiñas y otras que la comunidad administra.\n" +
                "Además de la oferta ecológica, Chocaya tiene otros atractivos históricos como la primera planta hidroeléctrica de Cochabamba que funcionó desde 1908. Ahora las máquinas son piezas de museo.\n" +
                "Las cascadas naturales, los ocho molinos antiguos de piedra (sin funcionar), la producción de flores, la horticultura, los senderos de donde emergen variedad de aves y mamíferos como el zorro andino, las zarigüeyas, los zorrinos, búhos, palomas, halcones y, en alguna ocasión, también planean desde las alturas los cóndores en busca de alimento.\n" +
                "\n" +
                "El centro ecológico cuenta además con áreas de camping para excursionistas, parrilleros, restaurant y áreas de parqueo. Se procede a la atención a las delegaciones una vez que éstas la solicitan a la comunidad de acuerdo al número de personas, y si requieren servicios de cocina o solamente el paseo por el bosque. Los fondos que dejan los excursionistas benefician a la comunidad.\n");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Quillacollo, Bolivia");
        lugarTuristico.setTelefono(4416359);
        lugarTuristico.setGpsX(-17.349936890297155f);
        lugarTuristico.setGpsY(-66.29992872476578f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_SITIOS_NATURALES);
        lugarTuristico.setNombre("Parque Eco - turístico Pairumani");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{ "parque ecoturistico pairumani3.jpg", "parque ecoturistico pairumani1.jpg", "parque ecoturistico pairumani2.jpg"});
        lugarTuristico.setDescripcion("El parque Pairumani está rodeado de vertientes de límpidas aguas que descienden directamente del Tunari, un gran bosque de eucaliptos y qewiñas. El parque tiene parrilleros, baños, agua potable y basureros a disposición. Además, en el lugar se alquilan carpas, de 2 a 25 personas, a quienes quieran pasar la noche, dentro del parque se encuentra una cascada natural y campos deportivos para la recreación.\n" +
                "En este lugar funcionaba una estación hidroeléctrica que pertenecía al Barón de Estaño.\n");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Av. Pairumani, Vinto, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.344708944824216f);
        lugarTuristico.setGpsY(-66.33162438869476f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CHAPARE);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_SITIOS_NATURALES);
        lugarTuristico.setNombre("Incachaca");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"incachaca2.jpg", "incachaca1.5.jpg", "incachaca1.jpg" });
        lugarTuristico.setDescripcion("La ruta hacia Incachaca se encuentra sobre la antigua carretera hacia Santa Cruz. Es una zona tropical en la que se pueden observar hermosas caídas de aguas cristalinas y riachuelos que labraron la piedra, además de una exuberante vegetación y lugares adecuados para la pesca deportiva.\n" +
                "Existe un sendero natural en medio de la naturaleza donde se pone a prueba la resistencia física.\n" +
                "Sus atractivos son: El velo de novia, la ventana del diablo, la casa de las máquinas y el puente colgante.\n");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Colomi, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.237111339419496f);
        lugarTuristico.setGpsY(-65.81713378429413f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_SITIOS_NATURALES);
        lugarTuristico.setNombre("Laguna Alalay");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"laguna alalay2.jpg", "laguna alalay1.jpg", "laguna alalay3.jpg" });
        lugarTuristico.setDescripcion("La laguna Alalay tiene en su entorno una forma vehicular denominada “circuito Bolivia” que permite el recorrido vehicular alrededor de este atractivo. Así mismo, posee una franja peatonal para bicicletas que forma parte de la ciclovía que llega a tener un total aproximado de 15 km. de recorrido\n" +
                "También cuenta con lugares para descanso de los peatones, haciendo su visita más agradable, sobre todo durante la primavera y verano donde se puede apreciar la flora y la fauna del lugar.\n" +
                "La laguna Alalay corresponde a un sistema semi-artificial, intervenido a partir de 1935 en su profundización de cubeta, tiene condiciones de vaso regulador de crecidas del río Rocha para el control de las inundaciones provocadas en época de lluvias por dicha cuenca. \n" +
                "\n" +
                "La fauna que se encuentra en la laguna Alalay es muy variada, hasta ahora se han registrado cinco especies de peces: dos platinchos como especies nativas, la gambusia, carpa y el pejerrey como especie introducida. A su vez existen dos especies de anfibios, sapo, rana y dos especies de reptiles.\n" +
                "Las aves, sin duda alguna, constituyen uno de los recursos más atractivos que tiene esta laguna, no sólo por el valor estético, sino porque constituye el valor genético histórico que tiene este valle. En este sentido se han registrado más de 136 especies de aves, tanto de tierras altas como de tierras bajas.\n");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Circuito Bolivia, Cochabamba Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.406584733882628f);
        lugarTuristico.setGpsY(-66.13902568817139f);
        lugarTuristico.setLinea("241, 244");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        //Patrimonio Urbano Arquitectónico , Artístico, Museos y Manifestaciones Culturales

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Banco Mercantil");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"banco mercantil.jpg"});
        lugarTuristico.setDescripcion("Este edificio, donde hoy funciona el Banco Mercantil Santa Cruz, Fue construido por el mandato del Barón del Estaño Simón I. Patiño a principios de 1930. Su construcción es de estilo neoclásico afrancesado, en el ambiente principal que es el hall del Banco resalta la inmensa cúpula con ala metálica y rellena de cristal decorado.\n" +
                "En la fachada existe una relación de molduras en forma de guirnaldas y características zoomorfas una biga circular.\n" +
                "En la altura de la cubierta se tienen dos inmensas estatuas cubiertas de bronce, las tejas escamas de zinc traídas de Europa, el piso es de mármol y ónice, para poder acceder a los pisos superiores cuenta con una gran escalera que completa la majestuosidad del conjunto arquitectónico. \n");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Calle Nataniel Aguirre, esq. Calama");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.396359588573944f);
        lugarTuristico.setGpsY(-66.15689736760541f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Banco Nacional de Bolivia");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"banco nacional de bolivia.jpg"});
        lugarTuristico.setDescripcion("Mediante Resolución de 1º de Septiembre de 1871, el gobierno del Presidente Agustín Morales aceptó la solicitud de Mariano Peró, de crear una entidad bancaria en la que los bolivianos fuesen socios únicos o tuviesen una significativa influencia, que era de vital importancia para el desarrollo tecnológico de la minería.\n" +
                "Es así que, a fines del año 1872, el Directorio del Banco Nacional de Bolivia, ve necesaria la apertura de una sucursal en la ciudad de Cochabamba. Esta agencia tiene uno de los edificios más modernos del banco en el ámbito nacional; se encuentra ubicado entre las calles Nataniel Aguirre y Jordán, punto de despliegue de la banca cochabambina. La construcción de este edificio se inició en 1952, concluyéndose cuatro años después a cargo del arquitecto Oscar Améztegui. El edificio de cemento y hierro está coronado por una cúpula esquinada en forma de gran casco, por debajo de la cual se extiende un piso de mansardas y las plantas inferiores en dos alas abiertas desde la puerta de entrada.\n");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Calle Nataniel Aguirre, esq. Jordán");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.396359588573944f);
        lugarTuristico.setGpsY(-17.396359588573944f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Museo Casona Santiváñez");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"museo casona santivañez6.jpg", "museo casona santivañez1.jpg", "museo casona santivañez2.jpg", "museo casona santivañez3.jpg", "museo casona santivañez4.jpg", "museo casona santivañez5.jpg" });
        lugarTuristico.setDescripcion("La Casona Santivañez declarada Patrimonio Histórico de Cochabamba, constituye una reliquia arquitectónica de estilo colonial, que data del siglo XIX. La elegancia, historia y colorido, caracterizan esta infraestructura de gran valor turístico para Cochabamba.\n" +
                "Perteneció en su época a Don Juan Antonio Santivañez de Gazma y Barrao. A la muerte de los herederos, el inmueble pasó a ser propiedad de la Universidad Católica Boliviana. Posteriormente, la Honorable Municipalidad de Cochabamba, recuperó el predio sobre la base de una permuta con el fin expreso de cobijar el museo de la familia Santivañez y ser un centro de exposición artístico cultural.\n" +
                "Al recorrer sus elegantes ambientes se muestra la arquitectura propia de la época e historia traducida en la cultura y el arte plasmado en toda la casona. Pilares de arquitectura colonial, paredes tapizadas con figuras llamativas, pisos construidos detalladamente caracterizan el lugar adornado con cuadros y muebles que pertenecieron a la familia y a pesar del tiempo se mantienen intactos.\n" +
                "Posee salones de exposición como el de fotografía antigua, pinacoteca para exposiciones pictóricas itinerantes, salón principal de recepciones restaurado a su forma original. Entre sus atractivos se puede apreciar un juego de estar azul, sillas y sillones blancos (estilo Luis XV), entre otros. Además, se encuentran el Salón de Exposición, el hall para eventos a nivel protocolar, el museo y otros ambientes de gran riqueza arquitectónica.\n");
        lugarTuristico.setHorario("Lunes a viernes 9:00 – 12:00 14:30 - 18:30");
        lugarTuristico.setDireccion("C. Santivañez entre Av. Ayacucho y Junín, Santivañez, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(4258030);
        lugarTuristico.setGpsX(-17.3946576348589f);
        lugarTuristico.setGpsY(-66.15903496742249f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);



        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Catedral Metropolitana");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"catedral metropolitana4.jpg", "catedral metropolitana1.jpg", "catedral metropolitana2.jpg", "catedral metropolitana3.jpg" });
        lugarTuristico.setDescripcion("Es la Iglesia Mayor. Más conocida como la “Catedral Metropolitana” de la ciudad de Cochabamba, fue construida en 1735 y es una de las mayores de Charcas, de las antiguas, en su interior conserva cuadros y muebles coloniales. Una galería de arcos que data de principios de siglo cubre la parte lateral de la plaza 14 de Septiembre y queda descubierta solo la portada de la cabecera, que se alza sobre la calle Esteban Arze.\n" +
                "Su portada se compone de tres cuerpos con columnas salomónicas que flaquean la puerta. Hay cartonería a los lados y decoración “mestiza”; en la coronación, la portada se alza entre dos grandes contrafuertes que parecen dispuestos a recibir un arco, que posee una sola torre donde se encuentra el reloj principal.\n");
        lugarTuristico.setHorario("Lunes a Viernes 07:45 – 20:30");
        lugarTuristico.setDireccion("Esteban Arze, Plaza Principal, 14 de Septiembre, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.3943841f);
        lugarTuristico.setGpsY(-66.1566666f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Casona Mayorazgo");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"casona mayorazgo.jpg"});
        lugarTuristico.setDescripcion("Esta casona de más de 300 años de antigüedad situada en la zona de Cala-Cala, sobre la avenida Simón López, es considerada un invaluable patrimonio de la ciudad, pues perteneció a uno de los primeros habitantes de la ciudad cuando Cochabamba aún se denominaba Villa de Oropesa. Se trata de don Garci Ruíz de Orellana que ingresó a los valles de Cochabamba hacia el año 1538 cuando se daban las luchas civiles entre los españoles. Él mismo dice en un documento que fue el primer poblador y fue la causa que dio origen a la Villa de Oropeza, que se la organizó posteriormente cuando hubo mayor afluencia de gente.\n" +
                "Ruiz de Orellana fue un personaje muy importante en los acontecimientos de la fundación de Cochabamba por haber sido dueño de la mayor parte de tierras en las que se fundó la denominada Villa de Oropesa.\n" +
                "En época moderna, después de haber estado en litigio con una familia que reclamaba derechos sobre ella, la casona fue totalmente entregada al Municipio. En un principio se pensó en echarla abajo ya que prácticamente quedaba en ruinas, pero un patrimonio cochabambino de tantos años de antigüedad, no podía perderse. Fue así que años después de papeleos, juicios, depredación, olvido e indiferencia, el municipio decidió restaurarla y remodelarla en el año 2009.\n" +
                "Actualmente la Casona de Mayorazgo es un Museo de Estilo de Vida, en el que se muestra, a través de sus diversos espacios, cómo era la cotidianeidad de aquel período histórico. Además, es escenario para presentaciones, exposiciones artísticas y difusión cultural.\n");
        lugarTuristico.setHorario("Lunes a Viernes de 9:00 a 12:00. y 14:30 a 18:30");
        lugarTuristico.setDireccion("Av. Simón López esq. Av. Pérez de Holguín");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.365344520890872f);
        lugarTuristico.setGpsY(-66.17461670530675f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CAMPERO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Catedral San Pedro");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"catedral de san pedro3.jpg", "catedral de san pedro4.jpg", "catedral de san pedro5.jpg", "catedral de san pedro1.jpg"});
        lugarTuristico.setDescripcion("Es una obra maestra, sustituye a la anterior catedral derrumbada por el terremoto de 1998 que asoló la ciudad. Es preciosa, moderna y amplia. \n" +
                "Merece la pena visitar, las campanas del patio que pertenecieron a la anterior iglesia. Está custodiada por la virgen de Candelaria patrona de Aiquile. Sus visitas de la plaza son inmejorables, lugar de reunión de los aiquileños.\n");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("C. Parroquial, entre Bolívar y Plaza 20 de diciembre, Aiquile");
        lugarTuristico.setTelefono(4343182);
        lugarTuristico.setGpsX(-18.19939414919811f);
        lugarTuristico.setGpsY(-65.17867416143417f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_PUNATA);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Cementerio de Punata");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"cementerio de punata2.jpg", "cementerio de punata manuel asencio villarroel.jpg", "cementerio de punata1.jpg" });
        lugarTuristico.setDescripcion("Ubicado al Sur del área urbana tiene las condiciones apropiadas, no solo para población viviente, sino también para la que tiene que contar con una morada digna para un descanso eterno. El cementerio, en Punata permite pasear y observar las especies forestales cuidadosamente seleccionadas entre pinos, molles y hermosos rosales, que hacen atractivo el lugar. Además de constituirse en un legado histórico para la misma Punata ya que en ello descansan los restos de punateños célebres: Dr. Andrés María Torrico y el Dr. Manuel Ascencio Villarroel, ya que también en su interior se guarda la reliquia de un carro mortuorio de la época colonial, que servía para velar a los muertos.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Av. Gualberto Villarroel, Punata");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.56258890046693f);
        lugarTuristico.setGpsY(-65.83536475896835f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);



        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Centro Cultural “Simon I. Patiño”");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"centro cultural simon i patiño1.jpg", "centro cultural simon i patiño5.jpg", "centro cultural simon i patiño2.jpg", "centro cultural simon i patiño3.jpg" });
        lugarTuristico.setDescripcion("Una obra arquitectónica maravillosa, un paseo por una parte de la historia de un hombre visionario a pesar de sus limitaciones, imponente gusto decorativo y ecléctico que todos deberíamos conocer. Excelente atención y conocimiento de su personal.");
        lugarTuristico.setHorario("Martes a Viernes 15:30 - 18:00, Sábado 09:30 – 11:30, Domingo 11:00 – 11:30");
        lugarTuristico.setDireccion("Potosí 1450, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(4243137);
        lugarTuristico.setGpsX(-17.374832870983536f);
        lugarTuristico.setGpsY(-66.15314617753029f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Convento de Santa Clara");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"convento santa clara1.jpg", "convento santa clara2.jpg"});
        lugarTuristico.setDescripcion("La iglesia de Santa Clara y el convento que lleva el mismo nombre, fueron fundados el 25 de mayo de 1648 fecha en la que se inició la construcción de la antigua iglesia ubicada donde hoy se encuentra el Palacio de Cultura.\n" +
                "La benefactora principal fue Doña Francisca de Vargas, quien financió la construcción del convento y la iglesia con las rentas de su hacienda que se encontraba en Cliza. La construcción del actual templo se efectuó entre 1912 y 1918, bajo la dirección del Ing. Julio Knaudt, en un sobrio y elegante estilo gótico.\n");
        lugarTuristico.setHorario("Lunes a Viernes 09:00 – 11:00 14:30 – 16:30 Sábado 14:30 – 16:30");
        lugarTuristico.setDireccion("C.25 de mayo, entre Av. Heroínas y calle Colombia, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.39151f);
        lugarTuristico.setGpsY(-66.1556675f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);



        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Iglesia de Santo Domingo");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"iglesia de santo domingo3.jpg", "iglesia de santo domingo1.jpg", "iglesia de santo domingo2.jpg" });
        lugarTuristico.setDescripcion("Este hermoso templo de piedra y barro posee más de cuatro siglos de existencia y fue erigido en el sitio original del Convento de los Frailes de la Orden de Predicadores o Dominicos el año 1612. Fue la primera sede parroquial de la entonces Villa de Oropeza, hoy ciudad de Cochabamba. Es la única construcción religiosa en la ciudad que guarda semejanza con los templos de la región andina del altiplano.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Av. Ayacucho y Santivañez nro. 151, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(4221550);
        lugarTuristico.setGpsX(-17.394785612153562f);
        lugarTuristico.setGpsY(-66.15848779678345f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Inka Rakay");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"inka rakay2.jpg", "inka rakay1.jpg" });
        lugarTuristico.setDescripcion("Fortaleza Incaica, construida entre 1460 y 1470. Fue un conjunto de 17 edificios cuadrangulares y rectangulares, algunos silos redondos. Son las ruinas Incaicas más accesibles para visitar desde Cochabamba. Los expertos clasifican Inka Racay como un centro administrativo de los incas, encargado de:\n" +
                "o\tLa organización del asentamiento de los quechuas y aymaras, que los incas llevaron del Altiplano, para cultivar el maíz en el valle de Cochabamba.\n" +
                "o\tLa creación y la administración del granero de Quillacollo.\n" +
                "o\tEl Manejo de los caudales de agua en el valle, supervisando el uso de estos escasos recursos.\n" +
                "Según los investigadores Inka Racay era una capitanía, encargada de la seguridad del granero incaico en Cotapachi. Con unos 4000 silos para el almacenaje de maíz (capacidad de más de 5.000 toneladas). De la fortaleza quedaron únicamente muros y fundamentos.\n" +
                "De la Plaza de la Fortaleza de Inka Racay, se tiene una vista única sobre el Valle Bajo y el Valle Central.\n" +
                " Cada 21 de Junio en ese lugar se realiza un evento especial por el solsticio y el año nuevo indígena.\n");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Sipe Sipe, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.479665f);
        lugarTuristico.setGpsY(-66.385489f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("La Angostura");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"la angostura1.jpg", "la angostura4.jpg", "la angostura2.jpg", "la angostura3.jpg" });
        lugarTuristico.setDescripcion("Se trata de una laguna artificial que originalmente fue construida como una represa para riegos y actualmente también es uno de los lugares turísticos en los que se puede disfrutar de piscina, paseos en bote por la laguna, y de la comida de la zona. A orillas de la laguna se encuentran varios restaurantes cuya especialidad es el pescado, además de las dulces y cálidas cabañas que ofrecen alojamiento y servicios para celebrar ocasiones especiales.\n" +
                "Esta represa fue materializada gracias a la cooperación del Gobierno de México, que junto a su similar de Bolivia, concretó el embalse que acumula 50.000.000 de metros cúbicos de agua. Su culminación, después de 8 años fue en 1948.\n");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Esteban Arze, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.55435457556444f);
        lugarTuristico.setGpsY(-66.06328010559082f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);



        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Mansión Villa Albina");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"mansion albina patiño1.jpg", "mansion albina patiño4.jpg", "mansion albina patiño2.jpg", "mansion albina patiño3.jpg" });
        lugarTuristico.setDescripcion("Esta belleza arquitectónica ubicada en las faldas del Tunari a 2 km de Vinto, fue mandado a construir por el Barón de Estaño Simón I. Patiño entre los años 1818y 1921, bajo la dirección del Arq. Francés Jardín y concluido por su hijo. Villa Albina posee toda la magia del arte europeo: patios inmensos con fuentes deslumbrantes, majestuosos jardines, esculturas y el gran mausoleo en donde descansan los restos de los propietarios.\n" +
                "Actualmente en una de sus dependencias funciona el más importante laboratorio filogenético de maíz y haba; y una granja experimental.\n");
        lugarTuristico.setHorario("Lunes a Viernes 08:00 – 16:00 Sábado 09:00 – 13:00");
        lugarTuristico.setDireccion("Av. Pairumani, Bolivia");
        lugarTuristico.setTelefono(4252090);
        lugarTuristico.setGpsX(-17.366408296168935f);
        lugarTuristico.setGpsY(-66.32076814770699f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CAMPERO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Monumento al Charango");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"monumento a charango1.jpg", "monumento al charango.jpg" });
        lugarTuristico.setDescripcion("Está en el parque del Kjochi. Imponente infraestructura de cemento en forma de charango. Es uno de los monumentos más representativos de Aiquile, en cuyo lugar también se realizan representaciones folklóricas.");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Aiquile, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-18.20364421551036f);
        lugarTuristico.setGpsY(-65.17837107181549f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);



        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Museo Arqueológico Universitario");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"museo arqueologico4.jpg", "museo arqueologico1.jpg", "museo arqueologico2.jpg", "museo arqueologico3.jpg" });
        lugarTuristico.setDescripcion("El Museo Arqueológico de la Universidad Mayor de San Simón cuenta actualmente con aproximadamente 40.000 piezas arqueológicas, etnográficas y paleontológicas, clasificadas e inventariadas en su mayoría procedentes del Departamento de Cochabamba y otras regiones de Bolivia. Cuenta con un equipo de investigadores que realizan estudios, proyectos y programas en coordinación con instituciones científicas, educativas y demás dentro y fuera del país.\n" +
                "Actualmente cuenta con tres áreas de exposición permanente:\n" +
                "La Sección Arqueológica que constituye la parte fundamental del Museo. Muestra una secuencia cronológica de las distintas culturas que ocuparon Cochabamba y áreas aledañas, desde las sociedades pre-cerámicas hasta la formación de los grandes estados, como Tiwanaku e Inca.\n" +
                "La Sección Etnográfica que cuenta con una colección de pergaminos de cuero y discos de arcilla que son representaciones gráficas de oraciones y rezos católicos, los cuales fueron utilizados por la Iglesia para evangelizar a los indígenas. Además, esta sección contiene, entre otros, material etnográfico amazónico-chaqueño actual.\n" +
                "La Sección Paleontológica muestra un breve resumen de lo que constituye la historia de la vida hasta la aparición del hombre. Presenta en orden cronológico fósiles de la evolución biológica boliviana.\nEl museo ha recibido reconocimiento en el ámbito nacional e internacional, como el Cóndor de los Andes, conferido por la Nación por su destacada labor y aporte al patrimonio arqueológico y desarrollo de país.");
        lugarTuristico.setHorario("Lunes a Viernes 08:00-18:00");
        lugarTuristico.setDireccion("Av. Oquendo Jordán esq., Nataniel Aguirre, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(4250010);
        lugarTuristico.setGpsX(-17.39537046725039f);
        lugarTuristico.setGpsY(-66.15736126899719f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_MIZQUE);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Museo arqueológico P. Mauricio Valcanover");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"museo arqueológico pm.jpg"});
        lugarTuristico.setDescripcion("El museo arqueológico P. Mauricio Valcanover, ubicado en la alcaldía, expone piezas arqueológicas, herramientas, armas, símbolos, vestimentas, cerámicas precolombinas, fósiles y trajes típicos de Rakaypampa.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("C. Bolívar, Mizque, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.942215977709438f);
        lugarTuristico.setGpsY(-65.34131661057472f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Museo Convento de Santa Teresa");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"museo convento de santa teresa1.jpg", "museo convento de santa teresa2.jpg"});
        lugarTuristico.setDescripcion("De estilo barroco este convento es una de las construcciones más antiguas que existen en Cochabamba, fue construido en 1760. La construcción inicial quedó inconclusa y se retomó cuarenta años después con una peculiar construcción dentro de otra.\n" +
                "El lugar es considerado una reliquia colonial, por sus características de construcción y riqueza en sus paredes, cuadros y ambientes, donde se observan imágenes del año 1.700 propias de los Jesuitas que llegaron al país a predicar el evangelio de Jesucristo.\n" +
                "El convento recibía a las mujeres de las familias mejor acomodadas económicamente en la ciudad que decidían dedicar sus vidas al servicio del señor, quienes en la mayoría de los casos llegaban acompañadas por algunas sirvientas que también permanecían enclaustradas por el resto de sus días.\n" +
                "El Convento Santa Teresa es en la actualidad un monasterio claustro histórico donde viven las hermanas de la orden Carmelitas Descalzas, devotas de Santa Teresa de Jesús. Representa uno de los más grandes baluartes de la Iglesia Católica, sus ambientes rústicos, la presencia de monjas que oran en silencio por la salvación del mundo y las réplicas pintadas en las paredes de manera natural, hacen del lugar todo un atractivo turístico.\n");
        lugarTuristico.setHorario("Lunes a Sábado 08:30 – 12:00 14:30 – 18:00 Domingo 09:00 – 12:00 15:00 – 17:00");
        lugarTuristico.setDireccion("C. Baptista nro. 0344 casi Ecuador, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(4221252);
        lugarTuristico.setGpsX(-17.38987633896569f);
        lugarTuristico.setGpsY(-66.15808010101318f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CHAPARE);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Museo cap. David Andrade López");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"museo cap. david andrade lopez 1.jpg", "museo cap. david andrade lopez 2.jpg" });
        lugarTuristico.setDescripcion("Ubicado a 1 Km. de la población de Chimoré, en los ambientes de la UMOPAR, en dicho lugar se encuentra objetos incautados por la FELCN, donde se podrá observar las diversas formas de fabricar y transportar sustancias controladas, este atractivo puede ser visitado en coordinación con la responsable de la Unidad de Turismo.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Chapare, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-16.99459167189879f);
        lugarTuristico.setGpsY(-65.14233961701393f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CAMPERO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Museo del Charango");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"museo del charango0.jpg", "museo del charango1.jpg", "museo del charango2.jpg", "museo del charango3.jpg", "museo del charango4.jpg"});
        lugarTuristico.setDescripcion("Museo del Charango, donde hay piezas realmente únicas, premiadas en diferentes festivales, con un sinfín de detalles tallados, como los cuernos de un escarabajo, el mapa de Bolivia o algunas escenas costumbristas. El museo cuenta la trayectoria del Instrumento de Cuerda más rico en Artesanía Boliviana, es pues así que Aiquile muestra a Bolivia y al mundo el por qué se le denomina \"Cuna De Charangos\".\n" +
                "Aiquile fue declarado Capital Nacional del Charango y la Feria y Festival del Charango declarada Patrimonio Oral e Intangible de Bolivia, se efectúa del 2 al 4 de noviembre.\n");
        lugarTuristico.setHorario("Lunes a Viernes de 08:30 – 17:00");
        lugarTuristico.setDireccion("C. Campero Esquina Héroes Del Chaco, Aiquile, Bolivia");
        lugarTuristico.setTelefono(4343537);
        lugarTuristico.setGpsX(-18.201381603182707f);
        lugarTuristico.setGpsY(-65.17853736877441f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Museo paleontológico y centro cultural artístico");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"museo paleontológico y centro cultural artístico1.jpg"});
        lugarTuristico.setDescripcion("En la Casa de la Cultura ubicada en la plaza Principal de la ciudad donde se encuentra el primer Museo histórico, galería fotográfica, paleontológico de cerámica, restos fósiles, entre otros.\n" +
                "Es un centro de recolección de la historia de Tarata desde sus inicios y el aporte de la población a través del tiempo, de los años, contemplando fotografías de carácter histórico que nos trasporta a épocas pasadas de la población.\n");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Tarata, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.611923067197406f);
        lugarTuristico.setGpsY(-66.02368131279945f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Parroquia de San Idelfonso");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"parroquia de san idelfonso2.jpg", "parroquia de san idelfonso4.jpg", "parroquia de san idelfonso3.jpg" });
        lugarTuristico.setDescripcion("Se construyó en 1908   y se consagra solemnemente el 14 de agosto de1947.\n" +
                "El templo fue construido entre los años 1908 1947, la primer fue colocada en el mes de abril de 1908, cuando oficiaba el Párroco el Fructuoso Mencia este hermoso templo fue edificado con pedrones trasladados desde El Calvario piedra por piedra, con arena del rio Tacata Que fueron traídos en mantas, ponchos, tablones y los por ancianos y niños.\n" +
                "Fue declarado patrimonio histórico, actualmente es el Altar Mayor emplazado en el lugar y sitio más estratégico como admirable se halla compuesto de varios motivos también excepcionales, La expresión radiante de la urna áurea (revestida de la pintura pan de oro) de donde la imagen original de la santísima virgen de Urkupiña va irradiando sus dones divinos.\n" +
                "La estructura general del Altar Mayor, se halla emplazado al fondo de la Nave Principal y central, en la posición sud de la Basílica compuesta en rasgos generales de:\n" +
                "• En planta semicircular, jerarquizada por su considerable altura generando acústica y mayor iluminación.\n" +
                "• Definido visualmente por columnas laterales adosadas sin estilo alguno, rematados por capiteles del orden Corintio compuesto, donde resaltan las hojas de acanto doradas, bañadas con la pintura de pan de oro, la cornisa transversal complementada de ornamentos más pequeños.\n" +
                "• En sentido vertical, se alza magistralmente el arco de medio punto con la base inferior esculpida y decorada por figuras abstractas doradas.\n");
        lugarTuristico.setHorario("Lunes a Domingo 08:00 – 12:00 14:00 – 17:00 (No se atiende Jueves por la tarde)");
        lugarTuristico.setDireccion("Quillacollo, Bolivia");
        lugarTuristico.setTelefono(4260185);
        lugarTuristico.setGpsX(-17.3982601614805f);
        lugarTuristico.setGpsY(-66.28162264823914f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Palacio Consistorial (Quillacollo)");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"palacio consistorial1.jpg", "palacio consistorial.jpg" });
        lugarTuristico.setDescripcion("El actual edificio de la Alcaldía Municipal de Quillacollo, conocido también como Palacio Consistorial, es una de las infraestructuras más antiguas, de la época republicana. Este se caracteriza por tener en la fachada, balcones trabajados en fierro forjado y una galería de arcos que lo representa. La alcaldía de Quillacollo funciona en este lugar desde el año 1857, convirtiéndose en un símbolo para los quillacolleños, del pasado y presente de su sociedad.\n" +
                "Se encuentra en pleno centro de la ciudad de Quillacollo, siendo parte del casco histórico de la misma. En este edificio funciona la Alcaldía en la parte superior y el centro de abastecimiento o mercado popular en la parte baja.\n");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Av. 6 de Agosto, Quillacollo, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.39724787786554f);
        lugarTuristico.setGpsY(-66.28048539161682f);
        lugarTuristico.setLinea("260");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CHAPARE);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Santuario de la Virgen de los Ángeles (Iglesia de Melga)");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"santuario de la virgen de los ángeles.jpg", "santuario de la virgen de los ángeles2.jpg", "santuario de la virgen de los ángeles3.jpg"});
        lugarTuristico.setDescripcion("El santuario de melga se encuentra al norte de la carretera a 15 km. Aproximadamente de Sacaba, la iglesia tiene un estilo arquitectónico ecléctico con detalles clásicos de la arquitectura religiosa vanguardista.\n" +
                "Es una torre de piedra y cubierta con teja industrial, esta obra espectacular se caracteriza por su monumentalidad y por amplios jardines exteriores, muchas personas llegan al lugar, algunos por conocer la iglesia debido a que es una obra de arte que llama la atención y otros por sanidad. Los días 18, 19, 20 de octubre de cada año la iglesia es visitada con el fin de celebrar la fiesta de la patrona Virgen de los Ángeles.\n");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("km. 35 carretera nueva a Santa Cruz, Chapare");
        lugarTuristico.setTelefono(76474112);
        lugarTuristico.setGpsX(-17.424330611606145f);
        lugarTuristico.setGpsY(-65.91747790575027f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Santuario de la Virgen de Urkupiña");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"santuario de la virgen de urkupiña1.jpg", "santuario de la virgen de urkupiña3.jpg", "santuario de la virgen de urkupiña2.jpg" });
        lugarTuristico.setDescripcion("Cuenta la historia que a una pastorcita se le apareció la imagen de la Virgen con el Niño, cuando ella llevaba a pastorear a sus ovejas, al principio no le creía sus relatos y un día su madre la siguió y pudo obsérvala. En dicho lugar se creó el Santuario en donde todos los 14 de Agosto se realiza una peregrinación.\n" +
                "Todos hacen pedidos por su salud o por mejoras en sus vidas, en lo material dejan una pequeña replica de los solicitado, autitos de juguetes, fotocopias de billetes.\n" +
                "También a la par de la parroquia hay un santuario donde dejan velas encendidas.\n");
        lugarTuristico.setHorario("Lunes a Domingo 08:00 - 12:00 14:00-17:00");
        lugarTuristico.setDireccion("Quillacollo, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.422093917259023f);
        lugarTuristico.setGpsY(-66.28405809402466f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Teatro Achá");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"teatro acha1.jpg", "teatro acha3.jpg", "teatro acha4.jpg", "teatro acha5.jpg", "teatro acha2.jpg" });
        lugarTuristico.setDescripcion("Otro obsequio colonial que embellece este valle. En 1578 se levanta imponente una de las obras arquitectónicas más importantes de la época. El convento de San Agustín que posteriormente sirvió para la consolidación del famoso “Teatro de la Unión Americana” remodelado en 1864 y que con posteridad adquirió el nombre de “Teatro Achá”, en homenaje al presidente José María Achá.\n" +
                "Esta joya colonial se erige hoy como el verdadero estandarte del arte y la cultura cochabambina. Ante sus palcos y su gran salón dorado han debutado las mejores campañas de danza y teatro y han concertado extraordinarios músicos y directores de orquesta, consolidando a Cochabamba como el semillero de artistas. \n" +
                "Este majestuoso edificio que evoca en silencio el pasado, cobijando en su interior los restos del fundador de Cochabamba Gerónimo de Osorio es sin lugar a dudas, uno de los principales monumentos de la ciudad y que aun encierra en sus muros la historia de Bolivia.\n");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Cercado");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.39272644661129f);
        lugarTuristico.setGpsY(-66.15679498761892f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);



        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Teatro Adela Zamudio");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"teatro adela zamudio1.jpg", "teatro adela zamudio2.jpg" });
        lugarTuristico.setDescripcion("Teatro ubicado en pleno centro de la ciudad, con buena capacidad para espectadores. Dividido en dos niveles. Es escenario para actividades culturales como festivales nacionales e internacionales de música, presentaciones de baile, ciclos cinematográficos, obras de teatro, actuaciones estelares, conciertos folklóricos, eventos históricos y otros. Cuenta con dos ingresos laterales y dos ingresos laterales frontales.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Av. Heroínas nro. 381, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(69448657);
        lugarTuristico.setGpsX(-17.39194577493204f);
        lugarTuristico.setGpsY(-66.1559048295021f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_GERMAN_JORDAN);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Parroquia San Antonio Tolata");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"parroquia san antonio de tolata1.jpg", "parroquia san antonio de tolata2.jpg"});
        lugarTuristico.setDescripcion("Según relatos del Monseñor Walter Rosales en el año 1864 durante la presidencia del General Mariano Melgarejo, en el cerro kalapaKira a 1 km hacia el norte de la actual plaza principal de Tolata, donde apareció una imagen de la Virgen María a una pastorcita.\n" +
                "Dicha imagen fue trasladada a Tarata ya que aquella época Tolata pertenecía a la parroquia de Tarata.\n" +
                "El pueblo lloraba porque el pueblo de Tarata se apodero de la imagen, fue entonces que a la misma pastorcita se le apareció la actual imagen que está en la parroquia de Tolata un 14 de septiembre, es por esta razón que su fiesta se celebra en esta fecha cada año bajo la vocación de Nuestra Señora del Patrocinio y como Patrona de Tolata.\n" +
                "Según datos antiguos, el pueblo estaba dividido en dos fajas enormes de tierra pertenecientes a dos hermanas, a medida que la población iba creciendo la autoridad eclesiástica vio la necesidad y conveniencia de atender a la población y creo una nueva parroquia denominada “San Antonio de Tolata” por el obispo de de la diócesis de Cochabamba Mons. Rafael Salinas, fue por esta razón que en el año 1868 fue nombrado como primer párroco por la anuencia del presidente Melgarejo, el joven sacerdote Máximo Rosales oriundo de Tarata,  más tarde Doctor en derecho, egresado de Medicina, Párroco y Rector.\n" +
                "Por ser el primer párroco fue fundador de Tolata, desempeño su cargo por 22 años construyendo la actual iglesia, el cementerio, construyo el puente en los ríos con troncos de poste, también logro que se abriera una escuela.\n");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Plaza Principal deTolata, Bolivia.");
        lugarTuristico.setTelefono(4575555);
        lugarTuristico.setGpsX(-17.53365203404495f);
        lugarTuristico.setGpsY(-65.96293330192566f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Templo del Hospicio");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"templo hospicio1.jpg", "templo hospicio3.jpg", "templo hospicio2.jpg"});
        lugarTuristico.setDescripcion("El Templo del Hospicio se encuentra ubicado en la acera sur de la plaza Colón. Su construcción se inició en 1859 y concluyó en 1875. Fue obra del arquitecto José Rosetti, está construida enteramente de adobe, la iglesia es de un estilo neoclásico, sin Cúpula y posee algunos detalles barrocos y bizantinos. Se construyó con aportes de la población Cochabambina y de los centros mineros donde acudían los sacerdotes Franciscanos a pedir contribuciones.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Plaza Colón, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(4222610);
        lugarTuristico.setGpsX(-17.389006068239883f);
        lugarTuristico.setGpsY(-66.15575194358826f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Casa Museo Martín Cárdenas");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"casa museo martin cardenas2.jpg", "casa museo martin cardenas3.jpg", "casa museo martin cardenas4.jpg", "casa museo martin cardenas1.jpg"});
        lugarTuristico.setDescripcion("La Casa Museo Internacional y Científico Martín Cárdenas Hermosa es un patrimonio consagrado al destacado científico y botánico cochabambino, que entre varios estudios e investigaciones reconocidos internacionalmente figura la variada flora boliviana. Fue declarado Monumento Nacional el 31 de Julio de 1973; en él se guardan y exponen objetos personales, diferentes investigaciones y publicaciones que se preservaron en el tiempo como reliquias históricas.\n" +
                "El centro se encuentra instalado donde residió el doctor Martín Cárdenas, quien consagró gran parte de su vida al estudio de la botánica de la región y de toda Bolivia. La Casa Museo es un lugar histórico que sirve como referente para los estudiantes de biología y botánica.\n" +
                "El Jardín Botánico de la ciudad, lleva precisamente el nombre de este destacado científico como tributo a su loable labor de años de investigación y aporte a las ciencias naturales y en especial la botánica.\n");
        lugarTuristico.setHorario("Lunes a Viernes 09:00 – 12:00 15:00 - 18:30");
        lugarTuristico.setDireccion("Av. Heroínas 266, Cochabamba, Bolivia.");
        lugarTuristico.setTelefono(4258030);
        lugarTuristico.setGpsX(-17.39272260725053f);
        lugarTuristico.setGpsY(-66.16055846214294f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Monumento a las Heroínas de la Coronilla");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"minumento a las heroinas de la coronilla.jpg"});
        lugarTuristico.setDescripcion("Declarado Monumento Nacional el 14 de octubre de 1926; está asentado sobre la Colina de San Sebastián, ubicada al sud de Cochabamba. El monumento hecho en bronce, tiene un alto de 6,00 mts. y ancho de 2,00 mts. erigido en homenaje a las Heroínas de la Coronilla y al movimiento independentista del 27 de mayo de 1812. En mayo de dicho año, Goyeneche estaba al frente de las tropas realistas y una vez que derrotó a las tropas patriotas que estaban al mando de Esteban Arce avanzo hacia Cochabamba que preparaba la resistencia con muy escasos recursos. Los pocos habitantes del lugar en su mayoría mujeres salieron a enfrentar la invasión española a la cabeza de doña Mañuela Gandarillas que, aun estando ciega, comando valerosamente el regimentó civil femenino. Se atrincheraron en la colina de San Sebastián. Finalmente, Goyeneche entró a Cochabamba el 27 de mayo de 1812, quebrando la heroica resistencia. Para que las personas nunca olvidaran el valor que tuvieron aquellas mujeres cochabambinas, este lugar recibió el nombre de “Coronilla”. En el inicio de la colina hay dos leones de metal antiguamente estos fueron dos cañones de guerra. En el monumento se representa a tres mujeres, 2 niños, un anciano y al centro la figura de Manuela Gandarillas quien liderizó la batalla. En la parte superior del monumento se encuentra una estatua de Cristo.");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Av. Aroma (Zona Central)");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.40857732804517f);
        lugarTuristico.setGpsY(-66.15795006801585f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Museo de historia Natural Alcide d´ Orbigny");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"museo alcides dorbigni.jpg", "museo alcides dorbigni2.jpg", "museo alcides dorbigni3.jpg"});
        lugarTuristico.setDescripcion("El Museo de Historia “Alcide d’ Orbigny”, abre al pubico varias salas de exhibición el 29 de enero del 2003, bajo un convenio con la Universidad Mayor de San Simón, la Honorable Alcaldía Municipal de Cochabamba y la colaboración de la Embajada de Francia durante las celebraciones al bicentenario del nacimiento del famoso naturalista viajero francés Alcide d’ Orbigny.\n" +
                "El museo cuenta con tres salas: Geología y mineralogía; Paleontología y sala de zoología y entomología.  La primera, exhibe en sus colecciones hermosos cristales, minerales y meteoritos, junto a ellos una gama de ejemplares geológicos que resaltan la riqueza minera de Bolivia. \n" +
                "Respecto a la valiosa colección paleontológica, enriquecen sus colecciones fósiles únicos en el mundo como el pez Sacabambaspis jambieri que vivió durante el ordovícico en los mares cochabambinos hace 470 millones de años, huellas de artrópodos como Cruciana, fósil descrito por d’ Orbigny y dedicado al presidente Andrés de Santa Cruz.\n" +
                "Se expone también una rica fauna y flora del Pérmico, braquiópodos, equinodermos junto a gigantescos tiburones que vivieron en sus océanos. En las costas plantas licófitas, equísetos y helechos primitivos de hace 260 millones de años. El museo dedica un sector a la fauna de vertebrados, destacando los peces voladores, como Gasteroclupea branisai. Se enfatiza en la riqueza fosilífera del Paleógeno al sur de Cochabamba de 60 millones de años que poblaban estas regiones cocodrilos, tortugas, serpientes, mamíferos marsupiales y placentados que son piezas fundamentales para la evolución de los mamíferos sudamericanos, que situan a Cochabamba entre las localidades más importantes a nivel mundial.\nEn zoología y entomología, el museo cuenta con colecciones zoológicas y entomológicas recolectadas hace varias décadas atrás por meritorios científicos e investigadores cochabambinos. Sus muestras estimulan a los visitantes, a reflexionar sobre la importancia de la preservación de la biodiversidad de nuestro territorio.");
        lugarTuristico.setHorario("Lunes a Viernes 09:00 – 12:00 15:00- 18:00");
        lugarTuristico.setDireccion("Av. Potosí 1458");
        lugarTuristico.setTelefono(4486969);
        lugarTuristico.setGpsX(-17.374007161870722f);
        lugarTuristico.setGpsY(-66.1530283612573f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_PATRIMONIO);
        lugarTuristico.setNombre("Cementerio General");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"cementerio general2.jpg", "cementerio general.jpg" });
        lugarTuristico.setDescripcion("El Cementerio General de la ciudad de Cochabamba, se constituye en un bien patrimonial de la comunidad, porque conserva los valores espirituales de las familias, la memoria de todos los actores notables y otros no tanto, que escribieron alguna página gloriosa o rutinaria del transcurrir urbano.\n" +
                "Cuenta con Mausoleos y bloques de nichos. Además, una capilla de estilo moderno y sencillo con cúpulas y arcos que la hacen muy llamativa.\n" +
                "El cementerio actualmente está instalado aproximadamente sobre 16 hectáreas de terreno, cuenta con un Plan Maestro para su organización y desarrollo posterior y está ocupado por 8.555 criptas de los enterratorios, 14.084 de nichos a perpetuidad y 704 cenizarios, varios sectores de mausoleos distribuidos en 11 cuarteles administrados por el Municipio.\n" +
                "El cementerio contiene 3 circuitos para ser visitados:\n" +
                "Circuito histórico, para visitar las tumbas de los personajes más sobresalientes de la historia boliviana.\n" +
                "Circuito Cultural: que incluye las criptas de los personajes que contribuyeron con el arte y la cultura del País.\n" +
                "Circuito Arquitectónico: que muestra las diferentes tumbas y mausoleos de diversos estilos arquitectónicos.\n");
        lugarTuristico.setHorario("Lunes a Domingo 09:00 – 17:00");
        lugarTuristico.setDireccion("Av. Bartolomé Guzmán y del Cabildo  ");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.409214645335368f);
        lugarTuristico.setGpsY(-66.16152180619635f);
        lugarTuristico.setLinea("233");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        //Etnografía y Floklore********************************************************************

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_ETNOGRAFIA);
        lugarTuristico.setNombre("Pasaje Artesanal Joaquín Zenteno Anaya");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"pasaje artesanal joaquín zenteno anaya.jpg"});
        lugarTuristico.setDescripcion("Muy concurrido y repleto de tiendas y negocios principalmente dedicado a las artesanías, este pasaje se encuentra muy cerca de la Plaza Principal. Hay gran cantidad de artesanías en sus más variadas presentaciones, ropa de estilos andinos, bolsos, carteras, adornos y mucho más que el viajero, sobre todo el extranjero, no debe dejar de visitar. Otro rubro de bastante venta aquí son los libros de amplia variedad, las joyas y demás rubros relacionados.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Calle Achá, entre Av. Ayacucho y calle Nataniel Aguirre.");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.393270835331407f);
        lugarTuristico.setGpsY(-66.1582636149982f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_ETNOGRAFIA);
        lugarTuristico.setNombre("Feria “La Cancha”");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"feria la cancha2.jpg","feria la cancha.jpg" });
        lugarTuristico.setDescripcion("Los estrechos pasillos a modo de laberintos y las calles llenas de intercambio cultural seducen a los visitantes. En él se puede encontrar desde verduras y frutas hasta lo último en tecnología como televisores plasma o computadoras de última generación.\n" +
                "La Cancha comprende especialmente cuatro grandes áreas: Mercado Fidel Aranibar, que oferta tortas, ropa, juguetes, además de tener su sección de comedores populares con toda la variedad gastronómica. El Mercado San Antonio, donde destacan sus áreas de artesanías e instrumentos musicales; posee también zona de comedores. El gran Mercado La Pampa con la venta de frutas y verduras, ropa, zapatos, artesanía, productos por rubros, vestimenta típica: polleras, sombreros, productos ferreteros, etc. Finalmente, el Mercado La Paz, también conocido como Miamicito, es el más moderno y reciente donde se vende principalmente gran variedad de ropa de todas las marcas y modelos, también electrodomésticos y equipos de cómputo en el interior de sus galerías.\n");
        lugarTuristico.setHorario("07:00 – 18:00");
        lugarTuristico.setDireccion("Punata, Republica");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.393270835331407f);
        lugarTuristico.setGpsY(-66.1582636149982f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_ETNOGRAFIA);
        lugarTuristico.setNombre("Pasaje el Boulevard");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"pasaje el boulevard.jpg"});
        lugarTuristico.setDescripcion("Uno de los espacios de esparcimientos y gastronómicos más importantes de la zona norte es el paseo peatonal “El Boulevard”. Se encuentra en la Recoleta y los fines de semana es muy concurrido debido a que en su entorno se han instalado establecimientos gastronómicos y centros de diversión nocturna.\n" +
                "El Paseo del Boulevard se ha convertido en un punto de encuentro de jóvenes y adulto quienes participan de muchas actividades como el bouling, salas de juegos y discotecas, además de cafecitos.\n");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Plazuela Recoleta");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.37848114917358f);
        lugarTuristico.setGpsY(-66.15139955778493f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_ETNOGRAFIA);
        lugarTuristico.setNombre("Qollcas Incaicas de Cotapachi");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"qollcas incaicas de cotapachi1.jpg", "qollcas incaicas de cotapachi2.jpg", "qollcas incaicas de cotapachi3.jpg"});
        lugarTuristico.setDescripcion("Al sur de la ciudad de Quillacollo, sobre las colinas alrededor de la laguna de Cotapachi, se encuentra uno de los sitios arqueológicos incaicos más importantes de Bolivia, llamadas Qollcas por los incas, se trata de un enorme complejo de silos emplazados en tres sectores de la colina para el acopio de maíz que se producía en la zona, siendo el más grande del imperio de los incas, formado por aproximadamente 2.500 Qollcas o silos. Es muy importante este dato porque no hay que olvidar que la capital del imperio de los Incas fue  El Cuzco, y ni siquiera en los alrededores de esa ciudad, donde estaba toda la estructura del poder y las grandes construcciones, existía un depósito de tales dimensiones.\n" +
                "Ocupan una superficie de aproximadamente 61 hectáreas. Fueron construidas ordenadamente en filas sumando alrededor de 2.500 unidades en filas de norte a sur. Tuvieron originalmente base circular de piedra, forma cónica de tres metros de altura y estructura tipo canasta combinada y reforzada con barro y techo de paja. \n" +
                "En la zona la corriente de aire fresco es continua, ideal para la protección del maíz.  \n");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Quillacollo, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.440160710476203f);
        lugarTuristico.setGpsY(-66.28774881362915f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_MIZQUE);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_ETNOGRAFIA);
        lugarTuristico.setNombre("Ruedo de Toros");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"ruedo de toros1.jpg"});
        lugarTuristico.setDescripcion("La actividad complementaria de la festividad del Señor de Burgos, es la tradicional corrida de Toros, una de las prácticas más populares post hispánicas que se acostumbra realizar durante ocho jornadas.\n" +
                "Todas las tardes, la plaza taurina es escenario de esta famosa tradición, donde se aprecia la bravura de los toros y la experiencia de los capeadores, quienes tentados por los sendos premios buscan arrebatar la platería o los billetes de diferentes cortes, previamente amarrados en aguayos o pañoletas en las espaldas o astas de este bravo animal.\n" +
                "Una misa y la posterior romería oficiada el 8 de septiembre en honor a la Virgen de Guadalupe, es el inicio a este evento tradicional, en el que participan experimentados toreros mizqueños, aiquileños y totoreños, además de los vallunos provenientes de Punata, Arani, Cliza que gustan de esta costumbre taurina.\n" +
                "Capa en mano los experimentados capeadores ingresan al ruedo en medio de aplausos de la multitud que vitorea “ole”, “ole”. Así, por ocho tardes consecutivas se desarrolla esta corrida de toros en devoción al santo patrono de Mizque, el Señor de Burgos.\n");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Mizque, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.938786369660132f);
        lugarTuristico.setGpsY(-65.33959865570068f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_ETNOGRAFIA);
        lugarTuristico.setNombre("Wayllunk’as de San Andres");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"wayllunkas de san andres2.jpg", "wayllunkas des san andres1.jpg" });
        lugarTuristico.setDescripcion("Esta fiesta se realiza en la región de la Taquiña cada 30 de noviembre en honor a San Andrés, aunque su celebración comienza el 27.\n" +
                "En esta festividad las “Wayllunk’as”, que es un término referido a la acción de columpiarse realizado por las mujeres participantes y creyentes de la festividad, deben tener movimientos precisos, cantar, coqueteo y perfectamente armoniosos, los cuales terminan de forma necesaria con la captura de los premios que son colocados en una cesta.\n" +
                "Esta celebración como muchas otras en Cochabamba, es una fusión de creencias religiosas y andinas, por la cual los creyentes aspiran a obtener bendiciones, tierras fértiles para su cultivo, abundante cosecha y a beneficiar su gastronomía.\n");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Zona Taquiña");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.330343617842416f);
        lugarTuristico.setGpsY(-66.18437581808206f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        //Realizaciones Técnicas y Científicas*********************************************************************************

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_REALIZACIONES);
        lugarTuristico.setNombre("Cristo de la Concordia");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"cristo de la concordia3.jpg", "cristo de la concordia1.jpg" });
        lugarTuristico.setDescripcion("Situado sobre el cerro San Pedro, El Cristo tiene el denominativo de la “Concordia”, significando el carácter integrador geográfico, político y social que tiene la ciudad y el departamento de Cochabamba.\n" +
                "\n" +
                "Para perpetuar el recuerdo de la visita del Papa Juan Pablo II y la enseñanza de paz, entendimiento y concordia impartida en esa ocasión por el Vicario de Cristo, a iniciativa del dirigente obrero fabril Lucio López, se acordó levantar en la cumbre del cerro San Pedro, una monumental y bellísima obra escultora del Cristo de la Concordia proyectada y llevada a cabo por los afanado escultores y arquitectos cochabambinos, los hermanos Walter y Cesar Terrazas.\n" +
                "\n" +
                "El Cristo de la concordia tiene una estructura de hormigón armado con un alto de 34,20 m. y un ancho de 6,00 m., es considerado el monumento más alto de Latinoamérica. Esta gigantesca imagen de Jesús está de pie, con los brazos extendidos, representado la hospitalidad del pueblo cochabambino y la protección del Cristo sobre la ciudad de Cochabamba.\n" +
                " Alrededor del Cristo se ha instalado un magnifico mirador, del mismo se puede divisar y admirar toda la cuidad y el valle que lo rodea, obteniendo una panorámica total. Los visitantes llegan caminando por las gradas, en vehículos por la serranía, teleférico.\n\n" +
                "Complementando sus servicios, en los últimos años se ha dotado de un restaurante - snack y un sistema de iluminación intermitente, acciones que mejoran y complementan la calidad del atractivo.\n");
        lugarTuristico.setHorario("09:00 – 16:00");
        lugarTuristico.setDireccion("Av. de la Concordia, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(4228530);
        lugarTuristico.setGpsX(-17.38435132938883f);
        lugarTuristico.setGpsY(-66.1349768936634f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_REALIZACIONES);
        lugarTuristico.setNombre("Art Gallery Gildaro Antezana");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"art gallery gildaro antezana1.jpg", "art gallery gildaro antezana2.jpg" });
        lugarTuristico.setDescripcion("Es el salón más requerido por los artistas regionales y nacionales de gran nivel para la difusión de sus obras de escultura, pintura, grabados, dibujo y otras manifestaciones.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Plaza Principal 14 de Setiembre esq. España, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.393153894938802f);
        lugarTuristico.setGpsY(-66.15671619772911f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_REALIZACIONES);
        lugarTuristico.setNombre("Casa de la Cultura");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"casa de la cultura2.jpg"});
        lugarTuristico.setDescripcion("La Casa de la Cultura tiene por objetivo institucional promover, fomentar, revalorizar, y difundir las expresiones artísticas, las prácticas inter-culturales y el patrimonio cultural del Municipio de Cochabamba. El Centro es escenario para diversas actividades en el ámbito de la cultura. En este lugar, aparte de poder contemplar obras de arte propias de la cultura boliviana, también se puede acceder a los diversos archivos y biblioteca, así como al teatro integrado en el centro.\n" +
                "Salón de Exposiciones Mario Unzueta\n" +
                "Que alberga exposiciones culturales, paneles de información y un sistema de iluminación directa para las diversas obras presentadas.\n" +
                "Teatro Adela Zamudio\n" +
                "Dividido en dos niveles. Es escenario para actividades culturales como festivales nacionales e internacionales de música, presentaciones de baile, ciclos cinematográficos, obras de teatro, actuaciones estelares, conciertos folklóricos, eventos históricos y otros.\n" +
                "Biblioteca Municipal Jesús Lara\n" +
                "Ubicada en el tercer piso del edificio, la biblioteca cuenta con más de 40,000 tomos. Además, tiene una red de 10 Bibliotecas Zonales, ubicados en diferentes Distritos Municipales de la ciudad.\n");
        lugarTuristico.setHorario("Lunes a Viernes 08:30 – 12:30 14:30 – 18:30");
        lugarTuristico.setDireccion("Av. Heroínas esq. Calle 25 de Mayo.");
        lugarTuristico.setTelefono(4252090);
        lugarTuristico.setGpsX(-17.391917059712966f);
        lugarTuristico.setGpsY(-66.15583531541073f);
        lugarTuristico.setLinea("H");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_REALIZACIONES);
        lugarTuristico.setNombre("Jardín Botánico");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"jardin botanico1.jpg", "jardin botanico2.jpg", "jardin botanico3.jpg", "jardin botanico4.jpg"});
        lugarTuristico.setDescripcion("El Jardín Botánico Martín Cárdenas surgió como homenaje al más grande de los botánicos bolivianos Martín Cárdenas Hermosa, nacido en Cochabamba, gran investigador de campo, y fundador de la facultad de Biología de la Universidad Mayor de San Simón y rector de la misma durante dos gestiones. \n" +
                "Entre los objetivos del Jardín Botánico se encuentra el de promover la investigación, la enseñanza y el de exhibición de la flora de la provincia de Cochabamba, así como la conservación de la diversidad florística y de sus endemismos. Fue creado en 1962.   \n");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Raúl Rivero Torres, Cochabamba, Bolivia.");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.3772528f);
        lugarTuristico.setGpsY(-66.1398142f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_REALIZACIONES);
        lugarTuristico.setNombre("La Ciclo Vía");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"la ciclovia2.jpg", "la ciclovia3.jpg", "la ciclovia1.jpg" });
        lugarTuristico.setDescripcion("La ciudad cuenta con una Ciclovía principal que recorre parte de la ciudad, iniciándose en el llamado Circuito Bolivia, al sudoeste de la ciudad, en el perímetro de la Laguna Alalay, siguiendo hacia el norte por la avenida Rubén Darío, bordeando la colina San Pedro. En seguida cruza la avenida Villazón, entrando por la avenida Florentino Mendieta hasta la Plaza Tarija, de ahí sigue su largo recorrido por la avenida Rodríguez Morales, para finalizar su tramo entre la avenida Simón López y la calle Wiracocha, a unas cuadras de la Casona de Mayorazgo, al noroeste de la ciudad.\n" +
                "El recorrido completo de esta ciclovía es de aproximadamente 25 km. En su extenso tramo, el viajero puede disfrutar y conocer gran parte de la ciudad, como las zonas de Las Cuadras, Muyurina, Tupuraya, Queru Queru, Cala Cala y Mayorazgo.\n");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Circuito Bolivia- bordea la colina San Pedro.");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.402458967056607f);
        lugarTuristico.setGpsY(-66.13237917423248f);
        lugarTuristico.setLinea("241, 244");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CHAPARE);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_REALIZACIONES);
        lugarTuristico.setNombre("Parque Cretácico");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"parque cretácico.jpg", "parque cretácico2.jpg" });
        lugarTuristico.setDescripcion("Bajo las poderosas alas de un descomunal pterodáctilo se ubica el ingreso del nuevo parque cretácico del municipio de Sacaba que fue inaugurado con el objetivo de impulsar el turismo en Cochabamba con la presentación de gigantescas esculturas de reptiles extintos como un tiranosaurio-rex, Pterodáctilo, el ankilosaurio o un inmenso triceratop, coloridas esculturas con un recorrido recreacional que transportará a los visitantes a la prehistoria para descubrir la fascinante fauna, de la que aún se desconoce la exacta razón de su extinción.\n" +
                "Los hermanos y escultores bolivianos, Edgar y Juan García Guzmán, que también produjeron los dinosaurios del Parque Cretácico de Sucre en 2006, mejoraron el proyecto inicial para darle una mayor espectacularidad. Por ejemplo, diseñaron el ingreso del parque ubicándolo en medio de las patas de la réplica de un Pterodáctilo de gran tamaño.\n" +
                "Pero entre las réplicas de los dinosaurios, no deja de sorprender el Tiranosaurio de cinco metros de alto y 15 de largo un carnívoro bípedo con un enorme cráneo equilibrado por una cola larga y pesada.  Durante mucho tiempo el Tiranosaurio fue el mayor carnívoro de su ecosistema, debió haber sido el superpredador, cazando hadrosáuridos y ceratópsidos, aunque algunos expertos han sugerido que era principalmente carroñero.\n" +
                "La réplica más grande del parque temático de Sacaba es el Pterodáctilo con 10 metros de altura ubicado al ingreso del lugar, el animal era un carnívoro y probablemente cazaba peces y otros animales pequeños. Sus alas estaban formadas por una membrana de músculo y piel que se extendía desde su alargado cuarto dedo hasta sus miembros posteriores.\n");
        lugarTuristico.setHorario("Martes a Domingo 09:00 – 18:00");
        lugarTuristico.setDireccion("Av. Villazón km. 10");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.39652609446997f);
        lugarTuristico.setGpsY(-66.052685379982f);
        lugarTuristico.setLinea("212, 233, 241, 244");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_REALIZACIONES);
        lugarTuristico.setNombre("Liriuni");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"liriuni3.jpg", "liriuni1.jpg", "liriuni2.jpg" });
        lugarTuristico.setDescripcion("Liriuni es un balneario natural, ubicado en la Cordillera Tunari, dentro el municipio de Quillacollo. Se encuentra a 20 kilómetros de la ciudad de Cochabamba.\n" +
                "De belleza impactante, el viajero es testigo de cómo aquí se confunden el campo, la brisa, el agua y los sonidos propios del lugar para dar como resultado un paisaje apasionante y cautivador.\n" +
                "El gran imán de esta hermosa zona es, definitivamente la cualidad curativa y medicinal que posee sus aguas, es por ello que muchos visitantes, más que todo adultos mayores, acuden al lugar sólo para comprobar las cualidades terapéuticas de sus aguas.\n" +
                "Estas propiedades medicinales son fruto de la alta concentración de minerales y del proceso natural que atraviesa el agua, porque los acuíferos subterráneos se infiltran en la corteza terrestre y llegan a tomar contacto con la lava y se evapora; y al subir, este vapor se vuelve a condensar, cerrando así el ciclo de formación de aguas termales o minerales.\n" +
                "La mayoría de los visitantes del turno del día llega a la piscina en busca de sanar sus afecciones y dolencias, especialmente en casos de reumatismo y dolor de huesos.\n" +
                "Es uno de los lugares más concurridos y con más demanda en Quillacollo donde la gente viene a acampar y a disfrutar de la naturaleza.\n");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Noroeste, en el Municipio de Quillacollo, Bolivia");
        lugarTuristico.setTelefono(65027337);
        lugarTuristico.setGpsX(-17.287852468753886f);
        lugarTuristico.setGpsY(-66.29197061061859f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_REALIZACIONES);
        lugarTuristico.setNombre("Parque de Educación Vial");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"parque de educacion vial4.jpg","parque de educacion vial1.jpg", "parque de educacion vial3.jpg"});
        lugarTuristico.setDescripcion("Área recreacional de educación vial, donde los más pequeños pueden aprender sobre la seguridad vial, a través de un pequeño circuito y recorridos divertidos, en el cual podrán identificar las diferentes señalizaciones viales. Dentro esta área se puede apreciar igualmente diferentes juegos recreacionales, paseos a través del trencito en las diferentes calles creadas dentro el parque y diversión con cochecitos chocadores además de diferentes áreas verdes.");
        lugarTuristico.setHorario("Martes a Domingo 10:00 – 19:00.");
        lugarTuristico.setDireccion("Av. Ramón Rivero, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.381060817049427f);
        lugarTuristico.setGpsY(-66.15509748458862f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_REALIZACIONES);
        lugarTuristico.setNombre("Parque de la Familia");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"parque de la familia1.jpg", "parque de la familia2.jpg", "parque de la familia3.jpg"});
        lugarTuristico.setDescripcion("También conocido como el parque de “aguas danzantes”. Esta nueva atracción tiene un moderno sistema que combina música e iluminación con el movimiento de los chorros de agua. La combinación de estos elementos permite la proyección de imágenes en el agua y disparos del líquido a una altura de hasta 20 metros. El espectáculo se sincroniza con música.");
        lugarTuristico.setHorario("Martes a Domingo: 15:00 a 22:00");
        lugarTuristico.setDireccion("Av. Pedro Domingo Murillo, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(70696666);
        lugarTuristico.setGpsX(-17.38643618581872f);
        lugarTuristico.setGpsY(-66.16346597671509f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_REALIZACIONES);
        lugarTuristico.setNombre("Centro Ferial Alalay");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"centro ferial alalay1.jpg", "centro ferial alalay.jpg" });
        lugarTuristico.setDescripcion("La Feria Internacional de Cochabamba que se lleva a cabo en el Recinto Ferial Alalay, en el Circuito Bolivia, es un evento anual donde se exponen productos y servicios de diferentes empresas nacionales e internacionales, ya que Feicobol se ha hecho conocida a lo largo de los 30 años que lleva vigente. La feria convoca la participación de industriales, importadores, exportadores, distribuidores, agentes, representantes y comercializadores directos. Cuenta con diferentes stands distribuidos en cuatro pabellones: Pabellón Bolivia, Pabellón Internacional, Pabellón Unión Europea y Pabellón Bicentenario. El recinto ferial tiene extensas áreas verdes, espacios de recreación, además de salones y centro de convenciones donde se llevan a cabo las Ruedas de negocios propias de la feria.\n" +
                "También se realizan presentaciones artísticas y musicales a cargo de diferentes grupos nacionales e internacionales.\n" +
                "Esta feria internacional se celebra entre los últimos días del mes de abril y los primeros días del mes de mayo.\n");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Circuito Bolivia.");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.41790175278443f);
        lugarTuristico.setGpsY(-66.12979368704133f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CHAPARE);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_REALIZACIONES);
        lugarTuristico.setNombre("Parque Machia");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"parque machia2.jpg", "parque machia3.jpg", "parque machia4.jpg", "parque machia1.jpg"});
        lugarTuristico.setDescripcion("Situado a dos kilómetros de Villa Tunari, en el Chapare, fue creado hace más de 10 años, es el lugar dedicado a la readaptación de animales que vivían en cautiverio. Este parque tiene una superficie de 36 hectáreas oficiales, a las que se suman otras 110 que se están utilizando con el permiso de las comunidades. Sus mentores la comunidad Inti Wara Yasi, se dedica al cuidado de varias especies que conviven en el parque, en su mayor parte monos, loros, tucanes, papagayos, halcones, tejones, ciervos, armadillos, perezosos, reptiles y felinos.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("7, Villa Tunari, Bolivia.");
        lugarTuristico.setTelefono(4136572);
        lugarTuristico.setGpsX(-16.97173538754652f);
        lugarTuristico.setGpsY(-65.41171789169312f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_REALIZACIONES);
        lugarTuristico.setNombre("Parque acuático Mariscal Santa Cruz");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"parque mariscal santa cruz1.jpg", "parque mariscal santa cruz2.jpg", "parque mariscal santa cruz4.jpg", "parque mariscal santa cruz5.jpg" });
        lugarTuristico.setDescripcion("El parque Mariscal Santa Cruz es una verdadera y sólida opción para quienes desean practicar deportes de diferente naturaleza. Cuenta con amplios espacios verdes, campos deportivos y áreas para juegos o simplemente lugares de convivencia. Su infraestructura deportiva consta de canchas poli funcionales, ideales para la práctica de básquet, voleibol y fútbol de salón. Lo que le permite una agradable estadía de los visitantes.\n" +
                "\n" +
                "Se destaca como espacio recreativo más grande de la ciudad de Cochabamba. El objetivo de su recreación fue la sensibilización ciudadana, recuperación y preservación del medio ambiente, además de la defensa de los recursos de la naturaleza como el agua, el aire y la biodiversidad.\n" +
                "\n" +
                "Es un lugar de encuentro para niños y público en general, donde se puede disfrutar en familia de la piscina, entornos naturales, diferentes juegos recreativos, botes acuáticos a pedal y tener una experiencia dentro del museo subterráneo del parque.\n");
        lugarTuristico.setHorario("Martes a Viernes 09:00 -19:00, Sábado y Domingo 10:00 – 19:30");
        lugarTuristico.setDireccion("Hernán Morales, zona Chimba Cochabamba, Bolivia.");
        lugarTuristico.setTelefono(68444499);
        lugarTuristico.setGpsX(-17.400554735575163f);
        lugarTuristico.setGpsY(-66.17417335510254f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_PUNATA);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_REALIZACIONES);
        lugarTuristico.setNombre("Parques Defensores del Chaco");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"parques defensores del chaco.jpg"});
        lugarTuristico.setDescripcion("Este parque se encuentra ubicado en la parte posterior del templo San Juan Bautista, en ella se encuentra el monumento en homenaje al héroe de la guerra del chaco el Mariscal Bernardinho Bilbao Rioja. Es importante mencionar que punateños y punateñas como el Mayor Desiderio Rocha, Tte de Av.Alberto Montaño, Walter Rocha, Lucio Canedo, Subte. Laureano Hinojosa quienes fueron partícipes en estos actos valerosos quienes hoy en día guardan sus restos en el Cementerio general de Punata. Este monumento fue entregado por la Sub federación de beneméritos de la Patria el año 1991.");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Calle Bolívar, Punata");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.54528487733693f);
        lugarTuristico.setGpsY(-65.83497919142246f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);



        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_REALIZACIONES);
        lugarTuristico.setNombre("Plaza 14 de Septiembre");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"plaza 14 de septiembre4.jpg", "plaza 14 de septiembre1.jpg", "plaza 14 de septiembre2.jpg", "plaza 14 de septiembre3.jpg"});
        lugarTuristico.setDescripcion("Remodelada en 1938, la plaza 14 de Septiembre se cobra importancia por su diseño y pasado histórico. \n" +
                "En el nivel inferior de sus cuatro elevaciones muestra un ritmo unitario de arcos sobre las columnas (estilos Dórico y Jónico). El cuerpo superior de las edificaciones de su alrededor se remató con frontones y áticos cuyo resultado definitivo y que se mantiene hasta nuestros días es la conjugación de los estilos: Barroco y Neo-Clásico.\n" +
                "En el centro se observa un enorme enfilado de cemento conocido como “Columna de los Héroes” o “Columna de la Libertad” (estilo Corintio), que en su cúspide se yergue un cóndor con las alas extendidas. \n" +
                "De jardines incomparables y de eterna primavera, la plaza principal de Cochabamba, ofrece un ambiente de paz e inspiración.\n");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Nataniel Aguirre y Bolívar, Cochabamba, Bolivia.");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.393782267762315f);
        lugarTuristico.setGpsY(-66.15696161985397f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_REALIZACIONES);
        lugarTuristico.setNombre("Plazuela Cala Cala");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"plazuela cala cala2.jpg", "plazuela cala cala1.jpg" });
        lugarTuristico.setDescripcion("Construida el 1863 con el nombre de “Plaza del Regocijo” donde, cada noviembre, las familias más distinguidas de la ciudad se trasladaban para pasar momentos de grato esparcimiento, además de tomarse un delicioso baño. Ubicada en la campiña de Cala Cala, la “Plaza del Regocijo” Fue una de las más atractivas por sus exuberantes y paradisiacos bosques.\n" +
                "Hoy Cala Cala Mantiene su fama y tradición. Aunque la espesura de sus bosques y sus aires vallunos de noviembre han desaparecido, concentra todavía entre sus habitantes a las familias originarias Cochabambinas.\n");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Adela Zamudio, Man césped, Cochabamba, Bolivia.");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.368415279566744f);
        lugarTuristico.setGpsY(-66.16386830806732f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_REALIZACIONES);
        lugarTuristico.setNombre("Plazuela Colón");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"plazuela colon1.jpg", "plazuela colon2.jpg", "plazuela colon3.jpg", "plazuela colon4.jpg"});
        lugarTuristico.setDescripcion("Está llena de árboles y vegetación típica de Cochabamba y embellecida por las construcciones modernas de la zona. Tiene un vistoso puente peatonal sobre una pileta.\n" +
                "Frente a la Plaza Colón, sobre la acera este, se encuentra el paseo Independencia, que muestra la arquitectura de la época Republicana de la ciudad de Cochabamba. En este paseo, se llevan a cabo concierto, ferias, festivales y otras actividades de carácter cultural.\n" +
                "Antiguamente existía un portón entre la plaza Colón y El Prado, así como un tranvía que pasaba por un bosquecillo de árboles. Lleva el nombre de Plaza Colón en homenaje a Cristóbal Colón, descubridor de América.\n");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Rocha y San Martín, Cochabamba, Bolivia.");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.388064123495077f);
        lugarTuristico.setGpsY(-66.1558485031128f);
        lugarTuristico.setLinea("242");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_REALIZACIONES);
        lugarTuristico.setNombre("Plazuela Corazonistas");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"plazuela corazonistas1.jpg", "plazuela corazonistas2.jpg", "plazuela corazonistas3.jpg", "plazuela corazonistas4.jpg"});
        lugarTuristico.setDescripcion("Ubicada en la avenida Heroínas, frente a la Iglesia del Corazón de Jesús, esta plazuela de forma alargada, lleva al medio de ella un monumento de la Virgen con una gran aureola iluminada. El mismo fue construido en conmemoración al Encuentro Mariano en Cochabamba.");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("C. Hamiraya, Av. Heroínas, Cochabamba, Bolivia.");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.393183329966508f);
        lugarTuristico.setGpsY(-66.16151332855225f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo(Constants.TIPO_LUGAR_REALIZACIONES);
        lugarTuristico.setNombre("Salón de exposición Mario Unzueta");
        lugarTuristico.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"salon de exposicion mario unzueta1.jpg", "salon de exposicion mario unzueta2.jpg", "salon de exposicion mario unzueta3.jpg" });
        lugarTuristico.setDescripcion("Es un salón de exposición de artes plásticas, ero su básica es la promoción cultural de las actividades de diversas instituciones y personas que se dan a conocer y muchas veces, ofrecen a la ventas.");
        lugarTuristico.setHorario("Abierto.");
        lugarTuristico.setDireccion("Av. Heroínas esq. 25 de Mayo Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.391923378564208f);
        lugarTuristico.setGpsY(-66.15568924695253f);
        lugarTuristico.setLinea("");
        lugarTuristico.setFecha("");
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        return idLugTur;
    }
// Acontecimientos programados***********************************************************************************
    private void setListaAcontecimientos(int idAcontecimiento) {
        ModeloLugarTuristico acontecimiento;

        acontecimiento = new ModeloLugarTuristico();
        acontecimiento.setIdSQLite(idAcontecimiento++);
        acontecimiento.setProvincia(Constants.FIREBASE_PROVINCIA_ARANI);
        acontecimiento.setTipo("Acontecimientos Programados");
        acontecimiento.setNombre("Festividad de la Virgen “La Bella”");
        acontecimiento.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"festividad de la virgen la bella3.jpg", "festividad de la virgen la bella.jpg" });
        acontecimiento.setDescripcion("Araní es un atractivo destino para la práctica de turismo religioso, actividad que se encuentra enmarcada en una profunda tradición y ferviente vocación religiosa, resultado del proceso de evangelización y catequización que se llevó a cabo durante la conquista, además de haber funcionado como sede del Obispado de Santa Cruz de la Sierra, el siglo XVII. Entre el 23 y el 25 de agosto, Arani se viste de gala al celebrar la festividad religiosa en honor a la Virgen La Bella, declarada Patrimonio Cultural y Religioso del Departamento de Cochabamba, mediante Ley de 24 de diciembre de 2007. Esta fiesta, al contrario de otras festividades que comienzan con la entrada folklórica, inicia su evento festivo con el día del calvario, seguido de la procesión de la sagrada imagen de la Bella, para finalizar con la demostración folklórica.\n" +
                "No obstante, antes de la celebración misma de la fiesta, la imagen es venerada en principio en la ciudad de Sacaba para después retornar a Arani donde se da inicio a las tres jornadas festivas. En esta fiesta, durante el calvario también se acostumbra adquirir objetos en miniatura o propiedades para luego ser bendecidas en los rituales católicos y andinos, con similares características que las de Urkupiña.\n");
        acontecimiento.setHorario("09:00");
        acontecimiento.setDireccion("Arani, Bolivia");
        acontecimiento.setTelefono(0);
        acontecimiento.setGpsX(-17.57885187017981f);
        acontecimiento.setGpsY(-65.77288269996643f);
        acontecimiento.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        acontecimiento.setFecha("25 mayo ");
        acontecimiento.setLinea("");
        listaLugares.add(acontecimiento);


        acontecimiento = new ModeloLugarTuristico();
        acontecimiento.setIdSQLite(idAcontecimiento++);
        acontecimiento.setProvincia(Constants.FIREBASE_PROVINCIA_PUNATA);
        acontecimiento.setTipo(Constants.TIPO_LUGAR_ACONTECIMIENTOS);
        acontecimiento.setTipo("Acontecimientos Programados");
        acontecimiento.setNombre("La festividad del Señor de los milagros");
        acontecimiento.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"la festividad del señor de los milagros0.jpg", "la festividad del señor de los milagros1.jpg"});
        acontecimiento.setDescripcion("Una de las características de Punata es la celebración de diferentes festividades religiosas, siendo la fiesta patronal del Señor de Milagros que recuerda la exaltación de la Cruz celebrada el último fin de semana del mes de Septiembre.\n" +
                "La Festividad del Señor de los Milagros fue reconocida como Patrimonio Cultural e Inmaterial de Bolivia. La imagen del Patrono fue trabajada, con todos los rasgos y detalles de un ser humano de un tamaño de 50 centímetros. En la región de la columna vertebral a la altura de la cintura, tiene una abertura de 3 cm, cubierta de vidrio.\n" +
                "La imagen llegó a Bolivia el año 1943 procedente de Burgos - España y a Punata gracias a la diligencia del Dr. Manuel de la Cruz Méndez para alguno de sus hijos que elija la vocación sacerdotal siendo merecedor Juan Méndez.\n ");
        acontecimiento.setHorario("Abierto");
        acontecimiento.setDireccion("Punata, Bolivia");
        acontecimiento.setTelefono(0);
        acontecimiento.setFecha("10 Diciembre");
        acontecimiento.setGpsX(-17.545190252404954f);
        acontecimiento.setGpsY(-65.83560414612293f);
        acontecimiento.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(acontecimiento);

//****** dol doc.
        acontecimiento = new ModeloLugarTuristico();
        acontecimiento.setIdSQLite(idAcontecimiento++);
        acontecimiento.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        acontecimiento.setTipo(Constants.TIPO_LUGAR_ACONTECIMIENTOS);
        acontecimiento.setTipo("Acontecimientos Programados");
        acontecimiento.setNombre("Carnaval de la concordia");
        acontecimiento.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"carnaval de la concordia.jpg"});
        acontecimiento.setDescripcion("El Carnaval de la Concordia, tiene su origen en el carnaval de antaño que llegó con la presencia de los españoles. Es una de las fiestas más populares y democráticas del país ya que participan sin ninguna distinción todos los sectores de la sociedad. ");
        acontecimiento.setHorario("09:00");
        acontecimiento.setDireccion("Av. José Ballivian, paseo del prado, Cochabamba, Bolivia.");
        acontecimiento.setTelefono(0);
        acontecimiento.setFecha("4 Marzo");
        acontecimiento.setGpsX(-17.386061810323937f);
        acontecimiento.setGpsY(-66.1568412607924f);
        acontecimiento.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(acontecimiento);


        acontecimiento = new ModeloLugarTuristico();
        acontecimiento.setIdSQLite(idAcontecimiento++);
        acontecimiento.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        acontecimiento.setTipo(Constants.TIPO_LUGAR_ACONTECIMIENTOS);
        acontecimiento.setTipo("Acontecimientos Programados");
        acontecimiento.setNombre("Festividad de San Andrés");
        acontecimiento.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"festividad de san andres.jpg"});
        acontecimiento.setDescripcion("Esta fiesta se realiza en la región de la Taquiña cada 30 de noviembre en honor a San Andrés, aunque su celebración comienza el 27, San Andrés Cuna de Wayllunk’as. ");
        acontecimiento.setHorario("10:00");
        acontecimiento.setDireccion("Zona Taquiña, Cochabamba, Bolivia.");
        acontecimiento.setTelefono(0);
        acontecimiento.setFecha("30 Noviembre");
        acontecimiento.setGpsX(-17.3522988f);
        acontecimiento.setGpsY(-66.1922095f);
        acontecimiento.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(acontecimiento);


        acontecimiento = new ModeloLugarTuristico();
        acontecimiento.setIdSQLite(idAcontecimiento++);
        acontecimiento.setProvincia(Constants.FIREBASE_PROVINCIA_MIZQUE);
        acontecimiento.setTipo(Constants.TIPO_LUGAR_ACONTECIMIENTOS);
        acontecimiento.setTipo("Acontecimientos Programados");
        acontecimiento.setNombre("Festividad del Señor de Burgos");
        acontecimiento.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"festividad del señor de burgos.jpg"});
        acontecimiento.setDescripcion("La población mizqueña mantiene, desde tiempos de la Colonia, la fe por el Señor de Burgos, al que se le atribuyen varios milagros y se pide intercesión en los partos difíciles.");
        acontecimiento.setHorario("Abierto");
        acontecimiento.setDireccion("Mizque, Cochabamba, Bolivia.");
        acontecimiento.setTelefono(0);
        acontecimiento.setFecha("19 Septiembre");
        acontecimiento.setGpsX(-17.9418306f);
        acontecimiento.setGpsY(-65.3435859f);
        acontecimiento.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(acontecimiento);


        /*acontecimiento = new ModeloLugarTuristico();
        acontecimiento.setIdSQLite(idAcontecimiento++);
        acontecimiento.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        acontecimiento.setTipo(Constants.TIPO_LUGAR_ACONTECIMIENTOS);
        acontecimiento.setTipo("Acontecimientos Programados");
        acontecimiento.setNombre("Fiesta de Compadres y Comadres");
        acontecimiento.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{});
        acontecimiento.setDescripcion("El carnaval Cochabambino, se inicia el jueves de compadres y continua con el jueves siguiente que celebran de la misma forma las “comadres”. Así dentro de estas actividades se desarrolla la ya tradicional \"Feria del Puchero y Festival del Acordeón y la Concertina”.");
        acontecimiento.setHorario("10:00");
        acontecimiento.setDireccion("Cochabamba, Bolivia.");
        acontecimiento.setTelefono(0);
        acontecimiento.setFecha("");
        acontecimiento.setGpsX(-17.398708023328837f);
        acontecimiento.setGpsY(-66.15274988934343f);
        acontecimiento.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(acontecimiento);*/


        acontecimiento = new ModeloLugarTuristico();
        acontecimiento.setIdSQLite(idAcontecimiento++);
        acontecimiento.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        acontecimiento.setTipo(Constants.TIPO_LUGAR_ACONTECIMIENTOS);
        acontecimiento.setTipo("Acontecimientos Programados");
        acontecimiento.setNombre("Festividad de Cristo Rey");
        acontecimiento.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"festividad de cristo rey.jpg"});
        acontecimiento.setDescripcion("Recordemos que cada año en esta fiesta religiosa se hacía una peregrinación al Cristo de la Concordia y se celebraba una eucaristía a los pies del Cristo.");
        acontecimiento.setHorario("No se tiene registrado.");
        acontecimiento.setDireccion("Av. de la Concordia, Cochabamba, Bolivia.");
        acontecimiento.setTelefono(0);
        acontecimiento.setFecha("25 Noviembre");
        acontecimiento.setGpsX(-17.38435132938883f);
        acontecimiento.setGpsY(-66.1349768936634f);
        acontecimiento.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(acontecimiento);


        acontecimiento = new ModeloLugarTuristico();
        acontecimiento.setIdSQLite(idAcontecimiento++);
        acontecimiento.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        acontecimiento.setTipo(Constants.TIPO_LUGAR_ACONTECIMIENTOS);
        acontecimiento.setTipo("Acontecimientos Programados");
        acontecimiento.setNombre("Festividad de San Joaquín");
        acontecimiento.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"festividad de san joaquin.jpg", "festividad de san joaquin1.jpg" });
        acontecimiento.setDescripcion("El tradicional barrio de Jaihuayco se prepara para celebrar la Fiesta de San Joaquín, considerado según la tradición católica el abuelo de Jesucristo, del 24 al 27 de agosto.La festividad se inicia el viernes 24 de agosto con la verbena. Sigue el sábado 25 con la Entrada Folklórica, sigue el domingo 26 con la misa y termina 27 con el calvario.");
        acontecimiento.setHorario("No se tiene registrado.");
        acontecimiento.setDireccion("Jaihuayco, Cochabamba, Bolivia.");
        acontecimiento.setTelefono(0);
        acontecimiento.setFecha("24 Agosto");
        acontecimiento.setGpsX(-17.4214352f);
        acontecimiento.setGpsY(-66.1584174f);
        acontecimiento.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(acontecimiento);


        acontecimiento = new ModeloLugarTuristico();
        acontecimiento.setIdSQLite(idAcontecimiento++);
        acontecimiento.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        acontecimiento.setTipo(Constants.TIPO_LUGAR_ACONTECIMIENTOS);
        acontecimiento.setTipo("Acontecimientos Programados");
        acontecimiento.setNombre("Festividad de Santa Veracruz");
        acontecimiento.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"festividad de santa veracruz.jpg"});
        acontecimiento.setDescripcion("Santa Vera Cruz, es una de las festividades religiosas más grandes de la Arquidiócesis de Cochabamba, que reconoce las bendiciones del Señor en la fecundidad. Santa Vera Cruz es la segunda festividad religiosa más importante del departamento de Cochabamba. Cada año, recibe 40.000 turistas, el 90 por ciento nacionales. ");
        acontecimiento.setHorario("No se tiene registrado.");
        acontecimiento.setDireccion("Av. Petrolera km7, Cochabamba, Bolivia.");
        acontecimiento.setTelefono(0);
        acontecimiento.setFecha("1 Mayo");
        acontecimiento.setGpsX(-17.4559286f);
        acontecimiento.setGpsY(-66.1263881f);
        acontecimiento.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(acontecimiento);


        acontecimiento = new ModeloLugarTuristico();
        acontecimiento.setIdSQLite(idAcontecimiento++);
        acontecimiento.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        acontecimiento.setTipo(Constants.TIPO_LUGAR_ACONTECIMIENTOS);
        acontecimiento.setTipo("Acontecimientos Programados");
        acontecimiento.setNombre("Fiesta de la Virgen del Carmen");
        acontecimiento.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"fiesta de la virgen del carmen.jpg"});
        acontecimiento.setDescripcion("La Virgen del Carmen es Patrona de las Fuerzas Armadas y es venerada casi en todos los pueblos de Bolivia, donde la milagrosa imagen sale por distintas calles en procesión donde la gente rinde tributos. ");
        acontecimiento.setHorario("Abierto");
        acontecimiento.setDireccion("av. Ecuador, Cochabamba, Bolivia.");
        acontecimiento.setTelefono(0);
        acontecimiento.setFecha("16 Julio  ");
        acontecimiento.setGpsX(-17.3903429f);
        acontecimiento.setGpsY(-66.1580821f);
        acontecimiento.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(acontecimiento);


        acontecimiento = new ModeloLugarTuristico();
        acontecimiento.setIdSQLite(idAcontecimiento++);
        acontecimiento.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        acontecimiento.setTipo(Constants.TIPO_LUGAR_ACONTECIMIENTOS);
        acontecimiento.setTipo("Acontecimientos Programados");
        acontecimiento.setNombre("Festividad de Todos Santos");
        acontecimiento.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"festividad de todos santos.jpg", "festividad de todos santos2.jpg" });
        acontecimiento.setDescripcion("En Bolivia, desde tiempos inmemoriales, las comunidades originarias celebran la fiesta a los muertos. Con la llegada de los conquistadores español esta fiesta se fusiono con la fiesta de Todos Santos que los católicos celebran los dos primeros días de noviembre de cada año. Desde entonces la tradición de festejar a las almas y ajayus(almas en aymara), de los muertos forma parte de los detalles culturales de muchos bolivianos.");
        acontecimiento.setHorario("Abierto");
        acontecimiento.setDireccion("Av. Bartolomé Guzmán");
        acontecimiento.setTelefono(0);
        acontecimiento.setFecha("2 Noviembre");
        acontecimiento.setGpsX(-17.4092406f);
        acontecimiento.setGpsY(-66.1607367f);
        acontecimiento.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(acontecimiento);


        acontecimiento = new ModeloLugarTuristico();
        acontecimiento.setIdSQLite(idAcontecimiento++);
        acontecimiento.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        acontecimiento.setTipo(Constants.TIPO_LUGAR_ACONTECIMIENTOS);
        acontecimiento.setTipo("Acontecimientos Programados");
        acontecimiento.setNombre("Feria Internacional de Cochabamba");
        acontecimiento.setImagenesFirebaseArreglo(ModeloImagen.TIPO_LUGAR, new String[]{"feria internacional de cochabamba.jpg", "feria internacional de cochabamba2.jpg" });
        acontecimiento.setDescripcion("La Feria Internacional de Cochabamba, nace como proyecto en 1971 por iniciativa de la Federación de Entidades Empresariales Privadas de Cochabamba (FEPC), como un primer ensayo realizado en el Estado Mayor, organizado y apoyado por la Cámara de Comercio de Cochabamba.");
        acontecimiento.setHorario("Abierto");
        acontecimiento.setDireccion("Circuito Bolivia, Cochabamba.");
        acontecimiento.setTelefono(0);
        acontecimiento.setFecha("26 Abril ");
        acontecimiento.setGpsX(-17.4092406f);
        acontecimiento.setGpsY(-66.1607367f);
        acontecimiento.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(acontecimiento);
    }

    private void setListaUsuarios() {
        int idUser = 1;
        ModeloUsuario modeloUsuario;

        idUser++;
        modeloUsuario = new ModeloUsuario();
        modeloUsuario.setIdSqlite(idUser);
        modeloUsuario.setNombre("Herminia");
        modeloUsuario.setApellido("Garcia");
        modeloUsuario.setEmail("hga.ax88@gmail.com");
        modeloUsuario.setIdFirebase(modeloUsuario.getEmail());
        modeloUsuario.setTelefono(String.valueOf(60761942));
        modeloUsuario.setContrasenia("firebase123");
        modeloUsuario.setRol(Constants.USUARIO_ROL_ADMIN);
        modeloUsuario.setEstado(Constants.ESTADO_USUARIO_ACTIVO);
        listaUsuarios.add(modeloUsuario);

        idUser++;
        modeloUsuario = new ModeloUsuario();
        modeloUsuario.setIdSqlite(idUser);
        modeloUsuario.setNombre("Juan");
        modeloUsuario.setApellido("Perez");
        modeloUsuario.setEmail("juan@gmail.com");
        modeloUsuario.setIdFirebase(modeloUsuario.getEmail());
        modeloUsuario.setTelefono(String.valueOf(60761941));
        modeloUsuario.setContrasenia("firebase123");
        modeloUsuario.setRol(Constants.USUARIO_ROL_REVISOR);
        modeloUsuario.setEstado(Constants.ESTADO_USUARIO_ACTIVO);
        listaUsuarios.add(modeloUsuario);

        idUser++;
        modeloUsuario = new ModeloUsuario();
        modeloUsuario.setIdSqlite(idUser);
        modeloUsuario.setNombre("Juana");
        modeloUsuario.setApellido("Gonzales");
        modeloUsuario.setEmail("juana@gmail.com");
        modeloUsuario.setIdFirebase(modeloUsuario.getEmail());
        modeloUsuario.setTelefono(String.valueOf(60761940));
        modeloUsuario.setContrasenia("firebase123");
        modeloUsuario.setRol(Constants.USUARIO_ROL_REVISOR);
        modeloUsuario.setEstado(Constants.ESTADO_USUARIO_ACTIVO);
        listaUsuarios.add(modeloUsuario);
    }
}
