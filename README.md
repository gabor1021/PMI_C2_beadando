# PMI_C2_beadando
beadando

A program választott témája a gazdaság. Egy üzletnek a rendeléseit bonyolítja le (középkori fegyvereket árul az üzlet). A rendelhető dolgok listájának forrása:
https://darksouls.fandom.com/wiki/Weapons_(Dark_Souls)

A bemenő adatok a data.xml nevű fájlban vannak rögzítve. Itt minden <n> és </n> közötti rész egy fegyvert tartalmaz, amelyeknek 5 tulajdonsága van:
        <name> a fegyver neve
        <type> fegyvertípus
        <cost> ár
        <time> elkészítési idő munkanapban mérve
        <upgradePath> fejlesztési alapanyag - csak a "Normal" fejlesztésű fegyverek készíthetők el, a "Twinkling" és a "Demon fejlesztésűek egyediek, ezért jóval
                      drágábbak, és nem készíthetők el
A beolvasást az XMLin osztály végzi el. Ez egyetlen metódust tartalmaz, ami egy ArrayList-ben visszaadja a fájl tartalmát "Weapons" objektumokba rendezve. A név és a típus
stringként, az ár és az elkészítési idő integerként, az upgradePath pedig az UpgradePath nevű Enum értékeként kerül beolvasásra.
          
A Weapons osztály objektumaiként vannak az adatok beolvasva, ezért a tagváltozók megegyeznek az XML tag-ekkel. Ez az osztály tartalmaz egy konstruktort, gettereket és settereket,
és 2 metódust. A getAllWeaponNames metódus visszaadja az összes fegyvernevet, a getAllWeaponTypes visszaadja az összes fegyvertípust. A kiíratáshoz @Override a toString metódusra.
          
Az Orders osztály a Weapons objektumait használja, ebben vannak a rendeléshez használt metódusok. A newWeapon metódussal új rendelést lehet hozzáadni a rendelések listájához,
a modifyWeapon egy rendelt fegyvert kicserél egy másik választott fegyverre, a deleteWeapon töröl egy rendelést, a sumOfOrders pedig stringként visszaadja kiíratáshoz az összes
költséget, a rendelések számát és az összes elkészítési időt.
          
A rendeléseket az XMLout osztály XMLOut metódusa rögzíti XML fájlba, ez minden lefutáskor felülírásra kerül. Ennek a data2 nevű XML-nek megegyezik a formátuma a data-éval,
a tagek ugyanazok.
          
A program menüszerűen fut le, a main_classban található a main. Lefutáskor bekér a felhasználótól egy számot 1-7-ig vagy a "menu" szót, a menü újbóli kiíratásához. Ha nem ezek
valamelyikét adja meg, akkor hibaüzenet után újra bekéri a számot. "1" lenyomásakor kiírja a program az összes rendelhető fegyver nevét, ezeket megadva lehet törölni, hozzáadni,
stb. a rendelésekhez. "2" lenyomásakor minden fegyvertípust kiír. "3" lenyomásakor lefut a newWeapon, "4" - deleteWeapon, "5" - modifyWeapon, "6" - összegzés. A "7" lenyomásával kilép
a while ciklusból, kiírja a rendelt fegyverek listájának tartalmát XML-be, és leáll a program.
