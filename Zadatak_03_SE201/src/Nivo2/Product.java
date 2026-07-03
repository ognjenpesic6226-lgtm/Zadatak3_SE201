package Nivo2;

//2.Zadatak: Izgradite mikroservis Product Service koji omogućava upravljanje proizvodima u prodavnici.
//        Servis treba da podrži sledeće funkcionalnosti:
//        1. Dodavanje proizvoda (POST zahtev)
//        2. Preuzimanje informacija o proizvodima (GET zahtev)
//        3. Ažuriranje proizvoda (PUT zahtev) Uputstvo: • Koristite ugrađeni HTTP server u Javi za implementaciju servera.
//        • Svaki proizvod treba da ima jedinstveni ID, naziv, cenu i opis. • Implementirajte API koji omogućava interakciju sa listom proizvoda u memoriji.
//2.Zadatak: Kreirajte Java program koji traži od korisnika da unese broj telefona u formatu +country_code XXX-XXX-XXXX i proverava
//        da li je uneti broj u ispravnom formatu (npr. +1 123-456-7890). Uputstvo: • Koristite Scanner za unos broja telefona.
//        • Koristite regex da proverite da li broj ima oblik +country_code XXX-XXX-XXXX, gde country_code može imati 1 do 3 cifre.
//        • Ako broj nije validan, prikažite poruku o grešci.
//3. Zadatak: Automatizujte testiranje procesa registracije. Test treba da proveri:
//        1. Da li korisnik može da se registruje sa validnim podacima.
//        2. Da li se prikazuje odgovarajuća greška pri pokušaju registracije sa nevalidnim podacima
//        (npr. nevalidna email adresa ili lozinka koja nije dovoljno dugačka). 4. Zadatak: 1. Napravite izmene u lokalnom repozitorijumu koje još niste spremni da komitujete.
//        2. Upotrebite git stash kako biste sačuvali te promene.
//        3. Prebacite se na drugu granu i napravite izmene na toj grani.
//4. Kada se vratite na originalnu granu, primenite promene sa stasha koristeći git stash apply. Dokumentujte korake i dostavite link ka repozitorijumu (public).
//

public class Product {

    private int id;
    private String name;
    private double price;
    private String description;

    public Product(int id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}