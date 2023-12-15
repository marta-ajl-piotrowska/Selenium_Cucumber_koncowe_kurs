# Końcowe zadania warsztatowe

## Selenium WebDriver + Cucumber

To repozytorium zawiera testy, napisane przeze mnie, jako zaliczeniowe zadania końcowe na kursie testera automatyzującego w CodersLab.

### Zadanie 1 

Utwórz użytkownika manualnie na stronie https://mystore-testlab.coderslab.pl (możesz wykorzystać tymczasowego maila do utworzenia użytkownika: https://10minutemail.com/).


Napisz skrypt, który:

1. będzie logować się na tego stworzonego użytkownika,
2. wejdzie klikając w kafelek Addresses po zalogowaniu (adres, na którym powinniśmy się znaleźć to: https://mystore-testlab.coderslab.pl/index.php?controller=addresses ),
3. kliknie w + Create new address,
4. wypełni formularz New address - dane powinny być pobierane z tabeli Examples w Gherkinie (alias, address, city, zip/postal code, country, phone),
5. sprawdzi czy dane w dodanym adresie są poprawne.

Dodatkowe kroki dla chętnych:

6. usunie powyższy adres klikając w "delete",
7. sprawdzi czy adres został usunięty.

### Zadanie 2

Napisz skrypt, który:

1. zaloguje się na tego samego użytkownika z zadania 1,
2. wybierze do zakupu Hummingbird Printed Sweater (opcja dodatkowa: sprawdzi czy rabat na niego wynosi 20%),
3. wybierze rozmiar M (opcja dodatkowa: zrób tak żeby można było sparametryzować rozmiar i wybrać S, M, L, XL),
4. wybierze 5 sztuk według parametru podanego w teście (opcja dodatkowa: zrób tak żeby można było sparametryzować liczbę sztuk),
5. doda produkt do koszyka,
6. przejdzie do opcji - checkout,
7. potwierdzi address (możesz go dodać wcześniej ręcznie),
8. wybierze metodę odbioru - "self pick up",
9. wybierze opcję płatności - Pay by Check,
10. kliknie na "place order",
11. zrobi screenshot z potwierdzeniem zamówienia i kwotą.
12. wejdzie w historię zamówień i detale (najpierw kliknij w użytkownika zalogowanego, później kafelek),
13. sprawdzi czy zamówienie znajduje się na liście ze statusem "Awaiting check payment" i kwotą taką samą jak na zamówieniu dwa kroki wcześniej.

