package com.hga.appturismo.provider;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.hga.appturismo.R;
import com.hga.appturismo.modelo.ModeloHotel;
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
    private ArrayList<ModeloPuntaje> usuarioLugar;

    public Listas() {
        this.listaHoteles = new ArrayList<>();
        this.listaLugares = new ArrayList<>();
        this.listaRestaurantes = new ArrayList<>();
        this.listaUsuarios= new ArrayList<>();
        this.listaUsuarios= new ArrayList<>();
        this.usuarioLugar= new ArrayList<>();

        setListaLugarTuristico();
        setListaHoteles();
        setListaRestaurantes();
        //setListaUsuarios();
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

    public ArrayList<ModeloUsuario> getListaUsuarios(){
        return listaUsuarios;
    }

    public ArrayList<ModeloPuntaje> getUsuarioLugar(){
        return usuarioLugar;
    }

    private void setListaHoteles() {
        int idHotel = 1;
        ModeloHotel hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal Bonairense");
        hotel.setGpsX(-17.389546148501218f);
        hotel.setGpsY(-66.15610867738724f);
        hotel.setDireccion("Alfonso Arze nro. 2091 Zona: Jaihuayco");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hostal bonairense.jpg",
                "hostal bonairense1.jpg",
                "hostal bonairense4.jpg",
                "hostal bonairense7.jpg" ,
                "hostal bonairense9.jpg"
        });
        hotel.setTelefono(4567452);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("hostal-bonairense.com");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Apart Hotel Regina");
        hotel.setGpsX(-17.38629988377598f);
        hotel.setGpsY(-66.15779981017113f);
        hotel.setDireccion("C. España nro.636");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "apart hotel regina.jpg",
                "Apart Hotel Regina1.jpg",
                "Apart Hotel Regina2.jpg",
                "Apart Hotel Regina3.jpg",
                "Apart Hotel Regina4.jpg",
                "Apart Hotel Regina5.jpg",
                "Apart Hotel Regina6.jpg",
                "Apart Hotel Regina7.jpg",
                "Apart Hotel Regina8.jpg"
        });
        hotel.setTelefono(0);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado");
        hotel.setEmail("No se tiene registrado");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Portales");
        hotel.setGpsX(-17.375694249761082f);
        hotel.setGpsY(-66.15142554044724f);
        hotel.setDireccion("Av. Pando nro. 1271(Recoleta)");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel portales1.jpg",
                "Hotel Portales2.jpg",
                "Hotel Portales3.jpg",
                "Hotel Portales4.jpg",
                "Hotel Portales5.jpg",
                "Hotel Portales6.jpg",
                "Hotel Portales7.jpg"
        });
        hotel.setTelefono(4285444);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("hotelportales.com.bo");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal Olympic");
        hotel.setGpsX(-17.381609879813155f);
        hotel.setGpsY(-66.14440619945526f);
        hotel.setDireccion("Av. Aniceto Arce nro. 766 entre Papa Paulo y Puente Muyurina");
        hotel.setImagenesFirebaseArreglo(new String[]{"olympic extreme relax - hostal olympic1.jpg", "olympic extreme relax - hostal olympic2.jpg", "olympic extreme relax - hostal olympic3.jpg" });
        //hotel.setimagenesandroid(new int[]{r.drawable.img_portada});
        hotel.setTelefono(4532066);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("hostalolympic.com");
        hotel.setEmail("No se tiene registrado");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Adara Suites Apart Hotel");
        hotel.setGpsX(-17.38467001063881f);
        hotel.setGpsY(-66.16149187088013f);
        hotel.setDireccion("C. Junín nro. 867 Zona: Central");
        hotel.setImagenesFirebaseArreglo(new String[]{"adara suites apart hotel1.jpg","adara suites apart hotel2.jpg", "adara suites apart hotel3.jpg","adara suites apart hotel4.jpg" });
        //hotel.setimagenesandroid(new int[]{r.drawable.img_portada});
        hotel.setTelefono(4662020);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb(" No se tiene registrado.");
        hotel.setEmail("info@adarahotel.com.bo");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);



        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Apart Hotel La Corona");
        hotel.setGpsX(-17.388023169265743f);
        hotel.setGpsY(-66.16324067115784f);
        hotel.setDireccion("C. Juan de la Reza nro. 433 entre c. Tumusla y Av. Rafael Urquidi (Central)");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "apart hotel la corona1.jpg"});
        hotel.setTelefono(4520269);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("lacorona@supernet.com.bo");
        hotel.setEmail("reserve.affiniaspence.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Armenia Hotel");
        hotel.setGpsX(-17.394268583333226f);
        hotel.setGpsY(-66.16348877549171f);
        hotel.setDireccion("General Achá nro. 560 Edificio: Hotel Mundial Piso: Pb Zona: Barrio Noroeste");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "armenia hotel5.jpg","armenia hotel1.jpg", "armenia hotel2.jpg", "armenia hotel3.jpg", "armenia hotel4.jpg"  });
        hotel.setTelefono(0);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("virbaba@hotmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Cesar's Plaza Hotel");
        hotel.setGpsX(-17.39313661785511f);
        hotel.setGpsY(-66.15532882511616f);
        hotel.setDireccion("C. 25 de Mayo entre Bolívar y Sucre nro. 210 Zona: Central");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "cesar's plaza hotel.jpg", "cesar's plaza hotel1.jpg", "cesar's plaza hotel2.jpg", "cesar's plaza hotel3.jpg" });
        hotel.setTelefono(4254032);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.cesarsplaza.com");
        hotel.setEmail("info@cesarsplaza.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("City Hotel");
        hotel.setGpsX(-17.39501597105829f);
        hotel.setGpsY(-66.15571975708008f);
        hotel.setDireccion("C. Jordán nro. 341 entre 25 de mayo y Esteban Arze Zona: Central");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "city hotel ltda1.jpg", "city hotel ltda2.jpg", "city hotel ltda3.jpg", "city hotel ltda4.jpg", "city hotel ltda5.jpg", "city hotel ltda6.jpg" });
        hotel.setTelefono(4222993);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.cityhotelbolivia.com");
        hotel.setEmail("cityhotel42@hotmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Monserrat Hotel");
        hotel.setGpsX(-17.389583262963f);
        hotel.setGpsY(-66.15698978304863f);
        hotel.setDireccion("C. España nro.  342 entre Mayor Rocha y Ecuador");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "monserrat hotel1.jpg", "monserrat hotel2.jpg", "monserrat hotel3.jpg", "monserrat hotel4.jpg", "monserrat hotel5.jpg" });
        hotel.setTelefono(4521011);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.hotelmonserrat.com");
        hotel.setEmail("hotelmonse@supernet.com.bo");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Briston");
        hotel.setGpsX(-17.394549813918648f);
        hotel.setGpsY(-66.16483876481652f);
        hotel.setDireccion("C. Suipacha nro. 181 Zona: Central");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel briston.jpg", "hotel briston1.jpg", "hotel briston3.jpg" });
        hotel.setTelefono(0);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("El Poncho");
        hotel.setGpsX(-17.337405060968177f);
        hotel.setGpsY(-66.29199676215649f);
        hotel.setDireccion("Camino Antiguo a Portero Zona: Marquina");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "el poncho.jpg", "el poncho2.jpg", "el poncho3.jpg", "el poncho4.jpg", "el poncho5.jpg", "el poncho6.jpg" });
        hotel.setTelefono(4392283);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado");
        hotel.setEmail("hdeglone@elponcho.org");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Americana Hotel");
        hotel.setGpsX(-17.399221249840263f);
        hotel.setGpsY(-66.15543812513351f);
        hotel.setDireccion("C. Esteban Arze nro. 788 Edificio: Americana Hotel Zona: Sud-Oeste");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "americana hotel0.jpg", "americana hote1.jpg",  "americana hotel2.jpg", "americana hotel3.jpg", "americana hotel5.jpg" });
        hotel.setTelefono(0);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.americanahotel.com.bo");
        hotel.setEmail("americanahotel@email.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Heroínas");
        hotel.setGpsX(-17.392945290041474f);
        hotel.setGpsY(-66.1604592204094f);
        hotel.setDireccion("Av. Heroínas nro. 239 entre Junín y Hamiraya");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel heroinas.jpg", "hotel heroinas2.jpg", "hotel heroinas3.jpg" });
        hotel.setTelefono(4583171);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.hotelheroinas.webs.com");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal Maya Bolivia");
        hotel.setGpsX(-17.39239882086965f);
        hotel.setGpsY(-66.16528317332268f);
        hotel.setDireccion("C. Colombia nro. 710 Zona: Noroeste");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hostal maya bolivia1.jpg", "hostal maya bolivia2.jpg", "hostalmayabolivia.jpg" });
        hotel.setTelefono(4259701);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("ricardo_pol-acha@hotmial.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Briston");
        hotel.setGpsX(-17.394549813918648f);
        hotel.setGpsY(-66.16483876481652f);
        hotel.setDireccion("C. Suipacha nro. 181 Zona: Central");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel briston.jpg", "hotel briston1.jpg", "hotel briston3.jpg" });
        hotel.setTelefono(0);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Camino Plaza");
        hotel.setGpsX(-17.36868151040645f);
        hotel.setGpsY(-66.1634150147438f);
        hotel.setDireccion("C.  Huallparimachi nro. 1862 Zona: Cala Cala");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel camino plaza1.jpg", "hotel camino plaza2.jpg", "hotel camino plaza3.jpg", "hotel camino plaza4.jpg", "hotel camino plaza5.jpg", "hotel camino plaza6.jpg", "hotel camino plaza7.jpg" });
        hotel.setTelefono(4200306);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("caminoplaza.com");
        hotel.setEmail("gerencia@hotelcaminoplaza.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Diplomat Martinez");
        hotel.setGpsX(-17.38656608861003f);
        hotel.setGpsY(-66.15711316466331f);
        hotel.setDireccion("Av. Ballivián nro. 0611 Edificio: Hotel Diplomat Zona: El Prado");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel diplomat martinez sociedad ltda5.jpg", "hotel diplomat martinez sociedad ltda1.jpg", "hotel diplomat martinez sociedad ltda2.jpg", "hotel diplomat martinez sociedad ltda3.jpg", "hotel diplomat martinez sociedad ltda4.jpg", "hotel diplomat martinez sociedad ltda6.jpg" });
        hotel.setTelefono(4250687);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.hdiplomat.com");
        hotel.setEmail("info@hdiplomat.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Felipez");
        hotel.setGpsX(-17.391411460837585f);
        hotel.setGpsY(-66.15682817995548f);
        hotel.setDireccion("C. España nro. 172 entre Av. Heroínas y C. Colombia");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel felipez7.jpg", "hotel felipez.jpg", "hotel felipez2.jpg", "hotel felipez3.jpg" });
        hotel.setTelefono(4510773);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("felipezhotel.com-hotel.com");
        hotel.setEmail("walter.bustillos@gmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Integración");
        hotel.setGpsX(-17.040280491660837f);
        hotel.setGpsY(-64.86629068851471f);
        hotel.setDireccion("");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel integracion1.jpg", "hotel integracion2.jpg", "hotel integracion3.jpg", "hotel integracion4.jpg" });
        hotel.setTelefono(4773024);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("granhotelintegracion.com");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel León Avila");
        hotel.setGpsX(-17.392178696994918f);
        hotel.setGpsY(-66.16008270531893f);
        hotel.setDireccion("C. Junín nro. 156 Edificio: Hotel León Zona: Central");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel león avila1.jpg", "hotel león avila.jpg", "hotel león avila0.jpg", "hotel león avila2.jpg" });
        hotel.setTelefono(4589380);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("leondoryani@gmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Luxor Cochabamba");
        hotel.setGpsX(-17.384497231716722f);
        hotel.setGpsY(-66.15667060017586f);
        hotel.setDireccion("C. La Paz nro. 439 Edificio: Hotel Luxor Zona: Noreste");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel luxor cochabamba1.jpg", "hotel luxor cochabamba2.jpg" });
        hotel.setTelefono(4524048);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado");
        hotel.setEmail("luxoraparthotel@hotmail.es");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Manhattan");
        hotel.setGpsX(-17.397726505709343f);
        hotel.setGpsY(-66.15672424435616f);
        hotel.setDireccion("C. Ladislao Cabreranro.601 y Nataniel Aguirre Edificio: Hotel Manhattan");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel manhattan1.jpg", "hotel manhattan2.jpg" });
        hotel.setTelefono(0);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.hotelmanhattanbolivia.com");
        hotel.setEmail("reservashotelmanhattan@gmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Fortaleza");
        hotel.setGpsX(-17.399697313042324f);
        hotel.setGpsY(-66.15728214383125f);
        hotel.setDireccion("Av. Aroma.");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel fortaleza1.jpg"});
        hotel.setTelefono(4229912);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Apart Hotel Violetta");
        hotel.setGpsX(-17.387623225137908f);
        hotel.setGpsY(-66.15402862429619f);
        hotel.setDireccion("C. Lanza entre Paccieri y Venezuela nro. 464");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "apart hotel violetta1.jpg", "apart hotel violetta2.jpg", "apart hotel violetta3.jpg", "apart hotel violetta4.jpg"});
        hotel.setTelefono(4523386);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("violettas.com");
        hotel.setEmail("apart@violettas.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Kokusai");
        hotel.setGpsX(-17.397224842269264f);
        hotel.setGpsY(-66.15824103355408f);
        hotel.setDireccion("Av. Ayacucho nro. 552 entre Ladislao Cabrera y Calama");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel kokusai1.jpg"});
        hotel.setTelefono(4582486);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.hotelkokusaibolivia.com");
        hotel.setEmail("info@hotelkokusaibolivia.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Gran Hotel Ambassador ");
        hotel.setGpsX(-17.389441204120267f);
        hotel.setGpsY(-66.15731835365295f);
        hotel.setDireccion("Calle España Nro. 349 entre Mayor Rocha y Ecuador ");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "gran hotel ambassador ltda2.jpg", "gran hotel ambassador ltda1.jpg", "hotel ambassador1.jpg", "hotel ambassador2.jpg", "hotel ambassador3.jpg"});
        hotel.setTelefono(44253816);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.granhotelambassador.com/");
        hotel.setEmail("granhotelambassador@gmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal \"Escobar\"");
        hotel.setGpsX(-17.39902928852103f);
        hotel.setGpsY(-66.1564439535141f);
        hotel.setDireccion("C. Nataniel Aguirre nro. 749 entre C. Uruguay, Av. Aroma");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hostal escobar.jpg"});
        hotel.setTelefono(4225812);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal Pueblo Lindo Villa Tunari");
        hotel.setGpsX(-16.97578417977435f);
        hotel.setGpsY(-65.42054370045662f);
        hotel.setDireccion("Av. Benigno Paz entre Calle Santa Cruz Zona: Villa Tunari");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hostal pueblo lindo villa tunari1.jpg", "hostal pueblo lindo villa tunari2.jpg", "hostal pueblo lindo villa tunari3.jpg"});
        hotel.setTelefono(75976183);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal Dory’s");
        hotel.setGpsX(-17.399018410706905f);
        hotel.setGpsY(-66.15787960588932f);
        hotel.setDireccion("Av. Ayacucho nro. 754 Zona: Sud Oeste");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hostal dory’s1.jpg", "hostal dory’s2.jpg", "hostal dory’s3.jpg"});
        hotel.setTelefono(4583590);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado. ");
        hotel.setEmail("jobbalo@hotmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal Familiar F.G");
        hotel.setGpsX(-17.397214604225546f);
        hotel.setGpsY(-66.1633861809969f);
        hotel.setDireccion("C. Méndez Arcos nro. 518 Zona: Central");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hostal familiar f.g2.jpg", "hostal familiar f.g.jpg", "hostal familiar f.g1.jpg" });
        hotel.setTelefono(4589681);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado. ");
        hotel.setEmail("juanrodrigogamboa@hotmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal Habana “Las Cocas”");
        hotel.setGpsX(-16.9734529121648f);
        hotel.setGpsY(-65.41794195771217f);
        hotel.setDireccion("Av. Benigno Paz Zona: Villa Tunari");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hostal habana las cocas.jpg", "hostal habana las cocas2.jpg" });
        hotel.setTelefono(71776471);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Heroínas");
        hotel.setGpsX(-17.392945290041474f);
        hotel.setGpsY(-66.1604592204094f);
        hotel.setDireccion("Av. Heroínas nro. 239 entre Junín y Hamiraya");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel heroinas.jpg", "hotel heroinas2.jpg", "hotel heroinas3.jpg" });
        hotel.setTelefono(4583171);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.hotelheroinas.webs.com");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal J.E.M.");
        hotel.setGpsX(-17.393670926910215f);
        hotel.setGpsY(-66.15172326564789f);
        hotel.setDireccion("Antezana Sucre y Jordan Nro.341 Zona: Sud Este");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hostal j.e.m1.jpg", "hostal j.e.m2.jpg", "hostal j.e.m3.jpg" });
        hotel.setTelefono(4510058);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal Leito");
        hotel.setGpsX(-17.401348167769576f);
        hotel.setGpsY(-66.15586191415787f);
        hotel.setDireccion("C. Nataniel Aguirre nro. 939 Zona: Central Sud");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hostal leito.jpg"});
        hotel.setTelefono(4226890);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado");
        hotel.setEmail("hostal_leito@hotmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal Malibu");
        hotel.setGpsX(-17.399203333459f);
        hotel.setGpsY( -66.15641444921494f);
        hotel.setDireccion("C. Nataniel Aguirre nro. 767 Zona: Sud Oeste");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hostal malibu.jpg"});
        hotel.setTelefono(4503777);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("hostal-malibu.com");
        hotel.setEmail("terrazasdeysi@hotmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal Palmilla");
        hotel.setGpsX(-16.972299773769866f);
        hotel.setGpsY(-65.42222276329994f);
        hotel.setDireccion("Villa Tunari");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hostal palmilla.jpg"});
        hotel.setTelefono(76412571);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal Maya Bolivia");
        hotel.setGpsX(-17.39239882086965f);
        hotel.setGpsY(-66.16528317332268f);
        hotel.setDireccion("C. Colombia nro. 710 Zona: Noroeste");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hostal maya bolivia1.jpg", "hostal maya bolivia2.jpg", "hostalmayabolivia.jpg" });
        hotel.setTelefono(4259701);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("ricardo_pol-acha@hotmial.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal Puente de Plata");
        hotel.setGpsX(-17.394102212362366f);
        hotel.setGpsY( -66.16012662649155f);
        hotel.setDireccion("Gral. Achá nro. 235 Zona: Noroeste Central");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hostal puente de plata1.jpg", "hostal puente de plata2.jpg" });
        hotel.setTelefono(4583454);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado");
        hotel.setEmail("hostalcentral2@gmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal Versalles");
        hotel.setGpsX(-17.398723429735966f);
        hotel.setGpsY(-66.15793526172638f);
        hotel.setDireccion("Av. Ayacucho nro. 714 entre Ladislao Cabrera y Uruguay");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hostal versalles1.jpg", "hostal versalles2.jpg", "hostal versalles3.jpg" });
        hotel.setTelefono(4583315);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("hiversalles@yahoo.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Boston");
        hotel.setGpsX(-17.39149976674768f);
        hotel.setGpsY(-66.15580558776855f);
        hotel.setDireccion("C. 25 De Mayo nro. 167 Edificio: Hotel Boston Zona: Central");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel boston1.jpg"});
        hotel.setTelefono(4224421);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("hboston@supernet.com.bo");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Briston");
        hotel.setGpsX(-17.394549813918648f);
        hotel.setGpsY( -66.16483876481652f);
        hotel.setDireccion("C. Suipacha Esq. Gral. Acha  nro. 181 Zona: Central");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel briston.jpg", "hotel briston1.jpg", "hotel briston3.jpg" });
        hotel.setTelefono(4366156);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("hotelbriston.com");
        hotel.setEmail("info@hotelbriston.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Camino Plaza");
        hotel.setGpsX(-17.36868151040645f);
        hotel.setGpsY(-66.1634150147438f);
        hotel.setDireccion("C.  Huallparimachi nro. 1862 Zona: Cala Cala");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel camino plaza1.jpg", "hotel camino plaza2.jpg", "hotel camino plaza3.jpg", "hotel camino plaza4.jpg", "hotel camino plaza5.jpg", "hotel camino plaza6.jpg", "hotel camino plaza7.jpg" });
        hotel.setTelefono(4200306);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("caminoplaza.com");
        hotel.setEmail("gerencia@hotelcaminoplaza.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Victoria");
        hotel.setGpsX(-17.002789498689367f);
        hotel.setGpsY(-65.43620109558105f);
        hotel.setDireccion("C. Innominada, Carretera Cbba.-Sta. Cruz Km.156 Zona: Cuarenta Arroyos");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel victoria1.jpg", "hotel victoria2.jpg" });
        hotel.setTelefono(4136538);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("victoria-resort.com");
        hotel.setEmail("hvr@victoria-resort.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Diplomat Martinez");
        hotel.setGpsX(-17.38656608861003f);
        hotel.setGpsY(-66.15711316466331f);
        hotel.setDireccion("Av. Ballivián nro. 0611 Edificio: Hotel Diplomat Zona: El Prado");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel diplomat martinez sociedad ltda5.jpg", "hotel diplomat martinez sociedad ltda1.jpg", "hotel diplomat martinez sociedad ltda2.jpg", "hotel diplomat martinez sociedad ltda3.jpg", "hotel diplomat martinez sociedad ltda4.jpg", "hotel diplomat martinez sociedad ltda6.jpg"});
        hotel.setTelefono(4250687);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.hdiplomat.com");
        hotel.setEmail("reserva@hdiplomat.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel El Super 8");
        hotel.setGpsX(-17.396774367803353f);
        hotel.setGpsY(-66.16029158234596f);
        hotel.setDireccion("C. Hamiraya nro. 475 Zona: Central");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel el super 81.jpg", "hotel el super 8.jpg", "hotel el super 82.jpg" });
        hotel.setTelefono(4581978);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Felipez");
        hotel.setGpsX(-17.391411460837585f);
        hotel.setGpsY(-66.15682817995548f);
        hotel.setDireccion("C. España nro. 172 entre Av. Heroínas y C. Colombia");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel felipez3.jpg",  "hotel felipez.jpg", "hotel felipez2.jpg", "hotel felipez7.jpg"});
        hotel.setTelefono(4510773);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("felipezhotel.com-hotel.com");
        hotel.setEmail("walter.bustillos@gmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Hacienda de Kaluyo");
        hotel.setGpsX(-17.51900921719227f);
        hotel.setGpsY(-66.1144258081913f);
        hotel.setDireccion("Kaluyo-Angostura Zona: Angostura");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel hacienda de kaluyo1.jpg", "hotel hacienda de kaluyo2.jpg", "hotel hacienda de kaluyo3.jpg", "hotel hacienda de kaluyo4.jpg", "hotel hacienda de kaluyo5.jpg" });
        hotel.setTelefono(4576593);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("com-hotel.com");
        hotel.setEmail("kaluyogranhotel@gmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Regina Resort & Convenciones");
        hotel.setGpsX(-17.335991104024966f);
        hotel.setGpsY(-66.2307558953762f);
        hotel.setDireccion("Av. Yamparticuy Zona: Tiquipaya");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel regina resort y convenciones1.jpg", "hotel regina resort y convenciones2.jpg", "hotel regina resort y convenciones3.jpg", "hotel regina resort y convenciones4.jpg" });
        hotel.setTelefono(4316555);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("reservas@hotelreginabolivia.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Integración");
        hotel.setGpsX(-17.040280491660837f);
        hotel.setGpsY(-64.86629068851471f);
        hotel.setDireccion("Av. De La Integración Zona: Loc. Ivirgarzama");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel integracion1.jpg", "hotel integracion2.jpg", "hotel integracion3.jpg", "hotel integracion4.jpg" });
        hotel.setTelefono(4773024);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("granhotelintegracion.com");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel León Avila");
        hotel.setGpsX(-17.392178696994918f);
        hotel.setGpsY(-66.16008270531893f);
        hotel.setDireccion("C. Junín nro. 156 Edificio: Hotel León Zona: Central");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel león avila1.jpg", "hotel león avila.jpg", "hotel león avila0.jpg", "hotel león avila2.jpg" });
        hotel.setTelefono(4589380);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("leondoryani@gmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Luxor Cochabamba");
        hotel.setGpsX(-17.384497231716722f);
        hotel.setGpsY(-66.15667060017586f);
        hotel.setDireccion("C. La Paz nro. 439 Edificio: Hotel Luxor Zona: Noreste");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel luxor cochabamba1.jpg", "hotel luxor cochabamba2.jpg" });
        hotel.setTelefono(4524048);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("luxoraparthotel@hotmail.es");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Manhattan");
        hotel.setGpsX(-17.397726505709343f);
        hotel.setGpsY(-66.15672424435616f);
        hotel.setDireccion("C. Ladislao Cabrera nro.601 y Nataniel Aguirre Edificio: Hotel Manhattan");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel manhattan1.jpg", "hotel manhattan2.jpg"});
        hotel.setTelefono(4252488);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.hotelmanhattanbolivia.com");
        hotel.setEmail("reservashotelmanhattan@gmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Reina Nieves ");
        hotel.setGpsX(-17.39729650855925f);
        hotel.setGpsY(-66.15672156214714f);
        hotel.setDireccion("C. Nataniel Aguirre nro. 718 Edificio: Hotel Reina Nieves Zona: Central");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel reina nieves1.jpg" });
        hotel.setTelefono(4256269);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.reinanieveshotel.com");
        hotel.setEmail("reinanieveshotel@hotmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Siles Ideal");
        hotel.setGpsX(-17.38998704222446f);
        hotel.setGpsY(-66.15723520517349f);
        hotel.setDireccion("C. España entre Ecuador y Mayor Rocha nro. 329");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel siles ideal1.jpg", "hotel siles ideal2.jpg", "hotel siles ideal3.jpg", "hotel siles ideal4.jpg"});
        hotel.setTelefono(4235175);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.hotelideal.com.bo");
        hotel.setEmail("hotelidealcbba@gmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Unión");
        hotel.setGpsX(-17.392690612574373f);
        hotel.setGpsY(-66.15769520401955f);
        hotel.setDireccion("C. Baptista S-011 esq. Av. Heroínas");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel unión1.jpg", "hotel unión2.jpg", "hotel unión3.jpg" });
        hotel.setTelefono(4503728);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("hotelunion-bolivia.com");
        hotel.setEmail("hotel_union@gmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Jaguar House Hostel");
        hotel.setGpsX(-17.384792235629604f);
        hotel.setGpsY(-66.1596661247313f);
        hotel.setDireccion("C. Baptista nro. 746 Zona: Prado");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "jaguar house hostel0.jpg", "jaguar house hostel1.jpg", "jaguar house hostel2.jpg" });
        hotel.setTelefono(4523799);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.jaguarhousehostel.com/");
        hotel.setEmail("jaguarhousehostel@gmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("La Fontaine Oruro Hotel");
        hotel.setGpsX(-17.39209039141259f);
        hotel.setGpsY(-66.16137385368347f);
        hotel.setDireccion("C. Hamiraya nro. 181 Zona: Central Oeste");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "la fontaine oruro hotel1.jpg", "la fontaine oruro hotel2.jpg"});
        hotel.setTelefono(4252838);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.fontainehotel.com");
        hotel.setEmail("hotelfontaine@hotmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("La Tua Casa ");
        hotel.setGpsX(-17.37052399640577f);
        hotel.setGpsY(-66.15014880895615f);
        hotel.setDireccion("Calle David Alvestegui Nro. 769 entre Avenida Pando y Avenida Melchor Urquidi ");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "la tua casa 0.jpg", "la tua casa 1.jpg", "la tua casa 2.jpg", "la tua casa 3.jpg", "la tua casa 4.jpg" });
        hotel.setTelefono(4032006);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("latuacasahotelboutique.com");
        hotel.setEmail("reservalatuacasa@gmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Las Vegas");
        hotel.setGpsX(-17.39487775575027f);
        hotel.setGpsY(-66.15625217556953f);
        hotel.setDireccion("C. Esteban Arce nro. 601");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel las vegas1.jpg", "hotel las vegas2.jpg"});
        hotel.setTelefono(4229976);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("hotellasvegas@hotmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Ñaupa House Hostel");
        hotel.setGpsX(-17.413950160621734f);
        hotel.setGpsY(-66.16529675200582f);
        hotel.setDireccion("C. España nro.  250 Edificio: Ñaupa House Piso: 1 Zona: Central");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "ñaupa house hostel1.jpg", "ñaupa house hostel2.jpg"});
        hotel.setTelefono(4250862);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("naupahouse.com");
        hotel.setEmail("ivonne.ortega.fuentes@gmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Anteus Apart Hotel");
        hotel.setGpsX(-17.375887515468104f);
        hotel.setGpsY(-66.15400180220604f);
        hotel.setDireccion("Av. Potosi nro. 1365 Zona: Recoleta");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "anteus apart hotel1.jpg", "anteus apart hotel2.jpg", "anteus apart hotel3.jpg" });
        hotel.setTelefono(4245067);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.hotelanteus.com");
        hotel.setEmail("agerencia@anteus.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Toloma Hotel");
        hotel.setGpsX(-17.38402240880186f);
        hotel.setGpsY(-66.15124851465225f);
        hotel.setDireccion("Av. Oquendo nro. 690 Edificio: Hotel Toloma Piso: 1 Oficina: 1 Zona: Muyurina");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "toloma hotel0.jpg", "toloma hotel1.jpg", "toloma hotel1_1.jpg", "toloma hotel2.jpg", "toloma hotel2_1.jpg", "toloma hotel3.jpg", "toloma hotel4.jpg", "toloma hotel4_1.jpg", "toloma hotel5.jpg" });
        hotel.setTelefono(4533600);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.tolomahotel.com");
        hotel.setEmail("contabilidad_toloma_granhotel@hotmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Los Tucanes");
        hotel.setGpsX(-16.972882115958097f);
        hotel.setGpsY(-65.39628982543945f);
        hotel.setDireccion("Carretera A Santa Cruz Km 163 Zona: Agrigento");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "los tucanes.jpg" });
        hotel.setTelefono(4136506);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("contacto@lostucaneshotel.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Torero II");
        hotel.setGpsX(-17.04423484297137f);
        hotel.setGpsY(-64.8638927936554f);
        hotel.setDireccion("Av. Integración Edificio: Hotel Torero II Zona: Díaz ");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel torero ii1.jpg", "hotel torero ii2.jpg", "hotel torero ii3.jpg", "hotel torero ii4.jpg"});
        hotel.setTelefono(4773629);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("hoteltorero@gmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Gran Hotel Cochabamba ");
        hotel.setGpsX(-17.378048621747695f);
        hotel.setGpsY(-66.15223087370396f);
        hotel.setDireccion("Plaza Ubaldo Anze E-415, La Recoleta, Cochabamba, Bolivia");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "gran hotel cochabamba s.a1.jpg", "gran hotel cochabamba 2.jpg", "gran hotel cochabamba 3.jpg", "gran hotel cochabamba s.a2.jpg", "gran hotel cochabamba s.a6.jpg", "gran hotel cochabamba.jpg"});
        hotel.setTelefono(4489420);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.granhotelcochabamba.com.bo");
        hotel.setEmail("info@granhotelcochabamba.com.bo");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal Oruro");
        hotel.setGpsX(-17.400454916442342f);
        hotel.setGpsY(-66.156966984272f);
        hotel.setDireccion("C. Agustín López");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hostal oruro1.jpg" });
        hotel.setTelefono(0);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado");
        hotel.setEmail("No se tiene registrado");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Banana Tropic");
        hotel.setGpsX(-16.998434127224467f);
        hotel.setGpsY(-65.43705940246582f);
        hotel.setDireccion("Carretera Cbba - Snt. Cruz");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "banana tropic1.jpg", "banana tropic2.jpg", "banana tropic3.jpg" });
        hotel.setTelefono(4700956);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb(": No se tiene registrado.");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal Florida");
        hotel.setGpsX(-17.396974010033116f);
        hotel.setGpsY(-66.15461938083172f);
        hotel.setDireccion("C. 25 de Mayo 583");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hostal florida1.jpg", "hostal florida2.jpg"});
        hotel.setTelefono(4257911);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("florida_hostal@hotmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Maria de Los Angeles");
        hotel.setGpsX(-17.394788811584785f);
        hotel.setGpsY(-66.15614622831345f);
        hotel.setDireccion("Esteban Arce casi Pasaje Aldunate");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel maria de los angeles1.jpg" });
        hotel.setTelefono(0);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado");
        hotel.setEmail("No se tiene registrado");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Gard Gina’s");
        hotel.setGpsX(-17.38797197646617f);
        hotel.setGpsY(-66.15695759654045f);
        hotel.setDireccion("México 346 entre España y 25 de Mayo ");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel gard gina’s0.jpg", "hotel gard gina’s1.jpg", "hotel gard gina’s2.jpg", "hotel gard gina’s3.jpg", "hotel gard gina’s4.jpg"});
        hotel.setTelefono(4222925);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.hotelginas.com");
        hotel.setEmail("hotelginas@hotmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Moraine");
        hotel.setGpsX(-17.38982002745576f);
        hotel.setGpsY(-66.15933269262314f);
        hotel.setDireccion("Av. Ayacucho nro. 356 entre Ecuador y Mayor Rocha");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel moraine2_1.jpg", "hotel moraine1.jpg", "hotel moraine1_1.jpg", "hotel moraine2.jpg",  "hotel moraine3.jpg"});
        hotel.setTelefono(4230750);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("hotelmorainecochabamba.com");
        hotel.setEmail("hotelmoraine@gmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hostal Casa Vieja");
        hotel.setGpsX(-17.39234634950496f);
        hotel.setGpsY(-66.15992411971092f);
        hotel.setDireccion("Junín 134 entre Av. Heroínas y C. Colombia");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hostal casa vieja3.jpg", "hostal casa vieja.jpg", "hostal casa vieja2.jpg" });
        hotel.setTelefono(4583791);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("hostal.colonial@hotmail.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Tamesis Hotel");
        hotel.setGpsX(-17.38715288972503f);
        hotel.setGpsY(-66.153409704566f);
        hotel.setDireccion("Paccieri y Antezana");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "tamesis hotel1.jpg", "tamesis hotel2.jpg"});
        hotel.setTelefono(4527605);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Davinci");
        hotel.setGpsX(-17.400508025346717f);
        hotel.setGpsY(-66.15402661263943f);
        hotel.setDireccion("C. 25 de Mayo y Montes");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel davinci1.jpg"});
        hotel.setTelefono(0);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("La colonia");
        hotel.setGpsX(-17.36161538239869f);
        hotel.setGpsY(-66.16156563162804f);
        hotel.setDireccion("C. Atahuallpa y Mostajo");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "la colonia.jpg", "la colonia1.jpg", "la colonia2.jpg", "la colonia3.jpg" });
        hotel.setTelefono(4450300);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("lacoloniahotel.com.bo");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Oblitas");
        hotel.setGpsX(-17.380394004345483f);
        hotel.setGpsY(-66.15910470485687f);
        hotel.setDireccion("Av. Oblitas nro. 220");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel oblitas1.jpg", "hotel oblitas2.jpg"});
        hotel.setTelefono(4543704);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("oblitashotel.com");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel Candiré");
        hotel.setGpsX(-17.022337405456373f);
        hotel.setGpsY(-65.47824203968048f);
        hotel.setDireccion("Sobre la carretera Cbba - Sta Cruz; Km. 151; pasando 500m la tranca de Padre Sama ( 10km. antes de Villa Tunari)");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel candire.jpg"});
        hotel.setTelefono(70382348);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Hotel de La Torre");
        hotel.setGpsX(-17.386328679990655f);
        hotel.setGpsY(-66.15070939064026f);
        hotel.setDireccion("Federico Blanco casi Oquendo");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "hotel de la torre1.jpg", "hotel de la torre2.jpg" });
        hotel.setTelefono(0);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("delatorreapart.com-hotel.com");
        hotel.setEmail("No se tiene registrado");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Casa Campestre");
        hotel.setGpsX(-17.380707573002113f);
        hotel.setGpsY(-66.25139951705933f);
        hotel.setDireccion("Av. Elías Meneces");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "casa campestre2.jpg", "casa campestre0.jpg", "casa campestre1.jpg", "casa campestre3.jpg", "casa campestre4.jpg" });
        hotel.setTelefono(4350312);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("lacasacampestre.com");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Olga’s Hotel");
        hotel.setGpsX(-17.39122397061177f);
        hotel.setGpsY(-66.15637555718422f);
        hotel.setDireccion("C. Colombia nro. 467 entre San Martin y 25 de Mayo");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "olgas hotel1.jpg", "olgas hotel2.jpg", "olgas hotel3.jpg"});
        hotel.setTelefono(4522476);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.olgashotel.net");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Puka Killa ");
        hotel.setGpsX(-17.356854024208364f);
        hotel.setGpsY(-66.15082522854209f);
        hotel.setDireccion("Circunvalación 2 entre final Pando y Luis Calvo");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "puka killa00.jpg", "puka killa0.jpg", "puka killa1.jpg", "puka killa2.jpg", "puka killa3.jpg", "puka killa4.jpg" });
        hotel.setTelefono(4227434);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("www.pukakillasrl.com");
        hotel.setEmail("info@pukakillasrl.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);


        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Arasan Hotel");
        hotel.setGpsX(-17.403615829184734f);
        hotel.setGpsY(-66.15700721740723f);
        hotel.setDireccion("Av. Ayacucho 7241");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "arasan hotel.jpg"});
        hotel.setTelefono(4552001);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("arasancbba@gmail.com");
        hotel.setEmail("www.arasanhotel.com");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);

        hotel = new ModeloHotel();
        hotel.setIdSQLite(idHotel++);
        hotel.setNombre("Virginias  Hotel");
        hotel.setGpsX(-17.392631102461856f);
        hotel.setGpsY(-66.15381941199303f);
        hotel.setDireccion("C. Bolívar 440 entre Lanza y Av. San Martín");
        hotel.setImagenesFirebaseArreglo(new String[]{
                "virginias  hotel.jpg"});
        hotel.setTelefono(4510468);
        hotel.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        hotel.setPaginaWeb("No se tiene registrado.");
        hotel.setEmail("No se tiene registrado.");
        hotel.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaHoteles.add(hotel);
    }

    private void setListaRestaurantes() {
        int idRestaurante = 1;

        ModeloRestaurante restaurante;

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Bunker Grill");
        restaurante.setGpsX(-17.376839762065707f);
        restaurante.setGpsY(-66.16944931447506f);
        restaurante.setDireccion("Av. Juan De La Rosa nro. 842 Zona: Sarco");
        restaurante.setImagenesFirebaseArreglo(new String[]{"bunker grill s.r.l.2.jpg", "bunker grill s.r.l.jpg", "bunker grill s.r.l_1.jpg", "bunker grill s.r.l3.jpg" });
        restaurante.setTelefono(0);
        restaurante.setHorario("No se tiene registrado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Carbonell");
        restaurante.setGpsX(-17.389166044786787f);
        restaurante.setGpsY(-66.1704383790493f);
        restaurante.setDireccion("Av. Perú nro. 580 Zona: Villa Galindo");
        restaurante.setImagenesFirebaseArreglo(new String[]{"carbonell1.jpg"});
        restaurante.setTelefono(4418199);
        restaurante.setHorario("Lunes a Sábado 18:30-22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Carne y Fuego");
        restaurante.setGpsX(-17.376764248067403f);
        restaurante.setGpsY(-66.17607034742832f);
        restaurante.setDireccion("Av. Melchor Pérez nro. 1555 Zona: Sarco");
        restaurante.setImagenesFirebaseArreglo(new String[]{"carne y fuego.jpg", "carne y fuego2.png", "carne y fuego3.png" });
        restaurante.setTelefono(4243800);
        restaurante.setHorario("Martes a Viernes 18:00-23:00 Sábado 18:00-23:00 Domingo 11:00-15:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Carniclub");
        restaurante.setGpsX(-17.37802494378927f);
        restaurante.setGpsY(-66.15633934736252f);
        restaurante.setDireccion("C. Aniceto Padilla nro. 339 Zona: Norte");
        restaurante.setImagenesFirebaseArreglo(new String[]{"carniclub1.jpg", "carniclub2.jpg" });
        restaurante.setTelefono(4036494);
        restaurante.setHorario("Lunes a Sábado: 17:00-22:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("ChickenS Kingdom");
        restaurante.setGpsX(-17.391429377982195f);
        restaurante.setGpsY(-66.15454092621803f);
        restaurante.setDireccion("Av. San Martin nro. 150 Zona: Central");
        restaurante.setImagenesFirebaseArreglo(new String[]{"chicken s kingdom s.r.l.1.jpg", "chicken s kingdom s.r.l.2.jpg" });
        restaurante.setTelefono(4660328);
        restaurante.setHorario("Lunes a Domingo 10:00-23:45");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Restaurante Pochos");
        restaurante.setGpsX(-17.408995653764446f);
        restaurante.setGpsY(-66.15610867738724f);
        restaurante.setDireccion("Alfonso Arze nro. 2091 Zona: Jaihuayco");
        restaurante.setImagenesFirebaseArreglo(new String[]{"restaurante pochos3.jpg", "restaurante pochos1.jpg", "restaurante pochos2.jpg"});
        restaurante.setTelefono(60348277);
        restaurante.setHorario("No se tiene registrado.");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Paprika");
        restaurante.setGpsX(-17.38526897630569f);
        restaurante.setGpsY(-66.15441352128983f);
        restaurante.setDireccion("C. Chuquisaca nro. 688 Zona: Noreste");
        restaurante.setImagenesFirebaseArreglo(new String[]{"paprika 1.jpg", "paprika 2.jpg", "paprika 3.jpg" });
        restaurante.setTelefono(4662400);
        restaurante.setHorario("Lunes a Sábado 11:30 - 01:30 Domingo 11:30-0");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("“El Bosque De Las Hadas”");
        restaurante.setGpsX(-17.38755219496939f);
        restaurante.setGpsY(-66.16038411855698f);
        restaurante.setDireccion("José de La Reza 143");
        restaurante.setImagenesFirebaseArreglo(new String[]{"bosque de las hadas.jpg", "el bosque de las hadas 1.jpg", "el bosque de las hadas 2.jpg" });
        restaurante.setTelefono(4522806);
        restaurante.setHorario("Lunes a Sábado 18:00- 23:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Jardín Colonial");
        restaurante.setGpsX(-17.38605607564349f);
        restaurante.setGpsY(-66.15666791796684f);
        restaurante.setDireccion("Av. Ballivián nro. 0622 Zona: Central");
        restaurante.setImagenesFirebaseArreglo(new String[]{"jardin colonial.jpg", "jardin colonial2.jpg" });
        restaurante.setTelefono(4221056);
        restaurante.setHorario("No se tiene registrado.");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("La Chingada");
        restaurante.setGpsX(-17.376025745120195f);
        restaurante.setGpsY(-66.16588532924652f);
        restaurante.setDireccion("C. José Quintín Mendoza nro. 1489 Zona: Cala Cala");
        restaurante.setImagenesFirebaseArreglo(new String[]{"la chingada.jpg", "la chingada1.jpg", "la chingada2.jpg" });
        restaurante.setTelefono(4501156);
        restaurante.setHorario("Lunes a Sábado de 18:00 – 23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Acertijos");
        restaurante.setGpsX(-17.381373104697445f);
        restaurante.setGpsY(-66.17012858390808f);
        restaurante.setDireccion("Casto Rojas nro. 1649 Zona: Glorieta");
        restaurante.setImagenesFirebaseArreglo(new String[]{"acertijos.jpg"});
        restaurante.setTelefono(4400352);
        restaurante.setHorario("No se tiene registrado.");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Apthapi World Street Food");
        restaurante.setGpsX(-17.371657381677554f);
        restaurante.setGpsY(-66.16151869297028f);
        restaurante.setDireccion("C. Juan Capriles nro. 170 Zona: Cala Cala");
        restaurante.setImagenesFirebaseArreglo(new String[]{"apthapi world street food.jpg"});
        restaurante.setTelefono(67426557);
        restaurante.setHorario("Lunes a Viernes: 12:00 – 1400  17:00 – 22:30 Sabado 18:00 – 21:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Muela Del Diablo ");
        restaurante.setGpsX(-17.375481785238488f);
        restaurante.setGpsY(-66.15381572395563f);
        restaurante.setDireccion("Av. Potosí nro. 1392 Zona: Queru Queru");
        restaurante.setImagenesFirebaseArreglo(new String[]{"muela del diablo.jpg", "muela del diablo2.jpg" });
        restaurante.setTelefono(4799686);
        restaurante.setHorario("Lunes a Jueves: 09:30 – 11:30 Viernes 09:30 – 02:00 Sábado 17:30 - 0200 ");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Restaurant Rincón del Valle");
        restaurante.setGpsX(-17.371467951312823f);
        restaurante.setGpsY(-66.18206441402435f);
        restaurante.setDireccion("Av. América oeste Nro. 1509 lado Fiorentina");
        restaurante.setImagenesFirebaseArreglo(new String[]{"restaurant rincón del valle1.jpg", "restaurant rincón del valle2.jpg", "restaurant rincón del valle3.jpg", "restaurant rincón del valle4.jpg", "restaurant rincón del valle5.jpg", "restaurant rincón del valle6.jpg" });
        restaurante.setTelefono(4280339);
        restaurante.setHorario("Lunes a Viernes 12:00 - 15:00  Sábado y Domingo  12:00 - 19:00  ");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Bar Restaurant “Mediterráneo”");
        restaurante.setGpsX(-17.374059162520194f);
        restaurante.setGpsY(-66.16060271859169f);
        restaurante.setDireccion("Calle Tarija Nro. 1508 esquina Calle Guadalquivir");
        restaurante.setImagenesFirebaseArreglo(new String[]{"bar restaurant mediterráneo1.jpg", "bar restaurant mediterráneo2.jpg"  });
        restaurante.setTelefono(4036421);
        restaurante.setHorario("Lunes a Sábado 17:00 - 23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Con Yapa");
        restaurante.setGpsX(-17.37377630054552f);
        restaurante.setGpsY(-66.14937096834183f);
        restaurante.setDireccion("Av. Melchor Urquidi nro. 1430 Zona: Queru Queru");
        restaurante.setImagenesFirebaseArreglo(new String[]{"con yapa1.jpg", "con yapa2.jpg", "con yapa2_1.jpg" });
        restaurante.setTelefono(4548627);
        restaurante.setHorario("Lunes a Domingo de 10:00- 22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("árbol de Papel");
        restaurante.setGpsX(-17.368616872666028f);
        restaurante.setGpsY(-66.16504311561584f);
        restaurante.setDireccion("C.  Man Cesped entre Calle Enrique Arce y Calle Simeón ");
        restaurante.setImagenesFirebaseArreglo(new String[]{"arbol de papel.jpg","arbol de papel1.jpg"});
        restaurante.setTelefono(4461061);
        restaurante.setHorario("Martes a Sábado 09:30-20:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("La Cantonata");
        restaurante.setGpsX(-17.388920320753154f);
        restaurante.setGpsY(-66.15746855735779f);
        restaurante.setDireccion("C. España nro. 409 Zona: Central");
        restaurante.setImagenesFirebaseArreglo(new String[]{"la cantonata0.jpg", "la cantonata1.jpg" });
        restaurante.setTelefono(4259222);
        restaurante.setHorario("Lunes a Sábado de 12:00-22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Barbacoa");
        restaurante.setGpsX(-17.377898234662428f);
        restaurante.setGpsY(-66.15159317851067f);
        restaurante.setDireccion("Av. Pando nro. 1164 Zona: Recoleta");
        restaurante.setImagenesFirebaseArreglo(new String[]{"barbacoa1.jpg"});
        restaurante.setTelefono(4522525);
        restaurante.setHorario("Lunes a Sábado 12:00 – 15:00 Domingo 12:00 – 15:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Baretto Café Express");
        restaurante.setGpsX(-17.377260208080074f);
        restaurante.setGpsY(-66.15328699350357f);
        restaurante.setDireccion("C. Beni nro. 577 Zona: Queru Queru");
        restaurante.setImagenesFirebaseArreglo(new String[]{"baretto café express.jpg"});
        restaurante.setTelefono(4485211);
        restaurante.setHorario("No se tiene registrado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Big Joy");
        restaurante.setGpsX(-17.377356840132606f);
        restaurante.setGpsY(-66.1537778377533f);
        restaurante.setDireccion("C. Beni Edificio: Toscana Piso: Pb Oficina: 2 Zona: Recoleta");
        restaurante.setImagenesFirebaseArreglo(new String[]{"big joy.jpg", "big joy2.jpg", "big joy3.jpg" });
        restaurante.setTelefono(4798545);
        restaurante.setHorario("Martes a Domingo: 17:30- 23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Brasas & Carbón");
        restaurante.setGpsX(-17.378770478037364f);
        restaurante.setGpsY(-66.16587392985821f);
        restaurante.setDireccion("Av. Juan de La Rosa nro. 560 Zona: Estadium");
        restaurante.setImagenesFirebaseArreglo(new String[]{"brasas & carbón.jpg", "brasas & carbón1.jpg", "brasas & carbón2.jpg" });
        restaurante.setTelefono(4545459);
        restaurante.setHorario("No se tiene registrado.");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Bricks Pizzeria");
        restaurante.setGpsX(-17.372841317018036f);
        restaurante.setGpsY(-66.16031974554062f);
        restaurante.setDireccion("Av. América nro. 222 Zona: Norte");
        restaurante.setImagenesFirebaseArreglo(new String[]{"bricks pizzeria s.r.l.jpg"});
        restaurante.setTelefono(4799911);
        restaurante.setHorario("Lunes a Domingo  10:00 - 23:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Café Lea Mas");
        restaurante.setGpsX(-17.39463459893635f);
        restaurante.setGpsY(-66.15894712507725f);
        restaurante.setDireccion("Santibáñez nro. 134 Zona: Centro");
        restaurante.setImagenesFirebaseArreglo(new String[]{"café lea mas.jpg","café lea mas1.jpg" });
        restaurante.setTelefono(71748747);
        restaurante.setHorario("Lunes a Sábado 9:00 - 21:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Café Parlawi & Lab");
        restaurante.setGpsX(-17.39069285391186f);
        restaurante.setGpsY(-66.17052286863327f);
        restaurante.setDireccion("Av. Perú nro. 460 Zona: Hipodromo");
        restaurante.setImagenesFirebaseArreglo(new String[]{"café parlawi & lab1.jpg"});
        restaurante.setTelefono(77491649);
        restaurante.setHorario("Lunes a  Sábado 9:00- 19:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Café Fragmentos");
        restaurante.setGpsX(-17.3899172927802f);
        restaurante.setGpsY(-66.15680873394012f);
        restaurante.setDireccion("C. Chuquisaca nro. 501 Zona: Central Noreste");
        restaurante.setImagenesFirebaseArreglo(new String[]{"café fragmentos1.jpg", "café fragmentos.jpg" });
        restaurante.setTelefono(0);
        restaurante.setHorario("No se tiene registrado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Caffeina Caffeina");
        restaurante.setGpsX(-17.369925622470742f);
        restaurante.setGpsY(-66.16224825382233f);
        restaurante.setDireccion("Huallparrimachi y Tupac Katary");
        restaurante.setImagenesFirebaseArreglo(new String[]{"caffeina caffeina1.jpg"});
        restaurante.setTelefono(4231006);
        restaurante.setHorario("Lunes a Sábado 10:00-2:00 Domingo 10:00-16:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Capicúa");
        restaurante.setGpsX(-17.371261881571947f);
        restaurante.setGpsY(-66.17804244160652f);
        restaurante.setDireccion("Av. América Esquina Intiraymi Zona: Sarco");
        restaurante.setImagenesFirebaseArreglo(new String[]{"capicúa.jpg", "capicúa_1.jpg", "capicúa1.jpg" });
        restaurante.setTelefono(4446042);
        restaurante.setHorario("No se tiene registrado.");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Chicken Brass");
        restaurante.setGpsX(-17.384203187213203f);
        restaurante.setGpsY(-66.16834877058864f);
        restaurante.setDireccion("Pasaje Zoológico nro. 1471 y Av. Tadeo Haenke, Hipodromo");
        restaurante.setImagenesFirebaseArreglo(new String[]{"chicken brass1.jpg"});
        restaurante.setTelefono(4444852);
        restaurante.setHorario("Lunes a Jueves 18:00-22:00 Viernes y Sabado 12:0-15:00, 18:00-22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Churrasquería \"Bagu\"");
        restaurante.setGpsX(-17.37246437843471f);
        restaurante.setGpsY(-66.15387909114361f);
        restaurante.setDireccion("Calle Potosí entre Av. América y Juan Capriles");
        restaurante.setImagenesFirebaseArreglo(new String[]{"churrasquería bagu0.jpg", "churrasquería bagu1.jpg", "churrasquería bagu2.jpg", "churrasquería bagu3.jpg", "churrasquería bagu4.jpg"  });
        restaurante.setTelefono(4290795);
        restaurante.setHorario("Martes a Sábado 12:00-15:00, 19:00-23:00 , Domingo 12:00-15:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Churrasquería Bruno");
        restaurante.setGpsX(-17.38049447436129f);
        restaurante.setGpsY(-66.16928234696388f);
        restaurante.setDireccion("Parque Demetrio Canelas esq. Av. C. Medinacelli");
        restaurante.setImagenesFirebaseArreglo(new String[]{"churrasquería bruno1.jpg", "churrasquería bruno2.jpg"  });
        restaurante.setTelefono(72266897);
        restaurante.setHorario("Lunes a Sabado 11:00-15:00, 18:00-23:00, Domingo 11:30-15:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Churrasquería Tunari Boulevar");
        restaurante.setGpsX(-17.378525379988663f);
        restaurante.setGpsY(-66.15108624100685f);
        restaurante.setDireccion("Psje. Boulevard De La Recoleta Y/O Av. Uyuni, Aniceto Padilla 680");
        restaurante.setImagenesFirebaseArreglo(new String[]{"churrasquería tunari boulevar.jpg"});
        restaurante.setTelefono(4488153);
        restaurante.setHorario("Martes a Jueves 18:20-23:00 Viernes y Sábado 12:00- 15:00 Domingo 12:00-15:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Cratos");
        restaurante.setGpsX(-17.38677470078144f);
        restaurante.setGpsY(-66.15878149867058f);
        restaurante.setDireccion("C.Baptista nro. 604 Edificio: Alborada Piso: Pb Oficina: 2 Zona: Nor-Oeste");
        restaurante.setImagenesFirebaseArreglo(new String[]{"cratos1.jpg", "cratos2.jpg", "cratos3.jpg" });
        restaurante.setTelefono(4287772);
        restaurante.setHorario("Lunes a Sábado 09:00-20:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Da Vinci Pizzeria Bar");
        restaurante.setGpsX(-17.38414783384251f);
        restaurante.setGpsY(-66.15525841712952f);
        restaurante.setDireccion("C. Antezana nro. 763 Zona: Central");
        restaurante.setImagenesFirebaseArreglo(new String[]{"da vinci pizzeria bar1.jpg", "da vinci pizzeria bar2.jpg" });
        restaurante.setTelefono(4660857);
        restaurante.setHorario("Lunes a Sábado 18:30-00:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("De K'ffe, Cafe, Lounge");
        restaurante.setGpsX(-17.377476510219704f);
        restaurante.setGpsY(-66.15127919241786f);
        restaurante.setDireccion("Av. Pando nro. 1143 Edificio: Condominio Recoleta Piso: Pb Oficina: 1 Zona: Recoleta");
        restaurante.setImagenesFirebaseArreglo(new String[]{ "De K'ffe, Cafe, Lounge1.jpg", "De K'ffe, Cafe, Lounge2.jpg", "De K'ffe, Cafe, Lounge3.jpg", "De K'ffe, Cafe, Lounge4.jpg", "De K'ffe, Cafe, Lounge5.jpg"});
        restaurante.setTelefono(4402050);
        restaurante.setHorario("Lunes a Domingo 09:00-02:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Dimas' Restaurant");
        restaurante.setGpsX(-17.389283147530463f);
        restaurante.setGpsY(-66.0877700150013f);
        restaurante.setDireccion("Carretera Sacaba 6.5 al Sud Pasaje Sin Salida Zona: Este");
        restaurante.setImagenesFirebaseArreglo(new String[]{"dimas' restaurant1.jpg", "dimas' restaurant2.jpg"});
        restaurante.setTelefono(4721154);
        restaurante.setHorario("Lunes 12:00-14:00 Martes a Domingo 12:00-22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Dogs Burgers & More");
        restaurante.setGpsX(-17.377808642297584f);
        restaurante.setGpsY(-66.14958085119724f);
        restaurante.setDireccion("Melchor Urquidi nro. 1166 Zona: Queru Queru");
        restaurante.setImagenesFirebaseArreglo(new String[]{"dogs burgers & more0.jpg", "dogs burgers & more1.jpg", "dogs burgers & more2.jpg" });
        restaurante.setTelefono(4414176);
        restaurante.setHorario("Martes a Domingo 15:30-23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Chicharronería Doña Pola");
        restaurante.setGpsX(-17.37240230188733f);
        restaurante.setGpsY(-66.15931257605553f);
        restaurante.setDireccion("Av. América nro. 275 Zona: Queru Queru");
        restaurante.setImagenesFirebaseArreglo(new String[]{"chicharronería doña pola1.jpg", "chicharronería doña pola2.jpg" });
        restaurante.setTelefono(4248332);
        restaurante.setHorario("No se tiene registrado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Doner Kebab");
        restaurante.setGpsX(-17.378969499971284f);
        restaurante.setGpsY(-66.16606906056404f);
        restaurante.setDireccion("Av. Juan de la Rosa esq. Calle Julio Mendez, próximo a la clínica los Angeles");
        restaurante.setImagenesFirebaseArreglo(new String[]{"döner kebab1.jpg"});
        restaurante.setTelefono(67420179);
        restaurante.setHorario("Lunes a Viernes 08:00-12:30, 18:00-22:00 Sábado y Domingo 18:00-22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Dori Pollo");
        restaurante.setGpsX(-17.421780419580454f);
        restaurante.setGpsY(-66.1584247648716f);
        restaurante.setDireccion("Av. Suecia nro. 1259 Zona: Sud");
        restaurante.setImagenesFirebaseArreglo(new String[]{"dori pollo.jpg"});
        restaurante.setTelefono(4748613);
        restaurante.setHorario("Lunes a Domingo de 10:00 – 23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Dortmund Bierhaus");
        restaurante.setGpsX(-17.380996823613167f);
        restaurante.setGpsY(-66.15136384963989f);
        restaurante.setDireccion("Av. Ramón Rivero nro. 736 Zona: Noreste");
        restaurante.setImagenesFirebaseArreglo(new String[]{"dortmund bierhaus2.jpg", "dortmund bierhaus.jpg", "dortmund bierhaus3.jpg" });
        restaurante.setTelefono(72725089);
        restaurante.setHorario("Lunes a Domingo 19:00-22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("El Bagual");
        restaurante.setGpsX(-17.373292490363422f);
        restaurante.setGpsY(-66.1525634676218f);
        restaurante.setDireccion("Av. América Este Zona: Queru Queru");
        restaurante.setImagenesFirebaseArreglo(new String[]{"el bagual.jpg"});
        restaurante.setTelefono(0);
        restaurante.setHorario("Lunes a Sábado 07:00-23:00 Sábado y Domingo 11:00-23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("El Buen Gusto Tiquipayeño");
        restaurante.setGpsX(-17.337414022181616f);
        restaurante.setGpsY(-66.22109055519104f);
        restaurante.setDireccion("Av. Reducto nro.  354 Zona: Tiquipaya");
        restaurante.setImagenesFirebaseArreglo(new String[]{"el buen gusto tiquipayeño.jpg"});
        restaurante.setTelefono(4316673);
        restaurante.setHorario("Lunes a Domingo de 08:00-20:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Gaudil Restaurant Buffet");
        restaurante.setGpsX(-17.374652403296814f);
        restaurante.setGpsY(-66.15763954818249f);
        restaurante.setDireccion("C.Trinidad nro. 1456 Zona: Norte");
        restaurante.setImagenesFirebaseArreglo(new String[]{"gaudil restaurant buffet.jpg", "gaudil restaurant buffet2.jpg" });
        restaurante.setTelefono(4424041);
        restaurante.setHorario("No se tiene registrado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Mesón del Cantor");
        restaurante.setGpsX(-17.365475194997373f);
        restaurante.setGpsY(-66.18834681808949f);
        restaurante.setDireccion("C. Adolfo Ballivián nro. 139 Zona: Sarcobamba");
        restaurante.setImagenesFirebaseArreglo(new String[]{"mesón del cantor00.jpg", "mesón del cantor.jpg", "mesón del cantor0.jpg", "mesón del cantor1.jpg", "mesón del cantor2.jpg", "mesón del cantor3.jpg" });
        restaurante.setTelefono(4422554);
        restaurante.setHorario("Jueves a Sábado 18:00-00:00 Domingo 12:00-00:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("El Palacio del Silpancho");
        restaurante.setGpsX(-17.38885888969319f);
        restaurante.setGpsY(-66.15851528942585f);
        restaurante.setDireccion("C. Baptista nro. 434 Zona: Central");
        restaurante.setImagenesFirebaseArreglo(new String[]{"el palacio del silpancho1.jpg", "el palacio del silpancho2.jpg" });
        restaurante.setTelefono(4222732);
        restaurante.setHorario("No se tiene registrado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);



        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("El Tablón Family’s Food");
        restaurante.setGpsX(-17.38341320023889f);
        restaurante.setGpsY(-66.15251585841179f);
        restaurante.setDireccion("Salamanca nro. 916 Zona: Central");
        restaurante.setImagenesFirebaseArreglo(new String[]{"el tablón family’s food1.jpg", "el tablón family’s food2.jpg", "el tablón family’s food3.jpg", "el tablón family’s food4.jpg" });
        restaurante.setTelefono(0);
        restaurante.setHorario("Lunes a Domingo de 06:30 - 22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Frica’s Burger");
        restaurante.setGpsX(-17.388624683587803f);
        restaurante.setGpsY(-66.170699223876f);
        restaurante.setDireccion("Av. Perú nro. 651 Zona: Villa Ingavi");
        restaurante.setImagenesFirebaseArreglo(new String[]{"frica’s burger.jpg"});
        restaurante.setTelefono(4244035);
        restaurante.setHorario("No se tiene registrado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Giros Pub");
        restaurante.setGpsX(-17.389089256061734f);
        restaurante.setGpsY(-66.15735188126564f);
        restaurante.setDireccion("C. España nro. 286 Zona: Central");
        restaurante.setImagenesFirebaseArreglo(new String[]{"giros pub.jpg", "giros pub_1.jpg" });
        restaurante.setTelefono(70753557);
        restaurante.setHorario("No se tiene registrado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);


        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Greddy Gorillas");
        restaurante.setGpsX(-17.378008305222057f);
        restaurante.setGpsY(-66.1569495499134f);
        restaurante.setDireccion("Av. Santa Cruz Esq. Aniceto Padilla nro. 1210 Zona: Queru Queru");
        restaurante.setImagenesFirebaseArreglo(new String[]{"greddy gorillas.jpg"});
        restaurante.setTelefono(78326960);
        restaurante.setHorario("No se tiene registrado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Guti's");
        restaurante.setGpsX(-17.388042366561884f);
        restaurante.setGpsY(-66.17444157600403f);
        restaurante.setDireccion("Av D'Orbigni, Cochabamba");
        restaurante.setImagenesFirebaseArreglo(new String[]{"guti's.jpg"});
        restaurante.setTelefono(4283148);
        restaurante.setHorario("Martes a Sábado  19:30 - 23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Heladería Colonial España");
        restaurante.setGpsX(-17.379473773227488f);
        restaurante.setGpsY(-66.16647809743881f);
        restaurante.setDireccion("C. Diomedes de Pereira nro. 588 Zona: Cala Cala");
        restaurante.setImagenesFirebaseArreglo(new String[]{"heladería colonial españa1.jpg", "heladería colonial españa2.jpg" });
        restaurante.setTelefono(4417028);
        restaurante.setHorario("No se tiene registrado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Heladería Globos");
        restaurante.setGpsX(-17.387476685390638f);
        restaurante.setGpsY(-66.15560844540596f);
        restaurante.setDireccion("Av. José Ballivián (El Prado)");
        restaurante.setImagenesFirebaseArreglo(new String[]{"heladería globos s.r.l.jpg", "heladería globos s.r.l0.jpg", "heladería globos s.r.l2.jpg", "heladería globos s.r.l3.jpg" });
        restaurante.setTelefono(4520606);
        restaurante.setHorario("Lunes a Domingo 10:00- 00:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Heladería Gracia");
        restaurante.setGpsX(-17.39223756735946f);
        restaurante.setGpsY(-66.15616500377655f);
        restaurante.setDireccion("Av. Heroínas nro. 354, Pje Fidelia Sanchez Zona: Central");
        restaurante.setImagenesFirebaseArreglo(new String[]{"heladería gracia s.r.l..jpg"});
        restaurante.setTelefono(4501300);
        restaurante.setHorario("No se tiene registrado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Helados Brunello");
        restaurante.setGpsX(-17.396910022162697f);
        restaurante.setGpsY(-66.15239046514034f);
        restaurante.setDireccion("Ladislao Cabrera #612 Ciudad Cochabamba, Cochabamba, Bolivia");
        restaurante.setImagenesFirebaseArreglo(new String[]{"helados brunello s.r.l.0.jpg", "helados brunello s.r.l.1.jpg", "helados brunello s.r.l.2.jpg", "helados brunello s.r.l.3.jpg" });
        restaurante.setTelefono( 4140187);
        restaurante.setHorario("Lunes a Domingo de 11:00-19:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Hunan");
        restaurante.setGpsX(-17.37545874690195f);
        restaurante.setGpsY(-66.15092061460018f);
        restaurante.setDireccion("Plaza de comidas Huper Mall 4to piso. Pando y Portales/ zona Recoleta Cochabamba, Bolivia.");
        restaurante.setImagenesFirebaseArreglo(new String[]{"hunan1.png"});
        restaurante.setTelefono(4548737);
        restaurante.setHorario("Lunes a Domingo 12:00-22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Kansas Grill & Bar");
        restaurante.setGpsX(-17.37586127742051f);
        restaurante.setGpsY(-66.15790776908398f);
        restaurante.setDireccion("Calle Trinidad entre C. Pedro Blanco y C. Portales ");
        restaurante.setImagenesFirebaseArreglo(new String[]{"kansas grill & bar.jpg", "kansas grill & bar0.jpg", "kansas grill & bar1.jpg", "kansas grill & bar2.jpg", "kansas grill & bar3.jpg" });
        restaurante.setTelefono(4122727);
        restaurante.setHorario("Lunes a Sábado de 12:00-23:59 ");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Karbonju");
        restaurante.setGpsX(-17.372133516594012f);
        restaurante.setGpsY(-66.16958476603031f);
        restaurante.setDireccion("Av. America no 663 entre Eduardo Caba y Daniel Albornoz");
        restaurante.setImagenesFirebaseArreglo(new String[]{"karbonju.jpg", "karbonju_1.jpg", "karbonju0.jpg", "karbonju1.jpg", "karbonju2.jpg", "karbonju2_1.jpg", "karbonju3.jpg" });
        restaurante.setTelefono(4413634);
        restaurante.setHorario("Martes y Miércoles 12:00-15:00 Jueves, Viernes y Sábado de 19:00-23:00 Domingo12:00-16:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Koi Sushi Bar");
        restaurante.setGpsX(-17.373953569300213f);
        restaurante.setGpsY(-66.16113513708115f);
        restaurante.setDireccion("Pasaje Tarija  nro. 7 , Cala Cala");
        restaurante.setImagenesFirebaseArreglo(new String[]{"koi sushi bar4.jpg", "koi sushi bar.jpg", "koi sushi bar2.jpg", "koi sushi bar3.jpg"});
        restaurante.setTelefono(4247314);
        restaurante.setHorario("Lunes 18:00-23:30 Martes a Domingo de 12:00-23:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("La Bohemia Chuquisaqueña");
        restaurante.setGpsX(-17.395102995457886f);
        restaurante.setGpsY(-66.16040289402008f);
        restaurante.setDireccion("C. Santibáñez casi C. Hamiraya nro. 921 Zona: Sud Oeste");
        restaurante.setImagenesFirebaseArreglo(new String[]{"la bohemia chuquisaqueña2.jpg", "la bohemia chuquisaqueña1.jpg" });
        restaurante.setTelefono(4585181);
        restaurante.setHorario("Lunes a Domingo 9:00 – 14:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("La Cantera Café Resto Bar");
        restaurante.setGpsX(-17.368793506437342f);
        restaurante.setGpsY(-66.16364501416683f);
        restaurante.setDireccion("Av. Libertador Esq.Juan Huallparimachi");
        restaurante.setImagenesFirebaseArreglo(new String[]{"la cantera café resto bar.jpg", "la cantera café resto bar2.jpg", "la cantera café resto bar3.jpg", "la cantera café resto bar4.jpg" });
        restaurante.setTelefono(4546527 );
        restaurante.setHorario("Lunes a Domingo a partir de las 18:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Casona de la Pascualita");
        restaurante.setGpsX(-17.3779622291819f);
        restaurante.setGpsY(-66.15846768021584f);
        restaurante.setDireccion("Av. Aniceto Padilla nro. 237  entre Av. Santa Cruz y Av. Villarroel ");
        restaurante.setImagenesFirebaseArreglo(new String[]{"casona de la pascualita.jpg", "casona de la pascualita2.jpg", "casona de la pascualita3.jpg" });
        restaurante.setTelefono(4485999 );
        restaurante.setHorario("Lunes a Domingo 11:45-15:00 excepto Sábado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("La Sangucheria");
        restaurante.setGpsX(-17.374242190623917f);
        restaurante.setGpsY(-66.1590014398098f);
        restaurante.setDireccion("Av. Gualberto Villarroel y Psj Guadalquivir");
        restaurante.setImagenesFirebaseArreglo(new String[]{"la sangucheria.jpg", "la sangucheria0.jpg", "la sangucheria2.jpg" });
        restaurante.setTelefono(4419704);
        restaurante.setHorario("Martes a Domingo 9:30-22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Lago del Edén");
        restaurante.setGpsX(-17.527094244373355f);
        restaurante.setGpsY(-66.08554914593697f);
        restaurante.setDireccion("Carretera Antigua a Santa Cruz Km 16  Zona: Angostura");
        restaurante.setImagenesFirebaseArreglo(new String[]{"lago del edén.jpg"});
        restaurante.setTelefono(0);
        restaurante.setHorario("Lunes a Domingo 11:45-18:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Las Moras");
        restaurante.setGpsX(-17.376117898163606f);
        restaurante.setGpsY(-66.14992886781693f);
        restaurante.setDireccion("Melchor Urquidi nro. nro. 1249 Zona: Norte");
        restaurante.setImagenesFirebaseArreglo(new String[]{"las moras.jpg", "las moras1.jpg", "las moras2.jpg", "las moras3.jpg", "las moras4.jpg" });
        restaurante.setTelefono(4439043);
        restaurante.setHorario("Lunes a Viernes  18:30 – 23:30 Sábado y Domingo 11:00 – 15:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Lutetia");
        restaurante.setGpsX(-17.37214759583345f);
        restaurante.setGpsY(-66.1464124917984f);
        restaurante.setDireccion("Av. Eudoro Galindo nro.1760 entre Av. America y Fidel Anze");
        restaurante.setImagenesFirebaseArreglo(new String[]{"lutetia.jpg", "lutetia1.jpg", "lutetia2.jpg", "lutetia3.jpg", "lutetia4.jpg" });
        restaurante.setTelefono(4501020);
        restaurante.setHorario("Lunes a Sábado 9:00-12:00  15:00-20:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Mad Mex");
        restaurante.setGpsX(-17.386315881673582f);
        restaurante.setGpsY(-66.155886054039f);
        restaurante.setDireccion("Calle Valdivieso #581 Entre Salamanca y ChuquisacaCalle Valdivieso #581 Entre Salamanca y Chuquisaca");
        restaurante.setImagenesFirebaseArreglo(new String[]{"mad mex0.jpg", "mad mex1.jpg", "mad mex2.5.jpg", "mad mex2.jpg", "mad mex3.jpg", "mad mex4.jpg", "mad mex5.jpg", "mad mex6.jpg" });
        restaurante.setTelefono(4351493);
        restaurante.setHorario("Martes a Sábado 19:00 – 00:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Madonna Mia");
        restaurante.setGpsX(-17.389192920832944f);
        restaurante.setGpsY(-66.10998205840588f);
        restaurante.setDireccion("Av. Chapare No 4550, entre Maximiliano Kolbe y San Antonio de Padua");
        restaurante.setImagenesFirebaseArreglo(new String[]{"madonna mia01.jpg", "madonna mia02.jpg", "madonna mia03.jpg", "madonna mia04.jpg" });
        restaurante.setTelefono(4790000);
        restaurante.setHorario("Lunes a Domingo 18:00 – 22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Maesma Pizzeria");
        restaurante.setGpsX(-17.385810347433218f);
        restaurante.setGpsY(-66.15752220153809f);
        restaurante.setDireccion("Av. Ballivian");
        restaurante.setImagenesFirebaseArreglo(new String[]{"maesma pizzeria.jpg", "maesma pizzeria1.jpg", "maesma pizzeria2.jpg", "maesma pizzeria3.jpg", "maesma pizzeria4.jpg", "maesma pizzeria5.jpg" });
        restaurante.setTelefono(4527616);
        restaurante.setHorario("No se tiene registrado.");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Maesma Pizzeria(Circunvalación)");
        restaurante.setGpsX(-17.369325326655158f);
        restaurante.setGpsY(-66.1436752974987f);
        restaurante.setDireccion("Benjamin Guzman y Av. Circunvalación  Cochabamba");
        restaurante.setImagenesFirebaseArreglo(new String[]{"maesma pizzeria1.jpg", "maesma pizzeria2.jpg", "maesma pizzeria3.jpg"});
        restaurante.setTelefono(4225088);
        restaurante.setHorario("No se tiene registrado.");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Malditos Food");
        restaurante.setGpsX(-17.378969499971284f);
        restaurante.setGpsY(-66.16606839001179f);
        restaurante.setDireccion("Juan de la Rosa #559 esquina calle José Aguirre de Acha");
        restaurante.setImagenesFirebaseArreglo(new String[]{"malditos food1.jpg", "malditos food2.jpg" });
        restaurante.setTelefono(4436194);
        restaurante.setHorario("Lunes a Sábado 17:30-23:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Malditos Food (Beijing)");
        restaurante.setGpsX(-17.384933018240368f);
        restaurante.setGpsY(-66.18229508399963f);
        restaurante.setDireccion("Avenida Beijing esquina Topáter");
        restaurante.setImagenesFirebaseArreglo(new String[]{"malditos food2.jpg"});
        restaurante.setTelefono(4425267);
        restaurante.setHorario("Lunes a Sábado 17:30-23:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Marisqueria Mar Adentro");
        restaurante.setGpsX(-17.386560329374934f);
        restaurante.setGpsY(-66.15276010707021f);
        restaurante.setDireccion("Paccieri entre antezana y 16 de julio #741");
        restaurante.setImagenesFirebaseArreglo(new String[]{"marisqueria mar adentro.jpg"});
        restaurante.setTelefono(4355328);
        restaurante.setHorario("Lunes 09:30 – 14:00 Martes a Sábado 09:30 – 14:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Maria Bonita Mexican Food");
        restaurante.setGpsX(-17.37723333028156f);
        restaurante.setGpsY(-66.15356124937534f);
        restaurante.setDireccion("Beni nro. 0539 Edificio: Edif. Beni Piso: Pb Oficina: L2 Zona: Recoleta");
        restaurante.setImagenesFirebaseArreglo(new String[]{"maria bonita mexican food.jpg", "maria bonita mexican food_1.jpg" });
        restaurante.setTelefono(4453333);
        restaurante.setHorario("No se tiene registrado.");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Menta Restobar ");
        restaurante.setGpsX(-17.36871990905333f);
        restaurante.setGpsY(-66.1693212389946f);
        restaurante.setDireccion("C. Man Cesped nro. 464 Edificio: Eco 1 Piso: P.B. Zona: Cala Cala");
        restaurante.setImagenesFirebaseArreglo(new String[]{"menta restobar1.jpg", "menta restobar2.jpg", "menta restobar3.jpg" });
        restaurante.setTelefono(4309789);
        restaurante.setHorario("Lunes a Sábado 12:00-15:00 18:30-22:00 ");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Ms. Sushi Mr. Ramyun");
        restaurante.setGpsX(-17.372783720340752f);
        restaurante.setGpsY(-66.1544369906187f);
        restaurante.setDireccion("Av. America y Pantaleon Dalence Frente de la U. UPAL N° 592");
        restaurante.setImagenesFirebaseArreglo(new String[]{"ms. sushi mr. ramyun0.jpg", "ms. sushi mr. ramyun1.jpg" });
        restaurante.setTelefono(71611152);
        restaurante.setHorario("Lunes 11:30 - 22:30 Martes a Sábado 9:00 – 22:30 Domingo 16:30 – 22:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Muela Del Diablo ");
        restaurante.setGpsX(-17.375481785238488f);
        restaurante.setGpsY(-66.15381572395563f);
        restaurante.setDireccion("Av. Potosí nro. 1392 Zona: Queru Queru");
        restaurante.setImagenesFirebaseArreglo(new String[]{"muela del diablo.jpg", "muela del diablo2.jpg" });
        restaurante.setTelefono(76220409);
        restaurante.setHorario("No se tiene registrado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Restaurant Nauvoo");
        restaurante.setGpsX(-17.387339744210674f);
        restaurante.setGpsY(-66.15523159503937f);
        restaurante.setDireccion("C. Baldivieso nro. 509 Zona: Plaza Colon");
        restaurante.setImagenesFirebaseArreglo(new String[]{"retaurant nauvoo.jpg", "retaurant nauvoo1.jpg", "retaurant nauvoo2.jpg", "retaurant nauvoo3.jpg", "retaurant nauvoo15.jpg", "retaurant nauvoo16.jpg", "retaurant nauvoo17.jpg" });
        restaurante.setTelefono(4549383);
        restaurante.setHorario("Lunes a Sábado 07:00 – 22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("New York Chicken");
        restaurante.setGpsX(-17.36262402308524f);
        restaurante.setGpsY(-66.16858296096325f);
        restaurante.setDireccion("Av. Circunvalación esq. C. Luis Taborga nro. 2417 Zona: Temporal Pampa");
        restaurante.setImagenesFirebaseArreglo(new String[]{"new york chicken1.jpg", "new york chicken2.jpg", "new york chicken3.jpg" });
        restaurante.setTelefono(4471169);
        restaurante.setHorario("Martes a Domingo 18:00-22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Churrasquería \"El Cumpa\"");
        restaurante.setGpsX(-17.383673010021106f);
        restaurante.setGpsY(-66.18867471814156f);
        restaurante.setDireccion("C. Thunupa Zona: Villa Busch Norte");
        restaurante.setImagenesFirebaseArreglo(new String[]{"churrasquería el cumpa.jpg", "churrasquería el cumpa1.jpg" });
        restaurante.setTelefono(4254175);
        restaurante.setHorario("Viernes y Sábado  18:00-23:30 Domingo: 12:00-18:00 ");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Napoli's Pizzeria");
        restaurante.setGpsX(-17.39161302861343f);
        restaurante.setGpsY(-66.1523998528719f);
        restaurante.setDireccion("Av. Libertador Bolivar nro. 1324 Zona: Norte");
        restaurante.setImagenesFirebaseArreglo(new String[]{"napoli's pizzeria1.5.jpg", "napoli's pizzeria1.jpg", "napoli's pizzeria2.jpg" });
        restaurante.setTelefono(4454877);
        restaurante.setHorario("Lunes a Domingo 16:00-0:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Pizzería Cozzolisi");
        restaurante.setGpsX(-17.37723653001968f);
        restaurante.setGpsY(-66.15130953490734f);
        restaurante.setDireccion("Pando nro. 1177 Zona: Recoleta");
        restaurante.setImagenesFirebaseArreglo(new String[]{"pizzería cozzolisi.jpg"});
        restaurante.setTelefono(4485400);
        restaurante.setHorario("Lunes a Domingo 11:00-23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Pollos Willys \"El Sabor A La Brasa\"");
        restaurante.setGpsX(-17.369102615127318f);
        restaurante.setGpsY(-66.1758778989315f);
        restaurante.setDireccion("Av. Melchor Perez De Olquin nro. 678 Edificio: Romina Piso: 1 Zona: Norte");
        restaurante.setImagenesFirebaseArreglo(new String[]{"pollos willys el sabor a la brasa1.jpg", "pollos willys el sabor a la brasa2.jpg" });
        restaurante.setTelefono(4408412);
        restaurante.setHorario("Lunes a Domingo 12:00-20:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Quinta Chop Las Américas");
        restaurante.setGpsX(-17.361410581581247f);
        restaurante.setGpsY(-66.16682477295399f);
        restaurante.setDireccion("C. J. Baptista Esq. Hernando Siles nro.  572 Zona Temporal");
        restaurante.setImagenesFirebaseArreglo(new String[]{"quinta chop las américas3.jpg", "quinta chop las américas4.jpg", "quinta chop las américas5.jpg", "quinta chop las américas6.jpg" });
        restaurante.setTelefono(4241817);
        restaurante.setHorario("Martes y Miércoles: 12:00-20:00 Jueves 12:00-22:00 Viernes 12:00-2:45 Sábado :12:00-22:00 Domingo 11:00- 18:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Restaurant Casa De Campo");
        restaurante.setGpsX(-17.378677686386496f);
        restaurante.setGpsY(-66.15161195397377f);
        restaurante.setDireccion("Pasaje Boulevar nro. 618 Zona: Recoleta");
        restaurante.setImagenesFirebaseArreglo(new String[]{"restaurant casa de campo1.jpg"});
        restaurante.setTelefono(4392137);
        restaurante.setHorario("Lunes a Sábado de 12:00 – 23:30  Domingo 11:30-1430");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Restaurant Savarin");
        restaurante.setGpsX(-17.385924252738377f);
        restaurante.setGpsY(-66.15675508975983f);
        restaurante.setDireccion("Av. Ballivián nro. 626 Zona: Central");
        restaurante.setImagenesFirebaseArreglo(new String[]{"restaurant savarin2.jpg", "restaurant savarin3.jpg" });
        restaurante.setTelefono(4523880);
        restaurante.setHorario("No se tiene registrado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Seoul Food");
        restaurante.setGpsX(-17.368883103212763f);
        restaurante.setGpsY(-66.16417575627565f);
        restaurante.setDireccion("Man Césped y Adela Zamudio  Edificio: Edificio Patmos Piso: Pb Oficina: B Zona: Norte");
        restaurante.setImagenesFirebaseArreglo(new String[]{"seoul food00.jpg", "seoul food0.jpg", "seoul food2.jpg", "seoul food3.jpg", "seoul food4.jpg", "seoul food5.jpg", "seoul food6.jpg", "seoul food7.jpg", "seoul food8.jpg", "seoul food9.jpg", "seoul food10.jpg", "seoul food11.jpg", "seoul food12.jpg"});
        restaurante.setTelefono(4250480);
        restaurante.setHorario("Lunes a Sábado 11:00-15:00 18:00-22:00 ");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Seven To Seven ");
        restaurante.setGpsX(-17.37594191140847f);
        restaurante.setGpsY(-66.15395151078701f);
        restaurante.setDireccion("Av. Potosí nro. 1365 Edificio: Anteus Piso: Pb Zona: Queru Queru");
        restaurante.setImagenesFirebaseArreglo(new String[]{"7271.jpg", "7272.jpg", "7273.jpg", "7274.jpg", "7275.jpg", "7276.jpg", "7277.jpg", "72711.jpg" });
        restaurante.setTelefono(4036373);
        restaurante.setHorario("No se tiene registrado.");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Shofár");
        restaurante.setGpsX(-17.398636407059282f);
        restaurante.setGpsY(-66.154490634799f);
        restaurante.setDireccion("C. 25 De Mayo nro. 762 Zona: Sudeste");
        restaurante.setImagenesFirebaseArreglo(new String[]{"shofár1.jpg"});
        restaurante.setTelefono(4025082);
        restaurante.setHorario("Lunes a Domingo 10:00-22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Simple Foods");
        restaurante.setGpsX(-17.375021017956897f);
        restaurante.setGpsY(-66.15767776966095f);
        restaurante.setDireccion("C. Pantaleón Dalence nro. 1777 Zona: Queru Queru");
        restaurante.setImagenesFirebaseArreglo(new String[]{"simple foods1.jpg", "simple foods2.jpg", "simple foods3.jpg", "simple foods4.jpg", "simple foods5.jpg", "simple foods6.jpg", "simple foods7.jpg" });
        restaurante.setTelefono(72201478);
        restaurante.setHorario("Lunes a Viernes 11:00-20:00 Sábado  14:00-20:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Sole Mio");
        restaurante.setGpsX(-17.3734639999393f);
        restaurante.setGpsY(-66.15068189799786f);
        restaurante.setDireccion("Av. América nro. 826 Zona: Queru - Queru");
        restaurante.setImagenesFirebaseArreglo(new String[]{"sole mi18.jpg", "sole mio2.jpg", "sole mio3.jpg", "sole mio4.jpg", "sole mio5.jpg", "sole mio6.jpg", "sole mio7.jpg", "sole mio8.jpg", "sole mio9.jpg", "sole mio10.jpg", "sole mio11.jpg", "sole mio12.jpg", "sole mio13.jpg", "sole mio15.jpg", "sole mio16.jpg", "sole mio17.jpg", "sole mio18.jpg" });
        restaurante.setTelefono(4283379);
        restaurante.setHorario("Martes a Domingo 12:00-14:30 18:00-23:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Solo Pastas");
        restaurante.setGpsX(-17.369882104290127f);
        restaurante.setGpsY(-66.16224221885204f);
        restaurante.setDireccion("Juan Huallparimachi 1761");
        restaurante.setImagenesFirebaseArreglo(new String[]{"solo pastas6.jpg", "solo pastas7.jpg", "solo pastas8.jpg", "solo pastas9.jpg", "solo pastas10.jpg" });
        restaurante.setTelefono(4580088);
        restaurante.setHorario("Lunes a Sábado  11:00-23:00 Domingo 11:00-15:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Restaurante Suiza");
        restaurante.setGpsX(-17.38336200614964f);
        restaurante.setGpsY(-66.1586594581604f);
        restaurante.setDireccion("Av. Ballivián nro. 820 Zona: Central");
        restaurante.setImagenesFirebaseArreglo(new String[]{"restaurante suiza6.jpg", "restaurante suiza1.jpg", "restaurante suiza2.jpg", "restaurante suiza3.jpg", "restaurante suiza4.jpg", "restaurante suiza5.jpg"});
        restaurante.setTelefono(4257102);
        restaurante.setHorario("Lunes a Sábado 11:00-14:30 y 18:30-23:00 Domingo: 11:00-14:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Stuffz Burgers");
        restaurante.setGpsX(-17.384446037930708f);
        restaurante.setGpsY(-66.1528430879116f);
        restaurante.setDireccion("C. Pedro Borda nro. 629 Zona: Central");
        restaurante.setImagenesFirebaseArreglo(new String[]{"stuffz burgers1.jpg", "stuffz burgers2.jpg", "stuffz burgers3.jpg", "stuffz burgers4.jpg" });
        restaurante.setTelefono(4510673);
        restaurante.setHorario("Lunes a domingo 11:00-0:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Súper Caldos Originales");
        restaurante.setGpsX(-17.391042879187346f);
        restaurante.setGpsY(-66.2749245017767f);
        restaurante.setDireccion("Calle Calama entre Litoral y Mejillones,Quillacollo");
        restaurante.setImagenesFirebaseArreglo(new String[]{"súper caldos originales.jpg", "súper caldos originales2.jpg", "súper caldos originales3.jpg", "súper caldos originales25.jpg", "súper caldos originales26.jpg" });
        restaurante.setTelefono(4363455);
        restaurante.setHorario("Lunes a Domingo 08:00 – 13:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Sushito's");
        restaurante.setGpsX(-17.37821436737091f);
        restaurante.setGpsY(-66.15710712969303f);
        restaurante.setDireccion("Av. Santa Cruz esq. Aniceto Padilla, acera sur-oeste Zona: Recoleta");
        restaurante.setImagenesFirebaseArreglo(new String[]{"sushitos1.jpg", "sushitos2.jpg", "sushitos3.jpg", "sushitos4.jpg" });
        restaurante.setTelefono(4405087);
        restaurante.setHorario("Martes a Domingo 18:20 – 23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Churrasquería \"Tierra Andaluz\"");
        restaurante.setGpsX(-17.38631460184183f);
        restaurante.setGpsY(-66.16045385599136f);
        restaurante.setDireccion("C. La Paz nro. 687 casi esq. Av. Ayacucho ");
        restaurante.setImagenesFirebaseArreglo(new String[]{"tierra andaluz0.jpg", "tierra andaluz1.jpg", "tierra andaluz2.jpg", "tierra andaluz3.jpg" });
        restaurante.setTelefono(4394836);
        restaurante.setHorario("Miércoles a Domingo 18:30-22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Tonny's");
        restaurante.setGpsX(-17.371350197203572f);
        restaurante.setGpsY(-66.18251904845238f);
        restaurante.setDireccion("Av. América Oeste nro.  1519 Zona: Sarcobamba");
        restaurante.setImagenesFirebaseArreglo(new String[]{"tonny's2.jpg", "tonny's1.jpg", "tonny's3.jpg", "tonny's4.jpg"  });
        restaurante.setTelefono(0);
        restaurante.setHorario("Lunes a Domingo 18:30 – 22:30 ");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Tuesday");
        restaurante.setGpsX( -17.37337760521033f);
        restaurante.setGpsY(-66.15231737494469f);
        restaurante.setDireccion("Av. América Nº 752 entre Pando y Potosi");
        restaurante.setImagenesFirebaseArreglo(new String[]{"tuesday0.jpg", "tuesday1.jpg", "tuesday2.jpg", "tuesday3.jpg", "tuesday4.jpg", "tuesday5.jpg", "tuesday6.jpg", "tuesday7.jpg", "tuesday8.jpg" });
        restaurante.setTelefono(4487042);
        restaurante.setHorario("Lunes a Domingo 08:00-23:45");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Vainilla");
        restaurante.setGpsX(-17.385396960168354f);
        restaurante.setGpsY(-66.15401923656464f);
        restaurante.setDireccion("Salamanca y Antezana, Cochabamba");
        restaurante.setImagenesFirebaseArreglo(new String[]{"vainilla0.jpg", "vainilla1.jpg", "vainilla2.jpg", "vainilla3.jpg", "vainilla4.jpg", "vainilla5.jpg" });
        restaurante.setTelefono(4522104);
        restaurante.setHorario("Lunes a Sabado 08:00-22:30 Domingo 8:00-21:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Vinoppolis ");
        restaurante.setGpsX(-17.37841850945736f);
        restaurante.setGpsY(-66.15101382136345f);
        restaurante.setDireccion("Boulevard La Recoleta nro.  717 Zona: Recoleta");
        restaurante.setImagenesFirebaseArreglo(new String[]{"vinoppolis.jpg"});
        restaurante.setTelefono(4485120);
        restaurante.setHorario("Martes a Sábado 18:00-02:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("What’s Up ");
        restaurante.setGpsX(-17.372034961887636f);
        restaurante.setGpsY(-66.15562319755554f);
        restaurante.setDireccion("C. Juan Capriles nro. 616 Edificio: Santorini Piso: Pb Oficina: 1 Zona: Queru Queru");
        restaurante.setImagenesFirebaseArreglo(new String[]{"what’s up 1.jpg", "what’s up 2.jpg" });
        restaurante.setTelefono(4667777);
        restaurante.setHorario("Lunes a Domingo 11:00 - 23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Wonderfood");
        restaurante.setGpsX(-17.37345888025279f);
        restaurante.setGpsY(-66.14997379481792f);
        restaurante.setDireccion("Av. America y Melchor Urquidi nro. 860 Zona: Queru Queru");
        restaurante.setImagenesFirebaseArreglo(new String[]{"wonderfood1.jpg", "wonderfood2.jpg", "wonderfood3.jpg", "wonderfood4.jpg", "wonderfood5.jpg", "wonderfood6.jpg" });
        restaurante.setTelefono(4488493);
        restaurante.setHorario("No se tiene registrado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Donal Heladeria");
        restaurante.setGpsX(-17.39243081559684f);
        restaurante.setGpsY(-66.15608721971512f);
        restaurante.setDireccion("Av.Heroinas entre 25 de Mayo y España Pasaje Fidelia Sanchez, Av Heroínas");
        restaurante.setImagenesFirebaseArreglo(new String[]{"donal heladeria1.jpg", "donal heladeria2.jpg", "donal heladeria3.jpg", "donal heladeria4.jpg"});
        restaurante.setTelefono(4509477);
        restaurante.setHorario("Lunes a Domingo 07:30-23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Ecla Express");
        restaurante.setGpsX(-17.377233970229188f);
        restaurante.setGpsY(-66.15346871316433f);
        restaurante.setDireccion("Beni 553");
        restaurante.setImagenesFirebaseArreglo(new String[]{"ecla express1.jpg", "ecla express2.jpg", "ecla express3.jpg" });
        restaurante.setTelefono(70768969);
        restaurante.setHorario("No se tiene registrado.");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Shawarma King");
        restaurante.setGpsX(-17.37562385491644f);
        restaurante.setGpsY(-66.15089312195778f);
        restaurante.setDireccion("HUPER MALL.");
        restaurante.setImagenesFirebaseArreglo(new String[]{"shawarma king.jpg"});
        restaurante.setTelefono(4548737);
        restaurante.setHorario("Lunes a Sábado 12:00-23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Sillpancheria Celia");
        restaurante.setGpsX(-17.389512873460113f);
        restaurante.setGpsY(-66.15369200706482f);
        restaurante.setDireccion("Ecuador nro. 610 Esq. Lanza");
        restaurante.setImagenesFirebaseArreglo(new String[]{"sillpancheria celia.jpg"});
        restaurante.setTelefono(4229192);
        restaurante.setHorario("Lunes a Sábado 12:00-14:00 18:00-21:00 Domingo 18:00-0:000");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Restaurant Las Palmeras ");
        restaurante.setGpsX(-17.38994480861918f);
        restaurante.setGpsY(-66.15363501012325f);
        restaurante.setDireccion("Calle Lanza nro 248 entre Ecuador y Colombia");
        restaurante.setImagenesFirebaseArreglo(new String[]{"restaurant las palmeras1.jpg", "restaurant las palmeras2.jpg", "restaurant las palmeras3.jpg", "restaurant las palmeras4.jpg", "restaurant las palmeras5.jpg" });
        restaurante.setTelefono(4228559);
        restaurante.setHorario("Lunes a Domingo 12:00-1:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("La Tentazione");
        restaurante.setGpsX(-17.38592169306938f);
        restaurante.setGpsY(-66.15562872961164f);
        restaurante.setDireccion("Valdivieso entre Chuquisaca y Salamanca #563");
        restaurante.setImagenesFirebaseArreglo(new String[]{"la tentazione0.jpg", "la tentazione1.jpg", "la tentazione2.jpg", "la tentazione3.jpg" });
        restaurante.setTelefono(4522797);
        restaurante.setHorario("Lunes y Sábado 09:00-15:00, Martes a Viernes 09:00-18:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Cassis");
        restaurante.setGpsX(-17.37811901566005f);
        restaurante.setGpsY(-66.15684762597084f);
        restaurante.setDireccion("Edificio V&V Planta Baja, Aniceto Padilla esq. Av Santa Cruz");
        restaurante.setImagenesFirebaseArreglo(new String[]{"cassis0.jpg", "cassis1.jpg", "cassis2.jpg", "cassis3.jpg" });
        restaurante.setTelefono(4036120);
        restaurante.setHorario("Martes a Domingo 15:00-22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Charques \"Doña Julia\"");
        restaurante.setGpsX(-17.387262954719134f);
        restaurante.setGpsY(-66.16491369903088f);
        restaurante.setDireccion("Av. Rivereña");
        restaurante.setImagenesFirebaseArreglo(new String[]{"charques doña julia1.jpg"});
        restaurante.setTelefono(0);
        restaurante.setHorario("No se tiene registrado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);



        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Churrasquería “El Arriero”");
        restaurante.setGpsX(-17.373745582476722f);
        restaurante.setGpsY(-66.15794263780117f);
        restaurante.setDireccion("Buenos Aires");
        restaurante.setImagenesFirebaseArreglo(new String[]{"churrasquería “el arriero”1.jpg", "churrasquería “el arriero”2.jpg", "churrasquería “el arriero”3.jpg", "churrasquería “el arriero”4.jpg" });
        restaurante.setTelefono(78383965);
        restaurante.setHorario("No se tiene registrado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Sabor Chaqueño");
        restaurante.setGpsX(-17.347914343364845f);
        restaurante.setGpsY(-66.16689920425415f);
        restaurante.setDireccion("T'ikallajta 5024");
        restaurante.setImagenesFirebaseArreglo(new String[]{"sabor chaqueño1.jpg", "sabor chaqueño2.jpg"});
        restaurante.setTelefono(70396703);
        restaurante.setHorario("Viernes 19:00-23:00 Sábado y Domingo 12:00-16:00 ");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Dogs Burgers & More");
        restaurante.setGpsX(-17.377799683058683f);
        restaurante.setGpsY(-66.14966936409473f);
        restaurante.setDireccion("Av. Melchor Urquidi, Número 01166");
        restaurante.setImagenesFirebaseArreglo(new String[]{"dogs burgers & more0.jpg", "dogs burgers & more1.jpg", "dogs burgers & more2.jpg" });
        restaurante.setTelefono(4414176);
        restaurante.setHorario("Martes A Domingo 15:30-23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Cuadri Burger");
        restaurante.setGpsX(-17.37521300446513f);
        restaurante.setGpsY(-66.18058450520039f);
        restaurante.setDireccion("Av. Beiging y Av. Juan de la Rosa acera este");
        restaurante.setImagenesFirebaseArreglo(new String[]{"cuadri burger1.jpg"});
        restaurante.setTelefono(4417868);
        restaurante.setHorario("Lunes a Domingo 18:30-21:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Delicias Chuquisaqueñas");
        restaurante.setGpsX(-17.394707546014473f);
        restaurante.setGpsY(-66.16498544812202f);
        restaurante.setDireccion("Gral. Acha nro.721 y Suipacha");
        restaurante.setImagenesFirebaseArreglo(new String[]{"delicias chuquisaqueñas1.jpg", "delicias chuquisaqueñas2.jpg" });
        restaurante.setTelefono(4258130);
        restaurante.setHorario("Lunes a Domingo 09:00-14:00 Domingo 09:00-13:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Doggus");
        restaurante.setGpsX(-17.38672030806029f);
        restaurante.setGpsY(-66.1624963581562f);
        restaurante.setDireccion("Av. Pedro Domingo Murillo, frente al ex Zoológico");
        restaurante.setImagenesFirebaseArreglo(new String[]{"doggus1.jpg"});
        restaurante.setTelefono(75492400);
        restaurante.setHorario("Miércoles a Domingo 18:00 - 23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Don Coquito");
        restaurante.setGpsX(-17.37230950700923f);
        restaurante.setGpsY(-66.16317965090275f);
        restaurante.setDireccion("Av. América nro. 138");
        restaurante.setImagenesFirebaseArreglo(new String[]{"don coquito0.jpg", "don coquito1.jpg", "don coquito2.jpg" });
        restaurante.setTelefono(4409092);
        restaurante.setHorario("Lunes a Sábado 11:00-22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Döner Kebab");
        restaurante.setGpsX(-17.378951581606675f);
        restaurante.setGpsY(-66.16612337529659f);
        restaurante.setDireccion("Av. Juan de la Rosa esq. Calle Julio Mendez, próximo a la clínica los Angeles");
        restaurante.setImagenesFirebaseArreglo(new String[]{"döner kebab1.jpg"});
        restaurante.setTelefono(67420179);
        restaurante.setHorario("Lunes a Viernes 08:00-12:30 18:00-22:00 Sábado y Domingo 18:00-22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("El Atrio del Baul");
        restaurante.setGpsX(-17.379722069701113f);
        restaurante.setGpsY(-66.16868421435356f);
        restaurante.setDireccion("De Pereira Plaza R. Palmas");
        restaurante.setImagenesFirebaseArreglo(new String[]{"el atrio del baul.jpg"});
        restaurante.setTelefono(4403893);
        restaurante.setHorario("Lunes a Viernes 18:00 – 23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("El Rey de la Sabrosura");
        restaurante.setGpsX(-17.390760683359414f);
        restaurante.setGpsY(-66.14944607019424f);
        restaurante.setDireccion("Av. Heroinas entre Av. Oquendo y calle Pasteur");
        restaurante.setImagenesFirebaseArreglo(new String[]{"el rey de la sabrosura1.jpg"});
        restaurante.setTelefono(60746756);
        restaurante.setHorario("Lunes a Domingo 10:00 - 22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Bufalo's Rodizio");
        restaurante.setGpsX(-17.384558024319013f);
        restaurante.setGpsY(-66.1509608477354f);
        restaurante.setDireccion("Torres Soffer, Av. Oquendo");
        restaurante.setImagenesFirebaseArreglo(new String[]{"bufalo's rodizio.jpg"});
        restaurante.setTelefono(4251597);
        restaurante.setHorario("Lunes 19:00-22:30 Martes a Sábado 12:00-15:00 ,19:00-22:30 Domingo 12:00-1500");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Empanadas Paula");
        restaurante.setGpsX(-17.397169172899623f);
        restaurante.setGpsY(-66.15227982401848f);
        restaurante.setDireccion("Lanza entre Ladislao Cabrera y Uruguay");
        restaurante.setImagenesFirebaseArreglo(new String[]{"empanadas paula.jpg"});
        restaurante.setTelefono(4227056);
        restaurante.setHorario("Lunes a Domingo 09:00-19:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Fragola");
        restaurante.setGpsX(-17.372014482980944f);
        restaurante.setGpsY(-66.17268741130829f);
        restaurante.setDireccion("America Oeste 989, entre Gabriel Rene Moreno y Manchaypuito.");
        restaurante.setImagenesFirebaseArreglo(new String[]{"fragola.jpg"});
        restaurante.setTelefono(4121010);
        restaurante.setHorario("Lunes a Domingo  11:30 - 21:00 ");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Heladería Colonial España");
        restaurante.setGpsX( -17.379475693046857f);
        restaurante.setGpsY(-66.16647742688656f);
        restaurante.setDireccion("De Pereira Plaza y Batallón de Colorados");
        restaurante.setImagenesFirebaseArreglo(new String[]{"heladería colonial españa1.jpg", "heladería colonial españa2.jpg" });
        restaurante.setTelefono(0);
        restaurante.setHorario("Lunes a Domingo 14:00-18:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Hola Paella");
        restaurante.setGpsX(-17.38831368813202f);
        restaurante.setGpsY(-66.14290684461594f);
        restaurante.setDireccion("Max Paredes 220 final Colombia este zona san pedro");
        restaurante.setImagenesFirebaseArreglo(new String[]{"hola paella.jpg"});
        restaurante.setTelefono(4590044);
        restaurante.setHorario("Lunes a Domingo 11:45 - 15:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        /*restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("La Morada Café ");
        restaurante.setGpsX(-17.377134138371943f);
        restaurante.setGpsY(-66.15661963820457f);
        restaurante.setDireccion("Beni 330");
        restaurante.setImagenesFirebaseArreglo(new String[]{"la morada café 1.jpg","la morada café2.jpg","la morada café3.jpg","la morada café4.jpg"});
        restaurante.setTelefono(9742380);
        restaurante.setHorario("Lunes a Viernes 08:00 - 22:00 Sábado 09:00 - 22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);*/

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("La Vinagreta");
        restaurante.setGpsX(-17.37717765482922f);
        restaurante.setGpsY(-66.15415368229151f);
        restaurante.setDireccion("Calle Beni #0487 casi esquina Potosi, Acera Norte");
        restaurante.setImagenesFirebaseArreglo(new String[]{"la vinagreta.jpg"});
        restaurante.setTelefono(0);
        restaurante.setHorario("Lunes a Viernes 11:00-22:00 Sábado 11:00-14:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Las Leñas del Valle");
        restaurante.setGpsX(-17.38420798663761f);
        restaurante.setGpsY(-66.15299463272095f);
        restaurante.setDireccion("Av. Salamanca 818 esq. Pedro Borda");
        restaurante.setImagenesFirebaseArreglo(new String[]{"las leñas del valle.jpg"});
        restaurante.setTelefono(4500674);
        restaurante.setHorario("Lunes a Sábado 18:00-23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Let’s Rock");
        restaurante.setGpsX(-17.372642928386675f);
        restaurante.setGpsY(-66.14671424031258f);
        restaurante.setDireccion("Av America esquina Eudoro Galindo # 1719 (Una cuadra al norte del Banco BNB)");
        restaurante.setImagenesFirebaseArreglo(new String[]{"let’s rock 1.jpg"});
        restaurante.setTelefono(75499780);
        restaurante.setHorario("Jueves a Sábado 17:00 - 02:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Los Chicharrones Originales");
        restaurante.setGpsX( -17.389289546585317f);
        restaurante.setGpsY(-66.08183093369007f);
        restaurante.setDireccion("Av. Villazón km 7");
        restaurante.setImagenesFirebaseArreglo(new String[]{"los chicharrones originales1.jpg", "los chicharrones originales2.jpg", "los chicharrones originales3.jpg", "los chicharrones originales4.jpg" });
        restaurante.setTelefono(77632712);
        restaurante.setHorario("Sábado Domingo 08:00 - 22:00 Lunes 08:00 - 14:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Mac Soba ");
        restaurante.setGpsX(-17.34886417514498f);
        restaurante.setGpsY(-66.19583889842033f);
        restaurante.setDireccion("14 De Septiembre y Av. Ecológica 256");
        restaurante.setImagenesFirebaseArreglo(new String[]{"mac soba 2.jpg", "mac soba.jpg"  });
        restaurante.setTelefono(4792872);
        restaurante.setHorario("Lunes a Domingo 16:00-23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Mega Chicken");
        restaurante.setGpsX(-17.365002882716308f);
        restaurante.setGpsY(-66.1526070535183f);
        restaurante.setDireccion("Av. Circunvalación esq. Potosi. 1 cuadra al norte. 823");
        restaurante.setImagenesFirebaseArreglo(new String[]{"mega chicken0.jpg", "mega chicken1.jpg", "mega chicken2.jpg"  });
        restaurante.setTelefono(4233797);
        restaurante.setHorario("Martes a Domingo 17:00 - 22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Monopoly Fast Food");
        restaurante.setGpsX(-17.371210044116154f);
        restaurante.setGpsY(-66.18632577359676f);
        restaurante.setDireccion("Av. América");
        restaurante.setImagenesFirebaseArreglo(new String[]{"monopoly fast food.jpg"});
        restaurante.setTelefono(4420554);
        restaurante.setHorario("Lunes a Domingo 19:00 - 22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Mosita Camba");
        restaurante.setGpsX(-17.37042480086186f);
        restaurante.setGpsY(-66.16351827979088f);
        restaurante.setDireccion("Libertador Simon Bolivar nro 1775");
        restaurante.setImagenesFirebaseArreglo(new String[]{"mosita camba1.jpg", "mosita camba2.jpg" });
        restaurante.setTelefono(4410805);
        restaurante.setHorario("Lunes a Sábado 9:00 - 20:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Novecento");
        restaurante.setGpsX(-17.3849925308569f);
        restaurante.setGpsY(-66.15432769060135f);
        restaurante.setDireccion("Antezana Esquina Chuquisaca");
        restaurante.setImagenesFirebaseArreglo(new String[]{"novecento1.jpg", "novecento2.jpg", "novecento3.jpg" });
        restaurante.setTelefono(4663024);
        restaurante.setHorario("Lunes a Viernes 12:00 - 00:00 Sábado 18:00 - 00:00 Domingo 12:00 – 16:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Otoño Bistro Pub");
        restaurante.setGpsX(-17.371589545150545f);
        restaurante.setGpsY(-66.16859436035156f);
        restaurante.setDireccion("Av. Ricardo Jaimes Freyre");
        restaurante.setImagenesFirebaseArreglo(new String[]{"otoño bistro pub1.jpg", "otoño bistro pub2.jpg" });
        restaurante.setTelefono(4794480);
        restaurante.setHorario("Lunes a Sábado 20:00 - 04:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Paqui’s Restaurant");
        restaurante.setGpsX(-17.363021461830993f);
        restaurante.setGpsY(-66.15060210227966f);
        restaurante.setDireccion("Av. Pando");
        restaurante.setImagenesFirebaseArreglo(new String[]{"paqui’s restaurant0.jpg", "paqui’s restaurant1.jpg", "paqui’s restaurant2.jpg", "paqui’s restaurant3.jpg", "paqui’s restaurant4.jpg", "paqui’s restaurant5.jpg" });
        restaurante.setTelefono(4546701);
        restaurante.setHorario("Lunes a Sábado 12:00 - 15:00 Domingo 11:30-15:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Pastelería Elida");
        restaurante.setGpsX(-17.37928691071078f);
        restaurante.setGpsY(-66.16614751517773f);
        restaurante.setDireccion("Diómedes de Pereira #0568 entre Juan de la Rosa y Batallón Colorado");
        restaurante.setImagenesFirebaseArreglo(new String[]{"pastelería elida1.jpg","pastelería elida2.jpg"  });
        restaurante.setTelefono(4448592);
        restaurante.setHorario("Lunes a Sábado 08:00-20:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Peach’s  Delight");
        restaurante.setGpsX(-17.392435934752676f);
        restaurante.setGpsY(-66.14867426455021f);
        restaurante.setDireccion("Pasteur entre Bolívar y Sucre");
        restaurante.setImagenesFirebaseArreglo(new String[]{"peach’s  delight1.jpg"});
        restaurante.setTelefono(70364393);
        restaurante.setHorario("No se tiene registrado.");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        /*restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Peña Churrasquería \"Sachawasi\"");
        restaurante.setGpsX(-17.37139371503537f);
        restaurante.setGpsY(-66.17461927235126f);
        restaurante.setDireccion("Av. América");
        restaurante.setImagenesFirebaseArreglo(new String[]{"churrasquería sachawasi1.jpg" ,"churrasquería sachawasi2.jpg" ,"churrasquería sachawasi4.png" });
        restaurante.setTelefono(4666403);
        restaurante.setHorario("Lunes a Domingo 11:30 - 23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);*/

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("El Nuevo Amanecer Cochabambino");
        restaurante.setGpsX(-17.383042042767375f);
        restaurante.setGpsY(-66.16892494261265f);
        restaurante.setDireccion("Av. Martin de La Rocha y Av. Perú ");
        restaurante.setImagenesFirebaseArreglo(new String[]{"el nuevo amanecer cochabambino1.jpg", "el nuevo amanecer cochabambino2.jpg"  });
        restaurante.setTelefono(4405892);
        restaurante.setHorario("Lunes a Domingo 12:00 – 23:00 Domingo 12:00 – 15:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Pepperoni");
        restaurante.setGpsX(-17.374571768741006f);
        restaurante.setGpsY(-66.16683885455132f);
        restaurante.setDireccion("Lucas Mendoza 582 Esq. José Aguirre Achá");
        restaurante.setImagenesFirebaseArreglo(new String[]{"pepperoni0.jpg", "pepperoni1.jpg", "pepperoni2.jpg", "pepperoni3.jpg", "pepperoni4.jpg" });
        restaurante.setTelefono(4038122);
        restaurante.setHorario("Martes a Domingo 12:00-15:00 , 19:00-23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Pizzería \"Miguitas Tu y Yo \"  ");
        restaurante.setGpsX(-17.371315638918013f);
        restaurante.setGpsY(-66.18271619081497f);
        restaurante.setDireccion("Av. América nro. 1521, entre Juan de La Rosa y Av. Beijing");
        restaurante.setImagenesFirebaseArreglo(new String[]{"pizzeríamiguitas tu y yo 1.jpg", "pizzeríamiguitas tu y yo 2.jpg"  });
        restaurante.setTelefono(4421486);
        restaurante.setHorario("Lunes a Domingo 17:00-22:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Pizzería Villa Esperanza");
        restaurante.setGpsX(-17.367254994971187f);
        restaurante.setGpsY(-66.20789006352425f);
        restaurante.setDireccion("Av. Esperanza");
        restaurante.setImagenesFirebaseArreglo(new String[]{"pizzería villa esperanza1.jpg"});
        restaurante.setTelefono(4016901);
        restaurante.setHorario("Lunes a Domingo 17:30 - 23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Pollos a La Brasa Villa Chicken ");
        restaurante.setGpsX(-17.371439792728374f);
        restaurante.setGpsY(-66.17205172777176f);
        restaurante.setDireccion("Av. Gabriel René Moreno Casi Av. América");
        restaurante.setImagenesFirebaseArreglo(new String[]{"pollos a la brasa villa chicken 1.jpg", "pollos a la brasa villa chicken 2.jpg" });
        restaurante.setTelefono(4443598);
        restaurante.setHorario("Lunes a Domingo 11:30-22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Puerto Madero");
        restaurante.setGpsX(-17.37998764416485f);
        restaurante.setGpsY(-66.15942522883415f);
        restaurante.setDireccion("Av. Gualberto Villarroel");
        restaurante.setImagenesFirebaseArreglo(new String[]{"puerto madero1.jpg"});
        restaurante.setTelefono(4486700);
        restaurante.setHorario("Martes  a Domingo 12:00-15:00 18:00-22:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Punto de Encuentro Restaurant");
        restaurante.setGpsX(-17.3908221137808f);
        restaurante.setGpsY(-66.18502289056778f);
        restaurante.setDireccion("Cobija y Manuel Rodríguez");
        restaurante.setImagenesFirebaseArreglo(new String[]{"punto de encuentro restaurant1.jpg"});
        restaurante.setTelefono(4427903);
        restaurante.setHorario("Martes a Domingo 12:00 - 20:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Quinta El Palmar");
        restaurante.setGpsX(-17.368543275211046f);
        restaurante.setGpsY(-66.16884112358093f);
        restaurante.setDireccion("Man cesped Nro.459 entre tarcos y Algarrobos");
        restaurante.setImagenesFirebaseArreglo(new String[]{"quinta el palmar.jpg"});
        restaurante.setTelefono(4246224);
        restaurante.setHorario("Sábado y Domingo 12:00 – 18:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Quinta Soledad");
        restaurante.setGpsX(-17.3707076680129f);
        restaurante.setGpsY(-66.17274172604084f);
        restaurante.setDireccion("Manchay Puito Nro. 1963");
        restaurante.setImagenesFirebaseArreglo(new String[]{"quinta soledad0.jpg", "quinta soledad1.jpg", "quinta soledad2.jpg", "quinta soledad3.jpg" });
        restaurante.setTelefono(4413567);
        restaurante.setHorario("No se tiene registrado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Rancho Viejo");
        restaurante.setGpsX(-17.372408701532358f);
        restaurante.setGpsY(-66.16506457328796f);
        restaurante.setDireccion("Av. América Esquina Pasaje Irigoyen");
        restaurante.setImagenesFirebaseArreglo(new String[]{"rancho viejo3.jpg", "rancho viejo.jpg", "rancho viejo2.jpg"  });
        restaurante.setTelefono(4245888);
        restaurante.setHorario("Lunes a Viernes 11:30-15:00 , 18:00-22:00 Sábado y Domingo 11:30-23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Repostería Rossi");
        restaurante.setGpsX(-17.393695242734278f);
        restaurante.setGpsY(-66.15268617868423f);
        restaurante.setDireccion("Sucre entre Lanza y Antezana");
        restaurante.setImagenesFirebaseArreglo(new String[]{"repostería rossi.jpg"});
        restaurante.setTelefono(4220929);
        restaurante.setHorario("Lunes a Sábado 07:00 - 20:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Restaurant \"Na Cunna\"");
        restaurante.setGpsX(-17.38669919088183f);
        restaurante.setGpsY(-66.15481987595558f);
        restaurante.setDireccion("Av. Salamanca Nro. 577 casi Lanza");
        restaurante.setImagenesFirebaseArreglo(new String[]{ "Restaurant Na Cunna1.jpg", "Restaurant Na Cunna3.jpg", "Restaurant Na Cunna4.jpg"});
        restaurante.setTelefono(70369682 );
        restaurante.setHorario("Jueves a Sábado 17:00 - 01:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Alcaparras Restaurant & Bar");
        restaurante.setGpsX(-17.370193771032014f);
        restaurante.setGpsY(-66.15681745111942f);
        restaurante.setDireccion("Av. Santa Cruz esq. Ciclovía");
        restaurante.setImagenesFirebaseArreglo(new String[]{"alcaparras restaurant & bar1.jpg", "alcaparras restaurant & bar2.jpg", "alcaparras restaurant & bar3.jpg" });
        restaurante.setTelefono(4060919);
        restaurante.setHorario("Martes a Sábado 19:00 – 23:00 Domingo 12:00 – 16:00 ");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Círculo de Amigos");
        restaurante.setGpsX(-17.378582974859885f);
        restaurante.setGpsY(-66.17596507072449f);
        restaurante.setDireccion("Av. Melchor Pérez De Olguín");
        restaurante.setImagenesFirebaseArreglo(new String[]{"círculo de amigos1.jpg", "círculo de amigos2.jpg" });
        restaurante.setTelefono(0);
        restaurante.setHorario("Martes  a Domingo 18:00-22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Restaurant Cristal");
        restaurante.setGpsX(-17.392268282324746f);
        restaurante.setGpsY(-66.15609660744667f);
        restaurante.setDireccion("Av. Heroínas E-0352");
        restaurante.setImagenesFirebaseArreglo(new String[]{"restaurant cristal1.jpg", "restaurant cristal2.jpg", "restaurant cristal3.jpg", "restaurant cristal4.jpg" });
        restaurante.setTelefono(4258933);
        restaurante.setHorario("Lunes a Domingo 07:00-23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Restaurant Jacaranda");
        restaurante.setGpsX(-17.381557405354467f);
        restaurante.setGpsY(-66.17554128170013f);
        restaurante.setDireccion("Av. Tadeo Haenke Nro. 2150");
        restaurante.setImagenesFirebaseArreglo(new String[]{"restaurant jacaranda.jpg", "restaurant jacaranda2.jpg", "restaurant jacaranda3.jpg", "restaurant jacaranda4.jpg" });
        restaurante.setTelefono(4286424);
        restaurante.setHorario("Lunes a Domingo 11:00 – 20:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Restaurant Jusk’u Rumi ");
        restaurante.setGpsX(-17.521311223015367f);
        restaurante.setGpsY(-66.0873281210661f);
        restaurante.setDireccion("Zona La Angostura");
        restaurante.setImagenesFirebaseArreglo(new String[]{"restaurant jusk’u rumi1.jpg", "restaurant jusk’u rumi2.jpg"  });
        restaurante.setTelefono(70775969);
        restaurante.setHorario("Lunes a Domingo 09:00-18:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Restaurant La Gaviota");
        restaurante.setGpsX(-17.371566506324328f);
        restaurante.setGpsY(-66.17794454097748f);
        restaurante.setDireccion("Av. América Oeste , calle Azanaque Nro. 1000");
        restaurante.setImagenesFirebaseArreglo(new String[]{"restaurant la gaviota1.jpg", "restaurant la gaviota2.jpg", "restaurant la gaviota3.jpg" });
        restaurante.setTelefono(4424497);
        restaurante.setHorario("No se tiene registrado.");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("De La Tierra");
        restaurante.setGpsX(-17.377018307751403f);
        restaurante.setGpsY(-66.19058026000857f);
        restaurante.setDireccion("Chiriguanos y Apurimak Nro. 1586");
        restaurante.setImagenesFirebaseArreglo(new String[]{"de la tierra1.jpg", "de la tierra2.jpg" });
        restaurante.setTelefono(79973505);
        restaurante.setHorario("Jueves a Domingo 12:00 – 21:45");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Restaurant La Villa");
        restaurante.setGpsX(-17.371753376720008f);
        restaurante.setGpsY( -66.13968551158905f);
        restaurante.setDireccion("Av. Circunvalacion Nro. 1680 direccion a Pacata entre M.Mendez y J.Anaya");
        restaurante.setImagenesFirebaseArreglo(new String[]{"restaurant la villa0.jpg", "restaurant la villa1.jpg", "restaurant la villa2.jpg", "restaurant la villa3.jpg", "restaurant la villa4.jpg", "restaurant la villa5.jpg", "restaurant la villa6.jpg", "restaurant la villa7.jpg", "restaurant la villa8.jpg", "restaurant la villa9.jpg", "restaurant la villa10.jpg", "restaurant la villa11.jpg", "restaurant la villa12.jpg", "restaurant la villa13.jpg", "restaurant la villa14.jpg", "restaurant la villa15.jpg", "restaurant la villa16.jpg", "restaurant la villa17.jpg", "restaurant la villa18.jpg", "restaurant la villa19.jpg", "restaurant la villa20.jpg", "restaurant la villa21.jpg", "restaurant la villa22.jpg", "restaurant la villa23.jpg", "restaurant la villa24.jpg", "restaurant la villa25.jpg", "restaurant la villa26.jpg" });
            restaurante.setTelefono(4482205);
        restaurante.setHorario("Lunes a Sábado 11:30 - 14:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Restaurant Los Ángeles");
        restaurante.setGpsX(-17.39229771749497f);
        restaurante.setGpsY(-66.15032717585564f);
        restaurante.setDireccion("Bolívar Nro. 848 entre 16 de Julio y Oquendo ");
        restaurante.setImagenesFirebaseArreglo(new String[]{"restaurant los ángeles4.jpg", "restaurant los ángeles1.jpg", "restaurant los ángeles2.jpg", "restaurant los ángeles3.jpg"  });
        restaurante.setTelefono(4501319 );
        restaurante.setHorario("Lunes a Domingo 11:00-21:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Restaurant Magui ");
        restaurante.setGpsX(-17.394186677643397f);
        restaurante.setGpsY(-66.16987310349941f);
        restaurante.setDireccion("Av. Blanco Galindo Km. 1 nro. 1173");
        restaurante.setImagenesFirebaseArreglo(new String[]{"restaurant magui0.jpg", "restaurant magui1.jpg", "restaurant magui2.jpg", "restaurant magui3.jpg", "restaurant magui4.jpg" });
        restaurante.setTelefono(4245164);
        restaurante.setHorario("Lunes a Domingo 08:00-14:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Restaurant Moreira");
        restaurante.setGpsX(-17.38534832631108f);
        restaurante.setGpsY(-66.16975776851177f);
        restaurante.setDireccion("Av. Perú y excombatientes");
        restaurante.setImagenesFirebaseArreglo(new String[]{"restaurant moreira1.jpg", "restaurant moreira2.jpg", "restaurant moreira3.jpg" });
        restaurante.setTelefono(4297965);
        restaurante.setHorario("No se tiene registrado.");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Picaditos Grill");
        restaurante.setGpsX(-17.377716490105158f);
        restaurante.setGpsY(-66.15275658667088f);
        restaurante.setDireccion("Beni");
        restaurante.setImagenesFirebaseArreglo(new String[]{"picaditos grill1.jpg", "picaditos grill2.jpg", "picaditos grill3.jpg"});
        restaurante.setTelefono(72420369);
        restaurante.setHorario("No se tiene registrado.");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Restaurant todo al Horno");
        restaurante.setGpsX(-17.389250512347143f);
        restaurante.setGpsY(-66.17817521095276f);
        restaurante.setDireccion("La Plata y Nueva Castilla");
        restaurante.setImagenesFirebaseArreglo(new String[]{"restaurant todo al horno1.jpg"});
        restaurante.setTelefono(4409347);
        restaurante.setHorario("Sábado Domingo 11:00 - 1900");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Restaurante De Doña Ruth");
        restaurante.setGpsX(-17.385082119705487f);
        restaurante.setGpsY(-66.17057919502258f);
        restaurante.setDireccion("Av. Excombatientes entre Av. Perú y Diego de Almagro 1758");
        restaurante.setImagenesFirebaseArreglo(new String[]{"restaurante de doña ruth1.jpg", "restaurante de doña ruth2.jpg"  });
        restaurante.setTelefono(69467999);
        restaurante.setHorario("Lunes a Domingo 12:00 - 10:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Restaurante Náutico Las Isla");
        restaurante.setGpsX(-17.5334678871805f);
        restaurante.setGpsY(-66.0827288031578f);
        restaurante.setDireccion("Zona La Angostura");
        restaurante.setImagenesFirebaseArreglo(new String[]{"restaurante náutico las isla1.jpg", "restaurante náutico las isla2.jpg", "restaurante náutico las isla3.jpg", "restaurante náutico las isla4.jpg" });
        restaurante.setTelefono(4576911);
        restaurante.setHorario("No se tiene registrado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Planchitas Originales");
        restaurante.setGpsX(-17.418188593482085f);
        restaurante.setGpsY(-66.12714350223541f);
        restaurante.setDireccion("Cto. Bolivia");
        restaurante.setImagenesFirebaseArreglo(new String[]{"planchitas originales1.jpg", "planchitas originales2.jpg", "planchitas originales3.jpg" });
        restaurante.setTelefono(4752550);
        restaurante.setHorario("Miércoles a Domingo 10:00 - 22:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Rolling Wings");
        restaurante.setGpsX(-17.38518706658663f);
        restaurante.setGpsY(-66.18275105953217f);
        restaurante.setDireccion("C. Circunvalación nro. 043 entre C. Tovar y C. S. Mendoza");
        restaurante.setImagenesFirebaseArreglo(new String[]{"rolling wings1.jpg", "rolling wings2.jpg"});
        restaurante.setTelefono(4036814);
        restaurante.setHorario("Lunes a Sábado  18:00 - 23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Salón de Té El Pahuichi");
        restaurante.setGpsX(-17.394791371129717f);
        restaurante.setGpsY(-66.156290397048f);
        restaurante.setDireccion("Esteban Arze entre y Jordán, Sucre");
        restaurante.setImagenesFirebaseArreglo(new String[]{"salón de té el pahuichi.jpg"});
        restaurante.setTelefono(4254697);
        restaurante.setHorario("Lunes A Sábado 9:00-21:00 Domingo 10:00- 21:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Break & Donuts");
        restaurante.setGpsX(-17.378525379988663f);
        restaurante.setGpsY(-66.15273579955101f);
        restaurante.setDireccion("Aniceto Padilla");
        restaurante.setImagenesFirebaseArreglo(new String[]{"break & donuts1.jpg", "break & donuts2.jpg" });
        restaurante.setTelefono(4485209);
        restaurante.setHorario("Lunes a Domingo 07:30 - 21:30");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Snack Don Tino");
        restaurante.setGpsX(-17.377709450699673f);
        restaurante.setGpsY(-66.15553669631481f);
        restaurante.setDireccion("Tomas Frías");
        restaurante.setImagenesFirebaseArreglo(new String[]{"snack don tino1.jpg"});
        restaurante.setTelefono(4486703);
        restaurante.setHorario("No se tiene registrado");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Spicy & More");
        restaurante.setGpsX(-17.372262789570044f);
        restaurante.setGpsY(-66.16928368806839f);
        restaurante.setDireccion("Av. America Esquina Daniel Albornoz Nro. 655");
        restaurante.setImagenesFirebaseArreglo(new String[]{"spicy & more1.jpg", "spicy & more2.jpg" });
        restaurante.setTelefono(4402525);
        restaurante.setHorario("Lunes 18:00-  23:00 Martes a Domingo 12:00-23:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

        restaurante = new ModeloRestaurante();
        restaurante.setIdSQLite(idRestaurante++);
        restaurante.setNombre("Subs & Co");
        restaurante.setGpsX(-17.387077379981488f);
        restaurante.setGpsY(-66.15751281380653f);
        restaurante.setDireccion("Chuquisaca");
        restaurante.setImagenesFirebaseArreglo(new String[]{"subs & co1.jpg", "subs & co2.jpg" });
        restaurante.setTelefono(4224336);
        restaurante.setHorario("Lunes a Viernes 11:00-14:00 , 17:00-21:00 Sábado 11:00-21:00");
        restaurante.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        restaurante.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaRestaurantes.add(restaurante);

    }

    private void setListaLugarTuristico() {
        int idLugTur = 1;
        ModeloLugarTuristico lugarTuristico;

        //CERCADO
        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas");
        lugarTuristico.setNombre("Cristo de la Concordia");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"cristo de la concordia1.jpg", "cristo de la concordia2.jpg", "cristo de la concordia3.jpg" });
        lugarTuristico.setDescripcion("Situado sobre el cerro San Pedro, El Cristo tiene el denominativo de la “Concordia”, significando el carácter integrador geográfico, político y social que tiene la ciudad y el departamento de Cochabamba.\n" +
                "\n" +
                "Para perpetuar el recuerdo de la visita del Papa Juan Pablo II y la enseñanza de paz, entendimiento y concordia impartida en esa ocasión por el Vicario de Cristo, a iniciativa del dirigente obrero fabril Lucio López, se acordó levantar en la cumbre del cerro San Pedro, una monumental y bellísima obra escultora del Cristo de la Concordia proyectada y llevada a cabo por los afanado escultores y arquitectos cochabambinos, los hermanos Walter y Cesar Terrazas.\n" +
                "\n" +
                "El Cristo de la concordia tiene una estructura de hormigón armado con un alto de 34,20 m. y un ancho de 6,00 m., es considerado el monumento más alto de Latinoamérica. Esta gigantesca imagen de Jesús está de pie, con los brazos extendidos, representado la hospitalidad del pueblo cochabambino y la protección del Cristo sobre la ciudad de Cochabamba.\n" +
                " Alrededor del Cristo se ha instalado un magnifico mirador, del mismo se puede divisar y admirar toda la cuidad y el valle que lo rodea, obteniendo una panorámica total. Los visitantes  llegan caminando por las gradas, en vehículos por la serranía, teleférico.\n" +
                "\n" +
                "Complementando sus servicios, en los últimos años se ha dotado de un restaurante - snack y un sistema de iluminación ");
        lugarTuristico.setHorario("09:00 - 16:00");
        lugarTuristico.setDireccion("Av de la Concordia, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(4228530);
        lugarTuristico.setGpsX(-17.38435132938883f);
        lugarTuristico.setGpsY(-66.1349768936634f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Colina de San Sebastián La Coronilla ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"colinas de san sebastian la coronilla1.jpg", "colinas de san sebastian la coronilla2.jpg" });
        lugarTuristico.setDescripcion("En la zona sur de la ciudad, muy cerca de la Terminal de Buses,  se encuentra la colina de San Sebastián en cuya cuesta se halla el monumento a las Heroínas de la Coronilla, el Paseo de Los Héroes y el Monumento a las Armas, monumentos que son considerado Sitio de Interés Histórico, Cultural y Nacional. El monumento a las Heroínas, esculpida en bronce en 1922, representa simbólicamente la participación de un grupo de valerosas mujeres que resistieron a las tropas del General Goyeneche, durante la guerra de la independencia.\n" +
                "\n" +
                "El día de la Madre en Bolivia se celebra el 27 de Mayo en memoria del movimiento heroico de las mujeres cochabambinas al enfrentarse en desigual lucha ante los realistas y por ser el único movimiento libertario en Latinoamérica que demostró el valor de las mujeres para la consolidación de la soberanía de la patria.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion(" Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.4047292f);
        lugarTuristico.setGpsY(-66.1604894f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Jardín Botánico  ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"jardin botanico1.jpg","jardin botanico2.jpg","jardin botanico3.jpg"," jardin botanico4.jpg"});
        lugarTuristico.setDescripcion("El Jardín Botánico Martín Cárdenas surgió como un homenaje al más grande de los botánicos bolivianos Martín Cárdenas Hermosa, nacido en Cochabamba, gran investigador de campo, y fundador de la Facultad de Biología de la Universidad Mayor de San Simón y rector de la misma durante dos gestiones.\n" +
                "Entre los objetivos del jardín botánico se encuentran el de promover la investigación, la enseñanza y el de exhibición de la flora de la provincia de Cochabamba, así como la conservación de la diversidad florística y de sus endemismos. Fue creado en 1962.\n");
        lugarTuristico.setHorario("Lunes a Sábado 10:00 - 16:00");
        lugarTuristico.setDireccion(" Raul Rivero Torres, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.3772528f);
        lugarTuristico.setGpsY(-66.1398142f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Parque de la Familia");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"parque de la familia1.jpg", "parque de la familia2.jpg", "parque de la familia3.jpg" });
        lugarTuristico.setDescripcion("También conocido como el parque de “aguas danzantes”. Esta nueva atracción tiene un moderno sistema que combina música e iluminación con el movimiento de los chorros de agua. La combinación de estos elementos permite la proyección de imágenes en el agua y disparos del líquido " +
                "a una altura de hasta 20 metros. El espectáculo se sincroniza con música.");
        lugarTuristico.setHorario("Martes a Domingo: 15:00 a 22:00 hrs");
        lugarTuristico.setDireccion(" Av. Pedro Domingo Murillo, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(70696666);
        lugarTuristico.setGpsX(-17.38643618581872f);
        lugarTuristico.setGpsY(-66.16346597671509f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Parque de Educación Vial");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"parque de educacion vial1.jpg", "parque de educacion vial2.jpg", "parque de educacion vial3.jpg", "parque de educacion vial4.jpg" });
        lugarTuristico.setDescripcion("Área recreacional de educación vial, donde los más pequeños pueden aprender sobre la seguridad vial, a través de un pequeño circuito y recorridos divertidos, en el cual podrán identificar las diferentes señalizaciones viales. Dentro esta área se puede apreciar igualmente diferentes juegos recreacionales, paseos a través del trencito en las diferentes calles creadas " +
                "dentro el parque y diversión con cochecitos chocadores además de diferentes áreas verdes.");
        lugarTuristico.setHorario("Martes a Domingo:10:00 a 19:00 hrs ");
        lugarTuristico.setDireccion("Av.Ramón Rivero, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.381060817049427f);
        lugarTuristico.setGpsY(-66.15509748458862f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Parque Mariscal Santa Cruz");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"parque mariscal santa cruz4.jpg", "parque mariscal santa cruz5.jpg", "parque mariscal santa cruz1.jpg", "parque mariscal santa cruz2.jpg" });
        lugarTuristico.setDescripcion("El parque Mariscal Santa Cruz es una verdadera y sólida opción para quienes desean practicar deportes de diferente naturaleza. Cuenta con amplios espacios verdes, campos deportivos y áreas para juegos o simplemente lugares de convivencia. Su infraestructura deportiva consta de canchas poli funcionales, ideales para la práctica de básquet, voleibol y  fútbol  de salón. Lo que le permite una agradable estadía de los visitantes.\n" +
                "\n" +
                "Se destaca como espacio recreativo más grande de la ciudad de Cochabamba. El objetivo de su recreación fue la sensibilización ciudadana, recuperación y preservación del medio ambiente, además de la defensa de los recursos de la naturaleza como el agua, el aire y la biodiversidad.\n" +
                "\n" +
                "Es un lugar de encuentro para niños y público en general, donde se puede disfrutar en familia de la piscina, entornos naturales, diferentes juegos recreativos, botes acuáticos a pedal y tener una experiencia dentro del museo subterráneo del parque.\n");
        lugarTuristico.setHorario("Martes a Viernes 09:00 -19:00, Sábado y Domingo 10:00 – 19:30");
        lugarTuristico.setDireccion(" Hernán Morales, zona Chimba Cochabamba, Bolivia");
        lugarTuristico.setTelefono(68444499);
        lugarTuristico.setGpsX(-17.400554735575163f);
        lugarTuristico.setGpsY(-66.17417335510254f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("La Ciclo Vía");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"la ciclovia1.jpg", "la ciclovia2.jpg", "la ciclovia3.jpg" });
        lugarTuristico.setDescripcion("La ciudad cuenta con una Ciclovía principal que recorre parte de la ciudad, iniciándose en el llamado Circuito Bolivia, al sudoeste de la ciudad, en el perímetro de la Laguna Alalay, siguiendo hacia el norte por la avenida Rubén Darío, bordeando la colina San Pedro. En seguida cruza la avenida Villazón, entrando por la avenida Florentino Mendieta hasta la Plaza Tarija, de ahí sigue su largo recorrido por la avenida Rodríguez Morales, para finalizar su tramo entre la avenida Simón López y la calle Wiracocha, a unas cuadras de la Casona de Mayorazgo, al noroeste de la ciudad.\n" +
                "El recorrido completo de esta ciclovía es de aproximadamente 25 km. En su extenso tramo, el viajero puede disfrutar  y conocer gran parte de la ciudad, como las zonas de Las Cuadras, Muyurina, Tupuraya, Queru Queru, Cala Cala y Mayorazgo.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion(" Circuito Bolivia- bordea la colina San Pedro, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.402458967056607f);
        lugarTuristico.setGpsY(-66.13237917423248f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Parque Kanata ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"parque kanata1.jpg", "parque kanata2.jpg", "parque kanata3.jpg" });
        lugarTuristico.setDescripcion("Este renovado parque al sur de la ciudad posee juegos infantiles: sube y bajas, resbalines, túneles, paralelas, etc. También tiene canchas de fulbito y de basket con graderías de cemento. Para los niños está el moderno ‘Chapoteador’ que es una piscina de poca altura para que caminen descalzos y se refresquen. El parque cuenta además con parvulario, destinado a bebés " +
                "desde los 6 meses hasta los 5 años de edad con columpios, casitas diminutas para bebés gateadores, resbalines y corrales." +
                "Martes a Sábado: 10:00 a 18:00 hrs.\n");
        lugarTuristico.setHorario(" Domingos y feriados: 09:00 a 18:00 hrs.");
        lugarTuristico.setDireccion(" Av. 6 de Agosto y El Cabildo, Cochabamba,Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.41258382169276f);
        lugarTuristico.setGpsY(-66.15836441516876f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Teleférico");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"teleferico1.jpg" ,"teleferico2.jpg" ,"teleferico3.jpg" ,"teleferico4.jpg" });
        lugarTuristico.setDescripcion("El Teleférico, una obra que es orgullo de los cochabambinos, permite subir y bajar en pocos minutos la cima de San Pedro. Parte del Parque de La Autonomía hasta la cima.\n" +
                "Permite gozar una bella vista panorámica de la ciudad.");
        lugarTuristico.setHorario(" Lunes a Domingo: 9:00 a 17:00\n Miércoles: Cerrado   ");
        lugarTuristico.setDireccion(" Luis Castel Quiroga,Cochabamba, Bolivia");
        lugarTuristico.setTelefono(4446866);
        lugarTuristico.setGpsX(-17.384879904813577f);
        lugarTuristico.setGpsY(-66.13564610481262f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Plaza 14 de Septiembre");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"plaza 14 de septiembre1.jpg", "plaza 14 de septiembre2.jpg", "plaza 14 de septiembre3.jpg", "plaza 14 de septiembre4.jpg" });
        lugarTuristico.setDescripcion("Remodelada en 1938, la plaza 14 de Septiembre se cobra importancia por su diseño y pasado histórico. \n" +
                "En el nivel inferior de sus cuatro elevaciones muestra un ritmo unitario de arcos sobre las columnas (estilos Dórico y Jónico). El cuerpo superior de las edificaciones de su alrededor se remató con frontones y áticos cuyo resultado definitivo y que se mantiene hasta nuestros días es la conjugación de los estilos: Barroco y Neo-Clásico.\n" +
                "En el centro se observa un enorme enfilado de cemento conocido como “Columna de los Héroes” o “Columna de la Libertad”(estilo Corintio), que en su cúspide se yergue un cóndor con las alas extendidas. \n" +
                "De jardines incomparables y de eterna primavera, la plaza principal de Cochabamba, ofrece un ambiente de paz e inspiración.\n");
        lugarTuristico.setHorario(" Abierto");
        lugarTuristico.setDireccion(" Nataniel Aguirre y Bolivar, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.393782267762315f);
        lugarTuristico.setGpsY(-66.15696161985397f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Plazuela Colón");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"plazuela colon1.jpg", "plazuela colon2.jpg", "plazuela colon3.jpg", "plazuela colon4.jpg" });
        lugarTuristico.setDescripcion("Está llena de árboles y vegetación típica de Cochabamba y embellecida por las construcciones modernas de la zona. Tiene un vistoso puente peatonal sobre una pileta.\n" +
                "Frente a la Plaza Colón, sobre la acera este, se encuentra el paseo Independencia, que muestra la arquitectura de la época Republicana de la ciudad de Cochabamba. En este paseo, se llevan a cabo concierto, ferias, festivales y otras actividades de carácter cultural.\n" +
                "Antiguamente existía un portón entre la plaza Colón y El Prado, así como un tranvía que pasaba por un bosquecillo de árboles. Lleva el nombre de Plaza Colón en homenaje a Cristóbal Colón, descubridor de América.");
        lugarTuristico.setHorario(" Abierto");
        lugarTuristico.setDireccion(" Rocha y San Martín , Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.388064123495077f);
        lugarTuristico.setGpsY(-66.1558485031128f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Plazuela Cala Cala");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"plazuela cala cala1.jpg", "plazuela cala cala2.jpg" });
        lugarTuristico.setDescripcion("Construida el 1863 con el nombre de “Plaza del Regocijo” donde, cada noviembre, las familias más distinguidas de la ciudad se trasladaban para pasar momentos de grato esparcimiento, además de tomarse un delicioso baño. Ubicada en la campiña de Cala Cala, la “Plaza del Regocijo” Fue una de las más atractivas por sus exuberantes y paradisiacos bosques." +
                "Hoy Cala Cala Mantiene su fama y tradición. Aunque la espesura de sus bosques y sus aires vallunos de noviembre han desaparecido, concentra todavía entre sus habitantes a las familias originarias Cochabambinas.");
        lugarTuristico.setHorario(" Abierto");
        lugarTuristico.setDireccion("Adela Zamudio, Man Cesped,Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.368415279566744f);
        lugarTuristico.setGpsY(-66.16386830806732f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Plazuela Corazonistas");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"plazuela corazonistas1.jpg", "plazuela corazonistas2.jpg", "plazuela corazonistas3.jpg", "plazuela corazonistas4.jpg" });
        lugarTuristico.setDescripcion("Ubicada en la avenida Heroínas, frente a la Iglesia del Corazón de Jesús, ésta plazuela de forma alargada, lleva al medio de ella un monumento de la" + " Virgen con una gran aureola iluminada. El mismo fue construido en conmemoración al Encuentro Mariano en Cochabamba.");
        lugarTuristico.setHorario(" Abierto");
        lugarTuristico.setDireccion("Calle Hamiraya, Av Heroínas, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.393183329966508f);
        lugarTuristico.setGpsY(-66.16151332855225f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Plaza de las Banderas");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"plaza de las banderas1.jpg", "plaza de las banderas2.jpg", "plaza de las banderas3.jpg" });
        lugarTuristico.setDescripcion("La Plaza de las Banderas representa la unión de los pueblos americanos, luciendo las banderas de cada uno de ellos. También posee la fuente Carlos Montenegro que representa “La diversidad en equilibrio”, del artista boliviano Andrés Gavilano.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("A. José Ballivián (El Prado), Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.382299725566245f);
        lugarTuristico.setGpsY(-66.1598289012909f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Catedral Metropolitana");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"catedral metropolitana1.jpg", "catedral metropolitana2.jpg", "catedral metropolitana3.jpg", "catedral metropolitana4.jpg" });
        lugarTuristico.setDescripcion("Es la Iglesia Mayor. Más conocida como la  “Catedral Metropolitana” de la ciudad ce Cochabamba, fue construida en 1735 y es una de las mayores de Charcas, de las antiguas, en su interior conserva cuadros y muebles coloniales. Una galería de arcos que data de principios de siglo cubre la parte lateral de la plaza 14 de Septiembre y queda descubierta solo la portada de la cabecera, que se alza sobre la calle Esteban Arze.\n" +
                "Su portada se compone de tres cuerpos con columnas salomónicas que flaquean la puerta. Hay cartonería a los lados y decoración “mestiza”; en la coronación, la portada se alza entre dos grandes contrafuertes que parecen dispuestos a recibir un arco, que posee una sola torre donde se encuentra el reloj principal.\n");
        lugarTuristico.setHorario("Lunes a Viernes 07:45 – 20:30");
        lugarTuristico.setDireccion("Esteban Arze, Plaza Principal, 14 de Septiembre, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(4223331);
        lugarTuristico.setGpsX(-17.3943841f);
        lugarTuristico.setGpsY(-66.1566666f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Convento de Santa Clara");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"convento santa clara1.jpg", "convento santa clara2.jpg" });
        lugarTuristico.setDescripcion("La iglesia de Santa Clara y el convento que lleva el mismo nombre, fueron fundados el 25 de mayo de 1648 fecha en la que se inició la construcción de la antigua iglesia ubicada donde hoy se encuentra el Palacio de la Cultura.\n" +
                "\n" +
                "La benefactora principal fue Doña Francisca de Vargas, quien financió la construcción del convento y la iglesia con las rentas de su hacienda que se encontraba en Cliza. La construcción del actual templo se efectuó entre" +
                " 1912 y 1918, bajo la dirección del Ing. Julio Knaudt., en un sobrio y elegante estilo gótico");
        lugarTuristico.setHorario(" Lunes a Viernes 09:00 – 11:00 14:30 – 16:30 Sábado 14:30 – 16:30");
        lugarTuristico.setDireccion("Calle 25 de mayo, entre Av. Heroínas y calle Colombia, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.39151f);
        lugarTuristico.setGpsY(-66.1556675f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Iglesia de Santo Domingo");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"iglesia de santo domingo1.jpg", "iglesia de santo domingo2.jpg", "iglesia de santo domingo3.jpg" });
        lugarTuristico.setDescripcion("Este hermoso templo de piedra y barro posee más de cuatro siglos de existencia y fue erigido en el sitio original del Convento de los Frailes de la Orden de Predicadores o Dominicos el año 1612. Fue la primera sede parroquial de la entonces Villa de Oropeza, hoy ciudad de Cochabamba." +
                " Es la única construcción religiosa en la ciudad que guarda semejanza con los templos de la región andina del altiplano.");
        lugarTuristico.setHorario(" No hay horario de atención");
        lugarTuristico.setDireccion("Av. Ayacucho y Santivañez nro. 151, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(4221550);
        lugarTuristico.setGpsX(-17.394785612153562f);
        lugarTuristico.setGpsY(-66.15848779678345f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Templo del Hospicio");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"templo hospicio1.jpg", "templo hospicio2.jpg", "templo hospicio3.jpg" });
        lugarTuristico.setDescripcion("El Templo del Hospicio se encuentra ubicado en la acera sur de la plaza Colón. Su construcción se inició en 1859 y concluyó en 1875. Fue obra del arquitecto José Rosetti, está construida enteramente de adobe, la iglesia es de un estilo neoclásico, sin Cúpula y posee algunos detalles barrocos y bizantinos. Se construyó con" +
                " aportes de la población Cochabambina y de los centros mineros donde acudían los sacerdotes Franciscanos a pedir contribuciones.");
        lugarTuristico.setHorario(" No hay horario de atención");
        lugarTuristico.setDireccion("25 de Mayo y Mayor Rocha, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.389006068239883f);
        lugarTuristico.setGpsY(-66.15575194358826f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Templo de  San Francisco");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"templo de san francisco1.jpg", "templo de san francisco2.jpg", "templo de san francisco3.jpg", "templo de san francisco4.jpg" });
        lugarTuristico.setDescripcion("Este templo de gran belleza y perfectamente conservado fue edificado en 1581 con retablo en el altar mayor bañado en “Pan de Oro” conjuntamente con el púlpito; se considera que es una obra del barroco mestizo. Fue reconstruido en 1782, finalmente se modernizo en 1926 conservado algunas partes de su edificación original.\n" +
                "De las iglesias Cochabambinas de los primeros tiempos, La Merced es la única que mantuvo y conservó intacta su estructura y estilo renacentista del siglo XVI; fue construida por Sebastián montes y terminada en 1604.\n" +
                "Como todas las iglesias nave única con un arco triunfal que señalaba el presbítero. El testero plano y la cubierta de artesonado.\n" +
                "Su estructura era de piedra y en ella se abrían dos portadas sencillas; dos pirámides y el escudo de la Orden contemplaban la composición. El claustro de la merced se usó como mercado, pero ya fue demolido.\n");
        lugarTuristico.setHorario(" No hay horario de atención");
        lugarTuristico.setDireccion("25 de Mayo, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.392482007148708f);
        lugarTuristico.setGpsY(-66.15509748458862f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Museo Convento de Santa Teresa");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"museo convento de santa teresa1.jpg", "museo convento de santa teresa2.jpg", "museo convento de santa teresa3.jpg", "museo convento de santa teresa4.jpg" });
        lugarTuristico.setDescripcion("De estilo barroco este convento es una de las construcciones más antiguas que existen en Cochabamba, fue construido en 1760. La construcción inicial quedó inconclusa y se retomó cuarenta años después con una peculiar construcción dentro de otra.\n" +
                "El lugar es considerado una reliquia colonial, por sus características de construcción y riqueza en sus paredes, cuadros y ambientes, donde se observan imágenes del año 1.700 propias de los Jesuitas que llegaron al país a predicar el evangelio de Jesucristo.\n" +
                "El convento recibía a las mujeres de las familias mejor acomodadas económicamente en la ciudad que decidían dedicar sus vidas al servicio del señor, quienes en la mayoría de los casos llegaban acompañadas por algunas sirvientas que también permanecían enclaustradas por el resto de sus días.\n" +
                "El Convento Santa Teresa es en la actualidad un monasterio claustro histórico donde viven las hermanas de la orden Carmelitas Descalzas, devotas de Santa Teresa de Jesús. Representa uno de los más grandes baluartes de la Iglesia Católica, sus ambientes rústicos, la presencia de monjas que oran en silencio por la salvación del mundo y las réplicas pintadas en las paredes de manera natural, hacen del lugar todo un atractivo turístico.\n");
        lugarTuristico.setHorario("Lunes a Sábado 08:30 – 12:00 14:30 – 18:00  Domingo 09:00 – 12:00 15:00 – 17:00");
        lugarTuristico.setDireccion("C. Baptista nro. 0344 casi Ecuador, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(4221252);
        lugarTuristico.setGpsX(-17.38987633896569f);
        lugarTuristico.setGpsY(-66.15808010101318f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);



        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Laguna Alalay ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"laguna alalay1.jpg", "laguna alalay2.jpg", "laguna alalay3.jpg" });
        lugarTuristico.setDescripcion("La laguna Alalay tiene en su entorno una forma vehicular denominada “circuito Bolivia” que permite el recorrido vehicular alrededor de este atractivo. Así mismo, posee una franja peatonal para bicicletas que forma parte de la ciclovía que llega a tener un total aproximado de 15 km. de recorrido\n" +
                "También cuenta con lugares para descanso de los peatones, haciendo su visita más agradable, sobre todo durante la primavera y verano donde se puede apreciar la flora y la fauna del lugar.\n" +
                "La laguna Alalay corresponde a un sistema semi-artificial, intervenido a partir de 1935 en su profundización de cubeta, tiene condiciones de vaso regulador de crecidas del río Rocha para el control de las inundaciones provocadas en época de lluvias por dicha cuenca. \n" +
                "\n" +
                "La fauna que se encuentra en la laguna Alalay es muy variada, hasta ahora se han registrado cinco especies de peces: dos platinchos como especies nativas, la gambusia, carpa y el pejerrey como especie introducida. A su vez existen dos especies de anfibios, sapo, rana y dos especies de reptiles.\n" +
                "Las aves, sin duda alguna, constituyen uno de los recursos más atractivos que tiene esta laguna, no sólo por el valor estético, sino porque constituye el valor genético histórico que tiene este valle. En este sentido se han registrado más de 136 especies de aves, tanto de tierras altas como de tierras bajas.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Circuito Bolivia, Cochabamba Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.406584733882628f);
        lugarTuristico.setGpsY(-66.13902568817139f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Parque Nacional Tunari");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"parque nacional tunari1.jpg", "parque nacional tunari2.jpg", "parque nacional tunari3.jpg", "parque nacional tunari4.jpg" });
        lugarTuristico.setDescripcion("El Parque Nacional Tunari, fue creado y declarado Parque Nacional el 30 de marzo de 1962. El pico del Tunari se encuentra a 5.200 m.s.n.m. es el más alto de la cordillera del mismo nombre y es uno de los atractivos turísticos naturales más representativos de la ciudad de Cochabamba. \n" +
                "\n" +
                "El Parque Nacional Tunari se encuentra a 4 Km. del centro de la ciudad de Cochabamba, lugar donde se puede disfrutar de grandes momentos de recreación y esparcimiento, sobre todo para quienes acuden al encuentro con la naturaleza. El parque brinda la posibilidad de disfrutar de la naturaleza, practicar el ecoturismo, turismo de aventura y el paisajismo ya que desde sus faldas se puede apreciar esta bella ciudad. \n" +
                "\n" +
                "En la ladera sur del área existen bosques implantados de pinos y eucaliptos, esto contribuye a estabilizar las pendientes de las zonas torrenteras y también para mantener el equilibrio ambiental de los valles. A la fecha se registraron más de 30 especies de mamíferos, 163 especies de aves, 2 especies de reptiles y 2 de anfibios. Cuenta con bosques naturales y artificiales de diversas especies y principalmente algunas típicas de la cordillera. Es el hábitat de cóndores, llamas, alpacas, vizcachas y gansos andinos. \n" +
                "\n" +
                "La cordillera del Tunari bordea gran parte de los valles central y bajo de Cochabamba. Los recursos naturales que existen en la zona y su manejo adecuado forman un equilibrio en esta zona y brindan un excelente espacio para la práctica del eco turismo, que ofrece mucho por explorar, descubrir y conocer para aquellas personas dispuestas a integrarse a la naturaleza. Uno de los tantos valores biológicos del área y su aspecto más relevante, es su condición de fuente de recursos hídricos, superficiales y subterráneos que beneficia a los valles de Cochabamba.\n" +
                "\n" +
                "El Parque nacional Tunari es un área protegida de Bolivia, ubicado en el oeste del departamento de Cochabamba. Abarca las provincias de Ayopaya, Cercado, Quillacollo, Chapare y Tapacarí. Los municipios involucrados son: Morochata, Cochabamba, Quillacollo, Sipe Sipe, Tiquipaya, Vinto, Colcapirhua, Sacaba, Colomi, Villa Tunari y Tapacarí.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Cochabamba,Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.334508645845624f);
        lugarTuristico.setGpsY(-66.14096760749817f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Casa de la Cultura");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"casa de la cultura1.jpg", "casa de la cultura2.jpg" });
        lugarTuristico.setDescripcion("La Casa de la Cultura tiene por objetivo institucional promover, fomentar, revalorizar, y difundir las expresiones artísticas, " +
                "las prácticas inter-culturales y el patrimonio cultural del Municipio de Cochabamba. El Centro es escenario para diversas actividades en el ámbito de la cultura. En este lugar, aparte de poder contemplar obras de arte propias de la cultura boliviana, también se puede acceder a los diversos archivos y biblioteca, así como al teatro integrado en el centro.");
        lugarTuristico.setHorario("Lunes a Viernes 8:00 - 18:30");
        lugarTuristico.setDireccion("Av. Heroinas esq. 25 de Mayo n.399, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(4252090);
        lugarTuristico.setGpsX(-17.391932977007894f);
        lugarTuristico.setGpsY(-66.15572445094585f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Teatro Achá");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"teatro acha1.jpg", "teatro acha2.jpg", "teatro acha3.jpg", "teatro acha4.jpg", "teatro acha5.jpg" });
        lugarTuristico.setDescripcion("En1578 se levanta imponente una de las obras arquitectónicas más importantes de la época. El convento de San Agustín que posteriormente sirvió para la consolidación del famoso “Teatro de la Unión Americana” remodelado en 1864 y que con posteridad adquirió el nombre de “Teatro Achá”, en homenaje al presidente José María Achá.\n" +
                "Esta joya colonial se erige hoy como el verdadero estandarte del arte y la cultura cochabambina. Ante sus palcos y su gran salón dorado han debutado las mejores campañas de danza y teatro y han concertado extraordinarios músicos y directores de orquesta, consolidando a Cochabamba como el semillero de artistas. \n" +
                "Este majestuoso edificio que evoca en silencio el pasado, cobijando en su interior los restis del fundador de Cochabamba Gerónimo de Osorio es sin lugar a dudas, uno de los principales monumentos de la ciudad y que aun encierra en sus muros la historia de Bolivia.\n");
        lugarTuristico.setHorario("No hay horario de atención");
        lugarTuristico.setDireccion("Esteban Arze,Cochabamba,Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.39272644661129f);
        lugarTuristico.setGpsY(-66.15679498761892f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);



        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Museo Casona Santivañez");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"museo casona santivañez1.jpg", "museo casona santivañez2.jpg", "museo casona santivañez3.jpg", "museo casona santivañez4.jpg", "museo casona santivañez5.jpg", "museo casona santivañez6.jpg" });
        lugarTuristico.setDescripcion("La Casona Santivañez declarada Patrimonio Histórico de Cochabamba, constituye una reliquia arquitectónica de estilo colonial, que data del siglo XIX. La elegancia, historia y colorido, caracterizan esta infraestructura de gran valor turístico para Cochabamba.\n" +
                "Perteneció en su época a Don Juan Antonio Santivañez de Gazma y Barrao. A la muerte de los herederos, el inmueble pasó a ser propiedad de la Universidad Católica Boliviana. Posteriormente, la Honorable Municipalidad de Cochabamba, recuperó el predio sobre la base de una permuta con el fin expreso de cobijar el museo de la familia Santivañez y ser un centro de exposición artístico cultural.\n" +
                "Al recorrer sus elegantes ambientes se muestra la arquitectura propia de la época e historia traducida en la cultura y el arte plasmado en toda la casona. Pilares de arquitectura colonial, paredes tapizadas con figuras llamativas, pisos construidos detalladamente caracterizan el lugar adornado con cuadros y muebles que pertenecieron a la familia y a pesar del tiempo se mantienen intactos.\n" +
                "Posee salones de exposición como el de fotografía antigua, pinacoteca para exposiciones pictóricas itinerantes, salón principal de recepciones restaurado a su forma original. Entre sus atractivos se puede apreciar un juego de estar azul, sillas y sillones blancos (estilo Luis XV), entre otros. Además se encuentran el Salón de Exposición, el hall para eventos a nivel protocolar, el museo y otros ambientes de gran riqueza arquitectónica.\n");
        lugarTuristico.setHorario("Lunes a Viernes 09:00 - 12:00 y 14:30 - 18:30");
        lugarTuristico.setDireccion("C. Santivañez entre Av. Ayacucho y Junín, Santivañez, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(4258030);
        lugarTuristico.setGpsX(-17.3946576348589f);
        lugarTuristico.setGpsY(-66.15903496742249f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Casa Museo Martín Cárdenas");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"casa museo martin cardenas1.jpg", "casa museo martin cardenas2.jpg", "casa museo martin cardenas3.jpg", "casa museo martin cardenas4.jpg" });
        lugarTuristico.setDescripcion("La Casa Museo Internacional y Científico Martín Cárdenas Hermosa es un patrimonio consagrado al destacado científico y botánico cochabambino, que entre varios estudios e investigaciones reconocidos internacionalmente figura la variada flora boliviana. Fue declarado Monumento Nacional el 31 de Julio de 1973; en él se guardan y exponen objetos personales, diferentes investigaciones y publicaciones que se preservaron en el tiempo como reliquias históricas.\n" +
                "El centro se encuentra instalado donde residió el doctor Martín Cárdenas, quien consagró gran parte de su vida al estudio de la botánica de la región y de toda Bolivia. La Casa Museo es un lugar histórico que sirve como referente para los estudiantes de biología y botánica.\n" +
                "El Jardín Botánico de la ciudad, lleva precisamente el nombre de este destacado científico como tributo a su loable labor de años de investigación y aporte a las ciencias naturales y en especial la botánica.\n");
        lugarTuristico.setHorario("Lunes  a Viernes 09:00 – 12:00  15:00 - 18:30");
        lugarTuristico.setDireccion("Av Heroínas 266, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(4258030);
        lugarTuristico.setGpsX(-17.39272260725053f);
        lugarTuristico.setGpsY(-66.16055846214294f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Art Gallery Gildaro Antezana");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"art gallery gildaro antezana1.jpg" ,"art gallery gildaro antezana2.jpg" });
        lugarTuristico.setDescripcion("Es el salón más requerido por los artistas regionales y nacionales de " +
                "gran nivel para la difusión de sus obras de escultura, pintura, grabados, dibujo y otras manifestaciones. ");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Plaza Principal 14 de Septiembre esq. España, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.393153894938802f);
        lugarTuristico.setGpsY(-66.15671619772911f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Salon de exposición Mario Unzueta ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"salon de exposicion mario unzueta1.jpg", "salon de exposicion mario unzueta2.jpg", "salon de exposicion mario unzueta3.jpg" });
        lugarTuristico.setDescripcion("Es un salón de exposición de artes plásticas, ero su básica es la promoción cultural de las actividades de diversas instituciones y personas que se dan a conocer y muchas veces, ofrecen a la venta sus obras.Es un salón de exposición de artes plásticas, ero su básica es la promoción cultural de" +
                " las actividades de diversas instituciones y personas que se dan a conocer y muchas veces, ofrecen a la venta sus obras.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Av. Heroinas esq. 25 de Mayo Cochabamba, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.391923378564208f);
        lugarTuristico.setGpsY(-66.15568924695253f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Teatro Adela Zamudio");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"teatro adela zamudio1.jpg", "teatro adela zamudio2.jpg" });
        lugarTuristico.setDescripcion("Teatro ubicado en pleno centro de la ciudad, con buena capacidad para espectadores. Dividido en dos niveles. Es escenario para  actividades culturales como festivales nacionales e internacionales de música, presentaciones de baile, ciclos cinematográficos, obras de teatro, actuaciones estelares, " +
                "conciertos folklóricos, eventos históricos y otros. Cuenta con dos ingresos laterales y dos ingresos laterales frontales.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Av. Heroínas nro. 381,  Cochabamba, Bolivia");
        lugarTuristico.setTelefono(69448657);
        lugarTuristico.setGpsX(-17.39194577493204f);
        lugarTuristico.setGpsY(-66.1559048295021f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Museo Arqueológico ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"museo arqueologico1.jpg", "museo arqueologico2.jpg", "museo arqueologico3.jpg", "museo arqueologico4.jpg" });
        lugarTuristico.setDescripcion("El Museo Aqueológico de la Universidad Mayor de San Simón cuenta actualmente con aproximadamente 40.000 piezas arqueológicas, etnográficas y paleontológicas, clasificadas e inventariadas en su mayoría procedentes del Departamento de Cochabamba y otras regiones de Bolivia. Cuenta con un equipo de investigadores que realizan estudios, proyectos y programas en coordinación con instituciones científicas, educativas y demás dentro y fuera del país.\n" +
                "Actualmente cuenta con tres áreas de exposición permanente:\n" +
                "La Sección Arqueológica que constituye la parte fundamental del Museo. Muestra una secuencia cronológica de las distintas culturas que ocuparon Cochabamba y áreas aledañas, desde las sociedades pre-cerámicas hasta la formación de los grandes estados, como Tiwanaku e Inca.\n" +
                "La Sección Etnográfica que cuenta con una colección de pergaminos de cuero y discos de arcilla que son representaciones gráficas de oraciones y rezos católicos, los cuales fueron utilizados por la Iglesia para evangelizar a los indígenas. Además esta sección contiene, entre otros,  material etnográfico amazónico-chaqueño actual.\n" +
                "La Sección Paleontológica muestra un breve resumen de lo que constituye la historia de la vida hasta la aparición del hombre. Presenta en orden cronológico fósiles de la evolución biológica boliviana.\n" +
                "El museo ha recibido reconocimiento en el ámbito nacional e internacional, como el Cóndor de los Andes, conferido por la Nación por su destacada labor y aporte al patrimonio arqueológico y desarrollo de país.\n");
        lugarTuristico.setHorario("Lunes a Viernes 08:00-18:00");
        lugarTuristico.setDireccion("Av Oquendo Jordan esq. Nataniel Aguirre, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(4250010);
        lugarTuristico.setGpsX(-17.39537046725039f);
        lugarTuristico.setGpsY(-66.15736126899719f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CERCADO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Centro Cultural “Simon I. Patiño”");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"centro cultural simon i patiño1.jpg", "centro cultural simon i patiño2.jpg", "centro cultural simon i patiño3.jpg", "centro cultural simon i patiño5.jpg" });
        lugarTuristico.setDescripcion("Una obra arquitectónica maravillosa, un paseo por una parte de la historia de un hombre visionario a pesar de sus limitaciones, imponente gusto decorativo y ecléctico que todos deberíamos conocer. Excelente atención y conocimiento de su personal.");
        lugarTuristico.setHorario("Martes a Viernes 15:30 -  18:00, Sábado 09:30 – 11:30, Domingo11:00 – 11:30");
        lugarTuristico.setDireccion("Potosí 1450, Cochabamba, Bolivia");
        lugarTuristico.setTelefono(4243137);
        lugarTuristico.setGpsX(-17.374832870983536f);
        lugarTuristico.setGpsY(-66.15314617753029f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        //QUILLACOLLO
        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Parroquia de San Idelfonso");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"parroquia de san idelfonso1.jpg", "parroquia de san idelfonso2.jpg", "parroquia de san idelfonso3.jpg" ,"parroquia de san idelfonso4.jpg" });
        lugarTuristico.setDescripcion("Se construyó en 1908   y se consagra solemnemente  el 14 de agosto de1947.\n" +
                "El templo fue construido entre los años 1908 1947, la primer fue colocada en el mes de abril  de 1908,   cuando oficiaba el Párroco el  Fructuoso  Mencia este hermoso  templo fue edificado con pedrones trasladados desde El Calvario piedra por piedra, con arena del rio Tacata Que fueron traídos en mantas, ponchos, tablones y  Los por ancianos y niños.\n" +
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
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Santuario de la Virgen de Urkupiña");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"santuario de la virgen de urkupiña1.jpg", "santuario de la virgen de urkupiña2.jpg", "santuario de la virgen de urkupiña3.jpg" });
        lugarTuristico.setDescripcion("Cuenta la historia que a una pastorcita se le apareció la imagen de la Virgen con el Niño, cuando ella llevaba a pastorear a sus ovejas, al principio no le creía sus relatos y un día su madre la siguió y pudo observala.\n" +
                "En dicho lugar se creó el Santuario en donde todos los 14 de Agosto se realiza una peregrinación.\n" +
                "Todos hacen pedidos por su salud o por mejoras en sus vidas, en lo material dejan una pequeña replica de los solicitado, autitos de juguetes, fotocopias de billetes.\n" +
                "También a la par de la parroquia hay un santuario donde dejan velas encendidas.\n" +
                "Lunes a Domingo 8:00-12:00 14:00-17:00\n");
        lugarTuristico.setHorario("Lunes a Domingo 08:00 - 12:00 14:00-17:00");
        lugarTuristico.setDireccion("Quillacollo, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.422093917259023f);
        lugarTuristico.setGpsY(-66.28405809402466f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Señor de Piñami ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"señor de piñami1.jpg"});
        lugarTuristico.setDescripcion("Señor de Piñami, también conocido como Señor de los compadres, que celebran su fiesta el segundo jueves anterior a la fiesta del carnaval.\n" +
                "Recorrido que se realiza, resaltando la emotiva visita a la virgen de Urkupiña, ubicada en el altar mayor.\n");
        lugarTuristico.setHorario("No hay horario de atención");
        lugarTuristico.setDireccion("Quillacollo, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.38263760825179f);
        lugarTuristico.setGpsY(-66.24977946281433f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Iglesia El Paso ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"iglesia el paso1.jpg", "iglesia el paso2.jpg" });
        lugarTuristico.setDescripcion("Pueblo ubicado en las faldas del Tunari, en la zona noreste del municipio de Quillacollo. Es una de las más antiguas poblaciones coloniales del valle cochabambino.\n" +
                "Su historia se remonta a mediados del siglo XVI, cuando don Juan Polo de Ondegardo, recibió estas tierras como repartimiento. Durante el tiempo de reducción de los pueblos originarios, este Pueblo de Indios fue creado por Cédula Real el 27 de Mayo de 1571 por orden del Virrey Francisco de Toledo. A finales de la colonia, fue centro de doctrina y administración para la comarca indígena como criolla. En la época republicana se elevó a rango de cantón de Quillacollo, un 14 de septiembre de 1905. A lo largo de la historia se constituyó en un lugar de reposo y paso obligado para atravesar la cordillera hacia el trópico y viceversa.\n" +
                "Es de los primeros centros poblados en Cochabamba.\n" +
                "Se constituyó en Pueblo Real de Indios, posteriormente fue centro de doctrina y administración de indígenas y criollos. Fue lugar de paso y descanso entre la cordillera y el trópico, lo que hizo que le diera el nombre. No se encuentra muy distante a los centros urbanos.\n");
        lugarTuristico.setHorario("No hay horario de atención");
        lugarTuristico.setDireccion("Camino al Paso, Quillacollo, Bolivia");
        lugarTuristico.setTelefono(4319679);
        lugarTuristico.setGpsX(-17.337706541551242f);
        lugarTuristico.setGpsY(-66.26560315489769f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Centro Eco - Turístico el Poncho");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"centro ecoturistico el poncho1.jpg", "centro ecoturistico el poncho2.jpg", "centro ecoturistico el poncho3.jpg" });
        lugarTuristico.setDescripcion("Al pie del majestuoso Tunari, y a tan solo 20 Kilometros del centro de la ciudad de Cochabamba, se encuentra el Centro Eco-turístico El Poncho, lugar caracterizado por su arquitectura ecológica y ancestral, combinada con una hermosa diversidad de flora y fauna silvestre, además de una serie de paisajes naturales característicos del valle alto de Cochabamba.\n" +
                "El Poncho es un centro energético construido en base a posiciones estelares de antiguas constelaciones, y tiene como principal misión buscar el reencuentro y el descanso de nuestros huéspedes y amigos.\n");
        lugarTuristico.setHorario("No se tiene registrado");
        lugarTuristico.setDireccion("Quillacollo, Bolivia");
        lugarTuristico.setTelefono(4392283);
        lugarTuristico.setGpsX(-17.337232877567974f);
        lugarTuristico.setGpsY(-66.2926572561264f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Parque Eco - Turístico Pairumani ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"parque ecoturistico pairumani3.jpg", "parque ecoturistico pairumani1.jpg", "parque ecoturistico pairumani2.jpg" });
        lugarTuristico.setDescripcion("El parque Pairumani está rodeado de vertientes de límpidas aguas que descienden directamente del Tunari, un gran bosque de eucaliptos y de qewiñas. El parque tiene parrilleros, baños, agua potable y basureros a disposición. Además, en el lugar se alquilan carpas, de 2 a 25 personas, a quienes quieran pasar la noche, dentro del parque se encuentra una cascada natural y campos deportivos para la recreación.\n" +
                "En este lugar funcionaba una estación hidroeléctrica que pertenecía al Barón del Estaño.\n");
        lugarTuristico.setHorario("No se tiene registrado");
        lugarTuristico.setDireccion("Av. Pairumani, Vinto, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.344708944824216f);
        lugarTuristico.setGpsY(-66.33162438869476f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas");
        lugarTuristico.setNombre("Liriuni");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"liriuni1.jpg", "liriuni2.jpg", "liriuni3.jpg" });
        lugarTuristico.setDescripcion("Liriuni es un balneario natural, ubicado en la Cordillera Tunari, dentro el municipio de Quillacollo. Se encuentra a 20 kilómetros de la ciudad de Cochabamba.\n" +
                "De belleza impactante, el viajero es testigo de cómo aquí se confunden el campo, la brisa, el agua y los sonidos propios del lugar para dar como resultado un paisaje apasionante y cautivador.\n" +
                "El gran imán de esta hermosa zona es, definitivamente la cualidad curativa y medicinal que posee sus aguas, es por ello que muchos visitantes, más que todo adultos mayores, acuden al lugar sólo para comprobar las cualidades terapéuticas de sus aguas.\n" +
                "Estas propiedades medicinales son fruto de la alta concentración de minerales y del proceso natural que atraviesa el agua, porque los acuíferos subterráneos se infiltran en la corteza terrestre y llegan a tomar contacto con la lava y se evapora; y al subir, este vapor se vuelve a condensar, cerrando así el ciclo de formación de aguas termales o minerales.\n" +
                "La mayoría de los visitantes del turno del día llega a la piscina en busca de sanar sus afecciones y dolencias, especialmente en casos de reumatismo y dolor de huesos.\n" +
                "Es uno de los lugares más concurridos y con más demanda en Quillacollo donde la gente viene a acampar y a disfrutar de la naturaleza.\nu");
        lugarTuristico.setHorario("No hay horario de atención");
        lugarTuristico.setDireccion("Noroeste, en el Municipio de Quillacollo.Bolivia");
        lugarTuristico.setTelefono(65027337);
        lugarTuristico.setGpsX(-17.287852468753886f);
        lugarTuristico.setGpsY(-66.29197061061859f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Mansión Villa Albina");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"mansion albina patiño1.jpg", "mansion albina patiño2.jpg", "mansion albina patiño3.jpg", "mansion albina patiño4.jpg" });
        lugarTuristico.setDescripcion("Esta belleza arquitectónica ubicada en las faldas del Tunari a 2 Kms. de Vinto, fue mandada a construir por el Barón del Estaño Simón I. Patiño entre los años 1818 y1921, bajo la dirección del Arq. Francés Jardín y concluido por su hijo. Villa Albina posee toda la magia del arte europeo: patios inmensos con fuentes deslumbrantes, majestuosos jardines, esculturas y el gran mausoleo e donde descansan los restos de los propietarios.\n" +
                "\n" +
                "Actualmente en una de sus dependencias funciona el más importante laboratorio filogenético de maíz y haba; y una granja experimental.\n");
        lugarTuristico.setHorario("Lunes a Viernes 08:00 – 16:00 Sábado 09:00 – 13:00");
        lugarTuristico.setDireccion("Avenida Pairumani, Bolivia");
        lugarTuristico.setTelefono(4252090);
        lugarTuristico.setGpsX(-17.366408296168935f);
        lugarTuristico.setGpsY(-66.32076814770699f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Palacio Consistorial");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"palacio consistorial.jpg"});
        lugarTuristico.setDescripcion("El actual edificio de la Alcaldía Municipal de Quillacollo, conocido también como Palacio Consistorial, es una de las infraestructuras más antiguas, de la época republicana. Este se caracteriza por tener en la fachada, balcones trabajados en fierro forjado y una galería de arcos que lo representa. La alcaldía de Quillacollo funciona en este lugar desde el año 1857, convirtiéndose en un símbolo para los quillacolleños, del pasado y presente de su sociedad.\n" +
                "Se encuentra en pleno centro de la ciudad de Quillacollo, siendo parte del casco histórico de la misma. En este edificio funciona la Alcaldía en la parte superior y el centro de abastecimiento o mercado popular en la parte baja.\n");
        lugarTuristico.setHorario("No hay horario de atención");
        lugarTuristico.setDireccion("Av.6 de Agosto, Quillacollo, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.39724787786554f);
        lugarTuristico.setGpsY(-66.28048539161682f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);



        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas");
        lugarTuristico.setNombre("Plaza 6 de Agosto ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"plaza 6 de agosto1.jpg", "plaza 6 de agosto2.jpg", "plaza 6 de agosto3.jpg" });
        lugarTuristico.setDescripcion("La Plaza 6 de Agosto o del “Cóndor”, junto a la Plaza Principal, representan la identidad de Quillacollo y son los referentes más antiguos como espacios de confraternidad y esparcimiento. También conocida como la Plaza de la Alcaldía por estar ubicado al frente del edificio municipal, consta de especies arbóreas nativas como molles, ligustros, palmeras y jardines con especies variadas de flores.\n" +
                "Destaca el monumento al “C ó n d o r”, como fiel representación de esa emblemática ave que abunda en la Cordillera del Tunari.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Quillacollo, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.397388650890836f);
        lugarTuristico.setGpsY(-66.28071740269661f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Qollcas Incaicas de Cotapachi");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"qollcas incaicas de cotapachi1.jpg", "qollcas incaicas de cotapachi2.jpg", "qollcas incaicas de cotapachi3.jpg" });
        lugarTuristico.setDescripcion("Al sur de la ciudad de Quillacollo, sobre las colinas alrededor de la laguna de Cotapachi, se encuentra uno de los sitios arqueológicos incaicos más importantes de Bolivia.\n" +
                "Llamadas qollqas por los incas, se trata de un enorme complejo de silos emplazados en tres sectores de la colina para el acopio de maíz que se producía en la zona, siendo el más grande del imperio de los incas, formado por aproximadamente 2.500 qollcas o silos. Es muy importante este dato porque no hay que olvidar que la capital del imperio de los Incas fue El Cuzco, y ni siquiera en los alrededores de esa ciudad, donde estaba toda la estructura del poder y las grandes construcciones, existía un depósito de tales dimensiones.\n" +
                "Ocupan una superficie de aproximadamente 61 hectáreas. Fueron construidas ordenadamente en filas sumando alrededor de 2.500 unidades en filas de norte a sur. Tuvieron originalmente base circular de piedra, forma cónica de tres metros de altura y estructura tipo canasta combinada y reforzada con barro y techo de paja.\n" +
                "En la zona la corriente de aire fresco es continua, ideal para la protección del maíz.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Quillacollo, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.440160710476203f);
        lugarTuristico.setGpsY(-66.28774881362915f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Inka Rakay");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"inka rakay1.jpg", "inka rakay2.jpg" });
        lugarTuristico.setDescripcion("Fortaleza Incaica, construida entre 1460 y 1470. Fue un conjunto de 17 edificios cuadrangulares y rectangulares, y de algunos silos redondos. Son las ruinas Incaicas más accesibles para visitar desde Cochabamba. Los expertos clasifican Inka Rakay como un centro administrativo de los Incas, encargado de:\n" +
                "1) La organización del asentamiento de los quechuas y aymaras, que los incas llevaron del Altiplano, para cultivar el maíz en el valle de Cochabamba.\n" +
                "2) La creación y la administración del granero de Quillacollo.\n" +
                "3) El Manejo de los caudales de agua en el valle, supervisando el uso de estos escasos recursos.\n" +
                "Según otros investigadores Inka Rakay era una capitanía, encargada de la seguridad del granero incaico en Cotapachi, con unos 4000 silos para el almacenaje de maíz (capacidad de más de 5000 toneladas). De la Fortaleza quedaron únicamente muros y fundamentos.\n" +
                "De la Plaza de la Fortaleza Inka Rakay, se tiene una vista única sobre el Valle Bajo y el Valle Central.\n" +
                "\n" +
                "Cada 21 de junio en este lugar se realiza un evento especial por el solsticio y el año nuevo indígena\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Sipe Sipe, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.479665f);
        lugarTuristico.setGpsY(-66.385489f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Los Molinos");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"los molinos1.jpg", "los molinos2.jpg", "los molinos3.jpg" });
        lugarTuristico.setDescripcion("Es una zona ecológica, turística y productiva de diversidad climática propia de los valles, punas y subtrópicos que se mezclan con el cotidiano vivir de su gente. En esta zona además se puede encontrar una hermosa cascada natural de más de 15 mts. de altura en cuyas pozas es posible refrescarse.");
        lugarTuristico.setHorario("No se tiene registrado");
        lugarTuristico.setDireccion("Tiquipaya, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.318322f);
        lugarTuristico.setGpsY(-66.208662f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas");
        lugarTuristico.setNombre("Acuaventura");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"acuaventura1.jpg", "acuaventura2.jpg", "acuaventura3.jpg", "acuaventura4.jpg" });
        lugarTuristico.setDescripcion("Dos esculturas de elefantes, apostados a ambos lados de la entrada dan la bienvenida al visitante. Adentro, hay un par de dos grandes estructuras de toboganes para probar la adrenalina, media docena de resbalines pequeños, cuatro piscinas de distintos tamaños, dos de éstas con sistema de agua atemperada para niños, un “río” de 60 metros de largo, y un juego de camping (descenso inclinado en cuerda), donde las familias pueden pasar un fin de semana, refrescarse con todos las ofertas que puede ofrecer un balneario al aire libre, con juegos, sauna y pahuichis para servirse un plato de fin de semana.");
        lugarTuristico.setHorario("Jueves a Domingo 10:00 - 18:00");
        lugarTuristico.setDireccion("Av.Suárez Miranda, Quillacollo, Bolivia ");
        lugarTuristico.setTelefono(76415145);
        lugarTuristico.setGpsX(-17.365266558557217f);
        lugarTuristico.setGpsY(-66.27706825733185f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_QUILLACOLLO);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Chocalla");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"chocalla1.jpg", "chocalla2.jpg", "chocalla3.jpg" });
        lugarTuristico.setDescripcion(": Del extremo norte de Quillacollo, en una colina a más de 3.200 metros sobre el nivel del mar, a la distancia se observa la ciudad de Cochabamba envuelta en una nube gris que la aprisiona. El bosque tiene 40 hectáreas con más de 10 variedades de pinos, eucaliptos, kewiñas y otras que la comunidad administra.\n" +
                "Además de la oferta ecológica, Chocaya tiene otros atractivos históricos como la primera planta hidroeléctrica de Cochabamba que funcionó desde 1908. Ahora las máquinas son piezas de museo.\n" +
                "Las cascadas naturales, los ocho molinos antiguos de piedra (sin funcionar), la producción de flores, la horticultura, los senderos de donde emergen variedad de aves y mamíferos como el zorro andino, las zarigüeyas, los zorrinos, búhos, palomas, halcones y, en alguna ocasión, también planean desde las alturas los cóndores en busca de alimento.\n" +
                "\n" +
                "El centro ecológico cuenta además con áreas de camping para excursionistas, parrilleros, restaurant y áreas de parqueo. Se procede a la atención a las delegaciones una vez que éstas la solicitan a la comunidad de acuerdo al número de personas, y si requieren servicios de cocina o solamente el paseo por el bosque. Los fondos que dejan los excursionistas benefician a la comunidad.\n");
        lugarTuristico.setHorario("No se tiene registrado");
        lugarTuristico.setDireccion("Quillacollo, Bolivia");
        lugarTuristico.setTelefono(4416359);
        lugarTuristico.setGpsX(-17.349936890297155f);
        lugarTuristico.setGpsY(-66.29992872476578f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        // CAPINOTA

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CAPINOTA);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Santivañez");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"santivañez1.jpg" ,"santivañez2.jpg", "santivañez3.jpg", "santivañez4.jpg" });
        lugarTuristico.setDescripcion("Santivañez pueblo de valientes, pueblo de guerreros, histórica población, que se desarrolla sobre espacios concretos y determinados que tuvo importante papel en el proceso de consolidación del departamento de Cochabamba.\n" +
                "La quebrada de Huirquini, que se encuentra a 3 ½ km. de la plaza Santivañez, es la zona mas visitada por los turistas quienes realizan descensos, campings, además de que pueden bañarse en sus aguas al fondo del precipicio.\n" +
                "A su vez las Chullpas en Poquera son restos del periodo Incaico que se encuentran en el sector llamado Chullpamogo, que está en el camino a Poquera.\n");
        lugarTuristico.setHorario("No hay horario de atención");
        lugarTuristico.setDireccion("Provincia Capinota, sur oeste del departamento de Cochabamba,Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.574648186029f);
        lugarTuristico.setGpsY(-66.05838239192963f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CAPINOTA);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Plaza Principal(1° de Octubre)");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"plaza principal deoctubre1.jpg", "plaza principal deoctubre2.jpg", "plaza principal deoctubre13.jpg" });
        lugarTuristico.setDescripcion("Es importante destacar que en el mismo centro de Capinota (Plaza 1ro. de Octubre), existe una edificación de propiedad particular que desde hace muchísimos años ha sido destinada como alojamiento para el hospedaje de visitantes y oriundos del municipio.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Capinota, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.714733553061f);
        lugarTuristico.setGpsY(-66.26305237412453f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CAPINOTA);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Campana de Buen retiro");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"campana de buen retiro1.jpg"});
        lugarTuristico.setDescripcion("En efecto, esta memorable campana anunciaba con su repicar las principales actividades de la estación. Se encontraba a la salida de la oficina principal, donde a su vez se encontraba el telégrafo y colindaba con la oficina del  Jefe de Estación, quien salía a tocarla cuando el tren estaba saliendo de alguna de las estaciones próximas.  En ese momento se producía un bullicio y movimiento inusitado en toda la estación, tanto por parte de los pasajeros que debían abordar el tren, de gente que esperaba a algún pariente y, principalmente, de los comerciantes de verdura y de vendedoras de comida que preparaban sus platos para atender a los viajantes. Buen Retiro era la última estación del valle y la más importante antes de subir la cordillera.\n" +
                "La estación de Buen retiro funcionó desde 1915, y solo dos años después el  ferrocarril fue extendido hasta Cochabamba. La campana, por lo tanto, pudo tener un siglo anunciando el movimiento de trenes.  Como sucede con el ferrocarril en general, que es desmantelado todos los días, y su equipamiento y sus piezas son robados sistemáticamente, en la oportunidad fue robada la campana.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Capinota, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.693765773025515f);
        lugarTuristico.setGpsY(-66.26380205154419f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        //BOLIVAR
        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_BOLIVAR);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Cuevas de Totora Pampa");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"cuevas de totora pampa1.jpg", "cuevas de totora pampa2.jpg" });
        lugarTuristico.setDescripcion("Se puede observar formaciones pétreas naturales.");
        lugarTuristico.setHorario("No hay horario de atención");
        lugarTuristico.setDireccion("Bolivar, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.895939f);
        lugarTuristico.setGpsY(-66.627054f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        //MIzQUE
        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_MIZQUE);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Museo arqueológico P. Mauricio Valcanover");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"museo arqueológico pm.jpg"});
        lugarTuristico.setDescripcion("El museo arqueológico P. Mauricio Valcanover, ubicado en la alcaldía, expone piezas arqueológicas, herramientas, armas, símbolos, vestimentas, cerámicas precolombinas, fósiles y trajes típicos de Rakaypampa.");
        lugarTuristico.setHorario("No se tiene registrado");
        lugarTuristico.setDireccion("C. Bolívar, Mizque, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.942215977709438f);
        lugarTuristico.setGpsY(-65.34131661057472f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_MIZQUE);
        lugarTuristico.setTipo("Etnografía y Folkore");
        lugarTuristico.setNombre("Ruedo de Toros");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"ruedo de toros1.jpg"});
        lugarTuristico.setDescripcion("La actividad complementaria de la festividad del Señor de Burgos, es la tradicional corrida de Toros, una de las prácticas más populares post hispánicas que se acostumbra realizar durante ocho jornadas.\n" +
                "Todas las tardes, la plaza taurina es escenario de esta famosa tradición, donde se aprecia la bravura de los toros y la experiencia de los capeadores, quienes tentados por los sendos premios buscan arrebatar la platería o los billetes de diferentes cortes, previamente amarrados en aguayos o pañoletas en las espaldas o astas de este bravo animal.\n" +
                "Una misa y la posterior romería oficiada el 8 de septiembre en honor a la Virgen de Guadalupe, es el inicio a este evento tradicional, en el que participan experimentados toreros mizqueños, aiquileños y totoreños, además de los vallunos provenientes de Punata, Arani, Cliza que gustan de esta costumbre taurina.\n" +
                "Capa en mano los experimentados capeadores ingresan al ruedo en medio de aplausos de la multitud que vitorea “ole”, “ole”. Así, por ocho tardes consecutivas se desarrolla esta corrida de toros en devoción al santo patrono de Mizque, el Señor de Burgos.\n");
        lugarTuristico.setHorario("No se tiene registrado");
        lugarTuristico.setDireccion("C. Mizque, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.938786369660132f);
        lugarTuristico.setGpsY(-65.33959865570068f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_MIZQUE);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Parroquia de Mizque - San Sebastián");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"parroquia de misque.jpg"});
        lugarTuristico.setDescripcion("Destruida en el terremoto del año 1998; se terminó la reconstrucción en 2002, en ocasiones se puede subir a la torre para gozar de la vista sobre el valle.");
        lugarTuristico.setHorario("No hay horario de atención");
        lugarTuristico.setDireccion("C. Sucre, Mizque, Bolivia");
        lugarTuristico.setTelefono(4342166);
        lugarTuristico.setGpsX(-17.943787859184194f);
        lugarTuristico.setGpsY(-65.3423935174942f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_MIZQUE);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Rio Mizque");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"rio mizque1.jpg", "rio mizque2.jpg" });
        lugarTuristico.setDescripcion("Actividad casi obligatoria en la fiesta de Pascua");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Mizque, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.947339851600756f);
        lugarTuristico.setGpsY(-65.33082246780396f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_MIZQUE);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Puente de los libertadores");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"puente de los libertadores1.jpg", "puente de los libertadores2.jpg" });
        lugarTuristico.setDescripcion("Puente de los Libertadores bello puente ubicado a 25 km. De Mizque, que se alza sobre un sendero incaico y muestra una imponente cañada justo donde se ubica este puente construido durante la colonia y que sigue siendo utilizado hasta nuestros días. El puente debe su denominación porque por allí cruzaron las huestes de Simón Bolívar durante la guerra de la Independencia.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Mizque, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.835152348714885f);
        lugarTuristico.setGpsY(-65.47152042388916f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_MIZQUE);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Mizque - Cascada ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"cascada misque1.jpg", "cascada misque2.jpg" });
        lugarTuristico.setDescripcion("Con bellos paisajes ideales para pasar momentos en familia");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Mizque, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.90079085145688f);
        lugarTuristico.setGpsY(-65.46720743179321f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        // GERMAN JORDAN

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_GERMAN_JORDAN);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Plaza de Tolata");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"plaza tolata1.jpg", "plaza tolata2.jpg", "plaza tolata3.jpg", "plaza tolata4.jpg" });
        lugarTuristico.setDescripcion("Está compuesta de diseños modernos y vegetación,  muy agradable deleitarse de su belleza, suelen realizarse algunas actividades religiosas el 14 de Septiembre.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Tolata, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.53405613345308f);
        lugarTuristico.setGpsY(-65.96310093998909f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_GERMAN_JORDAN);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Parroquia San Antonio Tolata");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"parroquia san antonio de tolata1.jpg", "parroquia san antonio de tolata2.jpg" });
        lugarTuristico.setDescripcion("Según relatos del Monseñor Walter Rosales en el año 1864 durante la presidencia del General Mariano Melgarejo, en el cerro kalapaKira a 1 km hacia el norte de la actual plaza principal de Tolata, donde apareció una imagen de la Virgen María a una pastorcita.\n" +
                "Dicha imagen fue trasladada a Tarata ya que aquella época Tolata pertenecía a la parroquia de Tarata.\n" +
                "El pueblo lloraba porque el pueblo de Tarata se apodero de la imagen, fue entonces que a la misma pastorcita se le apareció la actual imagen que está en la parroquia de Tolata un 14 de septiembre, es por esta razón que su fiesta se celebra en esta fecha cada año bajo la vocación de Nuestra Señora del Patrocinio y como Patrona de Tolata.\n" +
                "Según datos antiguos, el pueblo estaba dividido en dos fajas enormes de tierra pertenecientes a dos hermanas, a medida que la población iba creciendo la autoridad eclesiástica vio la necesidad y conveniencia de atender a la población y creo una nueva parroquia denominada “San Antonio de Tolata” por el obispo de de la diócesis de Cochabamba Mons. Rafael Salinas, fue por esta razón que en el año 1868 fue nombrado como primer párroco por la anuencia del presidente Melgarejo, el joven sacerdote Máximo Rosales oriundo de Tarata,  más tarde Doctor en derecho, egresado de Medicina, Párroco y Rector.\n" +
                "Por ser el primer párroco fue fundador de Tolata, desempeño su cargo por 22 años construyendo la actual iglesia, el cementerio, construyo el puentes en los ríos con  troncos de poste, también logro que se abriera una escuela.\n");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Plaza Principal deTolata, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.53365203404495f);
        lugarTuristico.setGpsY(-65.96293330192566f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_GERMAN_JORDAN);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Templo de Nuestra Señora del Carmen");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"templo de nuestra señora del carmen1.jpg", "templo de nuestra señora del carmen2.jpg", "templo de nuestra señora del carmen3.jpg" });
        lugarTuristico.setDescripcion("El templo de Nuestra Señora del Carmen ubicada en la plaza principal 21 de Septiembre cuya torre del reloj que data de 1912 y es considerado el más antiguo de la región. En cuyos ambientes de realiza la celebración de la Virgen del Carmen.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Plaza principal de Cliza, Cliza, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.591512193456335f);
        lugarTuristico.setGpsY(-65.93400433659554f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_GERMAN_JORDAN);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas");
        lugarTuristico.setNombre("Mercado Central de Cliza");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"mercado centarl de cliza1.jpg", "mercado centarl de cliza3.jpg" });
        lugarTuristico.setDescripcion("Es el mercado central de la ciudad, donde, desde, que sale el sol no hasta mucho después que deja de brillar se vive un ambiente de fiesta en el que el regateo por el precio es su particularidad.");
        lugarTuristico.setHorario("No hay horario de atención");
        lugarTuristico.setDireccion("Cliza , Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.592556633727572f);
        lugarTuristico.setGpsY(-65.935617685318f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_GERMAN_JORDAN);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Iglesia de San Miguel");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"mercado centarl de cliza1.jpg", "mercado centarl de cliza3.jpg" });
        lugarTuristico.setDescripcion("Iglesia San Miguel, es una joya arquitectónica construida el 1788, aunque es posible que esta edificación se la haya hecho sobre otra construcción más antigua. Llama la atención su cúpula recubierta con azulejos multicolores fabricados por los artesanos de Huaiculli en Tarata, así como esta iglesia todavía queda en Toco casas que conservan su estilo condal.\n" +
                "El altar central esta tallada en madera cedro con mágicas representaciones de simbólicas divinas que le dan un toque de esplendorosa magnificencia.\n" +
                "Guarda los elementos que definen la tipología de los primeros templos altoperuano, la misma que pervive aún después de la Independencia de la República, la cual demuestra a simple vista características de real importancia en cada uno sus elementos constructivos como ser, la disposición en planta de la iglesia, la cubierta, la estructura, una cúpula con acabados imponentes, la puerta de ingreso y todos los pequeños elementos decorativos que la hacen única en su tipo.\n");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Toco, Bolivia");
        lugarTuristico.setTelefono(4574197);
        lugarTuristico.setGpsX(-17.626959701734197f);
        lugarTuristico.setGpsY(-65.92665642499924f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_GERMAN_JORDAN);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Plaza de Granos ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"plaza de granos1.jpg", "plaza de granos2.jpg" });
        lugarTuristico.setDescripcion("Uno de sus principales productos que tiene Cliza es la producción de maíz cuya comercialización es una de las principales actividades del municipio y es un elemento fundamental de la cultura. Se puede encontrar la variedad más grande de granos de maíz del departamento.\n" +
                "La chicha cliceña que se caracteriza por su particular y diferente forma de elaboración como también por su maíz, chicha amarilla y kulli se puede degustar en el centro del pueblo. \n" +
                "Se puede encontrar la variedad más grande de granos de maíz del departamento. \n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Cliza, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.59010723918821f);
        lugarTuristico.setGpsY(-65.9342309832573f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_GERMAN_JORDAN);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Arco de Bienvenida - Cliza");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"arco de bienvenida1.jpg", "arco de bienvenida2.jpg" });
        lugarTuristico.setDescripcion("EL arco de Bienvenida de Cliza se encuentra ubicada en la Av. Monseñor Walter Rosales, desde el ingreso al pueblo la historia acompaña al visitante. El arco histórico de Cliza da la bienvenida al “pueblo pujante y granero de Bolivia”.  ");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Cliza, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.587506958345383f);
        lugarTuristico.setGpsY(-65.93390241265297f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        // ARANI
        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ARANI);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Iglesia de San Bartolomé ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"iglesia de san bartolome1.jpg", "iglesia de san bartolome2.jpg", "iglesia de san bartolome3.jpg" });
        lugarTuristico.setDescripcion("Uno de los atractivos arquitectónicos religiosos más bellos que se precia de tener la población de Arani, es el templo colonial de San Bartolomé, declarado Monumento Nacional, en 1945.\n" +
                "Diseñado por el obispo agustino Fray Bernardino de Cárdenas, al más puro estilo romano y barroco plateresco, y construido por Lucas Cabral, en 1610, esta reliquia religiosa es considerada como una de las mejores obras de arte del virreinato, actualmente se encuentra entre las cinco catedrales marianas del país, consagrada a las indulgencias de peregrinos de todo el territorio Nacional.\n" +
                "Su interior está hermosamente decorado por varios retablos tallados en madera cedro. En el altar se encuentra la imagen de la Virgen “La Bella”, cuya fiesta es celebrada con pompas desde el 23 al 25 de agosto.\n");
        lugarTuristico.setHorario("No se tiene registrado");
        lugarTuristico.setDireccion("Plaza principal de Arani, Bolivia");
        lugarTuristico.setTelefono(4576124);
        lugarTuristico.setGpsX(-17.572878722852952f);
        lugarTuristico.setGpsY(-65.76882719993591f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ARANI);
        lugarTuristico.setTipo("Acontecimientos Programados");
        lugarTuristico.setNombre("Festividad de la Virgen “La Bella”");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"Festividad de la Virgen LA BELLA.jpg", "Festividad de la Virgen LA BELLA2.jpg", "Festividad de la Virgen LA BELLA3.jpg"  });
        lugarTuristico.setDescripcion("Araní es un atractivo destino para la práctica de turismo religioso, actividad que se encuentra enmarcada en una profunda tradición y ferviente vocación religiosa, resultado del proceso de evangelización y catequización que se llevó a cabo durante la conquista, además de haber funcionado como sede del Obispado de Santa Cruz de la Sierra, el siglo XVII. Entre el 23 y el 25 de agosto, Arani se viste de gala al celebrar la festividad religiosa en honor a la Virgen La Bella, declarada Patrimonio Cultural y Religioso del Departamento de Cochabamba, mediante Ley de 24 de diciembre de 2007. Esta fiesta, al contrario de otras festividades que comienzan con la entrada folklórica, inicia su evento festivo con el día del calvario, seguido de la procesión de la sagrada imagen de la Bella, para finalizar con la demostración folklórica.\n" +
                "No obstante, antes de la celebración misma de la fiesta, la imagen es venerada en principio en la ciudad de Sacaba para después retornar a Arani donde se da inicio a las tres jornadas festivas. En esta fiesta, durante el calvario también se acostumbra adquirir objetos en miniatura o propiedades para luego ser bendecidas en los rituales católicos y andinos, con similares características que las de Urkupiña.\n");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Arani, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.57885187017981f);
        lugarTuristico.setGpsY(-65.77288269996643f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ARANI);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas");
        lugarTuristico.setNombre("Plaza 24 de Noviembre");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"plaza 24 de noviembre1.jpg", "plaza 24 de noviembre2.jpg", "plaza 24 de noviembre3.jpg" });
        lugarTuristico.setDescripcion("Esta plaza se caracteriza por la cantidad de gente que participa en sus ferias en las cuales los comunarios presentan la variedad de sus productos pero fundamentalmente el tradicional pan, los distintos platos y la riquísima chicha en sus dos colores kulli y amarillo.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Arani, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.57312931262057f);
        lugarTuristico.setGpsY(-65.76800376176834f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ARANI);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Molino ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"molino1.jpg"});
        lugarTuristico.setDescripcion("Un molino antiguo, construido el siglo XIX, realizada por Schneider, Haviland.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Arani, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.57950644967455f);
        lugarTuristico.setGpsY(-65.75476437807083f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ARANI);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Puya Raymundi");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"puya raymondi1.jpg", "puya raymondi2.jpg" });
        lugarTuristico.setDescripcion("La Puya Raymundi, planta catalogada como especie en extinción, habita en la región, la cual florece cada cien años aproximadamente, siendo polinizada por el picaflor de pico curvo, especie que también se encuentra en peligro de extinción.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Vacas, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.611618844895645f);
        lugarTuristico.setGpsY(-65.53942054510117f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ARANI);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Cascadas Rosas Pampa");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"cascadas rosas pampa1.jpg"});
        lugarTuristico.setDescripcion("Cascadas Rosas Pampa ubicada en la provincia de Arani de aguas cristalinas para pasar un momento de diversión además de la vista agradable que posee este atractivo natural. ");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Vacas, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.62798987749787f);
        lugarTuristico.setGpsY(-65.53587198257446f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ARANI);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Cascada Toro Warkhu");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"cascada toro warkhu.jpg"});
        lugarTuristico.setDescripcion("Toro Warkhu, una cascada de al menos 50 m. de altura, maravilla natural que está a menos de tres horas de caminata de la plaza principal del municipio de Vacas, que desde hace un par de años impulsa el turismo para fortalecer su economía.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Vacas, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.635535799397076f);
        lugarTuristico.setGpsY(-65.51352381706238f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ARANI);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Laguna Parco Jhocha");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"parco jhocha1.jpg", "parco jhocha2.jpg" });
        lugarTuristico.setDescripcion("Uno de los atractivos de la comunidad de Vacas son sus lagunas de aguas tranquilas donde se puede hacer camping y turismo de pesca recreativa.\n" +
                "Tiene más de siete kilómetros cuadrados y es de agua dulce.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Vacas, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.554600076380435f);
        lugarTuristico.setGpsY(-65.6248140335083f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        //ARQUE
        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ARQUE);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Sicaya ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"sicaya1.jpg", "sicaya2.jpg" });
        lugarTuristico.setDescripcion("Habitada anteriormente por la cultura de los Túmulos. (a.c.), donde existen pedazos de cerámica sin pinturas.\n" +
                "A manera de conclusión, cabe señalar que la provincia, por la serie de factores antes mencionados posee una riqueza arqueológica digna de mayor atención y por lo tanto de investigaciones sistemáticas y científicas. Las pocas piezas arqueológicas conocidas hasta la fecha dan cuenta de esta riqueza, entre estas se destacan: tipos de cobre, estatuillas líticas de la cultura de los túmulos, figurillas de arcilla, hachas metálicas, punta de lanza de cuarzo.  \n");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Arque, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.805980987405523f);
        lugarTuristico.setGpsY(-66.33203744888306f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ARQUE);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Tacopaya");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"tacopaya1.jpg", "tacopaya2.jpg" });
        lugarTuristico.setDescripcion("De paisajes hermosos atravesados por ríos y montañas, de gente hospitalaria y tradicional.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Arque, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.838788220061982f);
        lugarTuristico.setGpsY(-66.53558492660522f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ARANI);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Pesarani");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"pesarani1.jpg"});
        lugarTuristico.setDescripcion("De aguas cristalinas y paisajes hermosos, cuyo afluente crece en tiempos de lluvia, además de ser aprovechabas para el riego de sus sembradíos.\n" +
                "La producción agrícola, principalmente de papa y cebada, es la base de su economía. Las mujeres se dedican a la Agroforestería y el tejido pero sólo para su uso.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Arque, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.85780f);
        lugarTuristico.setGpsY(-66.35904f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        // Esteban Arze
        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("La Angostura");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"la angostura1.jpg", "la angostura2.jpg", "la angostura3.jpg", "la angostura4.jpg" });
        lugarTuristico.setDescripcion("Se trata de una laguna artificial que originalmente fue construida como una represa para riegos y actualmente también es uno de los lugares turísticos en los que se puede disfrutar de piscina, paseos en bote por la laguna, y de la comida de la zona. A orillas de la laguna se encuentran varios restaurantes cuya especialidad es el pescado, además de las dulces y cálidas cabañas que ofrecen alojamiento y servicios para celebrar ocasiones especiales.\n" +
                "Esta represa fue materializada gracias a la cooperación del Gobierno de México, que junto a su similar de Bolivia, concretó el embalse que acumula 50.000.000 de metros cúbicos de agua. Su culminación, después de 8 años fue en 1948.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Esteban Arce, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.55435457556444f);
        lugarTuristico.setGpsY(-66.06328010559082f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Templo San Pedro ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"templo san pedro3.jpg", "templo san pedro1.jpg", "templo san pedro2.jpg" });
        lugarTuristico.setDescripcion("El templo de San Pedro, ubicado cerca de la Plaza de Armas, tiene la estructura de una sola nave en forma de cruz latina. Sus retablos están tallados en madera y cubiertos con pan de oro. En este sitio se conserva el primer libro de fábrica (1963) y también un órgano del siglo XVIII considerado reliquia patrimonial de Tarata, al lado derecho del interior del templo, se puede apreciar la espada original de Melgarejo.");
        lugarTuristico.setHorario("No hay horario de atención");
        lugarTuristico.setDireccion("Plaza principal de Tarata, Bolivia");
        lugarTuristico.setTelefono(4578424);
        lugarTuristico.setGpsX(-17.61114844973899f);
        lugarTuristico.setGpsY(-66.02326691150665f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Casa de Barrientos");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"casa de barrientos.jpg"});
        lugarTuristico.setDescripcion("Edificación en la que sobre sale la Arquitectura Colonial, la Planta baja con pilastras talladas en roca al igual que sus puertas con arquería y jampas, en la Planta Alta resalta sus balcones en hierro forjado y sus decorados afiligranados. Se observa en este lugar, que las calles antiguas se abren en brazos, de carácter clásicos y Coloniales, pintados con el Ocre Rojizo.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Tarata, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.6111586757337f);
        lugarTuristico.setGpsY(-66.022879332304f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Casa de Melgarejo ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"casa de melgarejo 1.jpg"});
        lugarTuristico.setDescripcion("Al oeste de Tarata esta la casa del Gral. Melgarejo al interior está su imagen que es venerada con flores y chica, la casa es de dos plantas construido con adobe, que conserva pese a los años transcurridos la imponencia de su estructura decorada en las arcadas de sus ventanales con el Águila Bicéfala que le da el semblante marcial al edificio. En el año 1999 restauraron la casa del Gral. Mariano Melgarejo.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Tarata, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.615913700495472f);
        lugarTuristico.setGpsY(-66.03216916322708f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Puente de Mariano Melgarejo");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"puente mariano melgarejo1.jpg", "puente mariano melgarejo2.jpg", "puente mariano melgarejo3.jpg" });
        lugarTuristico.setDescripcion("Construido originalmente durante el año 1861, para que la gente cruzara el Río Pilcomayo e ir hacia la zona del convento. Pero también se dice que este puente fue construido por los franciscanos para que la población cruzara con facilidad al convento posteriormente el ex presidente Mariano Melgarejo lo utilizo con su querido caballo Holofermes, y descansaba debajo del árbol de ceibo y se dedicaba a coplear, ya que él amaba ante todo a su caballo fue un regalo traído del extranjero.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Tarata, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.61444374654207f);
        lugarTuristico.setGpsY(-66.02488294243813f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Plaza Principal Aroma");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"plaza principal aroma1.jpg", "plaza principal aroma2.jpg", "plaza principal aroma4.jpg" });
        lugarTuristico.setDescripcion("En la plaza principal se puede observar un busto del General Mariano Melgarejo, sin embargo lo más llamativo es la Estatua del General Esteban Arze, un justo homenaje a este personaje.\n" +
                "Caminando unas calles arriba, se puede encontrar un monumento en homenaje a la mujer ");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Tarata, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.611537037130375f);
        lugarTuristico.setGpsY(-66.02358341217041f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("La torre del mirador");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"torre mirador1.jpg"});
        lugarTuristico.setDescripcion("Ubicada en la Plaza Principal de Tarata en el Edificio Municipal, construida en la Época como un lugar de observación o vigía, alberga en sus ambientes un  reloj centenario que funciona a cuerda construida en Alemania. De este edificio se observa la ciudad, los techos coloniales, las calles, barrios y pueblos circunvecinos.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Tarata, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.611493576740003f);
        lugarTuristico.setGpsY(-66.02371819317341f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Museo paleontológico y centro cultural artístico");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"museo paleontológico y centro cultural artístico1.jpg"});
        lugarTuristico.setDescripcion("En la Casa de la Cultura ubicada en la plaza Principal de la ciudad donde se encuentra el primer Museo histórico, galería fotográfica, paleontológico de cerámica, restos fósiles, entre otros.\n" +
                "Es un centro de recolección de la historia de Tarata desde sus inicios y el aporte de la población a través del tiempo, de los años, contemplando fotografías de carácter histórico que nos trasporta a épocas pasadas de la población.\n");
        lugarTuristico.setHorario("No se tiene registrado");
        lugarTuristico.setDireccion("Tarata, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.611923067197406f);
        lugarTuristico.setGpsY(-66.02368131279945f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Palacio Consistorial (Tarata)");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"palacio consistorial1.jpg"});
        lugarTuristico.setDescripcion("Edificio construido en el Siglo XVIII, en el salón principal conserva los retratos de los personajes más importantes nacidos en este suelo y que han descollado en el quehacer político, histórico, y cultural de nuestro país; también cobija los decretos con la firma del Libertador Bolívar del 29 de noviembre de 1825 y del General Mariano Melgarejo de 1866 donde declara a Tarata, el nuevo Departamento de Bolivia.");
        lugarTuristico.setHorario("No hay horario de atención");
        lugarTuristico.setDireccion("Tarata, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.611081980759312f);
        lugarTuristico.setGpsY(-66.0235907882452f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Cuartel de Melgarejo");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"cuartel de melgarejo.jpg"});
        lugarTuristico.setDescripcion("Ubicado hacia el sur de la Plaza Principal, se observa un portón magistral que merece ser conservada en un fanal de cristal, por lo que muestra pilastras talladas en roca al más puro estilo Corintio Griego, el portón en sí con el mozárabe y con decorados republicanos. En el interior se conservan balaustres prolijamente tallados en madera de Cedro, los corredores con arcos de medio punto, las gradas que dan acceso a la planta alta y son de roca talladas que aún conservan su belleza y su funcionalidad.");
        lugarTuristico.setHorario("No se tiene registrado");
        lugarTuristico.setDireccion("Tarata, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.61195885802272f);
        lugarTuristico.setGpsY(-66.02348819375038f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Templo franciscano de San José");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"templo franciscano.jpg", "templo franciscano1.jpg", "templo franciscano2.jpg" });
        lugarTuristico.setDescripcion("La arquitectura de este Templo es de estilo Neoclásico con reminiscencias Barrocas, tienen una fachada en tres cuerpos decoradas con juegos de pilastras, una espadaña y una torre donde penden campanas de gran sonoridad, todo esto jerarquizan la fachada, el interior del templo tiene un estilo románico en su construcción, los pilares tienen capiteles de estilo Corintio, la nave central es de cañón corrido, las capillas laterales cobijan imágenes de la devoción de los feligreses, entre los que sobresalen “San Severino”, venerado en todo el Valle como “El Santo de las Lluvias “. También es digno de conocer al visitar Tarata las Capillas Menores del Señor del Exaltación y el de la Sagrada Familia, que es una muestra de la gran religiosidad que caracteriza al pueblo.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Tarata, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.615341058987813f);
        lugarTuristico.setGpsY(-66.02973639965057f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Convento San José");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"convento san jose1.jpg"});
        lugarTuristico.setDescripcion("El convento franciscano  de San José, construido en 1796, al interior se conservan parte de la arquitectura original, además de pinturas y cantaros, anteriormente funcionaba una fábrica de vino, en la actualidad es un centro de recogimiento espiritual.");
        lugarTuristico.setHorario("No hay horario de atención");
        lugarTuristico.setDireccion("Plaza Esteban Arce, Tarata, Bolivia");
        lugarTuristico.setTelefono(4578302);
        lugarTuristico.setGpsX(-17.61533626566395f);
        lugarTuristico.setGpsY(-66.02973422035575f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_ESTEBAN_ARZE);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Arbol de Jarka ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"arbol jarka1.jpg", "arbol jarka2.jpg" });
        lugarTuristico.setDescripcion("Árbol “Jarka”, es un árbol con el tronco torcido ubicado en la Plazuela 27 de mayo, también denominado árbol de la juventud. En años anteriores esta zona se llamaba “loza katu” por la venta de cerámica.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Tarata, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.6144987102532f);
        lugarTuristico.setGpsY(-66.02461002767086f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        //AYOPAYA
        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_AYOPAYA);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Muralla de Sacambaya ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"muralla de sacambaya2.jpg", "muralla de sacambaya3.jpg" });
        lugarTuristico.setDescripcion("Es uno de los grandes restos arqueológicos de Ayopaya. Cuenta con 166 metros de longitud y cuatro metros de altura, y se ubica en el fondo de una impresionante cañada con leyendas de oro escondido. Durante la época de la república estas construcciones sirvieron de asilo para guerrilleros legendarios (José Miguel de Lanza y José Miguel de Chinchilla entre otros). Una hipótesis manejada sobre el origen de estas ruinas, es que este monumento podría haberse construido en un periodo preincaico y posiblemente fueron utilizados y reforzados por los incas.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Independencia, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-16.933658f);
        lugarTuristico.setGpsY(-66.985463f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_AYOPAYA);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Phajchanti");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"phajchanti.jpg"});
        lugarTuristico.setDescripcion("Phajchanti es un bosque de 284 hectáreas cercado de neblina. Esta reserva forestal de la especie pino de monte es la mayor en Bolivia.Tiene una laguna donde se cría trucha y una cascada de sorprendente paisaje de difícil acceso y desafió para turistas aventureros. Desde la cima se puede observar el pueblo de Independencia. Sus casas son construidas de materiales del lugar, y hay comidas típicas como el T’impu (cordero con arroz). Su fiesta es en carnaval. Es una comunidad de fácil acceso y grandes valores naturales y culturales.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Independencia, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.065974586856083f);
        lugarTuristico.setGpsY(-66.83584213256836f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_AYOPAYA);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Morochata");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"morochata.jpg"});
        lugarTuristico.setDescripcion("Esta caracterizado por poseer un clima teñido de pinceladas que oscilan entre tonalidades gélidas y templadas, indudablemente es el lugar propicio para la reproducción óptima de la trucha, por lo cual, el municipio tiene como principal fuente de explotación, la comercialización de esta variedad de pescado. También es conocida como la capital productora de la papa por su gran variedad. ");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Ayopaya, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.237136956837325f);
        lugarTuristico.setGpsY(-66.5337610244751f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_AYOPAYA);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Independencia");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"independencia.jpg"});
        lugarTuristico.setDescripcion("Independencia es una zona minera. Sea cual fuere la razón, los españoles y sobre todo los jesuitas se asentaron en Sacambaya y explotaron allí oro. Con la expulsión de esta orden religiosa de los dominios españoles, los jesuitas se fueron y, en su lugar han quedado solamente leyendas de tesoros escondidos.\n" +
                "En el pueblo de la Villa de la Independencia, capital del Municipio, nombrado por la participación de su gente en la Guerra de Independencia, hay todavía casas coloniales; su gente es mestiza y quechua; el Río Palca está bajando bordeando el pueblo. Su fiesta patronal es 16 de julio, cuando honran su patrona La Virgen del Carmen con misas, desfiles, concursos de deportes y motos, y una corrida de toros. Gente vienen de las ciudades y el campo para compartir en las festividades. Hay unas rutas turísticas para aprovechar alrededor del pueblo.\n ");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Ayopaya, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.084267293938602f);
        lugarTuristico.setGpsY(-66.81936599314213f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        //TIRAQUE

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_TIRAQUE);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Plaza 15 de Octubre");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"plaza 15 de octubre1.jpg"});
        lugarTuristico.setDescripcion(" La plaza 15 de Octubre, es el kilómetro cero que conduce a todas las rutas turísticas que esconde este pueblo y sus alrededores.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Tiraque, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.42659286954629f);
        lugarTuristico.setGpsY(-65.7228085398674f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_TIRAQUE);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Agua del Amor");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"agua del amor del amor1.jpg"});
        lugarTuristico.setDescripcion("Un manantial de agua ubicado al final de la calle Vandiola a unas cuadras de la plaza central, que según muchas historias esas aguas poseen virtudes afrodisiacas y curativas. La tradición oral cuenta, que una pareja al beber de estas aguas con bastante fe, encuentra una pasión inexplicable de frenesí. ");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.425052285170732f);
        lugarTuristico.setGpsY(-65.71752995252609f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_TIRAQUE);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Bosque de los Enamorados");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"bosque del amor1.jpg"});
        lugarTuristico.setDescripcion("Cuando sus impulsores decidieron forestar con eucaliptos y pinos la cadena de cerros que bordea al pueblo de Tiraque, jamás pensaron en que un día se convertiría en el “bosque del amor”. \n" +
                "La locación donde se encuentran hace que el visitante pueda disfrutar a lo máximo del hermoso paisaje de la zona.\n" +
                "Por esas cosas de la vida, gracias a la frondosidad que han adquirido estas plantas.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Tiraque, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.43619f);
        lugarTuristico.setGpsY(-65.71206f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_TIRAQUE);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Ch’ejta Rumi");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"chejta rumi.jpg", "chetjta rumi2.jpg" });
        lugarTuristico.setDescripcion("Ch’ejta Rumi también conocida como la “Piedra del Inca”, una piedra enorme partida por un rayo, por el que pasa el río Millu Mayo, además de ser un espacio en el que los turistas pueden acampar y estar junto a la naturaleza, nutrido por frondosos alisos, eucaliptos y kewiñas.\n" +
                "Allí mismo se encuentra un antiguo molino de piedra, que a pesar de varios años de su construcción, continúa funcionando.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Tiraque, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.41091f);
        lugarTuristico.setGpsY(-65.71453f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_TIRAQUE);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Totora Qhocha");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"totora qhocha1.jpg"});
        lugarTuristico.setDescripcion("Represas imponentes situadas a 4.000 metros de altura donde abunda la variedad piscícola y potencialidad inmensa");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Tiraque, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.4500105f);
        lugarTuristico.setGpsY(-65.6358305f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        /*lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_TIRAQUE);
        lugarTuristico.setTipo("Tipo turismo");
        lugarTuristico.setNombre("La Cueva del Amor");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"chejta rumi.jpg"});
        lugarTuristico.setDescripcion("La Cueva del Amor, ubicada al noreste y un kilómetro y medio de Tiraque.\n" +
                "Al pie de una enorme peña partida de nombre Ch’ejta Rumi, justo a un costado por donde discurre el río Millumayu (río salado)\n" +
                "Según los comentarios locales, la pequeña cueva existente a espaldas de la gigantesca piedra, hoy denominada como el “Refugio del amor”, era la morada del demonio y de una hermosa mujer: el primero, un ser sobrenatural y la otra, una mortal que, según la leyenda mantenían una relación amorosa.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Tiraque, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.41091f);
        lugarTuristico.setGpsY(-65.71453f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);*/

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_TIRAQUE);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Árbol milenario");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"arbol milenario 1.jpg", "arbol milenario 2.jpg" });
        lugarTuristico.setDescripcion("Tan solo caminar por sus calles, como en sus alrededores, esta región encanta por sus diferentes atractivos de carácter cultural y la belleza natural de sus paisajes interandinos. Sin pasar desapercibido un gigantesco árbol de muchos años de vida que tiene una gran frondosidad.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Tiraque, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.42138f);
        lugarTuristico.setGpsY(-65.71503f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


// PUNATA
        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_PUNATA);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Templo San Juan Bautista");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"templo san juan bautista1.jpg", "templo san juan bautista2.jpg" });
        lugarTuristico.setDescripcion("Ubicado en la ciudad de Punata capital de la provincia Punata, ubicado a 45 km de la ciudad de Cochabamba, se encuentra el templo san juan bautista. El primer templo fué edificado en 1635-1646 no duró más de un siglo y un tercio y se desplomo, se erigió el nuevo monumental y magnifico templo matriz San Juan Bautista entre los años 1770-1775 merced al esfuerzo tenaz y valiente del párroco Lic. Francisco Moscoso y Pérez, posteriormente fué declarado monumento nacional el 20 de abril de 1948, por haberse cimentado como base de la fundación de la ciudad de Punata, por su antigüedad y por las reliquias de arte colonial. responde al modelo barroco neoclásico, mestizo, en forma de cruz latina; alberga retablos tallados en madera y bañados en pan de oro.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("C.Bolívar , Punata");
        lugarTuristico.setTelefono(4577020);
        lugarTuristico.setGpsX(-17.545174907816733f);
        lugarTuristico.setGpsY(-65.83553239703178f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_PUNATA);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre(" Plaza 18 de mayo  ");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"plaza 18 de mayo.jpg"});
        lugarTuristico.setDescripcion("Se constituye en un importante legado histórico, en primera instancia fue conocido como Plaza Francisco Mariscal en homenaje al benefactor que cedió las tierras para la construcción del Templo San Juan Bautista y la base de la misma Plaza, su segundo nominativo fue Plaza 6 de agosto en homenaje al 6 de agosto de 1825 día en que se funda el territorio boliviano, y el tercer denominativo como Plaza 18 de mayo, nombre actual con el que se la conoce el cual rinde homenaje al 18 de mayo de 1838,fecha en la que el Mariscal Andrés de Santa Cruz Presidente de Bolivia y su Ministro General Dr. Andrés María Torrico punateño descansaban unos días en Punata, lugar que en ese entonces se constituía como Cantón de la Provincia Germán Jordán, quienes aprovechando su estadía tomaron la sabía decisión de crear la Villa de Punata.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Entre las calles Sucre ,Potosí");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.54518641625802f);
        lugarTuristico.setGpsY(-65.83625391125679f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_PUNATA);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Cementerio de Punata");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"cementerio de punata manuel asencio villarroel.jpg", "cementerio de punata1.jpg", "cementerio de punata2.jpg" });
        lugarTuristico.setDescripcion("Ubicado al Sur del área urbana tiene las condiciones apropiadas, no solo para población viviente, sino también para la que tiene que contar con una morada digna para un descanso eterno. El cementerio, en Punata permite pasear y observar las especies forestales cuidadosamente seleccionadas entre pinos, molles y hermosos rosales, que hacen atractivo el lugar. Además de constituirse en un legado histórico para la misma Punata ya que en ello descansan los restos de punateños célebres: Dr. Andrés María Torrico y el Dr. Manuel Ascencio Villarroel, ya que también en su interior se guarda la reliquia de un carro mortuorio de la época colonial, que servía para velar a los muertos.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Av. Gualberto Villarroel, Punata");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.56258890046693f);
        lugarTuristico.setGpsY(-65.83536475896835f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);



        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_PUNATA);
        lugarTuristico.setTipo("Acontecimientos Programados");
        lugarTuristico.setNombre("La festividad del Señor de los milagros");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"la festividad del señor de los milagros0.jpg", "la festividad del señor de los milagros1.jpg" });
        lugarTuristico.setDescripcion("Una de las características de Punata es la celebración de diferentes festividades religiosas, siendo la fiesta patronal del Señor de Milagros que recuerda la exaltación de la Cruz celebrada el último fin de semana del mes de Septiembre.\n" +
                "La Festividad del Señor de los Milagros fue reconocida como Patrimonio Cultural e Inmaterial de Bolivia. La imagen del Patrono fue trabajada, con todos los rasgos y detalles de un ser humano de un tamaño de 50 centímetros. En la región de la columna vertebral a la altura de la cintura, tiene una abertura de 3 cm, cubierta de vidrio.\n" +
                "La imagen llegó a Bolivia el año 1943 procedente de Burgos - España y a Punata gracias a la diligencia del Dr. Manuel de la Cruz Méndez para alguno de sus hijos que elija la vocación sacerdotal siendo merecedor Juan Méndez.\n ");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Punata, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.545190252404954f);
        lugarTuristico.setGpsY( -65.83560414612293f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_PUNATA);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas");
        lugarTuristico.setNombre("Plaza la Era");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"plaza la era.jpg"});
        lugarTuristico.setDescripcion("Es un sitio cultural e histórico ubicado al este del municipio aproximadamente 500 km. de la plaza principal, en ella se encuentra un palomario de la época colonial, además de ser la única que se conserva en el Municipio. Cuenta con una plaza en la que se constituye un kiosco colonial el mismo que Antiguamente se encontraba en la Plaza Principal. Es importante mencionar que la era se constituye en el lugar donde se inicia los actos festivos para la realización de la festividad del señor de milagros a fines del mes de septiembre.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("C. Antofagasta, Punata");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.539588112646303f);
        lugarTuristico.setGpsY(-65.82865923643112f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_PUNATA);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas");
        lugarTuristico.setNombre("Biblioteca Municipal - Punata");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"biblioteca municipal de punata.jpg"});
        lugarTuristico.setDescripcion("Se encuentra al este de la plaza Principal, se constituye en un infraestructura contigua al templo de San Juan Bautista ya que posee pasadizos directos al templo. En ella se encuentra 3 cuadros coloniales con las dimensiones de 2m x 1 m, con imágenes con temáticas religiosas. Además de poseer un mueso de restos de cerámica precolombina y restos arqueológica encontrados en inmediaciones de la Plaza en una excavación realizada entre los años1998 al 2001.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Plaza 28 de septiembre, Punata");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.54519153112058f);
        lugarTuristico.setGpsY(-65.83588846027851f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_PUNATA);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas");
        lugarTuristico.setNombre("Parque Defensores del Chaco");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"parques defensores del chaco.jpgg"});
        lugarTuristico.setDescripcion("Este parque se encuentra ubicado en la parte posterior del templo San Juan Bautista, en ella se encuentra el monumento en homenaje al héroe de la guerra del chaco el Mariscal Bernardinho Bilbao Rioja. Es importante mencionar que punateños y punateñas como el Mayor Desiderio Rocha, Tte de Av.Alberto Montaño, Walter Rocha, Lucio Canedo, Subte. Laureano Hinojosa quienes fueron partícipes en estos actos valerosos quienes hoy en día guardan sus restos en el Cementerio general de Punata. Este monumento fue entregado por la Sub federación de beneméritos de la Patria el año 1991.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Calle Bolívar, Punata");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.54528487733693f);
        lugarTuristico.setGpsY(-65.83497919142246f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_PUNATA);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas");
        lugarTuristico.setNombre("Plazuela de coca");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"plazuela de coca.jpg"});
        lugarTuristico.setDescripcion("Se encuentra ubicado al oeste de la plaza Principal 18 de mayo sobre la calle cobija, donde ostenta el monumento al Dr. Demetrio Canelas, considerado uno de los principales editores de la prensa escrita, periodista de profesión nació en Punata el 7 de abril de 1879 y murió el año 1964, fue director del Periódico La Patria de Oruro y posteriormente de los Tiempos en Cochabamba, fue Diputado Nacional y Ministro de Guerra y Hacienda delegado de Bolivia ante la Liga de las Naciones Unidas. Esta plaza se constituye en lugar de venta de flores de toda índole.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Calle Cobija, Punata");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.546022694368684f);
        lugarTuristico.setGpsY(-65.83790883421898f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_PUNATA);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas");
        lugarTuristico.setNombre("Plaza de San Benito");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"plaza de san benito.jpg", "plaza de san benito2.jpg" });
        lugarTuristico.setDescripcion("La flora y fauna en Villa José Quintín Mendoza San Benito es incomparable por tanto en  plena plaza principal de San Benito se erigió el monumento al durazno como señal de que este pueblo es la “Capital del Durazno de Bolivia”.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("San Benito, Punata");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.52283053086353f);
        lugarTuristico.setGpsY(-65.8943559229374f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_PUNATA);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Cerro killi killi");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"cerro killi killi.jpg"});
        lugarTuristico.setDescripcion("En la cima del cerro K’ili K’ili” se encuentra la capilla de la Virgen María de Surumi”, en Villa Rivero.\n" +
                "De acuerdo a expresiones de religiosas/os, la aparición de la imagen de la virgen María de Surumi, es el 8 de septiembre de 1940, los últimos años con autorización del arzobispado por gestiones de autoridades locales, la fecha es movible al fin de semana más próximo, para brindar mayores posibilidades de asistencia a los peregrinos visitantes.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Villa Rivero, Punata");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.611025737757387f);
        lugarTuristico.setGpsY(-65.79335868358612f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        // jose carrasco torrico

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_JOSE_CARRASCO_TORRICO);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Incallajta");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"incallajta1.jpg", "incallajta2.jpg", "incallajta3.jpg", "incallajta4.jpg" });
        lugarTuristico.setDescripcion("La fortaleza de Incallajta es un conjunto de edificaciones construídas en una superficie de aproximadamente 12 Has. Siguiendo la forma de una plataforma aluvial inclinada, delimitada por quebradas profundas, lo que le da un carácter estratégico defensivo inmejorable. Por referencia de cronistas españoles, se sabe que Incallajta fue mandada a construir entre 1463 y 1472 por Inca Tupac Yupanki habiendo sido invadida y saqueada por los pueblos del oriente (los Chiriguanos). Posteriormente, el inca Huayna Capac en 1525 la mandó a reconstruir.\n" +
                "Este monumento tiene numerosos atractivos como: “La Kallanka” edificio de 22 mts. de ancho por 78 mts. de largo constituyéndose en el edificio techado más grande de las edificaciones precolombinas en América. La cascada o Pajcha que fue un lugar de rituales.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Pocona, Carrasco");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.6050204f);
        lugarTuristico.setGpsY(-65.4159315f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_JOSE_CARRASCO_TORRICO);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Sehuencas");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"sehuencas parque nacional carrasco1.jpg", "sehuencas parque nacional carrasco2.jpg", "sehuencas parque nacional carrasco3.jpg", "sehuencas parque nacional carrasco4.jpg" });
        lugarTuristico.setDescripcion("Sehuencas es definitivamente una maravilla, rodeado de árboles, helechos, flores, animales silvestres, sol, lluvia, rocío, neblina.\n" +
                "En el trayecto al Parque, en general se aprecia un bellísimo jardín con cerros a la izquierda y la derecha en una especie de cañadón, con arboleda y vegetación natural que permanece húmeda todo el tiempo, un río y un camino angosto de tierra y de trecho en trecho se aprecian unas cascadas con aguas cristalinas que bajan de cerros empinados y que invitan a darse un mojazón, pero el agua es fría.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Pocona, Carrasco");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.50066374550242f);
        lugarTuristico.setGpsY(-65.27973175048828f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_JOSE_CARRASCO_TORRICO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Museo de Totora");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"museo totora.jpg"});
        lugarTuristico.setDescripcion("“La Casa de la Cultura”, que en su época fue una mansión lujosa y actualmente es utilizada como museo.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("Totora");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.73611785734974f);
        lugarTuristico.setGpsY(-65.19271284341812f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        //CHAPARE

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CHAPARE);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas");
        lugarTuristico.setNombre("Parque Machia");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"parque machia2.jpg", "parque machia3.jpg", "parque machia4.jpg", "parque machia1.jpg" });
        lugarTuristico.setDescripcion("Situado a dos kilómetros de Villa Tunari, en el Chapare, fue creado hace más de 10 años, es el lugar dedicado a la readaptación de animales que vivían en cautiverio. Este parque tiene una superficie de 36 hectáreas oficiales, a las que se suman otras 110 que se están utilizando con el permiso de las comunidades. Sus mentores la comunidad Inti Wara Yasi, se dedica al cuidado de varias especies que conviven en el parque, en su mayor parte monos, loros, tucanes, papagayos, halcones, tejones, ciervos, armadillos, perezosos, reptiles y felinos.");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("7, Villa Tunari, Bolivia");
        lugarTuristico.setTelefono(4136572);
        lugarTuristico.setGpsX(-16.97173538754652f);
        lugarTuristico.setGpsY(-65.41171789169312f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CHAPARE);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Puerto aurora");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"puerto aurora.jpg"});
        lugarTuristico.setDescripcion("Puerto Aurora una pequeña población se encuentra a orillas del rió Chapare, sus características rusticas de las casas de madera y techos de palma y jatata hacen que esta población sea pintoresca y como no realizar visitas en las embarcaciones de madera hechas por los mismos comunarios que sirven para trasladar de la orilla del rio a la isla que se encuentra al frente. Puerto Aurora se encuentra a 19 Km. de la población de Chimoré a 30 minutos en movilidad. El tiempo de pesca recomendado por los comunarios en Puerto aurora es el mes de agosto.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Distrito VI Puerto Aurora");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-16.847056915376648f);
        lugarTuristico.setGpsY(-65.18666982650757f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CHAPARE);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Museo cap. David Andrade López");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"museo cap. david andrade lopez 1.jpg", "museo cap. david andrade lopez 2.jpg" });
        lugarTuristico.setDescripcion("Ubicado a 1 Km. de la población de Chimoré, en los ambientes de la UMOPAR, en dicho lugar se encuentra objetos incautados por la FELCN, donde se podrá observar las diversas formas de fabricar y transportar sustancias controladas, este atractivo puede ser visitado en coordinación con la Responsable de la Unidad de Turismo.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Chapare, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-16.99459167189879f);
        lugarTuristico.setGpsY(-65.14233961701393f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CHAPARE);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Parque Nacional Isidoro Sécure");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"parque nacional isidoro sécure3.jpg", "parque nacional isidoro sécure.jpg", "parque nacional isidoro sécure0.jpg", "parque nacional isidoro sécure1.jpg", "parque nacional isidoro sécure2.jpg" });
        lugarTuristico.setDescripcion("Área protegida donde habitan diferentes comunidades indígenas ahí se desarrolla planes de manejo de peces y lagartos posee una diversidad geográfica con bosques nublados y sabanas inundadas, pantanos y lagunas, dando un espectáculo de naturaleza, cobijo de una rica flora y fauna silvestre.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Chapare, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-16.613821843398224f);
        lugarTuristico.setGpsY(-65.76622009277344f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CHAPARE);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Incachaca");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"incachaca1.5.jpg", "incachaca1.jpg", "incachaca2.jpg" });
        lugarTuristico.setDescripcion("La ruta hacia Incachaca se encuentra sobre la antigua carretera hacia Santa Cruz. Es una zona tropical en la que se pueden observar hermosas caídas de aguas cristalinas y riachuelos que labraron la piedra, además de una exuberante vegetación y lugares adecuados para la pesca deportiva.\n" +
                "Existe un sendero natural en medio de la naturaleza donde se pone a prueba la resistencia física.\n" +
                "Sus atractivos son: El velo de novia, la ventana del diablo, la casa de las máquinas y el puente colgante.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Colomi, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.237111339419496f);
        lugarTuristico.setGpsY(-65.81713378429413f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CHAPARE);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Laguna Corani");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"laguna corani.jpg", "laguna corani0.jpg" });
        lugarTuristico.setDescripcion("Laguna artificial de mágico encanto  rodeada de bosques de pinos y ríos, donde la brisa del altiplano se transforma en un encuentro placentero con lo telúrico y enigmático de un lugar de pesca y recreación tradicional.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Colomi, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.272670015135095f);
        lugarTuristico.setGpsY(-65.90230464935303f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);


        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CHAPARE);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Laguna San Isidro");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"laguna san isidro.jpg", "laguna san isidro1.jpg" });
        lugarTuristico.setDescripcion("La laguna de san isidro es principalmente atractivo de la comunidad, de aguas cristalinas en su interior conviven especies de peces como el pejerrey dorado. Este espejo de agua natural posee una diversidad de ofertas en cuanto a actividades re-creativas, que van desde la simple pesca deportiva, paseos en botes, natación.\n" +
                "Durante el mes de abril se realiza el Festival turístico gastronómico y la competencia de motociclismo, donde participan de esta actividad autoridades municipales y departamentales.\n" +
                "Galeón Morgan es la representación artística del barco pirata ingles el cual navegaba por el atlántico, robando riquezas del nuevo mundo a los barcos mercaderes españoles, galeón es un mirador turístico y centro de atención turística, construido de madera y hierro.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Sacaba, Chapare");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-17.408908635978058f);
        lugarTuristico.setGpsY(-65.89654862880707f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CHAPARE);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Santuario de la Virgen de los Ángeles (Iglesia de Melga)");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"santuario de la virgen de los ángeles.jpg", "santuario de la virgen de los ángeles2.jpg", "santuario de la virgen de los ángeles3.jpg" });
        lugarTuristico.setDescripcion("El santuario de melga se encuentra al norte de la carretera a 15 km. Aproximadamente de Sacaba, la iglesia tiene un estilo arquitectónico ecléctico con detalles clásicos de la arquitectura religiosa vanguardista.\n" +
                "Es una torre de piedra y cubierta con teja industrial, esta obra espectacular se caracteriza por su monumentalidad y por amplios jardines exteriores, muchas personas llegan al lugar, algunos por conocer la iglesia debido a que es una obra de arte que llama la atención y otros por sanidad. Los días 18, 19, 20 de octubre de cada año la iglesia es visitada con el fin de celebrar la fiesta de la patrona Virgen de los Ángeles.\n");
        lugarTuristico.setHorario("No se tiene registrado.");
        lugarTuristico.setDireccion("km. 35 carretera nueva a Santa Cruz, Chapare");
        lugarTuristico.setTelefono(76474112);
        lugarTuristico.setGpsX(-17.424330611606145f);
        lugarTuristico.setGpsY(-65.91747790575027f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        //CAMPERO

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CAMPERO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Museo del Charango");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"museo del charango0.jpg", "museo del charango1.jpg", "museo del charango2.jpg", "museo del charango3.jpg", "museo del charango4.jpg" });
        lugarTuristico.setDescripcion("Museo del Charango, donde hay piezas realmente únicas, premiadas en diferentes festivales, con un sinfín de detalles tallados, como los cuernos de un escarabajo, el mapa de Bolivia o algunas escenas costumbristas. El museo cuenta la trayectoria del Instrumento de Cuerda más rico en Artesanía Boliviana, es pues así que Aiquile muestra a Bolivia y al mundo el por qué se le denomina \"Cuna De Charangos\".\n" +
                "Aiquile fue declarado Capital Nacional del Charango y la Feria y Festival del Charango declarada Patrimonio Oral e Intangible de Bolivia, se efectúa del 2 al 4 de noviembre.\n");
        lugarTuristico.setHorario("Lunes a Viernes de 08:30 – 17:00");
        lugarTuristico.setDireccion("C. Campero Esquina Héroes Del Chaco, Aiquile, Bolivia");
        lugarTuristico.setTelefono(4343537);
        lugarTuristico.setGpsX(-18.201381603182707f);
        lugarTuristico.setGpsY(-65.17853736877441f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CAMPERO);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Omereque / Paraba Frente Roja");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"omereque paraba roja1.jpg", "omereque paraba roja2.jpg", "omereque paraba roja3.jpg" });
        lugarTuristico.setDescripcion("Es un municipio ubicado al sur de Cochabamba. En sus valles florecieron importantes culturas precolombinas. Fue una de las zonas más pobladas y un importante yacimiento arqueológico. Es uno de los destinos turísticos poco conocido, pero de gran valor.\n" +
                "Omereque posee valles fértiles que son atravesados por el río Mizque, que nace cerca de la población que le da nombre y recorre la provincia Campero, para luego seguir su curso por los valles cruceños y finalmente unirse al Río Grande.\n" +
                "Miles de años atrás, los habitantes de los valles de Omereque, al sur de Cochabamba, dibujaron sobre los farallones que dan al río Mizque, unos lagartos o lagartijas de gran tamaño, figuras humanas y representaciones del sol y de la luna. Esas figuras, que fueron pintadas con ocres de color rojo carmín, rojo oscuro y naranja y grasa animal, han sobrevivido como mudos testimonios de los primeros habitantes humanos de esa región.\n" +
                "Al sureste de Omereque, en la comunidad de San Carlos, se encuentra la Fortaleza de Tunas Mok’o, que fuera un sitio fortificado con murallas extensas y altas construidas en piedra que bordean toda la colina. En la cima hay restos de construcciones y cimientos de habitaciones. Cerca de allí se encuentra a orillas del río Mizque uno de los lugares claves para lo observación de las parabas frente roja (Ara rubrogenys), que son endémicas de la región de los valles altos del departamento de Cochabamba y que están en peligro de extinción.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Omereque, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-18.13932668561848f);
        lugarTuristico.setGpsY(-64.87937450408936f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CAMPERO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Monumento al Charango");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"monumento a charango1.jpg", "monumento al charango.jpg" });
        lugarTuristico.setDescripcion("Está en el parque del Kjochi. Imponente infraestructura de cemento en forma de charango. Es uno de los monumentos más representativos de Aiquile, en cuyo lugar también se realizan representaciones folklóricas.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Aiquile, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-18.20364421551036f);
        lugarTuristico.setGpsY(-65.17837107181549f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CAMPERO);
        lugarTuristico.setTipo("Sitios Naturales");
        lugarTuristico.setNombre("Colina San Sebastián “El cerrito”");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"colina de san sebatian1.jpg", "colina de sansebastian1.jpg", "colina de sansebastian2.jpg" });
        lugarTuristico.setDescripcion("La colina de San Sebastián, considerado un lugar histórico: según los aiquileños, aquí es donde Patricio Lara, héroe de la batalla de la Tenería, se parapetó para hacer frente a la arremetida de los españoles, y ahí mismo fue ahorcado.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Aiquile, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-18.200601912398366f);
        lugarTuristico.setGpsY(-65.1817037165165f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CAMPERO);
        lugarTuristico.setTipo("Patrimonio Urbano Arquitectónico, Artístico, Museos y Manifestaciones Culturales");
        lugarTuristico.setNombre("Catedral San Pedro");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"catedral de san pedro1.jpg", "catedral de san pedro2.jpg", "catedral de san pedro3.jpg", "catedral de san pedro4.jpg", "catedral de san pedro5.jpg" });
        lugarTuristico.setDescripcion("Es una obra maestra, sustituye a la anterior catedral derrumbada por el terremoto de 1998 que asoló la ciudad. Es preciosa, moderna y amplia. \n" +
                "Merece la pena visitar, las campanas del patio que  pertenecieron a la anterior iglesia. Está custodiada por la virgen de Candelaria patrona de Aiquile. Sus visitas de la plaza son inmejorables, lugar de reunión de los aiquileños.\n");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("C. Parroquial, entre Bolívar y Plaza 20 de diciembre, Aiquile");
        lugarTuristico.setTelefono(4343182);
        lugarTuristico.setGpsX(-18.19939414919811f);
        lugarTuristico.setGpsY(-65.17867416143417f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);

        lugarTuristico = new ModeloLugarTuristico();
        lugarTuristico.setIdSQLite(idLugTur++);
        lugarTuristico.setProvincia(Constants.FIREBASE_PROVINCIA_CAMPERO);
        lugarTuristico.setTipo("Realizaciones Técnicas y Científicas ");
        lugarTuristico.setNombre("Plaza Zenón Delgadillo");
        lugarTuristico.setImagenesFirebaseArreglo(new String[]{"plaza zenon delgadillo1.jpg", "plaza zenon delgadillo2.jpg" });
        lugarTuristico.setDescripcion("La plaza Zenón Delgadillo tiene una enorme tradición histórica, cultural, recreacional, medioambiental y turística y se encuentra ubicada a los pies de la colina de San Sebastián. Posee una escultura más Mide 15 metros, pesa 3 toneladas y está hecho de hierro viene a ser el charango más grande del mundo.");
        lugarTuristico.setHorario("Abierto");
        lugarTuristico.setDireccion("Aiquile, Bolivia");
        lugarTuristico.setTelefono(0);
        lugarTuristico.setGpsX(-18.2005764322485f);
        lugarTuristico.setGpsY(-65.18137112259865f);
        lugarTuristico.setEstado(Constants.ESTADO_LUGAR_VISIBLE);
        listaLugares.add(lugarTuristico);
    }

    private  void setListaUsuarios(){
        int idUser = 1;
        ModeloUsuario modeloUsuario;

        idUser++;
        modeloUsuario=new ModeloUsuario();
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
        modeloUsuario=new ModeloUsuario();
        modeloUsuario.setIdSqlite(idUser);
        modeloUsuario.setNombre("Juan");
        modeloUsuario.setApellido("Perez");
        modeloUsuario.setEmail("juan@gmail.com");
        modeloUsuario.setIdFirebase(modeloUsuario.getEmail());
        modeloUsuario.setTelefono(String.valueOf(60761941));
        modeloUsuario.setContrasenia("firebase123");
        modeloUsuario.setRol(Constants.USUARIO_ROL_NORMAL);
        modeloUsuario.setEstado(Constants.ESTADO_USUARIO_ACTIVO);
        listaUsuarios.add(modeloUsuario);
    }
}
