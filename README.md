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
