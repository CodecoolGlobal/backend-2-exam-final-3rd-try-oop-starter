# Ingatlan ügynök
Ebben a feladatban egy ingatlan ügynököt és a hozzá tartozó ingatlanokat kell modelezned.

Minden osztályodat a s `hu.nive.ujratervezes.realestate` packagben kell létrehozni.

A `Main` osztály `main` metódusában próbálhatod ki a kódodat, illetve használd
az előre megírt teszteseteket az algoritmusod kipróbálására!

## Feladatleírás
Implementáld az alábbi leírás szerinti programot:

### hu.nive.ujratervezes.Room
tulajdonsága:
- `int sizeInSquareMeter` méret négyzetméterben
    - Konstruktor segítségével beállítható kell legyen. 
    - Tartozik hozzá egy `int getSizeInSquareMeter()` getter.
    
### hu.nive.ujratervezes.BathRoom
Az összes `BathRoom` egyben `Room` is.
ezen felül tulajdonsága:
- `boolean hasSmartMirror`
    - Konstruktor segítségével beállítható kell legyen. 
    - Tartozik hozzá egy `hasSmartMirror()` getter.
    
### hu.nive.ujratervezes.BedRoom
Az összes `BedRoom` egyben `Room` is.
ezen felül tulajdonsága:
- `boolean hasBigTV`
    - Konstruktor segítségével beállítható kell legyen. 
    - Tartozik hozzá egy `boolean hasBigTV()` getter.
    
### hu.nive.ujratervezes.Kitchen
Az összes `Kitchen` egyben `Room` is.
ezen felül tulajdonsága:
- `boolean hasSmartFridge`
    - Konstruktor segítségével beállítható kell legyen. 
    - Tartozik hozzá egy `boolean hasSmartFridge()` getter.
    
### hu.nive.ujratervezes.RealEstate
tulajdonságai: 
- `int id` az ingatlan id-ja.
    - Konstruktor segítségével beállítható kell legyen. 
    - Tartozik hozzá egy `int getId()` getter.
- `int pricePerSquareMeter` négyzetméter ár.
    - Konstruktor segítségével beállítható kell legyen. 
    - Tartozik hozzá egy `getPricePerSquareMeter()` getter.
- `List<Room> rooms` szobák listája.
    - Konstruktor segítségével beállítható kell legyen. 
    - Tartozik hozzá egy `List<Room> getRooms()` getter.

Ezen felül metodusai:
- `int calculateSizeInSquareMeter()` vissza adja az ingatlan méretét, ami az ingatlan szobáinak méretének összege.
- `int calculatePrice()` vissza adja az ingatlan árát, ami az ingatlan mérete szorozva a négyzetméterárral. 

### hu.nive.ujratervezes.RealEstateAgent
tulajdonságai: 
- `List<RealEstate> realEstates` az ingatla ügynökhöz tartozo ingatlanok listája.
    - Konstruktor segítségével beállítható kell legyen. 
    - Tartozik hozzá egy `List<RealEstate> getRealEstates()` getter.
    
metodusai:
- `void addRealEstate(RealEstate realEstate)` az ingatlan ügynökhöz adja a paraméterben kapott ingatlant.
- `removeRealEstateById(int id)` id alapján eltávolítja az ingatlant az ingatlan ügynökhöz tartozó ingatlanokból.
- `RealEstate findLargestRealEstate()` vissza adja  az ingatlan ügynökhöz tartozó ingatlanok közül a legnagyobbat.
- `RealEstate findCheapestBySquareMeterRealEstate()` vissza adja  az ingatlan ügynökhöz tartozó ingatlanok közül a legkisebb négyzetméter árral rendelkezőt.